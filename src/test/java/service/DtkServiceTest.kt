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
        val content = "6\uD83D\uDC48 hi:/\uD83D\uDDDDxG5yXVIXjFt\uD83D\uDCB2  吉香居下饭酱暴下饭香菇酱拌饭酱牛肉酱下饭菜拌面酱辣椒酱250g"
        val data = dtwService.twd2twd(content)
        println(data)
    }

    @Test
    fun getItemInfo() {
        val itemId = 611542927430
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
}