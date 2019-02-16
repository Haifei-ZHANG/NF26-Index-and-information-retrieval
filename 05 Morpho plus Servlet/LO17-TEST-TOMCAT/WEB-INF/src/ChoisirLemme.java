import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.*;
import java.io.*;
import org.antlr.runtime.*;

public class ChoisirLemme extends HttpServlet {
	String requete ="";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
	{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>Choisir lemme</title>");
        out.println("</head>");
        out.println("<body>");
        requete = request.getParameter("requete");
    	try {
        	String requete;
            requete = request.getParameter("requete");
            if(requete != null){
    	        out.println("<table>");
    	        out.print("<tr><td>Requête saisie : </td><td>"+requete + "</td></tr>");
    	        out.println("</table>");
    	        StringTokenizer mots = new StringTokenizer(requete);
    	        
    	        BufferedReader brFilt=null;
    	        BufferedReader brSP=null;
    	        try {
    			     try {
    			         brFilt = new BufferedReader(new FileReader("/volsme/user1x/users/lo17a042/workspace/LO17-TEST-TOMCAT/filtronc.txt"));      		    
    			     } 
    			     catch(Exception e) {
    			          brFilt.close();
    			     }
    			} 
    			catch(FileNotFoundException e) {
    			     System.out.println("fichier inconnu : " + "filtronc.txt");
    			} 
    			catch(IOException e) {
    			     System.out.println("IO Exception");
    			}
    	        try {
    			     try {
    			    	 brSP = new BufferedReader(new FileReader("/volsme/user1x/users/lo17a042/workspace/LO17-TEST-TOMCAT/stoplist.txt"));      		    
    			     } 
    			     catch(Exception e) {
    			          brSP.close();
    			     }
    			} 
    			catch(FileNotFoundException e) {
    			     System.out.println("fichier inconnu : " + "stoplist.txt");
    			} 
    			catch(IOException e) {
    			     System.out.println("IO Exception");
    			}
    	        
    	        
    	        Lexique monLexique = new Lexique(brFilt, brSP);
    	        String motActuel;
    	        out.println("<table>");
    	        out.println("<form id='form' name='ChoisirLemme' method='get' action='LanceRequete' accept-charset='utf-8'><p>Choisissez votre mot</p>");
    	        out.println("<tr><td>Mot</td><td>Lemme</td><td>Méthode</td></tr>");
    	        while(mots.hasMoreTokens()){
    	      	  motActuel = mots.nextToken().toLowerCase();
    	      	  ArrayList<String> bestLemmes = new ArrayList<String>(monLexique.getLemmes(motActuel));
    	      	  if(bestLemmes.size()>1){
    	      		if(bestLemmes.size()>2){
    	      			out.println("<tr><td>"+motActuel+"</td>");
    	      			out.println("<td><select name='lemmes' id='"+motActuel+"'><option value='"+bestLemmes.get(1)+"'>"+bestLemmes.get(1)+"</option><option value='"+bestLemmes.get(2)+"'>"+bestLemmes.get(2)+"</option>");
    	      			 //if(bestLemmes.get(motActuel)[2] != null){
    	      			for(int i=3;i<bestLemmes.size();i++){
    	      				out.println("<option value='"+bestLemmes.get(i)+"'>"+bestLemmes.get(i)+"</option>");
    	      			 }
    	      			out.println("</select></td>");
    	      			out.println("<td>"+bestLemmes.get(0)+"</td></tr>");
    	      			 
    	      		}
    	      		else{
    	      			out.println("<tr><td>"+motActuel+"</td>");
    	      			out.println("<td><select name='lemmes' id='"+motActuel+"'><option selected='selected' value='"+bestLemmes.get(1)+"'>"+bestLemmes.get(1)+"</option>");
    	      			out.println("</select></td>");
    	      			out.println("<td>"+bestLemmes.get(0)+"</td></tr>");
    	      			//requetNormalise += " " + bestLemmes.get(motActuel)[0];
    	      			//out.println("<table>");
    	      			//out.println("<tr><td>"+motActuel+"</td><td>"+bestLemmes.get(motActuel)[0]+"</td><td>"+bestLemmes.get(motActuel)[3]+"</td></tr>");
    	      		}
    	      	  }	      	  
    	        }
    	        out.println("<tr><td></td><td></td><td><input type='submit' name='submit' value='validez après avoir choisi' /></td></tr>");
    	        out.println("</table>");
            }
        } catch(Exception e) {}
	}
}