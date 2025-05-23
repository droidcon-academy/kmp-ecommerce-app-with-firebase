package com.droidcon.di

import com.droidcon.admin_panel.AdminPanelViewModel
import com.droidcon.data.AdminRepositoryImpl
import com.droidcon.data.CustomerRepositoryImpl
import com.droidcon.data.OrderRepositoryImpl
import com.droidcon.data.ProductRepositoryImpl
import com.droidcon.data.domain.AdminRepository
import com.droidcon.data.domain.CustomerRepository
import com.droidcon.data.domain.OrderRepository
import com.droidcon.data.domain.ProductRepository
import com.droidcon.shared.util.IntentHandler
import com.droidcon.auth.AuthViewModel
import com.droidcon.cart.CartViewModel
import com.droidcon.category_search.CategorySearchViewModel
import com.droidcon.checkout.CheckoutViewModel
import com.droidcon.checkout.domain.PaypalApi
import com.droidcon.details.DetailsViewModel
import com.droidcon.home.HomeGraphViewModel
import com.droidcon.manage_product.ManageProductViewModel
import com.droidcon.payment_completed.PaymentViewModel
import com.droidcon.products_overview.ProductsOverviewViewModel
import com.droidcon.profile.ProfileViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val sharedModule = module {
    single<CustomerRepository> { CustomerRepositoryImpl() }
    single<AdminRepository> { AdminRepositoryImpl() }
    single<ProductRepository> { ProductRepositoryImpl() }
    single<OrderRepository> { OrderRepositoryImpl(get()) }
    single<IntentHandler> { IntentHandler() }
    single<PaypalApi> { PaypalApi() }
    viewModelOf(::AuthViewModel)
    viewModelOf(::HomeGraphViewModel)
    viewModelOf(::ProductsOverviewViewModel)
    viewModelOf(::CartViewModel)
    viewModelOf(::CategorySearchViewModel)
    viewModelOf(::AdminPanelViewModel)
    viewModelOf(::ManageProductViewModel)
    viewModelOf(::DetailsViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::CheckoutViewModel)
    viewModelOf(::PaymentViewModel)
}

expect val targetModule: Module

fun initializeKoin(
    config: (KoinApplication.() -> Unit)? = null,
) {
    startKoin {
        config?.invoke(this)
        modules(sharedModule, targetModule)
    }
}