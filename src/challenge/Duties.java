package challenge;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;


import java.util.Scanner;

public class Duties {
	private static String dutyName;

	public static void main(String[] args){
		Connection con = null;
		Statement stmt =null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;

		 
		/*          Select Statement              */
			try{Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/RoboResumeDB?"+ "user=root&password=password" );
			/*   duty name  */
			System.out.println("Enter a duty name: ");
			Scanner sc = new Scanner(System.in);
			while (!sc.hasNext()){
				System.out.println("Enter a duty name:");
				dutyName = sc.nextLine();
				}
			dutyName = sc.nextLine();
			/*   duty name   */
			
			
		
			
			pstmt = con.prepareStatement("Insert into Duties(dutyName) values (?) ");
			pstmt.setString(1,dutyName);

		
      		pstmt.executeUpdate();
			
      		
		

			}catch(SQLException e){
				e.printStackTrace();
				
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}finally{
				try{
					//rs.close();
					pstmt.close();
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			
			/*          Select Statement              */
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/RoboResumeDB?"+ "user=root&password=password" );
				stmt= con.createStatement();
				String sql = "Select * from Duties";
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					System.out.println(rs.getString("dutyName"));
					System.out.println();
								
				}
				
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}finally{
				try{
					rs.close();
					stmt.close();
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			}
		




}
