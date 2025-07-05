package OTPgeneration.otpGeneration;

public class OtpDetails {

    private String otp;
    private long expirationTime;

    public OtpDetails(String otp, long expirationTime) {
        this.otp = otp;
        this.expirationTime = expirationTime;
    }

    public String getOtp() {
        return otp;
    }

    public long getExpirationTime() {
        return expirationTime;
    }
}
