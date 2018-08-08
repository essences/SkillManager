package vo;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Wed Aug 08 14:30:29 JST 2018
 */
import java.io.Serializable;

/**
 * Shainmaster_wo_retire_viewVo.
 * @author e.hayashi
 * @version 1.0 
 * history 
 * Symbol	Date		Person		Note
 * [1]		2018/08/08	e.hayashi		Generated.
 */
public class Shainmaster_wo_retire_viewVo implements Serializable{

	public static final String TABLE = "SHAINMASTER_WO_RETIRE_VIEW";

	/**
	 * 社員No:varchar(5)
	 */
	private String employee_no;

	/**
	 * 会社コード:char(5)
	 */
	private String company_cd;

	/**
	 * 雇用形態:char(1)
	 */
	private String employee_type;

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
	 * 部署コード:char(4)
	 */
	private String dept_cd;

	/**
	 * 事業本部名:varchar(60)
	 */
	private String group_name;

	/**
	 * 部署名:varchar(60)
	 */
	private String dept_name;

	/**
	 * 課名:varchar(60)
	 */
	private String section_name;

	/**
	 * 契約先コード:char(4)
	 */
	private String client_cd;

	/**
	 * 常駐先コード:char(4)
	 */
	private String work_place_cd;

	/**
	 * メールアドレス:varchar(256)
	 */
	private String email;

	/**
	 * 入社年月日:date(0)
	 */
	private java.sql.Date employ_date;

	/**
	 * nenji:bigint(19)
	 */
	private long nenji;

	/**
	 * 退社年月日:date(0)
	 */
	private java.sql.Date retirement_date;

	/**
	 * 更新日時:datetime(0)
	 */
	private java.sql.Timestamp update_datetime;

	/**
	 * 削除フラグ:char(1)
	 */
	private String delete_flg;

	/**
	 * 性別:char(1)
	 */
	private String gender;

	/**
	 * 生年月日:date(0)
	 */
	private java.sql.Date birth_date;

	/**
	 * age:bigint(19)
	 */
	private long age;

	/**
	 * 電話番号:varchar(11)
	 */
	private String tel_no;

	/**
	 * 携帯番号:varchar(11)
	 */
	private String cell_tel_no;

	/**
	 * 業務中電話番号:varchar(11)
	 */
	private String working_tel_no;

	/**
	 * 役職:varchar(40)
	 */
	private String position;

	/**
	 * 昇格年月日:date(0)
	 */
	private java.sql.Date upgrade_date;

	/**
	 * chuto_ninasinenji:bigint(19)
	 */
	private long chuto_ninasinenji;

	/**
	 * biko:varchar(1024)
	 */
	private String biko;

	/**
	* Constractor
	*/
	public Shainmaster_wo_retire_viewVo(){}

	public String getEmployee_no(){ return this.employee_no; }

	public void setEmployee_no(String employee_no){ this.employee_no = employee_no; }

	public String getCompany_cd(){ return this.company_cd; }

	public void setCompany_cd(String company_cd){ this.company_cd = company_cd; }

	public String getEmployee_type(){ return this.employee_type; }

	public void setEmployee_type(String employee_type){ this.employee_type = employee_type; }

	public String getEmployee_family_name(){ return this.employee_family_name; }

	public void setEmployee_family_name(String employee_family_name){ this.employee_family_name = employee_family_name; }

	public String getEmployee_first_name(){ return this.employee_first_name; }

	public void setEmployee_first_name(String employee_first_name){ this.employee_first_name = employee_first_name; }

	public String getEmployee_family_name_kana(){ return this.employee_family_name_kana; }

	public void setEmployee_family_name_kana(String employee_family_name_kana){ this.employee_family_name_kana = employee_family_name_kana; }

	public String getEmployee_first_name_kana(){ return this.employee_first_name_kana; }

	public void setEmployee_first_name_kana(String employee_first_name_kana){ this.employee_first_name_kana = employee_first_name_kana; }

	public String getDept_cd(){ return this.dept_cd; }

	public void setDept_cd(String dept_cd){ this.dept_cd = dept_cd; }

	public String getGroup_name(){ return this.group_name; }

	public void setGroup_name(String group_name){ this.group_name = group_name; }

	public String getDept_name(){ return this.dept_name; }

	public void setDept_name(String dept_name){ this.dept_name = dept_name; }

	public String getSection_name(){ return this.section_name; }

	public void setSection_name(String section_name){ this.section_name = section_name; }

	public String getClient_cd(){ return this.client_cd; }

	public void setClient_cd(String client_cd){ this.client_cd = client_cd; }

	public String getWork_place_cd(){ return this.work_place_cd; }

	public void setWork_place_cd(String work_place_cd){ this.work_place_cd = work_place_cd; }

