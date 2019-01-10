package lv.lottery.users;


import lv.lottery.registration.LotteryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/register")
public class UserController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LotteryController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public void add(@RequestBody UsersRegistration usersRegistration) {
        LOGGER.info("Participant registered");
        userService.add(usersRegistration);
    }
    @GetMapping
    public Collection<UsersRegistration> users() {
        return userService.users();
    }

    @PutMapping(value = "/assign")
    public boolean assign(@RequestParam Long userId, @RequestParam Long lotteryId) {
        return userService.assign(userId, lotteryId);
    }
}
