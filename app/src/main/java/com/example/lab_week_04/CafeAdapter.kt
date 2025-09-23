package com.example.lab_week_04

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CafeAdapter(
    private val context: Context,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val cafes = listOf(
        R.string.starbucks_title to R.string.starbucks_desc,
        R.string.janjijiwa_title to R.string.janjijiwa_desc,
        R.string.kopikenangan_title to R.string.kopikenangan_desc
    )

    override fun getItemCount(): Int = cafes.size

    override fun createFragment(position: Int): Fragment {
        val (titleRes, descRes) = cafes[position]
        val title = context.getString(titleRes)
        val desc = context.getString(descRes)

        val content = "$title\n\n$desc"
        return CafeDetailFragment.newInstance(content)
    }
}
