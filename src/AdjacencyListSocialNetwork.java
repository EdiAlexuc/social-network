import java.util.*;

 /* This implements SocialNetwork interface.
 It uses an adjacency list data structure to represent the social network
 where each user is a vertex in the graph and their friends are store as adjacent vertices in the list

 */
public class AdjacencyListSocialNetwork implements SocialNetwork{

    private final Map<String, List<String>> adjacencyList;

    public AdjacencyListSocialNetwork() {
        adjacencyList = new HashMap<>();
    }

    // adds a user to the social network.
    // It adds the user as a key if it is not already in the map
    @Override
    public void addUser(String user) {
        adjacencyList.putIfAbsent(user, new ArrayList<>());
    }

    // add friend connection between 2 users
    @Override
    public void addFriend(String user1, String user2) {
        adjacencyList.get(user1).add(user2);
        adjacencyList.get(user2).add(user1);
    }

    // returns the shortest chain length between 2 users using BFS
    // algorithm on the social network represented by adjacency list
    @Override
    public int shortestChainlength(String user1, String user2) {
        // If either user is not in the social network, there is no path between
        if(!adjacencyList.containsKey(user1) || !adjacencyList.containsKey(user2)) {
            return -1;
        }

        // Initialize a map to hold the distance of each user
        // from the starting user (user1)
        Map<String, Integer> distance = new HashMap<>();
        for(String user : adjacencyList.keySet()) {
            distance.put(user, Integer.MAX_VALUE);
        }
        distance.put(user1, 0);

        // Initialize a queue to hold the nodes to be explored in BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(user1);

        // Run BFS on the social network to find the shortest path between user1 and user2
        while (!queue.isEmpty()) {
            String current = queue.remove();
            for(String neighbour: adjacencyList.get(current)) {
                if(distance.get(neighbour) == Integer.MAX_VALUE) {
                    distance.put(neighbour, distance.get(current) + 1);
                    queue.add(neighbour);
                }
                if(neighbour.equals(user2)) {
                    return distance.get(neighbour);
                }
            }
        }

        return -1; // no path from user1 to user2
    }
}
