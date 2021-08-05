package com.kakapo.gostrada

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.kakapo.gostrada.viewModel.LoginViewModel
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ViewModelTest {

    @get: Rule
    var rule: TestRule = InstantTaskExecutorRule()


}