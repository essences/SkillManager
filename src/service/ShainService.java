package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.ListBean;
import dao.Dao;
import dao.KenshuDao;
import dao.ShainDao;
import domain.SearchSort;
import domain.SearchType;

public class ShainService
{
    public ListBean getList(
            String[] idList,
            SearchSort searchSort,
            SearchType searchType,
            String searchJoken,
            int kenshuNendo
            )
    {
        ListBean bean = new ListBean();
        try ( Connection con = Dao.getConnection(); )
        {
            ShainDao dao = new ShainDao(con);
            KenshuDao kdao = new KenshuDao(con);

            dao.getShainList( bean.getList(), idList, searchSort,searchType,searchJoken );

            kdao.getKenshuJissekiList(kenshuNendo, bean.getKenshuList());

        }
        catch( SQLException e )
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

        return bean;
    }

}
