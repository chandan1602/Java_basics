package T2454.Chandan_Bansal.BE_Project1;

import T2454.Chandan_Bansal.BE_Project1.entity.Department;
import T2454.Chandan_Bansal.BE_Project1.entity.Employee;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@MappedTypes({Employee.class, Department.class})
@MapperScan("T2454.Chandan_Bansal.BE_Project1.mappers")
@SpringBootApplication
public class BeProject1Application {

	@Bean
	public RedisCacheManagerBuilderCustomizer
	redisCacheManagerBuilderCustomizer() {
		return (builder) -> builder
				.withCacheConfiguration("departmentCache",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)));
	}

	@Bean
	RedisTemplate<String, Department> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Department> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return redisTemplate;
	}


	public static void main(String[] args) {
		SpringApplication.run(BeProject1Application.class, args);
	}
}
