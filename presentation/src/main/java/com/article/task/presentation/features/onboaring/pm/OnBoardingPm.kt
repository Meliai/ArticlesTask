package com.article.task.presentation.features.onboaring.pm

import com.article.task.presentation.core.pm.BasePm
import com.article.task.presentation.core.pm.ServiceFacade
import javax.inject.Inject

class OnBoardingPm @Inject constructor(
    services: ServiceFacade
) : BasePm(services)