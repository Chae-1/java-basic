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
