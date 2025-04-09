package ir.hajkarami.memocraft.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import ir.hajkarami.memocraft.root.IntroLandingPageActivity
import ir.hajkarami.memocraft.R

class LandingPage3Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_landing_page3, container, false)

        val buttonNext: AppCompatImageButton = view.findViewById(R.id.intro_btn_next)

        buttonNext.setOnClickListener {
            (activity as IntroLandingPageActivity).findViewById<ViewPager2>(R.id.viewPager).currentItem = 3
        }

        return view
    }
}