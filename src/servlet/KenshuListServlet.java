package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.KenshuJissekiListBean;
import service.KenshuService;

/**
 * Servlet implementation class JukouServlet
 */
@WebServlet("/KenshuList")
public class KenshuListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KenshuListServlet() {
        super();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );

        String nendoStr= request.getParameter("searchNendo");

        int nendo = 0;

        if( nendoStr!=null && !nendoStr.equals("ALL") )
        {
            nendo = Integer.parseInt(nendoStr);
        }


        KenshuService service = new KenshuService();

        KenshuJissekiListBean bean = service.getKenshuJissekiList(nendo);
        bean.setPrevSearchNendo( (nendoStr==null)?"": nendoStr );

        request.setAttribute( "bean", bean );

        RequestDispatcher disp = request.getRequestDispatcher( "/kenshujisseki.jsp" );
        disp.forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
