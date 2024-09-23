package org.spellbinders.spaceService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "http://localhost:8005")
public interface UserServiceClient {

    @GetMapping("/users/validate")
    Boolean validateUser(@RequestHeader("Authorization") String token);

    @PutMapping("/users/update-role")
    void updateUserRoleToAdmin(@RequestHeader("Authorization") String token, @RequestParam Long userId);
}
