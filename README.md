# social-network
### How did you represent the social network? Why did you choose this representation?

I represented the social network using an adjacency list data structure. This data structure consists of list of vertices, where each vertex has a list of adjacent vertices that it is connected to. In this case, each vertex represents a user, and the adjacent vertices represent their friends.
I chose this implementation because it is space-efficient and allows for efficient traversal of the network. Since each vertex only stores information about its adjacent vertices, the amount of memeory required to represent the network scales linearly with the number of users and friend connections. Additionally, the adjacency lsit representation allows us to easily traverse the network by visiting each vertex and its adjacent vertices.

### What algorithm did you use to compute the sortest chain of friends? What alternatives did you consider? Why did you choose this algorithm over the alternatives?

I used BFS (Breadth-First Search) algorithm to compute the shortest chain of friends betwenn two users. An alternative algorithm for finding the shortest path in a graph is Dijkstra's algorithm, which works by maintaining a priority queue of vertices and their tentative distances from the source vertex. However, since the edges in our graph have the same weight, BFS suffices for finding the shortest path.

### I wrote 3 test cases:

1. 'testSimpleNetwork': This test case verifies that the 'shortestChainLength' method works correctly on a simple network with a shortest path of length 2. It is relevant because it tests the most basic functionality of the algorithm.
2. 'testComplexNetwork': This test case verifies that the 'shortestChainLength' method works correctly on a more complex network with a shortest path of length 2. It is relevant because it tests the the algorithm's ability to handle larger and more complexc networks.
3. 'testNoNetwork': This test case verifies that the 'shortestChainLength' method returns -1 when there is no path between the source and destination vertices. It is relevant because it tests the algorithm's ability to handle scenarios where there is no shortest path between two users. 
