package challenge;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;


import java.util.Scanner;

public class Skills {
	private static String skillName;
	private static String proficiency; 
	public static String outString="";
	public static void SkillsProcess(){
		Connection con = null;
		Statement stmt =null;
		PreparedStatement pstmt= null;

		ResultSet rs = null;

		 
		/*          Select Statement              */
			try{Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/RoboResumeDB?"+ "user=root&password=password" );
			/*   skill name  */
			System.out.println("Enter a skill name: ");
			Scanner sc = new Scanner(System.in);
			while (!sc.hasNext()){
				System.out.println("Enter a skill name:");
				skillName = sc.nextLine();
				}
			skillName = sc.nextLine();
			/*   skill name   */
			/*   proficiency  */
			System.out.println("Enter the proficiency: ");

			while (!sc.hasNext()){
				System.out.println("Enter a proficiency:");
				proficiency = sc.next();
				}
			proficiency = sc.next();
			/*   proficiency   */
		
		
			
			pstmt = con.prepareStatement("Insert into Skills(skillName, proficiency) values (?,?) ");
			pstmt.setString(1,skillName);
			pstmt.setString(2, proficiency);
		
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
				String sql = "Select * from Skills";
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					/*System.out.println(rs.getString("skillName")+ " \n"+ rs.getString("proficiency"));
					System.out.println();*/
								outString=rs.getString("skillName")+ ", "+ rs.getString("proficiency")+" \n";
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
