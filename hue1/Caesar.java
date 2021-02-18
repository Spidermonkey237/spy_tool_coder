package pis.hue1;


/**
 * @author ewoya
 *
 */
public class Caesar implements Codec {
 
	/**
	 *String alpha is a local variable for the alphabet 
	 */
	private String alpha= "abcdefghijklmnopqrstuvwxyz";
	/**
	 * keyword
	 */
	private String schluessel; 
	
	
	/**
	 * Constructor
	 * @param schluessel
	 */
	public Caesar(String schluessel) {
		setzeLosung(schluessel);
	}
	
	/**
	 * empty Constructor
	 */
	public Caesar() {
		setzeLosung("2077");
	}
	
	
	
	
	
	
	/**
	 * @param text here refer to the "Klartext"
	 * @return an integer Array,that contains position each letter of the "klartext" in the alphabet.
	 */
	private int[] toInter(String text) {
		
		int[]intValue=new int [text.length()];
		boolean b =false;
		
		for (int i=0;i<text.length();i++) {
			
			for (int j=0;j<alpha.length();j++) {
				
				  if(alpha.charAt(j)==text.charAt(i) || Character.toUpperCase(alpha.charAt(j))==text.charAt(i) ) {
				  intValue[i]=(j+1);
				  b=true;
				  
				   }
		 }
			if(b==false) {
				intValue[i]=0;
			}	
		
		b=false;
		}
		return intValue;
	}
	
	/**
	 * @param text for  "klartext"
	 * @param key  for   "schluessel"
	 * @param intValue from the method toInter(String)
	 * @return losung the "Losungwort"
	 */
	private char[] coder(String text,String key,int []intValue) {
		
		
		char []losung=new char[text.length()];
		
		for (int i=0;i<text.length();i++) {
			
			if(intValue[i] != 0) {
				if( Character.isUpperCase(text.charAt(i)) ) {
			     losung[i] = Character.toUpperCase(  alpha.charAt( ( ((intValue[i]-1)+ key.length())%26) )  );
				}
				 if( !Character.isUpperCase(text.charAt(i)) ) {
				 losung[i] =   alpha.charAt( ( ((intValue[i]-1)+ key.length())%26 ) )  ;		
				}
			}
			else{
				losung [i]=text.charAt(i);
					}
		}
		return losung; 
		
	}
	
	/**
	 * @param text ("klartext")
	 * @param key ("schluessel")
	 * @param intValue from the method toInter(String)
	 * @return the secret code ("Geheimtext")
	 */
	private char[] decoder(String text,String key,int []intValue){
		
		char []losungchar=new char[text.length()];
		
		for (int i=0;i<text.length();i++) {
			
			if(intValue[i] != 0) {
				if( Character.isUpperCase(text.charAt(i)) ) {
			     losungchar[i] = Character.toUpperCase(  alpha.charAt(  (((intValue[i]-1)+(key.length()*26))- key.length())%26 )  );
				}
				if( !Character.isUpperCase(text.charAt(i)) ) {
				 losungchar[i] =   alpha.charAt(  (((intValue[i]-1)+(key.length()*26))- key.length())%26 )  ;		
				}
			}
			else{
				losungchar [i]=text.charAt(i);
					}
		}
		return losungchar;
	}
	
	
	/**
	 *interface methods
	 */
	@Override
	public String kodiere(String klartext) {
		
		return String.valueOf(coder(klartext,gibLosung(),toInter(klartext) ));
		
		
		}
	
	
	@Override
	public String dekodiere(String geheimtext) {
		
		return String.valueOf( decoder(geheimtext,gibLosung(),toInter(geheimtext)) );
	}
	
	
	@Override
	public String gibLosung() {
		return this.schluessel ;
		
	}
	
	
	
	@Override
	public void setzeLosung(String schluessel) throws IllegalArgumentException {
		
			this.schluessel=schluessel;
			
			
	}
	
	
	
	
}
