상속
==
```java
public class ElectricCar {
    public void move() {
        System.out.println("차를 이동합니다.");
    }

    public void charge() {
        System.out.println("전기를 충전합니다.");
    }
}


public class GasCar {

    public void move() {
        System.out.println("차를 이동합니다.");
    }

    public void fillUp() {
        System.out.println("");
    }
}
```
GasCar, ElectricCar 둘 다 자동차라는 상위 개념이 존재한다.
- move()라는 메서드가 공통적으로 존재한다.
- 연료를 충전하는 방식이 다르지, 이동하는 것은 같다.
이럴 떄, 상속 관계를 사용하는 것이 효과적이다.

### 상속
기존 클래스의 속성, 기능을 새로운 클래스에서 재사용하게 해주는 객체 지향 프로그래밍의 핵심 요소
- `extends` 키워드를 사용하면 된다.

**상속 구조도**
클래스 다이어그램에서 상속을 표현하면, 자식 클래스에서 부모 클래스를 가르키는 화살표로 나타낸다.
- 자식은 부모를 알지만, 부모는 자식을 알지 못한다.

**단일 상속**
자바에서는 `extends` 키워드로 하나의 부모만 가질 수 있다.
- C++의 경우 다중 상속을 지원한다. 
  - 여러개의 부모에 같은 메서드가 존재할 때, 어떤 메서드를 호출할지 모호해지는 다이아몬드 문제로 자바에서는 이를 허용하지 않는다.


### 상속과 메모리 구조
상속 관계를 객체로 생성할 때, 메모리 구조는 중요하다.
```java
public class Car {

    public void move() {
        System.out.println("차를 이동합니다.");
    }
}

public class ElectricCar extends Car{

    public void charge() {
        System.out.println("충전합니다.");
    }
}

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();
    }
}

```
`new ElectricCar()`를 호출하면, 상속 관계에 있는 Car의 객체도 함께 생성한다. 
- 자식 클래스의 인스턴스를 생성할 때, 부모 클래스도 함께 생성한다.

electric.charge() 메서드를 호출하면, 호출하는 변수의 타입을 기준으로 선택한다.
- electric은 `ElectricCar` 클래스의 인스턴스이다. 따라서, `Electric` 클래스에서 charge() 메서드를 찾는다.
  - 존재하므로, 호출한다.

electric.move()메서드를 호출하면
- `ElectricCar` 클래스에 move()메서드를 탐색하지만, 존재하지 않기 때문에 부모 타입으로 올라가서 찾는다.
- 부모 클래스인 `Car` 클래스에 move() 메서드가 존재하므로, 이를 호출한다.
만약, 상위 클래스에도 존재하지 않는 기능이라면, 컴파일 오류가 발생한다.

정리하자면,
- 상속 관계의 객체를 생성하면 부모와 자식 모두 생성된다.
- 상속 관계의 객체를 호출할 때, 대상 타입을 정해야 한다.
- 대상 타입에서 기능을 못찾으면, 상위 타입에서 기능을 찾는다.


### 기능 추가
상위 클래스에 기능을 추가하면, 모든 하위 클래스에 이 기능이 적용된다.


### 오버라이딩
부모의 기능을 자식에서 재정의하는 것을 오버라이딩(overriding)라 한다.
```java
public class Car {

    public void move() {
        System.out.println("차를 이동합니다.");
    }

    public void openDoor() {
        System.out.println("문을 엽니다.");
    }
}

public class ElectricCar extends Car {

  @Override
  public void move() {
    System.out.println("전기차를 빠르게 움직입니다.");
  }

  public void charge() {
    System.out.println("충전합니다.");
  }
}
```
`ElectricCar`클래스에서 `Car` 클래스의 move() 메서드를 재정의하는 것을 오버라이딩이라고 한다.
- `Car` 클래스의 move()가 아닌, `ElectricCar` 클래스의 move()가 호출된다.

**@Override**
- 자식 클래스에서 오버라이딩 실수를 방지하기 위해 존재하는 애노테이션
  - 오버라이딩을 하지 않을 시, 컴파일 에러를 발생시킨다.

