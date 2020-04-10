package com.article.task.presentation.features.onboaring.ui

import android.os.Bundle
import com.article.task.presentation.R
import com.article.task.presentation.features.onboaring.pm.OnBoardingPm
import com.article.task.presentation.core.ui.fragment.BaseFragment
import com.article.task.presentation.core.ui.system_ui.LightStatusBarConfigProvider
import com.article.task.presentation.core.ui.system_ui.StatusBarConfigProvider

class OnBoardingFragment : BaseFragment<OnBoardingPm>() {

    override val screenLayout: Int = R.layout.fragment_onboarding
    override val classToken: Class<OnBoardingPm> = OnBoardingPm::class.java
    override val statusBarConfigProvider: StatusBarConfigProvider = LightStatusBarConfigProvider

    companion object {
        fun newInstance(): OnBoardingFragment {
            return OnBoardingFragment().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }
}
