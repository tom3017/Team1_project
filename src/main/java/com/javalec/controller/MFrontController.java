package com.javalec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.command.MCommand;
import com.javalec.command.MFaqCommand;
import com.javalec.command.MNoticeCommand;
import com.javalec.command.MReviewCommand;
import com.javalec.command.ManagerCommand;
import com.javalec.command.MqnaCommand;
import com.javalec.command.MqnaContentCommand;
import com.javalec.command.MqnaWriteCommand;
import com.javalec.command.ProductCommand;
import com.javalec.command.TotalCommand;

/**
 * Servlet implementation class SFrontController
 */
@WebServlet("*.do")
public class MFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost");
		actionDo(request, response);// 유지보수때문에
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");

		// session
		HttpSession session = request.getSession();// 세션정의 (컨트롤러)

		MCommand command = null;
		String viewPage = null;

		String uri = request.getRequestURI();// uri=> 뒤에 쓴것만 가져오
		System.out.println(uri);
		String conPath = request.getContextPath();/// MVCBoard
		System.out.println(conPath);
		String com = uri.substring(conPath.length());
		System.out.println(com);

		switch (com) {
		case ("/main.do"): // 메인 페이지
//			session.invalidate();
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "index.jsp";
			break;

		// ------------- about 폴더 ------------------
		case ("/about.do"): // aboutUs
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "./about/aboutUs.jsp";
			break;

		// ------------- category 폴더 ------------------
		case ("/best100.do"): // Best 100
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "./category/best_100.jsp";
			break;
		case ("/all_in_one.do"): // All-in-one
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "./category/all_in_one.jsp";
			break;
		case ("/outer.do"): // Outer
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "./category/outer.jsp";
			break;
		case ("/topshort.do"): // Top(short sleeve)
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "./category/topshort_sleeve.jsp";
			break;
		case ("/toplong.do"): // Top(long sleeve)
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "./category/toplong_sleeve.jsp";
			break;
		case ("/bottoms.do"): // Bottoms
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "./category/bottoms.jsp";
			break;
		case ("/bags.do"): // Bags
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "./category/bags.jsp";
			break;
		case ("/accessories.do"): // Accessories
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "./category/accessories.jsp";
			break;
		case ("/shoes.do"): // Shoes
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "./category/shoes.jsp";
			break;
		case ("/women.do"): // Women only
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "./category/women_only.jsp";
			break;

		// ------------- board 폴더 ------------------
		case ("/notice.do"): // notice
			command = new MNoticeCommand();
			command.execute(request, response);
			viewPage = "./board/notice.jsp";
			break;
		case ("/review.do"): // review
			command = new MReviewCommand();
			command.execute(request, response);
			viewPage = "./board/review.jsp";
			break;
		case ("/qna.do"): // qna
			command = new MqnaCommand();
			command.execute(request, response);
			viewPage = "./board/qna.jsp";
			break;
		case ("/faq.do"): // board
			command = new MFaqCommand();
			command.execute(request, response);
			viewPage = "./board/faq.jsp";
			break;
		case ("/qnaWrite.do"):// Q&A 에서 글쓰기 버튼을 눌렀을 시 글쓰기 페이지로 가는 컨트롤러
//			command = new MqnaWriteCommand();
//			command.execute(request, response);
			viewPage = "./board/qnaWrite.jsp";
			break;
		case ("/qnaWriteSubmit.do"):// 글쓰기에서 작성후 데이터베이스에 담기
			command = new MqnaWriteCommand();
			command.execute(request, response);
			viewPage = "./board/qna.jsp";
			break;
		case ("/qnaContent.do"):// Q&A 에서 글 클릭시 컨트롤러
			command = new MqnaContentCommand();
			command.execute(request, response);
			viewPage = "./board/qnaContent.jsp";
		break;

		// ------------- member 폴더 ------------------
		case ("/agreement.do"): // agreement
			viewPage = "./member/agreement.jsp";
			break;
		case ("/privacy.do"): // privacy
			viewPage = "./member/privacy.jsp";
			break;
		case ("/login.do"): // login
			viewPage = "./member/login.jsp";
			break;
		case ("/findId.do"): // 아이디 찾기
			viewPage = "./member/findId.jsp";
			break;
		case ("/findPasswd.do"): // 비밀번호 찾기
			viewPage = "./member/findPasswd.jsp";
			break;
		case ("/memberJoin.do"): // 회원가입
			viewPage = "./member/Join.jsp";
			break;

		// ------------- admin ---------------------
		
		case ("/manager.do"):
			command = new ManagerCommand();
			command.execute(request, response);
			viewPage = "./admin/UserManageAdmin.jsp";
			break;

		case ("/productmanager.do"):
//			//			command= new PmCommand();
  			command= new ProductCommand();
			command.execute(request,response);
			viewPage="./admin/ProductManager.jsp";
			break;

		case ("/productinsert.do"):
			viewPage="ProductInsert.jsp";
		viewPage="ProductInsertAdmin.jsp";
		break;

		case ("/productupdate.do"):
			viewPage="./admin/TotalAdmin.jsp";
			break;

		case ("/noticemanager.do"):
//			command= new NoticeCommand();
//			command.execute(request, response);
			viewPage = "Noticemanager.jsp";
			break;

		case ("/noticeinsert.do"):
			viewPage = "NoticeInsert.jsp";
			break;

		case ("/noticeupdate.do"):
			viewPage = "Noticeupdate.jsp";
			break;

		case("/totalmanager.do"):
//			command= new TotalCommand();
			command= new TotalCommand();
			command.execute(request,response);
			viewPage="./admin/TotalAdmin.jsp";
			break;

		// ------------- logout ---------------------
		case ("/logout.do"): // 로그아웃시 메인으로
			session.invalidate();
//			command = new BListCommand();
//			command.execute(request, response);
			viewPage = "index.jsp";
			break;

		default:
			break;

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}// actiondo

}