package bean;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import vo.Kenshujisseki_viewVo;
import vo.KenshumasterVo;

public class KenshuJissekiListBean implements List<Kenshujisseki_viewVo>
{
    private List<Kenshujisseki_viewVo> list;
    private List<KenshumasterVo> kenshuMasterList;

    private String prevSearchNendo;


    public String getPrevSearchNendo() {
        return prevSearchNendo;
    }

    public void setPrevSearchNendo(String prevSearchNendo) {
        this.prevSearchNendo = prevSearchNendo;
    }

    public List<Kenshujisseki_viewVo> getList() {
        return list;
    }

    public void setKenshuMasterList(List<KenshumasterVo> kenshuMasterList) {
        this.kenshuMasterList = kenshuMasterList;
    }

    public void setList(List<Kenshujisseki_viewVo> list) {
        this.list = list;
    }

    public List<KenshumasterVo> getKenshuMasterList() {
        return kenshuMasterList;
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

    public Iterator<Kenshujisseki_viewVo> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    public boolean add(Kenshujisseki_viewVo e) {
        return list.add(e);
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends Kenshujisseki_viewVo> c) {
        return list.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends Kenshujisseki_viewVo> c) {
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

    public Kenshujisseki_viewVo get(int index) {
        return list.get(index);
    }

    public Kenshujisseki_viewVo set(int index, Kenshujisseki_viewVo element) {
        return list.set(index, element);
    }

    public void add(int index, Kenshujisseki_viewVo element) {
        list.add(index, element);
    }

    public Kenshujisseki_viewVo remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    public ListIterator<Kenshujisseki_viewVo> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Kenshujisseki_viewVo> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<Kenshujisseki_viewVo> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

}
