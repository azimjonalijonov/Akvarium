import java.util.Random;

public class Main {
    public static void main(String[] args)   {
        int numMaleFish = new Random().nextInt(1,10)+3;
        int numFemaleFish =  new Random().nextInt(1,30)+3;
        int aquariumWidth = 3;
        int aquariumHeight =3;
        int aquariumDepth = 3;
        Aquarium aquarium = new Aquarium(numMaleFish, numFemaleFish, aquariumWidth, aquariumHeight, aquariumDepth);
        aquarium.startThreads();
    }
}
