import com.tuanfans.jdbcNoXml.config.SpringConfig;
import com.tuanfans.JdbcTemplate.pojo.Dept;
import com.tuanfans.JdbcTemplate.pojo.Emp;
import com.tuanfans.JdbcTemplate.service.AccountService;
import com.tuanfans.jdbcNoXml.service.AccountServiceNoXml;
import com.tuanfans.JdbcTemplate.service.DeptService;
import com.tuanfans.JdbcTemplate.service.EmpService;
import com.tuanfans.jdbcNoXml.service.serviceImpl.AccountServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @author TuanFans
 * @date 2025/4/30
 * @description
 */
public class JdbcTest {
    static AbstractApplicationContext ioc = null;
    static EmpService empService = null;
    static DeptService deptService = null;
    static AccountService accountService = null;
    @BeforeAll
    public static void init(){
        ioc = new ClassPathXmlApplicationContext("JdbcTemplate/MySQLConfig.xml");
        empService = ioc.getBean(EmpService.class);
        deptService = ioc.getBean(DeptService.class);
        accountService = ioc.getBean(AccountService.class);
    }

    @AfterAll
    public static void close(){
        ioc.close();
    }

    @Test
    public void testRead(){
        empService.read();
    }

    @Test
    public void testGetEmpCount(){
        System.out.println("员工数量："+empService.getEmpCount()+"名");
    }

    @Test
    public void testFindEmpByEmpNo(){
        Emp emp = empService.findEmpByEmpNo(7788);
        System.out.println(emp);
    }

    @Test
    public void testFindEmpByDeptNo(){
        empService.findEmpByDeptNo(10).forEach(System.out::println);
    }

    @Test
    public void testAddEmp(){
        Emp emp = new Emp(10000, "小橘", "SALESMAN", 7788,
                LocalDate.of(2000,1,1), 10000.0, null, 20);
        int row = empService.addEmp(emp);

        System.out.println("添加员工："+row+"条");
    }

    @Test
    public void testUpdateEmp(){
        Emp emp = new Emp(10000, "小橘", "BOSS", null,
                LocalDate.of(2000,1,1), 10000.0, 5000.0, 10);
        int row = empService.updateEmp(emp);

        System.out.println("修改员工："+row+"条");
    }

    @Test
    public void testDeleteEmp(){
        int row = empService.deleteEmp(10000);

        System.out.println("删除员工："+row+"条");
    }

    @Test
    public void testBatchAddDept(){
        Dept dept50 = new Dept(50, "财务部", "北京");
        Dept dept60 = new Dept(60, "运营部", "北京");
        Dept dept70 = new Dept(70, "开发部", "北京");
        List<Dept> depts = List.of(dept50, dept60, dept70);
        int[] rows = deptService.batchAddDept(depts);
        System.out.println(Arrays.toString(rows));
    }

    @Test
    public void testBatchUpdateDept(){
        Dept dept50 = new Dept(50, "财务部", "河北");
        Dept dept60 = new Dept(60, "运营部", "辽宁");
        Dept dept70 = new Dept(70, "开发部", "江西");
        List<Dept> depts = List.of(dept50, dept60, dept70);
        int[] rows = deptService.batchUpdateDept(depts);
        System.out.println(Arrays.toString(rows));
    }

    @Test
    public void testBatchDeleteDept(){
        List<Integer> deptNos = List.of(50,60,70);
        int[] rows = deptService.batchDeleteDept(deptNos);
        System.out.println(Arrays.toString(rows));
    }

    @Test
    public void testTransMoney(){
        System.out.println("from 1 to 2:");
        System.out.println(accountService.transMoney(1,2, 100.0));
    }

    @Test
    public void testTransMoneyByXml(){
        AbstractApplicationContext ioc2 =
                new ClassPathXmlApplicationContext("JdbcTemplate/MySQLConfigByXml.xml");
        AccountService account = ioc2.getBean(AccountService.class);
        System.out.println(account.transMoney(2, 1, 100.0));
        ioc2.close();
    }

    @Test
    public void testTransMoneyNoXml(){
        AbstractApplicationContext ioc3 =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountServiceNoXml account = ioc3.getBean(AccountServiceNoXml.class);
        System.out.println(account.transMoney(1, 2, 100.0));
        ioc3.close();
    }


}
