import java.util.ArrayList;
import java.util.Scanner;

public class Passwordchecker {
  private ArrayList<String> passwords;
private ArrayList<String> symbols;
private ArrayList<String> numbers;

//*Makes a toStringList for each file with the this. method
public Passwordchecker (String passwordFile, String symbolsFile, String numbersFile) {
  this.passwords = FileReader.toStringList(passwordFile);
  this.symbols = FileReader.toStringList(symbolsFile);
  this.numbers = FileReader.toStringList(numbersFile);
}

//* The makeReccomendation method takes the password the user inputted and suggests whether 
//putting a symbol or number would make it stronger with the hasNumber method. It starts at false
//and if the password has a number it returns true, otherwise if the password does not have a number, 
//it tells the user to add a number to their password
  //*
  public String makeReccomendation(String password) {
    String recs = "";
    // TODO: Check to see if it has a number.
    // 1. Traverse the numbers ArrayList (use i, .size())
    boolean hasNumber = false;
    for (int i = 0; i < numbers.size(); i++) {
      // 2. Get the current number (String currentNumber) (.get(i))
      String currentNumber = numbers.get(i);
      // 3. If the password.indexOf(currentNumber) == -1
      if (password.indexOf(currentNumber) != -1) {
        hasNumber = true;
      }
    }
    if (!hasNumber) {
      recs += "Add a number to your password";
    }

  //*The boolean hasSymbol method does the same thing as the makeRecommendation method but for symbols.
  //it checks if the password inputted by the user has a symbol or not, and if it does not, it returns
  //to the user to add a symbol to their password. This happens only if the password is weak.
    //*
    boolean hasSymbol = false;
    // TODO: Check to see if it has a symbol
    // 1. Traverse the symbols ArrayList (use i, .size())
    for (int i = 0; i < symbols.size(); i++) {
      // 2. Get the current symbol (String currentSymbol) (.get(i))
      String currentSymbol = symbols.get(i);
      // 3. If the password.indexOf(currentSymbol) == -1
      if(password.indexOf(currentSymbol) != -1) {
        hasSymbol = true;
      }
    }
    if (!hasSymbol) {
      recs += "\nAdd a symbol to your password";
    }
    return recs;
  }


  //*This method traverses through the password ArrayList written by the user and uses a file reader to do that.
  //It will get the user password using a .get method and then will check if the password matches anything
  //in the password.txt file and if it does it will return false which means it is a weak password, otherwise 
  //it returns true which means the password is strong.
  public boolean checkPasswordStrength(String password) {
    // 1. Travers your passwords ArrayList
    ArrayList<String> passwords = FileReader.toStringList("passwords.txt");
    // 2. Get the current password using the .get() method
    for (int index = 0; index < passwords.size(); index++) {
    String pw = passwords.get(index);
    // 3. Check if the password parameter equals the current password
    if (password.equals(pw)) {
      // 4. If a match, return false 
      return false;
    }

  }


    return true;
  }

//*This user method prints out and makes a new scanner system. It first prompts the user to input their password
//then, it uses the checkPasswordStrength method to take the userPassword and check if it is weak or strong using
//an if else statement.
  //*
  public void user() {
  Scanner input = new Scanner(System.in);

  System.out.println("Hello! Please enter your password: ");
  String userPassword = input.nextLine();
  
  boolean passcheck = checkPasswordStrength(userPassword);
  if (passcheck) {
    System.out.println("Your password is strong");
  } else {
    System.out.println("Your password is weak");
    String reccomendations = makeReccomendation(userPassword);
    System.out.println(reccomendations);
  }
  
}
}