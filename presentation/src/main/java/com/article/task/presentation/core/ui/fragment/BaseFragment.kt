package com.article.task.presentation.core.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import com.jakewharton.rxbinding3.view.visibility
import com.article.task.presentation.R
import com.article.task.presentation.core.navigation.BackHandler
import com.article.task.presentation.core.navigation.FlowRouter
import com.article.task.presentation.core.navigation.RouterProvider
import com.article.task.presentation.core.pm.BasePm
import com.article.task.presentation.core.pm.widgets.bindTo
import com.article.task.presentation.core.ui.progress.ProgressDialog
import com.article.task.presentation.core.ui.state_view.StateView
import com.article.task.presentation.core.ui.system_ui.StatusBarConfigProvider
import me.dmdev.rxpm.bindTo

/**
 * Base class for all fragments.
 */
abstract class BaseFragment<T : BasePm> : BasePmFragment<T>(), BackHandler {

    protected abstract val statusBarConfigProvider: StatusBarConfigProvider?

    protected open val backgroundColor: Int? = R.color.color_window_background

    open val progressDialog: ProgressDialog by lazy { ProgressDialog.newInstance() }
    open val router by lazy(LazyThreadSafetyMode.NONE) {
        ((parentFragment ?: activity) as RouterProvider).router as FlowRouter
    }

    private var errorStateView: StateView? = null
    private var emptyStateView: StateView? = null
    private var progressView: View? = null
    private var homeButtonView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return super.onCreateView(inflater, container, savedInstanceState).also { view ->
            errorStateView = view.findViewById<View>(R.id.errorStateView) as? StateView
            emptyStateView = view.findViewById<View>(R.id.emptyStateView) as? StateView
            progressView = view.findViewById(R.id.progressView)
            homeButtonView = view.findViewById(R.id.homeButtonView)
        }
    }

    override fun onResume() {
        super.onResume()
        backgroundColor?.let { activity?.window?.setBackgroundDrawableResource(it) }
    }

    @CallSuper
    override fun onBindPresentationModel(pm: T) {
        errorStateView?.let { stateView -> pm.errorControl.bindTo(stateView) }
        emptyStateView?.let { stateView -> pm.emptyControl.bindTo(stateView) }
        progressView?.let { view -> pm.progressState.bindTo(view.visibility()) }
        homeButtonView?.let { view -> view.setOnClickListener { activity?.onBackPressed() } }
    }

    override fun providePresentationModel(): T {
        val pm = super.providePresentationModel()
        pm.router = router
        return pm
    }

    override fun handleBack() {
        router.exit()
    }

//    protected fun bindProgressDialog(pm: T) {
//        pm.progressState.observable
//            .throttleLast(DEBOUNCE, TimeUnit.MILLISECONDS)
//            .bindTo(progressDialog.visibility(childFragmentManager))
//    }

    companion object {
        const val DEBOUNCE = 300L
    }
}