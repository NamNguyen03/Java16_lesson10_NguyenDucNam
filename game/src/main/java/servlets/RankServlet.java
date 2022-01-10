package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.GameController;
import models.Player;
import statics.css.MyStyle;

@WebServlet(name = "rank" , urlPatterns = {
		"/rank"
})
public class RankServlet extends HttpServlet  {
	private GameController gameController = GameController.init();	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rs = "";

		rs = "<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>Game Find Number</title>      \n"
				+ "    <style>" + MyStyle.css + "</style>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "  <div class=\"w-30 flex-column content\">\n"
				+ "    <p class=\"title\">Rank For Game Find Number</p>\n"
				+ "    <table class=\"mb-10\">\n"		
				+ "        <tr>\n"
				+ "          <th>Rank</th>\n"
				+ "          <th>Username</th>\n"
				+ "          <th>Highest Score</th>\n"
				+ "        </tr>\n";
		int i =1;
		for(Player player: gameController.getRank()) {
			rs +=     "        <tr>\n"
					+ "          <td>#" + i +"</td>\n"
					+ "          <td>"+player.getUsername()+"</td>\n"
					+ "          <td>"+player.getHighestScores()+"</td>\n"
					+ "        </tr>\n";
			i++;
		}



		rs	+=    "      </table>\n"
				+ "      <form action=\"home\" method=\"get\">\n"
				+ "        <button class=\"w-40 btn\" type=\"submit\">Go to home</button>\n"
				+ "    </form> \n"
				+ "  </div>\n"
				+ "</body>\n"
				+ "</html>";

		resp.getWriter().append(rs );
	}
}
