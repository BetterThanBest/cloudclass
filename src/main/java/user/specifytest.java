package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class specifytest
 */
public class specifytest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public specifytest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String userName = request.getParameter("user");
		String passWord = request.getParameter("password");
		Cookie userNameCookie = new Cookie("userName", userName);
		response.addCookie(userNameCookie);
		userNameCookie.setMaxAge(3*60);
		HttpSession session = request.getSession();
		session.setAttribute("passWord", passWord);
		String pwd = (String)session.getAttribute("passWord");
		if(pwd != null)
		{
			
			System.out.println("second login:"+pwd);
			session.invalidate();
		}
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies)
		{
			if(cookie.getName().equals("userName"))
			{
				if(userName != cookie.getValue())
				{
					System.out.println(userName+"hello");
				}
			}
		}
	}

}
