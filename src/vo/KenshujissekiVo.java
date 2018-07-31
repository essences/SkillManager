package vo;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed Jul 25 17:23:16 JST 2018
 */
import java.io.Serializable;

/**
 * KenshujissekiVo.
 * @author e.hayashi
 * @version 1.0 
 * history 
 * Symbol	Date		Person		Note
 * [1]		2018/07/25	e.hayashi		Generated.
 */
public class KenshujissekiVo implements Serializable{

	public static final String TABLE = "KENSHUJISSEKI";

	/**
	 * KENSHUJISSEKI:int(10) <Primary Key>
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
	 * COST:varchar(10)
	 */
	private String cost;

	/**
	 * JISSHI_ITO:varchar(256)
	 */
	private String jisshi_ito;

	/**
	 * create_at:timestamp(0)
	 */
	private java.sql.Timestamp create_at;

	/**
	 * update_at:timestamp(0)
	 */
	private java.sql.Timestamp update_at;

	/**
	* Constractor
	*/
	public KenshujissekiVo(){}

	/**
	* Constractor
	* @param <code>kenshujisseki</code>
	*/
	public KenshujissekiVo(int kenshujisseki){
		this.kenshujisseki = kenshujisseki;
	}

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

	public String getCost(){ return this.cost; }

	public void setCost(String cost){ this.cost = cost; }

	public String getJisshi_ito(){ return this.jisshi_ito; }

	public void setJisshi_ito(String jisshi_ito){ this.jisshi_ito = jisshi_ito; }

	public java.sql.Timestamp getCreate_at(){ return this.create_at; }

	public void setCreate_at(java.sql.Timestamp create_at){ this.create_at = create_at; }

	public java.sql.Timestamp getUpdate_at(){ return this.update_at; }

	public void setUpdate_at(java.sql.Timestamp update_at){ this.update_at = update_at; }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[KenshujissekiVo:");
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
		buffer.append(" cost: ");
		buffer.append(cost);
		buffer.append(" jisshi_ito: ");
		buffer.append(jisshi_ito);
		buffer.append(" create_at: ");
		buffer.append(create_at);
		buffer.append(" update_at: ");
		buffer.append(update_at);
		buffer.append("]");
		return buffer.toString();
	}

}
