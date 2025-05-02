import com.tuanfans.JdbcTemplate.service.EmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author TuanFans
 * @date 2025/5/2
 * @description
 */
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:JdbcTemplate/MySQLConfig.xml")
@SpringJUnitConfig(locations = "classpath:JdbcTemplate/MySQLConfig.xml")
public class TestWithSpring {
    @Autowired
    private EmpService empService;
    @Test
    public void test(){
        empService.findEmpByDeptNo(10).forEach(System.out::println);
    }
}
