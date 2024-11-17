package main;

import assembler.Assembler;
import spring.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class         : MainForAssembler
 * date          : 24-11-17 22:48
 * description   : 콘솔 명령어를 통해 회원 등록과 비밀번호 변경 기능을 수행하는 class
 */

public class MainForAssembler {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;

        while (true){
            System.out.println("명령어를 입력하세요 :  ");
            String command = reader.readLine() ;

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다.");
                break;
            }
            if(command.startsWith("new ")){
                processNewCommand(command.split(" "));
                continue;
            } else if (command.startsWith("change ")) {
                processChangeCommand(command.split(" "));
                continue;
            }
        printHelp() ;
        }
    }
    /**
     * method        : Assembler
     * date          : 24-11-17 22:48
     * description   : Assembler 객체를 생성
     */
    private static Assembler assembler = new Assembler() ;

    /**
     * method        : processNewCommand
     * date          : 24-11-17 22:48
     * param         : arg  배열 ( email, name, password, ConfirmPassword )
     * return        : void
     * description   : 회원 등록 명령을 처리하고, 등록 실패 시 오류 메시지를 출력
     */
    private static void processNewCommand(String[] arg){

        if(arg.length!= 5) {
            printHelp() ;
            return;
        }

        MemberRegisterService regSvc = assembler.getMemberRegisterService();
        RegisterRequest req = new RegisterRequest() ;
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if(!req.isPasswordEqualToConfirmPassword()){
            System.out.println("암호와 확인이 일치하지 않습니다. \n");
            return;
        } try {
            regSvc.regist(req) ;
            System.out.println("등록했습니다. \n");
        } catch (DuplicateMemberException e) {
            System.out.println("이미 존재하는 이메일입니다.\n");
        }
    }

    /**
     * method        : processChangeCommand
     * date          : 24-11-17 22:48
     * param         : arg 배열 (email, oldPwd, newPwd)
     * return        : void
     * description   : 이메일을 기준으로 회원 정보를 조회하여 비밀번호 변경을 처리
     */
    private static void processChangeCommand(String[] arg){
        if(arg.length!= 4) {
            printHelp() ;
            return;
        }
        ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
        try {
            changePwdSvc.changePassword(arg[1], arg[2], arg[3]);  //changePassword(String email, String oldPwd, String newPwd)
            System.out.println("암호를 변경하였습니다.");
        }catch (MemberNotFoundException e){
            System.out.println("존재하지 않는 이메일 입니다.");
        }catch  (WrongIdPasswordException e) {
            System.out.println("이메일과 암호가 일치하지 않습니다.");
        }
    }


    /**
     * method        : printHelp
     * date          : 24-11-17 22:48
     * param         : None
     * return        : void
     * description   : 잘못된 명령어 입력 시 사용법을 안내하는 메시지를 출력
     */
    private static void printHelp(){
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
        System.out.println("명령어 사용법 : ");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재비번 변경비번");
        System.out.println();
    }


}
/*
assembler는 자신이 생성하고 조립한 객체를 리턴하는 메서드를 제공한다.
MemberRegisterService regSvc = assembler.getMemberRegisterService();
ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
이와 같이 assembler에서 제공하는 메서드를 이용해서 필요한 객체를 구하고, 그 객체를 사용하는 것이 전형적인 assembler 사용법


*/