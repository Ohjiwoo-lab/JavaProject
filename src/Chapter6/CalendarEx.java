/*
 * [예제 6-11] Calendar 클래스를 이용하여 현재 날짜와 시간 알아내기, 날짜와 시간 설정하기
 * Calendar 클래스는 시간과 날짜 정보를 저장 및 관리할 수 있는 클래스이다.
 */

package Chapter6;
import java.util.Calendar;

public class CalendarEx {
    // Calendar 클래스 객체를 받아 시간과 날짜 정보를 출력해주는 메소드
    public static void printCalendar(String msg, Calendar cal){
        int year = cal.get(Calendar.YEAR);  /// 년도

        // get()은 0~30 까지의 정수를 리턴한다.
        int month = cal.get(Calendar.MONTH) + 1;  // 달(0~11)
        int day = cal.get(Calendar.DAY_OF_MONTH);  // 한 달의 날짜
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 한 주의 요일
        int hour = cal.get(Calendar.HOUR);  // 시간(0~11)
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);  // 24시간을 기준으로 한 시간
        int amPm = cal.get(Calendar.AM_PM);  // 오전인지 오후인지 구분
        int minute = cal.get(Calendar.MINUTE);  // 분
        int second = cal.get(Calendar.SECOND);  // 초
        int millisecond = cal.get(Calendar.MILLISECOND);  // 밀리초

        System.out.print(msg + year + "/" + month + "/" + day + "/");
        switch(dayOfWeek){
            case Calendar.SUNDAY:  // 오늘이 일요일이면
                System.out.print("일요일");
                break;
            case Calendar.MONDAY:  // 오늘이 월요일이면
                System.out.print("월요일");
                break;
            case Calendar.TUESDAY:  // 오늘이 화요일이면
                System.out.print("화요일");
                break;
            case Calendar.WEDNESDAY:  // 오늘이 수요일이면
                System.out.print("수요일");
                break;
            case Calendar.THURSDAY:  // 오늘이 목요일이면
                System.out.print("목요일");
                break;
            case Calendar.FRIDAY:  // 오늘이 금요일이면
                System.out.print("금요일");
                break;
            case Calendar.SATURDAY:  // 오늘이 토요일이면
                System.out.print("토요일");
                break;
        }

        System.out.print("(" + hourOfDay + "시)");
        if(amPm == Calendar.AM)
            System.out.print("오전");
        else
            System.out.print("오후");

        System.out.println(hour + "시 " + minute + "분 " + second + "초 " + millisecond + "밀리초");
    }

    public static void main(String[] args){
        Calendar now = Calendar.getInstance();  // Calendar 객체 생성
        printCalendar("현재 ", now);  // 현재 날짜 출력

        Calendar firstDate = Calendar.getInstance();
        firstDate.clear();

        // 2016년 12월 25일을 표현, 12월을 표현하기 위해 month에는 11로 설정
        firstDate.set(2016, 11, 25);
        firstDate.set(Calendar.HOUR_OF_DAY, 20);  // 저녁 8시
        firstDate.set(Calendar.MINUTE, 30);  // 30분
        printCalendar("처음 데이트한 날은 ", firstDate);
    }
}
