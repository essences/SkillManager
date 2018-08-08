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


    Map<String,String> checkJizenShusseki1EmpNoMap = new HashMap<String,String>();
    Map<String,String> checkJizenShusseki2EmpNoMap = new HashMap<String,String>();
    Map<String,String> checkJizenShusseki3EmpNoMap = new HashMap<String,String>();

    Map<String,String> checkToujitsuShusseki1EmpNoMap = new HashMap<String,String>();
    Map<String,String> checkToujitsuShusseki2EmpNoMap = new HashMap<String,String>();
    Map<String,String> checkToujitsuShusseki3EmpNoMap = new HashMap<String,String>();

    public String getJizenShusseki1(String key) {
        return checkJizenShusseki1EmpNoMap.get(key);
    }

    public String putJizenShusseki1(String key, String value) {
        return checkJizenShusseki1EmpNoMap.put(key, value);
    }
    public String getJizenShusseki2(String key) {
        return checkJizenShusseki2EmpNoMap.get(key);
    }

    public String putJizenShusseki2(String key, String value) {
        return checkJizenShusseki2EmpNoMap.put(key, value);
    }
    public String getJizenShusseki3(String key) {
        return checkJizenShusseki3EmpNoMap.get(key);
    }

    public String putJizenShusseki3(String key, String value) {
        return checkJizenShusseki3EmpNoMap.put(key, value);
    }

    public String getToujitsuShusseki1(String key) {
        return checkToujitsuShusseki1EmpNoMap.get(key);
    }

    public String putToujitsuShusseki1(String key, String value) {
        return checkToujitsuShusseki1EmpNoMap.put(key, value);
    }
    public String getToujitsuShusseki2(String key) {
        return checkToujitsuShusseki2EmpNoMap.get(key);
    }

    public String putToujitsuShusseki2(String key, String value) {
        return checkToujitsuShusseki2EmpNoMap.put(key, value);
    }
    public String getToujitsuShusseki3(String key) {
        return checkToujitsuShusseki3EmpNoMap.get(key);
    }

    public String putToujitsuShusseki3(String key, String value) {
        return checkToujitsuShusseki3EmpNoMap.put(key, value);
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
