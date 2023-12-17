접근 제어자
==
public, private같은 접근 제어자를 제공한다. 접근 제어자를 사용하면 해당 클래스 외부에서 특정 필드나 메서드에 접근하는 것을 제한할 수 있다.
- 제한하지 않을 경우 직접 필드에 접근하여 수정할 수 있기 때문에 제대로 기능 수행을 하지 못할 수 있다.

그래서, 필드의 외부 접근을 차단해야한다.

private 접근 제어자가 이를 가능하게 한다. private 접근 제어자는 모든 외부 호출을 막는다.
- 클래스 내부에서는 사용 가능하지만, 외부에서는 접근이 불가능해진다.
- 사전에 외부 접근을 막는 것으로 추후 발생할 수 있는 문제를 원천적으로 차단할 수 있다.
접근 제어자는 적절한 제약을 제공한다는 점에서 중요하다.

### 접근 제어자 종류
- `private`: 모든 외부 호출을 막는다.
- `default`: 같은 패키지안에서 호출은 허용한다.
- `protected`: 같은 패키지안에서 호출은 허용한다. 패키지가 달라도 상속 관계의 호출은 허용한다.
- `public`: 모든 외부 호출을 허용한다.

**package-private**

접근 제어자를 명시하지 않으면 `default` 접근 제어자가 사용된다.

같은 패키지내의 다른 클래스에서 직접 호출이 가능하다는 점 때문에 package-private라고도 한다.

접근 제어자는 속성, 메서드에 사용이 가능하다.
- `private`: 현재 클래스에서만 사용하겠다는 선언.
- `default`: 현재 클래스의 같은 패키지에서만 사용하겠다는 선언.
- `protected`: 현재 클래스의 같은 패키지와 이 클래스를 상속받는 자식 클래스에서만 사용하겠다는 선언.
- `public`: 어디서든지 사용해도 된다는 선언.

```java
package org.example.ch06.a;

public class AccessData {
    public int publicField;
    int defaultField;
    private int privateField;

    public void publicMethod() {
        System.out.println("publicMethod 호출 " + publicField);
    }

    void defaultMethod() {
        System.out.println("defaultMethod 호출 " + defaultField);
    }

    private void privateMethod() {
        System.out.println("privateMethod 호출 " + privateField);
    }

    public void innerAccess() {
        System.out.println("내부 호출");
        publicField = 100;
        defaultField = 100;
        privateField = 100;
        publicMethod();
        defaultMethod();
        privateMethod();
    }
}
```
- 클래스 내부에서는 `private`, `default`, `public` 멤버 모두 호출 가능하다.

**같은 패키지에 있는 클래스**
```java
package org.example.ch06.a;

public class AccessInnerMain {
    public static void main(String[] args) {
        AccessData accessData = new AccessData();

        //public 호출 가능
        accessData.publicMethod();
        accessData.publicField = 100; // 호출 가능

        // 같은 패키지에서 default 호출 가능
        accessData.defaultMethod();
        accessData.defaultField = 200;

        //private 호출 불가능
        //  accessData.privateMethod();
        //  accessData.privateField = 200;
        accessData.innerAccess();
    }
}
```
- 같은 패키지의 외부 클래스에서는
- `private`은 접근 불가능하다.
- `default`은 같은 패키지에 존재하기 때문에 접근 가능하다.
- `public`은 어디서나 호출 가능하다.

**다른 패키지에 있는 클래스**
```java

import org.example.ch06.a.AccessData;

public class AccessOuterMain {
    public static void main(String[] args) {
        AccessData accessData = new AccessData();

        //public 호출 가능
        accessData.publicMethod();
        accessData.publicField = 100; // 호출 가능

        // 다른 패키지에서 default 호출 불가능
        //accessData.defaultMethod();
        //accessData.defaultField = 200;

        //private 호출 불가능
        //  accessData.privateMethod();
        //  accessData.privateField = 200;
        accessData.innerAccess();
    }
}
```
- 다른 패키지에서는 `default` 접근 제어자로 선언된 멤버의 접근을 허용하지 않는다.
- `private` 는 당연히 안된다.
- `public`은 전부 호출 가능하다.


### 클래스 레벨에서의 접근 제어자
- 클래스 레벨에서는 `public`, `default`만 사용할 수 있다.
  - `private`, `protected`는 사용 불가능하다.
- `public` 클래스는 반드시 파일명과 같아야한다.
- `default` 클래스는 `java`파일 내부에서 무한정 만들 수 있다.

```java
package org.example.ch06.a;

public class PublicClass {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        DefaultClass1 defaultClass1 = new DefaultClass1();
        DefaultClass2 defaultClass2 = new DefaultClass2();

    }
}

class DefaultClass1 {

}

class DefaultClass2 {

}

public class PublicClassInnerMain {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        DefaultClass1 defaultClass1 = new DefaultClass1();
        DefaultClass2 defaultClass2 = new DefaultClass2();
    }
}

```
- 같은 패키지내에서 사용할 때, `default` 클래스를 사용할 수 있다.

```java

import org.example.ch06.a.PublicClass;

public class PublicClassOuterMain {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
    }
}
```
- 패키지가 다르면 `default` 클래스를 사용할 수 없다.


## 캡슐화
캡슐화(Encapsulation)은 객체 지향 프로그래밍에서 아주 중요하다.
- 데이터와 해당 데이터를 처리하는 메서드를 하나로 묶어서 외부에서의 접근을 제한한다.
- 즉, 지금까지 클래스를 구성한 것처럼 데이터와 기능을 한데 묶고 추가적으로 접근 제어자를 통해 필요한 부분만 공개하는 것이 캡슐화이다.

**1. 데이터를 숨겨라**
- 객체 내부의 데이터를 외부에서 함부로 접근하게 두면, 클래스의 기능이 전부 파괴될 수 있다. 즉, 내부 로직이 전부 무시된다.
  - 사용하는 입장에서는ㄴ 데이터를 직접 확인할 필요가 없다.
  - ex) MusicPlayer

**객체의 데이터는 객체가 제공하는 기능인 메서드를 통해서 접근해야한다.**
  
**2. 기능을 숨겨라**
객체의 기능 중에서 외부에서 사용하지 않고 내부에서만 사용하는 기능들이 존재하기에 이런 기능을 감춰야한다.
- 내부에서만 사용되는 기능을 공개한다면, 사용하는 입장에서 혼란을 야기할 수 있다.

즉, 접근 제어자와 캡슐화를 통해 데이터를 안전하게 보호할 수 있고 사용하는 개발자 입장에서 복잡도를 낮출 수 있다.
