package pokemon;

import fly.Flyable;

import java.util.ArrayList;
import java.util.HashMap;

public class Pikachu extends Pokemon {
    public Pikachu(Flyable f) {
        super(f);
        System.out.println("피카피카~");
        this.setName("피카츄");
        this.setAttackRate((int)(Math.random()*6)+50);
        this.setHp(120);
        this.setDefenceRate(40);

        this.skills = new HashMap<>();
        skills.put(1, "전기쇼크");
        skills.put(2, "스피드스타");
        skills.put(3, "10만볼트");

        this.specialAttackRate = new HashMap<>();
        specialAttackRate.put("전기쇼크", 40);
        specialAttackRate.put("스피드스타", 60);
        specialAttackRate.put("10만볼트", 95);
    }


    @Override
    public void attack() {
        System.out.println(this.getName() + "이(가) 전기장판 공격을 시전!");
    }

    public void evolution() { //리자드 클래스 참고
        super.evolution();
        this.skills.put(4, "아이언태일");
        this.specialAttackRate.put("아이언태일", 100);
    }

}
