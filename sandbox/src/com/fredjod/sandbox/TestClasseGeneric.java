// https://www.jmdoudoux.fr/java/dej/chap-jdk1.5.htm#jdk1.5-1

package com.fredjod.sandbox;

public class TestClasseGeneric {
	
	public static void main(String[] args) {
	    MaClasseGeneric<Integer, String> maClasse = 
		  new MaClasseGeneric<Integer, String>(1, "valeur 1");
	    Integer param1 = maClasse.getParam1();
	    String  param2 = maClasse.getParam2();
	    System.out.println("parama1: "+ param1 + ", param2: "+ param2);
	  }
}
