package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Style;

import statics.css.MyStyle;

@WebServlet(name = "home" , urlPatterns = {
		"/home",
		"/"	
})
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
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
				+ "  <div class=\"w-40 flex-column content\">\n"
				+ "    <p class=\"title\">Wellcome To Find Number</p>\n"
				+ "    <div class=\"grid-2\">\n"
				+ "        <form action=\"play\" method=\"get\">\n"
				+ "            <button class=\"w-100 btn\" type=\"submit\">Play</button>\n"
				+ "        </form> \n"
				+ "        <form action=\"rank\" method=\"get\">\n"
				+ "            <button class=\"w-100 btn\" type=\"submit\">Rank</button>\n"
				+ "        </form> \n"
				+ "    </div>\n"
				+ "  </div>\n"
				+ "</body>\n"
				+ "</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
				+ "  <div class=\"w-40 flex-column content\">\n"
				+ "    <p class=\"title\">Wellcome To Find Number</p>\n"
				+ "    <div class=\"grid-2\">\n"
				+ "        <form action=\"play\" method=\"get\">\n"
				+ "            <button class=\"w-100 btn\" type=\"submit\">Play</button>\n"
				+ "        </form> \n"
				+ "        <form action=\"rank\" method=\"get\">\n"
				+ "            <button class=\"w-100 btn\" type=\"submit\">Rank</button>\n"
				+ "        </form> \n"
				+ "    </div>\n"
				+ "  </div>\n"
				+ "</body>\n"
				+ "</html>");
	}
	
}
