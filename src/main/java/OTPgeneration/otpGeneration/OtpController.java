package OTPgeneration.otpGeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OtpController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private OtpService otpService;

    @PostMapping("/sendOtp")
    public String sendOtp(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String otp = emailService.generateOtp();
        otpService.storeOtp(email,otp);
        emailService.sendOtpEmail(email,otp);
        return "OTP sent successfully";
    }

    @PostMapping("/submit")
    public String verify(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String userInputOtp = requestBody.get("otp");
        boolean isValid = otpService.verifyOtp(email,userInputOtp);
        if(isValid) {
            return "You have been verified";
        }
        else return "Error: OTP doesn't match";
    }


}
