package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.KenshuService;

/**
 * Servlet implementation class RegistKenshuServlet
 */
@WebServlet("/RegistKenshu")
public class RegistKenshuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistKenshuServlet() {
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding( "utf-8" );

        if( request.getParameter("yotei1") != null && !request.getParameter("yotei1").equals("") )
        {
            KenshuService service = new KenshuService();
            service.registKenshu(
                    request.getParameter("kenshuMaster"),
                    request.getParameter("yotei1"),
                    (request.getParameter("yotei2")==null)?"":request.getParameter("yotei2"),
                    (request.getParameter("yotei3")==null)?"":request.getParameter("yotei3"),
                    (request.getParameter("jisshi_ito")==null)?"":request.getParameter("jisshi_ito")
                    );
        }


        RequestDispatcher disp = request.getRequestDispatcher( "/KenshuList" );
        disp.forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}
