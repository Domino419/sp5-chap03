package main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spring.MemberDao;
import spring.MemberPrinter;

/**
 * class        : AppConfImport
 * date         : 24-11-20 22:43
 * description  : 스프링 애플리케이션 설정 클래스.
 *                AppConf2 클래스를 Import하여 해당 클래스의 Bean도 함께 사용 가능하도록 설정.
 *                MemberDao와 MemberPrinter를 Bean으로 등록.
 *                [리스트 3.28] 8.2@Import 애노테이션 사용
 */


@Configuration
@Import({AppConf1.class,AppConf2.class})
public class AppConfImport {

    /**
     * method        : memberDao
     * date          : 24-11-20
     * param         : None
     * return        : MemberDao
     * description   : MemberDao 객체를 생성하여 Bean으로 등록. 회원 정보를 관리하기 위해 사용.
     */
    @Bean
    public MemberDao memberDao(){
        return new MemberDao() ;
    }

    /**
     * method        : memberPrinter
     * date          : 24-11-20
     * param         : None
     * return        : MemberPrinter
     * description   : MemberPrinter 객체를 생성하여 Bean으로 등록. 회원 정보를 출력하는 기능 제공.
     */
    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter() ;
    }
}
