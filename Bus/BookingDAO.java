package Bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookingDAO {
	
	public int getBookedCount(int busNo, Date date) throws SQLException {
		
		String query = "select count(passenger_name) from booking where bus_no = ? and travel_date = ?";
		
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		pst.setInt(1, busNo);
		pst.setDate(1, sqldate);
		
		ResultSet rs = pst.executeQuery();
		rs.next();
		
		return rs.getInt(1);
		
	}
	
	public void addBooking(Booking booking) throws SQLException{
	
	String query = "insert into booking values(?,?,?)";
	
	Connection con = DbConnection.getConnection();
	java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
	PreparedStatement pst = con.prepareStatement(query);
	pst.setString(1, booking.passengerName);
	pst.setInt(2, booking.busNo);
	pst.setDate(3, sqldate);
	
	pst.executeUpdate();
	
	}

}
