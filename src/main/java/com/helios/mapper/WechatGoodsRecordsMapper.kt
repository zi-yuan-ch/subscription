package com.helios.mapper

import com.helios.domain.entity.WechatGoodsRecordsEntity

interface WechatGoodsRecordsMapper {
    fun insertRecord(entity: WechatGoodsRecordsEntity)
}