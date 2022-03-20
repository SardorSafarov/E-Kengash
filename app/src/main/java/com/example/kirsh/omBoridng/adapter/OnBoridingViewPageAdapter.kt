package com.example.kirsh.omBoridng.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoridingViewPageAdapter(
    listFragment: ArrayList<Fragment>,
    fm:FragmentManager,
    lifecycle:Lifecycle
):FragmentStateAdapter(fm,lifecycle)
{
    private val listFragment = listFragment
    override fun getItemCount(): Int = listFragment.size

    override fun createFragment(position: Int): Fragment {
       return listFragment[position]
    }
}