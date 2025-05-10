package sungyun.hello_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import sungyun.hello_spring.service.MemberService;

@Controller
public class MEmberController {

    private final MemberService memberService;


    @Autowired
    public MEmberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
