package com.wd.tech.entity

class LoginBean {
    var result: Result? = null
    var status: String? = null
    var message: String? = null

    inner class Result {
        var nickName: String? = null
        var phone: String? = null
        var pwd: String? = null
        var sessionId: String? = null
        var userId: Int = 0
        var userName: String? = null
        var whetherVip: Int = 0
        var whetherFaceId: Int = 0
    }
}
