package EX1;
public class BaseConvertor {
    public String binaryToDecimal(String binaryInput) {
        // בדיקת קצה: קלט ריק
        if (binaryInput == null || binaryInput.isEmpty()) {
            // תרגום הודעת שגיאה לאנגלית
            throw new IllegalArgumentException("Binary input cannot be empty");
        }
 
        long decimalResult = 0;
        int power = 0; // החזקה של 2 (מתחילה ב-2^0)
     
        // הלולאה רצה מהסוף להתחלה (מימין לשמאל)
        for (int i = binaryInput.length() - 1; i >= 0; i--) {
            // 'שליפת' התו הנוכחי
            char bit = binaryInput.charAt(i);
 
            if (bit == '1') {
                
                // --- החלק שהתבהר ---
                // השתמשנו ב-Math.pow(2, power) כדי לחשב "2 בחזקת power"
                // Math.pow מחזיר מספר עשרוני (double), 
                // לכן אנו ממירים אותו בחזרה למספר שלם (long) באמצעות (long).
                decimalResult += (long) Math.pow(2, power);
                
            } else if (bit != '0') {
                // אותו טיפול בקלט לא חוקי (מקרה קצה)
                // תרגום הודעת שגיאה לאנגלית
                throw new IllegalArgumentException("Invalid binary input: Character '" + bit + "' is not 0 or 1.");
            }
            
            // אותו קידום של החזקה לביט הבא
            power++;
        }
 
        // החזרת התוצאה העשרונית כמחרוזת
        return String.valueOf(decimalResult);
    }
 
    public String decimalToBinary(String decimalInput) {
        // בדיקת קצה: קלט ריק
        if (decimalInput == null || decimalInput.isEmpty()) {
            // תרגום הודעת שגיאה לאנגלית
            throw new IllegalArgumentException("Decimal input cannot be empty");
        }
 
        long decimalNum;
        try {
            // נסיון להמיר את המחרוזת למספר ארוך (long)
            // trim() מסיר רווחים מיותרים מההתחלה והסוף (מקרה קצה)
            decimalNum = Long.parseLong(decimalInput.trim());
        } catch (NumberFormatException e) {
            // טיפול בקלט לא חוקי (מקרה קצה) - אם הזינו "abc"
            // תרגום הודעת שגיאה לאנגלית
            throw new IllegalArgumentException("Invalid decimal input: '" + decimalInput + "' is not a number.");
        }
 
        // מקרה קצה: קלט 0
        if (decimalNum == 0) {
            return "0";
        }
 
        // מקרה קצה: מספרים שליליים (אם לא רוצים לתמוך בהם)
        if (decimalNum < 0) {
            // תרגום הודעת שגיאה לאנגלית
            throw new IllegalArgumentException("Conversions currently only support positive numbers.");
        }
 
        // נשתמש ב-StringBuilder ליעילות בבניית המחרוזת
        StringBuilder binaryResult = new StringBuilder();
 
        // זהו אלגוריתם "חילוק-ב-2":
        // כל עוד המספר גדול מ-0, אנו בודקים את השארית ומחלקים ב-2.
        while (decimalNum > 0) {
            // (decimalNum % 2) זו השארית (0 או 1). מוסיפים אותה לסוף.
            binaryResult.append(decimalNum % 2);
 
            // (decimalNum / 2) זו תוצאת החילוק השלם.
            decimalNum /= 2;
        }
 
        // התוצאה נבנתה בסדר הפוך (מהספרה הפחות משמעותית למשמעותית)
        // לכן, חובה להפוך אותה לפני ההחזרה.
        return binaryResult.reverse().toString();
    }
}