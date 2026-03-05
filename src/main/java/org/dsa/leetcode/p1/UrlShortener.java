package org.dsa.leetcode.p1;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UrlShortener {
    public static void main(String[] args) {
        UrlShortener shortener = new UrlShortener();
        String shortUrl = shortener.shorten("https://leetcode.com/problems/binary-tree-paths/description/");
        System.out.println(shortUrl);
        System.out.println(shortener.expand("b"));
    }
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private AtomicLong counter = new AtomicLong(1);
    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(); // shortCode -> longURL

    // Encode integer to base62 string
    private String encodeBase62(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(BASE62.charAt((int) (num % 62)));
            num /= 62;
        }
        return sb.reverse().toString();
    }

    // Shorten URL
    public String shorten(String longUrl) {
        long id = counter.getAndIncrement();
        String code = encodeBase62(id);
        map.put(code, longUrl);
        return "http://short.url/" + code;
    }

    // Retrieve long URL
    public String expand(String code) {
        return map.getOrDefault(code, null);
    }
}
