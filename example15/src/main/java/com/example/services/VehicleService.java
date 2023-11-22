package com.example.services;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import com.example.model.Song;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class VehicleService {
    private Speakers speakers;
    private Tyres tyres;

    private Logger logger = Logger.getLogger(VehicleService.class.getName());

    @Autowired
    public VehicleService(@Qualifier("sonySpeakers") Speakers speakers, Tyres tyres) {
        System.out.println("VehicleService instantiated");
        this.speakers = speakers;
        this.tyres = tyres;
    }

    // AOP (Aspect-Oriented Programming)
    // : AOP는 비즈니스 로직들에 공통으로 실행되어야 하는 로직이 있을 때, 코드 중복을 막기 위해 적용하는 개념.
    // : AOP를 위해, WWW(What-When-Which)을 따르고 각각에 해당하는 용어를 알아야 함.
    //      - What = "Aspect": 수행하고자 하는 로직
    //      - When = "Advice": 언제 실행되어야 할지 (메소드 실행 전 or 후 등)
    //      - Which = "Pointcut": 어떤 메소드에서 실행되어야 할지
    // : 추가 용어
    //      - Join Point: Aspect를 발생시키는 "이벤트"를 의미. Spring 애플리케이션에서는 "메소드 실행"이 그 이벤트가 됨.
    //      - Target Object: Pointcut 메소드가 포함된 bean이 무엇인지
    // : 따라서 AOP 시나리오는 대부분 아래의 문장으로 설명할 수 있음.
    // :    "개발자는 'VehicleService bean(=Target Obejct)' 안에 있는 'moveVehicle()(=Pointcut)'메소드의
    // :     '실행(=Joint Point)' '전에(=Advice)' '특정 로직(=Aspect)'을 실행시키고자 한다."

    // Weaving - AOP의 동작 원리
    // : AOP는 메소드를 가로채서 Aspect를 실행시키는데, POJO에서 대체 어떻게 한걸까?
    // : => Weaving이라는 방식으로 동작함.
    // : Weaving은 Pointcut이 실행될 때, 원본이 아닌 bean의 Proxy Object가 생성되면서 Aspect가 실행되는 방식
    // : 프록시 방식에는 CGLIB Proxy(클래스 기반)와 JDK Dynamic Proxy(인터페이스 기반)가 있는데, Spring Boot는 디폴트로 CGLIB를 사용한다고 함

    // Advice의 종류
    // : Advice에는 아래의 어노테이션들을 사용한 5가지 종류가 있다. 해당 어노테이션은 Aspect에 적용한다.
    //      1. @Before: Pointcut 실행 전
    //      2. @AfterReturning: Pointcut이 예외 없이 정상 실행된 후
    //      3. @AfterThrowing: Pointcut이 예외를 발생시킨 후
    //      4. @After: Pointcut이 예외 상관 없이 실행된 후
    //      5. @Around: After + Before

    // AOP를 사용하지 않는 경우
    // : 특정 비즈니스 로직 전후로 수행되어야 하는 로직들이 많을 수 있음. - 실행 시간 측정, 로깅, 보안(인증/인가), 트랜잭션 관리 등
    // : AOP를 사용하지 않았을 때, 아래 코드와 같이 해당 로직을 매 메소드마다 작성을 해줘야 함. - 가독성이나 유지 보수 측면에서 최악
    /*
    public String playMusic(boolean vehicleStarted, Song song) {
        // 실행 시간 측정
        Instant start = Instant.now();
        // 로깅
        logger.info("method execution start");

        String music = null;
        if(vehicleStarted){
            // 사실상 메인 비즈니스 로직
            music = speakers.makeSound(song);
        } else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }

        logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);

        return music;
    }
    */

    // AOP를 사용하는 경우
    // : 반복되는 코드를 작성하지 않아도, AOP를 구현한대로 실행됨. 따라서 아래의 한 줄로 끝남.
    public String playMusic(boolean vehicleStarted, Song song) {
        return speakers.makeSound(song);
    }

    public String moveVehicle(boolean vehicleStarted) {
        return tyres.rotate();
    }
}
