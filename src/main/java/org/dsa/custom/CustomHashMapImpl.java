package org.dsa.custom;

import java.util.ArrayList;
import java.util.List;

public class CustomHashMapImpl<K, V> implements CustomHashMap<K, V> {
    private List<MapNode<K, V>> buckets;
    private int size;
    private int noOfBucket;

    public CustomHashMapImpl() {
        noOfBucket = 5;
        buckets = new ArrayList<>();
        for (int i = 0; i < noOfBucket; i++) {
            buckets.add(null);
        }
    }

    @Override
    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode mapNode = new MapNode<>(key, value);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.getKey() == key) {
                head.setValue(value);
                return;
            }
            head = head.getNext();
        }
        head = buckets.get(bucketIndex);
        MapNode<K, V> newMapNode = new MapNode<>(key, value);
        size++;
        newMapNode.setNext(head);
        buckets.set(bucketIndex, newMapNode);
        if (loadFactor() > 0.75) {
            reHash();
        }
    }

    private void reHash() {
        System.out.println("Rehashing: %d buckets " + noOfBucket + " size " + size);
        List<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        noOfBucket *= 2;
        for (int i = 0; i < noOfBucket; i++) {
            buckets.add(null);
        }
        size = 0;
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> tempMapNode = temp.get(i);
            while (tempMapNode != null) {
                K key = tempMapNode.getKey();
                V value = tempMapNode.getValue();
                insert(key, value);
                tempMapNode = tempMapNode.getNext();
            }

        }
        System.out.println("Rehashed To : %d buckets " + noOfBucket + " size " + size);
    }

    @Override
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;
        while (head != null) {
            if (head.getKey().equals(key)) {
                size--;
                if (prev == null) {
                    buckets.set(bucketIndex, head.getNext());
                } else {
                    prev.setNext(head.getNext());
                }
                return head.getValue();
            }
            prev = head;
            head = head.getNext();
        }
        return null;
    }

    @Override
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.getKey().equals(key)) {
                return head.getValue();
            }
            head = head.getNext();
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % noOfBucket;
    }

    private double loadFactor() {
        return 1.0 * size / noOfBucket;
    }

}
