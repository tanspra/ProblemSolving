package org.dsa.leetcode.p1;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c','f','j'}, 'j'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        char maxChar = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] == target) {
                if (mid != letters.length - 1) {
                    while(letters[mid] == letters[mid+1])mid++;
                    return letters[mid + 1];
                }
                else
                    return letters[0];
            } else if (letters[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                maxChar = letters[mid];
            }
            if(left == right){
                if(letters[left] > target)
                    maxChar = letters[left];
            }
        }
        if (maxChar == 0)
            return letters[0];
        else
            return maxChar;
    }
}
