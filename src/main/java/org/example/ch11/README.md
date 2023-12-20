다형성2
==
```java
public class AnimalSoundMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        System.out.println("동물 소리 테스트 시작");
        dog.sound();
        System.out.println("동물 소리 테스트 끝");

        System.out.println("동물 소리 테스트 시작");
        cat.sound();
        System.out.println("동물 소리 테스트 끝");

        System.out.println("동물 소리 테스트 시작");
        caw.sound();
        System.out.println("동물 소리 테스트 끝");
    }
}
```
`Dog`, `Cat`, `Caw` 클래스는 서로 다른 타입이다. 중복되는 부분을 줄이기 위해서는 같은 타입이어야 줄일 수 있다.
- ex) 배열을 통한 for문 접근, 하나의 메서드로 처리

하지만, 서로 다른 타입이므로 중복을 제거할 수가 없다. 이럴때, 다형성을 활용하면 해결할 수 있다.

```java
public class Animal {
    public void sound() {
        System.out.println("동물 울음 소리");
    }
}

public class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("냐옹");
    }
}

public class AnimalSoundMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);

    }

    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
//...
```
`Animal`이라는 상위 클래스를 두고 이를 상속받아서 사용하면 모든 자식 클래스의 인스턴스를 참조할 수 있다.
- 다형적 참조를 통해 `Dog`, `Cat`, `Caw` 인스턴스를 참조할 수 있다.
- 메서드 오버라이딩을 통해 상위 클래스의 메서드를 호출하는 것이 아닌, 실제 인스턴스의 메서드를 호출하기 때문에 중복을 해소할 수 있다.

새로운 기능이 추가되었을 때 변하는 부분을 최소화 하는 것이 잘 작성된 코드이다.

### 남은 문제
- Animal 클래스의 인스턴스를 생성할 수 있다.
  - 추상적인 개념으로 존재하는 클래스의 객체를 생성할 일이 없다.
- 메서드 오버라이딩을 하지 않았을 때, 부모 클래스에 저장된 메서드를 이용한다.

## 추상 클래스
부모 클래스 역할을 하지만, 실제 생성되면 안되는 클래스를 추상 클래스라 한다.
- `abstract` 키워드를 사용한다.
- 직접 인스턴스를 생성하지 못하고 부모 클래스의 역할만 수행 가능하다.

**추상 메서드**
부모 클래스를 상속 받는 자식 클래스가 반드시 오버라이딩 해야할 메서드.
- 부모 클래스에 `abstract` 키워드를 사용한 메서드로 선언하는 것으로 만들 수 있다.
- 추상 메서드가 1개 이상 존재하면, 반드시 추상 클래스로 선언해야 한다.
- 추상 메서드는 메서드 바디가 존재하지 않는다.

**순수 추상 클래스**
모든 메서드가 추상 메서드인 추상 클래스
```java
public abstract class AbstractAnimal {
    public abstract void sound();

    public abstract void move();
}
```
- 실행 로직을 전혀 갖지 않는다.
- 순수 추상 클래스는 다형성을 위한 부모 클래스로만 존재한다.
- 자식 클래스는 모든 메서드를 오버라이딩 해야한다.
순수 추상 클래스는 인터페이스로 제공한다.

## 인터페이스
- 인터페이스의 메서드는 모두 `public`, `abstract`이다.
- 구현시 모든 메서드를 오버라이딩해야 한다.
- 다중 구현을 지원한다.
- 인스턴스의 모든 멤버 변수는 public 상수이다.

**상속 vs 구현**

부모 클래스의 기능을 자식 클래스가 상속 받을 때, 상속이라고 한다.

반면, 인터페이스는 물려받을 기능이 없다. 구현할 메서드만 존재한다. 그래서 인터페이스는 구현한다고 표현한다.

**인터페이스 사용 이유**
모든 메서드가 추상 메서드인 경우, 추상 클래스를 사용해도 되지만, 인터페이스를 사용하자.
- 인터페이스는 다중 구현이 가능하다.

**다중 구현**
다이아몬드 문제로 다중 상속을 허용하지 않는 자바에서는 인터페이스의 다중 구현을 허용하여 이 문제를 해결한다.
- 추상 클래스로만 구성돼 있어 다이아몬드 문제가 발생하지 않는다.

