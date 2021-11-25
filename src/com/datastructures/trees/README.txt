Trees represent hierarchical data.

A tree is a data structure that stores elements in a hierarchical manner.
Each data in a tree is referred to as a node.
Each line that connects the nodes are called edges.
Each node contains a value/data/Object etc.
The top node of the tree is called the Root, and the nodes below it are its children nodes.
The nodes that are at the bottom which don't have any children are called leaf nodes.

          A             -Root Node  Level 0
       /     \
      B       C         -           Level 1
     / \     / \
    D   E   F   G       -           Level 2
   /
  H                     -           Level 3
/ | \
M N O                   -           Level 4

Uses
====================================
-   Represent hierarchical data
-   Databases
-   Autocompletion (chrome stores all previously stored queries in trees)
-   Compilers
-   Compression algorithms (JPEG,MP3)

Formal definitions:
====================================
-   Sibling - Children of same parent
-   Degree - Degree of node is no. of children of that node
-   Degree of Tree - Max Degree among all nodes
-   Depth of Node - Length of path from root to that node
-   Height of Node - no. of edges in the longest path from that node to a leaf node
-   Level of node - Each step in hierarchy is a level starting from root = level 0 (distance of root/number of edges to given target node)
    -   Level of the node *is always equal* to depth of the node.
    -   Level of the tree *is always equal* to the height of the tree.
    -   Level of the node *is not always equal* to height of node

-   Ancestor - any predecessor node on the path from root to that node
-   Descendant -  any successor node on the path from that node to leaf node
-   Subtree - A node and all of its descendants is a subtree

Condition of a tree: n nodes => (n-1) edges




Binary Tree
====================================
-   Special Variation Of Tree
-   Each node can have at most 2 children

                    Where L = Level

        7           L=0  Max 0 Children => 2^L = 2^0
      /   \
     4     9        L=1  Max 2 Children => 2^L = 2^1
    / \   / \
   1   6 8   10     L=2  Max 4 Children => 2^L = 2^2

                    MAX NUM NODES OF TREE = 0 + 2 + 4 = 7

                    MAX NUM OF NODES WITH HEIGHT OF TREE: 2^0 + 2^1 + 2^2 + ..... 2^h
                    => 2^(h+1) - 1
                    MIN NUM OF NODES WITH HEIGHT OF TREE: h + 1

                    Given max n nodes: find min height
                    n = 2^(h+1) - 1
                    n + 1 = 2^(h+1)
                    log(n + 1) = log(2^h+1)
                    log(n + 1) = h + 1
                    h = ceil.log(n + 1) - 1

                    Given min n nodes: find max height
                    n = h + 1
                    h = n - 1


Type of Binary Trees
====================================
Full Binary Trees is where all nodes must contain exactly 2 children nodes except leaf nodes.
    - number of leaf node = number of internal nodes + 1
    - max num nodes = 2^(h+1) - 1
    - min num nodes:
        H0 => 1
        H1 => 3
        H2 => 5
        H3 => 7
    - 2^h + 1
    - min height = log(n+1) - 1
    - max height = (n - 1) / 2

Complete Binary Tree is where all levels are completely filled except the last level, and the last level must have
all of its nodes as left as possible.
    - max num nodes = 2^(n+1) - 1
    - min num nodes = 2^h
    - min height = log(n + 1) - 1
    - max height = log n

Perfect Binary Tree is where all internal nodes have 2 children and all leaf nodes are at the same level

Degenerate Binary Tree is where each internal node only have 1 children.


Operations Binary Search Tree
====================================
-   left < node < right (relationship)
-   value of all nodes on left is smaller than root (left subtree)
-   value of all nodes on right is bigger than root (right subtree)

*   Why are these relationship properties matter?
        - Allows for quick search of a value compared to a linear data structure where you have to traverse entire list
        - Target: 1
        - Node: target < 7
            - Look at nodes in left subtree only (right subtree is > 7)
                - target < 7
                    - Look at left nodes in left subtree
                        - target == 7
                            return 1

-   The tree has a total of 7 nodes, but we found our target of 1 in only 3 comparisons.
        - In every step, we threw away half of our nodes away. (Logarithmic Time Complexity)

Complexity:
====================
-   Lookup O(log n)
-   Insert O(log n)
-   Delete O(log n)
If algorithm is bad, then complexity can be O(n) *** bad meaning how data is structured in the tree and accessed.
