package bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.SearchSort;
import domain.SearchType;
import vo.Kenshujisseki_viewVo;
import vo.Shainmaster_wo_retire_viewVo;

public class ListBean
{
    private List<Shainmaster_wo_retire_viewVo> list = new ArrayList<Shainmaster_wo_retire_viewVo>();
    private List<Kenshujisseki_viewVo> kenshuList = new ArrayList<Kenshujisseki_viewVo>();


    public List<Kenshujisseki_viewVo> getKenshuList() {
        return kenshuList;
    }

    Map<String,String> checkEmpNoMap = new HashMap<String,String>();
    public String get(Object key) {
        return checkEmpNoMap.get(key);
    }

    public String put(String key, String value) {
        return checkEmpNoMap.put(key, value);
    }


    Map<String,String> checkJizenShussekiEmpNoMap = new HashMap<String,String>();
    public String getJizenShussseki(Object key) {
        return checkJizenShussekiEmpNoMap.get(key);
    }

    public String putJizenShussseki(String key, String value) {
        return checkJizenShussekiEmpNoMap.put(key, value);
    }


    Map<String,String> checkToujitsuShussekiEmpNoMap = new HashMap<String,String>();
    public String getToujitsuShussseki(Object key) {
        return checkToujitsuShussekiEmpNoMap.get(key);
    }

    public String putToujitsuShussseki(String key, String value) {
        return checkToujitsuShussekiEmpNoMap.put(key, value);
    }


    private SearchSort prevSearchSort;

    private SearchType prevSearchType;

    private String prevsearchJoken;


    private String nendo;//=Integer.toString(LocalDate.now().getYear());
    public String getPrevSearchNendo()
    {
        return nendo;
    }

    public void setPrevSearchNendo(String nend1)
    {
        this.nendo = nend1;
    }
    public SearchSort getPrevSearchSort() {
        return prevSearchSort;
    }

    public void setPrevSearchSort(SearchSort prevSearchSort) {
        this.prevSearchSort = prevSearchSort;
    }

    public SearchType getPrevSearchType() {
        return prevSearchType;
    }

    public void setPrevSearchType(SearchType prevSearchType) {
        this.prevSearchType = prevSearchType;
    }

    public String getPrevsearchJoken() {
        return prevsearchJoken;
    }

    public void setPrevsearchJoken(String prevsearchJoken) {
        this.prevsearchJoken = prevsearchJoken;
    }




    public List<Shainmaster_wo_retire_viewVo> getList() {
        return list;
    }

    public String getCSV()
    {
        StringBuilder sb = new StringBuilder();



        for(Shainmaster_wo_retire_viewVo vo :  list )
        {


        }
        return sb.toString();
    }



}
