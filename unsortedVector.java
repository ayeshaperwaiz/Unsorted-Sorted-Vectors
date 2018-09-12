//Ayesha Perwaiz 
//unsortedVector.java 
 
import java.io.File; 
import java.io.FileNotFoundException; import java.util.Scanner; import java.util.Vector; 
 
public class unsortedVector 
{ 
    //stores number of assignments and comparisons     
    static long assignments = 0;     
    static long comparisons = 0; 
 
    public static void main(String args[]) 
    { 
        String fileName = "wordlist.txt"; 
 
        Vector<String> readWords = new Vector<String>(); // stores words from file 
        //reads words to file 
        readWords = readFileToVector(fileName);         
        Scanner sc = new Scanner(System.in);         
        sc.close(); 
 
        int uniqueWords = 0; 
 
        uniqueWords = unsortedUniqueCount(readWords); 
 
        //prints out the number of assignments, comparisons, and unique words 
        System.out.println("Number of unique words = " + uniqueWords); 
        System.out.println("Number of assignments = " + assignments);         
        System.out.println("Number of comparisons = " + comparisons); 
 
    } 
 
    //function to count how many times a word appears 
    public static int stringCount(String str, Vector<String> readWords) 
    { 
        int count = 0; 
        for (int i=0; i < readWords.size(); i++) 
        { 
            if (readWords.get(i).equals(str)) 
                count ++; // counts how many times the word appears             
                comparisons++; 
        } 
        return count; 
    }  
 
    public static int unsortedUniqueCount(Vector<String> readWords) 
    { 
        Vector<String> uniqueWords = new Vector<String>(); // stores all unique words 
        Vector<Integer> uniqueCount = new Vector<Integer>(); 
 
        for (int i = 0; i < readWords.size(); i++) 
        { 
            if (!uniqueWords.contains(readWords.get(i))) 
            { 
                uniqueWords.add(readWords.get(i)); 
                uniqueCount.add(stringCount(readWords.get(i), readWords));                 
                assignments++; //increment the number of assignments made 
            } 
            //comparisons made of all words against each other             
            comparisons += uniqueWords.size(); 
         } 
        return uniqueWords.size(); 
    } 
 
    //function that reads contents of text file into vector 
    public static Vector<String> readFileToVector(String fileName) 
    { 
        Vector<String> words = new Vector<String>(); 
        File file = new File(fileName); 
 
        try{ 
            Scanner sc = new Scanner(file);             
            while (sc.hasNextLine()) 
            { 
                String data = sc.nextLine().toLowerCase(); //converts all characters to lowercase                 
                char ch=' ';                 
                if (!data.equals("")) 
                    ch = data.charAt(0); // get first character of string                 
             // adds values to words vector if character is alphabetical.                 
             if (ch >= 'a' && ch <= 'z')                     
              words.add(data); 
            }             
         sc.close(); 
        } 
        catch (FileNotFoundException e) 
        { 
            e.printStackTrace(); 
        }  
        return words; 
    } 
} 
