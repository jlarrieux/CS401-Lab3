import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * Created by Jeannius on 5/27/2015.
 */
public class Hangman {

    int numberOfDashes;
    static StringBuffer guessTemplate;
    public static void main(String[]arg)throws IOException{

        InputStreamReader reader = new InputStreamReader(System.in);
        StreamTokenizer tokens = new StreamTokenizer(reader);

        System.out.print("Enter the secret word: ");
        tokens.nextToken();
        String secretWord =(String)tokens.sval;
        guessTemplate = createTemplate(secretWord);
//        System.out.print(guessTemplate);
        int numberOfDashes = guessTemplate.length(), numberOfTries=0;
        while(numberOfDashes>0) {
            numberOfTries++;
            System.out.print("\nGuess a letter: ");
            tokens.nextToken();
            char guessedLetter = (char) tokens.sval.charAt(0);
            updateTemplate(secretWord,guessedLetter,guessTemplate);
            numberOfDashes = countDashes(guessTemplate);
            System.out.print(guessTemplate);
        }

        System.out.printf("\nYou guessed the word in %d guesses", numberOfTries);
    }



    public static StringBuffer createTemplate(String secretWord){
        StringBuffer template = new StringBuffer();
        new StringBuffer();
        for(int i=0; i<secretWord.length(); i++) template.append("-");
        return template;
    }

    public static void updateTemplate(String secretWord, char guessedLetter, StringBuffer guessTemplate){
        for (int i = 0; i < secretWord.length(); i++) {
            if (guessedLetter == secretWord.charAt(i)){
                guessTemplate.replace(i, i + 1, String.valueOf(guessedLetter));

            }
        }
    }

    private static int countDashes(StringBuffer guessTemplate){
        int count =0;
        for(int i=0; i<guessTemplate.length(); i++){
            if(guessTemplate.charAt(i)==45 ){
                count ++;
            }
        }
        return count;
    }

}
