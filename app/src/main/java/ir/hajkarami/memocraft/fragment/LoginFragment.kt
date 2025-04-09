package ir.hajkarami.memocraft.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import ir.hajkarami.memocraft.R
import ir.hajkarami.memocraft.presenter.AuthenticationPresenter

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val txtRegister: Button = view.findViewById(R.id.txt_register)
        val btnBack: ImageButton = view.findViewById(R.id.btn_back)
        val txtBack: Button = view.findViewById(R.id.txt_back)


        txtRegister.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, RegisterFragment())
                .addToBackStack(null)
                .commit()
        }
        btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, WelcomeFragment())
                .addToBackStack(null)
                .commit()
        }
        txtBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, WelcomeFragment())
                .addToBackStack(null)
                .commit()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, WelcomeFragment())
                    .addToBackStack(null)
                    .commit()
            }
        })
    }
}