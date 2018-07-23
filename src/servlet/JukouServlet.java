package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.JukouListBean;
import service.KenshuService;

/**
 * Servlet implementation class JukouServlet
 */
@WebServlet("/Jukou")
public class JukouServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JukouServlet() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );


        String shainNo =  request.getParameter("shainNo");

        System.out.println("shainNo" + shainNo);

        KenshuService service = new KenshuService();

        JukouListBean bean = service.getJukouList(shainNo);

        request.setAttribute( "bean", bean );
        //一覧画面に遷移
        RequestDispatcher disp = request.getRequestDispatcher( "/jukou.jsp" );
        disp.forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
