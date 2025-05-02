package sungyun.hello_spring.repotitory;

import org.assertj.core.api.Assertions;//Assertions 생략 가능하게 해줌
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import sungyun.hello_spring.domain.Member;
import sungyun.hello_spring.repository.MemberRepository;
import sungyun.hello_spring.repository.MemoryMemberRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach//하나의 테스특다 끝날 때 마다 방문
    public void afterEach() {
        repository.clearStore();//각 테스트들은 임의로 정해진 순서로 동작하기에 이전 값 클리어
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        //Assertions.assertEquals(member, null);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result1 = repository.findByName("spring1").get();
        Member result2 = repository.findByName("spring2").get();

        assertThat(result1).isEqualTo(member1);
        assertThat(result2).isEqualTo(member2);

    }

    @Test
    public void findAll() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }
}
