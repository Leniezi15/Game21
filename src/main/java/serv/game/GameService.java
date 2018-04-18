package serv.game;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static java.lang.Math.random;

public class GameService {

    private static ArrayList<Player> players = new ArrayList<>();
    private static int WINNER_SCORE = 21;

    public static Player getPlayer(String name, HttpSession session) {
        Player player;
        if (session.getAttribute(name) == null) {
            player = new Player(name);
            players.add(player);
            session.setAttribute(name, player);
        } else {
            player = (Player) session.getAttribute(name);
        }
        return player;
    }

    public static boolean isLost(int points) {
        return points > WINNER_SCORE;
    }

    public static boolean isWin(int points) {
        return points == WINNER_SCORE;
    }

    public static int getCard() {
        int res = (int) (random() * 10 + 2);
        System.out.println("Generate: " + res);
        return  res;
    }

}