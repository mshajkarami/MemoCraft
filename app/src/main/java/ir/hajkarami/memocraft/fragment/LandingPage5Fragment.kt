package ir.hajkarami.memocraft.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment
import ir.hajkarami.memocraft.root.AuthenticationActivity
import ir.hajkarami.memocraft.R

class LandingPage5Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_landing_page5, container, false)

        val buttonNext: AppCompatImageButton = view.findViewById(R.id.intro_btn_next)

        buttonNext.setOnClickListener {
            val intent = Intent(requireContext(), AuthenticationActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }
}