package main.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.*;


/**
 * class         : AppCtx
 * date          : 24-11-17
 * description   : Spring 설정 클래스. 애플리케이션에서 필요한 Bean을 정의하고 관리.
 */
@Configuration
public class AppCtx {

    /**
     * method        : memberDao
     * date          : 24-11-17
     * description   : MemberDao 빈을 생성하여 반환. 회원 데이터를 관리하는 DAO 객체.
     */
    @Bean
    public MemberDao memberDao(){
        return new MemberDao() ;
    }

    /**
     * method        : memberRegisterService
     * date          : 24-11-17
     * return        : MemberRegisterService
     * description   : MemberRegisterService 빈을 생성하여 반환. 회원 등록 기능을 제공하며, MemberDao에 의존함.
     */
    @Bean
    public MemberRegisterService memberRegSvc(){
        // memberDao()가 생성한 객체를 MemberRegisterService 생성자를 통하여 주입한다.
        return new MemberRegisterService(memberDao());
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
        // 세터 ( setMemberDao()메서드 ) 를 이용해서 의존 객체를 주입한다.
        pwdSvc.setMemberDao(memberDao());
        return pwdSvc ;
    }

    /**
     * method        : memberPrinter
     * date          : 24-11-17
     * description   : MemberPrinter는 회원 정보를 출력하는 역할을 수행한다.
     */
    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter() ;
    }

    /**
     * method        : listPrinter
     * date          : 24-11-17
     * description   : MemberListPrinter 객체를 생성하여 스프링 컨텍스트에 등록한다.
     *                 MemberDao와 MemberPrinter를 주입하여 모든 회원 정보를 출력하는 기능을 제공한다.
     */
    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter(memberDao(), memberPrinter()) ;
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
        infoPrinter.setMemberDao(memberDao());
        infoPrinter.setPrinter(memberPrinter());
        return infoPrinter ;
    }



}


/*
@Configuration 애노테이션은 스프링 설정 클래스를 의미한다.
@Bean 애노테이션은 해당 메서드가 생성한 객체를 스프링 빈이라고 설정한다.
      메서드마다 한개의 빈 객체를 생성하며, 이때 메서드 이름은 빈 객체의 이름으로 사용한다.
      memberDao() 메서드를 이용해서 생성한 빈 객체는 "memberdao" 라는 이름으로 스프링에 등록된다.

객체를 생성하고 의존 객체를 주입하는 것은 스프링 컨테이너이므로, 설정 클래스를 이용해어 컨테이너를 생성해야 한다.
 AnnotationConfigApplicationContext ctx =    new AnnotationConfigApplicationContext(AppCtx.class);

컨테이너를 생성하면 getBean() 메서드를 이용해서 사용할 객체를 구할 수 있다.
//컨테이너에[서 이름이 memberRegSvc인 빈 객체를 구하는 getBean() 메서드의 사용 예시
MemberRegisterService regSvc = ctx.getBean("memberRegSvc",MemberRegisterService.class) ;

 */