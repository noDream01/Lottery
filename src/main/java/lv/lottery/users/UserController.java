package lv.lottery.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void add(@RequestBody UsersRegistration usersRegistration) {
        userService.add(usersRegistration);
    }
    @GetMapping
    public Collection<UsersRegistration> users() {
        return userService.users();
    }
}
