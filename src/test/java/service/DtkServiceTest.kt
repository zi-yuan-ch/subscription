package service

import com.helios.Application
import com.helios.service.DtkService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
class DtkServiceTest {
    @Autowired
    private lateinit var dtwService: DtkService
    @Test
    fun twd2twd() {
        val content = "0.0 hihi:/₴9ROkX5lUONg\uD83D\uDCB2  LONKEY香水洗衣凝珠小苍兰持久留香洁净浓缩洗衣液家庭5颗单袋装"
        val data = dtwService.twd2twd(content)
        println(data)
    }

    @Test
    fun getItemInfo() {
        val itemId = 645500259320
        dtwService.getItemInfo(itemId)
    }

    @Test
    fun tbMasterParse() {
        val content = "5\uD83D\uDC48 ha:/《v3tSXftbI1X£  一贝子18k项链女夏2021年新款轻奢小众锁骨链彩金镶施华洛世奇锆"
        val resp = dtwService.tbMasterParse(content)
        println()
    }

    @Test
    fun tbGetOrderDetails() {
        dtwService.getOrderDetails()
    }

    @Test
    fun genTwd() {
        val twd = "https://s.click.taobao.com/8c7phmu"
        val item = dtwService.tbMasterParse(twd) ?: return
        val itemUrl = item.originUrl ?: return
        val userId = "chenankang@qq.com"
        val newTwd = dtwService.genTwd(itemUrl,userId)
        println(newTwd)
    }
}