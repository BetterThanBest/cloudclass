package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class specify
 */
public class specify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public specify() {
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
		RequestDispatcher rds = null;
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		Cookie userNameCookie =new Cookie("userName", userName);
		Cookie passWordCookie = new Cookie("passWord",userPassword);
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		String name = (String)session.getAttribute("userName");
		if(name != null)
		{
			System.out.println("second login:"+name);
		}
	//	userNameCookie.setMaxAge(2);
	//	passWordCookie.setMaxAge(2);
		response.addCookie(userNameCookie);
		response.addCookie(passWordCookie);
		Cookie[] cookies = request.getCookies();
		if(cookies !=null)
		{
			for(Cookie cookie:cookies)
			{
				if(cookie.getName().equals("userName"))
					userName = cookie.getValue();
					//System.out.println(userName);
				if(cookie.getName().equals("passWord"))
				{
					userPassword = cookie.getValue();
					//System.out.println(userPassword);
				}
			}
		}
		try {
			if(userName.equals("admin") && userPassword.equals("admin"))
			{
				PrintWriter writer = response.getWriter();
				writer.println("<html>");
				writer.println("<head><title>wen3</title></head>");
				writer.println("<body>");
				writer.println("haha");
				writer.println("<p>用户名："+userName+"</p>");
				writer.println("<p>用户密码："+userPassword+"</p>");
				writer.println("</body>");
				writer.println("</html>");
				writer.flush();
				writer.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			rds = request.getRequestDispatcher("index.jsp");
			rds.forward(request, response);
		}

	}

}
