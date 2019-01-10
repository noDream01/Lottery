package lv.lottery.users;

import lv.lottery.registration.LotteryRegistration;
import lv.lottery.registration.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

//    private Map<Long, UsersRegistration> userMap = new HashMap<>();

//    private final LotteryService lotteryService;
    private final UsersDAOImplementation usersDAO;

    private Long lastId = 0L;

    @Autowired
    public UserService(UsersDAOImplementation usersDAO){
//        this.lotteryService = lotteryService;
        this.usersDAO = usersDAO;
    }

    public Long add(UsersRegistration usersRegistration) {
//        lastId++;
//        usersRegistration.setId(lastId);

//        usersDAO.insert(usersRegistration);
        return usersDAO.insert(usersRegistration);
    }

    public List<UsersRegistration> users() {
        return usersDAO.getAll();
    }

    public Optional<UsersRegistration> get(Long id){
        return usersDAO.getById(id);
    }

//    public UsersView get(Long id) {
//        Optional<UsersRegistration> user = usersDAO.getById(id);
//
//        if (user.isPresent()) {
//            return mapToTaskView(user.get());
//        } else {
//            return null;
//        }
//    }
//
//    private UsersView mapToTaskView(UsersRegistration usersRegistration) {
//        LotteryRegistration lotteryRegistration = lotteryService.get(usersRegistration.getAssignedLotteryId());
//
//        return new UsersView(
//                usersRegistration.getId(),
//                usersRegistration.getEmail(),
//                usersRegistration.getAge(),
//                usersRegistration.getCode(),
//                usersRegistration.getAssignedLotteryId(),
//                lotteryRegistration == null ? null : lotteryRegistration.getTitle());
//    }

    public boolean update(UsersRegistration usersRegistration) {
        usersDAO.update(usersRegistration);
        return true;
    }

    public boolean assign(Long userId, Long lotteryId) {
        Optional<UsersRegistration> user = usersDAO.getById(userId);

//        Optional<UsersRegistration> wrappedUser = this.get(userId);
//        Optional<LotteryRegistration> wrappedLottery = userDao.getById(userId);

        if (user.isPresent()) {
            UsersRegistration unwrapped = user.get();
            unwrapped.setAssignedLotteryId(lotteryId);

            usersDAO.update(unwrapped);
            return true;
        } else {
            return false;
        }
    }

}
