package sungyun.hello_spring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import sungyun.hello_spring.domain.Member;
import sungyun.hello_spring.repository.MemberRepository;
import sungyun.hello_spring.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberserviceSpring {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;


    @Test

//테스트 코드는 한글 가능
    void join() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외(){
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        /*
        try{
            memberService.join(member2);

        } catch (IllegalStateException e) {

            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */


    }

}
