package ir.hajkarami.memocraft.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import ir.hajkarami.memocraft.root.IntroLandingPageActivity
import ir.hajkarami.memocraft.R

class LandingPage1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_landing_page1, container, false)

        val buttonGetStarted: Button = view.findViewById(R.id.btn_start)

        buttonGetStarted.setOnClickListener {
            (activity as IntroLandingPageActivity).findViewById<ViewPager2>(R.id.viewPager).currentItem = 1
        }

        return view

    }
}