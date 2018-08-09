package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.JukouListBean;
import bean.KenshuJissekiListBean;
import bean.SankashaListBean;
import dao.Dao;
import dao.JukouDao;
import dao.KenshuDao;

public class KenshuService
{
    public SankashaListBean getKenshuSankashaList(String kenshuJissekiid  )
    {
        SankashaListBean bean = new SankashaListBean();
        try ( Connection con = Dao.getConnection(); )
        {
            JukouDao dao = new JukouDao(con);

            dao.getSankashaList( bean, kenshuJissekiid );

            if( bean.size() != 0 )
            {
                bean.setTitle(			bean.get(0).getTitle()			);
                bean.setKaisaidate(		bean.get(0).getKaisaidate()		);
                bean.setKaisaidate2(	bean.get(0).getKaisaidate2()		);
                bean.setKaisaidate3(	bean.get(0).getKaisaidate3()		);
                bean.setNumdays(		bean.get(0).getNumdays()	);
            }

        }
        catch( SQLException e )
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

        return bean;
    }


    public JukouListBean getJukouList(String shainid  )
    {
        JukouListBean bean = new JukouListBean();
        try ( Connection con = Dao.getConnection(); )
        {
            JukouDao dao = new JukouDao(con);

            dao.getJukouList( bean, shainid );

            if( bean.size() != 0 )
            {
                bean.setEmployee_no(			bean.get(0).getEmployee_no());
                bean.setEmployee_family_name( 	bean.get(0).getEmployee_family_name());
                bean.setEmployee_first_name( 	bean.get(0).getEmployee_first_name());
                bean.setNenji(					bean.get(0).getNenji());
                bean.setChuto_ninasinenji(		(int)bean.get(0).getChuto_ninasinenji());
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

        return bean;
    }


    public KenshuJissekiListBean getKenshuJissekiList(int nendo ) {
        KenshuJissekiListBean bean = new KenshuJissekiListBean();

        try ( Connection con = Dao.getConnection(); )
        {
            KenshuDao dao = new KenshuDao(con);

            bean.setList(				dao.getKenshuJissekiList(nendo)	);
            bean.setKenshuMasterList(	dao.getKenshuMasterList()	);

        }
        catch( SQLException e )
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

        return bean;
    }


    public void registKenshu(
            String parameter,
            String parameter2,
            String parameter3,
            String parameter4,
            String parameter5
            )
    {
        try ( Connection con = Dao.getConnection(); )
        {
            KenshuDao dao = new KenshuDao(con);

            dao.registKenshu(
                    parameter,
                    parameter2,
                    parameter3,
                    parameter4,
                    parameter5
                    );

        }
        catch( SQLException e )
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }
    }

}
