package com.sist.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet → Sever + let → Sevlet (서버에서 실행되는 가벼운 프로그램)
 *  
 * 1. 특징 : 순수하게 자바로만 제작
 * 	- 이해가 편리(분석이 쉽다)
 * 	- 수정이 된 경우에 계속 컴파일을 거친다(바로 수행되는 내용을 볼 수 없다)
 * 	- 소수기 노출이 없다(.java → .class) → 보안이 뛰어나다
 * 	- 바로 수행이 가능하게 만든 프로그램 : JSP
 * 	- JSP는 소스의 누출이 있다(보안)
 *  - JSP(HTML로 보여주는 기능), 서블릿(보안이 필요한 내용)
 * 
 * 2. 실행과정
 * 	- @WebServlet("/Firstsevlet")
 *  - 사용자가 URL을 브라우저에서 입력
 *  - http://localhost/JSPMiddleProject1/FristSevlet
 *  - 톰캣에서 해당 서블릿을 찾아준다
 *   1) 메모리 할당(생성자 호출)
 *   2) init() : 생성자 대신 → XML파일, Annotation
 *   			 화면에 출력되기 전에 처리하는 내용
 *   3) 사용자가 GET방식으로 데이터를 전송 : doGet()
 *      사용자가 POST방식으로 데이터를 전송 : doPost()
 *      doGet()/doPost() → 통합 service()
 *      JSP는 GET/POST → 한번에 처리 → 구분하지않는다
 *      doGet() → 목록출력, 입력폼
 *      doPost() → 데이터를 받아서 처리
 *      사용자가 요청한 페이지를 보여주는 부분
 *   4) 새로고침, 파일(페이지)을 이동 → 자동으로 메모리에서 해제
 *      destory()
 *      → 메소드는 톰캣에 의해 자동 호출
 * 
 */

@WebServlet("/Firstsevlet")
public class Firstsevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Firstsevlet() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("1. 첫번째 호출되는 메소드");
	}

	// doGet/doPost는 동시에 수행하지 않는다(사용자가 전송 방식)
	// → Get(doGet), POST(doPost)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("2. 요청을 받아서 요청 처리 → 브라우저로 HTML전송");
		// HTML을 작성 → JSP
		// 1 . 브라우저로 전송하는 방식 설정 → text/html, text/xml, text/plain
		// 전송 → response
		response .setContentType("text/html;charset=UTF-8");
		// <%@ page contentType="text/html;charset=UTF-8"%>
		// 2. 브라우저에서 읽어가는 메모리 공간 설정
		PrintWriter out=response.getWriter(); // Socket연결(response:ip)
		// 3. 메모리 공간안에 HTML을 출력 → 브라우저에서 읽어 간다
		// --------출력버퍼(클라이언트당 한개씩 배정)
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet!!</h1>");
		out.println("</body>");
		out.println("</html>");
		// 속도:서블릿, 가독성:JSP
		// → 두개를 통합해서 처리
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("3. 요청을 받아서 요청 처리 → 브라우저로 HTML전송");
		// HTML을 작성 → JSP → 서블릿으로 화면 출력(X), 서블릿은 Java,Html을 연
		// Controller (MVC) → 서블릿
		// Spring → Controller가 이미 만들어져있다 → 메뉴얼
		// 통합해서 처리(MVC)
	}

}
