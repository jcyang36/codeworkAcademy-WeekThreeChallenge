/*
 * 
 * Author: Joyce Yang
 * Week Three Challenge
 * This program takes in user's information, stores it in a database, and returns a resume.
 */
package challenge;

import java.util.Scanner;
import java.util.ArrayList;
public class WeekThreeChallenge{
    public static void main(String[] args){
    //----------  INPUT  ----------
       Scanner receiveInput  =new Scanner(System.in);
       Scanner choice = new Scanner(System.in);
       String first="John";
    String last="Jingleheimer-Schmidt";
    String middle="J";
        String email="jjjschmidt@gmail.com";
      String degree ="BS";
    String classOf="UMaryland, 2002";
    String field="Psychology";
    String wTitle="Software Developer II";
    String wDur="Amtrak, June 2015- Present";
    String  wComp;
    ArrayList <String> education = new ArrayList <String> ();
	ArrayList <String> work = new ArrayList <String> ();
	ArrayList <String> duties = new ArrayList <String> ();
	ArrayList <String> skills = new ArrayList <String> ();


	int count=0;
     //----------  INPUT  -----------
     
     //----------  PROCESSING  ----------
	String nameString="";
	Resumes r = new Resumes();
	r.ResumesProcess();
	nameString=r.outString;
    
    String rep="Y";
    String rep_duty="Y";

    Education e = new Education();
 	 String resString="";
 	while(rep.equalsIgnoreCase("Y")){
 		
 		e.EducationProcess();
 		resString=e.outString;
 	 	count++;
	 	System.out.println("Enter another educational achievement? Y/N: ");
	 	rep = choice.next();
	 	
	 	if(count>20){
	 		   break;
	 		   
	 	   }
	 	   
	 	
 	} 
 	

 	

    
 	
 
	 	String workrep="Y";
	 	int workcount=0;
	 	
	 	Work w = new Work();
		String workString ="";
	 	
	 	System.out.println("Work");
    while(workrep.equalsIgnoreCase("Y") && workcount<10){
    	w.WorkProcess();
    	workString=w.outString;
	
				
				workcount++;
			    System.out.println("Enter a new position for work(new comp)? (Y/N)  " );
				workrep = choice.next();			
				
    }

String	skill_rep="Y";
	int skill_count = 0;
	
	String skillString="";
	
	Skills s = new Skills();
	System.out.println("Skills");
 	while(skill_rep.equalsIgnoreCase("Y") && skill_count<20){
 			s.SkillsProcess();
 			skillString=s.outString;
 	
	 	     skill_count++;
	 	  System.out.println("Enter a new skill?(Y/N) " );
	 	  skill_rep=choice.next();
	 	   
 	}
    //----------  PROCESSING  ----------
    
   //-----------  OUTPUT  ---------- 
 	System.out.println(nameString);
 	System.out.println("Education");
 	System.out.println(resString);
 	System.out.println("Experience");
 	System.out.println(workString);
 	System.out.println("Skills");
	System.out.println(skillString);
       
 	
   //----------  OUTPUT  ----------
    }
    
    
  
}