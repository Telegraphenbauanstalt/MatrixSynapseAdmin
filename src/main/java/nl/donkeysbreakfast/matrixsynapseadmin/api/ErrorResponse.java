package nl.donkeysbreakfast.matrixsynapseadmin.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Telegraphenbauanstalt
 */
public class ErrorResponse {

    private String errcode;
    private String error;

    public ErrorResponse() {
    }

    @JsonProperty
    public String getErrcode() {
        return errcode;
    }

    @JsonProperty
    public String getError() {
        return error;
    }

}
