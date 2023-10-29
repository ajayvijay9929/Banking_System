package bank_management;

public class CustomEncryption {

    public String customEncrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            int charValue = (int) c;
            encrypted.append(charValue).append(" ");
        }
        return encrypted.toString().trim();
    }

    public String customDecrypt(String encryptedData) {
        StringBuilder decrypted = new StringBuilder();
        String[] parts = encryptedData.split(" ");
        for (String part : parts) {
            int intValue = Integer.parseInt(part);
            decrypted.append((char) intValue);
        }
        return decrypted.toString();
    }
}