	public String getEmail(){ return this.email; }

	public void setEmail(String email){ this.email = email; }

	public java.sql.Date getEmploy_date(){ return this.employ_date; }

	public void setEmploy_date(java.sql.Date employ_date){ this.employ_date = employ_date; }

	public long getNenji(){ return this.nenji; }

	public void setNenji(long nenji){ this.nenji = nenji; }

	public java.sql.Date getRetirement_date(){ return this.retirement_date; }

	public void setRetirement_date(java.sql.Date retirement_date){ this.retirement_date = retirement_date; }

	public java.sql.Timestamp getUpdate_datetime(){ return this.update_datetime; }

	public void setUpdate_datetime(java.sql.Timestamp update_datetime){ this.update_datetime = update_datetime; }

	public String getDelete_flg(){ return this.delete_flg; }

	public void setDelete_flg(String delete_flg){ this.delete_flg = delete_flg; }

	public String getGender(){ return this.gender; }

	public void setGender(String gender){ this.gender = gender; }

	public java.sql.Date getBirth_date(){ return this.birth_date; }

	public void setBirth_date(java.sql.Date birth_date){ this.birth_date = birth_date; }

	public long getAge(){ return this.age; }

	public void setAge(long age){ this.age = age; }

	public String getTel_no(){ return this.tel_no; }

	public void setTel_no(String tel_no){ this.tel_no = tel_no; }

	public String getCell_tel_no(){ return this.cell_tel_no; }

	public void setCell_tel_no(String cell_tel_no){ this.cell_tel_no = cell_tel_no; }

	public String getWorking_tel_no(){ return this.working_tel_no; }

	public void setWorking_tel_no(String working_tel_no){ this.working_tel_no = working_tel_no; }

	public String getPosition(){ return this.position; }

	public void setPosition(String position){ this.position = position; }

	public java.sql.Date getUpgrade_date(){ return this.upgrade_date; }

	public void setUpgrade_date(java.sql.Date upgrade_date){ this.upgrade_date = upgrade_date; }

	public long getChuto_ninasinenji(){ return this.chuto_ninasinenji; }

	public void setChuto_ninasinenji(long chuto_ninasinenji){ this.chuto_ninasinenji = chuto_ninasinenji; }

	public String getBiko(){ return this.biko; }

	public void setBiko(String biko){ this.biko = biko; }

	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[Shainmaster_wo_retire_viewVo:");
		buffer.append(" employee_no: ");
		buffer.append(employee_no);
		buffer.append(" company_cd: ");
		buffer.append(company_cd);
		buffer.append(" employee_type: ");
		buffer.append(employee_type);
		buffer.append(" employee_family_name: ");
		buffer.append(employee_family_name);
		buffer.append(" employee_first_name: ");
		buffer.append(employee_first_name);
		buffer.append(" employee_family_name_kana: ");
		buffer.append(employee_family_name_kana);
		buffer.append(" employee_first_name_kana: ");
		buffer.append(employee_first_name_kana);
		buffer.append(" dept_cd: ");
		buffer.append(dept_cd);
		buffer.append(" group_name: ");
		buffer.append(group_name);
		buffer.append(" dept_name: ");
		buffer.append(dept_name);
		buffer.append(" section_name: ");
		buffer.append(section_name);
		buffer.append(" client_cd: ");
		buffer.append(client_cd);
		buffer.append(" work_place_cd: ");
		buffer.append(work_place_cd);
		buffer.append(" email: ");
		buffer.append(email);
		buffer.append(" employ_date: ");
		buffer.append(employ_date);
		buffer.append(" nenji: ");
		buffer.append(nenji);
		buffer.append(" retirement_date: ");
		buffer.append(retirement_date);
		buffer.append(" update_datetime: ");
		buffer.append(update_datetime);
		buffer.append(" delete_flg: ");
		buffer.append(delete_flg);
		buffer.append(" gender: ");
		buffer.append(gender);
		buffer.append(" birth_date: ");
		buffer.append(birth_date);
		buffer.append(" age: ");
		buffer.append(age);
		buffer.append(" tel_no: ");
		buffer.append(tel_no);
		buffer.append(" cell_tel_no: ");
		buffer.append(cell_tel_no);
		buffer.append(" working_tel_no: ");
		buffer.append(working_tel_no);
		buffer.append(" position: ");
		buffer.append(position);
		buffer.append(" upgrade_date: ");
		buffer.append(upgrade_date);
		buffer.append(" chuto_ninasinenji: ");
		buffer.append(chuto_ninasinenji);
		buffer.append(" biko: ");
		buffer.append(biko);
		buffer.append("]");
		return buffer.toString();
	}

}
