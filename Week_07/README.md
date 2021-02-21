学习笔记

## Trie树（trie树，单词查找树，键树）

```
                  / | \
                t   a   i
               / \       \  
             to  te       in
                / | \
             tea ted ten  
```

典型应用：用于统计和排序大量的字符串（不仅限于字符串），经常被搜索引擎系统用于文本词频统计。

优点：最大限度地减少无谓的字符串比较，查询效率比哈希表高

### 基本性质

- 节点本身不存完整单词
- 从根节点到某一节点，路径上经过的字符链接起来为该节点对应的字符串
- 每个节点的所有子节点路径代表的字符都不相同

### 核心思想

```
空间换时间
```

利用字符串的公共前缀来降低查询时的开销以达到提高效率的目的

### 代码模板

```
class Trie {
    private boolean isEnd;
    private Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
     
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;    
    }    
    private Trie searchPrefix(String word) {        
        Trie node = this;        
        char[] words = word.toCharArray();        
        for (int i = 0;i < words.length;i++) {            
            node = node.next[words[i] - 'a'];            
            if (node == null) return null;        
        }        
        return node;    
    }
}
```

## 并查集（Disjoint Set）

适用场景: 组团、配对问题

### 基本操作

- makeSet(s) 建立一个新的并查集，其中包含s个单元素集合。
- unionSet(x,y) 把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并
- find(x) 找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合（比较两个元素的代表是否相同即可）

### 代码模板

```
class UnionFind { 	
    private int count = 0; 	
    private int[] parent; 	
    public UnionFind(int n) { 		
        count = n; 		
        parent = new int[n]; 		
        for (int i = 0; i < n; i++) { 			
            parent[i] = i;		
        }	
    } 	
    public int find(int p) { 		
        while (p != parent[p]) { 			
            parent[p] = parent[parent[p]]; 			
            p = parent[p]; 		
        }		
        return p; 	
    }	
    public void union(int p, int q) { 		
        int rootP = find(p); 		
        int rootQ = find(q); 		
        if (rootP == rootQ) 
            return; 		
        parent[rootP] = rootQ; 		
        count--;	
    }
}
```

## 搜索

### 初级搜索

1. 朴素搜索
2. 优化方式：去重复， 剪枝（去掉递归树中无用的枝条）
3. 搜索方向
   1. DFS
   2. BFS

#### 估价函数

- 启发式函数：h(n),用来评价哪些节点最可能是一个我们要找的节点，返回一个非负实数，也可以认为是从节点n的目标节点路径的估计成本
- 启发式函数是一种告知搜索方向的方法，提供了一种明智的方法来猜测那个邻居节点会导向一个目标

## AVL树和红黑树

### AVL树（发明者 G.M.Adelson-Velsky和Evgenii Landis）

- 平衡二叉搜索树
- 每个节点需要存储Balanc Factor（平衡因子）：左子树的高度减去右子树的高度，取值范围{-1,0,1}
- 通过旋转操作来进行平衡（四种）
  - 左旋
  - 右旋
  - 左右旋
  - 右左旋
- 保证苹果因子在-1，0，1来维护搜索效率

不足

- 节点需要存储额外信息
- 调整次数频繁

### 红黑树（近似平衡二叉树）

能够确保任何一个节点的左右子树的高度差小于两倍。

红黑树满是足以下条件的二叉搜索树

- 每个节点要么是红色，要么是黑色
- 根节点是黑色
- 每个叶子节点（叶子全部都是nil节点，空节点）是黑色
- 不能有相邻接的两个红色节点
- 从任一节点到其每个叶子的所有路径都包含相同数量的黑色节点

关键性质

- 从根节点到叶子节点的最长可能路径不超过最短的可能路径的两倍