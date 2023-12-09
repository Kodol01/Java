package pokemon;

import fly.Flyable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Squirtle extends Pokemon {
//    int hp;
//    int attack_rate;
//    String name;

    public Squirtle(Flyable f) {
        super(f);
        System.out.println("꼬북꼬북....");
        this.setName("꼬부기");
        this.setAttackRate((int)(Math.random()*4)+45);
        this.setHp(130);
        this.setXp(0);
        this.setDefenceRate(65);

        this.skills = new HashMap<>(Map.of(1, "물대포", 2, "거품", 3, "하이드로펌프"));
        this.specialAttackRate = new HashMap<>(Map.of("물대포", 40, "거품", 55, "하이드로펌프", 70));
    }

    @Override
    public void attack() {
        System.out.println(this.getName() + "이(가) 물장판 공격을 시전!");
    }

    public void evolution() { //리자드 클래스 참고
        super.evolution();
        this.skills.put(4, "하이드로캐논");
        this.specialAttackRate.put("하이드로캐논", 100);
    }

}
