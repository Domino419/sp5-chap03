package main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.*;


/**
 * class        : AppConf2
 * date         : 24-11-17
 * description  : 스프링 애플리케이션 컨텍스트에 필요한 Bean을 정의하는 설정 클래스.
 *                MemberDao와 MemberPrinter 빈을 등록하여 의존성 주입을 통해 사용 가능하게 설정.
 *                [리스트 3.27] 8.두 개 이상의 설정 파일 사용하기
 */

@Configuration
public class AppConf2 {
    @Autowired
    private MemberDao memberDao ;
    @Autowired
    private MemberPrinter memberPrinter ;

    /**
     * method        : memberRegisterService
     * date          : 24-11-17
     * return        : MemberRegisterService
     * description   : MemberRegisterService 빈을 생성하여 반환. 회원 등록 기능을 제공하며, MemberDao에 의존함.
     */
    @Bean
    public MemberRegisterService memberRegSvc(){
        return new MemberRegisterService(memberDao);
    }

    /**
     * method        : changePwdSvc
     * date          : 24-11-17
     * param         : None
     * return        : ChangePasswordService
     * description   : ChangePasswordService 빈을 생성하여 반환. 비밀번호 변경 기능을 제공하며, MemberDao에 의존함.
     */
    @Bean
    public ChangePasswordService changePwdSvc() {
        ChangePasswordService pwdSvc = new ChangePasswordService() ;
        pwdSvc.setMemberDao(memberDao);
        return pwdSvc ;
    }

    /**
     * method        : listPrinter
     * date          : 24-11-17
     * description   : MemberListPrinter 객체를 생성하여 스프링 컨텍스트에 등록한다.
     *                 MemberDao와 MemberPrinter를 주입하여 모든 회원 정보를 출력하는 기능을 제공한다.
     */
    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter(memberDao, memberPrinter) ;
    }


    /**
     * method        : infoPrinter
     * date          : 24-11-17
     * param         : none
     * return        : MemberInfoPrinter
     * description   : MemberInfoPrinter 빈을 생성하고 MemberDao 및 MemberPrinter 객체를 설정하여 반환한다.
     *                 의존성 주입을 통해 회원 정보를 조회하고 출력하는 기능을 제공한다.
     */
    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter() ;
        infoPrinter.setMemberDao(memberDao);
        infoPrinter.setPrinter(memberPrinter);
        return infoPrinter ;
    }


    /**
     * method        : versionPrinter
     * date          : 24-11-17
     * param         : none
     * return        : VersionPrinter - 버전 정보를 설정한 VersionPrinter 객체
     * description   : VersionPrinter 객체를 생성하고, majorVersion과 minorVersion 값을 설정하여 반환한다.
     *                 이 메소드는 프로그램의 버전 정보 출력을 위한 Bean을 생성한다. (리스트 3.24 , 89page)
     */
    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter() ;
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter ;
    }
}
