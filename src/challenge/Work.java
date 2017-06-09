package challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;


import java.util.Scanner;



public class Work{
private static String WorkTitle;
private static String WorkComp;
private static String workDur; 
private static String duty; 
public static String outString="";

	
	public static void WorkProcess(){
		Connection con = null;
		Statement stmt =null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;

		 
		/*          Select Statement              */
			try{Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/RoboResumeDB?"+ "user=root&password=password" );
			/*   work Title   */
			System.out.println("Enter a position title: ");
			Scanner sc = new Scanner(System.in);
			while (!sc.hasNext()){
				System.out.println("Enter a position title:");
				WorkTitle = sc.nextLine();
				}
			WorkTitle = sc.nextLine();
			/*   Work Title   */
			/*   Work Comp  */
			System.out.println("Enter the work company: ");

			while (!sc.hasNext()){
				System.out.println("Enter a work company:");
				WorkComp = sc.nextLine();
				}
			WorkComp = sc.nextLine();
			/*   Work Comp   */
			/*   WorkDur   */
			System.out.println("Enter the dates of employment: ");

			while (!sc.hasNext()){
				System.out.println("Enter dates of employment:");
				workDur= sc.nextLine();
				}
			workDur = sc.nextLine();
			/*   WorkDur  */
			/*   duty   */
			System.out.println("Enter list of duties: ");

			while (!sc.hasNext()){
				System.out.println("Enter list of duties:");
				duty= sc.nextLine();
				}
			duty = sc.nextLine();
			/*   duty  */
			
			pstmt = con.prepareStatement("Insert into Work(workTitle,workComp,workDur,duty) values (?,?,?,?) ");
			pstmt.setString(1, WorkTitle);
			pstmt.setString(2, WorkComp);
			pstmt.setString(3, workDur);
			pstmt.setString(4, duty);
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
				String sql = "Select * from Work";
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					/*System.out.println(rs.getString("WorkTitle")+ " \n"+ rs.getString("WorkComp")+", "+rs.getString("WorkDur"));
					System.out.println();*/
					outString = outString +rs.getString("WorkTitle")+ " \n"+ rs.getString("WorkComp")+", "+rs.getString("WorkDur")+"\n";
					outString = outString+ rs.getString("duty");
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
