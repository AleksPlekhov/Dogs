package com.mvvm.dogs.presentation.base.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mvvm.dogs.BR
import com.mvvm.dogs.presentation.base.view_handler.BaseViewHandler
import com.mvvm.dogs.presentation.base.view_handler.IViewHandler
import com.mvvm.dogs.presentation.base.view_model.BaseViewModel
import com.mvvm.dogs.presentation.binding.AppBindingComponent


abstract class BindingAct<Bind : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    val Lo = com.mvvm.dogs.utils.Lo(this)


    protected abstract var provideViewModel: Class<VM>
    protected abstract val provideLayoutId: Int
    protected open val provideViewHandler: IViewHandler = BaseViewHandler(this)

    val viewModel by lazy { ViewModelProviders.of(this).get(provideViewModel) }

    protected lateinit var binding: Bind
    private fun provideVariable(): Int = BR.vm


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewHandler()
        DataBindingUtil.setDefaultComponent(AppBindingComponent())
        binding = DataBindingUtil.setContentView<Bind>(this, provideLayoutId)
        binding.setVariable(provideVariable(), viewModel)
        binding.executePendingBindings()
        binding.lifecycleOwner = this

        // viewModel.binding = binding
        viewModel.handleOnCreate()
        viewModel.handleIntent(intent?.extras ?: return)

    }


    private fun initViewHandler() {
        viewModel.viewHandler.observe(this, Observer { provideViewHandler.handleControl(it) })
    }

    override fun onNewIntent(intent: Intent?) {
        viewModel.onNewIntent(intent)
        super.onNewIntent(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.onActivityResult(requestCode, resultCode, data)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        viewModel.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        viewModel.onRestoreInstanceState(savedInstanceState)
        super.onRestoreInstanceState(savedInstanceState)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.onOptionsItemSelected(item)
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()

    }

    override fun onStop() {
        super.onStop()
        viewModel.onStop()
    }


    override fun onBackPressed() {
        if (viewModel.onBackPressed())
            super.onBackPressed()
    }

}