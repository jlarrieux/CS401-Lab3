import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jeannius on 5/28/2015.
 */
public class HangmanFrame extends Frame implements ActionListener{

    public final static String GUESSMYSECRETWORD ="GUESS MY SECRET WORD";
    public final static String ENTERTHESECRETWORD ="Enter the secret word: ";
    Label secretLabel, templateLabel;
    TextField guessText, secretText;
    StringBuffer guessTemplate;
    String secretWord;
    int  numberOfTries=0;


    public HangmanFrame(){
        setLayout(new FlowLayout());
        secretLabel = new Label(ENTERTHESECRETWORD, Label.CENTER);

        add(secretLabel);
        toNextRow();
        templateLabel = new Label("-----------------------------------------------", Label.CENTER);
        secretText = new TextField(15);
        add(secretText);
        guessTemplate = new StringBuffer();
        guessTemplate.append("---");
        guessText = new TextField(1);
        secretText.addActionListener(this);
        guessText.addActionListener(this);
    }



    void toNextRow( )
    {
        // Add a horizontal line in the background color.  The line itself is
        // invisible, but it serves to force the next component onto a new line.
        Canvas line = new Canvas( );
        line.setSize(10000, 1);
        line.setBackground(getBackground( ));
        add(line);
    }




        @Override
        public void actionPerformed(ActionEvent e) {
            char ch=0;
            System.out.printf("Action Performed: %s\n\n", e.getActionCommand());
            if(secretLabel.getText().equals(HangmanFrame.ENTERTHESECRETWORD)) recordSecretWord();
            else if(secretLabel.getText().equals(HangmanFrame.GUESSMYSECRETWORD)){
                ch = guessText.getText().charAt(0);
                System.out.printf("GUESSED LETTER: %s\n", ch);
                if(guessText.getText().length()>0){
                    updateTemplate(secretWord,ch);
                    System.out.printf("Number of dashes : %d", countDashes());

                }
            }
            guessText.setText("");
            templateLabel.setText(guessTemplate.toString());
            doLayout();
            if(countDashes()==0){
//                secretText.removeActionListener(this);
                guessText.removeActionListener(this);
            }

        }


    private void recordSecretWord(){
        System.out.print("Doing record");
        secretWord = secretText.getText();
        secretText.setText("");
        secretLabel.setText(HangmanFrame.GUESSMYSECRETWORD);

        remove(secretText);
        add(guessText);
        toNextRow();
        guessTemplate = createTemplate(secretWord);


        templateLabel.setFont(new Font("Courier", Font.PLAIN, 18));


        add(templateLabel);
        guessText.requestFocus();
        doLayout();
        secretText.removeActionListener(this);
    }


    private StringBuffer createTemplate(String secretWord){
        StringBuffer template = new StringBuffer();
        new StringBuffer();
        for(int i=0; i<secretWord.length(); i++) template.append("-");
        return template;
    }

    private void updateTemplate(String secretWord, char guessedLetter){
        for (int i = 0; i < secretWord.length(); i++) {
            if (guessedLetter == secretWord.charAt(i)){

                numberOfTries++;
                guessTemplate.replace(i, i + 1, String.valueOf(guessedLetter));

            }
        }
    }


    public int countDashes(){
        int count =0;
        for(int i=0; i<guessTemplate.length(); i++){
            if(guessTemplate.charAt(i)==45 ){
                count ++;
            }
        }
        return count;
    }





}
