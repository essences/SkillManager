package vo;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Tue Jul 17 13:40:14 JST 2018
 */
import java.io.Serializable;

/**
 * Kenshujisseki_viewVo.
 * @author e.hayashi
 * @version 1.0 
 * history 
 * Symbol	Date		Person		Note
 * [1]		2018/07/17	e.hayashi		Generated.
 */
public class Kenshujisseki_viewVo implements Serializable{

	public static final String TABLE = "KENSHUJISSEKI_VIEW";

	/**
	 * KENSHUJISSEKI:int(10)
	 */
	private int kenshujisseki;

	/**
	 * KAISAIDATE:date(0)
	 */
	private java.sql.Date kaisaidate;

	/**
	 * KAISAIDATE2:date(0)
	 */
	private java.sql.Date kaisaidate2;

	/**
	 * KAISAIDATE3:date(0)
	 */
	private java.sql.Date kaisaidate3;

	/**
	 * TITLE:varchar(255)
	 */
	private String title;

	/**
	 * YOTEIDATE:date(0)
	 */
	private java.sql.Date yoteidate;

	/**
	 * YOTEIDATE2:date(0)
	 */
	private java.sql.Date yoteidate2;

	/**
	 * YOTEIDATE3:date(0)
	 */
	private java.sql.Date yoteidate3;

	/**
	 * KENSHUTYPEID:int(10)
	 */
	private int kenshutypeid;

	/**
	 * KOUSHICOMPANY:varchar(255)
	 */
	private String koushicompany;

	/**
	 * KOUSHINAME:varchar(255)
	 */
	private String koushiname;

	/**
	 * COST:varchar(10)
	 */
	private String cost;

	/**
	 * BASECOST:varchar(10)
	 */
	private String basecost;

	/**
	 * IS_EACH_COST:tinyint(3)
	 */
	private byte is_each_cost;

	/**
	 * NUMDAYS:int(10)
	 */
	private int numdays;

	/**
	 * JISSHI_ITO:varchar(256)
	 */
	private String jisshi_ito;

	/**
	 * NERAI:varchar(1023)
	 */
	private String nerai;

	/**
	 * GAIYOU:varchar(1023)
	 */
	private String gaiyou;

	/**
	* Constractor
	*/
	public Kenshujisseki_viewVo(){}

	public int getKenshujisseki(){ return this.kenshujisseki; }

	public void setKenshujisseki(int kenshujisseki){ this.kenshujisseki = kenshujisseki; }

	public java.sql.Date getKaisaidate(){ return this.kaisaidate; }

	public void setKaisaidate(java.sql.Date kaisaidate){ this.kaisaidate = kaisaidate; }

	public java.sql.Date getKaisaidate2(){ return this.kaisaidate2; }

	public void setKaisaidate2(java.sql.Date kaisaidate2){ this.kaisaidate2 = kaisaidate2; }

	public java.sql.Date getKaisaidate3(){ return this.kaisaidate3; }

	public void setKaisaidate3(java.sql.Date kaisaidate3){ this.kaisaidate3 = kaisaidate3; }

	public String getTitle(){ return this.title; }

	public void setTitle(String title){ this.title = title; }

	public java.sql.Date getYoteidate(){ return this.yoteidate; }

	public void setYoteidate(java.sql.Date yoteidate){ this.yoteidate = yoteidate; }

	public java.sql.Date getYoteidate2(){ return this.yoteidate2; }

	public void setYoteidate2(java.sql.Date yoteidate2){ this.yoteidate2 = yoteidate2; }

	public java.sql.Date getYoteidate3(){ return this.yoteidate3; }

	public void setYoteidate3(java.sql.Date yoteidate3){ this.yoteidate3 = yoteidate3; }

	public int getKenshutypeid(){ return this.kenshutypeid; }

	public void setKenshutypeid(int kenshutypeid){ this.kenshutypeid = kenshutypeid; }

	public String getKoushicompany(){ return this.koushicompany; }

	public void setKoushicompany(String koushicompany){ this.koushicompany = koushicompany; }

	public String getKoushiname(){ return this.koushiname; }

	public void setKoushiname(String koushiname){ this.koushiname = koushiname; }

	public String getCost(){ return this.cost; }

	public void setCost(String cost){ this.cost = cost; }

	public String getBasecost(){ return this.basecost; }

	public void setBasecost(String basecost){ this.basecost = basecost; }

	public byte getIs_each_cost(){ return this.is_each_cost; }

	public void setIs_each_cost(byte is_each_cost){ this.is_each_cost = is_each_cost; }

	public int getNumdays(){ return this.numdays; }

	public void setNumdays(int numdays){ this.numdays = numdays; }

	public String getJisshi_ito(){ return this.jisshi_ito; }

	public void setJisshi_ito(String jisshi_ito){ this.jisshi_ito = jisshi_ito; }

	public String getNerai(){ return this.nerai; }

	public void setNerai(String nerai){ this.nerai = nerai; }

	public String getGaiyou(){ return this.gaiyou; }

	public void setGaiyou(String gaiyou){ this.gaiyou = gaiyou; }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[Kenshujisseki_viewVo:");
		buffer.append(" kenshujisseki: ");
		buffer.append(kenshujisseki);
		buffer.append(" kaisaidate: ");
		buffer.append(kaisaidate);
		buffer.append(" kaisaidate2: ");
		buffer.append(kaisaidate2);
		buffer.append(" kaisaidate3: ");
		buffer.append(kaisaidate3);
		buffer.append(" title: ");
		buffer.append(title);
		buffer.append(" yoteidate: ");
		buffer.append(yoteidate);
		buffer.append(" yoteidate2: ");
		buffer.append(yoteidate2);
		buffer.append(" yoteidate3: ");
		buffer.append(yoteidate3);
		buffer.append(" kenshutypeid: ");
		buffer.append(kenshutypeid);
		buffer.append(" koushicompany: ");
		buffer.append(koushicompany);
		buffer.append(" koushiname: ");
		buffer.append(koushiname);
		buffer.append(" cost: ");
		buffer.append(cost);
		buffer.append(" basecost: ");
		buffer.append(basecost);
		buffer.append(" is_each_cost: ");
		buffer.append(is_each_cost);
		buffer.append(" numdays: ");
		buffer.append(numdays);
		buffer.append(" jisshi_ito: ");
		buffer.append(jisshi_ito);
		buffer.append(" nerai: ");
		buffer.append(nerai);
		buffer.append(" gaiyou: ");
		buffer.append(gaiyou);
		buffer.append("]");
		return buffer.toString();
	}

}
