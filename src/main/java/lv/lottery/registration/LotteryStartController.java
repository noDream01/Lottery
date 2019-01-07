package lv.lottery.registration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/start-registration")
public class LotteryStartController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LotteryStartController.class);

    @Autowired
    private LotteryStartService lotteryStartService;

    @GetMapping
    public Collection<LotteryStart> get(){
        LOGGER.info("lottery registered");
        return lotteryStartService.get();

    }

    @PostMapping
    public void create(@RequestBody LotteryStart lotteryStart){
        lotteryStartService.addLottery(lotteryStart);
    }

}
