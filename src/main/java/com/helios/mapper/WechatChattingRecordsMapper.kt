package com.helios.mapper

import com.helios.domain.entity.WechatChattingRecordsEntity

interface WechatChattingRecordsMapper {
    fun insertRecord(entity: WechatChattingRecordsEntity)
}