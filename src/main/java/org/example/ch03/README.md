객체 지향 프로그래밍
==
**절차 지향 프로그래밍 vs 객체 지향 프로그래밍**

**절차 지향 프로그래밍**
- 절차를 지향하는 프로그래밍 방식이다. 실행 순서를 중요하게 생각하는 방식.
- 프로그램의 흐름을 순차적으로 따르며 처리하는 방식.

**객체 지향 프로그래밍**
- 객체를 지향한다. 쉽게 말해 객체를 중요하게 생각하는 방식.
- 사물이나 사건을 객체로 보고, 객체들 간의 상호작용을 중심으로 프로그래밍하는 방식이다.

### **절차지향 프로그래밍 방식**
```java
public class MusicPlayerMain2 {
    public static void main(String[] args) {
        MusicPlayerData data = new MusicPlayerData();
        // 음악 플레이어 켜기
        powerOn(data);
        // 볼륨 증가
        volumeUp(data);
        // 볼륨 증가
        volumeUp(data);
        // 볼륨 증가
        volumeUp(data);
        //..
    }

    private static void powerOn(MusicPlayerData data) {
        data.isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");
    }


    static void volumeUp(MusicPlayerData data) {
        data.volume++;
        System.out.println("음악 플레이엉 볼륨: " + data.volume);
    }

}

```
- 각각의 기능을 메서드로 만들어(모듈화) 각각의 기능을 분리했다.
  - 중복을 제거할 수 있고 쉽게 이해할 수 있게 됐다.

하지만, 위 코드는 객체 지향 프로그래밍이 아니다.
- 데이터와 그를 사용하는 기능이 분리돼있다.
  - 데이터의 이름이 변경되거나 타입이 변경되면 그를 사용하는 다른 코드도 변경이 되는 문제점이 발생한다.
  
이를 해결하려면, 데이터와 기능을 한데 묶어야 한다.

### **객체 지향 프로그래밍 방식**
```java
public class ValueDate {
    int value;

    void add() {
        value++;
        System.out.println("숫자 증가 value = " + value);
    }
}

public class ValueDataMain {
    public static void main(String[] args) {
        ValueDate valueDate = new ValueDate();
        valueDate.add();
        valueDate.add();
        valueDate.add();
        System.out.println("valueDate.value = " + valueDate.value);
    }
}
```
- 객체 내부에 메서드를 포함시킬 수 있다.
  - 이렇게 데이터와 기능을 한데 묶을 수 있다.
- 객체는 메서드를 통해 자신의 멤버 변수에 접근 가능하다.
  - 이때, 메서드에서 접근하는 멤버 변수는 객체 자신의 멤버 변수이다.

## 객체 지향 프로그래밍
- 프로그램의 실행 순서가 아닌 객체를 온전히 만드는 것에 집중한다.
- 해당 객체가 데이터를 가지고 어떤 기능을 제공하는지 초점을 맞춰 개발하는 방식.
```java
public class MusicPlayer {
    int volume = 0;
    boolean isOn = false;

    void on() {
        isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");
    }

    void off() {
        isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }

    void volumeUp() {
        volume++;
        System.out.println("음악 플레이어 볼륨: " + volume);
    }
    //...
}
```
- 해당 객체를 사용하는 입장에서는 필요한 기능(메서드)를 호출하기만 하면 된다.
  - 데이터를 직접 다루지 않는다.
  - 어떤 데이터가 존재하는지 전혀 알지 못해도 사용하는데 문제가 없다.
  - 단순하게 기능을 호출해서 사용하면 된다.

### **캡슐화**
MusicPlayer 클래스는 속성과 기능이 마치 하나의 캡슐에 쌓여있는 것 같다.

이렇게 속성과 기능을 한데 묶어서 필요한 기능을 메서드를 통해 외부로 제공하는 것을 **캡슐화**라고 한다.

- 외부에서는 내부의 속성을 알지 못하기 때문에 외부에서 전혀 수정하지 않아도 된다.


