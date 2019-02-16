import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.util.*;
import java.io.*;
import org.antlr.runtime.*;

public class LanceRequete extends HttpServlet {
	String username;
	String password;
	String url;
	String requete ="";
	String nom;
	int nbre;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>Lance requete!</title>");
        out.println("</head>");
        out.println("<body>");

	// ---- configure START
	username = "lo17xxx";
	password = "dblo17";
	// The URL that will connect to TECFA's MySQL server
        // Syntax: jdbc:TYPE:machine:port/DB_NAME
        url = "jdbc:postgresql://tuxa/dblo17";
	// dans certaines configurations locales il faut d�finir l'url par :
	// url = "jdbc:postgresql://tuxa.sme.utc
	// ---- configure END
    String arbre = "";
    request.setCharacterEncoding("utf-8");
    String[] lemmes = request.getParameterValues("lemmes");
    String requetNormalise = String.join(" ",lemmes);
    
    out.println("<table><tr><td>Requête normalisée : </td><td>"+requetNormalise + "</td></tr>");
    
    
    tal_sqlLexer lexer = new tal_sqlLexer(new ANTLRReaderStream(new StringReader(requetNormalise)));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    tal_sqlParser parser = new tal_sqlParser(tokens);
    try {
		arbre = parser.listerequetes();
	} catch (RecognitionException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    out.println("<tr><td>Arbre SQL : </td><td>"+arbre + "</td></tr>");
    arbre = arbre.replaceAll("\\(|\\)", "");
    arbre = arbre.replaceAll("\\s{1,}"," ");
    arbre = arbre.replaceAll("count (\\w+)?([.])?(\\w+)(\\s)","count($1$2$3)$4");
    arbre = arbre+";";
    out.println("<tr><td>Requête SQL : </td><td>"+arbre + "</td></tr>");
    out.println("</table>");
	if ((arbre != null)&&(arbre != "")) {
		// INSTALL/load the Driver (Vendor specific Code)
		try {
			Class.forName("org.postgresql.Driver");
			} catch(java.lang.ClassNotFoundException e) {
	    		System.err.print("ClassNotFoundException: ");
	    		System.err.println(e.getMessage());
			}
		try {
			Connection con;
			Statement stmt;
			// Establish Connection to the database at URL with usename and password
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			// Send the query and bind to the result set
			
			ResultSet rs = stmt.executeQuery(arbre);
			ResultSetMetaData rsmd=rs.getMetaData();
			nbre=rsmd.getColumnCount();
			String[] domaines = new String[nbre];
			out.print("<table border='1'><tr>");
			for(int i=0;i<nbre;i++){
				domaines[i]=rsmd.getColumnName(i+1);
				out.print("<td>"+domaines[i]+"</td>");
			}
			System.out.print("</tr>");
			while (rs.next()) {
				out.print("<tr>");
				for (int i=0; i<nbre;i++){
					nom = domaines[i];
					String s = rs.getString(nom);
					if(nom.equals("fichier")){
						out.print("<td><a href=\"http://www4.utc.fr/~lo17/TELECHARGE/BULLETINS_LO17/"+s+"\" target=\"_blank\">"+s+"</a></td>");
					}
					else{
						out.print("<td>"+s+"</td>");
					}
				}
				out.print("</tr>");
			}
			out.println("</table>");
			
			
		out.println("</body>");
		out.println("</html>");
		// Close resources
		stmt.close();
		con.close();
		}
		// print out decent erreur messages
		catch(SQLException ex) {
			System.err.println("==> SQLException: ");
			while (ex != null) {
				System.out.println("Message:   " + ex.getMessage ());
				System.out.println("SQLState:  " + ex.getSQLState ());
				System.out.println("ErrorCode: " + ex.getErrorCode ());
				ex = ex.getNextException();
				System.out.println("");
	    			}
			}
        	}
	}
}
