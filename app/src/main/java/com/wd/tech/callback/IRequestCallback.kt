package com.wd.tech.callback

interface IRequestCallback {
    fun onSuccess(result: Any)

    fun onFailed(error: String)
}
