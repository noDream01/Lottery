package lv.lottery.registration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class LotteryController {
    private final static Logger LOGGER = LoggerFactory.getLogger(LotteryController.class);
    private final LotteryService lotteryService;

    @Autowired
    private LotteryController(LotteryService lotteryService){
        this.lotteryService = lotteryService;
    }

    @RequestMapping(value = "/start-registration", method = RequestMethod.GET)
    public Collection<LotteryRegistration> get(){
        LOGGER.info("lottery registered");
        return lotteryService.get();

    }

    @RequestMapping(value = "/start-registration", method = RequestMethod.POST)
    public void create(@RequestBody LotteryRegistration lotteryRegistration){
        lotteryService.addLottery(lotteryRegistration);
    }

    @RequestMapping( value = "start-registration/{id}", method = RequestMethod.GET)
    public Optional<LotteryRegistration> getById(@PathVariable Long id) {
        return lotteryService.get(id);
    }
//    @RequestMapping(value = "/stop-registration", method = RequestMethod.POST)
//    public LotteryRegistration getLotteryByIdRegistrationStop(@RequestBody Long id){
//        return lotteryService.get(id);
//    }
//
//    @RequestMapping(value = "/choose-winner", method = RequestMethod.GET)
//    public Collection<> getLotteryWinner(){
//
//    }



}
