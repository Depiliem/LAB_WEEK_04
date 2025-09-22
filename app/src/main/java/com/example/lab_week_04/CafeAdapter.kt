package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

// List of cafe titles (resource IDs)
val TABS_FIXED: List<Int> = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title
)

class CafeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = TABS_FIXED.size

    override fun createFragment(position: Int): Fragment {
        // Kirim posisi tab ke CafeDetailFragment
        return CafeDetailFragment().apply {
            arguments = Bundle().apply {
                putInt("TAB_POSITION", position)
            }
        }
    }
}
