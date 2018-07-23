package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SankashaListBean;
import service.KenshuService;

/**
 * Servlet implementation class JukouServlet
 */
@WebServlet("/Sankasha")
public class SankashaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SankashaServlet() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );

        String kenshujissekiId =  request.getParameter("KENSHUJISSEKIID");

        System.out.println("KENSHUJISSEKIID" + kenshujissekiId);

        KenshuService service = new KenshuService();

        SankashaListBean bean = service.getKenshuSankashaList(kenshujissekiId);

        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/sankasha.jsp" );
        disp.forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
