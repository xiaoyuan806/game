package experiment3.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    GameView gm;
    MainThread mt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        gm=new GameView(this);
        mt=new MainThread();
        setContentView(gm);

        gm.setOnTouchListener(shoushi);
    }
    View.OnTouchListener shoushi=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(!gm.thread.running){
                System.out.println("restart");
                gm.characterSprite.x=10;
                gm.characterSprite.y=50;
                gm.ball.x=  gm.ball.screenHeight+500;
                gm.ball.y = 200;
                gm.thread.setRunning(true);
                gm.thread.run();
                System.out.println(
                        gm.thread.running
                );
                System.out.println( gm.characterSprite.x+" "+ gm.ball.x);

            }
           if(gm.thread.running){
               switch (motionEvent.getAction()){
                   case MotionEvent.ACTION_DOWN:
                       gm.shang();


               };
          }

            return true;
        }
    };



}
