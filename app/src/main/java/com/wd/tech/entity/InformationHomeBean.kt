package com.wd.tech.entity

class InformationHomeBean {
    var result: List<Result>? = null
    var message: String? = null
    var status: String? = null

    inner class Result {
        var collection: Int = 0
        var id: Int = 0
        var releaseTime: String? = null
        var share: Int = 0
        var source: String? = null
        var summary: String? = null
        var thumbnail: String? = null
        var title: String? = null
        var whetherAdvertising: Int = 0
        var whetherCollection: Int = 0
        var whetherPay: Int = 0
        var infoAdvertisingVo: InfoAdvertisingVo? = null

        inner class InfoAdvertisingVo {
            var content: String? = null
            var id: Int = 0
            var pic: String? = null

        }

    }
}
