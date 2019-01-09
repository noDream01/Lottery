package lv.lottery.users;

import lv.lottery.registration.LotteryRegistration;
import lv.lottery.registration.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class UserService {

//    private Map<Long, UsersRegistration> userMap = new HashMap<>();

    private final LotteryService lotteryService;
    private final UsersDAO usersDAO;

    private Long lastId = 0L;

    @Autowired
    public UserService(LotteryService lotteryService, UsersDAO usersDAO){
        this.lotteryService = lotteryService;
        this.usersDAO = usersDAO;
    }

    public Long add(UsersRegistration usersRegistration) {
        lastId++;
        usersRegistration.setId(lastId);
        usersDAO.insert(usersRegistration);
        return lastId;
    }

    public List<UsersView> users() {
        return usersDAO.getAll().stream().map(this::mapToTaskView).collect(Collectors.toList());
    }

    public UsersView get(Long id) {
        Optional<UsersRegistration> user = usersDAO.getById(id);

        if (user.isPresent()) {
            return mapToTaskView(user.get());
        } else {
            return null;
        }
    }

    private UsersView mapToTaskView(UsersRegistration usersRegistration) {
        LotteryRegistration lotteryRegistration = lotteryService.get(usersRegistration.getAssignedLotteryId());

        return new UsersView(
                usersRegistration.getId(),
                usersRegistration.getEmail(),
                usersRegistration.getAge(),
                usersRegistration.getCode(),
                usersRegistration.getAssignedLotteryId(),
                lotteryRegistration == null ? null : lotteryRegistration.getTitle());
    }

    public boolean assign(Long userId, Long lotteryId) {
        Optional<UsersRegistration> user = usersDAO.getById(userId);

        if (user.isPresent()) {
            UsersRegistration unwrapped = user.get();
            unwrapped.setAssignedLotteryId(lotteryId);

            usersDAO.update(userId, unwrapped);
            return true;
        } else {
            return false;
        }
    }

}
