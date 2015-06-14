package me.shafin.sustord.services;

import java.io.PrintWriter;
import java.io.StringWriter;
import me.shafin.sustord.models.LoginMessage;
import org.hibernate.HibernateException;

/**
 *
 * @author SHAFIN
 */
public class StudentLoginService extends StudentIdentityService{

    private static final String NULL_RESPONSE = " - ";
    private static final String ERROR_RESPONSE = ":/";
    
     public StudentLoginService(String registrationNo) throws Exception{
        super(StudentIdentityService.forSingletonIdentityService(registrationNo));
        //super(StudentIdentityService.forProtypeIdentityService(registrationNo));
    }

    public boolean verifyRegistrationNo() throws Exception {
        return studentInfo != null;
    }

    public boolean verifyPassword(String password) throws Exception {
        String existingPassword = studentInfo.getPassword();
        return password.equals(existingPassword);
    }
    
    public LoginMessage authenticateStudent(String registrationNo, String password){
       LoginMessage message = new LoginMessage();
        try {
          
            if (verifyRegistrationNo()) {
                message.setRequestedIdValid(true);
                if (verifyPassword(password)) {
                    message.setRequestedPasswordValid(true);
                    message.setMessageTitle("Verified");
                    message.setMessageBody("Login information is correct. Verification successful.");
                    message.setRequestedId(registrationNo);
                } else {
                    message.setRequestedPasswordValid(false);
                    message.setMessageTitle("Access denied");
                    message.setMessageBody("Provided password is wrong.");
                }
            } else {
                message.setRequestedIdValid(false);
                message.setMessageTitle("Unknown ID");
                message.setMessageBody("Provided Registration No is invalid.");
            }

        } catch (HibernateException ex) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String errorString = sw.toString(); // stack trace as a string  

            message.setMessageTitle("Hibernate Exception");
            message.setMessageBody(errorString);
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String errorString = sw.toString(); // stack trace as a string  

            message.setMessageTitle("Server Exception");
            message.setMessageBody(errorString);
        }

        return message;
    }
}
