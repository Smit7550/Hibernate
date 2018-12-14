package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegDAO;
import vo.RegVO;

/**
 * Servlet implementation class cont
 */
@WebServlet("/cont")
public class cont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cont() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag = request.getParameter("flag").toString();
		HttpSession s = request.getSession();
		if (flag.equals("edit"))
		{
			int i = Integer.parseInt(request.getParameter("id"));
			s.setAttribute("abc", i);
			RegVO obj = new RegVO();
			obj.setId(i);
			
			RegDAO obj1 = new RegDAO();
			List ls = obj1.search1(obj);
			
			s.setAttribute("List", ls);
			
			response.sendRedirect("4.jsp");
			
		}
		else if(flag.equals("delete"))
		{
	
			int i = Integer.parseInt(request.getParameter("id"));
				
			RegVO obj = new RegVO();
			obj.setId(i);
				
			RegDAO obj1 = new RegDAO();
			obj1.delete(obj);
			
			response.sendRedirect("2.jsp");
	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		PrintWriter out = response.getWriter();
		String a = request.getParameter("flag");
		if (a.equals("insert")) 
		{
			String firstname = request.getParameter("fn");
			String lastname = request.getParameter("ln");
			if (firstname=="" || lastname=="")
			{
				response.sendRedirect("2.jsp");
			}
			else
			{
			RegVO obj = new RegVO();
			obj.setFirstname(firstname);
			obj.setLastname(lastname);
			
			RegDAO obj1 = new RegDAO();
			obj1.insert(obj);
			
			/*out.println("Details Added Succesfully");
			RequestDispatcher rd = request.getRequestDispatcher("2.jsp");
			rd.include(request, response);*/
			response.sendRedirect("2.jsp");
			}
		}
		else if(a.equals("search")) 
		{	
		String firstname = request.getParameter("search");
		
		RegVO obj = new RegVO();
		obj.setFirstname(firstname);
		
		RegDAO obj1 = new RegDAO();
		List ls = obj1.search(obj);
		
		s.setAttribute("List", ls);
		
		response.sendRedirect("3.jsp");
		}
		
		else if (a.equals("update"))
		{
			String s1 = request.getParameter("fn");
			String s2 = request.getParameter("ln");
			int i = (Integer)s.getAttribute("abc");
			
			RegVO obj1 = new RegVO();
			obj1.setFirstname(s1);
			obj1.setLastname(s2);
			obj1.setId(i);
		
			RegDAO obj = new RegDAO();
			obj.edit(obj1);
			
			response.sendRedirect("2.jsp");
		}
	}

}
