import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

class FishThread extends Thread {
    private Fish fish;
    private CopyOnWriteArrayList<Fish> fishes;
    private Timer timer;
    private volatile boolean isFishPresent;

    public FishThread(Fish fish, CopyOnWriteArrayList<Fish> fishes) {
        this.fish = fish;
        this.fishes = fishes;
        this.timer = new Timer();
        this.isFishPresent = true;
    }

    @Override
    public void run() {
        while (isFishPresent) {
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {
                        changePosition();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, 0, 3000);

            while (fish.getLifetime() > 0) {
                fish.decrease();
                System.out.println(fish.getType() + " with id " + fish.getID() + " fish at (" + fish.getX() + ", " + fish.getY() + ", " + fish.getZ()
                        + ") has " + fish.getLifetime() + " days left to live.");

                if (fish.getType() == FishType.FEMALE) {
                    synchronized (fishes) {
                        for (Fish otherFish : fishes) {
                            if (otherFish.getType() == FishType.MALE
                                    && otherFish.getX() == fish.getX()
                                    && otherFish.getY() == fish.getY()
                                    && otherFish.getZ() == fish.getZ()
                            ) {
                                Fish newFish = new Fish(Math.random() < 0.5 ? FishType.MALE : FishType.FEMALE,
                                        fish.getX(), fish.getY(), fish.getZ(), Aquarium.id++);
                                fishes.add(newFish);

                                System.out.println("New child born! with id "+newFish.getID());
                                FishThread thread = new FishThread(newFish, fishes);
                                thread.start();
                                break;
                            }
                        }
                    }
                }
            }

            synchronized (fishes) {
                fishes.remove(fish);
                System.out.println("Fish with id " + fish.getID() + " removed");
                isFishPresent = false;
            }
        }
        timer.cancel();

        synchronized (fishes) {
            if (fishes.isEmpty()) {
                System.out.println("No alive fish left");
            }
        }
    }

    private void changePosition() throws InterruptedException {
        Random random = new Random();
        int newX = random.nextInt(3);
        int newY = random.nextInt(3);
        int newZ = random.nextInt(3);
        fish.setX(newX);
        fish.setY(newY);
        fish.setZ(newZ);
        System.out.println(fish.getType() + " with id " + fish.getID() + " and with lifetime " + fish.getLifetime() + " fish at (" + fish.getX() + ", " + fish.getY() + ", " + fish.getZ()
                + ") has changed its position.");

    }
}
