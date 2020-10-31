import java.util.*;

public class leetcode381_时间插入删除和获取随机元素 {

}
class RandomizedCollection {
    Map<Integer, Set<Integer>> idx; //<key,value> key:所存储的数字，value：存储了key的索引
    List<Integer> nums; //所存储的数字集合
    public RandomizedCollection() {
        idx = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<Integer>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val); //在列表末尾添加的元素 O(1)
        Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
        set.add(nums.size()-1);
        idx.put(val,set);
        return set.size()==1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val)){
            return false; //没有该值，删除失败
        }
        int lastNum = nums.get(nums.size() - 1);
        //交换要删除的元素和列表最末的元素
        if (val==lastNum){ //如果末尾元素就是的要删除的元素
            idx.get(val).remove(nums.size()-1);
            return true;
        }
        //如果末尾元素不是要删除的元素
        int lastIndex=idx.get(val).iterator().next(); //要删除的元素第一次出现的位置
        nums.set(lastIndex, lastNum); //最后一个元素到要删除的元素第一次出现的位置
        idx.get(val).remove(lastIndex);
        idx.get(lastNum).remove(nums.size()-1);
        if (lastIndex < nums.size() - 1) idx.get(lastNum).add(lastIndex);
        if (idx.get(val).size() == 0) { //删除之后，val出现的次数变为0
            idx.remove(val);
        }
        nums.remove(nums.size()-1); //删除末尾元素的时间复杂度为O（1）
        return  true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}