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
import java.util.stream.Stream;

public class PokemonGame {
    static Pokemon enemy = null;
    private static void produceEnemyPokemon(){

        System.out.print("야생의 포켓몬이 나타났습니다! ");
        int number = (int)(Math.random() * 3);  // 0, 1, 2
        if(number == 0){
            enemy = new Pikachu(new NoFly());
        } else if (number == 1) {
            enemy = new Squirtle(new NoFly());
        } else if (number == 2) {
            enemy = new Charizard(new FlyWithWings());
        }
    }

    public static void main(String[] args) {
        System.out.println("포켓몬스터 게임을 시작합니다");
        Scanner s = new Scanner(System.in);
        System.out.print("플레이어 포켓몬스터를 고르세요. 1) 피카츄   2) 꼬부기   3) 리자드 : ");

        Pokemon player;

        while(true){
            int select = s.nextInt();
            if(select == 1) {
                int n = (int)(Math.random()*2);
                if(n==0){
                    player = new Pikachu(new NoFly());
                }else{
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

        Boolean continued = true; //while문의 TF를 변경하여 바로 게임을 끝낼 수 있게 boolean변수를 선언하였습니다.

        while(continued) { //적 생성시 부터 while문을 돌려 전투가 한번 끝나면 죽지 않는 이상 계속 전투가 이어지게 설계하였습니다.
            produceEnemyPokemon(); //적 생성

                System.out.print("1) 전투   2) 도망   3) 물약   4) 진화   5) 종료  : ");
                int menu = s.nextInt();
                if (menu == 5) {
                    System.out.println("게임을 종료합니다.");
                    break;
                }
                switch (menu) {
                    case 1:

                        while(true){
                            player.getSkills().forEach((k, v) -> System.out.println(k + ") " + v));
                            player.attack(enemy, s.nextInt());
                            if (enemy.getHp() <= 0) {
                                int winpoint = (int)(Math.random()*5+1);
                                player.setXp(player.getXp()+winpoint);
                                System.out.println(winpoint + "xp 획득! 총 xp : " + player.getXp());
                                break;
                            }

                            enemy.attack(player, (int) (Math.random() * 3) + 1);
                            if (player.getHp() <= 0) {
                                System.out.println("당신은 사망하셨습니다. RIP");
                                System.out.println("게임을 종료합니다.");
                                break;
                            }
                        }

                        break;

                    case 2:
                        player.performFlyable();
                        System.out.println("다른 지역으로 이동합니다");
                        break;

                    case 3:

                        Predicate<Integer> healPotion = hp -> {
                            if (hp > 0)
                                return true;
                            else
                                return false;
                        };
                        if (healPotion.test(player.getHp())) {
                            System.out.println("물약을 마십니다! +50");
                            player.setHp(player.getHp() + 50);
                            System.out.println(player.getName() + "의 체력은 " + player.getHp() + "입니다!");
                        } else {
                            System.out.println("당신은 사망하셨습니다. RIP");
                        }
                        break;

                    case 4: //해당 케이스는 진화 기능을 실행하는 케이스입니다.
                        if(player.isEvolution){ //진화는 한번만 되게 설정하였습니다. 진화가 되면 진화를 못하고 케이스문을 끝내게 설계하였습니다.
                            System.out.println("이미 진화되어 진화를 진행할 수 없습니다.");
                            break;
                        }
                        System.out.println("진화하려면 10xp가 필요합니다. 현재 당신의 xp는 " + player.getXp() + "입니다.");
                        System.out.println();
                        if(player.getXp() < 10){ //진화에 필요한 xp에 미치지 못하면 진화를 못하고 필요한 xp를 출력합니다.
                            System.out.println("xp가 부족하여 진화할 수 없습니다. 더 필요한 xp : " + (10-player.getXp()));
                            break;
                        }
                        player.setXp(player.getXp()-10); //진화가 실행되면 10xp가 차감됩니다.
                        player.evolution(); //진화를 실행합니다. 실행 메서드는 Pokemon 클래스에 있습니다.
                        System.out.println("남은 xp : " + player.getXp());

                        break;


                    default:
                        System.out.println("메뉴에서 선택해주세요~");
                        break;
                }

            if(player.getXp() > 20){ //20xp가 넘으면 while문을 벗어나게 하여 게임을 종료시킵니다.
                System.out.println("당신의 " + player.getName() + "(는)은 스테이지를 클리어하였습니다.");
                System.out.println("게임을 종료합니다.");
                continued = false;
                break;
            }

            System.out.println("계속 하시겠습니까?");
            System.out.println("1) 예  2) 아니요");
            int choose = s.nextInt();
            switch (choose){
                case 1:
                    break;

                case 2:
                    System.out.println("게임을 종료합니다.");
                    continued = false;
            }

        }
    }
}

