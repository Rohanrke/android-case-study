package com.target.targetcasestudy.data.mapper.product

import com.target.targetcasestudy.data.mapper.RemoteToEntityMapper
import com.target.targetcasestudy.data.model.PriceModel
import com.target.targetcasestudy.domain.entity.PriceEntity

class PriceMapper : RemoteToEntityMapper<PriceModel, PriceEntity> {

    override fun map(remote: PriceModel): PriceEntity {
        return PriceEntity(
            amount = remote.amount, currency = remote.currency, display = remote.display
        )
    }
}