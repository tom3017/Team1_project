package com.javalec.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.dao.QnaDao;
import com.javalec.dto.QnaDto;

public class MqnaCommand implements MCommand {

	//페이지당 표시할 게시글의 수
	int numOfTuplesPerPage = 5;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		 //사용자가 요청한 페이지 번호 초기값은 가장 최신글을 보여주는 1
	    int requestPage = 1;
	    QnaDao dao = new QnaDao();
	    HttpSession session = request.getSession();

	    //최초 목록 진입시 page값을 넘겨주지 않음 -> 초기값인 1페이지 목록을 보여줌
	    //목록에서 page요청 -> 해당 페이지 번호로 requestPage 설정
	    if (request.getParameter("page") != null) {
	        requestPage = Integer.parseInt(request.getParameter("page"));
	        //content에서 목록보기 요청시 최근 페이지 목록으로 돌아가기 위해 세션에 저장
	        session.setAttribute("currentPage", requestPage);
	    }

	    //반환되는 총 어레이리스트의 수
	    int countedTuple = dao.countTuple();
	    //페이지 목록 (1...n)
	    ArrayList<Integer> pageList = calcNumOfPage(countedTuple, numOfTuplesPerPage);
	    //해당 페이지에 알맞은 번호의 게시글
	    ArrayList<QnaDto> dtos = dao.list(requestPage, numOfTuplesPerPage);
	    //request에 게시글들을 태워 보낸다.
	    request.setAttribute("list", dtos);
	    //페이지 목록을 세션에 담는다. *list에 진입하면 무조건 세션이 갱신되므로 새 글이 생겨도 최신화가 된다.
	    session.setAttribute("pageList", pageList);
	}

	//총 어레이리스트수를 받아 페이지당 표시할 게시글의 수로 나누어서 페이지수를 계산하고 jsp에서 for-each문을 돌리기 위해 배열에 담는다(변수이름은 튜플로 되있는데 사실 어레이리스트랑 같은거임)
	//튜플: 리스트와 동일하게 여러 객체를 모아서 담는다. 숫자, 문자, 객체, 배열, 튜플 안의 튜플 전부 가능하다. 하지만 튜플 내의 값은 수정이 불가능 (그래서 어레이 리스트랑 같은거임 수정만 불가능한 파이썬에서 배운다고함)
	public ArrayList<Integer> calcNumOfPage(int countedTuple, int numOfTuplesPerPage) {
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    int calcPage = 0;
	    // 어레이리스트의 총 갯수가 딱 맞아떨어지는 경우를 대비해 조건 만들기
	    if (countedTuple % numOfTuplesPerPage == 0) {
	        calcPage = countedTuple / numOfTuplesPerPage;
	    } else {
	        calcPage = countedTuple / numOfTuplesPerPage + 1;
	    }

	    for (int i = 1; i <= calcPage; i++) {
	        arr.add(i);
	    }
	    return arr;
	}
	
}