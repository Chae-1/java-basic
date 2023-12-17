패키지
==
개발을 진행함에 따라, 많은 클래스를 생성할 것이다.

컴퓨터는 파일을 분류하기 위해 폴더, 디렉토리라는 개념을 제공한다.
자바에서는 패키지를 통해 디렉토리의 개념을 구현했다.

```java
user
- User
- UserHistory
- UserManager
product
- Product
- ProductCatalog
- ProductImage
order
- Order
- OrderService
- OrderHistroy
```
이와 같이 분류해서 관리하고 싶을 것 이때, 패키지가 필요하다.

패키지를 만든 후, 클래스를 만들어야 한다.
```java
package org.example.ch05.pack;

public class Data {
    public Data() {
        System.out.println("패키지 pack Data 생성");
    }
}
```
- 패키지를 사용하는 첫 줄에는 반드시 패키지명을 적어야한다.

```java
package org.example.ch05.pack.a;

public class User {
    public User() {
        System.out.println("패키지 pack.a 회원 생성");
    }
}

public class PackageMain1 {
    public static void main(String[] args) {
        org.example.ch05.pack.a.User user = new org.example.ch05.pack.a.User();
        Data data = new Data();
    }
}

```
- 패키지 하위에 패키지를 생성할 수 있다.
  - pack 하위에 a라는 패키지를 생성했다.
  
- 특정 패키지에서 다른 패키지의 클래스의 인스턴스를 생성하기 위해서는 반드시 해당 생성자가 public 이어야 한다.
- 사용할 클래스의 패키지와 사용자의 패키지가 같다면, 패키지 경로를 생략할 수 있다.
  - 그렇지 않다면, 패키지의 모든 경로를 클래스 이름 앞에 적어주어야 한다.


### import
패키지가 다르다고 항상 경로를 적어주는 것은 불편하다. 이때, import를 사용할 수 있다.
```java
package org.example.ch05.pack;

import org.example.ch05.pack.a.User;
import org.example.ch05.pack.*;

public class PackageMain1 {
    public static void main(String[] args) {
        User user = new User();
        Data data = new Data();
    }
}
```
- 다른 패키지의 클래스를 가져와서 사용할 때, 앞에 패키지 경로를 제외할 수 있다.
  - 다른 패키지의 모든 클래스를 사용해야 한다면, *를 사용할 수 있다.

**클래스 이름 중복**

```java
package org.example.ch05.pack;

import org.example.ch05.pack.a.User;

public class PackageMain3 {
    public static void main(String[] args) {
        User userA = new User();
        org.example.ch05.pack.b.User userB = new org.example.ch05.pack.b.User();
    }
}

```
- 같은 이름의 클래스가 있다면 둘 중 하나만 import가 가능하다.
- 남은 하나는 패키지명을 명시해야한다.

### 패키지 규칙
1. 패키지의 이름과 위치는 폴더(디렉토리) 위치와 같아야 한다.
2. 패키지 이름은 모두 소문자를 사용한다. (관례)
3. 패키지의 이름은 도메인의 이름을 거꾸로 사용한다.
  - 수 많은 외부 라이브러리를 사용할 때, 문제가 될 수 있기 때문이다.
  - 내가 오픈소스를 만들거나 외부에 제공한다면 꼭 지켜야 한다.

### 패키지 계층 구조
- 계층 구조 처럼 보이지만 모두 별개의 패키지다.
  - a, a.b, a.c는 전부 다른 패키지이다.
  - 즉, 사람이

### 패키지의 활용