package serv.game;

public class Player {

    private int points;
    private String name;

    public Player(String name) {
        this.points = 0;
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }
}