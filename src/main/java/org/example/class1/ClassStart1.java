package org.example.class1;

/**
 *
 * 1. 첫 번째 학생의 이름은 "학생1", 나이는 15, 성적은 90입니다.
 * 2. 두 번째 학생의 이름은 "학생2", 나이는 16, 성적은 80입니다.
 * 3. 각 학생의 정보를 다음과 같은 형식으로 출력해야 합니다: "이름: [이름] 나이: [나이] 성적: [성적]"
 * 4. 변수를 사용해서 학생 정보를 저장하고 변수를 사용해서 학생 정보를 출력해야 합니다.
 */
public class ClassStart1 {
    public static void main(String[] args) {
        String student1Name = "학생1";
        int student1Age = 15;
        int student1Score = 90;

        String student2Name = "학생1";
        int student2Age = 15;
        int student2Score = 90;

        System.out.println("이름 : " + student1Name + " 나이 : " + student1Age + " 점수 : " +student1Score);
        System.out.println("이름 : " + student2Name + " 나이 : " + student2Age + " 점수 : " +student2Score);

    }
}
