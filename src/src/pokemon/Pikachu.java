package pokemon;

import fly.Flyable;

import java.util.ArrayList;
import java.util.HashMap;

public class Pikachu extends Pokemon {
    public Pikachu(Flyable f) {
        super(f); // call parent's constructor
        System.out.println("피카피카~");
        this.setName("피카츄");
        this.setAttackRate((int)(Math.random()*6)+50);  // 1차 진화 포켓몬을 공격력 레인지가 5
        this.setHp(35);
        this.setDefenceRate(40);
//        this.skills = new String[]{"전기쇼크", "스피드스타", "10만볼트"};
//        this.specialAttackRate = new Integer[]{40, 60, 95};

//        this.skills = new ArrayList<>();
//        this.skills.add("전기쇼크");
//        this.skills.add("스피드스타");
//        this.skills.add("10만볼트");
//
//        this.specialAttackRate = new ArrayList<>();
//        this.specialAttackRate.add(40);
//        this.specialAttackRate.add(60);
//        this.specialAttackRate.add(95);

        this.skills = new HashMap<>();
        skills.put(1, "전기쇼크");
        skills.put(2, "스피드스타");
        skills.put(3, "10만볼트");

        this.specialAttackRate = new HashMap<>();
        specialAttackRate.put("전기쇼크", 40);
        specialAttackRate.put("스피드스타", 60);
        specialAttackRate.put("10만볼트", 95);
    }

//    public void fly() {
//        //System.out.println("날 수 없습니다!");
//    }

    @Override
    public void attack() {
        System.out.println(this.getName() + "이(가) 전기장판 공격을 시전!");
    }

}
