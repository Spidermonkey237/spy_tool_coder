package pis.hue1;


/**
 * @author Ewo Tchougang Yann
 * @version 1.0
 * 
 *
 */

public class Wuerfel implements Codec{
 
	
/**
 * String value for the alphabet
 */
private String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
private String schluessel;


/**
 * constructor
 * @param schluessel
 */
public Wuerfel(String schluessel) {
	setzeLosung(schluessel);
}

/**
 * constructor
 */
public Wuerfel() {
	setzeLosung("Test");  
}


 
 
 /**
  * this method calculates the position order of the letters of the "schluessel" and saves them in an array and returns in integer Array 
 * @param schluessel
 * @return integer[]position 
 */
private int[] positionRechnen(String schluessel) {
	 int temp1=0;
	 int temp2=0;
	 int position[] = new int[schluessel.length()];
	 
	 
	 for (int j=0; j<alphabet.length(); j++ ) 
	 {
		 
		 for( int i =0; i<schluessel.length();i++) {
			  if (schluessel.charAt(i)==alphabet.charAt(j) || ( schluessel.charAt(i)==Character.toLowerCase(alphabet.charAt(j)) )) {
				  position[temp1]=temp2;
				 temp1++;
			 }
		 ++temp2;
			  }
	temp2=0;
	  }
	 
	 return position;
 }
 
 
 /**
  * this method does the cubic coding and returns the secret word
 * @param schluessel
 * @param input (klartext)
 * @param position from the method PositionRechnen
 * @return a String (geheimtext)
 */
	private char[] wurfelCodieren(String schluessel, String input,int []position)  {
 
	 int temp=0;
	char geheimtext[]=new char [input.length()];
	 
	 
	 for(int i=0;i< schluessel.length();i++) {
		 
		 for (int j= position[i];j<input.length();j= j+ schluessel.length()  ) {
			 geheimtext[temp]= input.charAt(j);
			  temp++;
		 }
	 }
  
   return geheimtext;   
   }


 


 /**
  * this method calculates the length of each column in the cubic coding.
 * @param schluessel
 * @param position
 * @param input
 * @return
 */
private int[] spalteLaenge(String schluessel,int[]position,String input) {
	 int [] laenge = new int[input.length()];
 
	 for(int i=0;i<schluessel.length();i++) {
		 laenge[i]=( ( ( input.length()-1 )-position[i] ) /schluessel.length() )+1  ;
     }
	 return laenge;
 }
 
 /**
  * this method allows decoding 
 * @param schluessel
 * @param laenge from the method spaltelaenge(String,int[],String)
 * @param position
 * @param input
 * @return a String(klartext)
 */
private String geheimFinder(String schluessel,int []laenge,int []position,String input) {
	 int temp=0;
	 int temp1=0;
	 char array_klartext[]=new char [input.length()];
	 String klartext;
	 
 for(int i =0;i<schluessel.length();i++) {
		 
		 for(int j =1; j<=laenge[i] ;j++) {
			 array_klartext[( (position[i])+temp)] = input.charAt(temp1); //ici tu vas juste changer losungwort1 avec ce que l'utilisateur veut
			 temp= temp+(schluessel.length());
			 ++temp1;
		 }
		temp=0;
	 }
        klartext =String.valueOf(array_klartext);
	 	return  klartext;
 }


 
 
 /**
 *interface methods
 * @throws Exception 
 */


@Override

public String kodiere(String klartext)  {
	 String a=null;
	
		try {
			a=String.valueOf ( wurfelCodieren( gibLosung(),klartext,positionRechnen(gibLosung())) );
		} catch (Exception e) {
			
			System.out.println("invalid key");
		}
		
		
	    return a;
		
}


@Override
public String dekodiere(String geheimtext) {
	String b=null;
	
	int position1[]=positionRechnen(gibLosung());
	int[]laenge1=spalteLaenge(gibLosung(),position1,geheimtext);
	
	try{
		
		b= geheimFinder(gibLosung(),laenge1,position1,geheimtext);
		
	}catch(Exception e) {
		System.out.println("Invalid key");
	}
	
	return b;
	
	
}


@Override
public String gibLosung() {
	
	return this.schluessel;
	
}


@Override
public void setzeLosung(String schluessel)throws IllegalArgumentException {
	
	this.schluessel=schluessel;
	
}





}
