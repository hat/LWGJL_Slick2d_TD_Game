package data;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import static helpers.Artist.*;

/**
 * Created by taztony2010 on 9/5/15.
 */
public class Player {

    private TileGrid grid;
    private TileType[] types;
    private int index;


    public Player(TileGrid grid)
    {
        this.grid = grid;
        this.types = new TileType[3];
        this.types[0] = TileType.Grass;
        this.types[1] = TileType.Dirt;
        this.types[2] = TileType.Water;
        this.index = 0;
    }

    public void SetTile()
    {
        grid.SetTile((int)Math.floor(Mouse.getX() / 64),
                (int)Math.floor((HEIGHT - Mouse.getY() - 1) / 64), types[index]);
    }

    public void Update()
    {
        if( Mouse.isButtonDown(0) )
        {
            SetTile();
        }
        while(Keyboard.next() )
        {
            if( Keyboard.isKeyDown(Keyboard.KEY_RIGHT) )
            {
                moveIndex();
            }

        }
    }

    private void moveIndex()
    {
        index++;
        if( index > types.length - 1 )
        {
            index = 0;
        }
    }
}
