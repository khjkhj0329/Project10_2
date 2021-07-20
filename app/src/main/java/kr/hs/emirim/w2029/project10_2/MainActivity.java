package kr.hs.emirim.w2029.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgNames = {"MAK1", "MAK2", "MAK3", "MAK4","MAK5", "MAK6", "MAK7", "MAK8", "MAK9"};
    int[] imgVIds = {R.id.img01, R.id.img02,R.id.img03,R.id.img04,R.id.img05,R.id.img06,R.id.img07,R.id.img08,R.id.img09};
    int[] voteCount = new int[imgVIds.length];
    ImageView[] image = new ImageView[imgVIds.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.title);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < imgVIds.length; i++){
            final int index;
            index = i;
            image[index] = findViewById(imgVIds[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgNames[index] + "총" + voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnFinish = findViewById(R.id.btn_done);
        btnFinish.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("voteCount", voteCount);
            intent.putExtra("imgNames", imgNames);
            startActivity(intent);
        }
    };
}