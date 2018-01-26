package xyz.einandartun.burpplefoodplaces.network.responses;

import com.google.gson.annotations.SerializedName;

import xyz.einandartun.burpplefoodplaces.data.vo.RegisterUserVO;

/**
 * Created by einandartun on 1/27/18.
 */

public class RegisterResponse {
    private int code;
    private String message;
    @SerializedName("register_user")
    private RegisterUserVO registerUserVO;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public RegisterUserVO getRegisterUserVO() {
        return registerUserVO;
    }
}
