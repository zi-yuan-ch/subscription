package mapper

import com.google.gson.Gson
import com.helios.Application
import com.helios.domain.entity.WechatAccountEntity
import com.helios.domain.entity.WechatChattingRecordsEntity
import com.helios.mapper.WechatAccountMapper
import com.helios.mapper.WechatChattingRecordsMapper
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
class WechatChattingRecordsMapperTest {
    @Resource
    lateinit var mapper: WechatChattingRecordsMapper


    @Test
    fun insert() {
        val entity = WechatChattingRecordsEntity().apply {
            this.userId = 1L
            this.content = "hello world"
        }
        mapper.insertRecord(entity)
    }
}