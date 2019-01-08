package lv.lottery.registration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class LotteryController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LotteryController.class);

    @Autowired
    private LotteryService lotteryService;

    @RequestMapping(value = "/start-registration", method = RequestMethod.GET)
    public Collection<LotteryRegistration> get(){
        LOGGER.info("lottery registered");
        return lotteryService.get();

    }

    @RequestMapping(value = "/start-registration", method = RequestMethod.POST)
    public void create(@RequestBody LotteryRegistration lotteryRegistration){
        lotteryService.addLottery(lotteryRegistration);
    }
    @RequestMapping(value = "/stop-registration", method = RequestMethod.POST)
    public LotteryRegistration getLotteryByIdRegistrationStop(@RequestBody Long id){
        return lotteryService.get(id);
    }

    @RequestMapping(value = "/choose-winner", method = RequestMethod.POST)
    public LotteryRegistration getLotteryByIdStartLottery(@RequestBody Long id){
        return lotteryService.get(id);
    }

}
