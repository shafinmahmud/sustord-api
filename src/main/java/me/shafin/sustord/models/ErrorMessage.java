/*
 */
package me.shafin.sustord.models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SHAFIN
 */
@XmlRootElement
public class ErrorMessage {
    
    private String errorCode;
    private String errorTitle;
    private String errorBody;
    private String documentation;

    public ErrorMessage(){      
    }

    public ErrorMessage(String errorCode, String errorTitle, String errorBody, String documentation) {
        this.errorCode = errorCode;
        this.errorTitle = errorTitle;
        this.errorBody = errorBody;
        this.documentation = documentation;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorTitle() {
        return errorTitle;
    }

    public void setErrorTitle(String errorTitle) {
        this.errorTitle = errorTitle;
    }

    public String getErrorBody() {
        return errorBody;
    }

    public void setErrorBody(String errorBody) {
        this.errorBody = errorBody;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    
}
