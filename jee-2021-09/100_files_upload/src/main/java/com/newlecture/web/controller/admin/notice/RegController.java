package com.newlecture.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@MultipartConfig(
//		location="/tmp",
		fileSizeThreshold=1024*1024, // ÷�������� 1m�� ���� ��� �޸𸮰� �ƴ� ��ũ�� ����
		maxFileSize=1024*1024*5, // ���� �ϳ��� ũ�Ⱑ 5m
		maxRequestSize=1024*1024*5*5 // ������ �������� ���, ��ü ���� �뷮�� 25m�� ����
)
@WebServlet("/admin/board/notice/reg")
// get, post ��û ó��
public class RegController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����ϱ� ���� ������
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		boolean pub = isOpen != null ? true : false;
		
		Collection<Part> fileParts = request.getParts(); // �÷������� ����
		StringBuilder builder = new StringBuilder();
		
		for (Part p : fileParts) {
			if ((!p.getName().equals("file"))) continue; // name=file�� �͸� ����
			
			Part filePart = p;
			InputStream fis = filePart.getInputStream();
			
			String realPath = request.getServletContext().getRealPath("/upload");
			System.out.println(realPath);
			
			String fileName = filePart.getSubmittedFileName();
			builder.append(fileName);
			builder.append(",");
			String filePath = realPath + File.separator + fileName; 
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}
			fos.close();
			fis.close();
		}
		builder.delete(builder.length() - 1, builder.length()); // builder.delete(3,4) => "abcdef" -> "abcef"
		
		Notice notice = new Notice();
		notice.setId((int)Math.random()*100+1);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setWriter("newlec");
		notice.setFiles(builder.toString());
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		
		response.sendRedirect("list");
	}
	
}
