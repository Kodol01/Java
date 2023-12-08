package pokemon;

import fly.Flyable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//public class pokemon.Charizard extends pokemon.Pokemon implements fly.Flyable{
public class Charizard extends Pokemon {
    public Charizard() {
        System.out.println("자몽자몽!");
        this.setName("리자몽");
        this.setAttackRate((int)(Math.random()*11)+74);  // 2차 진화 포켓몬을 공격력 레인지가 10
        this.setHp(78);
        this.setDefenceRate(78);

        this.skills = new HashMap<>();
        this.skills.put(1, "할퀴기");
        this.skills.put(2, "용의숨결");
        this.skills.put(3, "플레어드라이브");

        this.specialAttackRate = new HashMap<>();
        this.specialAttackRate.put("할퀴기", 40);
        this.specialAttackRate.put("용의숨결", 60);
        this.specialAttackRate.put("플레어드라이브", 120);
    }

    public Charizard(Flyable f) {
        super(f);
        System.out.println("자몽자몽!");
        this.setName("리자몽");
        this.setAttackRate((int)(Math.random()*11)+74);  // 2차 진화 포켓몬을 공격력 레인지가 10
        this.setHp(78);
        this.setDefenceRate(78);
//        this.skills = new String[]{"할퀴기", "용의숨결", "플레어드라이브"};
//        this.specialAttackRate = new Integer[]{40, 60, 120};
//        this.skills = new ArrayList<>(Arrays.asList("할퀴기", "용의숨결", "플레어드라이브"));
//        this.specialAttackRate = new ArrayList<>(Arrays.asList(40, 60, 120));
        this.skills = new HashMap<>();
        this.skills.put(1, "할퀴기");
        this.skills.put(2, "용의숨결");
        this.skills.put(3, "플레어드라이브");

        this.specialAttackRate = new HashMap<>();
        this.specialAttackRate.put("할퀴기", 40);
        this.specialAttackRate.put("용의숨결", 60);
        this.specialAttackRate.put("플레어드라이브", 120);

    }

    @Override
    public void attack() {
        System.out.println(this.getName() + "이(가) 화염 공격시전!");
    }
//    public void attack(Pokemon target, int skill) {
//        super.attack(target, skill);
//        System.out.println("불속성 공격...");
//    }


//    public void fly() {
//        System.out.println("날개를 펼쳐 날아갑니다");
//    }
}
