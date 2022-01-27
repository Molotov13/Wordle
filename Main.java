import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;

public class Main {
  private static int credit = 4;
  public static void main(String[] args) {
    ArrayList<String> dict = new ArrayList<String>();
    try {
      File myObj = new File("words.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        dict.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    Scanner scanner = new Scanner(System.in);
    String key = new String(dict.get((int)(Math.random() * dict.size())));
    while(key.length() != 5) key = new String(dict.get((int)(Math.random() * dict.size())));
    word myWord = new word(key);

    System.out.println("WORDLE");
    System.out.println("! for a right letter in a right place");
    System.out.println("? for a right letter in a wrong place");
    System.out.println("* for a wrong letter");
    System.out.println("The length of the key word is " + myWord.length +".");
    
    while(credit > 0 && myWord.getStatus()){
		  String str = scanner.nextLine();
      while(dict.contains(str+"\n")|| !myWord.legit(str)){
        System.out.println("Invalid Input.");
		    str = scanner.nextLine();
      };
      myWord.display(str);
      credit --;
    }
    if(credit > 0){
      System.out.println("You win!");
    }
    else{
      System.out.println("You lost. The key word is " + myWord.key);
    }
  }
}