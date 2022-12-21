package space.students.luckyenglish;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Categories.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }
            }
        });

        //Кнопка для перехода - категория внешность
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Categories.this, CategoryAppearance.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }

            }
        });

        //Кнопка для перехода - категория город
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Categories.this, CategoryCity.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }

            }
        });

        //Кнопка для перехода - категория дом и быт
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Categories.this, CategoryHouse.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }

            }
        });

        //Кнопка для перехода - категория еда
        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Categories.this, CategoryFood.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }

            }
        });

        //Кнопка для перехода - категория животные
        TextView textView5 = (TextView)findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Categories.this, CategoryAnimals.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }

            }
        });

        //Кнопка для перехода - категория кухня
        TextView textView6 = (TextView)findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Categories.this, CategoryKitchen.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }

            }
        });

        //Кнопка для перехода - категория одежда
        TextView textView7 = (TextView)findViewById(R.id.textView7);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Categories.this, CategoryClothes.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }

            }
        });

        //Кнопка для перехода - категория погода
        TextView textView8 = (TextView)findViewById(R.id.textView8);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Categories.this, CategoryWeather.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }

            }
        });

        //Кнопка для перехода - категория профессии
        TextView textView9 = (TextView)findViewById(R.id.textView9);
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Categories.this, CategoryProfession.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }

            }
        });

        //Кнопка для перехода - категория спорт
        TextView textView10 = (TextView)findViewById(R.id.textView10);
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Categories.this, CategorySport.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }

            }
        });

        //Кнопка для перехода - категория характер
        TextView textView11 = (TextView)findViewById(R.id.textView11);
        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Categories.this, CategoryCharacter.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }

            }
        });




    }
    //Системная кнопка "Назад"
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(Categories.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e) {

        }
    }
}