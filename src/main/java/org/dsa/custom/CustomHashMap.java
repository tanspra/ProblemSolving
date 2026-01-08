package org.dsa.custom;

public interface CustomHashMap<K, V> {
    void insert(K key, V value);

    V remove(K key);

    V get(K key);

    int getSize();
}
