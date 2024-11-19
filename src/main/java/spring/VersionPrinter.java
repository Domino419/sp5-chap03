package spring;


/**
 * class         : VersionPrinter
 * date          : 24-11-17
 * description   : 프로그램 버전 정보를 관리하고 출력하는 클래스. majorVersion과 minorVersion을 설정하고,
 *                 현재 프로그램 버전을 출력하는 기능을 제공한다.
 *                 리스트 3.23 / 88page
 */

public class VersionPrinter {

    public int majorVersion ;
    public int minorVersion ;

    /**
     * method        : print
     * date          : 24-11-17
     * param         :
     * return        : void
     * description   : 설정된 majorVersion과 minorVersion을 사용하여 프로그램 버전 정보를 출력한다.
     */
    public void print() {
        System.out.printf("이 프로그램의 버전은 %d.%d입니다. \n\n", majorVersion, minorVersion );
    }

    /**
     * method        : setMajorVersion
     * date          : 24-11-17
     * param         : int majorVersion - 설정할 주요 버전 번호
     * return        : void
     * description   : majorVersion을 설정한다.
     */
    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion ;
    }

    /**
     * method        : setMinorVersion
     * date          : 24-11-17
     * param         : int minorVersion - 설정할 부 버전 번호
     * return        : void
     * description   : minorVersion을 설정한다.
     */
    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion ;
    }


}
