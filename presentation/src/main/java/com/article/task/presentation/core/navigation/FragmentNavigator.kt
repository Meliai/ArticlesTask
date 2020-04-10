package com.article.task.presentation.core.navigation

import androidx.fragment.app.Fragment
import com.article.task.presentation.R

/**
 * [ExtendedNavigator] for [Fragment].
 */
open class FragmentNavigator(
    fragment: Fragment
) : ExtendedNavigator(fragment.activity, fragment.childFragmentManager, R.id.containerView)