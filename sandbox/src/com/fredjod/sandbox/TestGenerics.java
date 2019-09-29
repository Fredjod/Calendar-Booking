// https://www.jmdoudoux.fr/java/dej/chap-jdk1.5.htm#jdk1.5-1

package com.fredjod.sandbox;
import java.util.*;
public class TestGenerics {
  public static void main(String[] args) {

	    List<String> liste = new ArrayList<String>();
	    String valeur = null;
	    for(int i = 0; i < 10; i++) {
	      valeur = ":"+i;
	      liste.add(valeur);
	    }
	 
	    for (Iterator<String> iter = liste.iterator(); iter.hasNext(); ) {
	      System.out.println(iter.next().toUpperCase());
	    }
	    
	    
  }
}
