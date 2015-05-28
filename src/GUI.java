/**
 * Created by Jeannius on 5/28/2015.
 */
public class GUI {

    static HangmanFrame h;








    public static void main(String[] args){

        h = new HangmanFrame();

        h.setSize(600,600);
        h.setVisible(true);

        int numberOfDashes =100;
        while (numberOfDashes>0){
            numberOfDashes = h.countDashes();
//            System.out.printf("Number of dashes: %d", numberOfDashes);
        }
        System.out.printf("You guessed the word in %d guesses", h.numberOfTries);
        System.exit(0);

    }







}
