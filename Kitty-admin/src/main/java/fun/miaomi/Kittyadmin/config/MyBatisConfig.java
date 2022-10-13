package fun.miaomi.Kittyadmin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("fun.miaomi.Kittyadmin.mbg.mapper")
public class MyBatisConfig {
}
