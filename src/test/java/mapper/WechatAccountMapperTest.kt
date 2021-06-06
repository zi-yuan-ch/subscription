package mapper

import com.google.gson.Gson
import com.helios.Application
import com.helios.domain.entity.WechatAccountEntity
import com.helios.mapper.WechatAccountMapper
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
class WechatAccountMapperTest {
    @Resource
    lateinit var mapper: WechatAccountMapper

    @Test
    fun selectByUser() {
        val list = mapper.selectByUser("1")
        println(Gson().toJson(list))
    }

    @Test
    fun upsert() {
        val entity = WechatAccountEntity().apply {
            this.userName = "2"
        }
        mapper.upsert(entity)
    }
}