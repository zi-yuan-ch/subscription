package com.helios.dtk

class DtkTwd2TwdResp {
    var requestId: String? = null
    var time: Long? = null
    var code: Int? = null
    var msg: String? = null
    var data: DtkTwd2TwdData? = null

}

class DtkTwd2TwdData {
    //商品ID
    var itemId: Long? = null
    //淘口令
    var tpwd: String? = null
    //针对iOS14版本，增加对应能解析的长口令
    var longTpwd: String? = null
    //佣金比例
    var maxCommissionRate: Double? = null
    //当传入请求参数channelId、specialId、externalId时，该字段展示预估最低佣金率(%)(接联盟通知，官方比价订单佣金调整正式生效时间推迟至7月22日)
    var minCommissionRate: String? = null
    //原始链接
    var originUrl: String? = null
    //商品标题
    var title: String? = null
    //商品优惠券推广链接
    var couponClickUrl: String? = null
    //优惠券面额
    var couponInfo: String? = null
    //优惠券开始时间
    var couponStartTime: String? = null
    //优惠券结束时间
    var couponEndTime: String? = null
    //优惠券总量
    var couponTotalCount: Long? = null
    //优惠券剩余量
    var couponRemainCount: Long? = null
    //短链接
    var shortUrl: String? = null

}