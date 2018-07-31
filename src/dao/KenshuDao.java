package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Kenshujisseki_viewVo;
import vo.KenshumasterVo;

public class KenshuDao extends Dao
{
    public KenshuDao(Connection con)
    {
        super( con );
    }


    private static final String KENSHU_JISSEKI_LIST_SQL =
            "SELECT `kenshujisseki_view`.`KENSHUJISSEKI`,\r\n" +
            "    `kenshujisseki_view`.`KAISAIDATE`,\r\n" +
            "    `kenshujisseki_view`.`KAISAIDATE2`,\r\n" +
            "    `kenshujisseki_view`.`KAISAIDATE3`,\r\n" +
            "    `kenshujisseki_view`.`TITLE`,\r\n" +
            "    `kenshujisseki_view`.`YOTEIDATE`,\r\n" +
            "    `kenshujisseki_view`.`YOTEIDATE2`,\r\n" +
            "    `kenshujisseki_view`.`YOTEIDATE3`,\r\n" +
            "    `kenshujisseki_view`.`KENSHUTYPEID`,\r\n" +
            "    `kenshujisseki_view`.`KOUSHICOMPANY`,\r\n" +
            "    `kenshujisseki_view`.`KOUSHINAME`,\r\n" +
            "    `kenshujisseki_view`.`COST`,\r\n" +
            "    `kenshujisseki_view`.`BASECOST`,\r\n" +
            "    `kenshujisseki_view`.`IS_EACH_COST`,\r\n" +
            "    `kenshujisseki_view`.`NUMDAYS`,\r\n" +
            "    `kenshujisseki_view`.`JISSHI_ITO`,\r\n" +
            "    `kenshujisseki_view`.`NERAI`,\r\n" +
            "    `kenshujisseki_view`.`GAIYOU`\r\n" +
            "FROM `kyoso`.`kenshujisseki_view`\r\n" +
            "";

            //" ORDER BY `YOTEIDATE`";

    public void getKenshuJissekiList(int nendo ,List<Kenshujisseki_viewVo> list )
            throws SQLException
    {

        StringBuffer sb = new StringBuffer(KENSHU_JISSEKI_LIST_SQL);

        if( nendo!= 0 )
        {
            sb.append(" WHERE ");
            sb.append(" `YOTEIDATE` >  '" + (nendo) +"-03-31' "
                        + "AND `YOTEIDATE` < '" + (nendo+1) + "-04-01'");
        }
        sb.append(" ORDER BY `YOTEIDATE`");

        System.out.println(sb.toString());

        try ( PreparedStatement stmt = con.prepareStatement( sb.toString() );)
        {
            ResultSet rset = stmt.executeQuery();

            while (rset.next())
            {
                Kenshujisseki_viewVo vo = new  Kenshujisseki_viewVo();
                vo.setKenshujisseki(	rset.getInt(	"KENSHUJISSEKI"));

                vo.setKoushicompany( 	rset.getString	("KOUSHICOMPANY")	);
                vo.setKoushiname(		rset.getString(	"KOUSHINAME")	);
                vo.setTitle(			rset.getString(	"TITLE")			);
                vo.setBasecost(			rset.getString(	"BASECOST")		);
                vo.setNumdays(			rset.getInt(	"NUMDAYS")			);
                vo.setIs_each_cost(		rset.getByte(	"IS_EACH_COST")	);
                vo.setYoteidate(		rset.getDate(	"YOTEIDATE")		);
                vo.setYoteidate2(		rset.getDate(	"YOTEIDATE2")		);
                vo.setYoteidate3(		rset.getDate(	"YOTEIDATE3")		);

                vo.setKaisaidate(		rset.getDate(	"KAISAIDATE") 			);
                vo.setKaisaidate2(		rset.getDate(	"KAISAIDATE2") 			);
                vo.setKaisaidate3(		rset.getDate(	"KAISAIDATE3") 			);

                vo.setNumdays(			rset.getInt(	"NUMDAYS")				);
                vo.setTitle(			rset.getString(	"TITLE")				);
                vo.setJisshi_ito(		rset.getString(	"JISSHI_ITO")			);

                list.add(vo);
            }
        }


    }

    public List<Kenshujisseki_viewVo> getKenshuJissekiList(int nendo ) throws SQLException
    {
        List<Kenshujisseki_viewVo> list;
        list = new ArrayList<Kenshujisseki_viewVo> ();
        getKenshuJissekiList( nendo,  list);

        return list;
    }

    private static final String KENSHU_JISSEKI_SQL =
            "SELECT `kenshujisseki_view`.`KENSHUJISSEKI`,\r\n" +
            "    `kenshujisseki_view`.`KAISAIDATE`,\r\n" +
            "    `kenshujisseki_view`.`KAISAIDATE2`,\r\n" +
            "    `kenshujisseki_view`.`KAISAIDATE3`,\r\n" +
            "    `kenshujisseki_view`.`TITLE`,\r\n" +
            "    `kenshujisseki_view`.`YOTEIDATE`,\r\n" +
            "    `kenshujisseki_view`.`YOTEIDATE2`,\r\n" +
            "    `kenshujisseki_view`.`YOTEIDATE3`,\r\n" +
            "    `kenshujisseki_view`.`KENSHUTYPEID`,\r\n" +
            "    `kenshujisseki_view`.`KOUSHICOMPANY`,\r\n" +
            "    `kenshujisseki_view`.`KOUSHINAME`,\r\n" +
            "    `kenshujisseki_view`.`COST`,\r\n" +
            "    `kenshujisseki_view`.`BASECOST`,\r\n" +
            "    `kenshujisseki_view`.`IS_EACH_COST`,\r\n" +
            "    `kenshujisseki_view`.`NUMDAYS`,\r\n" +
            "    `kenshujisseki_view`.`JISSHI_ITO`,\r\n" +
            "    `kenshujisseki_view`.`NERAI`,\r\n" +
            "    `kenshujisseki_view`.`GAIYOU`\r\n" +
            "FROM `kyoso`.`kenshujisseki_view`;\r\n" +
            "";

