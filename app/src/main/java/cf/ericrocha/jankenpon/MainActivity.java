package cf.ericrocha.jankenpon;

import androidx.appcompat.app.AppCompatActivity;

//import androidx.appcompat.app.AlertDialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button bt_rock;
    private Button bt_paper;
    private Button bt_scissors;
    private ImageView img_player;
    private ImageView img_bot;
    private TextView tx_result;
    private TextView tx_pt_p;
    private TextView tx_pt_b;
    private int play_bot;
    private int play_player;
    private int pt_p;
    private int pt_b;
    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_rock =   findViewById(R.id.bt_rock);
        bt_paper = findViewById(R.id.bt_paper);
        bt_scissors = findViewById(R.id.bt_scissors);
        img_player = findViewById(R.id.img_player);
        img_bot = findViewById(R.id.img_bot);
        tx_result = findViewById(R.id.tx_result);
        tx_pt_p = findViewById(R.id.tx_pt_p);
        tx_pt_b = findViewById(R.id.tx_pt_b);
        pt_p = 0;
        pt_b = 0;
    }

    public void bot_play(View view){
        play_bot = new Random().nextInt(3);
        if(play_bot == 0){
            img_bot.setImageResource(R.drawable.rock_emoji_skin);
        }
        if(play_bot == 1){
            img_bot.setImageResource(R.drawable.paper_emoji_skin);
        }
        if(play_bot == 2){
            img_bot.setImageResource(R.drawable.scissors_emoji_skin);
        }
    }

    public void  bt_rock_click(View view){
        bot_play(view);
        play_player = 0;
        img_player.setImageResource(R.drawable.rock_emoji_skin);
        if(play_player == play_bot){
            tx_result.setText(getText(R.string.tx_result_0));
        }
        if(play_bot == 1){
            tx_result.setText(getText(R.string.tx_result_2));
            pt_b = pt_b + 1;
            String result = String.valueOf(pt_b);
            tx_pt_b.setText(result);
        }
        if(play_bot == 2){
            tx_result.setText(getText(R.string.tx_result_1));
            pt_p = pt_p + 1;
            String result = String.valueOf(pt_p);
            tx_pt_p.setText(result);
        }

        if(pt_p == 5 || pt_b == 5){
            end_match(view);
        }


    }
    public void  bt_paper_click(View view){
        bot_play(view);
        play_player = 1;
        img_player.setImageResource(R.drawable.paper_emoji_skin);
        if(play_player == play_bot){
            tx_result.setText(getText(R.string.tx_result_0));
        }
        if(play_bot == 2){
            tx_result.setText(getText(R.string.tx_result_2));
            pt_b = pt_b + 1;
            String result = String.valueOf(pt_b);
            tx_pt_b.setText(result);
        }
        if(play_bot == 0){
            tx_result.setText(getText(R.string.tx_result_1));
            pt_p = pt_p + 1;
            String result = String.valueOf(pt_p);
            tx_pt_p.setText(result);
        }
        if(pt_p == 5 || pt_b == 5){
            end_match(view);
        }
    }
    public void  bt_scissors_click(View view){
        bot_play(view);
        play_player = 2;
        img_player.setImageResource(R.drawable.scissors_emoji_skin);
        if(play_player == play_bot){
            tx_result.setText(getText(R.string.tx_result_0));
        }
        if(play_bot == 0){
            tx_result.setText(getText(R.string.tx_result_2));
            pt_b = pt_b + 1;
            String result = String.valueOf(pt_b);
            tx_pt_b.setText(result);
        }
        if(play_bot == 1){
            tx_result.setText(getText(R.string.tx_result_1));
            pt_p = pt_p + 1;
            String result = String.valueOf(pt_p);
            tx_pt_p.setText(result);
        }

        if(pt_p == 5 || pt_b == 5){
            end_match(view);
        }

    }

    public void end_match(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if(pt_p > pt_b){
            builder.setTitle(R.string.al_t_1);
            builder.setMessage(R.string.al_m_1);
        }
        if(pt_p < pt_b){
            builder.setTitle(R.string.al_t_2);
            builder.setMessage(R.string.al_m_2);
        }
        if(pt_b != 0 && pt_p !=0){
            if(pt_p == pt_b){
                builder.setTitle(R.string.al_t_0);
                builder.setMessage(R.string.al_m_0);
            }
        }

        builder.setPositiveButton(R.string.al_c, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                img_player.setImageResource(0);
                img_bot.setImageResource(0);
                pt_b = 0;
                tx_pt_b.setText(R.string.tx_df_pt);
                pt_p = 0;
                tx_pt_p.setText(R.string.tx_df_pt);
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                img_player.setImageResource(0);
                img_bot.setImageResource(0);
                pt_b = 0;
                tx_pt_b.setText(R.string.tx_df_pt);
                pt_p = 0;
                tx_pt_p.setText(R.string.tx_df_pt);
            }
        });
        if(pt_b != 0 || pt_p !=0){
            alert = builder.create();
            alert.show();
        }


    }

    public void  bt_clean_click(View view){
        end_match(view);

    }


}
