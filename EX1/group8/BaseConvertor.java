package EX1.group8; 

import java.math.BigInteger;

public class BaseConvertor {
    public String binaryToDecimal(String binaryInput) {
        if (binaryInput == null || binaryInput.trim().isEmpty()) {
            throw new IllegalArgumentException("קלט בינארי לא יכול להיות ריק");
        }
        String s = binaryInput.trim();
        if (!s.matches("^[01]+$")) {
            throw new IllegalArgumentException("קלט בינארי לא חוקי: מותר רק 0/1");
        }
        // BigInteger עם base 2 פותר גם דיוק וגם גדלים ארוכים
        BigInteger val = new BigInteger(s, 2);
        return val.toString(10);
    }

    public String decimalToBinary(String decimalInput) {
        if (decimalInput == null || decimalInput.trim().isEmpty()) {
            throw new IllegalArgumentException("קלט עשרוני לא יכול להיות ריק");
        }
        String s = decimalInput.trim();
        // תומך במספרים חיוביים בלבד לפי ההנחיות
        if (!s.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("קלט עשרוני לא חוקי: מותר רק ספרות 0-9");
        }
        BigInteger val = new BigInteger(s, 10);
        if (val.signum() == 0) return "0";
        return val.toString(2);
    }
}