package fun.miaomi.Kittyadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(fun.miaomi.Kittyadmin.mapper)
public class KittyAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(KittyAdminApplication.class, args);
	}

}
