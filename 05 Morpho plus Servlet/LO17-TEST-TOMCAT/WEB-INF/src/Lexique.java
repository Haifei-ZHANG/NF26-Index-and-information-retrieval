import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class Lexique{
	
	public int seuilMin;
	public int seuilMax;
	private Map<String, String> Lemmes;
	private ArrayList<String> Stoplist;
	//private String[] motLexique;
	
	public Lexique(BufferedReader brFilt, BufferedReader brSP){
		seuilMin = 3;
		seuilMax = 5;
		Lemmes = new HashMap<String, String>();
		Stoplist = new ArrayList<String>();

		String chaine;
		StringTokenizer tokens;
		try {
		     try {
		         while ((chaine=brFilt.readLine())!=null){
		        	 tokens = new StringTokenizer(chaine);
		        	 Lemmes.put(tokens.nextToken(), tokens.nextToken());
		         }        	  		        	
		     } 
		     catch(EOFException e) {
		          brFilt.close();
		     }
		} 
		catch(IOException e) {
		     System.out.println("IO Exception");
		}
		
		try {
		     try {
		    	 int i = 0;
		         while ((chaine=brSP.readLine())!=null){
		        	 tokens = new StringTokenizer(chaine);
		        	 Stoplist.add(i, tokens.nextToken());
		         }        	  		        	
		     } 
		     catch(EOFException e) {
		          brSP.close();
		     }
		} 
		catch(IOException e) {
		     System.out.println("IO Exception");
		}
	}
		
	
	
	public ArrayList<String> getLemmes(String mot){
		HashMap<String, Float> lemmesCandidats = new HashMap<String, Float>();
		ArrayList<String> meilleureLemmes = new ArrayList<String>();
		try{
			System.out.println("Prétraitement");
			//mot=mot.replaceAll("(\\w+)?(')?(\\w+)","$3");
			//mot=mot.replaceAll("\"(\\w+)?\"","$1");
			//System.out.println(mot);
			if(mot.equals("et")||mot.equals("ou")){
				meilleureLemmes.add(0, "Lexique");
				meilleureLemmes.add(1, mot); 
				return meilleureLemmes;
			}
			Pattern pattern = Pattern.compile("[0-9]*");
			if(pattern.matcher(mot).matches()){
				meilleureLemmes.add(0, "Numéro");
				meilleureLemmes.add(1, mot);
				return meilleureLemmes;
			}
			//si le mot est dans le stoplist, le remplace par vide
			for(String element:Stoplist){
				if(mot.equals(element)){
					return meilleureLemmes;
				} 
					
			}
			
			System.out.println("Lexique");
			String lem = Lemmes.get(mot); 
			if(lem!=null){
				meilleureLemmes.add(0, "Lexique");
				meilleureLemmes.add(1, lem);
				return meilleureLemmes;
			}
            
            //prefix identique
			//if(mot.length()<seuilMin){
			//	return meilleureLemmes;
			//}
			System.out.println("Préfixe");
			meilleureLemmes.add(0, "Préfixe");
			Set<String> keys = Lemmes.keySet();
	        String[] motLexique = new String[keys.size()];
			keys.toArray(motLexique);
			float prox;
			for(String m : motLexique){
				prox = prox(mot, m);
				if(prox >75){
					lemmesCandidats.put(m, prox);
					}	
				}
			
			ArrayList<Map.Entry<String, Float>> list = new ArrayList<Entry<String, Float>>(lemmesCandidats.entrySet());
			Collections.sort(list,(o1,o2)->(int)(o2.getValue()-o1.getValue()));

			String Key =null;
			for(int i=1;i<=list.size();i++){
			  Key = list.get(i-1).getKey();
			  if(Key!=null)
			    meilleureLemmes.add(i, Lemmes.get(Key));
			}
			if(meilleureLemmes.size()>1) { 
				//if((lemmesCandidats.get(meilleureLemmes.get(2))!=null)&&(lemmesCandidats.get(meilleureLemmes.get(1)) >  lemmesCandidats.get(meilleureLemmes.get(2)))){
				//	meilleureLemmes.set(2, null);
				//}
				System.out.println("fin Préfixe");
				return meilleureLemmes;
			}
			  

			//Levenshtein
			System.out.println("Levenshtein");
			float levenshteinDist=0;
			for(String m : motLexique){
			  levenshteinDist = levenshteinDist(mot, m);
			  if(levenshteinDist <= 2){
				  System.out.println(m);
				  System.out.println(levenshteinDist); 
				  lemmesCandidats.put(m, levenshteinDist);
			    }
			}
			ArrayList<Map.Entry<String, Float>> list2 = new ArrayList<Entry<String, Float>>(lemmesCandidats.entrySet());
			Collections.sort(list2,(o1,o2)->(int)(o1.getValue()-o2.getValue()));
			String Key2 ="";
			for(int i=1;i<=list2.size();i++){
			  Key2 = list2.get(i-1).getKey();
			  if((Key2!=null)){
					  meilleureLemmes.add(i, Lemmes.get(Key2));
			}
			}
			if(meilleureLemmes.size()>1){
				//if((lemmesCandidats.get(meilleureLemmes.get(2))!=null)&&(lemmesCandidats.get(meilleureLemmes.get(1)) <  lemmesCandidats.get(meilleureLemmes.get(2)))){
				//	meilleureLemmes[1]=null;
				//	meilleureLemmes[2]=null;
				//}
				meilleureLemmes.set(0, "Levenshtein");
				for(int i=0;i<meilleureLemmes.size()-1;i++){
					for(int j=meilleureLemmes.size()-1;j>i;j--){
						if(meilleureLemmes.get(i).equals(meilleureLemmes.get(j))){
							meilleureLemmes.remove(j);
						}
					}
				}
				return meilleureLemmes;
			}
			
		}catch (Exception e){
			//System.out.println("Aucun mot n’a été trouvé!");
		}
		//System.out.println("Aucun mot n’a été trouvé!");
		System.out.println("Lui même");
		meilleureLemmes.set(0, "Non corrigé");
		meilleureLemmes.add(1, mot);
		return meilleureLemmes;
	}
	
	
	public float prox(String mot1, String mot2){
		int longueur1 = mot1.length();
		int longueur2 = mot2.length();
		float  proxM1M2 = 0;
		if(longueur1 < seuilMin || longueur2 < seuilMin)
			proxM1M2 = 0;
		else if(Math.abs(longueur1 - longueur2) > seuilMax)
			proxM1M2 = 0;
		else{
			int i =0;
			while(i < Math.min(longueur1, longueur2) && (mot1.charAt(i) == mot2.charAt(i))){
				i++;
			}
			proxM1M2 = i * 100 / Math.max(longueur1, longueur2);
		}
		return proxM1M2;
	}
	
	
	private float levenshteinDist(String mot1, String mot2){
		float d1=0,d2=0,d3=0;  //d1:remplace; d2:suppression; d3:insertion
		int longueur1 = mot1.length();
		int longueur2 = mot2.length();
		float dist[][] = new float[longueur1+1][longueur2+1];
		float minD1D2 = 0;
		dist[0][0] = 0;
		for(int i = 1; i <= longueur1; i++){
			dist[i][0] = (float) (dist[i-1][0] + 1.0);
		}
		for(int j = 1; j <= longueur2; j++)
			dist[0][j] = (float) (dist[0][j-1] + 1.0);
		for(int i = 1; i <= longueur1; i++){
			
			for(int j = 1; j <= longueur2; j++){
				if(mot1.charAt(i-1) == mot2.charAt(j-1)){
					d1 = dist[i-1][j-1];
				}
				else {
					if((i<longueur1)&&(j<longueur2)&&(mot1.charAt(i-1)== mot2.charAt(j)) && (mot1.charAt(i)== mot2.charAt(j-1))){
						d1 = (float) (dist[i-1][j-1] + 0.5);					
					}
					else if((i>1)&&(j>1)&&(i<longueur1)&&(j<longueur2)&&(mot1.charAt(i-1)== mot2.charAt(j-2)) && (mot1.charAt(i-2)== mot2.charAt(j-1))){
							d1 = (float) (dist[i-1][j-1] + 0.5);	
					}
					else {
						d1 = (float) (dist[i-1][j-1] + 1.0);
					}
				}
				d2 = (float) (dist[i-1][j] + 1.0);
				d3 = (float) (dist[i][j-1] + 1.0);
				minD1D2 = (d1 < d2)?d1:d2;
				dist[i][j] = (minD1D2 < d3)?minD1D2:d3;
			}
		}
		
		return dist[longueur1][longueur2];
	}
	

}