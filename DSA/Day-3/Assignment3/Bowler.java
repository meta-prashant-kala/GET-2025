public class Bowler implements Comparable<Bowler> {
    String bowlerName;
    int bowlerQuota;

    public Bowler(String name, int quota){
        bowlerName=name;
        bowlerQuota=quota;
    }

    @Override
    public int compareTo(Bowler o) {
        return this.bowlerQuota - o.bowlerQuota;
    }
}
