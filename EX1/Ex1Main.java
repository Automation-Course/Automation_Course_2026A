package EX1;
import java.util.Scanner;

// שם המחלקה שונה ל-Ex1Main כדי להתאים לשם הקובץ
public class Ex1Main {
	public static void main(String[] args) {
        
        // שים לב: שורה זו תציג שגיאה עד שניצור את הקובץ BaseConvertor.java
        BaseConvertor convertor = new BaseConvertor(); 
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // כל העברית הוחלפה באנגלית כדי למנוע ג'יבריש
            System.out.println("Converter: Binary <-> Decimal");
            System.out.println("Please select an operation:");
            System.out.println("1. Convert Binary to Decimal");
            System.out.println("2. Convert Decimal to Binary");
            System.out.println("3. Exit"); 
            System.out.println("Enter 1, 2 or 3");

            String choice = scanner.nextLine();
            try {
                if (choice.equals("1")) {
                    System.out.println("Test: Binary -> Decimal");
                    System.out.println("Enter a binary number: ");
                    String binInput = scanner.nextLine();
                    String decOutput = convertor.binaryToDecimal(binInput);
                    System.out.println("The decimal result is: " + decOutput);

                } else if (choice.equals("2")) {
                    System.out.println("Test: Decimal -> Binary");
                    System.out.println("Enter a decimal number: ");
                    String decInput = scanner.nextLine();
                    String binOutput = convertor.decimalToBinary(decInput);
                    System.out.println("The binary result is: " + binOutput);
                    
                } else if (choice.equals("3")) {
                    System.out.println("Exiting calculator...");
                    break; 
                    
                } else {
                    System.err.println("Invalid choice. Please enter 1, 2, or 3");
                }

            } catch (IllegalArgumentException e) {
                // תפיסת שגיאות קלט (כמו "102" בבינארי או "abc" בעשרוני)
                System.err.println("Input error: " + e.getMessage());
            } 
        } 
        scanner.close();
        System.out.println("Calculator closed.");
    }
}