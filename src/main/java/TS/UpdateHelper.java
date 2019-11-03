package TS;

public class UpdateHelper {
    public UpdateHelper(){}
    protected String Cancel(String place, String route, String train){
        String query="Update ticket Set Status = "+'0'+" Passenger = "+'0'+" Where";
        query += " Seat_number =" + place;
        query += " and RouteID = " + '"' + route+'"';
        query += " and TrainID = " + train;
        return query;
    }
    protected String Buy(String username, String place, String departure, String arrival, String time,String train){
        String query="Update ticket Set Status = "+'1'+" Passenger = (select UserID from user where Username = "+'"'+username+'"'+")";
        query+=" Where ";
        query += " Seat_number =" + place;
        query += " and RouteID = (select RouteID from route where departure = " + '"' + departure+'"';
        query+= " and arrival = " + '"' + arrival+'"'+ "time = "+ '"' + time+'"'+")";
        query+= " and trainID = " + train;
        return query;
    }
    protected String ChangePassenger(String fname, String lname, String email, String place, String train, String route){
        String query="Update ticket Set Status = 1, Passenger = ";
        query += "(Select UserID from User where Fname =" + '"'+fname+'"';
        query += " and Lname = " + '"' + lname+'"';
        query += " and Email = " + '"' + email+'"'+")";
        query += " Where Seat_number = " + place;
        query += " and Passenger = " + train;
        query += " and RouteID = " + '"' + route+'"';
        return query;
    }

}
