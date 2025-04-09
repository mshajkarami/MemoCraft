package ir.hajkarami.memocraft.presenter

import ir.hajkarami.memocraft.model.AuthenticationModel
import ir.hajkarami.memocraft.view.AuthenticationView

class AuthenticationPresenter(
    private val view: AuthenticationView,
    private val model: AuthenticationModel
) {
    fun onCreatePresenter() {
        view.onClickHandler()
    }

    interface AuthenticationActions {
        fun onLoginClicked(){}
        fun onSignupClicked(){}
        fun onBackClicked(){}
    }

}