package me.shafin.sustord.services;

import java.sql.SQLException;
import me.shafin.sustord.models.LoginMessage;
import org.hibernate.HibernateException;

/**
 *
 * @author SHAFIN
 */
public class StudentLoginService extends StudentIdentityService {

    public StudentLoginService(String registrationNo) throws HibernateException, SQLException{
        super(StudentIdentityService.forSingletonIdentityService(registrationNo));
        //super(StudentIdentityService.forProtypeIdentityService(registrationNo));
    }

    public boolean verifyRegistrationNo() {
        return studentInfo != null;
    }

    public boolean verifyPassword(String password) {
        String existingPassword = studentInfo.getPassword();
        return password.equals(existingPassword);
    }

    public LoginMessage authenticateStudent(String password) {
        LoginMessage message = new LoginMessage();

        if (verifyRegistrationNo()) {
            message.setRequestedIdValid(true);
            if (verifyPassword(password)) {
                message.setRequestedPasswordValid(true);
                message.setMessageTitle("Verified");
                message.setMessageBody("Login information is correct. Verification successful.");
                message.setRequestedId(studentInfo.getRegistrationNo());
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

        return message;
    }
}
