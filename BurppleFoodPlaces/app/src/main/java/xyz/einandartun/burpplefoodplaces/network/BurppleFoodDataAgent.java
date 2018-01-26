package xyz.einandartun.burpplefoodplaces.network;

/**
 * Created by einandartun on 1/12/18.
 */

public interface BurppleFoodDataAgent {

    void LoadFoodItems();

    /**
     * login
     */
    void loginUser(String phoneNo, String password);

    /**
     * Register
     */
    void registerUser(String phoneNo,String password,String name);
}
