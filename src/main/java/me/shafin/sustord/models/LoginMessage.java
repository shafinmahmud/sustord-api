/*
 */
package me.shafin.sustord.models;

/**
 *
 * @author SHAFIN
 */
public class LoginMessage {

    private String messageTitle;
    private String messageBody;
    private boolean requestedIdValid;
    private boolean requestedPasswordValid;
    private String requestedId;

    public LoginMessage() {
    }

    public LoginMessage(String messageTitle, String messageBody,
            boolean requestedIdValid, boolean requestedPasswordValid,
            String requestedId) {
        this.messageTitle = messageTitle;
        this.messageBody = messageBody;
        this.requestedIdValid = requestedIdValid;
        this.requestedPasswordValid = requestedPasswordValid;
        this.requestedId = requestedId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public boolean isRequestedIdValid() {
        return requestedIdValid;
    }

    public void setRequestedIdValid(boolean requestedIdValid) {
        this.requestedIdValid = requestedIdValid;
    }

    public boolean isRequestedPasswordValid() {
        return requestedPasswordValid;
    }

    public void setRequestedPasswordValid(boolean requestedPasswordValid) {
        this.requestedPasswordValid = requestedPasswordValid;
    }

    public String getRequestedId() {
        return requestedId;
    }

    public void setRequestedId(String requestedId) {
        this.requestedId = requestedId;
    }

}
