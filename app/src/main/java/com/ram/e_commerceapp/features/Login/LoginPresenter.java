package com.ram.e_commerceapp.features.Login;

public class LoginPresenter implements LoginContract.Presenter {
     private final LoginContract.View view;
     private final LoginModel loginModel = new LoginModel();

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void LoginOnclick(String userName, String password) {
        if (userName.isEmpty() || password.isEmpty()) {
            view.showInvalidMessage("userName and password is empty");

        } else LoginAPI(userName, password);

    }



    @Override
    public void LoginAPI(String userName, String password) {

        boolean isSuccessed = loginModel.loginAPI(userName, password);
        if (isSuccessed) {
            view.showSuccessfulMessage("Login success");
        } else {
            view.showInvalidMessage("Invalid Login.");
        }


    }
}
