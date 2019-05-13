
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author：xiaoyu
 * @create： 11:15 2019/5/11
 * @description:
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan({"com.shiqing.hashImage.*"})
@MapperScan({"com.shiqing.hashImage.dao"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
