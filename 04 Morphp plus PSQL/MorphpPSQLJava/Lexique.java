import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Lexique{
	
	public int seuilMin;
	public int seuilMax;
	private Map<String, String> Lemmes;
	private ArrayList<String> Stoplist;
	//private String[] motLexique;
	
	public Lexique(){
		seuilMin = 3;
		seuilMax = 5;
		Lemmes = new HashMap<String, String>();
		Stoplist = new ArrayList<String>();

		String fic = "filtronc.txt";
		BufferedReader br=null;
		String chaine;
		StringTokenizer tokens;
		try {
		     try {
		         br = new BufferedReader(new FileReader(fic));
		         while ((chaine=br.readLine())!=null){
		        	 tokens = new StringTokenizer(chaine);
		        	 Lemmes.put(tokens.nextToken(), tokens.nextToken());
		         }        	  		        	
		     } 
		     catch(EOFException e) {
		          br.close();
		     }
		} 
		catch(FileNotFoundException e) {
		     System.out.println("fichier inconnu : " + fic);
		} 
		catch(IOException e) {
		     System.out.println("IO Exception");
		}
		
		
		String sp = "stoplist.txt";
		br=null;
		try {
		     try {
		    	 int i = 0;
		         br = new BufferedReader(new FileReader(sp));
		         while ((chaine=br.readLine())!=null){
		        	 tokens = new StringTokenizer(chaine);
		        	 Stoplist.add(i, tokens.nextToken());
		         }        	  		        	
		     } 
		     catch(EOFException e) {
		          br.close();
		     }
		} 
		catch(FileNotFoundException e) {
		     System.out.println("fichier inconnu : " + sp);
		} 
		catch(IOException e) {
		     System.out.println("IO Exception");
		}
	}
		
	
	
	public String[] getLemmes(String mot){
		HashMap<String, Float> lemmesCandidats = new HashMap<String, Float>();
		String[] meilleureLemmes = new String[]{null,null,null};
		try{
			if(mot.equals("et")||mot.equals("ou")){
				meilleureLemmes[0] = mot;
				return meilleureLemmes;
			}
			Pattern pattern = Pattern.compile("[0-9]*");
			if(pattern.matcher(mot).matches()){
				meilleureLemmes[0] = mot;
				return meilleureLemmes;
			}
			//si le mot est dans le stoplist, le remplace par vide
			for(String element:Stoplist){
				if(mot.equals(element)) return meilleureLemmes;
			}
			
			String lem = Lemmes.get(mot); 
			if(lem!=null){
				meilleureLemmes[0] = lem;
				return meilleureLemmes;
			}
            
            //prefix identique
			//if(mot.length()<seuilMin){
			//	return meilleureLemmes;
			//}
			Set<String> keys = Lemmes.keySet();
	        String[] motLexique = new String[keys.size()];
			keys.toArray(motLexique);
			float prox;
			for(String m : motLexique){
				prox = prox(mot, m);
				if(prox >= 50){
					lemmesCandidats.put(Lemmes.get(m), prox);
					}	
				}
			
			ArrayList<Map.Entry<String, Float>> list = new ArrayList(lemmesCandidats.entrySet());
			Collections.sort(list,(o1,o2)->(int)(o2.getValue()-o1.getValue()));

			String Key =null;
			for(int i=0;i<list.size();i++){
			  Key = list.get(i).getKey();
			  if(Key!=null)
			    meilleureLemmes[i] = Key;
			}
			if(meilleureLemmes[0] != null)
			  return meilleureLemmes;

			//Levenshtein
			int levenshteinDist;
			for(String m : motLexique){
			   levenshteinDist = levenshteinDist(mot, m);
			  if(levenshteinDist < 3){
			    lemmesCandidats.put(Lemmes.get(m), (float) levenshteinDist);
			    }
			}
			ArrayList<Map.Entry<String, Float>> list2 = new ArrayList(lemmesCandidats.entrySet());
			Collections.sort(list2,(o1,o2)->(int)(o1.getValue()-o2.getValue()));
			String Key2 ="";
			for(int i=0;i<list2.size();i++){
			  Key2 = list2.get(i).getKey();
			  if(Key2!=null)
			    meilleureLemmes[i] = Key2;
			}

			if(meilleureLemmes[0]!=null)
			  return meilleureLemmes;
			
		}catch (Exception e){
			//System.out.println("Aucun mot n’a été trouvé!");
		}
		//System.out.println("Aucun mot n’a été trouvé!");
		meilleureLemmes[0] = mot;
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
	
	
	private int levenshteinDist(String mot1, String mot2){
		int d1=0,d2=0,d3=0;  //d1:remplace; d2:suppression; d3:insertion
		int longueur1 = mot1.length();
		int longueur2 = mot2.length();
		int dist[][] = new int[longueur1+1][longueur2+1];
		int minD1D2 = 0;
		dist[0][0] = 0;
		for(int i = 1; i <= longueur1; i++)
			dist[i][0] = dist[i-1][0] + 1;
		for(int j = 1; j <= longueur2; j++)
			dist[0][j] = dist[0][j-1] + 1;
		for(int i = 1; i <= longueur1; i++){
			for(int j = 1; j <= longueur2; j++){
				if(mot1.charAt(i-1) == mot2.charAt(j-1))
					d1 = dist[i-1][j-1];
				else{
					d1 = dist[i-1][j-1] + 1;
				}
				d2 = dist[i-1][j] + 1;
				d3 = dist[i][j-1] + 1;
				minD1D2 = (d1 < d2)?d1:d2;
				dist[i][j] = (minD1D2 < d3)?minD1D2:d3;
			}
		}
		return dist[longueur1][longueur2];
	}
	

}