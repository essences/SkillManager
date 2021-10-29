package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import vo.Kenshu_jukou_viewVo;
import vo.KenshujukouVo;

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
            "    `kenshu_jukou_view`.`POSITION`,\r\n" +
            "    `kenshu_jukou_view`.`TITLE`,\r\n" +
            "    `kenshu_jukou_view`.`NUMDAYS`,\r\n" +
            "    `kenshu_jukou_view`.`toujitu_nenji`,\r\n" +
            "    `kenshu_jukou_view`.`nenji`,\r\n" +
            "    `kenshu_jukou_view`.`chuto_ninasinenji`,\r\n" +
            "    `kenshu_jukou_view`.`genba_joucho_emp_no`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FAMILY_NAME_J`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FIRST_NAME_J`,\r\n" +
            "    `kenshu_jukou_view`.`EMAIL_J`,\r\n" +
            "    `kenshu_jukou_view`.`biko`,\r\n"+
            "    `kenshu_jukou_view`.`IS_KAKUNIN1`,\r\n" +
            "    `kenshu_jukou_view`.`IS_KAKUNIN2`,\r\n" +
            "    `kenshu_jukou_view`.`IS_KAKUNIN3`, \r\n" +
            "    `kenshu_jukou_view`.`GROUP_NAME`, \r\n" +
            "    `kenshu_jukou_view`.`DEPT_NAME`, \r\n" +
            "    `kenshu_jukou_view`.`MID_CAREER_FLG`\r\n" +
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
                vo.setKenshujukouid(			rset.getInt(	"KENSHUJUKOUID")				);
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
                vo.setKenshujissekiid(			rset.getInt(	"KENSHUJISSEKIID")		);
                vo.setBiko(						rset.getString(	"BIKO")					);
                vo.setIs_kakunin1(				rset.getInt(	"IS_KAKUNIN1")	);
                vo.setIs_kakunin2(				rset.getInt(	"IS_KAKUNIN2")	);
                vo.setIs_kakunin3(				rset.getInt(	"IS_KAKUNIN3")	);
                vo.setGroup_name(				rset.getString(	"GROUP_NAME")			);
                vo.setDept_name(				rset.getString(	"DEPT_NAME")			);
                vo.setMid_career_flg(			rset.getString(	"MID_CAREER_FLG")			);

                list.add( vo );
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
            "    `kenshu_jukou_view`.`POSITION`,\r\n" +
            "    `kenshu_jukou_view`.`TITLE`,\r\n" +
            "    `kenshu_jukou_view`.`NUMDAYS`,\r\n" +
            "    `kenshu_jukou_view`.`toujitu_nenji`,\r\n" +
            "    `kenshu_jukou_view`.`nenji`,\r\n" +
            "    `kenshu_jukou_view`.`chuto_ninasinenji`,\r\n" +
            "    `kenshu_jukou_view`.`genba_joucho_emp_no`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FAMILY_NAME_J`,\r\n" +
            "    `kenshu_jukou_view`.`EMPLOYEE_FIRST_NAME_J`,\r\n" +
            "    `kenshu_jukou_view`.`EMAIL_J`,\r\n" +
            "    `kenshu_jukou_view`.`biko`,\r\n"+
            "    `kenshu_jukou_view`.`IS_KAKUNIN1`,\r\n" +
            "    `kenshu_jukou_view`.`IS_KAKUNIN2`,\r\n" +
            "    `kenshu_jukou_view`.`IS_KAKUNIN3`, \r\n" +
            "    `kenshu_jukou_view`.`GROUP_NAME`, \r\n" +
            "    `kenshu_jukou_view`.`DEPT_NAME`,  \r\n" +
            "    `kenshu_jukou_view`.`MID_CAREER_FLG`  \r\n" +
            
            " FROM `kyoso`.`kenshu_jukou_view`\r\n" +
            " WHERE `KENSHUJISSEKIID`=? "+
            " ORDER BY CAST(`EMPLOYEE_FAMILY_NAME_KANA` as CHAR) ";

    public void getSankashaList(List<Kenshu_jukou_viewVo> list, String kenshuJissekiid) throws SQLException
    {
        try ( PreparedStatement stmt = con.prepareStatement( JUKOU_SEARCH_SQL );)
        {

            stmt.setString(1, kenshuJissekiid);
            ResultSet rset = stmt.executeQuery();

            while (rset.next())
            {
                Kenshu_jukou_viewVo vo = new  Kenshu_jukou_viewVo();

                vo.setKenshujukouid(			rset.getInt(	"KENSHUJUKOUID")				);
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
                vo.setPosition(					rset.getString(	"POSITION")				);
                vo.setToujitu_nenji(			rset.getLong(	"toujitu_nenji")		);
                vo.setNenji(					rset.getLong(	"nenji")				);
                vo.setChuto_ninasinenji(		rset.getInt(	"chuto_ninasinenji")	);
                vo.setGenba_joucho_emp_no(		rset.getString	("genba_joucho_emp_no")	);
                vo.setEmployee_family_name_j(	rset.getString("EMPLOYEE_FAMILY_NAME_J"));
                vo.setEmployee_first_name_j(	rset.getString("EMPLOYEE_FIRST_NAME_J")	);
                vo.setEmail_j(					rset.getString("EMAIL_J")				);
                vo.setBiko(						rset.getString(	"BIKO")					);
                vo.setIs_kakunin1(				rset.getInt(	"IS_KAKUNIN1")	);
                vo.setIs_kakunin2(				rset.getInt(	"IS_KAKUNIN2")	);
                vo.setIs_kakunin3(				rset.getInt(	"IS_KAKUNIN3")	);
                vo.setGroup_name(				rset.getString(	"GROUP_NAME")			);
                vo.setDept_name(				rset.getString(	"DEPT_NAME")			);
                vo.setMid_career_flg(			rset.getString(	"MID_CAREER_FLG")		);

                list.add(vo);
            }
        }
    }

    private static final String JUKOU_INSERT_SQL =
            "INSERT INTO `kyoso`.`kenshujukou`\r\n" +
            "(" +
            "`IS_SHUSSEKI`,\r\n" +
            "`IS_SHUSSEKI2`,\r\n" +
            "`IS_SHUSSEKI3`,\r\n" +
            "`KENSHUJISSEKIID`,\r\n" +
            "`KESSEKIRIYU`,\r\n" +
            "`EMPLOYEE_NO`,\r\n" +
            "`genba_joucho_emp_no`,\r\n" +
            "`IS_KAKUNIN1`,\r\n" +
            "`IS_KAKUNIN2`,\r\n" +
            "`IS_KAKUNIN3`,\r\n" +
            "`SYSTEM_NO`\r\n" +
            ")\r\n" +
            "VALUES" +
            "(?,?,?,?,?,?,?,?,?,?,?)"
            ;


    public void registSankasha(String kenshujissekiId, List<KenshujukouVo> list) throws SQLException
    {
        try ( PreparedStatement stmt = con.prepareStatement( JUKOU_INSERT_SQL );)
        {
            for( KenshujukouVo vo: list)
            {
                registSankasha( stmt, kenshujissekiId, vo);
            }
        }
    }


    public void registSankasha(PreparedStatement stmt, String kenshujissekiId, KenshujukouVo vo) throws SQLException
    {

        stmt.setLong(1, vo.getIs_shusseki());
        stmt.setLong(2, vo.getIs_shusseki2());
        stmt.setLong(3, vo.getIs_shusseki3());

        stmt.setString(4, kenshujissekiId);

        stmt.setString(5,  	vo.getKessekiriyu() );
        stmt.setString(6, 	vo.getShainid());

        stmt.setString(7, 	vo.getGenba_joucho_emp_no());
        stmt.setLong(8 , 	vo.getIs_kakunin1());
        stmt.setLong(9 , 	vo.getIs_kakunin2());
        stmt.setLong(10 , 	vo.getIs_kakunin3());
        stmt.setString(11, 	vo.getSystemNo());

        int i = stmt.executeUpdate();
        if( i!= 1 )
            throw new SQLException("インサートに失敗しました。");

    }

    private static final String JUKOU_UPDATE_SQL =
            "UPDATE `kyoso`.`kenshujukou`\r\n" +
            "SET\r\n" +
            "`IS_SHUSSEKI` 			= ?,\r\n" +
            "`IS_SHUSSEKI2` 		= ?,\r\n" +
            "`IS_SHUSSEKI3` 		= ?,\r\n" +
            "`KESSEKIRIYU` 			= ?,\r\n" +
            "`genba_joucho_emp_no` 	= ?,\r\n" +
            "`IS_KAKUNIN1` 			= ?,\r\n" +
            "`IS_KAKUNIN2` 			= ?,\r\n" +
            "`IS_KAKUNIN3` 			= ?,\r\n" +
            "`is_muko` 				= ?\r\n" +
            "WHERE `KENSHUJUKOUID` = ?;\r\n" +
            ""
            ;

    public void updateSankasha( List<KenshujukouVo> list) throws SQLException
    {
        try ( PreparedStatement stmt = con.prepareStatement( JUKOU_UPDATE_SQL );)
        {
            for( KenshujukouVo vo: list)
            {
                updateSankasha( stmt, vo);
            }
        }
    }

    private void updateSankasha(PreparedStatement stmt, KenshujukouVo vo) throws SQLException
    {
        stmt.setLong(1, vo.getIs_shusseki());
        stmt.setLong(2, vo.getIs_shusseki2());
        stmt.setLong(3, vo.getIs_shusseki3());
        stmt.setString(4,  vo.getKessekiriyu() );
        stmt.setString(5, vo.getGenba_joucho_emp_no());
        stmt.setLong(6 , vo.getIs_kakunin1());
        stmt.setLong(7 , vo.getIs_kakunin2());
        stmt.setLong(8 , vo.getIs_kakunin3());
        stmt.setString(9, vo.getIs_muko());
        stmt.setLong(10,  vo.getKenshujukouid());

        int i = stmt.executeUpdate();
        if( i!= 1 )
            throw new SQLException("更新に失敗しました。");
    }
}
