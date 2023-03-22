public interface SocialNetwork {

    void addUser(String user);
    void addFriend(String user1, String user2);
    int shortestChainlength(String user1, String user2);
}
