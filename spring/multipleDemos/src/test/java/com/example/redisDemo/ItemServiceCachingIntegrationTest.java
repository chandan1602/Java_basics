package com.example.redisDemo;

import com.example.redisDemo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Import({UserService.class})
@ExtendWith(SpringExtension.class)
@EnableCaching
@ImportAutoConfiguration(classes = {
        CacheAutoConfiguration.class,
        RedisAutoConfiguration.class
})

public class ItemServiceCachingIntegrationTest {
    @MockBean
    private UserRepositoryImpl mockUserRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    void givenRedisCaching_whenFindItemById_thenItemReturnedFromCache() {
        String id = "n32hde34",
               name = "temp user 1";
        User user = new User(id, name, 20000L);
        given(mockUserRepository.findById(id))
                .willReturn(user);
        User userCacheMiss = userService.getUserById(id);
        User userCacheHit = userService.getUserById(id);

        assertThat(userCacheMiss.getId()).isEqualTo(user.getId());
        assertThat(userCacheHit).isEqualTo(user);

        verify(mockUserRepository, times(1)).findById(id);

    }
}
