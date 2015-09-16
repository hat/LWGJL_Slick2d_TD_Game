package data;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import helpers.Clock;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

import static helpers.Artist.*;
import static data.Tile.*;

/**
 * Created by taztony2010 on 8/10/15.
 */
public class Boot {

    public Boot() {

        BeginSession();

        int[][] map = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 2, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 2, 2, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        TileGrid grid = new TileGrid(map);
        grid.SetTile(16, 3, grid.GetTile(15, 3).getType());
        Enemy e = new Enemy(QuickLoad("Enemy1"), grid.GetTile(1, 6), grid, 64, 64, 6);
        Wave wave = new Wave(20, e);
        Player player = new Player(grid);

        //Runs until close is pressed
        while (!Display.isCloseRequested()){

            Clock.update();

            grid.Draw();
            wave.Update();
            player.Update();

            //Updates window
            Display.update();
            Display.sync(60);
        }

        //Gets rid of window
        Display.destroy();
    }

    public static void main(String[] args) {
        new Boot();
    }
}
