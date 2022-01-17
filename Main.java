import java.util.*;

public class Main {
  private static int credit = 5;
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    word myWord = new word("bobby");

    System.out.println("WORDLE");
    System.out.println("! for a right letter in a right place");
    System.out.println("? for a right letter in a wrong place");
    System.out.println("* for a wrong letter");
    System.out.println("The length of the key word is " + myWord.length +".");
    
    while(credit > 0 && myWord.getStatus()){
		  String str = scanner.nextLine();
      while(!myWord.legit(str)){
        System.out.println("Invalid Input.");
		    str = scanner.nextLine();
      };
      myWord.display(str);
    }
    if(credit > 0){
      System.out.println("You win!");
    }
    else{
      System.out.println("You lost. The key word is " + myWord.key);
    }
  }
}