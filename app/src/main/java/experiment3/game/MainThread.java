package experiment3.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

/**
 * Created by TR on 2022/5/17.
 */

public class MainThread extends Thread {
Paint paint=null;
     boolean running;        //运行变量
    public static Canvas canvas;
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    public MainThread(SurfaceHolder surfaceHolder, GameView gameView) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }

    public MainThread() {

    }

    @Override
    public void run() {
        System.out.println("still runing");
        while (running) {
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();          //加锁
                synchronized(surfaceHolder) {
                    this.gameView.update();                   //更新游戏缓存
                    this.gameView.draw(canvas,running);

                    if (this.gameView.defen(canvas)){;
//                        Canvas c=new Canvas();
//                        paint.setColor(Color.RED);
//                        paint.setTextSize(80);
//                        canvas.drawText("失败",500,80,paint);
                       System.out.println("jieshoudao");
                       setRunning(false);


                   }

                    //绘制最新游戏画面

                }
            } catch (Exception e) {} finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);  //解锁
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        canvas = null;

        try {
            canvas = this.surfaceHolder.lockCanvas();
                   //加锁
            synchronized(surfaceHolder) {this.gameView.drawd(canvas);}
        }catch (Exception e) {} finally {
            if (canvas != null) {
                try {
                    surfaceHolder.unlockCanvasAndPost(canvas);  //解锁
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }}

        }
    public void setRunning(boolean isRunning) {
        running = isRunning;
    }

}
