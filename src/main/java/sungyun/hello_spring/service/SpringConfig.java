package sungyun.hello_spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sungyun.hello_spring.aop.TimeTraceAop;
import sungyun.hello_spring.repository.MemberRepository;

@Configuration
public class SpringConfig {

    //private DataSource dataSource;

    //public SpringConfig(DataSource dataSource) {
    //    this.dataSource = dataSource;
    // }



    /*
        private final EntityManager em;

        @Autowired
        public SpringConfig(EntityManager em) {
            this.em = em;
        }
        */
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /*
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
    */

    //@Bean
    //public MemberRepository memberRepository() {
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    //}




}
