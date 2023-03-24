import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SocialNetworkIntegrationTest {
    @Test
    void testSimpleNetwork() {
        SocialNetwork socialNetwork = new AdjacencyListSocialNetwork();

        socialNetwork.addUser("A");
        socialNetwork.addUser("B");
        socialNetwork.addUser("C");
        socialNetwork.addUser("D");

        socialNetwork.addFriend("A","B");
        socialNetwork.addFriend("B","C");
        socialNetwork.addFriend("C","D");

        assertEquals(3, socialNetwork.shortestChainlength("A", "D"));
    }

    @Test
    void testComplexNetwork() {
        SocialNetwork socialNetwork = new AdjacencyListSocialNetwork();

        socialNetwork.addUser("A");
        socialNetwork.addUser("B");
        socialNetwork.addUser("C");
        socialNetwork.addUser("D");
        socialNetwork.addUser("E");
        socialNetwork.addUser("F");
        socialNetwork.addUser("G");
        socialNetwork.addUser("H");
        socialNetwork.addUser("I");

        socialNetwork.addFriend("A","B");
        socialNetwork.addFriend("A","B");
        socialNetwork.addFriend("A","C");
        socialNetwork.addFriend("B","D");
        socialNetwork.addFriend("B","E");
        socialNetwork.addFriend("C","F");
        socialNetwork.addFriend("C","G");
        socialNetwork.addFriend("D","H");
        socialNetwork.addFriend("G","I");

        assertEquals(3, socialNetwork.shortestChainlength("A", "I"));
    }

    @Test
    void testNoPath() {
        SocialNetwork socialNetwork = new AdjacencyListSocialNetwork();

        socialNetwork.addUser("A");
        socialNetwork.addUser("B");
        socialNetwork.addUser("C");

        assertEquals(-1, socialNetwork.shortestChainlength("A", "C"));
    }
    @Test
    void testMultiplePaths() {
        SocialNetwork socialNetwork = new AdjacencyListSocialNetwork();

        socialNetwork.addUser("A");
        socialNetwork.addUser("B");
        socialNetwork.addUser("C");
        socialNetwork.addUser("D");
        socialNetwork.addUser("E");

        socialNetwork.addFriend("A", "B");
        socialNetwork.addFriend("B", "C");
        socialNetwork.addFriend("C", "D");
        socialNetwork.addFriend("D", "E");
        socialNetwork.addFriend("A", "E");

        assertEquals(1, socialNetwork.shortestChainlength("A", "B"));
        assertEquals(2, socialNetwork.shortestChainlength("A", "C"));
        assertEquals(2, socialNetwork.shortestChainlength("A", "D"));
        assertEquals(1, socialNetwork.shortestChainlength("A", "E"));
    }
}
