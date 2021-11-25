
[Ant, FoodStation, FoodStation]

Foodstation, Ant



Trees represent hierarchical data.

A tree is a data structure that stores elements in a hierarchical manner.
Each data in a tree is referred to as a node.
Each line that connects the nodes are called edges.
Each node contains a value/data/Object etc.
The top node of the tree is called the Root, and the nodes below it are its children nodes.
The nodes that are at the bottom which don't have any children are called leaf nodes.
          X             -Root Node
       /     \
      X       X
     / \     / \
    X   X   X   X       -Leaf Node

A Binary Tree is a special type of tree which constraints nodes to only have a max n of children nodes to be 2

Uses
====================================
-   Represent hierarchical data
-   Databases
-   Autocompletion (chrome stores all previously stored queries in trees)
-   Compilers
-   Compression algorithms (JPEG,MP3)

        7
      /   \
     4     9
    / \   / \
   1   6 8   10

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
