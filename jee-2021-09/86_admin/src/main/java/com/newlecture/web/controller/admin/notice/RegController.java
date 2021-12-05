package com.newlecture.web.controller.admin.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

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
		
		// Part�� ���̳ʸ� �������� �Ѱ� ��
		Part filePart = request.getPart("file"); // name=file�� part�� ����
		InputStream fis = filePart.getInputStream(); // ����ڰ� ������ ������ ��� ����
		// ���� ���� ���� : ��δ� ���� ��θ� ����
		// ���� ��θ� ���� ��η� �ٲٴ� ���
		String realPath = request.getServletContext().getRealPath("/upload"); // web ��Ʈ�� ���� ����θ� �Ѱ��ָ�, �ý��� �� ���� ������θ� ã��
		System.out.println(realPath);
		
//		int b = fis.read(); // System.in ó�� ������ �о� �Է¹���. ����Ʈ ������ 1����Ʈ �� ����.
		// ��ȯ Ÿ���� �������� ���� : �� �о���̰� �� �̻� �о���� ���� ���� ��, �� �о��ٴ� �� ���������� ����(-1).
		// ���� ���޵Ǵ� �� byte�� ������ �����͸� ������ �Ѵٸ� byte�� �ᵵ ��
		
		String fileName = filePart.getSubmittedFileName();
		String filePath = realPath + File.separator + fileName; // ���� ���� ���
		// File.pathSeparator : ������ "/"
		
		// InputStream : �Է��ϱ� ���� ����
		// OutputStream : ����ϱ� ���� ����
		// �� ��θ� �̿��� ��Ʈ���� ���� ����
		FileOutputStream fos = new FileOutputStream(filePath);
		
		// 1����Ʈ��
//		int b;
//		// int b�� 1����Ʈ�Ƿ� ��ü ���� ũ�⸦ �������� �ݺ��� ��� ��
//		while((b = fis.read()) != -1) {
//			fos.write(b); // 1����Ʈ�� �ű�
//		}
		
		// 1024����Ʈ��
		byte[] buf = new byte[1024];
		int size = 0;
		while((size = fis.read(buf)) != -1) { // ���� ���� �뷮�� 300�̸�, 300�� size�� ����, �� �̻� ���� �� ������ -1�� ����
//			fos.write(buf); // 1024 ��ŭ�� ���۸� �ۿͼ� �� ��
			fos.write(buf, 0, size); // �� ������ turn�� ���� �� 1024�� �� �������� �ʰ� �� ���� ���̱� ������, �о�� �� ��ŭ(size)�� ������ �ϱ�
			// 0�������� size ������ŭ 1024 �뷮�� �ٰ����� ����ؼ� ��� ��.
		}
		fos.close();
		fis.close();
		
//		PrintWriter out = response.getWriter();
//		out.printf("tltle: %s<br>", title);
//		out.printf("content: %s<br>", content);
//		out.printf("open: %s<br>", isOpen);
		
		Notice notice = new Notice();
		notice.setId((int)Math.random()*100+1);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setWriter("newlec");
		
		NoticeService service = new NoticeService();
		service.insertNotice(notice);
		
		response.sendRedirect("list");
	}
	
}
