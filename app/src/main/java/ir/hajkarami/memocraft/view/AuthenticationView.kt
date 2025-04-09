package ir.hajkarami.memocraft.view

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import ir.hajkarami.memocraft.databinding.ActivityAuthenticationBinding


class AuthenticationView (contextInstanse : Context) : FrameLayout(contextInstanse) {
    val binding = ActivityAuthenticationBinding.inflate(LayoutInflater.from(context))
    fun onClickHandler (){}
    interface AuthenticationActions {
        fun onLoginClicked()
        fun onSignupClicked()
    }
}