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
            "FROM `kyoso`.`kenshujisseki_view`\r\n" +
            "";

            //" ORDER BY `YOTEIDATE`";

    public List<Kenshujisseki_viewVo> getKenshuJissekiList(int nendo ) throws SQLException
    {
        List<Kenshujisseki_viewVo> list;

        StringBuffer sb = new StringBuffer(KENSHU_JISSEKI_SQL);

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




            list = new ArrayList<Kenshujisseki_viewVo> ();

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

        return list;
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




}
