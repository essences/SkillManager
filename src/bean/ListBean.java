package bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import domain.SearchSort;
import domain.SearchType;
import vo.Shainmaster_wo_retire_viewVo;

public class ListBean implements List<Shainmaster_wo_retire_viewVo>
{
    private List<Shainmaster_wo_retire_viewVo> list = new ArrayList<Shainmaster_wo_retire_viewVo>();

    Map<String,String> checkEmpNoMap = new HashMap<String,String>();

    private SearchSort prevSearchSort;

    private SearchType prevSearchType;

    private String prevsearchJoken;


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

    public String get(Object key) {
        return checkEmpNoMap.get(key);
    }

    public String put(String key, String value) {
        return checkEmpNoMap.put(key, value);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(Object o) {
        return list.contains(o);
    }

    public Iterator<Shainmaster_wo_retire_viewVo> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    public boolean add(Shainmaster_wo_retire_viewVo e) {
        return list.add(e);
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends Shainmaster_wo_retire_viewVo> c) {
        return list.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Shainmaster_wo_retire_viewVo> c) {
        return list.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    public void clear() {
        list.clear();
    }

    public boolean equals(Object o) {
        return list.equals(o);
    }

    public int hashCode() {
        return list.hashCode();
    }

    public Shainmaster_wo_retire_viewVo get(int index) {
        return list.get(index);
    }

    public Shainmaster_wo_retire_viewVo set(int index, Shainmaster_wo_retire_viewVo element) {
        return list.set(index, element);
    }

    public void add(int index, Shainmaster_wo_retire_viewVo element) {
        list.add(index, element);
    }

    public Shainmaster_wo_retire_viewVo remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    public ListIterator<Shainmaster_wo_retire_viewVo> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Shainmaster_wo_retire_viewVo> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Shainmaster_wo_retire_viewVo> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
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
