package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import vo.Kenshu_jukou_viewVo;

public class JukouDao extends Dao
{
    public JukouDao(Connection con)
    {
        super( con );
    }




    private static final String KENSHU_SEARCH_SQL =
            "SELECT `kenshu_jukou_view`.`KENSHUJUKOUID`,\r\n" +
            "    `kenshu_jukou_view`.`IS_SHUSSEKI`,\r\n" +
            "    `kenshu_jukou_view`.`IS_SHUSSEKI2`,\r\n" +
            "    `kenshu_jukou_view`.`IS_SHUSSEKI3`,\r\n" +
            "    `kenshu_jukou_view`.`KAISAIDATE`,\r\n" +
            "    `kenshu_jukou_view`.`KAISAIDATE2`,\r\n" +
            "    `kenshu_jukou_view`.`KAISAIDATE3`,\r\n" +
            "    `kenshu_jukou_view`.`KENSHUJISSEKIID`,\r\n" +
            "    `kenshu_jukou_view`.`KESSEKIRIYU`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_NO`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FAMILY_NAME`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FIRST_NAME`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FAMILY_NAME_KANA`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FIRST_NAME_KANA`,\r\n" +
            "    `kenshu_jukou_view`.`EMAIL`,\r\n" +
            "    `kenshu_jukou_view`.`CELL_TEL_NO`,\r\n" +
            "    `kenshu_jukou_view`.`TITLE`,\r\n" +
            "    `kenshu_jukou_view`.`NUMDAYS`,\r\n" +
            "    `kenshu_jukou_view`.`toujitu_nenji`,\r\n" +
            "    `kenshu_jukou_view`.`nenji`,\r\n" +
            "    `kenshu_jukou_view`.`chuto_ninasinenji`,\r\n" +
            "    `kenshu_jukou_view`.`genba_joucho_emp_no`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FAMILY_NAME_J`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FIRST_NAME_J`,\r\n" +
            "    `kenshu_jukou_view`.`EMAIL_J`\r\n" +
            " FROM `kyoso`.`kenshu_jukou_view`\r\n" +
            " WHERE `EMPLOYEE_NO`=?"+
            " ORDER BY `KAISAIDATE` ";




    //ユーザー検索
    public void getJukouList( List<Kenshu_jukou_viewVo> list, String shainid) throws SQLException
    {
        try ( PreparedStatement stmt = con.prepareStatement( KENSHU_SEARCH_SQL );)
        {

            stmt.setString(1, shainid);
            ResultSet rset = stmt.executeQuery();

            while (rset.next())
            {
                Kenshu_jukou_viewVo vo = new  Kenshu_jukou_viewVo();

                vo.setEmployee_no(				rset.getString(	"EMPLOYEE_NO")			);
                vo.setEmployee_family_name( 	rset.getString(	"EMPLOYEE_FAMILY_NAME") );
                vo.setEmployee_first_name( 		rset.getString(	"EMPLOYEE_FIRST_NAME") 	);
                vo.setKaisaidate(				rset.getDate(	"KAISAIDATE") 			);
                vo.setKaisaidate2(				rset.getDate(	"KAISAIDATE2") 			);
                vo.setKaisaidate3(				rset.getDate(	"KAISAIDATE3") 			);
                vo.setIs_shusseki(				rset.getInt(	"IS_SHUSSEKI")			);
                vo.setIs_shusseki2(				rset.getInt(	"IS_SHUSSEKI2")			);
                vo.setIs_shusseki3(				rset.getInt(	"IS_SHUSSEKI3")			);
                vo.setNumdays(					rset.getInt(	"NUMDAYS")				);
                vo.setKessekiriyu(				rset.getString(	"KESSEKIRIYU") 			);
                vo.setTitle(					rset.getString(	"TITLE")				);
                vo.setToujitu_nenji(			rset.getLong(	"toujitu_nenji")		);
                vo.setNenji(					rset.getLong(	"nenji")				);
                vo.setChuto_ninasinenji(		rset.getInt(	"chuto_ninasinenji")	);
                vo.setKenshujissekiid(			rset.getInt(	"KENSHUJISSEKIID"));


                list.add(vo);
            }
        }
    }


