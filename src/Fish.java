import java.util.Random;

public class Fish {
    private Long ID;
    private FishType type;
    private Long lifetime;
    private int x;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    private int y;
    private int z;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }


    public Fish(FishType type, int x, int y, int z,long id) {
        this.ID =id;
        this.type = type;
        this.lifetime =10l;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public FishType getType() {
        return type;
    }

    public void setType(FishType type) {
        this.type = type;
    }

    public Long getLifetime() {
        return lifetime;
    }
 public void decrease(){
        lifetime--;
 }
    public void setLifetime(Long lifetime) {
        this.lifetime = lifetime;
    }
}
