package com.shift.weather.presentation


open class BasePresenter<T : BaseView> {

    var view: T? = null

    fun attachView(view: T?) {
        this.view = view

        onViewAttached()
    }

    open fun onViewAttached(){}

    fun detach() {
        view = null
    }
}