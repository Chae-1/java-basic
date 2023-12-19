package org.example.ch09.child;

import org.example.ch09.parent.Parent;

public class Child extends Parent {

    public void call() {
        publicValue = 1;
        protectedValue = 2; // 상속 관계이거나 같은 패키지
        //defaultValue = 3; // 다른 패키지에서 접근 불가능
        //privateValue = 4; // 접근 불가

        publicMethod();
        protectedMethod();
        //defaultMethod() // 다른 패키지에서 접근 불가능
        //privateMethod() // 외부에서 접근 불가능

        printParent();
    }
}
