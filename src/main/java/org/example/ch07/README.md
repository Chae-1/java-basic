자바 메모리 구조, static
==
## 자바 메모리 구조
자바 메모리 구조는 메서드 영역, 스택 영역, 힙 영역으로 나뉜다.
- **메서드 영역**: 프로그램을 실행하는 데 필요한 공통 데이터를 관리한다 이 영역은 프로그램의 모든 영역에서 공유한다. 
  - 클래스 정보: 클래스의 실행코드(바이트 코드), 필드, 메서드와 생성자 코드등 모든 실행 코드 존재
  - static 영역: static 변수들을 보관한다.
  - 런타임 상수 풀: 프로그램을 실행하는 데 필요한 리터럴 상수를 보관.
- **스택 영역**: 실제 프로그램이 실행되는 영역. 메서드를 실행할 때 마다 하나씩 쌓인다.
  - 자바 실행 시, 하나의 실행 스택이 실행된다. 각 스택 프레임은 지역 변수, 중간 연산 결과, 메서드 호출 정보등을 포함한다.
  - 스택 프레임: 메서드를 호출할 때 마다 호출 정보가 쌓인다.
  - 쓰레드의 개수만큼 스택 영역이 생성된다. 
- **힙 영역**: `new` 명령어를 통해 생성된 객체가 해당 영역을 사용한다.
  - 객체와 배열이 생성되는 영역.
  - GC의 대상

### **메서드 코드는 메서드 영역에**
100개의 인스턴스를 생성하면, 힙 메모리에 100개의 인스턴스가 생긴다.

인스턴스의 멤버 변수는 모두 다른 값을 가질 가능성이 높기 때문에, 힙 영역에 생기지만,
모든 인스턴스가 같은 메서드를 갖기 때문에, 메서드 코드는 힙 영역이 아닌 메서드 영역에 관리된다.


## 스택, 큐 자료구조

### 스택(Stack) 구조
스택은, 가장 마지막에 넣은 데이터가 먼저 조회되는 구조를 갖는 자로구조이다.
- 이러한 구조를 후입선출(Last In First Out)라 한다.

### 큐(Queue) 자료 구조
- 후입 선출과 반대로 가장 먼저 넣은 것이 가장 먼저 나오는 것을 선입 선출이라 한다.
  - 이런 선입선출(First In First Out)의 자료구조를 큐라고 한다.

프로그램의 실행과 메서드 호출에는 스택 구조를 갖고 동작한다.


## 스택 영역
```java
public class JavaMemoryMain1 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1(10);
        System.out.println("main end");
    }

    static void method1(int m1) {
        System.out.println("method1 start");
        int cal = m1 * 2;
        method2(cal);
        System.out.println("method1 end");
    }

    static void method2(int m2) {
        System.out.println("method2 start");
        System.out.println("method2 end");
    }
}
```
1. 처음 프로그램을 실행하면, main() 스택 프레임이 생성되고 스택 영역에 쌓인다. 스택 프레임에는 
   - args라는 매개 변수를 갖게 된다.
2. 다음 메서드인 method1()이 호출되면 m1, cal을 갖는 스택 프레임이 생성된다.
3. method2()도 마찬가지로 생성된다.
4. method2()가 종료되면, 스택 영역 맨위에 존재했던, method2() 스택 프레임이 제거된다.
   - 제거됨에 따라 매개변수 정보도 삭제된다.
5. 제거가 됐으니, method1()으로 돌아온다.
6. method1()이 종료되면 또한 스택 프레임이 제거되고 main()으로 복귀한다.
7. main()이 종료되면, 스택 영역에 모든 스택 프레임이 제거된다. 
8. 프로그램이 종료된다.


### 스택 영역, 힙 영역
```java
public class JavaMemoryMain2 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1(10);
        System.out.println("main end");
    }

    static void method1(int m1) {
        System.out.println("method1 start");
        Data data = new Data(m1);
        method2(data);
        System.out.println("method1 end");
    }

    static void method2(Data data) {
        System.out.println("method2 start");
        System.out.println("data.getValue() = " + data.getValue());
        System.out.println("method2 end");
    }
}
```
1. main() -> method1()의 스택 프레임이 순서대로 생성된 후 스택 영역에 쌓인다.
2. method1()에서 Data 인스턴스를 생성한다. 인스턴스는 힙 영역에 존재하게 된다.
3. method2()에 Data 인스턴스를 매개변수로 넘겨주면 method1(), method2()에서 해당 인스턴스를 참조하게 된다.
4. method2(), method1() 순차적으로 종료된다.
   - 이때 스택 프레임이 제거된 후, 매개변수, 지역 변수가 삭제가 된다. 
5. 더 이상 Data 인스턴스를 참조하는 곳이 존재하지 않는다.
6. 이 데이터 인스턴스는 GC의 대상이 되고, 메모리에서 제거된다.

**지역 변수는 스택 영역에, 인스턴스는 힙 영역에서 관리된다.**

