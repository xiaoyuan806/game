package experiment3.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;

/**
 * Created by TR on 2022/5/17.
 */

public class ball {
    int x, y;
    Random rd = new Random();
    int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
     int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    private Bitmap image3;
    public ball(Bitmap bmp) {
        image3 = bmp;
        x = screenHeight+500;
        y = 200;
    }
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image3, x, y, null);
    }
    public void update()
    {
       x=x-5;
      if ((x > screenWidth - image3.getWidth()) || (x < 0)) {

          x=screenHeight+500;
          y=rd.nextInt(300);
          System.out.println(y);
       }
    }
}
