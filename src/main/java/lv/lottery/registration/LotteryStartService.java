package lv.lottery.registration;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class LotteryStartService {

    private Map<Long, LotteryStart> lotteryStorage = new HashMap<>();
    private Long lastId = 0L;


    public Long addLottery(LotteryStart lotteryStart){
        lastId++;
        lotteryStart.setId(lastId);
        lotteryStorage.put(lastId, lotteryStart);

        return lastId;

    }

    public List<LotteryStart> get(){
        return new ArrayList<>(lotteryStorage.values());
    }

}
