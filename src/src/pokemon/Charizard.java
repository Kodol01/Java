package pokemon;

import fly.Flyable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//public class pokemon.Charizard extends pokemon.Pokemon implements fly.Flyable{
public class Charizard extends Pokemon {
    public Charizard(Flyable f) {
        super(f);
        System.out.println("자드자드!");
        this.setName("리자드");
        this.setAttackRate((int)(Math.random()*11)+74);  // 2차 진화 포켓몬을 공격력 레인지가 10
        this.setHp(78);
        this.setDefenceRate(78);

        this.skills = new HashMap<>();
        this.skills.put(1, "할퀴기");
        this.skills.put(2, "용의숨결");
        this.skills.put(3, "플레어드라이브");

        this.specialAttackRate = new HashMap<>();
        this.specialAttackRate.put("할퀴기", 20);
        this.specialAttackRate.put("용의숨결", 30);
        this.specialAttackRate.put("플레어드라이브", 70);

    }

    @Override
    public void attack() {
        System.out.println(this.getName() + "이(가) 화염 공격시전!");
    }

    @Override
    public void evolution() {
        super.evolution(); //부모 클래스의 진화 메서드 실행!
        this.skills.put(4, "블라스트번"); //각 스킬을 추가하였습니다.
        this.specialAttackRate.put("블라스트번", 100);
    }
}
