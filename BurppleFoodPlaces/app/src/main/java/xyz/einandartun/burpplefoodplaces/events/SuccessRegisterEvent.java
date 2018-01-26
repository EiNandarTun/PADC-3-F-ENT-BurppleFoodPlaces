package xyz.einandartun.burpplefoodplaces.events;

import xyz.einandartun.burpplefoodplaces.data.vo.RegisterUserVO;

/**
 * Created by einandartun on 1/27/18.
 */

public class SuccessRegisterEvent {
    private RegisterUserVO registerUserVO;

    public SuccessRegisterEvent(RegisterUserVO registerUserVO) {
        this.registerUserVO = registerUserVO;
    }

    public RegisterUserVO getRegisterUserVO() {
        return registerUserVO;
    }
}
