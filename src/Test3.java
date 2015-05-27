//--------------------------------------------------------------------
//
//  Laboratory 3 - PreLab                                  Test3.jshl
//
//  SHELL:
//  Test program for practicing operations in the built-in String ADT
//
//--------------------------------------------------------------------

import java.io.*;

class Test3{


    public static void main( String args[ ] ) throws IOException {
        String a = "a",               // Predefined test strings
               alp= "alp",
               alpha = "alpha",
               epsilon = "epsilon",
               empty = "",
               inputStr;              // Input string   
        int start,                    // A character position
            count;                    // Count of characters    
        char ch,                      // A specified character
             selection;               // Input test selection
        
        //-----------------------------------------------------------------
        // Initialize reader and tokenizer for the keyboard input stream 
        //
        // For top efficiency use a BufferedReader
        //  which will allow reading of a character or an entire line of text
        BufferedReader bufReader =
                        new BufferedReader(new InputStreamReader(System.in));
        // Initialize a tokenizer -
        //   To read tokens (words and numbers separated by whitespace)
        StreamTokenizer tokens = new StreamTokenizer(bufReader);

        // Get user test selection.
        System.out.println("\nTests:");
        System.out.println("  1  Test showstructure operation.");
        System.out.println("  2  Test relational operations (lessThan and gtrThan).");
        System.out.println("  3  Test strCharCount operation.");
        System.out.println("  4  Test findSubstring operation.");
        System.out.println("  5  Test firstLtrWord operation.");
        System.out.print("Select the test to run : ");
        selection = (char)bufReader.read( );

        // Execute the selected test.

        System.out.println( );
        switch ( selection )
        {
        case '1' :
            // Test 1 : Tests use of charAt in the showstructure method.
            System.out.println("Structure of various strings: ");
            System.out.println("string: alpha");
            showStructure(alpha);
            System.out.println("string: epsilon");
            showStructure(epsilon);
            System.out.println("string: a");
            showStructure(a);
            System.out.println("empty string");
            showStructure(empty);
            break;

        case '2' :                                  
            // Test 2 : Tests the relational operations.
            //   (lessThan, equals, gtrThan) - equals is provided by String class
            System.out.println("left" + "\t\t" + "right" + "\t\t" + "<" + "\t" + "=="
                               + "\t" + "> ");
            System.out.println("------------------------------------------------------");
            System.out.println("alpha" + "\t\t\t" + "epsilon" + "\t\t\t"
                               + lessThan(alpha, epsilon) + "\t" + alpha.equals(epsilon) 
                               + "\t" + gtrThan(alpha, epsilon));
            System.out.println("epsilon" + "\t\t\t" + "alpha " + "\t\t\t"
                               + lessThan(epsilon, alpha) + "\t" + epsilon.equals(alpha) 
                               + "\t" + gtrThan(epsilon, alpha));
            System.out.println("alpha" + "\t\t\t" + "alpha " + "\t\t\t"
                               + lessThan(alpha, alpha) + "\t" + alpha.equals(alpha) 
                               + "\t" + gtrThan(alpha, alpha));
            System.out.println("alp" + "\t\t\t" + "alpha " + "\t\t\t" + lessThan(alp, alpha)
                               + "\t" + alp.equals(alpha) + "\t" + gtrThan(alp, alpha));
            System.out.println("alpha" + "\t\t" + "alp  " + "\t\t" + lessThan(alpha, alp) 
                               + "\t" + alpha.equals(alp) + "\t" + gtrThan(alpha, alp));
            System.out.println("a" + "\t\t" + "alpha " + "\t\t" + lessThan(a, alpha) 
                               + "\t" + a.equals(alpha) + "\t" + gtrThan(a, alpha));
            System.out.println("alpha" + "\t\t" + "a   " + "\t\t" + lessThan(alpha, a) 
                               + "\t" + alpha.equals(a) + "\t" + gtrThan(alpha, a));
            System.out.println("empty" + "\t\t" + "alpha " + "\t\t" 
                               + lessThan(empty, alpha) + "\t" + empty.equals(alpha) 
                               + "\t" + gtrThan(empty, alpha));
            System.out.println("alpha" + "\t\t" + "empty " + "\t\t" 
                               + lessThan(alpha, empty) + "\t" + alpha.equals(empty) 
                               + "\t" + gtrThan(alpha, empty));
            System.out.println("empty" + "\t\t" + "empty " + "\t\t" 
                               + lessThan(empty, empty) + "\t" + empty.equals(empty) 
                               + "\t" + gtrThan(empty, empty));
            break;

        case '3' :                                  
            // Test 3 : Tests use of indexOf in the StrCharCount method.
            
            // Get a string from the user.
            // Skip newline first
            bufReader.readLine( );
            System.out.print("Enter a string: ");
            inputStr = bufReader.readLine( );

            // Get a character from the user.
            System.out.print("Enter a character: ");
            ch = (char)bufReader.read( );
 
            // Output the count.
            System.out.println(ch + " occurs " + strCharCount(inputStr, ch)
                               + " times in the string");
            break;

        case '4' :
            // Test 4 : Tests use of substring in the findSubstring method.
            System.out.print("Enter a word : ");
            tokens.nextToken( );
            inputStr = tokens.sval;
            System.out.print("Enter the position of the first character "
                             + "to extract : ");
            tokens.nextToken( );
            start = (int)tokens.nval;
            System.out.print("Enter the number of characters to extract : ");
            tokens.nextToken( );
            count = (int)tokens.nval;
            
            System.out.println("Substring : " + findSubstring(inputStr, start, count));
            break;

        case '5' :
            // Test 5 : Tests use of length, charAt, indexOf in firstLtrWord method.
            // Skip newline first
            bufReader.readLine( );
            System.out.print("Enter a sentence : ");
            inputStr = bufReader.readLine( );
            firstLtrWord(inputStr);
            break;

        default :
            System.out.println("Inactive or invalid test");
        }
    } // main

