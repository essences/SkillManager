package bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import vo.Kenshu_jukou_viewVo;

public class JukouListBean implements List<Kenshu_jukou_viewVo>
{
    private List<Kenshu_jukou_viewVo> list = new ArrayList<Kenshu_jukou_viewVo>();



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
     * nenji:bigint(19)
     */
    private long nenji;

    /**
     * みなし年次:int(10)
     */
    private int chuto_ninasinenji;



    public long getNenji() {
        return nenji;
    }

    public void setNenji(long nenji) {
        this.nenji = nenji;
    }

    public int getChuto_ninasinenji() {
        return chuto_ninasinenji;
    }

    public void setChuto_ninasinenji(int chuto_ninasinenji) {
        this.chuto_ninasinenji = chuto_ninasinenji;
    }

    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public String getEmployee_family_name() {
        return employee_family_name;
    }

    public void setEmployee_family_name(String employee_family_name) {
        this.employee_family_name = employee_family_name;
    }

    public String getEmployee_first_name() {
        return employee_first_name;
    }

    public void setEmployee_first_name(String employee_first_name) {
        this.employee_first_name = employee_first_name;
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
