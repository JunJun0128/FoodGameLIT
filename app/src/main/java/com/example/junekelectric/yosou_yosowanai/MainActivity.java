package com.example.junekelectric.yosou_yosowanai;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends ActionBarActivity {
    String[] name;
    String[] number;
    String[] people = {"あべちゃん", "まっすー", "狼", "みーたん"};
    String[] food = {"カレー", "ラーメン", "チャーハン", "肉料理", "狩りたての動物", "おにぎり", "焼き魚", "タコさん", "味噌汁", "野菜炒め"};
    String[] DidDidnt = {"よそえました(^^)", "よそえませんでした…（ ;  ; ）"};

    int[] foodID = {
            R.drawable.curry,
            R.drawable.ramen,
            R.drawable.chahan,
            R.drawable.meat,
            R.drawable.esa,
            R.drawable.onigiri,
            R.drawable.fish,
            R.drawable.takosan,
            R.drawable.miso,
            R.drawable.vegi
    };

    ImageView[] image;

    TextView nameTextView;
    TextView foodTextView;
    TextView verbTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        foodTextView = (TextView) findViewById(R.id.foodTextView);
        verbTextView = (TextView) findViewById(R.id.verbTextView);

        image = new ImageView[]{
                (ImageView) findViewById(R.id.imageView5),
                (ImageView) findViewById(R.id.imageView6),
                (ImageView) findViewById(R.id.imageView7),
                (ImageView) findViewById(R.id.imageView8)};


        nameTextView.setTextSize(15);

    }

    public void serveFood(View v) {
        Random randomName = new Random();
        int index = randomName.nextInt(4);
        String name = people[index];
        nameTextView.setText(name + "に");

        Random randomFood = new Random();
        foodTextView.setText(food[randomFood.nextInt(10)] + "を");

        Random random = new Random();
        if (random.nextInt(100) < 50) {
            verbTextView.setText("よそえました(^^)");
            verbTextView.setTextColor(Color.rgb(255, 204, 0));
            verbTextView.setTextSize(10);
        } else {
            verbTextView.setText("よそえませんでした…（ ;  ; ）");
            verbTextView.setTextColor(Color.rgb(51, 204, 153));
            verbTextView.setTextSize(20);
        }
    }

    public void serveAllFood(View v) {


        Random random = new Random();
        int foodran = random.nextInt(10);
        int imgran = foodran;
        int nameran = foodran;

        Log.d("foodran", String.valueOf(foodran));
        Log.d("imgran", String.valueOf(imgran));


        while (foodran != 0) {
            foodran = random.nextInt(10);
        }

        for (int i = 0; i < 4; i++) {

            image[i].setImageResource(foodID[imgran]);

            nameTextView.setText("あべちゃん、まっすー、狼、みーたんに");
            foodTextView.setText(food[nameran] + "を");

            Random randomall = new Random();
            if (randomall.nextInt(100) < 50) {
                verbTextView.setText("みなさん〜よそえましたよ(^^)どうぞめしあがれぇぇぇぇ");
            } else {
                verbTextView.setText("あらみなさん、す、すみません、ぐ、具材が、あ、ぁぁぁ…");
            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}