## static 변수
- static 키워드는 멤버 변수, 메서드에 사용된다.
- 인스턴스간 멤버 변수가 각각 다른 메모리에 존재하기 때문에, 이 객체들의 공통 변수가 존재하지 않는다.
  - 외부 인스턴스를 활용할 수 있지만, 복잡해지는 문제가 있다.

static 변수는 이런 문제를 해결해준다.
  - 여러 인스턴스가 함께 공용으로 사용할 수 있는 필드를 만들어준다. 

```java
public class Data3 {
    public String name;
    public static int count;

    public Data3(String name) {
        this.name = name;
        count++;
    }
}

public class DataCountMain3 {
  public static void main(String[] args) {
    Data3 data1 = new Data3("A");
    System.out.println("A count = " + Data3.count);

    Data3 data2 = new Data3("B");
    System.out.println("A count = " + Data3.count);

    Data3 data3 = new Data3("C");
    System.out.println("A count = " + Data3.count);
  }
}

```
- static이 붙은 변수는 인스턴스의 변수로 접근하는 것이 아닌, 클래스명으로 접근한다.
- static이 붙은 멤버 변수는 힙 영역이 아닌 메서드 영역에서 관리된다.

메서드 영역에서 관리한다는 것은 여러 인스턴스에서 공용으로 사용하겠다는 의미가 된다.


### static 정리
```java
public class Data3 {
    public String name;
    public static int count;
}
```
- name, count는 둘다 멤버 변수이다.
  - static 여부에 따라 분류를 다음과 같이 할 수 있다.
- 인스턴스 변수: static이 붙지 않은 멤버 변수. 
  - 힙 영역에서 관리는 변수. 즉, 인스턴스를 생성할 때 마다 새로 만들어진다.
- 클래스 변수: static이 붙은 멤버 변수.
  - 클래스 변수, static 변수, 정적 변수로 부른다.
  - static이 붙은 멤버는 인스턴스와는 전혀 무관한 데이터이다.
  - 자바 프로그램을 시작할 때 딱 1개 만들어진다.

### 변수와 생명주기
- 지역 변수: 지역 변수는 스택 프레임에 보관된다. 메서드 종료시, 스택 프레임에 포함된 지역 변수가 모두 사라진다.
- 인스턴스 변수: GC의 대상이 되기 이전까지는 힙 영역에 보관된다.
- 클래스 변수: 메서드 영역에 보관되기 때문에 프로그램 종료 이전까지는 생존한다.
생명 주기 순위 : 클래스 변수 > 인스턴스 변수 > 지역 변수


## static 메서드
단순히 기능만 제공하는 클래스의 경우 객체를 생성하는 것이 의미가 없다.
이럴 경우, 정적 메서드를 만들 수 있다. 정적 변수와 마찬가지로 클래스 이름으로 호출이 가능하다.
- static이 붙은 메서드는 객체 생성 없이 클래스명 + . + 메서드명으로 호출 가능
- 이를 클래스 메서드, 정적 메서드라고 부른다.
  - 클래스 메서드에서는 정적 메서드나 정적 변수만 사용할 수 있다.
  - 인스턴스 변수, 메서드는 사용 불가능하다.
- 모든 곳에서 호출이 가능하다.

```java
public class DecoValue {
    private int instanceValue;
    private static int staticValue;
    public static void staticCall() {
//        instanceValue++;
//        instanceMethod();

        staticValue++; // 정적 변수 접근
        staticMethod(); // 정적 메서드 접근
    }

    public void instanceCall() {
        staticValue++;
        staticMethod();

        instanceValue++;
        instanceMethod();
    }

    public static void staticMethod() {
        System.out.println("staticValue = " + staticValue);
    }

    public void instanceMethod() {
        System.out.println("instanceValue=" + instanceValue);
    }
}
```
- staticCall() 메서드 안에서는
  - 정적 멤버들에만 접근이 가능하고, 인스턴스 멤버로 접근은 할 수없다.
- instanceCall() 메서드 안에서는
  - 클래스의 모든 멤버로 접근이 가능하다.

- 정적 메서드는 클래스의 이름으로 바로 호출할 수 있지만 인스턴스처럼 참조값의 개념이 없다.
그래서 인스턴스 변수와 메서드에 접근할 수 없다.

### static 메서드 용어 정리
**멤버 메서드의 종류**
- 인스턴스 메서드: static이 붙지 않은 멤버 메서드
- 클래스 메서드: static이 붙은 멤버 메서드
  - 클래스 메서드, 정적 메서드, static 메서드등으로 부른다.

**정적 메서드 활용**
객체의 생성이 필요 없이 메서드의 호출만으로 필요한 기능을 수행할 때 주로 사용한다.
- 간단한 메서드 하나로 끝나는 유틸리티 메서드
  - ex) Math 클래스

**static import**
정적 메서드를 자주 호출해야할때, 클래스이름을 생략할 수 있게 해준다.

