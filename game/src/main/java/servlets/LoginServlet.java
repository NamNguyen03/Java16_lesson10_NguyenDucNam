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

@WebServlet(name = "login" , urlPatterns = {
		"/login"
})
public class LoginServlet extends HttpServlet {
	
	private GameController gameController = GameController.init();	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//init form login
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
				+ "  <div class=\"w-30 flex-column content\">\n"
				+ "    <p class=\"title\">Login for Game Find Number</p>\n"
				+ "    <form class=\"flex-column\" action=\"login\" method=\"post\">\n"
				+ "        <div class=\"grid-2 mb-10\">\n"
				+ "            <label class=\"fz-25\"> Username: </label>\n"
				+ "            <input class=\"w-80 fz-25\" name='username'/>\n"
				+ "        </div>\n"
				+ "        <button class=\"w-40 btn\" type=\"submit\">Login</button>\n"
				+ "    </form> \n"
				+ "  </div>\n"
				+ "</body>\n"
				+ "</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		boolean isLogin = gameController.login(username);
		Player player = gameController.findPlayerByUsername(username);
		if( !isLogin ) {
			
			int timeExp = gameController.getMinuteResetToken(username);
			timeExp = timeExp==0 ? 1 : timeExp;
			
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
					+ "  <div class=\"w-30 flex-column content\">\n"
					+ "    <p class=\"title\">Login for Game Find Number</p>\n"
					+ "    <form class=\"flex-column\" action=\"login\" method=\"post\">\n"
					+ "        <div class=\"grid-2 mb-10\">\n"
					+ "            <label class=\"fz-25\"> Username: </label>\n"
					+ "            <input class=\"w-80 fz-25\" name='username'/>\n"
					+ "        </div>\n"
					+ "        <p class=\"error\">login after " + timeExp + " minutes please</p>\n"
					+ "        <button class=\"w-40 btn\" type=\"submit\">Login</button>\n"
					+ "    </form> \n"
					+ "  </div>\n"
					+ "</body>\n"
					+ "</html>");
			
		}
		
		if(isLogin) {
			req.setAttribute("token", player.getToken());
			req.getRequestDispatcher("/play").forward(req, resp);
		}
		
	}
}
