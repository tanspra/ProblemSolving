package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
  public static void main(String[] args) {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
//    String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
    int maxWidth = 16;
    List<String> justifiedList = new TextJustification().fullJustify(words, maxWidth);
    System.out.println(Arrays.toString(justifiedList.toArray()));
  }
  
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int n = words.length, i = 0;
    
    while (i < n) {
      int lineLen = words[i].length();
      int j = i + 1;
      // 🧱 Greedily bundle as many words as fit
      while (j < n && lineLen + 1 + words[j].length() <= maxWidth) {
        lineLen += 1 + words[j].length();
        j++;
      }
      
      int gaps = j - i - 1;
      StringBuilder line = new StringBuilder();
      
      // If last line or only one word → left justify
      if (j == n || gaps == 0) {
        for (int k = i; k < j; k++) {
          line.append(words[k]);
          if (k != j - 1) line.append(" ");
        }
        while (line.length() < maxWidth) {
          line.append(" ");
        }
      } else {
        // Distribute spaces evenly
        int totalSpaces = maxWidth - lineLen + gaps;
        int spaceWidth = totalSpaces / gaps;
        int extra = totalSpaces % gaps;
        
        for (int k = i; k < j; k++) {
          line.append(words[k]);
          if (k != j - 1) {
            int count = spaceWidth + (extra-- > 0 ? 1 : 0);
            line.append(" ".repeat(count));
          }
        }
      }
      
      result.add(line.toString());
      i = j;
    }
    return result;
  }
  
  public List<String> fullJustify2(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    
    int remainingLength = maxWidth;
    StringBuffer currentString = new StringBuffer();
    
    for (int i = 0; i < words.length; i++) {
      
      //if currentString is of maxWidth then add in result
      if (currentString.length() == maxWidth) {
        result.add(currentString.toString());
        currentString = new StringBuffer();
        remainingLength = maxWidth;
      }
      
      //if the current word length is less tahn or equal to remaining length
      if (currentString.length() == 0  && words[i].length() <= remainingLength ||
          currentString.length() > 0 && words[i].length() <= remainingLength - 1) {
        if (remainingLength == maxWidth) {
          currentString.append(words[i]);
          remainingLength -= words[i].length();
        } else {
          currentString.append(" ");
          currentString.append(words[i]);
          remainingLength -= (words[i].length() + 1);
        }
      } else {
        String[] splittedWord = currentString.toString().split(" ");
        int noOfSpace = splittedWord.length - 1;
        while (remainingLength != 0) {
          for (int j = 0; j < noOfSpace && remainingLength > 0; j++) {
            splittedWord[j] = splittedWord[j] + " ";
            remainingLength--;
          }
          if (noOfSpace == 0) {
            while (splittedWord[0].length() < maxWidth) {
              splittedWord[0] = splittedWord[0].concat(" ");
              remainingLength--;
            }
          }
        }
        currentString = new StringBuffer(String.join(" ", splittedWord));
        i--;
      }
    }
    if (currentString != null) {
      while (currentString.length() < maxWidth) {
        currentString.append(" ");
      }
      result.add(currentString.toString());
    }
    return result;
  }
}
