public class NLPRunner {
  public static void main(String[] args) {

//*Instantiates the password checker and all of the txt files
    
    //*
    String passwordFile = "passwords.txt";
    String symbolsFile = "symbols.txt";
    String numbersFile = "numbers.txt";
    
    Passwordchecker p = new Passwordchecker (passwordFile, symbolsFile, numbersFile);


p.user();


    
    
    
    
  }
}