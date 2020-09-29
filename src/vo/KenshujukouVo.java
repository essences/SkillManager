package vo;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Fri Aug 10 11:27:04 JST 2018
 */
import java.io.Serializable;

/**
 * KenshujukouVo.
 * @author e.hayashi
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2018/08/10	e.hayashi		Generated.
 */
public class KenshujukouVo implements Serializable{

    public static final String TABLE = "KENSHUJUKOU";

    /**
     * KENSHUJUKOUID:int(10) <Primary Key>
     */
    private int kenshujukouid;

    /**
     * IS_SHUSSEKI:int(10)
     */
    private int is_shusseki;

    /**
     * IS_SHUSSEKI2:int(10)
     */
    private int is_shusseki2;

    /**
     * IS_SHUSSEKI3:int(10)
     */
    private int is_shusseki3;

    /**
     * KENSHUJISSEKIID:int(10)
     */
    private int kenshujissekiid;

    /**
     * KESSEKIRIYU:varchar(255)
     */
    private String kessekiriyu;

    /**
     * SHAINID:varchar(255)
     */
    private String shainid;

    /**
     * SHAINNAME:varchar(255)
     */
    private String shainname;

    /**
     * TITLE:varchar(255)
     */
    private String title;

    /**
     * genba_joucho_emp_no:varchar(5)
     */
    private String genba_joucho_emp_no;

    /**
     * IS_KAKUNIN1:int(10)
     */
    private int is_kakunin1;

    /**
     * IS_KAKUNIN2:int(10)
     */
    private int is_kakunin2;

    /**
     * IS_KAKUNIN3:int(10)
     */
    private int is_kakunin3;

    /**
     * create_at:timestamp(0)
     */
    private java.sql.Timestamp create_at;

    /**
     * updated_at:timestamp(0)
     */
    private java.sql.Timestamp updated_at;

    /**
     * is_muko:varchar(1)
     */
    private String is_muko;

    private String systemNo;


    /**
    * Constractor
    */
    public KenshujukouVo(){}

    /**
    * Constractor
    * @param <code>kenshujukouid</code>
    */
    public KenshujukouVo(int kenshujukouid){
        this.kenshujukouid = kenshujukouid;
    }

    public int getKenshujukouid(){ return this.kenshujukouid; }

    public void setKenshujukouid(int kenshujukouid){ this.kenshujukouid = kenshujukouid; }

    public int getIs_shusseki(){ return this.is_shusseki; }

    public void setIs_shusseki(int is_shusseki){ this.is_shusseki = is_shusseki; }

    public int getIs_shusseki2(){ return this.is_shusseki2; }

    public void setIs_shusseki2(int is_shusseki2){ this.is_shusseki2 = is_shusseki2; }

    public int getIs_shusseki3(){ return this.is_shusseki3; }

    public void setIs_shusseki3(int is_shusseki3){ this.is_shusseki3 = is_shusseki3; }

    public int getKenshujissekiid(){ return this.kenshujissekiid; }

    public void setKenshujissekiid(int kenshujissekiid){ this.kenshujissekiid = kenshujissekiid; }

    public String getKessekiriyu(){ return this.kessekiriyu; }

    public void setKessekiriyu(String kessekiriyu){ this.kessekiriyu = kessekiriyu; }

    public String getShainid(){ return this.shainid; }

    public void setShainid(String shainid){ this.shainid = shainid; }

    public String getShainname(){ return this.shainname; }

    public void setShainname(String shainname){ this.shainname = shainname; }

    public String getTitle(){ return this.title; }

    public void setTitle(String title){ this.title = title; }

    public String getGenba_joucho_emp_no(){ return this.genba_joucho_emp_no; }

    public void setGenba_joucho_emp_no(String genba_joucho_emp_no){ this.genba_joucho_emp_no = genba_joucho_emp_no; }

    public int getIs_kakunin1(){ return this.is_kakunin1; }

    public void setIs_kakunin1(int is_kakunin1){ this.is_kakunin1 = is_kakunin1; }

    public int getIs_kakunin2(){ return this.is_kakunin2; }

    public void setIs_kakunin2(int is_kakunin2){ this.is_kakunin2 = is_kakunin2; }

    public int getIs_kakunin3(){ return this.is_kakunin3; }

    public void setIs_kakunin3(int is_kakunin3){ this.is_kakunin3 = is_kakunin3; }

    public java.sql.Timestamp getCreate_at(){ return this.create_at; }

    public void setCreate_at(java.sql.Timestamp create_at){ this.create_at = create_at; }

    public java.sql.Timestamp getUpdated_at(){ return this.updated_at; }

    public void setUpdated_at(java.sql.Timestamp updated_at){ this.updated_at = updated_at; }

    public String getIs_muko(){ return this.is_muko; }

    public void setIs_muko(String is_muko){ this.is_muko = is_muko; }




    public String getSystemNo() {
		return systemNo;
	}

	public void setSystemNo(String systemNo) {
		this.systemNo = systemNo;
	}

	public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("[KenshujukouVo:");
        buffer.append(" kenshujukouid: ");
        buffer.append(kenshujukouid);
        buffer.append(" is_shusseki: ");
        buffer.append(is_shusseki);
        buffer.append(" is_shusseki2: ");
        buffer.append(is_shusseki2);
        buffer.append(" is_shusseki3: ");
        buffer.append(is_shusseki3);
        buffer.append(" kenshujissekiid: ");
        buffer.append(kenshujissekiid);
        buffer.append(" kessekiriyu: ");
        buffer.append(kessekiriyu);
        buffer.append(" shainid: ");
        buffer.append(shainid);
        buffer.append(" shainname: ");
        buffer.append(shainname);
        buffer.append(" title: ");
        buffer.append(title);
        buffer.append(" genba_joucho_emp_no: ");
        buffer.append(genba_joucho_emp_no);
        buffer.append(" is_kakunin1: ");
        buffer.append(is_kakunin1);
        buffer.append(" is_kakunin2: ");
        buffer.append(is_kakunin2);
        buffer.append(" is_kakunin3: ");
        buffer.append(is_kakunin3);
        buffer.append(" create_at: ");
        buffer.append(create_at);
        buffer.append(" updated_at: ");
        buffer.append(updated_at);
        buffer.append(" is_muko: ");
        buffer.append(is_muko);
        buffer.append("]");
        return buffer.toString();
    }

}
