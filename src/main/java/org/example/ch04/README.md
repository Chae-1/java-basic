생성자
==
### 생성자가 필요한 이유

```java
MemberInit member1 = new MemberInit();
member1.name = "user1";
member1.age = 15;
member1.grade = 90;

MemberInit member2 = new MemberInit();
member2.name = "user2";
member2.age = 16;
member2.grade = 80;
```
- 위 코드 처럼 객체를 생성하면서 초기에 멤버 변수를 설정해줘야 사용 가능하다.

```java
private static MemberInit createMember(String name, int age, int grade) {
    MemberInit member1 = new MemberInit();
    member1.name = name;
    member1.age = age;
    member1.grade = grade;
    return member1;
}
```
- 메서드를 통해서 중복되는 부분을 제거할 수 있다.
  - 하지만, 데이터와 기능이 별개로 존재한다는 단점이 존재한다.


### this
this는 인스턴스 자기 자신을 가르키는 참조를 의미한다.
- 메서드의 매개변수가 코드 블럭안에 존재하기에 우선 순위가 멤버 변수보다 높다.
  - 그래서, 매개변수의 이름과 멤버 변수가 같은 경우 이를 구분하기 위해 사용한다.
IDE에서 멤버 변수와 매개변수를 구분해주기 때문에, 필요할 때 사용하면 된다.


### 생성자
객체를 생성하자마자 즉시 기능을 수행할 수 있도록 생성하는 시점에 단 한번 호출되는 함수.
- 생성자는 클래스의 이름과 같다.
- 반환 타입이 없다.
- 나머지는 메서드랑 같다.
```java
public class MemberConstruct {
    String name;
    int age;
    int grade;

    MemberConstruct(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
```
생성자는 인스턴스를 생성하고 난 뒤 즉시 호출된다.
- new 클래스이름(매개변수 목록)
  - ex) new MemberConstruct("name", 10, 10);
- 지금까지 객체를 생성할 때, ()가 있던 이유는 생성자를 호출했기 때문이다.

장점
- 중복 호출을 제거해준다.
  - ex) 메서드를 사용하여 객체를 생성하는 작업
- 필수 입력값들에 대한 제약을 걸어줄 수 있다.

**생성자를 사용하면 필수값 입력을 보장할 수 있다.**

### 기본 생성자
생성자를 별도로 생성한다면, 매개 변수가 없는 생성자를 만든다.
- 기본 생성자를 자동으로 만들어 주지 않는다면, 빈 생성자를 무조건 만들어줘야 하기에 문제가 된다.

1. 생성자는 반드시 호출 된다.
2. 별도로 생성하지 않으면 기본 생성자가 컴파일러에 의해 추가된다.
3. 생성자를 별도로 생성하면, 기본 생성자가 추가되지 않는다.


### this(), 오버로딩
생성자는 메서드의 오버로딩 처럼 여러 개 존재할 수 있다.

클래스 내의 생성자가 여러 개 존재할 때, 생성자 내부에서 다른 생성자를 호출할 수 있다.
```java
public class MemberConstruct {
    String name;
    int age;
    int grade;

    MemberConstruct(String name, int age) {
        this(name, age, 50); // t
    }

    MemberConstruct(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

```
이럴 때, this()를 사용한다.
- this() : 자기 자신의 생성자를 호출한다.
  - 생성자의 첫 줄에만 작성할 수 있다.  
