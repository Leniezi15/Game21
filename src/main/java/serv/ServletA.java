package serv;

import serv.game.GameService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletA extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        Player player = GameService.getPlayer("player", session);
//        Player server = GameService.getPlayer("server", session);


//
//
//        request.setAttribute("serverScore", server.getPoints());
//        request.setAttribute("playerScore", player.getPoints());
//
//        if (server.isLost() || player.isWin()) {
//            request.setAttribute("res", "Вы победили!");
//            request.getRequestDispatcher("/result.jsp").forward(request, response);
//        } else if (player.isLost() || server.isWin()) {
//            request.setAttribute("res", "Вы проиграли!");
//            request.getRequestDispatcher("/result.jsp").forward(request, response);
//        }

        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("serverScore", 0);
        request.setAttribute("playerScore", 0);

        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pcScore, playerScore;

        if (request.getParameter("pcScore") == null && request.getParameter("playerScore") == null)
            throw new NullPointerException("Score can't be NULL");

        pcScore = Integer.parseInt(request.getParameter("pcScore"));
        playerScore = Integer.parseInt(request.getParameter("playerScore"));
        System.out.println("Client:: pcScore: " + pcScore + ",  playerScore:" + playerScore);

        if (request.getParameter("restart") != null) {
            request.getRequestDispatcher("/game.jsp").forward(request, response);
            return;
        }


        if (request.getParameter("take") != null) {
            pcScore += GameService.getCard(); //pc get card
            playerScore += GameService.getCard(); //user get card
        }

        if (request.getParameter("pass") != null)
            pcScore += GameService.getCard(); //pc get card

        System.out.println("SERVER:: pcScore: " + pcScore + ",  playerScore:" + playerScore);

        // check is some win or lose
        if (GameService.isLost(pcScore) || GameService.isWin(playerScore)) {
            request.setAttribute("playerWin", true);
        } else if (GameService.isLost(playerScore) || GameService.isWin(pcScore)) {
            request.setAttribute("pcWin", true);
        }

        request.setAttribute("playerScore", playerScore);
        request.setAttribute("pcScore", pcScore);
        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}