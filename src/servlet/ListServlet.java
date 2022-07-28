package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ListBean;
import bean.SankashaListBean;
import domain.SearchSort;
import domain.SearchType;
import service.JukouService;
import service.ShainService;
import vo.KenshujukouVo;

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

    private boolean isContainInList( String[] list, String str)
    {
        if(list==null) return false;

        for( String s : list)
        {
            if( s.equals(str)) return true;
        }

        return false;
    }

    //登録参加者データのリストをリクエストから生成する
    private List<KenshujukouVo> getKenshujukouVoListByRequest(HttpServletRequest request)
    {
        List<KenshujukouVo> list = new ArrayList<KenshujukouVo>();

        String[] idList =  request.getParameterValues("hidden_employee_no");
        String[] sysIdList =  request.getParameterValues("hidden_system_no");
        String[] checkBoxidList =  request.getParameterValues("employee_no");


        String[] jizen_shusseki1List =  request.getParameterValues("jizen_shusseki1");
        String[] jizen_shusseki2List =  request.getParameterValues("jizen_shusseki2");
        String[] jizen_shusseki3List =  request.getParameterValues("jizen_shusseki3");

        String[] toujitu_shusseki1List =  request.getParameterValues("toujitu_shusseki1");
        String[] toujitu_shusseki2List =  request.getParameterValues("toujitu_shusseki2");
        String[] toujitu_shusseki3List =  request.getParameterValues("toujitu_shusseki3");

        String[] kesseki_jiyuList =  request.getParameterValues("kesseki_jiyu");
        String[] genba_joucho_emp_noList =  request.getParameterValues("genba_joucho_emp_no");

        for( int i =0; i< idList.length ; i++ )
        {
            if( !isContainInList(checkBoxidList, idList[i]) )
            	continue; //チェックボックスがセットされていなかったら登録しない

            KenshujukouVo vo = new KenshujukouVo();
            vo.setShainid(  idList[i]    );
            vo.setSystemNo( sysIdList[i] );

            vo.setIs_kakunin1( isContainInList( jizen_shusseki1List, idList[i] )?1:0 );
            vo.setIs_kakunin2( isContainInList( jizen_shusseki2List, idList[i] )?1:0 );
            vo.setIs_kakunin3( isContainInList( jizen_shusseki3List, idList[i] )?1:0 );

            vo.setIs_shusseki( 	isContainInList( toujitu_shusseki1List, idList[i] )?1:0 );
            vo.setIs_shusseki2( isContainInList( toujitu_shusseki2List, idList[i] )?1:0 );
            vo.setIs_shusseki3( isContainInList( toujitu_shusseki3List, idList[i] )?1:0 );

            vo.setKessekiriyu(	kesseki_jiyuList[i]	);

            vo.setGenba_joucho_emp_no(genba_joucho_emp_noList[i]);


            list.add(vo);
        }
        return list;

    }



    //参加者登録機能
    private void doSankashaTouroku(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
         List<KenshujukouVo> list = getKenshujukouVoListByRequest( request );

        String kenshujissekiId =  request.getParameter("kenshuList");

        System.out.println("KENSHUJISSEKIID:" + kenshujissekiId);

        JukouService service = new JukouService();
        SankashaListBean bean  =  service.registSankasha(kenshujissekiId, list );

        request.setAttribute( "bean", bean );
        RequestDispatcher disp = request.getRequestDispatcher( "/sankasha.jsp" );
        disp.forward( request, response );

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
         request.setCharacterEncoding( "utf-8" );

         //参加者を登録する
         if( request.getParameter("regist_shain_to_kenshu")!=null )
         {
             doSankashaTouroku(request, response);

         }
         else
         {

             String[] idList =  request.getParameterValues("employee_no");

             SearchSort searchSort = SearchSort.valueOf( (request.getParameter("searchSort")==null)?SearchSort.みなし年次.name():request.getParameter("searchSort") );
             SearchType searchType =SearchType.valueOf(  (request.getParameter("searchType")==null)?SearchType.年次.name():request.getParameter("searchType") );
             String searchJoken = (request.getParameter("searchJoken")==null)?"":request.getParameter("searchJoken");
             String prevSearchJoken =searchJoken;

             String presearchNendo = "";
             int searchNendo = 0;
             try
             {
            	 searchNendo
            	 	= (request.getParameter("searchNendo")==null)?LocalDate.now().getYear() : Integer.parseInt(request.getParameter("searchNendo"));
             	presearchNendo = new Integer(searchNendo).toString();
             }
             catch(Exception e)
             {
            	 //ALL　のときなにもしない。 
             }
             
             if( searchType== SearchType.年次 && searchJoken!=null && searchJoken.length()!=0 )
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
                 bean = service.getList(idList,searchSort,searchType,searchJoken,searchNendo);
             }
             else if( request.getParameter("kaijo") != null )
             {

                 bean = service.getList(null,searchSort,searchType,searchJoken,searchNendo);
             }
             else if( request.getParameter("csv") != null ) //CSVダウンロード
             {
                 bean = service.getList(idList,searchSort,searchType,searchJoken,searchNendo);
                 //文字コードと出力するCSVファイル名を設定
                 response.setContentType("application/octet-stream;charset=utf-8");
                 response.setHeader("Content-Disposition", "attachment; filename=\"shain_list.csv\"");

                 try (PrintWriter pw = response.getWriter())
                 {
                     bean = service.getList(null,searchSort,searchType,searchJoken,searchNendo);
                     pw.print( bean.getCSV() );
                 }
                 return;
             }
             else //ログインチェック
             {
                  String LoginName = (request.getParameter("loginname")==null)?"共創いえい":request.getParameter("loginname");
                  if(!LoginName.equals("共創いえい"))
                  {
                      RequestDispatcher disp = request.getRequestDispatcher( "/index.jsp" );
                      disp.forward( request, response );
                      return;
                  }

                  request.getSession().setAttribute("LoginName", LoginName);
                  bean = service.getList(null,searchSort,searchType,searchJoken,searchNendo);
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
             bean.setPrevSearchNendo(presearchNendo);

             request.setAttribute( "bean", bean );
             RequestDispatcher disp = request.getRequestDispatcher( "/shainlist.jsp" );
             disp.forward( request, response );
         }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
