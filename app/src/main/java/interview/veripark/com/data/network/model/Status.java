package interview.veripark.com.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mertKaradeniz on 7.11.2021
 * <p>
 * This is an interview project.
 */

public class Status {

    @SerializedName("isSuccess")
    @Expose
    private boolean isSuccess;

    @SerializedName("error")
    @Expose
    private ErrorM error;

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ErrorM getError() {
        return error;
    }

    public void setError(ErrorM error) {
        this.error = error;
    }


    public class ErrorM {

        @SerializedName("code")
        @Expose
        private int code;

        @SerializedName("message")
        @Expose
        private String message;

        public ErrorM(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}