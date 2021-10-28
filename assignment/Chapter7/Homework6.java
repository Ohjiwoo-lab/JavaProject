/*
 * [과제 6번] 도시 이름, 위도, 경도 정보를 가진 Location 클래스를 작성하고,
 * 도시 이름을 '키'로 하는 HashMap<String, Location> 컬렉션을 만든 뒤, 사용자로부터 입력을 받아 4개의 도시를 저장한다.
 * 그리고 도시 이름으로 검색하는 프로그램을 작성한다.
 */

package Chapter7;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

class Location {
    private String city;  // 도시 이름
    private double longitude;  // 경도
    private double latitude;  // 위도

    // 인자 있는 생성자
    public Location(String city, double longitude, double latitude) {
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setCity(String city) {  // 도시 이름을 세팅하는 메소드
        this.city = city;
    }
    public String getCity() {  // 도시 이름을 리턴해주는 메소드
        return city;
    }

    public void setLogitude(double longitude) {  // 경도를 세팅하는 메소드
        this.longitude = longitude;
    }
    public double getLongitude() {  // 경도를 리턴해주는 메소드
        return longitude;
    }

    public void setLatitude(double latitude) {  // 위도를 세팅하는 메소드
        this.latitude = latitude;
    }
    public double getLatitude() {  // 위도를 리턴해주는 메소드
        return latitude;
    }

    public void find_location(String name){
        System.out.println(name + "  " + (int)longitude + "  " + (int)latitude);
    }
}

public class Homework6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Scanner 객체 생성
        Location[] location = new Location[4];  // Location 객체 생성
        HashMap<String, Location> manage = new HashMap<String, Location>();  // HashMap 생성

        // 도시 정보 입력
        System.out.println("도시, 경도, 위도를 입력하세요.");
        for(int i = 0; i < location.length; i++) {
            System.out.print(">> ");
            String text = scanner.nextLine();  // 도시와 경도, 위도 정보를 입력받는다(공백포함)

            StringTokenizer st = new StringTokenizer(text, ",");  // ,로 토큰화한다.
            String city = st.nextToken().trim();  // 첫 번째 토큰(도시 이름)
            int longitude = Integer.parseInt(st.nextToken().trim());  // 두 번째 토큰(경도)
            int latitude = Integer.parseInt(st.nextToken().trim());  // 세 번째 토큰(위도)

            location[i] = new Location(city, longitude, latitude);  // 입력받은 것을 토대로 Location 객체 생성
            manage.put(city, location[i]);  // ArrayList에 저장
        }

        Set<String> key = manage.keySet();  // key를 가져옴
        Iterator<String> it = key.iterator();  // Iterator 생성

        // 입력받은 도시 정보 출력(Iterator 이용)
        System.out.println("----------------------------------");
        while(it.hasNext()) {  // Iterator가 다음을 가리킴
            String city = it.next();  // Iterator가 가리키는 원소를 가져옴
            Location s = manage.get(city);
            System.out.println(s.getCity() + "  " + (int)s.getLongitude() + "  " + (int)s.getLatitude());  // 도시정보 출력
        }
        System.out.println("----------------------------------");

        // 도시 이름으로 검색
        while(true) {
            System.out.print("도시 이름 >> ");
            String city = scanner.next();  // 검색할 도시 이름 입력받음

            if(city.equals("그만"))  // '그만'을 입력할 때 종료
                break;

            Location s = manage.get(city);  // 도시 이름에 해당하는 것을 가져옴
            if(s == null)  // 가져왔는데 null이라는 것은 해당 도시가 없다는 것을 의미한다.
                System.out.println(city + "는 없습니다.");
            else  // 도시가 있으면 위치를 출력한다.
                s.find_location(city);
        }
        scanner.close();
    }
}