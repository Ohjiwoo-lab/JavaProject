/*
 * [예제 3-10] 2차원 배열로 4년 평점 구하기
 * 2차원 배열에 학년별로 1, 2학기 성적을 저장하고, 4년간 전체 평점 평균을 출력하는 프로그램
 */

package Chapter3;

public class ScoreAverage {
    public static void main(String[] args){
        double score[][] = {
                {3.3, 3.4},  //1학년 1, 2학기 평점
                {3.5, 3.6},  //2학년 1, 2학기 평점
                {3.7, 4.0},  //3학년 1, 2학기 평점
                {4.1, 4.2}   //4학년 1, 2학기 평점
        };
        double sum = 0;

        for(int year = 0; year < score.length; year++)  //각 학년별로 반복(4번)
            for(int term = 0; term < score[year].length; term++)  //각 학년의 학기별로 반복(2번)
                sum += score[year][term];  //전체 평점을 더해나감

        int n = score.length;  //2차원 배열 score의 행 개수, 4개
        int m = score[0].length;  //2차원 배열 score의 열 개수, 2개
        System.out.println("4년 전체 평점 평균은 " + sum/(n*m) + "입니다.");
    }
}
