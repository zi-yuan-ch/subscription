package com.helios.dtk

class TbParseContentResp {
    var time: Long? = null
    var code: Int? = null
    var msg: String? = null
    var data: TbParseContentData? = null
}

class TbParseContentData {
    var goodsId: String? = null //商品ID
    var originUrl: String? = null //商品链接
    var originType: String? = null //二合一券
    var commissionRate: Double? = null
    var commissionType: String? = null
    var originInfo: TbParseOriginInfo? = null
}

class TbParseOriginInfo {
    var title: String? = null //商品标题
    var shopName: String? = null //店铺名
    var shopLogo: String? = null //店铺LOGO图
    var image: String? = null //商品主图
    var startTime: String? = null //券开始时间
    var endTime: String? = null //券结束时间
    var amount: Int? = null //券金额
    var startFee: Int? = null //券门槛金额
    var price: Double? = null //商品价格
    var activityId: String? = null //券ID
    var pid: String? = null //PID
    var status: Int? = null //券状态。0:可用; 非0:不可用
}