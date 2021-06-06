package com.helios.mapper

import com.helios.domain.entity.WechatAccountEntity
import org.apache.ibatis.annotations.Param

interface WechatAccountMapper {
    fun selectByUser(@Param("userName") userName: String): WechatAccountEntity?

    fun upsert(entity: WechatAccountEntity)
}