    private static final String JUKOU_SEARCH_SQL =
            "SELECT `kenshu_jukou_view`.`KENSHUJUKOUID`,\r\n" +
            "    `kenshu_jukou_view`.`IS_SHUSSEKI`,\r\n" +
            "    `kenshu_jukou_view`.`IS_SHUSSEKI2`,\r\n" +
            "    `kenshu_jukou_view`.`IS_SHUSSEKI3`,\r\n" +
            "    `kenshu_jukou_view`.`KAISAIDATE`,\r\n" +
            "    `kenshu_jukou_view`.`KAISAIDATE2`,\r\n" +
            "    `kenshu_jukou_view`.`KAISAIDATE3`,\r\n" +
            "    `kenshu_jukou_view`.`KENSHUJISSEKIID`,\r\n" +
            "    `kenshu_jukou_view`.`KESSEKIRIYU`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_NO`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FAMILY_NAME`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FIRST_NAME`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FAMILY_NAME_KANA`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FIRST_NAME_KANA`,\r\n" +
            "    `kenshu_jukou_view`.`EMAIL`,\r\n" +
            "    `kenshu_jukou_view`.`CELL_TEL_NO`,\r\n" +
            "    `kenshu_jukou_view`.`TITLE`,\r\n" +
            "    `kenshu_jukou_view`.`NUMDAYS`,\r\n" +
            "    `kenshu_jukou_view`.`toujitu_nenji`,\r\n" +
            "    `kenshu_jukou_view`.`nenji`,\r\n" +
            "    `kenshu_jukou_view`.`chuto_ninasinenji`,\r\n" +
            "    `kenshu_jukou_view`.`genba_joucho_emp_no`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FAMILY_NAME_J`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FIRST_NAME_J`,\r\n" +
            "    `kenshu_jukou_view`.`EMAIL_J`\r\n" +
            " FROM `kyoso`.`kenshu_jukou_view`\r\n" +
            " WHERE `KENSHUJISSEKIID`=?"+
            " ORDER BY `EMPLOYEE_NO` ";

    public void getSankashaList(List<Kenshu_jukou_viewVo> list, String kenshuJissekiid) throws SQLException
    {
        try ( PreparedStatement stmt = con.prepareStatement( JUKOU_SEARCH_SQL );)
        {

            stmt.setString(1, kenshuJissekiid);
            ResultSet rset = stmt.executeQuery();

            while (rset.next())
            {
                Kenshu_jukou_viewVo vo = new  Kenshu_jukou_viewVo();

                vo.setEmployee_no(				rset.getString(	"EMPLOYEE_NO")					);
                vo.setEmployee_family_name( 	rset.getString(	"EMPLOYEE_FAMILY_NAME") 		);
                vo.setEmployee_first_name( 		rset.getString(	"EMPLOYEE_FIRST_NAME") 			);
                vo.setEmployee_family_name_kana(rset.getString(	"EMPLOYEE_FAMILY_NAME_KANA") 	);
                vo.setEmployee_first_name_kana( rset.getString(	"EMPLOYEE_FIRST_NAME_KANA") 	);
                vo.setEmail(					rset.getString("EMAIL")							);
                vo.setCell_tel_no(				rset.getString("CELL_TEL_NO")					);

                vo.setKaisaidate(				rset.getDate(	"KAISAIDATE") 			);
                vo.setKaisaidate2(				rset.getDate(	"KAISAIDATE2") 			);
                vo.setKaisaidate3(				rset.getDate(	"KAISAIDATE3") 			);
                vo.setIs_shusseki(				rset.getInt(	"IS_SHUSSEKI")			);
                vo.setIs_shusseki2(				rset.getInt(	"IS_SHUSSEKI2")			);
                vo.setIs_shusseki3(				rset.getInt(	"IS_SHUSSEKI3")			);
                vo.setNumdays(					rset.getInt(	"NUMDAYS")				);
                vo.setKessekiriyu(				rset.getString(	"KESSEKIRIYU") 			);
                vo.setKenshujissekiid(			rset.getInt(	"KENSHUJISSEKIID")		);
                vo.setTitle(					rset.getString(	"TITLE")				);
                vo.setToujitu_nenji(			rset.getLong(	"toujitu_nenji")		);
                vo.setNenji(					rset.getLong(	"nenji")				);
                vo.setChuto_ninasinenji(		rset.getInt(	"chuto_ninasinenji")	);
                vo.setGenba_joucho_emp_no(		rset.getString	("genba_joucho_emp_no")	);
                vo.setEmployee_family_name_j(	rset.getString("EMPLOYEE_FAMILY_NAME_J"));
                vo.setEmployee_first_name_j(	rset.getString("EMPLOYEE_FIRST_NAME_J")	);
                vo.setEmail_j(					rset.getString("EMAIL_J")				);


                list.add(vo);
            }
        }
    }


}
