package assembler;


import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

/**
 * class        : Assembler
 * date          : 24-11-17 22:09
 */

public class Assembler {
    private MemberDao memberDao ;
    private MemberRegisterService regSvc ;
    private ChangePasswordService pwdSvc ;


    /**
     * method        : Assembler
     * date          : 24-11-17 12:30
     * description   : MemberDao, MemberRegisterService, ChangePasswordService 인스턴스를 생성.
     *                의존성을 주입하여 회원 등록 및 비밀번호 변경 기능을 관리하는 클래스
     *                이 생성자를 통하여 해당 의존성들을 초기화하고 설정하는 것이 가능함.
     */
    public Assembler () {
        memberDao = new MemberDao() ;
        regSvc = new MemberRegisterService(memberDao) ;
        pwdSvc = new ChangePasswordService() ;
        pwdSvc.setMemberDao(memberDao) ;
    }

    public MemberDao getMemberDao(){
        return memberDao ;
    }

    public MemberRegisterService getMemberRegisterService(){
        return regSvc ;
    }

    public ChangePasswordService getChangePasswordService(){
        return pwdSvc ;
    }

}
