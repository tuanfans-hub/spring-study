package com.tuanfans.component.myService;

import org.springframework.stereotype.Service;

/**
 * @author TuanFans
 * &#064;date 2025/4/17
 * &#064description @Service标识该类是Service层
 */
@Service("userService")
public interface UserService {
    void getUser();
}
