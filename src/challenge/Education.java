package challenge;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;


import java.util.Scanner;

import java.util.ArrayList;

public class Education {
private static String degree;
private static String field;
private static String classOf; 
private static String schoolIn;
private static int YearGrad;
private static String tryYearGrad;
public static String outString ="";

	
	public static void EducationProcess(){
		Connection con = null;
		Statement stmt =null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;

		 
		/*          Select Statement              */
			try{Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/RoboResumeDB?"+ "user=root&password=password" );
			/*   degree   */
			System.out.println("Enter the degree: ");
			Scanner sc = new Scanner(System.in);
			while (!sc.hasNext()){
				System.out.println("Enter a degree name:");
				degree = sc.nextLine();
				}
			degree = sc.nextLine();
			/*   degree   */
			/*   field   */
			System.out.println("Enter the field of study: ");

			while (!sc.hasNext()){
				System.out.println("Enter a field of study:");
				field = sc.nextLine();
				}
			field = sc.nextLine();
			/*   field   */
			/*   school   */
			System.out.println("Enter the school: ");

			while (!sc.hasNext()){
				System.out.println("Enter a school name:");
				schoolIn = sc.nextLine();
				}
			schoolIn = sc.nextLine();
			/*   school   */
			/*   yearGrad   */
			System.out.println("Enter Year of Graduation: ");
			if (sc.hasNextInt()){
				YearGrad=sc.nextInt();
			}
			else{while (!sc.hasNextInt()){
				System.out.println("Enter a year in the form of an integer:");
				tryYearGrad=sc.nextLine();
				}
				YearGrad=sc.nextInt();
			}
			/*   yearGrad   */
			
			pstmt = con.prepareStatement("Insert into Education(degree,field,school,YearGrad) values (?,?,?,?) ");
			pstmt.setString(1, degree);
			pstmt.setString(2, field);
			pstmt.setString(3, schoolIn);
			pstmt.setInt(4, YearGrad);
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
				con = DriverManager.getConnection("jdbc:mysql://localhost/RoboResumeDB?"+ "user=root&password=password&useSSL=false" );
				 stmt= con.createStatement();
				String sql = "Select * from Education";
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					/*System.out.print(rs.getString("degree")+ " in "+ rs.getString("field")+",\n"+rs.getString("school")+", "+rs.getString("YearGrad")+"\t");
					System.out.println();
					*/
					outString=rs.getString("degree")+ " in "+ rs.getString("field")+",\n"+rs.getString("school")+", "+rs.getString("YearGrad")+"\t";
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
