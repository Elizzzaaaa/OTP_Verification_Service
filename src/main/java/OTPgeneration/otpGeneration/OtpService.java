package OTPgeneration.otpGeneration;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class OtpService {

    private final Map<String, OtpDetails> otpMap = new HashMap<>();

    public void storeOtp(String email, String otp) {

        OtpDetails otpDetails = new OtpDetails(otp, System.currentTimeMillis()+ TimeUnit.MINUTES.toMillis(5));

        otpMap.put(email, otpDetails);
    }

    public boolean verifyOtp(String email, String userInputOtp) {

        OtpDetails otpDetails = otpMap.get(email);
        if(otpDetails.getOtp()==null || otpDetails.getExpirationTime()<System.currentTimeMillis()) {
            otpMap.remove(email);
            return false;
        }

        boolean isValid = otpDetails.getOtp().equals(userInputOtp);
        if(isValid) {
            otpMap.remove(email);
        }
        return isValid;
    }

}
