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
		fileSizeThreshold=1024*1024, // 첨부파일이 1m가 넘을 경우 메모리가 아닌 디스크를 쓰자
		maxFileSize=1024*1024*5, // 파일 하나의 크기가 5m
		maxRequestSize=1024*1024*5*5 // 파일이 여러개일 경우, 전체 파일 용량을 25m로 제한
)
@WebServlet("/admin/board/notice/reg")
// get, post 요청 처리
public class RegController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 등록하기 위한 페이지
		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String isOpen = request.getParameter("open");
		boolean pub = isOpen != null ? true : false;
		
		// Part는 바이너리 컨텐츠를 넘겨 줌
		Part filePart = request.getPart("file"); // name=file인 part를 얻음
		InputStream fis = filePart.getInputStream(); // 사용자가 전달한 파일을 얻어 저장
		// 받은 파일 저장 : 경로는 절대 경로만 가능
		// 절대 경로를 물리 경로로 바꾸는 방법
		String realPath = request.getServletContext().getRealPath("/upload"); // web 루트를 통해 상대경로를 넘겨주면, 시스템 내 실제 물리경로를 찾음
		System.out.println(realPath);
		
//		int b = fis.read(); // System.in 처럼 파일을 읽어 입력받음. 바이트 단위로 1바이트 씩 읽음.
		// 반환 타입이 정수형인 이유 : 다 읽어들이고 더 이상 읽어들일 값이 없을 때, 다 읽었다는 걸 정수형으로 리턴(-1).
		// 실제 전달되는 건 byte기 때문에 데이터만 쓰고자 한다면 byte를 써도 됨
		
		String fileName = filePart.getSubmittedFileName();
		String filePath = realPath + File.separator + fileName; // 실제 파일 경로
		// File.pathSeparator : 구분자 "/"
		
		// InputStream : 입력하기 위한 버퍼
		// OutputStream : 출력하기 위한 버퍼
		// 위 경로를 이용해 스트림을 통해 저장
		FileOutputStream fos = new FileOutputStream(filePath);
		
		// 1바이트씩
//		int b;
//		// int b는 1바이트므로 전체 파일 크기를 읽으려면 반복문 써야 함
//		while((b = fis.read()) != -1) {
//			fos.write(b); // 1바이트씩 옮김
//		}
		
		// 1024바이트씩
		byte[] buf = new byte[1024];
		int size = 0;
		while((size = fis.read(buf)) != -1) { // 만약 파일 용량이 300이면, 300이 size에 담기고, 더 이상 읽을 게 없으면 -1을 리턴
//			fos.write(buf); // 1024 만큼의 버퍼를 퍼와서 다 씀
			fos.write(buf, 0, size); // 맨 마지막 turn을 지날 때 1024와 딱 떨어지지 않고 더 적을 것이기 때문에, 읽어온 것 만큼(size)만 쓰도록 하기
			// 0에서부터 size 개수만큼 1024 용량의 바가지를 사용해서 담아 옴.
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
