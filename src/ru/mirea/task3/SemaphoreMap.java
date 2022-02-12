package ru.mirea.task3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SemaphoreMap<K, V> implements Map<K, V> {

    private volatile Map<K, V> map = new HashMap<>();//volatile - чтобы все потоки видели последнее измененное значение ассоциативного словаря

    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public int size() {
        int mapSize = 0;
        try {
            semaphore.acquire();
            mapSize = map.size();
            semaphore.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mapSize;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = false;
        try {
            semaphore.acquire();
            empty = map.isEmpty();
            semaphore.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return empty;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean isKey = false;
        try {
            semaphore.acquire();
            isKey = map.containsKey(key);
            semaphore.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isKey;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean isValue = false;
        try {
            semaphore.acquire();
            isValue = map.containsValue(value);
            semaphore.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isValue;
    }

    @Override
    public V get(Object key) {
        V v = null;
        try {
            semaphore.acquire();
            v = map.get(key);
            semaphore.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return v;
    }

    @Override
    public V put(K key, V value) {
        V v = null;
        try {
            semaphore.acquire();
            v = map.put(key, value);
            semaphore.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return v;
    }

    @Override
    public V remove(Object key) {
        V v = null;
        try {
            semaphore.acquire();
            v = map.remove(key);
            semaphore.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return v;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        try {
            semaphore.acquire();
            map.putAll(m);
            semaphore.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            map.clear();
            semaphore.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = null;
        try {
            semaphore.acquire();
            set = map.keySet();
            semaphore.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert set != null;
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> collection = null;
        try {
            semaphore.acquire();
            collection = map.values();
            semaphore.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert collection != null;
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> setEntry = null;
        try {
            semaphore.acquire();
            setEntry = map.entrySet();
            semaphore.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert setEntry != null;
        return setEntry;
    }
}
