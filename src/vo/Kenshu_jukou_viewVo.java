package vo;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Thu Aug 09 13:22:33 JST 2018
 */
import java.io.Serializable;

/**
 * Kenshu_jukou_viewVo.
 * @author e.hayashi
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2018/08/09	e.hayashi		Generated.
 */
public class Kenshu_jukou_viewVo implements Serializable{

    public static final String TABLE = "KENSHU_JUKOU_VIEW";

    /**
     * KENSHUJUKOUID:int(10)
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
     * KENSHUJISSEKIID:int(10)
     */
    private int kenshujissekiid;

    /**
     * KESSEKIRIYU:varchar(255)
     */
    private String kessekiriyu;

    /**
     * EMPLOYEE_NO:varchar(255)
     */
    private String employee_no;

    /**
     * 名前_姓:varchar(40)
     */
    private String employee_family_name;

    /**
     * 名前_名:varchar(40)
     */
    private String employee_first_name;

    /**
     * フリガナ_セイ:varchar(40)
     */
    private String employee_family_name_kana;

    /**
     * フリガナ_メイ:varchar(40)
     */
    private String employee_first_name_kana;

    /**
     * メールアドレス:varchar(256)
     */
    private String email;

    /**
     * 携帯番号:varchar(11)
     */
    private String cell_tel_no;

    
    private String  position;
    
    /**
     * TITLE:varchar(255)
     */
    private String title;

    /**
     * NUMDAYS:int(10)
     */
    private int numdays;

    /**
     * toujitu_nenji:bigint(19)
     */
    private long toujitu_nenji;

    /**
     * nenji:bigint(19)
     */
    private long nenji;

    /**
     * chuto_ninasinenji:bigint(19)
     */
    private long chuto_ninasinenji;

    /**
     * genba_joucho_emp_no:varchar(5)
     */
    private String genba_joucho_emp_no;

    /**
     * 名前_姓:varchar(40)
     */
    private String employee_family_name_j;

    /**
     * 名前_名:varchar(40)
     */
    private String employee_first_name_j;

    /**
     * メールアドレス:varchar(256)
     */
    private String email_j;

    /**
     * biko:varchar(1024)
     */
    private String biko;

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
     * 事業本部名:varchar(60)
     */
    private String group_name;

    //`MID_CAREER_FLG`
  	private String mid_career_flg;
  	
  	
  	public String getMid_career_flg() {
  		return mid_career_flg;
  	}

  	public void setMid_career_flg(String mid_career_flg) {
  		this.mid_career_flg = mid_career_flg;
  	}


    /**
     * 部署名:varchar(60)
     */
    private String dept_name;

    public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	/**
    * Constractor
    */
    public Kenshu_jukou_viewVo(){}

    
    
    public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public int getKenshujukouid(){ return this.kenshujukouid; }

    public void setKenshujukouid(int kenshujukouid){ this.kenshujukouid = kenshujukouid; }

    public int getIs_shusseki(){ return this.is_shusseki; }

    public void setIs_shusseki(int is_shusseki){ this.is_shusseki = is_shusseki; }

    public int getIs_shusseki2(){ return this.is_shusseki2; }

    public void setIs_shusseki2(int is_shusseki2){ this.is_shusseki2 = is_shusseki2; }

    public int getIs_shusseki3(){ return this.is_shusseki3; }

    public void setIs_shusseki3(int is_shusseki3){ this.is_shusseki3 = is_shusseki3; }

    public java.sql.Date getKaisaidate(){ return this.kaisaidate; }

    public void setKaisaidate(java.sql.Date kaisaidate){ this.kaisaidate = kaisaidate; }

    public java.sql.Date getKaisaidate2(){ return this.kaisaidate2; }

    public void setKaisaidate2(java.sql.Date kaisaidate2){ this.kaisaidate2 = kaisaidate2; }

    public java.sql.Date getKaisaidate3(){ return this.kaisaidate3; }

    public void setKaisaidate3(java.sql.Date kaisaidate3){ this.kaisaidate3 = kaisaidate3; }

    public int getKenshujissekiid(){ return this.kenshujissekiid; }

    public void setKenshujissekiid(int kenshujissekiid){ this.kenshujissekiid = kenshujissekiid; }

    public String getKessekiriyu(){ return this.kessekiriyu; }

    public void setKessekiriyu(String kessekiriyu){ this.kessekiriyu = kessekiriyu; }

    public String getEmployee_no(){ return this.employee_no; }

    public void setEmployee_no(String employee_no){ this.employee_no = employee_no; }

    public String getEmployee_family_name(){ return this.employee_family_name; }

    public void setEmployee_family_name(String employee_family_name){ this.employee_family_name = employee_family_name; }

    public String getEmployee_first_name(){ return this.employee_first_name; }

