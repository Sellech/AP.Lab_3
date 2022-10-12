import com.Game.Battlefield.Battle1VS1;
import com.Game.Droids.Droid;
import com.Game.Droids.Medium;


public class Main {
    public static void main(String[] args) {
        Medium r1 = new Medium();
        Medium r2 = new Medium();

        Battle1VS1 b = new Battle1VS1(r1, r2);
        b.fight();
    }
}