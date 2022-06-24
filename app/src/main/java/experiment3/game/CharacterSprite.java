package experiment3.game;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.Toast;

/**
 * Created by TR on 2022/5/17.
 */

public class CharacterSprite {
    int x, y;
    private int xVelocity = 10;
    private int yVelocity = 5;
    int shang=5;
    int jiang=5;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    private Bitmap image;
    public CharacterSprite(Bitmap bmp) {
        image = bmp;
        x = 10;
        y = 50;
    }
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }
    public void update()
    {
         y=y+jiang;

//        x += xVelocity;
//        y += yVelocity;
//        end();
//        if ((x > screenWidth - image.getWidth()) || (x < 0)) {
//
//            xVelocity = xVelocity * -1;
//
//        }
//        if ((y > screenHeight - image.getHeight()) || (y < 0)) {
//            yVelocity = yVelocity * -1;
//        }
    }
    public void end(){
        if(x>350&x<450& y>450&y<550){
            xVelocity=0;
            yVelocity=0;
        }
    }

}