package com.example.implementations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.interfaces.Tyres;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
// @Primary 어노테이션을 stereotype을 이용한 bean 클래스에도 적용 가능! -> 이 예제처럼 상위 클래스/인터페이스로 의존성 주입을 할 때 필요할 듯
@Primary
public class MichelinTyres implements Tyres {
    private String name;

    public MichelinTyres() {
        System.out.println("MichelinTyres instantiated");
    }
    
    @Override
    public void rotate() {
        System.out.println("Michelin tyre rolls...");
    }

    @PostConstruct
    public void initialize() {
        this.name = "Michelin Tyres";
    }
}
