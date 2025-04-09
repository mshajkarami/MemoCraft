package ir.hajkarami.memocraft.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ir.hajkarami.memocraft.R
import ir.hajkarami.memocraft.presenter.AuthenticationPresenter

class WelcomeFragment : Fragment(), AuthenticationPresenter.AuthenticationActions {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val loginButton: Button = view.findViewById(R.id.btn_login)
        val registerButton: Button = view.findViewById(R.id.btn_register)


        loginButton.setOnClickListener {
            onLoginClicked()
        }

        registerButton.setOnClickListener {
            onSignupClicked()
        }

        return view
    }

    override fun onLoginClicked() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, LoginFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onSignupClicked() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, RegisterFragment())
            .addToBackStack(null)
            .commit()
    }
}
