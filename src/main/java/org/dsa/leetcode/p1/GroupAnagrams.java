package org.dsa.leetcode.p1;

import java.util.*;

public class GroupAnagrams {
  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> anar = new GroupAnagrams().groupAnagrams(strs);
    System.out.println(anar.toString());
  }
  
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    
    for (String s : strs) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String sortedKey = new String(chars);
      
      map.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(s);
    }
    
    return new ArrayList<>(map.values());
  }
  
  public List<List<String>> groupAnagrams2(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    if (strs.length <= 1) {
      List<String> str = new ArrayList<>(List.of(strs));
      result.add(str);
      return result;
    }
    boolean[] isVisited = new boolean[strs.length];
    for (int i = 0; i < strs.length; i++) {
      List<String> strList = new ArrayList<>();
      if (!isVisited[i]) {
        strList.add(strs[i]);
        isVisited[i] = true;
        
        for (int j = 1; j < strs.length; j++) {
          if (!isVisited[j]) {
            if (isBothAnagrams(strs[i], strs[j])) {
              strList.add(strs[j]);
              isVisited[j] = true;
            }
          }
        }
        result.add(strList);
      }
    }
    return result;
  }
  
  private boolean isBothAnagrams(String first, String second) {
    if (first.length() == second.length()) {
      char[] firstCharArray = first.toCharArray();
      char[] secondCharArray = second.toCharArray();
      Map<Character, Integer> firstMap = getCharMap(firstCharArray);
      Map<Character, Integer> secondtMap = getCharMap(secondCharArray);
      return firstMap.equals(secondtMap);
    } else {
      return false;
    }
  }
  
  private Map<Character, Integer> getCharMap(char[] charArray) {
    Map<Character, Integer> resultMap = new HashMap<>();
    for (char ch : charArray) {
      if (resultMap.containsKey(ch)) {
        resultMap.put(ch, resultMap.get(ch) + 1);
      } else {
        resultMap.put(ch, 1);
      }
    }
    return resultMap;
  }
}
