package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.SearchSort;
import domain.SearchType;
import vo.Shainmaster_wo_retire_viewVo;


public class ShainDao extends Dao
{
    public ShainDao(Connection con)
    {
        super( con );
    }


    //ユーザー検索用SQL文
    private static final String SEARCH_SQL =
            "SELECT `shainmaster_wo_retire_view`.`EMPLOYEE_NO`,\r\n" +
            "    `shainmaster_wo_retire_view`.`COMPANY_CD`,\r\n" +
            "    `shainmaster_wo_retire_view`.`EMPLOYEE_TYPE`,\r\n" +
            "    `shainmaster_wo_retire_view`.`EMPLOYEE_FAMILY_NAME`,\r\n" +
            "    `shainmaster_wo_retire_view`.`EMPLOYEE_FIRST_NAME`,\r\n" +
            "    `shainmaster_wo_retire_view`.`EMPLOYEE_FAMILY_NAME_KANA`,\r\n" +
            "    `shainmaster_wo_retire_view`.`EMPLOYEE_FIRST_NAME_KANA`,\r\n" +
            "    `shainmaster_wo_retire_view`.`DEPT_CD`,\r\n" +
            "    `shainmaster_wo_retire_view`.`GROUP_NAME`,\r\n" +
            "    `shainmaster_wo_retire_view`.`DEPT_NAME`,\r\n" +
            "    `shainmaster_wo_retire_view`.`SECTION_NAME`,\r\n" +
            "    `shainmaster_wo_retire_view`.`CLIENT_CD`,\r\n" +
            "    `shainmaster_wo_retire_view`.`WORK_PLACE_CD`,\r\n" +
            "    `shainmaster_wo_retire_view`.`EMAIL`,\r\n" +
            "    `shainmaster_wo_retire_view`.`EMPLOY_DATE`,\r\n" +
            "    `shainmaster_wo_retire_view`.`nenji`,\r\n" +
            "    `shainmaster_wo_retire_view`.`RETIREMENT_DATE`,\r\n" +
            "    `shainmaster_wo_retire_view`.`UPDATE_DATETIME`,\r\n" +
            "    `shainmaster_wo_retire_view`.`DELETE_FLG`,\r\n" +
            "    `shainmaster_wo_retire_view`.`GENDER`,\r\n" +
            "    `shainmaster_wo_retire_view`.`BIRTH_DATE`,\r\n" +
            "    `shainmaster_wo_retire_view`.`age`,\r\n" +
            "    `shainmaster_wo_retire_view`.`TEL_NO`,\r\n" +
            "    `shainmaster_wo_retire_view`.`CELL_TEL_NO`,\r\n" +
            "    `shainmaster_wo_retire_view`.`WORKING_TEL_NO`,\r\n" +
            "    `shainmaster_wo_retire_view`.`POSITION`,\r\n" +
            "    `shainmaster_wo_retire_view`.`UPGRADE_DATE`,\r\n" +
            "    `shainmaster_wo_retire_view`.`chuto_ninasinenji`\r\n" +
            "FROM `kyoso`.`shainmaster_wo_retire_view` \r\n";



    //ユーザー検索
    public void getShainList(
            List<Shainmaster_wo_retire_viewVo> list,
            String[] idList,
            SearchSort searchSort,
            SearchType searchType,
            String searchJoken )
                    throws SQLException
    {
        StringBuilder sql =new StringBuilder( SEARCH_SQL );
        if(  idList != null || searchJoken.length() !=0 )
           sql.append(" WHERE ");

        if( idList != null )
        {
            for( String str: idList)
            {
                sql.append( " EMPLOYEE_NO=" +  str ).append(" OR");

            }
            sql.delete(sql.length()-2, sql.length());
        }

        if( searchJoken.length() !=0 && searchType == SearchType.年次 )
        {
            if( idList != null )
                sql.append(" OR ");
            sql.append("nenji=" + searchJoken );
        }
        else if( searchJoken.length() !=0 && searchType == SearchType.役職 )
        {
            if( idList != null )
                sql.append(" OR ");
            sql.append(" POSITION LIKE \"%" + searchJoken + "%\"" );
        }


        if( searchSort == SearchSort.年次 )
            sql.append(" ORDER BY `nenji`,`EMPLOYEE_NO` desc ");
        else
            sql.append(" ORDER BY `EMPLOYEE_FAMILY_NAME_KANA` ");

        System.out.println(sql.toString());

        try ( PreparedStatement stmt = con.prepareStatement( sql.toString() );)
        {

            ResultSet rset = stmt.executeQuery();

            while (rset.next())
            {
                Shainmaster_wo_retire_viewVo vo = new  Shainmaster_wo_retire_viewVo();

                vo.setEmployee_no(				rset.getString(	"EMPLOYEE_NO")			);
                vo.setEmployee_family_name( 	rset.getString(	"EMPLOYEE_FAMILY_NAME") );
                vo.setEmployee_first_name( 		rset.getString(	"EMPLOYEE_FIRST_NAME") 	);
                vo.setEmployee_family_name_kana( 	rset.getString(	"EMPLOYEE_FAMILY_NAME_KANA") );
                vo.setEmployee_first_name_kana( 		rset.getString(	"EMPLOYEE_FIRST_NAME_KANA") 	);
                vo.setNenji(					rset.getLong(	"nenji")				);
                vo.setDept_name(				rset.getString(	"DEPT_NAME")			);
                vo.setPosition(					rset.getString("POSITION")				);
                vo.setEmail(					rset.getString("EMAIL")					);
                vo.setTel_no(					rset.getString("CELL_TEL_NO")			);
                vo.setChuto_ninasinenji(		rset.getInt("chuto_ninasinenji")		);

                list.add(vo);
            }
        }
    }

}
