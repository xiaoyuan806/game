package experiment3.game;

import android.content.Context;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.view.View;
import android.graphics.Paint;
/**
 * Created by TR on 2022/5/17.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    CharacterSprite characterSprite=null;
ball ball=null;
    dafeat dafeat=null;
    Paint paint=null;
     MainThread thread;
    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas;
        canvas = new Canvas();
        thread.setRunning(true);
        thread.start();
        characterSprite = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.avdgreen));
        ball= new ball(BitmapFactory.decodeResource(getResources(),R.drawable.avdgreen));
        characterSprite.draw(canvas);
        ball.draw(canvas);
         dafeat=new dafeat();
dafeat.draw(canvas);    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();    //join方法的功能是等待该线程执行直到终止。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }
    public void update() {
        characterSprite.update();
        ball.update();

    }
    public void shang(){
        characterSprite.y=characterSprite.y-100;
    }
  public boolean defen(Canvas canvas){

      if (characterSprite.x-50<ball.x&ball.x<characterSprite.x+50&ball.y>characterSprite.y-50&ball.y<characterSprite.y+50){
          System.out.println("4");

//          paint.setColor(Color.RED);
//          paint.setTextSize(80);
//          canvas.drawText("失败了",100,80,paint);
          return true;
      }
      return false;
  }

    public void draw (Canvas canvas ,boolean ty) {
        super.draw(canvas);
        if(canvas != null&ty)
        {
            characterSprite.draw(canvas);
            ball.draw(canvas);

        }
        else {
            dafeat.draw(canvas);
        }

//注意需要注释掉下面这一段代码
        /*if (canvas != null) {
            canvas.drawColor(Color.WHITE);
            Paint paint = new Paint();
            paint.setColor(Color.rgb(250, 0, 0));
            canvas.drawRect(100, 100, 200, 200, paint);
        }*/
    }
    public void drawd (Canvas canvas ) {
        dafeat.draw(canvas);
    thread.stop();}
}
