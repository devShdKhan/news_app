package com.newsapp.shared.di.modules

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.newsapp.shared.di.QualifierFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
object BaseFragmentModule {

    @QualifierFragment
    @Provides
    @FragmentScoped
    fun provideFragmentLifecycleScope(mFragment: Fragment) = mFragment.lifecycleScope

}