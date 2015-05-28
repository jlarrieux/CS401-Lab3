import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Jeannius on 5/27/2015.
 */
public class TokenizerProgram {

    public static void main(String[] arg  ) throws IOException {

        FileInputStream inFile;
        String fileName ="PROGSAMP.DAT";
        StringBuffer programText= new StringBuffer();

        try {
            inFile = new FileInputStream(fileName);
        }catch (FileNotFoundException e){
            System.out.print("Error opening file"+ fileName);
            return;
        }
        int c;
        BufferedReader bufFinReader = new BufferedReader(new InputStreamReader(inFile));

        while((c=bufFinReader.read())!=-1){
            programText.append((char) c);
        }

//        System.out.print(programText);

        inFile.close();

        StringTokenizer st = new StringTokenizer(programText.toString());

        while(st.hasMoreTokens()){
            System.out.printf("\"%s\"\t", st.nextToken());

        }
    }


}
