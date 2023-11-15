package Authentication;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class OTP {
    private String code;
    private Date expiryDate;

    public OTP() {
        this.code = generateCode();
        this.expiryDate = new Date(System.currentTimeMillis() + 5 * 60 * 1000); // 5 minutes
    }

    public String getCode() {
        return code;
    }

    public boolean isExpired() {
        return new Date().after(expiryDate);
    }

    public void sendCode(String phoneNumber) {
        System.out.println("Sending OTP to " + phoneNumber + ": " + code);
    }

    public boolean verifyCode(String enteredCode) {
        return code.equals(enteredCode) && !isExpired();
    }

    public boolean verifyOTP() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the OTP code: ");
        String enteredCode = scanner.nextLine();
        return verifyCode(enteredCode);
    }

    private String generateCode() {
        Random rand = new Random();
        return String.format("%04d", rand.nextInt(10000));
    }
}