import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import by.gsu.pms.CountClass;

public class Runner {
    public static void main(String[] args) throws Exception {

        CountClass[] word = { new CountClass("book"),
                              new CountClass("Martin"),
        };
        String[] subStr;
        FileReader fr= new FileReader("src/part.txt");
        Scanner scan = new Scanner(fr);

        while (scan.hasNextLine())
        {
            subStr = scan.nextLine().trim().split("\\s+");
            for(int i = 0; i < subStr.length; i++) {
                 subStr[i]=subStr[i].replace(",","")
                                    .replace("\t","")
                                    .replace(".","")
                                    .replace("'","")
                                    .replace("(","")
                                    .replace("\"","")
                                    .replace(")","");
                 for (int j=0;j<word.length;j++){
                     if (subStr[i].equals(word[j].getKeyWord())){word[j].setUnits(word[j].getUnits()+1);}
                 }
            }
        }
        fr.close();
        System.out.println("Not sort:");
        for (int i=0;i<word.length;i++){
            System.out.println(word[i]);
        }
        Arrays.sort(word);
        System.out.println();
        System.out.println("After sort:");
        for (int i=0;i<word.length;i++){
            System.out.println(word[i]);
        }
    }

}