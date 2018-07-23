package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ListBean;
import domain.SearchSort;
import domain.SearchType;
import service.ShainService;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();

    }
    private static String zenkakuToHankaku(String value) {
        StringBuilder sb = new StringBuilder(value);
        for (int i = 0; i < sb.length(); i++) {
            int c = (int) sb.charAt(i);
            if ((c >= 0xFF10 && c <= 0xFF19) || (c >= 0xFF21 && c <= 0xFF3A) || (c >= 0xFF41 && c <= 0xFF5A)) {
                sb.setCharAt(i, (char) (c - 0xFEE0));
            }
        }
        value = sb.toString();
        return value;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
         request.setCharacterEncoding( "utf-8" );

         String[] idList =  request.getParameterValues("employee_no");

         SearchSort searchSort = SearchSort.valueOf( request.getParameter("searchSort") );
         SearchType searchType =SearchType.valueOf(  request.getParameter("searchType") );
         String searchJoken =request.getParameter("searchJoken");
         String prevSearchJoken =searchJoken;

         if(searchType== SearchType.年次 && searchJoken.length()!=0)
         {
             try {
            int i =Integer.parseInt( searchJoken );
            searchJoken = String.valueOf(i);
             }
             catch( NumberFormatException e )
             {
                 searchJoken = "";
                 prevSearchJoken = "<年次検索：数値を入力してください。>";
             }
         }


         ShainService service = new ShainService();
         ListBean bean = null;
         if( request.getParameter("shiborikomi")!=null )
         {
             bean = service.getList(idList,searchSort,searchType,searchJoken);
         }
         else if( request.getParameter("kaijo") != null )
         {

             bean = service.getList(null,searchSort,searchType,searchJoken);
         }
         else if( request.getParameter("csv") != null )
         {
             bean = service.getList(idList,searchSort,searchType,searchJoken);
             //文字コードと出力するCSVファイル名を設定
             response.setContentType("application/octet-stream;charset=utf-8");
             response.setHeader("Content-Disposition", "attachment; filename=\"shain_list.csv\"");

             try (PrintWriter pw = response.getWriter())
             {
                 bean = service.getList(null,searchSort,searchType,searchJoken);
                 pw.print( bean.getCSV() );
             }
             return;
          }


        if( idList != null )
         {
             for(String emp_no:idList)
             {
                 bean.put(emp_no, emp_no);
             }
         }
         bean.setPrevSearchSort(searchSort);
         bean.setPrevSearchType(searchType);
         bean.setPrevsearchJoken(prevSearchJoken);

         request.setAttribute( "bean", bean );
         RequestDispatcher disp = request.getRequestDispatcher( "/index.jsp" );
         disp.forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
