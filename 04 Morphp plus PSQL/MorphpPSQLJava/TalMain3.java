import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

//import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;


public class TalMain3 {

public static void main(String args[]) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Requête : ");
                String s = scanner.nextLine();
                //System.out.println(s);
                while (!s.equals("*")) {
                	try{
                		String requetNormalise = "";
                        StringTokenizer mots = new StringTokenizer(s);
                        Lexique monLexique = new Lexique();
                        String motActuel;
                        HashMap<String, String[]> bestLemmes = new HashMap<String, String[]>();

                        while(mots.hasMoreTokens()){
                      	  motActuel = mots.nextToken().toLowerCase();
                      	  bestLemmes.put(motActuel,monLexique.getLemmes(motActuel));
                      	  if(bestLemmes.get(motActuel)[0] != null)
                      	  requetNormalise += " " + bestLemmes.get(motActuel)[0];
                        }
                        requetNormalise += ".";
                        System.out.println("requêt normalisé : "+requetNormalise);
                		
                		
                        tal_sqlLexer lexer = new tal_sqlLexer(new ANTLRReaderStream(new StringReader(requetNormalise)));
                        CommonTokenStream tokens = new CommonTokenStream(lexer);
                        tal_sqlParser parser = new tal_sqlParser(tokens);
                        String arbre = parser.listerequetes();
                        System.out.println(arbre);
                        arbre = arbre.replaceAll("\\(|\\)", "");
                        arbre = arbre.replaceAll("\\s{1,}"," ");
                        arbre = arbre+";";
                        System.out.println("SQL : "+arbre);
                        InterrogPostgresql interroPsql = new InterrogPostgresql();
                        interroPsql.runSQL(arbre);
                		} catch(Exception e) {  }
                		System.out.print("Requête :");
                		s = scanner.nextLine();
                }
        }
}
