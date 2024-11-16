//package spring;
//
//import java.time.LocalDateTime ;
//
//public class MemberRegisterService {
//    private MemberDao memberDao ;
//    // DI 부분 str
//    public MemberRegisterService(MemberDao memberDao) {
//        this.memberDao = memberDao ;
//    }   // // DI 부분 end
//
//    public Long regist(RegisterRequest req) {
//        MemberDao member = memberDao.selectByEmail(req.getEmail()) ;
//        if(member != null){
//            throw new DuplicateMemberException("dup email " + req.getEmail()) ;
//        }
//
//        Member newMember = new Member (
//                req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now()) ;
//        memberDao.insert(newMember) ;
//        return newMember.getId() ;
//    }
//}
///*  new 연산자를 이용해서 객체를 직접 생성하는 경우에는 해당 객체를 사용하는 클래스를 모두 수정하여야 하지만,
//    DI를 사용하면 해당 객체를 생성하는 코드 한 군데만 수정하여도 됨.
//*/