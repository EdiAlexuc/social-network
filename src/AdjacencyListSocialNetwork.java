import java.util.*;

public class AdjacencyListSocialNetwork implements SocialNetwork{

    private final Map<String, List<String>> adjacencyList;

    public AdjacencyListSocialNetwork() {
        adjacencyList = new HashMap<>();
    }


    @Override
    public void addUser(String user) {
        adjacencyList.putIfAbsent(user, new ArrayList<>());
    }

    @Override
    public void addFriend(String user1, String user2) {
        adjacencyList.get(user1).add(user2);
        adjacencyList.get(user2).add(user1);
    }

    @Override
    public int shortestChainlength(String user1, String user2) {
        // BFS algorithm goes here
        if(!adjacencyList.containsKey(user1) || !adjacencyList.containsKey(user2)) {
            return -1;
        }

        Map<String, Integer> distance = new HashMap<>();
        for(String user : adjacencyList.keySet()) {
            distance.put(user, Integer.MAX_VALUE);
        }
        distance.put(user1, 0);

        Queue<String> queue = new LinkedList<>();
        queue.add(user1);

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
