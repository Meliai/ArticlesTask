package com.article.task.presentation

import androidx.fragment.app.Fragment
import com.article.task.presentation.features.onboaring.ui.OnBoardingFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object OnBoardingFlow : SupportAppScreen() {
        override fun getFragment(): Fragment = OnBoardingFragment.newInstance()
    }
}