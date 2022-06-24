package experiment3.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by TR on 2022/5/17.
 */

public class dafeat {
    int x, y;
    Paint paint=null;

    Random rd = new Random();
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    private Bitmap image3;
    public dafeat() {

    }
    public void draw(Canvas canvas) {
        paint=new Paint();
      paint.setColor(Color.RED);
        paint.setTextSize(80);
        canvas.drawText("失败",500,80,paint);;
    }
    public void update()
    {

    }
}
