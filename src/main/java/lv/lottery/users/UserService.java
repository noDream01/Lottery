package lv.lottery.users;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserService {

    private Map<Long, UsersRegistration> userMap = new HashMap<>();

    private Long lastId = 0L;

    public Long add(UsersRegistration usersRegistration) {
        lastId++;
        usersRegistration.id = lastId;
        userMap.put(lastId, usersRegistration);
        return lastId;
    }

    public List<UsersRegistration> users() {
        return new ArrayList<>(userMap.values());
    }

}
