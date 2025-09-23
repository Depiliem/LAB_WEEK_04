package com.example.lab_week_04

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CafeFragment : Fragment(R.layout.fragment_cafe) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)

        val adapter = CafeAdapter(requireContext(), childFragmentManager, lifecycle)
        viewPager.adapter = adapter

        val cafes = listOf(
            R.string.starbucks_title,
            R.string.janjijiwa_title,
            R.string.kopikenangan_title
        )

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(cafes[position])
        }.attach()
    }
}
