package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        QueryBuilder query = new QueryBuilder();
        
        Matcher m1 = query.playsIn("NYR").hasAtLeast(10, "goals").hasFewerThan(15, "assists").build();
        
        Matcher m2 = query.playsIn("PIT").hasAtLeast(10, "goals").hasFewerThan(15, "assists").build();
        
        Matcher m = query.oneOf(m1, m2).build();
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
