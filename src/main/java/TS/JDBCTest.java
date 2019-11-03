package TS;

import java.sql.*;


class JDBCTest {


   


    public static void main(String args[]) {

        try {
            DatabaseConnection db = new DatabaseConnection();
            Connection con = db.initializeDatabase();
            SelectHelper sel = new SelectHelper();
            String query2 = sel.SearchTicket("2019-10-29", "Astana", "Nur-Sultan","9:30","Pedrielli","Averil", "apedrielli1f@opera.com");
            Statement mySt2  = con.createStatement();
            ResultSet res = mySt2.executeQuery(query2);
            while(res.next()) {
                System.out.println(res.getString("seat_number") + " " + res.getString("RouteID")+ " "+ res.getString("Passenger")+ " " + res.getString("traintype"));
            }
            mySt2.close();
            con.close();
        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}