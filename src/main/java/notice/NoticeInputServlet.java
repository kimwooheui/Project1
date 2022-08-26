package notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NoticeInputServlet
 */
@WebServlet("/noticeInput.do")
public class NoticeInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");
		HttpSession session = request.getSession();
		String writer = 
				(String)session.getAttribute("MANAGER");
		DBExpert dbe = new DBExpert();
		int seqno = dbe.getSeqno() + 1;//���� �ִ� ��ȣ���� +1�ϱ�
		Notice notice = new Notice();
		notice.setSeqno(seqno);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setId(writer);
		dbe.insertNotice(notice);
		
		//�ۼ���: ����Ŭ�� sysdate �Լ� ���
		//�۹�ȣ-�ڵ����� select max(seqno) from notice_tbl
		//�ۼ��� - ���ǿ��� MANAGER�� ã�´�
		//session.getAttribute("MANAGER");
		//���� ����
		response.sendRedirect("NoticeSelect");
	}
	
}
