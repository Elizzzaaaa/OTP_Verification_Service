package OTPgeneration.otpGeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendOtpEmail(String receiver, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(receiver);
        message.setSubject("OTP Verification");
        message.setText("Your OTP code is " + otp + ". Valid for 5 minutes");
        mailSender.send(message);

    }

    public String generateOtp() {

    Random random = new Random();
    int otp = 100000 + random.nextInt(900000);
    return String.valueOf(otp);

    }

}
