package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeSelect
 */
@WebServlet("/NoticeSelect")
public class NoticeSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBExpert dbe = new DBExpert();
		ArrayList<Notice> list = dbe.selectAllNotice();
		int totalCount = dbe.selectTotalCount();//전체글 개수
		int pageCount = totalCount / 5;//전체글 개수
		if (totalCount % 5 != 0) {
			pageCount++;//나눴는데 나머지가 있으면 페이지를 1 늘린다.
		}
//		System.out.println("페이지의 갯수: "+pageCount);//콘솔로 페이지 수 출력함.
		request.setAttribute("LIST",list);
		request.setAttribute("PAGES",pageCount);
		RequestDispatcher rd = 
				request.getRequestDispatcher("template.jsp?BODY=noticeAll.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
