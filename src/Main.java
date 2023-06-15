import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numMaleFish = new Random().nextInt()%5+10;
        int numFemaleFish =  new Random().nextInt()%5+10;
        int aquariumWidth = 2;
        int aquariumHeight = 2;
        int aquariumDepth = 2;

        Aquarium aquarium = new Aquarium(numMaleFish, numFemaleFish, aquariumWidth, aquariumHeight, aquariumDepth);
        aquarium.startThreads();
    }
}
