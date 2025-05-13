package sungyun.hello_spring.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sungyun.hello_spring.repository.JdbcTemplateMemberRepository;
import sungyun.hello_spring.repository.MemberRepository;
import sungyun.hello_spring.repository.MemoryMemberRepository;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }




}
