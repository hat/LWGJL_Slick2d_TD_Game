package data;

/**
 * Created by taztony2010 on 9/6/15.
 */
public class Checkpoint {

    private Tile tile;
    private int xDirection, yDirection;

    public Checkpoint(Tile tile, int xDirection, int yDirection)
    {
        this.tile = tile;
        this.xDirection = xDirection;
        this.yDirection = yDirection;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public int getxDirection() {
        return xDirection;
    }

    public int getyDirection()
    {
        return yDirection;
    }
}
