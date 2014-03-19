/**
 *  Test class for Statistics.java.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Juha Lindqvist
 */
public class StatisticsTest {
    Player player;
    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4,  12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    public StatisticsTest() {
        stats = new Statistics(readerStub);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearch() {
        player = stats.search("Kurri");
        assertEquals(player.getName(), "Kurri");
    }
    
    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearchPlayerNotFound() {
        player = stats.search("Selänne");
        assertEquals(player, null);
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
        List<Player> team = stats.team("EDM");
        assertEquals(team.size(), 3);
    }
    
    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeamNotFound() {
        List<Player> team = stats.team("JOK");
        assertEquals(team.size(), 0);
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        player = stats.search("Gretzky");
        List<Player> top = stats.topScorers(1);
        assertEquals(player, top.get(0));
    }
}