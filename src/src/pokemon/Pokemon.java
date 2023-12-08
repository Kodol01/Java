package pokemon;

import fly.Flyable;

import java.util.List;
import java.util.Map;

public abstract class Pokemon {
    private int hp;
    private String name;
    private int attackRate;
    private int defenceRate;

//    protected String[] skills;
//    protected Integer[] specialAttackRate;

//    protected List<String> skills;
//    protected List<Integer> specialAttackRate;

    protected Map<Integer, String> skills ;
    protected Map<String, Integer> specialAttackRate;


    Flyable flyable;  // Association (has a)

    public Pokemon() {
    }

    public Pokemon(Flyable flyable) {
        this.flyable = flyable;
    }

    public Map<Integer, String> getSkills() {
        return skills;
    }

    //    public List<String> getSkills() {
//        return skills;
//    }
    public void setFlyable(Flyable flyable) {
        this.flyable = flyable;
    }

    public void performFlyable(){
        System.out.print(this.getName() + "은(는) ");
        this.flyable.fly();
    }

    public int getDefenceRate() {
        return defenceRate;
    }

    public void setDefenceRate(int defenceRate) {
        this.defenceRate = defenceRate;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackRate() {
        return attackRate;
    }

    public void setAttackRate(int attackRate) {
        this.attackRate = attackRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void attack(){
//        System.out.println("공격 시전!");
//    }
    public abstract void attack();  // 추상메서드
    public void attack(Pokemon target, int skill){
        int temporary_attack_rate = (this.getAttackRate() + this.specialAttackRate.get(this.skills.get(skill))) - target.getDefenceRate();
        if (temporary_attack_rate < 0){
            temporary_attack_rate = 0;
        }
        target.setHp(target.getHp() - temporary_attack_rate);
        System.out.println(this.getName() + "이(가) " + this.skills.get(skill) + " 공격을 " + target.getName() +"에게 시전!");
        if (target.getHp() <= 0){
            System.out.println(target.getName() + "은(는) 사망!");
        }else {
            System.out.println(target.getName() + "의 체력이 " + target.getHp() + "입니다.");
        }
    }
    public void fly(){
        System.out.println("날아갑니다");
    }

}
