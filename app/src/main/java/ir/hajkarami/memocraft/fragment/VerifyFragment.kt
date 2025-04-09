package ir.hajkarami.memocraft.fragment

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import ir.hajkarami.memocraft.databinding.FragmentVerifyBinding
import ir.hajkarami.memocraft.presenter.AuthenticationPresenter
import ir.hajkarami.memocraft.root.AuthenticationActivity
import ir.hajkarami.memocraft.root.MainActivity
import java.time.InstantSource

class VerifyFragment : Fragment(), AuthenticationPresenter.AuthenticationActions {
    private var _binding: FragmentVerifyBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentVerifyBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.apply {
            btnBack.setOnClickListener { onBackClicked() }
            txtBack.setOnClickListener { onBackClicked() }
        }

        val editTexts = listOf(
            binding.editText1,
            binding.editText2,
            binding.editText3,
            binding.editText4,
            binding.editText5
        )

        for (i in editTexts.indices) {
            editTexts[i].addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    if (s?.length == 1 && i < editTexts.size - 1) {
                        editTexts[i + 1].requestFocus()
                    }
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })
        }
        binding.btnSign.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
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
        parentFragmentManager.popBackStack()
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