    //--------------------------------------------------------------------
    //
    // Complete the following methods -- 
    //    these methods are to utilize methods from the built-in class
    //    String.
    //
    //--------------------------------------------------------------------

    static void showStructure (String str)
        // Uses charAt and length
        //   to output the characters in a string. 
    {
    	for(int j=0; j<str.length(); j++){
    		System.out.printf("%d\t %s\n",j,str.charAt(j));
    	}
 
    }

    //--------------------------------------------------------------------

    static boolean lessThan ( String leftString,
                              String rightString )
        // "Less than" relational operator. 
        // Uses compareTo and returns true if leftString is 
        //    less than rightString. Otherwise returns false.
    {
    	boolean result =false;
    	if(leftString.compareTo(rightString)<0) result =true;
        
    	return result;
    }

    //--------------------------------------------------------------------

    static boolean gtrThan ( String leftString,
                             String rightString )
        // "Greater than" relational operator. 
        // Uses compareTo and returns true if leftString is
        //     greater than rightString. Otherwise returns false.
    {
    	boolean result =false;
    	if(leftString.compareTo(rightString)>0) result =true;
    	return result;
    }
    
    static int strCharCount ( String inputString, char ch )
        // Uses indexOf
        // Count the number of times that character ch occurs in
        // inputString. 
    {
    	int count=0,  position=0, tempNumber;
    	for(int i=0; i<inputString.length(); i++){
    		tempNumber = inputString.indexOf(ch, position);
    		
    		if (tempNumber <0) break;
    		else{
    			position =tempNumber+1;
    			count++;
    		}
    		System.out.printf("Count:\t%d\t\t position:\t%d \t\t Tempnumber: \t%d\t\t\n\n", count, position, tempNumber );
    	}
    	
    	return count;

    }
    
    static String findSubstring ( String testStr1, int start, int count )
        // Uses length and substring 
        // Returns a substring of string testStr1 -- start specifies 
        //   the position of the first character to extract and 
        //   count specifies the number of characters to extract.
    {
    	StringBuffer returnString = new StringBuffer();
    	
    	for(int i=0; i<testStr1.length(); i++){
    		if(i>=start && i<(count+start)){
//    			System.out.printf("Current character: %s\t\tstart: %d\t\t i: %d\t\t count: %d\n\n", testStr1.charAt(i), start,i,count);
    			returnString.append(testStr1.charAt(i));
    		}
    	}
    	
    	return String.valueOf(returnString);
    }
    
    static void firstLtrWord ( String inStr )
        // Uses length, charAt, substring, and indexOf
        // Prints the following 
        //   String is:
        //   The string's length is:
        //   The first letter is: 
        //   The last letter is:
        //   The first word is:
        // If the string is empty, prints
        //   String is:
        //   The string's length is: 0
        //   The string is empty! No more data to print.
    {
    	
    	int length = inStr.length();
    	StringBuffer firstWord = new StringBuffer();
    	
    	System.out.printf("String is:\t%s\n", inStr);
    	int positionOfFirstLetter = firstLetterPosition(inStr);
        System.out.printf("\n\nPosition of first letter returning: %d\n\n", positionOfFirstLetter);
    	if(length==0){
    		System.out.printf("The string's length is:\t%d\nThe string is empty! No", length);
    	}
    	else{
    		boolean foundFirstLetter = false;
    		int asciiValue = 0;
    		
    		for(int i=positionOfFirstLetter; i<inStr.length(); i++){
    			asciiValue = inStr.charAt(i);
    			if(asciiValue==32)break;
    			 firstWord.append(inStr.charAt(i));
    			 
    			System.out.printf("First letter found? %b\t\tcurrent character: %sAscii value: %d\n\n", foundFirstLetter, inStr.charAt(i), asciiValue);
    		}
    	
    	System.out.printf("String is:\t %s\nThe string's length is:\t%s\nThe First letter is:\t%s\nThe last letter is:\t%s\nThe first word is:\t%s", 
    									inStr,inStr.length(),inStr.charAt(positionOfFirstLetter),inStr.charAt(length-1), String.valueOf(firstWord));
    	}
    }
    
    
    private static int firstLetterPosition(String inStr){
    	int position=0, asciiValue=32;
    	for(int i=0; i<inStr.length(); i++){
            asciiValue = inStr.charAt(i);
            System.out.printf("\nCurrent character: %s \t with position: %d\t and Ascii value: %d\n", inStr.charAt(i),i, asciiValue);
    		if(asciiValue!=32){
    			position =i;
    			break;
    		}
    	}
    			
    	return position;
    }
    
    
} // class Test3