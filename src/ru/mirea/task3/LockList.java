package ru.mirea.task3;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class LockList<E> implements List<E> {

    private List<E> list = new ArrayList<>();
    private ReentrantLock r = new ReentrantLock();


    @Override
    public int size() {
        r.lock();
        int listSize = list.size();
        r.unlock();
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        r.lock();
        boolean isListEmpty = list.isEmpty();
        r.unlock();
        return isListEmpty;
    }

    @Override
    public boolean contains(Object o) {
        r.lock();
        boolean isContains = list.contains(o);
        r.unlock();
        return isContains;
    }

    @Override
    public Iterator<E> iterator() {
        r.lock();
        Iterator<E> iterator = list.iterator();
        r.unlock();
        return iterator;
    }

    @Override
    public Object[] toArray() {
        r.lock();
        Object[] array = list.toArray();
        r.unlock();
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        r.lock();
        T[] array = list.toArray(a);
        r.unlock();
        return array;
    }

    @Override
    public boolean add(E e) {
        r.lock();
        boolean isAdded = list.add(e);
        r.unlock();
        return isAdded;
    }

    @Override
    public boolean remove(Object o) {
        r.lock();
        boolean isRemoved = list.remove(o);
        r.unlock();
        return isRemoved;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        r.lock();
        boolean isContainsAll = list.containsAll(c);
        r.unlock();
        return isContainsAll;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        r.lock();
        boolean isAddedAll = list.addAll(c);
        r.unlock();
        return isAddedAll;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        r.lock();
        boolean isAddedAll = list.addAll(index, c);
        r.unlock();
        return isAddedAll;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        r.lock();
        boolean isRemovedAll = list.removeAll(c);
        r.unlock();
        return isRemovedAll;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        r.lock();
        boolean isRetainedAll = list.retainAll(c);
        r.unlock();
        return isRetainedAll;
    }

    @Override
    public void clear() {
        r.lock();
        list.clear();
        r.unlock();

    }

    @Override
    public E get(int index) {
        r.lock();
        E element = list.get(index);
        r.unlock();
        return element;
    }

    @Override
    public E set(int index, E element) {
        r.lock();
        E elem = list.set(index, element);
        r.unlock();
        return elem;
    }

    @Override
    public void add(int index, E element) {
        r.lock();
        list.add(index, element);
        r.unlock();
    }

    @Override
    public E remove(int index) {
        r.lock();
        E removedElement = list.remove(index);
        r.unlock();
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        r.lock();
        int index = list.indexOf(o);
        r.unlock();
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        r.lock();
        int index = list.lastIndexOf(o);
        r.unlock();
        return index;
    }

    @Override
    public ListIterator<E> listIterator() {
        r.lock();
        ListIterator<E> listIterator = list.listIterator();
        r.unlock();
        return listIterator;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        r.lock();
        ListIterator<E> listIterator = list.listIterator(index);
        r.unlock();
        return listIterator;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        r.lock();
        List<E> list1 = list.subList(fromIndex, toIndex);
        r.unlock();
        return list1;
    }
}
