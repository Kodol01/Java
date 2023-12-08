import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pokemon{
    protected String name;
    protected int level;
    protected boolean canEvolve;

    public Pokemon(String name, int level, boolean canEvolve) {
        this.name = name;
        this.level = level;
        this.canEvolve = canEvolve;
    }

    void evolve(){
        if(canEvolve){
            level++;
            System.out.println(name + "이(가) "+ level +"레벨로 진화함!!");
        }
    }
}
public class StreamDemo {
    public static void main(String[] args) {
        List<Pokemon> pokemons = new ArrayList<>(
                Arrays.asList(
                        new Pokemon("피카츄", 5, true),
                        new Pokemon("파이리", 10, false),
                        new Pokemon("이상해씨", 7, true)
                )
        );
        pokemons.stream()
                .filter(pokemon -> pokemon.canEvolve)
                //.forEach(p -> p.evolve());
                .forEach(Pokemon::evolve);
    }
}
