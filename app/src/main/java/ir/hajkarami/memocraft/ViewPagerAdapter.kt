package ir.hajkarami.memocraft

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ir.hajkarami.memocraft.fragment.LandingPage1Fragment
import ir.hajkarami.memocraft.fragment.LandingPage2Fragment
import ir.hajkarami.memocraft.fragment.LandingPage3Fragment
import ir.hajkarami.memocraft.fragment.LandingPage4Fragment
import ir.hajkarami.memocraft.fragment.LandingPage5Fragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments = listOf(
        LandingPage1Fragment(),
        LandingPage2Fragment(),
        LandingPage3Fragment(),
        LandingPage4Fragment(),
        LandingPage5Fragment()
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}