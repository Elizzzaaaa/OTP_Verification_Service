## RESTful API developed using Spring Boot

OTP Generation RESTful API developed using Spring Boot. It takes email as an input and send the OTP on the email.
After it is entered it also verifies if it is correct or not. JavaMailSender Interface is used to send OTP on the provided email address.
I have also included the time limit of 5 minutes to enter the OTP, if the OTP is entered after 5 minutes, it will show Error.

You have to provide your email address and app password in the application.properties file. 
