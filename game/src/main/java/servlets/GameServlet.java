package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.GameController;
import models.Contexts;
import models.Player;
import statics.css.MyStyle;


@WebServlet(name = "game" , urlPatterns = {
		"/play"
})
public class GameServlet extends HttpServlet {

	private GameController gameController = GameController.init();
	int i = 1;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//redirect to login
		resp.sendRedirect(req.getContextPath() + "/login");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String numberString = req.getParameter("number");
		int token = null == req.getAttribute("token") ? Integer.parseInt(req.getParameter("token")) : (int) req.getAttribute("token")  ;	
		boolean tokenIsValid = gameController.checkToken(username, token); 
		
		if(tokenIsValid) {
			
			boolean contextsExsist = gameController.contextsActiveExsist(username);
			
			Contexts contexts = new Contexts();
			
			String notification = "";
			
			if(contextsExsist) {
				contexts = gameController.findContextsActiveByUsername(username);	
				if(numberString != null && !numberString.equals("")) {
					int number = Integer.parseInt(numberString);
					if(number == contexts.getNumberCurrent() ) {
						contexts.setScoresCurrent(contexts.getScoresCurrent() +1);
						gameController.finishContextsByUsername(username);
						gameController.removeToken(username);
						resp.sendRedirect(req.getContextPath() + "/");
						return;
					}
					if(number < contexts.getNumberCurrent()) {
						 notification = "number biger ";
					}
					if(number > contexts.getNumberCurrent()) {
						 notification = "number smaller ";
					}
					contexts.setScoresCurrent(contexts.getScoresCurrent() +1);
				}
			}
			
			if(!contextsExsist) {
				contexts = gameController.createContext(username);
			}
			
			//reset token for each request
			Player player = gameController.resetToken(contexts.getPlayer());
			resp.getWriter().append("<!DOCTYPE html>\n"
					+ "<html lang=\"en\">\n"
					+ "<head>\n"
					+ "    <meta charset=\"UTF-8\">\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
					+ "    <title>Game Find Number</title>      \n"
					+ "    <style>" + MyStyle.css + "</style>\n"
					+ "</head>\n"
					+ "<body>\n"
					+ "   <div class=\"w-30 flex-column content\">\n"
					+ "    <p class=\"title\">Game Play</p>\n"
					+ "    <form class=\"flex-column\" action=\"play\" method=\"post\">\n"
					+ "        <div class=\"grid-2 mb-10\">\n"
					+ "            <label class=\"fz-25\"> Scores current: </label>\n"
					+ "            <label class=\"fz-25\"> " + contexts.getScoresCurrent() + " </label>\n"
					+ "        </div>\n"
					+ "        <div class=\"grid-2 mb-10\">\n"
					+ "            <label class=\"fz-25\" name='number'> Input Number: </label>\n"
					+ "            <input class=\"w-80 fz-25\" name='number' type=\"number\"/>\n"
					+ "            <input type='hidden' name='token' value= "+ player.getToken()+ " />\n"
					+ "            <input type='hidden' name='username' value= "+ username+ " />\n"
					+ "        </div>\n"
					+ "        <p class=\"error\">" + notification + (notification.equals("") ? "" : numberString) + "</p>\n"
					+ "        <button class=\"w-40 btn\" type=\"submit\">Submit</button>\n"
					+ "    </form> \n"
					+ "</body>\n"
					+ "</html>");
		}
		
		if(!tokenIsValid) {
			//redirect to login
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
