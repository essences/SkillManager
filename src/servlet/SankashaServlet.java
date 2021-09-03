package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SankashaListBean;
import service.JukouService;
import vo.KenshujukouVo;

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


    private boolean isContainInList( String[] list, String str)
    {
        if(list==null) return false;

        for( String s : list)
        {
            if( s.equals(str)) return true;
        }

        return false;
    }



    private List<KenshujukouVo> getUpdateData(HttpServletRequest request, HttpServletResponse response)
    {
        List<KenshujukouVo> list = new ArrayList<KenshujukouVo>();

        String[] idList 			=  request.getParameterValues("hidden_kenshujukouid");
        if( idList== null)
            return list;

        String[] deleleCkecboxList 	= request.getParameterValues("deleleCkecbox");

        String[] is_kakunin1List 	= request.getParameterValues("is_kakunin1");
        String[] is_kakunin2List 	= request.getParameterValues("is_kakunin2");
        String[] is_kakunin3List 	= request.getParameterValues("is_kakunin3");

        String[] is_shusseki1List 	= request.getParameterValues("is_shusseki");
        String[] is_shusseki2List 	= request.getParameterValues("is_shusseki2");
        String[] is_shusseki3List 	= request.getParameterValues("is_shusseki3");

        String[] kessekiriyuList 	= request.getParameterValues("kessekiriyu");
        String[] genba_joucho_emp_noList 	= request.getParameterValues("genba_joucho_emp_no");

        for( int i =0; i< idList.length ; i++ )
        {
            KenshujukouVo vo = new KenshujukouVo();

            vo.setKenshujukouid( Integer.parseInt(idList[i])  );

            vo.setIs_muko(		isContainInList( deleleCkecboxList, idList[i])?"1":"0"  ) ;
            vo.setIs_kakunin1( 	isContainInList( is_kakunin1List, 	idList[i] )?1:0 );
            vo.setIs_kakunin2( 	isContainInList( is_kakunin2List, 	idList[i] )?1:0 );
            vo.setIs_kakunin3( 	isContainInList( is_kakunin3List, 	idList[i] )?1:0 );

            vo.setIs_shusseki( 	isContainInList( is_shusseki1List, idList[i] )?1:0 );
            vo.setIs_shusseki2( isContainInList( is_shusseki2List, idList[i] )?1:0 );
            vo.setIs_shusseki3( isContainInList( is_shusseki3List, idList[i] )?1:0 );

            vo.setKessekiriyu(	kessekiriyuList[i]	);

            //vo.setGenba_joucho_emp_no(genba_joucho_emp_noList[i]);


            list.add(vo);
        }

        return list;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );

        String kenshujissekiId =  request.getParameter("KENSHUJISSEKIID");

        System.out.println("KENSHUJISSEKIID" + kenshujissekiId);

        JukouService service = new JukouService();
        SankashaListBean bean;

        //参加者を登録を更新する
        if( request.getParameter("regist_shain_to_kenshu")!=null )
        {
            List<KenshujukouVo> list = getUpdateData(request, response);
            bean = service.updateKenshuSankashaList( kenshujissekiId, list );

        }
        else
        {
             bean = service.getKenshuSankashaList(kenshujissekiId);
        }

        bean.setKenshujissekiid( Integer.parseInt(kenshujissekiId));

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
