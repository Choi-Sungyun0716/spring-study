package sungyun.hello_spring.service;


import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sungyun.hello_spring.repository.JdbcTemplateMemberRepository;
import sungyun.hello_spring.repository.JpaMemberRepository;
import sungyun.hello_spring.repository.MemberRepository;
import sungyun.hello_spring.repository.MemoryMemberRepository;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    //private DataSource dataSource;

    //public SpringConfig(DataSource dataSource) {
    //    this.dataSource = dataSource;
    // }

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }




}
