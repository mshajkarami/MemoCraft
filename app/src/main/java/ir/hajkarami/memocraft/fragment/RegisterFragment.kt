package ir.hajkarami.memocraft.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.OnBackPressedCallback
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import ir.hajkarami.memocraft.R
import ir.hajkarami.memocraft.databinding.FragmentRegisterBinding
import ir.hajkarami.memocraft.presenter.AuthenticationPresenter
import ir.hajkarami.memocraft.root.AuthenticationActivity
import ir.hajkarami.memocraft.root.MainActivity
import java.time.InstantSource

class RegisterFragment : Fragment(), AuthenticationPresenter.AuthenticationActions {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.btnLogin.setOnClickListener {
            onLoginClicked()
        }
        binding.btnBack.setOnClickListener {
            onBackClicked()
        }
        binding.txtBack.setOnClickListener {
            onBackClicked()
        }
        binding.btnSign.setOnClickListener {
            if (binding.EditTextName.text.toString().isEmpty()){
                binding.TextInputLayoutName.error = "Please enter your name"
                return@setOnClickListener
            }else{
                binding.TextInputLayoutName.error = null
            }
            if (binding.EditTextEmail.text.toString().isEmpty()){
                binding.TextInputLayoutEmail.error = "Please enter your email"
                return@setOnClickListener
            }else{
                binding.TextInputLayoutEmail.error = null
            }
            if (binding.EditTextPass.text.toString().isEmpty()){
                binding.TextInputLayoutPass.error = "Please enter your password"
                return@setOnClickListener
            }else{
                binding.TextInputLayoutPass.error = null
            }

            if (binding.EditTextConfirm.text.toString().isEmpty()){
                binding.TextInputLayoutConfirmPass.error = "Please confirm your password"
                return@setOnClickListener
            }else{
                binding.TextInputLayoutConfirmPass.error = null
            }
            if (binding.EditTextPass.text.toString() != binding.EditTextConfirm.text.toString()){
                binding.TextInputLayoutConfirmPass.error = "Passwords do not match"
                return@setOnClickListener
            }else{
                binding.TextInputLayoutConfirmPass.error = null
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, VerifyFragment())
                .addToBackStack(null)
                .commit()
        }
        return view
    }

    override fun onLoginClicked() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, LoginFragment())
            .addToBackStack(null)
            .commit()
        parentFragmentManager.popBackStack()
    }

    override fun onBackClicked() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, WelcomeFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, WelcomeFragment())
                        .addToBackStack(null)
                        .commit()
                }
            })
    }
}
