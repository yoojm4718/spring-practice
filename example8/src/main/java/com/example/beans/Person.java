package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Person {
    private String name;

    // Wiring Option 3. @Autowired on Field
    // : @Autowired 어노테이션을 통해, stereotype을 이용한 bean 등록 상황에서 다른 bean과의 의존성을 명시할 수 있음
    // : 해당 옵션과 같이 멤버 변수에 @Autowired를 적용하면, IoC Container에서 해당 타입의 bean을 찾아 의존성을 주입해 줌
    // : 만약 해당 타입의 bean이 context에 없다면, NoSuchBeanDefinitionException 발생
    // : 해당 옵션부터가 진정한 의미의 DI
    // : final로 선언할 수 없기 때문에, 권장되지 않음.
    // : 만약 해당 의존성이 필수가 아닌 경우, 아래와 같이 required를 false로 설정 가능 (default는 true) -> bean이 없어도 그냥 null로 처리
    // @Autowired(required = false)
    @Autowired
    private Vehicle vehicle;

    public Person() {
        System.out.println("Person instantiated");
    }

    @PostConstruct
    public void initialize() {
        this.name = "Jungmin";
    }
}
