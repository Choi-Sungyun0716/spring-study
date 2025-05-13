package sungyun.hello_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sungyun.hello_spring.domain.Member;
import sungyun.hello_spring.repository.MemberRepository;
import sungyun.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

        private final MemberRepository memberRepository;
        @Autowired
        //생성자 주입(웬만하면 이렇게 하자)
        public MemberService(MemberRepository memberRepository){
            this.memberRepository = memberRepository;
        }

        //회원가입
        public long join(Member member){
            //같은 이름이 있으면 안됨
            vaildateDuplicateMember(member);//중복 회원 검증


            memberRepository.save(member);
            return member.getId();
        }

        private void vaildateDuplicateMember(Member member) {
            memberRepository.findByName(member.getName())
                            .ifPresent(m-> {
                                throw new IllegalStateException("이미 존재하는 회원입니다.");
                            });
        }

        public List<Member> findMembers() {
            return memberRepository.findAll();
        }

        public Optional<Member> findOne(Long memberId){
            return memberRepository.findById(memberId);
        }


}
