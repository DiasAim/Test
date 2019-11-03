package TS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DbServlet
 */
public class DbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected static Connection con=null;
    public DbServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset=UTF-16");
        out.println(" <head>" +"  <meta charset=\"UTF-8\">" +"</head> ");
        out.println("<html><body><table><tr><th>Date</th><th>Departure</th><th>Arrival</th><th>Time</th>");
        try {
            con=DatabaseConnection.initializeDatabase();
            Statement mySt  = con.createStatement();
            ResultSet r;
            String date, departure, arrival;
            date= request.getParameter("Date");
            departure = request.getParameter("Departure");
            arrival = request.getParameter("Arrival");
            if(date.isEmpty()||departure.isEmpty()||arrival.isEmpty()){
                    out.println("No available routes, sorry!        ");
                out.println("<a href = " + "http://localhost:8080/dynamictodolist_war_exploded" + ">Return</a>");

            }else {
                SelectHelper search = new SelectHelper();
                String query = search.Search(date, departure, arrival);
                r = mySt.executeQuery(query);
                if(!r.next()){
                    out.println("No available routes, sorry!        ");
                }else{
                    r.previous();
                }
                while (r.next()) {
                    out.println("<tr><td>" + r.getString(2) + "</td><td>" + r.getString(4) + "</td><td>" + r.getString(5) + "</td><td>" + r.getString(3) + "</td></tr>");
                }
                if (!r.next()) {
                    out.println("<a href = " + "http://localhost:8080/dynamictodolist_war_exploded" + ">GO BACK</a>");
                }
                mySt.close();
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("</table></body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
	}
}
