package sungyun.hello_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sungyun.hello_spring.domain.Member;
import sungyun.hello_spring.service.MemberService;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;


    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")//get은 조회
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")//데이터를 받아오면 post
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());



        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
