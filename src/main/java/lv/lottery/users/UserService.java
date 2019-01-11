package lv.lottery.users;

import lv.lottery.registration.LotteryDAOImplementation;
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
    private final LotteryDAOImplementation lotteryDAO;

    private Long lastId = 0L;

    @Autowired
    public UserService(UsersDAOImplementation usersDAO, LotteryDAOImplementation lotteryDAO){
//        this.lotteryService = lotteryService;
        this.usersDAO = usersDAO;
        this.lotteryDAO = lotteryDAO;
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
        Optional<UsersRegistration> wrappedUser = this.get(userId);
        Optional<LotteryRegistration> wrappedLottery = lotteryDAO.getById(lotteryId);

//        Optional<UsersRegistration> wrappedUser = this.get(userId);
//        Optional<LotteryRegistration> wrappedLottery = userDao.getById(userId);

        if (wrappedUser.isPresent() && wrappedLottery.isPresent()) {

            UsersRegistration usersRegistration = wrappedUser.get();
            usersRegistration.setLottery(wrappedLottery.get());

            this.update(usersRegistration);
            return true;
        } else {
            return false;
        }
    }

}
