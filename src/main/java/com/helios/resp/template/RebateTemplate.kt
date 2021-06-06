package com.helios.resp.template

object RebateTemplate {
    fun replayWithCoupon(title: String,
                         reservePrice: Double,
                         finalPrice: Double,
                         couponInfo: String,
                         rate: Double,
                         twd: String): String {
        return """
                 一一一反 莉 消 息一一一
                 $title
                【原价】${reservePrice}
                【折扣价】${finalPrice}
                【优惠券】$couponInfo
                【返利】$rate%
                ----------下单方法--------
                ①复制 $twd
                ②打开手机陶 宝，领券下单
                （请勿使用陶金币、荭包、集分宝） 
            """.trimIndent()
    }

    fun replayWithCommission(title: String,
                             reservePrice: Double,
                             finalPrice: Double,
                             rate: Double,
                             twd: String):String {
        return """
                 一一一反 莉 消 息一一一
                 $title
                【原价】${reservePrice}
                【折扣价】${finalPrice}
                【返利】$rate%
                ----------下单方法--------
                ①复制 $twd
                ②打开手机陶 宝，领券下单
                （请勿使用陶金币、荭包、集分宝） 
            """.trimIndent()
    }
}