package com.newsapp.shared.di.modules

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.newsapp.shared.di.QualifierActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object BaseActivityModule {

    @QualifierActivity
    @Provides
    @ActivityScoped
    fun provideActivityLifecycleScope(mActivity: Activity) =
        (mActivity as AppCompatActivity).lifecycleScope

}