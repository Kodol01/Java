import fly.FlyWithJetPack;
import fly.FlyWithWings;
import fly.NoFly;
import pokemon.Charizard;
import pokemon.Pikachu;
import pokemon.Pokemon;
import pokemon.Squirtle;

import java.util.Map;
import java.util.Scanner;
import java.util.function.*;

public class PokemonGame {
    static Pokemon enemy = null;
    private static void produceEnemyPokemon(){
        //Pokemon enemy = new Pikachu(new NoFly());

        System.out.print("야생의 포켓몬이 나타났습니다! ");
        int number = (int)(Math.random() * 3);  // 0, 1, 2
        if(number == 0){
            enemy = new Pikachu(new NoFly());
        } else if (number == 1) {
            enemy = new Squirtle(new NoFly());
        } else if (number == 2) {
            enemy = new Charizard(new FlyWithWings());
        } else{
            System.out.println("이 코드는 영원히 실행되지 않습니다");
        }
    }

    public static void main(String[] args) {
        System.out.println("포켓몬스터 게임을 시작합니다");
        Scanner s = new Scanner(System.in);
        System.out.print("플레이어 포켓몬스터를 고르세요. 1) 피카츄   2) 꼬부기   3) 리자몽 : ");

        Pokemon player;
        while(true){
            int select = s.nextInt();
            if(select == 1) {
                int n = (int)(Math.random()*2);
                if(n==0){
                    //System.out.println("NoFly실행");
                    player = new Pikachu(new NoFly());
                }else{
                    //System.out.println("JetPack실행");
                    player = new Pikachu(new FlyWithJetPack());
                }
                break;
            } else if (select == 2) {
                int n = (int)(Math.random()*2);
                if(n==0){
                    player = new Squirtle(new NoFly());
                }else{
                    player = new Squirtle(()-> System.out.println("물풍선을 타고 날아갑니다"));
                }
                break;
            } else if (select == 3) {
                player = new Charizard(new FlyWithWings());
                break;
            } else {
                System.out.println("프로그램을 종료합니다");
            }
        }

        // 적 포켓몬 생성 코드는 외부 메서드로 이동
        produceEnemyPokemon();

        while(true){
            System.out.print("1) 전투   2) 도망   3) 물약   4) 종료 : ");
            int menu = s.nextInt();
            if(menu == 4)
                break;  // while구문 탈출
            switch (menu){
                case 1:
//                    for(String skill : player.getSkills())
//                        System.out.print(skill + " ");
//                    for(int i=0; i<3; i++)
//                        System.out.print((i + 1) + ") " + player.getSkills().get(i) + " ");

//                    for(Map.Entry<Integer, String> mapSkill : player.getSkills().entrySet()){
//                        System.out.println(mapSkill.getKey() + ") " + mapSkill.getValue());
//                    }
                    player.getSkills().forEach((k, v)-> System.out.println(k + ") " + v));

                    //String temp = s.next();  // feat. 김남희
                    player.attack(enemy, s.nextInt());
                    enemy.attack(player, (int)(Math.random()*3)+1);
//                    enemy.attack(player, "어떤 공격");
                    break;
                case 2:
                    player.performFlyable();
                    System.out.println("다른 지역으로 이동합니다");
                    produceEnemyPokemon();
                    break;
                case 3:
//                    UnaryOperator<Integer> healPotion = hp ->  hp + 50;
//                    player.setHp(healPotion.apply(player.getHp()));

//                    Function<Integer, Integer> healPotion = hp -> hp + 50;
//                    player.setHp(healPotion.apply(player.getHp()));

//                    Supplier<Integer> healPotion = () -> 50;
//                    player.setHp(healPotion.get() + player.getHp());

//                    Consumer<Integer> healPotion = hp -> {
//                        player.setHp(hp + 50);
//                    };
//                    healPotion.accept(player.getHp());

                    Predicate<Integer> healPotion = hp -> {
                        if(hp > 0)
                            return true;
                        else
                            return false;
                    };
                    if(healPotion.test(player.getHp())) {
                        System.out.println("물약을 마십니다! +50");
                        player.setHp(player.getHp() + 50);
                        System.out.println(player.getName() + "의 체력은 " + player.getHp() + "입니다!");
                    }else{
                        System.out.println("당신은 사망하셨습니다. RIP");
                    }
                    break;
                default:
                    System.out.println("메뉴에서 선택해주세요~");
                    break;
            }
        }
    }
}

