package lv.lottery.registration;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LotteryService {

    private Map<Long, LotteryRegistration> lotteryStorage = new HashMap<>();
    private Long lastId = 0L;


    public Long addLottery(LotteryRegistration lotteryRegistration){
        lastId++;
        lotteryRegistration.setId(lastId);
        lotteryStorage.put(lastId, lotteryRegistration);

        return lastId;

    }

    public List<LotteryRegistration> get(){
        return new ArrayList<>(lotteryStorage.values());
    }

    public LotteryRegistration get(Long id){
        return lotteryStorage.get(id);

    }

}
