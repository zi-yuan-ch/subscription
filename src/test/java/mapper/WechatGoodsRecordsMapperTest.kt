package mapper

import com.google.gson.Gson
import com.helios.Application
import com.helios.domain.PromoteChannel
import com.helios.domain.entity.WechatAccountEntity
import com.helios.domain.entity.WechatGoodsRecordsEntity
import com.helios.mapper.WechatAccountMapper
import com.helios.mapper.WechatGoodsRecordsMapper
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
class WechatGoodsRecordsMapperTest {
    @Resource
    lateinit var mapper: WechatGoodsRecordsMapper


    @Test
    fun inset() {
        val entity = WechatGoodsRecordsEntity().apply {
            this.userId = 1L
            this.chattingId = 2L
            this.goodsId = 3L
            this.pid = "4"
            this.channel = PromoteChannel.TAOKE
            this.url ="hello world"
        }
        mapper.insertRecord(entity)
    }
}