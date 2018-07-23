package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.ListBean;
import dao.Dao;
import dao.ShainDao;
import domain.SearchSort;
import domain.SearchType;

public class ShainService
{
    public ListBean getList(String[] idList, SearchSort searchSort, SearchType searchType, String searchJoken  )
    {
        ListBean bean = new ListBean();
        try ( Connection con = Dao.getConnection(); )
        {
            ShainDao dao = new ShainDao(con);

            dao.getShainList( bean, idList, searchSort,searchType,searchJoken);

        }
        catch( SQLException e )
        {
            e.printStackTrace();
            throw new RuntimeException( e );
        }

        return bean;
    }

}
