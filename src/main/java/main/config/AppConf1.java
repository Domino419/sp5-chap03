package main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.MemberDao;
import spring.MemberPrinter;


/**
 * class        : AppConf1
 * date         : 24-11-17
 * description  : 스프링 애플리케이션 컨텍스트에 필요한 Bean을 정의하는 설정 클래스.
 *                MemberDao와 MemberPrinter 빈을 등록하여 의존성 주입을 통해 사용 가능하게 설정.
 *                [리스트 3.26] 8.두 개 이상의 설정 파일 사용하기
 */

@Configuration
public class AppConf1 {

    /**
     * method        : memberDao
     * date          : 24-11-17
     * param         : None
     * return        : MemberDao
     * description   : MemberDao 객체를 생성하여 Bean으로 등록
     */
    @Bean
    public MemberDao memberDao() {
        return new MemberDao() ;
    }

    /**
     * method        : memberPrinterDao
     * date          : 24-11-17
     * param         : None
     * return        : MemberPrinter
     * description   : MemberPrinter 객체를 생성하여 Bean으로 등록
     */
    @Bean
    public MemberPrinter memberPrinterDao() {
        return new MemberPrinter() ;
    }

}
