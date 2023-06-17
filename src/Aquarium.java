import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class Aquarium {
    public static CopyOnWriteArrayList<Fish> fishes;
  static   Long id =1l;

    public Aquarium(int numMaleFish, int numFemaleFish, int aquariumWidth, int aquariumHeight, int aquariumDepth) {
        fishes = new CopyOnWriteArrayList<>();

        Random random = new Random();
        for (int i = 0; i < numMaleFish; i++) {
            int x = random.nextInt(aquariumWidth)%3;
            int y = random.nextInt(aquariumHeight)%3;
            int z = random.nextInt(aquariumDepth)%3;
            fishes.add(new Fish(FishType.MALE, x, y, z,id++));
        }

        for (int i = 0; i < numFemaleFish; i++) {
            int x = random.nextInt(aquariumWidth)%3;
            int y = random.nextInt(aquariumHeight)%3;
            int z = random.nextInt(aquariumDepth)%3;
            fishes.add(new Fish(FishType.FEMALE, x, y, z,id++));
        }
    }

    public void startThreads() {
        for (Fish fish : fishes) {
            FishThread thread = new FishThread(fish, fishes);
            thread.start();
        }
    }
}