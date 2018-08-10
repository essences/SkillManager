package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.KenshuJissekiListBean;
import dao.Dao;
import dao.KenshuDao;

public class KenshuService
{

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
