package pokemon;

import fly.Flyable;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public abstract class Pokemon {
    private int hp;
    private String name;
    private int attackRate;
    private int defenceRate;

    private int xp = 0; //진화를 구현하기 위해 xp 변수를 생성하였고 0으로 초기화하였습니다.

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    protected Map<Integer, String> skills ;
    protected Map<String, Integer> specialAttackRate;


    Flyable flyable;

    public Pokemon() {
    }

    public Pokemon(Flyable flyable) {
        this.flyable = flyable;
    }

    public Map<Integer, String> getSkills() {
        return skills;
    }
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

    public boolean isEvolution = false;
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
    public abstract void attack();
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

    public void evolution(){
        //각 포켓몬 별로 진화
        Map<String, String> evPokemon = Map.of("피카츄", "라이츄", "리자드", "리자몽", "꼬부기", "어니부기");
        Stream<Map.Entry<String, String>> st = evPokemon.entrySet().stream(); //Map을 스트림으로 변환하였습니다.
        st.forEach(n -> { //스트림의 각 값들을 동작시키게 forEach를 활용하였고, 플레이어 캐릭터에 맞게 진화캐릭터를 출력하게 설계하였습니다.
            if(n.getKey().equals(this.getName())){ //forEach문은 Consumer 람다함수 사용가능
                System.out.print(n.getKey() + "에서 " + n.getValue() + "(으)로 진화하였습니다. ");
                this.setName(n.getValue());
            }
        });
        this.setHp(this.getHp() + 30);
        this.setDefenceRate(this.getDefenceRate() + 30);
        isEvolution = true; //한번 진화되었으니 해당 변수를 true로 변경하여 두번 진화되지 않게 설정했습니다.
    }

}
