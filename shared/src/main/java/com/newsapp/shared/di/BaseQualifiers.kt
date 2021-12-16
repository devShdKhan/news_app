package com.newsapp.shared.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class QualifierActivity

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class QualifierFragment