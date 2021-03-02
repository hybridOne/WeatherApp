package com.shift.weather.presenter

import com.shift.weather.view.BaseView

open class BasePresenter<View : BaseView> {

    var view: View? = null

    fun attachView(view: View) {
        this.view = view


        onViewAttached()
    }

    open fun onViewAttached(){

    }

    fun detach() {
        view = null
    }
}