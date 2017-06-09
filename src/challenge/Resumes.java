package challenge;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;


import java.util.Scanner;

public class Resumes{
	private static String FirstName;
	private static String Middle;
	private static String LastName; 
	private static String email;
	public static String outString="";
	public static void ResumesProcess(){
		Connection con = null;
		Statement stmt =null;
		PreparedStatement pstmt= null;

		ResultSet rs = null;

		 
		/*          Select Statement              */
			try{Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/RoboResumeDB?"+ "user=root&password=password" );

			
			/*   FirstName  */
			System.out.println("Enter first name: ");
			Scanner sc = new Scanner(System.in);
			while (!sc.hasNext()){
				System.out.println("Enter a first name:");
				FirstName = sc.nextLine();
				}
			FirstName = sc.nextLine();
			/*   FirstName   */
			/*   Middle  */
			System.out.println("Enter middle initial: ");

			while (!sc.hasNext()){
				System.out.println("Enter a middle initial:");
				Middle = sc.next();
				}
			Middle = sc.next();
			/*   Middle   */
		
			/*   LastName */
			System.out.println("Enter last name: ");

			while (!sc.hasNext()){
				System.out.println("Enter last name:");
				LastName = sc.next();
				}
			LastName = sc.next();
			/*   LastName   */
			/*   email  */
			System.out.println("Enter email: ");

			while (!sc.hasNext()){
				System.out.println("Enter an email:");
				email = sc.next();
				}
			email = sc.next();
			/*   email   */
			pstmt = con.prepareStatement("Insert into Resumes(FirstName, Middle, LastName, email) values (?,?,?,?) ");

			pstmt.setString(1,FirstName);
			pstmt.setString(2, Middle);
			pstmt.setString(3, LastName);
			pstmt.setString(4, email);
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
				String sql = "Select * from Resumes";
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					/*System.out.println(rs.getString("FirstName")+ " "+rs.getString("Middle")+" "+rs.getString("LastName")+" \n"+rs.getString("email"));
					System.out.println();*/
					outString = outString+	rs.getString("FirstName")+ " "+rs.getString("Middle")+" "+rs.getString("LastName")+" \n"+rs.getString("email")+"\n"	;	
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
