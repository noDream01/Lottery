package lv.lottery.registration;

import lv.lottery.users.UsersDAOImplementation;
import lv.lottery.users.UsersRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LotteryService {

//    private Map<Long, LotteryRegistration> lotteryStorage = new HashMap<>();
    private final LotteryDAOImplementation lotteryDAOImplementation;
    private final UsersDAOImplementation usersDAOImplementation;

    @Autowired
    public LotteryService(LotteryDAOImplementation lotteryDAOImplementation, UsersDAOImplementation usersDAOImplementation){
        this.lotteryDAOImplementation = lotteryDAOImplementation;
        this.usersDAOImplementation = usersDAOImplementation;
    }

    private Long lastId = 0L;

    public Long addLottery(LotteryRegistration lotteryRegistration){
        lotteryRegistration.setCreatedDate(new Date());
//        lastId++;
//        lotteryRegistration.setId(lastId);

        return lotteryDAOImplementation.insert(lotteryRegistration);

    }

    public List<LotteryRegistration> get(){

        return lotteryDAOImplementation.getAll();
    }

    public Optional<LotteryRegistration> get(Long id){
        return lotteryDAOImplementation.getById(id);

    }

    public void update(Long id, LotteryRegistration lotteryRegistration){
        lotteryRegistration.setId(id);
        lotteryDAOImplementation.update(lotteryRegistration);
    }


//    public void assignLottery(Long lotteryId, Long userId) {
//        Optional<LotteryRegistration> wrappedLottery = this.get(userId);
//        Optional<UsersRegistration> wrappedUser = usersDAOImplementation.getById(userId);
//
//        if (wrappedUser.isPresent() && wrappedLottery.isPresent()) {
//            LotteryRegistration lotteryRegistration = wrappedLottery.get();
//            lotteryRegistration.getUsersRegistrations().add(wrappedUser.get());
//
//            lotteryDAOImplementation.update(lotteryRegistration);
//        }
//    }

//    public void assignUser(Long lotteryId, Long userId) {
//        Optional<LotteryRegistration> wrappedLottery = this.get(lotteryId);
//        Optional<UsersRegistration> wrappedUser = usersDAOImplementation.getById(userId);
//
//        if (wrappedLottery.isPresent() && wrappedUser.isPresent()) {
//            LotteryRegistration lottery = wrappedLottery.get();
//            lottery.getTasks().add(wrappedTask.get());
//
//            userDaoImplementation.update(user);
//        }


}
