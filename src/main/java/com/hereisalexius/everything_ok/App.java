package com.hereisalexius.everything_ok;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*
    	String f0 = args[0];
    	String f1 = args[1];
    	*/
  
    	String f0 = "/home/hereisalexius/pages/sample-0-origin.html";
    	String f1 = "/home/hereisalexius/pages/sample-1-evil-gemini.html";
      	/*	String f2 = "/home/hereisalexius/pages/sample-2-container-and-clone.html";
    	String f3 = "/home/hereisalexius/pages/sample-3-the-escape.html";
    	String f4 = "/home/hereisalexius/pages/sample-4-the-mash.html";
    	*/
        MakeEverythingOkFinder f = new MakeEverythingOkFinder();
        
        System.out.println(f.findButton(f0, f1));

    }
}
