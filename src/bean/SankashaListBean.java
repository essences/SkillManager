package bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import vo.Kenshu_jukou_viewVo;

public class SankashaListBean  implements List<Kenshu_jukou_viewVo>
{
    private List<Kenshu_jukou_viewVo> list = new ArrayList<Kenshu_jukou_viewVo>();

    /**
     * KENSHUJISSEKIID:int(10)
     */
    private int kenshujissekiid;

    /**
     * TITLE:varchar(255)
     */
    private String title;

    /**
     * NUMDAYS:int(10)
     */
    private int numdays;

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




    public int getKenshujissekiid() {
        return kenshujissekiid;
    }

    public void setKenshujissekiid(int kenshujissekiid) {
        this.kenshujissekiid = kenshujissekiid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumdays() {
        return numdays;
    }

    public void setNumdays(int numdays) {
        this.numdays = numdays;
    }

    public java.sql.Date getKaisaidate() {
        return kaisaidate;
    }

    public void setKaisaidate(java.sql.Date kaisaidate) {
        this.kaisaidate = kaisaidate;
    }

    public java.sql.Date getKaisaidate2() {
        return kaisaidate2;
    }

    public void setKaisaidate2(java.sql.Date kaisaidate2) {
        this.kaisaidate2 = kaisaidate2;
    }

    public java.sql.Date getKaisaidate3() {
        return kaisaidate3;
    }

    public void setKaisaidate3(java.sql.Date kaisaidate3) {
        this.kaisaidate3 = kaisaidate3;
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

    public Iterator<Kenshu_jukou_viewVo> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    public boolean add(Kenshu_jukou_viewVo e) {
        return list.add(e);
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends Kenshu_jukou_viewVo> c) {
        return list.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Kenshu_jukou_viewVo> c) {
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

    public Kenshu_jukou_viewVo get(int index) {
        return list.get(index);
    }

    public Kenshu_jukou_viewVo set(int index, Kenshu_jukou_viewVo element) {
        return list.set(index, element);
    }

    public void add(int index, Kenshu_jukou_viewVo element) {
        list.add(index, element);
    }

    public Kenshu_jukou_viewVo remove(int index) {
        return list.remove(index);
    }


    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    public ListIterator<Kenshu_jukou_viewVo> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Kenshu_jukou_viewVo> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Kenshu_jukou_viewVo> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

}