    public void setEmployee_first_name(String employee_first_name){ this.employee_first_name = employee_first_name; }

    public String getEmployee_family_name_kana(){ return this.employee_family_name_kana; }

    public void setEmployee_family_name_kana(String employee_family_name_kana){ this.employee_family_name_kana = employee_family_name_kana; }

    public String getEmployee_first_name_kana(){ return this.employee_first_name_kana; }

    public void setEmployee_first_name_kana(String employee_first_name_kana){ this.employee_first_name_kana = employee_first_name_kana; }

    public String getEmail(){ return this.email; }

    public void setEmail(String email){ this.email = email; }

    public String getCell_tel_no(){ return this.cell_tel_no; }

    public void setCell_tel_no(String cell_tel_no){ this.cell_tel_no = cell_tel_no; }

    public String getTitle(){ return this.title; }

    public void setTitle(String title){ this.title = title; }

    public int getNumdays(){ return this.numdays; }

    public void setNumdays(int numdays){ this.numdays = numdays; }

    public long getToujitu_nenji(){ return this.toujitu_nenji; }

    public void setToujitu_nenji(long toujitu_nenji){ this.toujitu_nenji = toujitu_nenji; }

    public long getNenji(){ return this.nenji; }

    public void setNenji(long nenji){ this.nenji = nenji; }

    public long getChuto_ninasinenji(){ return this.chuto_ninasinenji; }

    public void setChuto_ninasinenji(long chuto_ninasinenji){ this.chuto_ninasinenji = chuto_ninasinenji; }

    public String getGenba_joucho_emp_no(){ return this.genba_joucho_emp_no; }

    public void setGenba_joucho_emp_no(String genba_joucho_emp_no){ this.genba_joucho_emp_no = genba_joucho_emp_no; }

    public String getEmployee_family_name_j(){ return this.employee_family_name_j; }

    public void setEmployee_family_name_j(String employee_family_name_j){ this.employee_family_name_j = employee_family_name_j; }

    public String getEmployee_first_name_j(){ return this.employee_first_name_j; }

    public void setEmployee_first_name_j(String employee_first_name_j){ this.employee_first_name_j = employee_first_name_j; }

    public String getEmail_j(){ return this.email_j; }

    public void setEmail_j(String email_j){ this.email_j = email_j; }

    public String getBiko(){ return this.biko; }

    public void setBiko(String biko){ this.biko = biko; }

    public int getIs_kakunin1(){ return this.is_kakunin1; }

    public void setIs_kakunin1(int is_kakunin1){ this.is_kakunin1 = is_kakunin1; }

    public int getIs_kakunin2(){ return this.is_kakunin2; }

    public void setIs_kakunin2(int is_kakunin2){ this.is_kakunin2 = is_kakunin2; }

    public int getIs_kakunin3(){ return this.is_kakunin3; }

    public void setIs_kakunin3(int is_kakunin3){ this.is_kakunin3 = is_kakunin3; }

    public String getDept_name(){ return this.dept_name; }

    public void setDept_name(String dept_name){ this.dept_name = dept_name; }

	@Override
	public String toString() {
		return "Kenshu_jukou_viewVo [kenshujukouid=" + kenshujukouid + ", is_shusseki=" + is_shusseki
				+ ", is_shusseki2=" + is_shusseki2 + ", is_shusseki3=" + is_shusseki3 + ", kaisaidate=" + kaisaidate
				+ ", kaisaidate2=" + kaisaidate2 + ", kaisaidate3=" + kaisaidate3 + ", kenshujissekiid="
				+ kenshujissekiid + ", kessekiriyu=" + kessekiriyu + ", employee_no=" + employee_no
				+ ", employee_family_name=" + employee_family_name + ", employee_first_name=" + employee_first_name
				+ ", employee_family_name_kana=" + employee_family_name_kana + ", employee_first_name_kana="
				+ employee_first_name_kana + ", email=" + email + ", cell_tel_no=" + cell_tel_no + ", position="
				+ position + ", title=" + title + ", numdays=" + numdays + ", toujitu_nenji=" + toujitu_nenji
				+ ", nenji=" + nenji + ", chuto_ninasinenji=" + chuto_ninasinenji + ", genba_joucho_emp_no="
				+ genba_joucho_emp_no + ", employee_family_name_j=" + employee_family_name_j
				+ ", employee_first_name_j=" + employee_first_name_j + ", email_j=" + email_j + ", biko=" + biko
				+ ", is_kakunin1=" + is_kakunin1 + ", is_kakunin2=" + is_kakunin2 + ", is_kakunin3=" + is_kakunin3
				+ ", group_name=" + group_name + ", mid_career_flg=" + mid_career_flg + ", dept_name=" + dept_name
				+ "]";
	}

    

}
