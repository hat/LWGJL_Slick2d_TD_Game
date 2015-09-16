package data;

/**
 * Created by taztony2010 on 8/17/15.
 */
public enum TileType {

    Grass("Grass", true),
    Dirt("Dirt", false),
    Water("Water", false),
    NULL("Water", false);

    String textureName;
    boolean buildable;

    TileType(String textureName, boolean buildable)
    {
        this.textureName = textureName;
        this.buildable = buildable;
    }
}
