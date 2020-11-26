package tree.Trie;/*
  @Date:2020/11/26 10:03
  @Author:Administrator
*/

import java.util.*;

public class leetcode421_数组中两个数的最大异或值 {
    public int findMaximumXOR(int[] nums) {
        int maxNum=nums[0];
        for (int num:nums) {  //找到最长的二进制表达，然后将其他的数字的对齐
            maxNum=Math.max(maxNum,num);
        }
        int L=(Integer.toBinaryString(maxNum)).length();
        int maxXor=0,currXor;
        Set<Integer> prefixes=new HashSet<>();
        for (int i = L-1; i >-1 ; i--) {
            maxXor<<=1; //当前已经计算出来的最大前缀左移，释放出下一位比特位（最右）的位置
            currXor=maxXor|1; //当前最右bit置1，看看是否存在前缀异或使得当前最右bit为1
            prefixes.clear(); //当前前i位nums前缀
            for (int num:nums) { //找到nums中的所有前i二进制前缀
                prefixes.add(num>>i);
            }
            for (int p:prefixes) {
                if (prefixes.contains(p^currXor)){ //p1^p2=currXor => currXor^p2=p1
                    maxXor=currXor;
                    break;
                }
            }
        }
        return maxXor;
    }
    //Trie 解法
    //Hash 解法需要每次都需要遍历所有nums的前i位prefixes，使用Trie可以实现剪枝
    /*
    * 剪枝思路
    * 对于（3,10,5,25,2,8）
    * 两次异或操作之后为了得到 (11***) 显然只能让 25 和 最左侧为 0000 前缀的数字（2，3， 5）组合。
    * 因此，在计算第三位比特的时候，我们就没有必要计算所有可能的按位前缀组合了。光看前两位就知道一些组合已经不能得到最大异或值了。
    * */

    /*
    *
    *
    *
    * */
    static  class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        public TrieNode() {}
    }
    static  class Solution{
        public int findMaximumXOR(int[] nums) {
            int maxNum = nums[0];
            for(int num : nums) maxNum = Math.max(maxNum, num);
            int L = (Integer.toBinaryString(maxNum)).length();
            int n = nums.length, bitmask = 1 << L;
            String [] strNums = new String[n];
            for(int i = 0; i < n; ++i) {
                strNums[i] = Integer.toBinaryString(bitmask | nums[i]).substring(1);
                //bitmask | nums[i] 左补齐
            }
            TrieNode trie = new TrieNode();
            int maxXor = 0;
            for (String num : strNums) {
                TrieNode node = trie, xorNode = trie;  //node xorNode 同时指向Trie
                int currXor = 0; //每次新插入一个数字时，都需要求一次此时最大的currXor
                for (Character bit : num.toCharArray()) {
                    if (node.children.containsKey(bit)) {
                        node = node.children.get(bit);
                    }else {
                        TrieNode newNode = new TrieNode();
                        node.children.put(bit, newNode);
                        node = newNode; //转移
                    }
                    Character toggledBit = bit == '1' ? '0' : '1';
                    if (xorNode.children.containsKey(toggledBit)) {
                        currXor=(currXor<<1)|1;
                        xorNode = xorNode.children.get(toggledBit); //有的选，向toggledBit走
                    }else{
                        currXor=currXor<<1;
                        xorNode = xorNode.children.get(bit); //没的选，只能往bit走
                    }
                }
                maxXor = Math.max(maxXor, currXor);
            }
            return maxXor;
        }
    }

    public static void main(String[] args) {
//        new leetcode421_数组中两个数的最大异或值.Solution().findMaximumXOR(new int[]{
//                3,10,5,25,2,8
//        });
        System.out.println((1<<5)|3);
    }
}
