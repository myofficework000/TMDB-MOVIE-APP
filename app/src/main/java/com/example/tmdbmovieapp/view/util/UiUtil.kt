package com.example.tmdbmovieapp.view.util

import android.content.Context
import android.util.TypedValue
import android.view.MenuItem
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.view.fragment.DetailFragment

object UiUtils {

    // this method is used to tint menu icons for toolbars and other components
    fun tintMenuIcon(context: Context, item: MenuItem, @ColorRes color: Int) {
        val itemIcon = item.icon
        val iconWrapper = DrawableCompat.wrap(itemIcon!!)
        DrawableCompat.setTint(iconWrapper, context.resources.getColor(color))
        item.icon = iconWrapper
    }

    // convert dip to float
    fun dipToPixels(context: Context, dipValue: Float): Float {
        val metrics = context.resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics)
    }

    fun AppCompatActivity.replaceFragment(containerId: Int, fragment: Fragment) {
        supportFragmentManager.inTransaction { replace(containerId, fragment) }
    }
    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }
}