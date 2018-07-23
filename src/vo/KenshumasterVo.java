package vo;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Fri Jul 13 11:40:43 JST 2018
 */
import java.io.Serializable;

/**
 * KenshumasterVo.
 * @author e.hayashi
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2018/07/13	e.hayashi		Generated.
 */
public class KenshumasterVo implements Serializable{

    public static final String TABLE = "KENSHUMASTER";

    /**
     * KENSHUMASTER_ID:int(10) <Primary Key>
     */
    private int kenshumaster_id;

    /**
     * KOUSHICOMPANY:varchar(255)
     */
    private String koushicompany;

    /**
     * KOUSHINAME:varchar(255)
     */
    private String koushiname;

    /**
     * TITLE:varchar(255)
     */
    private String title;

    /**
     * BASECOST:varchar(10)
     */
    private String basecost;

    /**
     * NUMDAYS:int(10)
     */
    private int numdays;

    /**
     * IS_EACH_COST:tinyint(3)
     */
    private byte is_each_cost;

    /**
    * Constractor
    */
    public KenshumasterVo(){}

    /**
    * Constractor
    * @param <code>kenshumaster_id</code>
    */
    public KenshumasterVo(int kenshumaster_id){
        this.kenshumaster_id = kenshumaster_id;
    }

    public int getKenshumaster_id(){ return this.kenshumaster_id; }

    public void setKenshumaster_id(int kenshumaster_id){ this.kenshumaster_id = kenshumaster_id; }

    public String getKoushicompany(){ return this.koushicompany; }

    public void setKoushicompany(String koushicompany){ this.koushicompany = koushicompany; }

    public String getKoushiname(){ return this.koushiname; }

    public void setKoushiname(String koushiname){ this.koushiname = koushiname; }

    public String getTitle(){ return this.title; }

    public void setTitle(String title){ this.title = title; }

    public String getBasecost(){ return this.basecost; }

    public void setBasecost(String basecost){ this.basecost = basecost; }

    public int getNumdays(){ return this.numdays; }

    public void setNumdays(int numdays){ this.numdays = numdays; }

    public byte getIs_each_cost(){ return this.is_each_cost; }

    public void setIs_each_cost(byte is_each_cost){ this.is_each_cost = is_each_cost; }

    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("[KenshumasterVo:");
        buffer.append(" kenshumaster_id: ");
        buffer.append(kenshumaster_id);
        buffer.append(" koushicompany: ");
        buffer.append(koushicompany);
        buffer.append(" koushiname: ");
        buffer.append(koushiname);
        buffer.append(" title: ");
        buffer.append(title);
        buffer.append(" basecost: ");
        buffer.append(basecost);
        buffer.append(" numdays: ");
        buffer.append(numdays);
        buffer.append(" is_each_cost: ");
        buffer.append(is_each_cost);
        buffer.append("]");
        return buffer.toString();
    }

}
