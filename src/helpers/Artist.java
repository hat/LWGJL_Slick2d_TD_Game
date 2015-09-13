package helpers;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.glMatrixMode;

/**
 * Created by taztony2010 on 8/11/15.
 */
public class Artist {

    //Height and width of game window
    public static final int WIDTH = 1280, HEIGHT = 960;

    public static void BeginSession() {
        //Sets window title
        Display.setTitle("LWGJL GAME");
        try {
            //Sets window size
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));

            //Shows window
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        //Sets gl graphics
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1); //sets up camera
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }

    //Draws quad
    public static void DrawQuad(float x, float y, float width, float height) {
        glBegin(GL_QUADS);
        glVertex2f(x, y); //Top left corner
        glVertex2f(x + width, y); //Top right corner
        glVertex2f(x + width, y + height); //Bottom right corner
        glVertex2f(x, y + height); //Bottom left corner
        glEnd();
    }

    public static void DrawQuadTex(Texture tex, float x, float y, float width, float height)
    {
        tex.bind();
        glTranslatef(x, y, 0);
        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex2f(0, 0);
        glTexCoord2f(1, 0);
        glVertex2f(width, 0);
        glTexCoord2f(1, 1);
        glVertex2f(width, height);
        glTexCoord2f(0, 1);
        glVertex2f(0, height);
        glEnd();
        glLoadIdentity(); //Fixes screen tearing
    }

    public static Texture LoadTexture(String path, String filetype)
    {
        Texture tex = null;

        //Loads texture
        InputStream in = ResourceLoader.getResourceAsStream(path);
        try {
            tex = TextureLoader.getTexture(filetype, in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tex;
    }

    public static Texture QuickLoad(String name)
    {
        Texture tex = null;

        tex = LoadTexture("/Users/taztony2010/IdeaProjects/LWGJL_Slick2d_Game/src/data/res/" + name + ".png", "PNG");

        return tex;
    }


}
