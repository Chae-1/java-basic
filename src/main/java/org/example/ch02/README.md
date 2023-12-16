기본형과 참조형
==
## 기본형 VS 참조형
**기본형**은 사용하는 값을 변수에 직접 넣을 수 있지만 **참조형**은 변수에 객체의 주소를 저장한다.
- 기본형(Primitive Type): 변수에 사용할 값을 변수에 담아 사용할 수 있는 데이터 타입.
  - ex) boolean, int, double
- 참조형(Reference Type): 변수에 데이터에 접근할 수 있는 참조(주소)를 저장하는 데이터 타입
  - ex) Student, int[] arr

기본형 VS 참조형
- 기본형은 10, 20과 같은 리터럴을 저장하여 바로 사용할 수 있다.
- 참조형은 실제 객체의 위치를 저장기에 바로 사용할 수 없다.
- 기본형은 연산이 바로 가능하지만, 참조형은 연산을 사용할 수 없다.

## 기본형 vs 참조형의 대입
- **자바는 항상 변수의 값을 복사해서 대입한다.**
- 기본형, 참조형 모두 변수에 있는 값을 복사해서 대입한다.
  - 기본형은 저장된 값을, 참조형은 참조값을 복사해서 대입한다.
```java

    public static void main(String[] args) {
        int a = 10;
        int b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        a = 20;
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        b = 30;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

```
- a와 b는 별개로 존재하기 때문에 별개의 값이 저장된다.

```java
public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        Data dataB = dataA;

        System.out.println("dataA 참조값 = " + dataA);
        System.out.println("dataB 참조값 = " + dataB);
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);

        // dataA 변경
        dataA.value = 20;
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);
        
        // dataB 변경
        dataB.value = 30;
        System.out.println("dataA.value = " + dataA.value);
        System.out.println("dataB.value = " + dataB.value);
    }
```
- 반면 같은 인스턴스를 참조하기 때문에, 어떤 참조형 변수에서 객체를 변경해도 변경된 객체에 접근한다.
- 변수의 값을 복사해서 저장하는 성질로 참조형 변수는 복사된 참조값을 갖는다.


## 메서드 호출
**자바는 항상 변수의 값을 복사해서 대입한다.**
```java

    public static void main(String[] args) {
        int a = 10;
        System.out.println("메서드 호출 전 : a = " + a);
        changePrimitive(a);
        System.out.println("메서드 호출 후 : a = " + a);
    }

    static void changePrimitive(int x) {
        x = 20;
    }
    
```
### 메서드에 기본형 타입 변수를 넘길 때
- 항상 변수에 값을 대입하는 것은 항상 값을 복사해서 대입한다.
  - 메서드 호출시, x라는 변수에 a가 가지고 있는 10이라는 값이 복사, 전달된다.
  - 메서드안에서는 x라는 값을 20으로 바꾼 것일 뿐, a는 변동이 없다.

```java
    public static void main(String[] args) {
        Data data = new Data();
        data.value = 10;
        System.out.println("메서드 호출 전: data.value = " + data.value);
        changeValue(data);
        System.out.println("메서드 호출 후: data.value = " + data.value);
    }

    static void changeValue(Data data) {
        data.value = 20;
    }
```
- 항상 변수에 값을 대입하는 것은 항상 값을 복사해서 대입한다.
  - 메서드 호출시, 참조형 변수가 복사된 후 그 값이 메서드의 매개변수에 대입된다. 
  - 메서드안에서는 참조값을 통해 객체에 접근이 가능해진다.

**기본형과 참조형의 메서드**

자바에서 메서드의 매개변수는 항상 값에 의해 전달된다.
  - 매개변수가 기본형일 경우, 즉, 이 두개는 서로 다르다.
  - 매개변수가 참조형일 경우, 두 참조형 변수를 통해 객체로 접근이 가능하니 변동이 일어나면 모든 곳에서 영향을 끼친다.


**변수와 초기화**
```java
public class Student {
    String name;
    int age;
    int grade;
}

```
- 클래스 내부의 모든 필드는 멤버 변수라고 한다.

```java
public static void main(String[] args) {
    int a = 10;
    System.out.println("메서드 호출 전 : a = " + a);
    changePrimitive(a);
    System.out.println("메서드 호출 후 : a = " + a);
}
```
- 메서드 내부의 모든 변수들은 지역 변수이다.
  - 메서드 블럭이 끝나면 제거된다.

- **멤버 변수**는 객체가 생성될 때, 자동으로 초기화된다.
  - 참조형 : null, 기본형 : 0, false
- **지역 변수**는 항상 직접 초기화해야한다.

**null**
- 참조형 변수는 항상 실제 객체의 위치를 가르키는 참조값이 들어간다.
- 나중에 대상을 지정하고 싶을 때, null 이라는 값을 지정할 수 있다.


**GC - 아무도 참조하지 않는 인스턴스의 최후**

참조 변수에 null을 할당한 후, 해당 인스턴스가 더 이상 다른 변수에 의해 참조되지 않는다면 더 이상 사용 불가하다.

이렇게 사용되지 않는 객체들이 메모리에 남아 불필요한 메모리 낭비가 발생한다. JVM의 GC가 더이상 사용되지 않는 인스턴스라 판단하고 삭제한다.


## **NullPointerException**
참조 값없이 객체에 접근할 때, 발생하는 예외이다. null은 해당 객체가 없다는 것을 의미한다. 
찾아갈 수 있는 인스턴스가 존재하지 않아 발생하는 예외이다.