            //" ORDER BY `YOTEIDATE`";

    public Kenshujisseki_viewVo getKenshuJisseki(String  kenshuJissekiId ) throws SQLException
    {

        Kenshujisseki_viewVo vo = new  Kenshujisseki_viewVo();
        StringBuffer sb = new StringBuffer(KENSHU_JISSEKI_SQL);

        sb.append(" WHERE ");
        sb.append(" KENSHUJISSEKI = ?;");

        System.out.println(sb.toString());

        try ( PreparedStatement stmt = con.prepareStatement( sb.toString() );)
        {

            stmt.setString(1, kenshuJissekiId );

            ResultSet rset = stmt.executeQuery();

            while (rset.next())
            {

                vo.setKenshujisseki(	rset.getInt(	"KENSHUJISSEKI"));

                vo.setKoushicompany( 	rset.getString	("KOUSHICOMPANY")	);
                vo.setKoushiname(		rset.getString(	"KOUSHINAME")	);
                vo.setTitle(			rset.getString(	"TITLE")			);
                vo.setBasecost(			rset.getString(	"BASECOST")		);
                vo.setNumdays(			rset.getInt(	"NUMDAYS")			);
                vo.setIs_each_cost(		rset.getByte(	"IS_EACH_COST")	);
                vo.setYoteidate(		rset.getDate(	"YOTEIDATE")		);
                vo.setYoteidate2(		rset.getDate(	"YOTEIDATE2")		);
                vo.setYoteidate3(		rset.getDate(	"YOTEIDATE3")		);

                vo.setKaisaidate(		rset.getDate(	"KAISAIDATE") 			);
                vo.setKaisaidate2(		rset.getDate(	"KAISAIDATE2") 			);
                vo.setKaisaidate3(		rset.getDate(	"KAISAIDATE3") 			);

                vo.setNumdays(			rset.getInt(	"NUMDAYS")				);
                vo.setTitle(			rset.getString(	"TITLE")				);
                vo.setJisshi_ito(		rset.getString(	"JISSHI_ITO")			);

            }
        }

        return vo;
    }



    private static final String KENSHU_MASTER_SQL =
            "SELECT `kenshumaster`.`KENSHUMASTER_ID`,\r\n" +
            "    `kenshumaster`.`KOUSHICOMPANY`,\r\n" +
            "    `kenshumaster`.`KOUSHINAME`,\r\n" +
            "    `kenshumaster`.`TITLE`,\r\n" +
            "    `kenshumaster`.`BASECOST`,\r\n" +
            "    `kenshumaster`.`NUMDAYS`,\r\n" +
            "    `kenshumaster`.`IS_EACH_COST`\r\n" +
            "FROM `kyoso`.`kenshumaster`;\r\n" +
            "";

    public List<KenshumasterVo> getKenshuMasterList( ) throws SQLException
    {
        List<KenshumasterVo> list;
        try ( PreparedStatement stmt = con.prepareStatement( KENSHU_MASTER_SQL );)
        {

            list = new ArrayList<KenshumasterVo> ();

            ResultSet rset = stmt.executeQuery();

            while (rset.next())
            {
                KenshumasterVo vo = new  KenshumasterVo();

                vo.setKenshumaster_id( 	rset.getInt("KENSHUMASTER_ID")	);
                vo.setKoushicompany( 	rset.getString("KOUSHICOMPANY")	);
                vo.setKoushiname(		rset.getString("KOUSHINAME")	);
                vo.setTitle(			rset.getString("TITLE")			);
                vo.setBasecost(			rset.getString("BASECOST")		);
                vo.setNumdays(			rset.getInt("NUMDAYS")			);
                vo.setIs_each_cost(		rset.getByte("IS_EACH_COST")	);

                list.add(vo);
            }
        }

        return list;
    }




    private static final String KENSHUJISSEKI_INSERT_SQL =
            "INSERT INTO `kyoso`.`kenshujisseki`\r\n" +
            "(`YOTEIDATE`,\r\n" +
            "`YOTEIDATE2`,\r\n" +
            "`YOTEIDATE3`,\r\n" +
            "`KENSHUTYPEID`,\r\n" +
            "`JISSHI_ITO` )\r\n" +
            "VALUES\r\n" +
            "("
            + "STR_TO_DATE(?,'%Y-%m-%d'),";


    public void registKenshu(
            String parameter,
            String parameter2,
            String parameter3,
            String parameter4,
            String parameter5
            ) throws SQLException
    {
        StringBuffer sb = new StringBuffer(KENSHUJISSEKI_INSERT_SQL);


        if( !parameter3.equals("") )
        {
            sb.append("STR_TO_DATE( \"" +  parameter3 + "\" ,'%Y-%m-%d'),");
        }
        else
        {
            sb.append("NULL,");
        }
        if( !parameter4.equals("") )
        {
            sb.append("STR_TO_DATE( \"" +  parameter4 + "\" ,'%Y-%m-%d'),");
        }
        else
        {
            sb.append("NULL,");
        }

        sb.append("?,?);");

        System.out.println(sb.toString());



        try ( PreparedStatement stmt = con.prepareStatement( sb.toString() );)
        {
            stmt.setString(1, parameter2 );


            stmt.setString(2, parameter );
            stmt.setString(3, parameter5 );

            stmt.executeUpdate();

        }


    }
}
