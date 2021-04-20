import com.github.modelisation.gestionchar.CharDAttaque;
import com.github.modelisation.munitions.MunitionFactory;
import com.github.modelisation.munitions.TypeMunition;

public class Main {

    public static void main(String[] args) {
	CharDAttaque c = new CharDAttaque("Peugeot", 100);
	c.ajouterMunition(MunitionFactory.getMunition(TypeMunition.BALLON));
	c.ajouterMunition(MunitionFactory.getMunition(TypeMunition.OBUS_EXPLOSIF));
	c.ajouterMunition(MunitionFactory.getMunition(TypeMunition.OBUS_PERFORANT));
    }

}
