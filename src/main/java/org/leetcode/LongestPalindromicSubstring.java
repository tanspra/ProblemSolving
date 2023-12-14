package org.leetcode;

/*https://leetcode.com/problems/longest-palindromic-substring/
*
* 5. Longest Palindromic Substring
Medium
Topics
Companies
Hint
Given a string s, return the longest
palindromic

substring
 in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
* */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("thelviymgkeddreyviespjsyqwmbmnlwzjhdokfzrczvreiagayofwvhecskjqlqzodtozvzozqyiwfsjyrinrmgfyhplybonzuvmxxyihmggwiuccplqjtgschmieoexvtewbsjqzkzapfxpzhgjtbmlchevohmxnbattphvobptnhmcoihcaimchurqpucxapojgszpopdvsfahwidiyxlpjfhdkcoewzvlmaebudtovnvcuadykhhmwfpilqfdvnseiitokcbuxmhwukrdxwvtgztczrwcsydqwosnktronibiplbljrcpinqorbhxrwjonnqeniebrksjkcmbvjnuwdedoenqmrcxayqbzmlpbubnfnkkqnuljtchaeijcmfpyuxkgfssoqliqmhowtbmcvzkqbanxhowjjejexxlihwwhilxxejejjwohxnabqkzvcmbtwohmqilqossfgkxuypfmcjieahctjlunqkknfnbubplmzbqyaxcrmqneodedwunjvbmckjskrbeineqnnojwrxhbroqnipcrjlblpibinortknsowqdyscwrzctzgtvwxdrkuwhmxubckotiiesnvdfqlipfwmhhkydaucvnvotdubeamlvzweockdhfjplxyidiwhafsvdpopzsgjopaxcupqruhcmiachiocmhntpbovhpttabnxmhovehclmbtjghzpxfpazkzqjsbwetvxeoeimhcsgtjqlpccuiwggmhiyxxmvuznobylphyfgmrniryjsfwiyqzozvzotdozqlqjkscehvwfoyagaiervzcrzfkodhjzwlnmbmwqysjpseivyerddekgmyivleht"));
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int maxLength = 1;
        String maxStr = s.substring(0, 1);
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLength; j <= len; j++) {
                if (j - i > maxLength && isPalindrome(s.substring(i, j))) {
                    maxStr = s.substring(i, j);
                    maxLength = j - i;
                }
            }

        }
        return maxStr;
    }

//    public String longestPalindrome(String s) {
//        List<String> palindromeList = new ArrayList<>();
//        int start = 0;
//        int len = s.length();
//        while (start <(len)) {
//            for (int end = start + 1; end < len+1; end++) {
//                if (isPalindrome(s.substring(start, end))) {
//                    palindromeList.add(s.substring(start, end));
//
//                }
//            }
//            start++;
//        }
//        Optional result = palindromeList.stream().max(Comparator.comparing(String::length));
//        if (result.isPresent()) return (String) result.get();
//        else return "";
//    }


    private boolean isPalindrome(String str) {

        return str.contentEquals(new StringBuilder(str).reverse());
    }
}//LongestPalindromicCombination
