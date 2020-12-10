>  前缀树解法

1. 首先构建下图所示的前缀树

![trie](..\..\img\trie.png)

2. 嵌套HashMap构建前缀树

```java
class TrieNode {
  HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  public TrieNode() {}
}
//构建TrieMap
TrieNode trie = new TrieNode();
for (String num : strNums) {
  TrieNode node = trie;
  for (Character bit : num.toCharArray()) { 
    if (node.children.containsKey(bit)) {
      node = node.children.get(bit);
    } else {
      TrieNode newNode = new TrieNode();
      node.children.put(bit, newNode);
      node = newNode;
    }
  }  
}
```

