package com.ram.e_commerceapp.features.Login;

public class LoginContract {


    interface View {

        void showSuccessfulMessage(String message);

        void showInvalidMessage(String invalidMessage);

    }

    interface Presenter {
        void LoginOnclick(String userName ,String password);

        void LoginAPI(String userName ,String password);



    }

    interface Model {

        boolean loginAPI(String userName, String password);

    }
}
