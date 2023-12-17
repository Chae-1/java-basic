package org.example.ch03;
// 메서드로 추출해서 이해하기 편해진 코드
public class MusicPlayerMain2 {
    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();
        // 음악 플레이어 켜기
        powerOn(data);
        // 볼륨 증가
        volumeUp(data);
        // 볼륨 증가
        volumeUp(data);
        // 볼륨
        volumeUp(data);
        // 상태
        showStatus(data);
        // 음악 플레이어 끄기
        powerOff(data);
    }

    private static void powerOff(MusicPlayerData data) {
        data.isOn = false;
        System.out.println("음악 플레이어를 종료");
    }

    private static void powerOn(MusicPlayerData data) {
        data.isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");
    }

    static void showStatus(MusicPlayerData data) {
        System.out.println("음악 플레이어 상태 확인");
        if (data.isOn) {
            System.out.println("음악 플레이어 ON, 볼륨:" + data.volume);
        } else {
            System.out.println("음악 플레이어 OFF");
        }
    }

    static void volumeUp(MusicPlayerData data) {
        data.volume++;
        System.out.println("음악 플레이엉 볼륨: " + data.volume);
    }

    static void volumeDown(MusicPlayerData data) {
        data.volume--;
        System.out.println("음악 플레이어 볼륨: " + data.volume);
    }
}
