package com.article.task.presentation.core.navigation

import androidx.fragment.app.FragmentActivity
import com.article.task.presentation.R

/**
 * [ExtendedNavigator] for [FragmentActivity].
 */
class AppNavigator(
    activity: FragmentActivity
) : ExtendedNavigator(activity, activity.supportFragmentManager, R.id.containerView)