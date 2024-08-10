package asterixorobelix.afrikaburn.di

import asterixorobelix.afrikaburn.viewmodel.CampViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewModelModule = module {
    singleOf(::CampViewModel)
}