**오버로딩과 오버라이딩**
- **메서드 오버로딩**: 메서드 이름이 같고, 파라미터가 다른 메서드를 정의하는 것을 말한다.
- **메서드 오버라이딩**: 하위 클래스에서 상위 클래스의 기능을 재정의하는 것을 말한다. 즉, 기존 기능을 새로운 기능으로 새롭게 정의한다.

**메서드 오버라이딩 조건**
- 메서드 이름: 메서드 이름이 같아야 한다.
- 메서드 파라미터: 파라미터 타입, 순서, 개수가 같아야 한다.
- 반환 타입: 반환 타입 같아야 한다.
- 접근 제어자: 상위 클래스에 정의된 메서드보다 허용 범위가 넓어야한다.
  - ex) protected method -> private method로 오버라이딩은 불가능
- 예외: 상위 클레스의 메서드보다 더 많은 예외를 throws로 선언 불가능하다.
- `static`, `final`, `private` 메서드는 오버라이딩이 불가능하다.
  - `static` : 클래스 레벨에서 작동하기에 오버라이딩이 의미가 없다.
  - `final` : 더 이상 변경이 불가능하기 때문에 오버라이딩이 불가능하다.
  - `private` : 클래스 내부에서만 사용 가능하기에, 오버라이딩이 불가능하다.
- 생성자 오버라이딩: 생성자는 안된다.

### 상속과 접근 제어
- 자식 타입에서 부모 타입의 기능을 호출할 때, 접근 제어자가 영향을 끼친다.
  - 객체 내부에서는 자식과 부모가 분리돼 있다.
  - 부모는 자식이 호출해도 외부에서 호출하는 것과 같기 때문에 접근 제어자의 영향을 받는다.
 
### super
본인 클래스의 멤버가 아닌, 상위 클래스의 멤버에 직접 접근해야할 경우가 존재한다. 이럴 때, `super` 키워드를 통해 상위 클래스로 접근이 가능하다.

**super 생성자**
상속 관계의 인스턴스를 생성하면, 메모리 내부에는 부모와 자식 모두 생성된다. 즉, 부모와 자식 생성자가 모두 호출된다는 것이다.
- 이때, 자식 클래스에서 반드시 부모 클래스의 생성자를 호출해야한다.

```java
public class ClassA {

    public ClassA() {
        System.out.println("ClassA 기본 생성자 호출");
    }
}

public class ClassB extends ClassA{
  public ClassB(int a) {
//        super(); 기본 생성자는 생략 가능
    System.out.println("a = " + a);
  }

  public ClassB(int a, int b) {
    // super() 기본 생성자는 생략 가능
    System.out.println("a = " + a + ", b = " + b);
  }
}

public class ClassC extends ClassB {

  public ClassC(int a) {
    this(a, 20);
    System.out.println("ClassC 생성자");
  }

  public ClassC(int a, int b) {
    super(a, b);
    System.out.println("ClassC(a,b) 호출");
  }
}
```
- 자식 클래스에서 부모의 생성자를 호출할 때, super(...)를 사용한다.
- `ClassB`의 인스턴스를 생성할 때, 처음에 `ClassA`의 인스턴스를 우선적으로 생성해야한다.
  - 기본 생성자가 있는 경우에는 `super()`가 생략이 가능하다.
- `ClassA`의 인스턴스가 생성된 이후, `ClassB`의 인스턴스를 생성한다.

반면, `ClassB`를 상속한 `ClassC`의 인스턴스를 생성할 떄는 `ClassB`에 다른 생성자가 존재하기에 기본 생성자가 별도로 생성되지 않는다.
- `ClassC`의 인스턴스를 생성 하기 위해서, `ClassB`의 인스턴스를 우선적으로 생성해야한다.
  - `ClassB` 에는 기본 생성자가 별도로 존재하지 않고, 다른 생성자가 존재하기 때문에 명시적으로 생성자를 호출해야한다.
  - 반드시 첫 번째 줄에 `super()`를 호출해야한다. 그렇지 않고 같은 클래스의 다른 생성자를 호출하는 `this()` 할 수 있다.
    - 결과적으로는, this()를 호출한 끝에 반드시 super()를 호출해야한다.
  