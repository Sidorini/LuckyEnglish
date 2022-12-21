package space.students.luckyenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import java.util.Arrays;


public class CategoryAppearance extends AppCompatActivity {

    public int numLeft; //переменная для левой картинки
    public int numCentre; //переменная для центральной картинки
    public int numRight; //переменная для правой картинки
    Array array = new Array(); //создали новый объект из класса Array
    Random random = new Random(); //для генерации случайных чисел
    public int count = 0; //счетчик правильных ответов
    public int saveNum;


    Dialog dialog;
    Dialog dialogEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //Переменная text_categories
        TextView text_categories = findViewById(R.id.text_categories);
        text_categories.setText(R.string.category_appearance);

        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        //скругление углов левого изображения
        img_left.setClipToOutline(true);

        final ImageView img_centre = (ImageView) findViewById(R.id.img_centre);
        //скругление углов центрального изображения
        img_centre.setClipToOutline(true);

        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        //скругление углов правого изображения
        img_right.setClipToOutline(true);

        //путь к тексту в центре
        final TextView text_card = findViewById(R.id.text_card);

        //вызов диалогового окна в начале
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialog.setContentView(R.layout.previewdialog); //путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалогового окна
        dialog.setCancelable(false); //окно нельзя закрыть кнопкой назад

        //кнопка, которая закрывает диалоговое окно - начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обрабатываем нажатие кнопки - начало
                try{
                    //вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(CategoryAppearance.this, Categories.class);
                    startActivity(intent);
                    finish();
                    //вернуться назад к выбору уровня - конец

                }catch (Exception e){

                }
                dialog.dismiss(); //закрываем диалоговое окно
                //обрабатываем нажатие кнопки - конец
            }
        });
        //кнопка, которая закрывает диалоговое окно - конец

        //кнопка "продолжить" - начало
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss(); //закрываем диалоговое окно
            }
        });
        //кнопка "продолжить" - конец

        dialog.show(); //показать диалоговое окно

        //___________________________
        //вызов диалогового окна в конце
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); //скрываем заголовок
        dialogEnd.setContentView(R.layout.endingdialog); //путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); //прозрачный фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); //окно нельзя закрыть кнопкой назад

        //кнопка, которая закрывает диалоговое окно - начало
        TextView btnback = (TextView)dialogEnd.findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обрабатываем нажатие кнопки - начало
                try{
                    //вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(CategoryAppearance.this, Categories.class);
                    startActivity(intent);
                    finish();
                    //вернуться назад к выбору уровня - конец

                }catch (Exception e){

                }
                dialogEnd.dismiss(); //закрываем диалоговое окно
                //обрабатываем нажатие кнопки - конец
            }
        });
        //кнопка, которая закрывает диалоговое окно - конец


        //___________________________

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(CategoryAppearance.this, Categories.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }
            }
        });

        //массив для прогресса - начало
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };
        //массив для прогресса -конец

        //анимация - начало
        final Animation a = AnimationUtils.loadAnimation(CategoryAppearance.this, R.anim.alpha);

        //анимация - конец



        numLeft = random.nextInt(10);
        img_left.setImageResource(array.images1[numLeft]); //достаем из массива картинку

        numCentre = random.nextInt(10);
        while (numLeft==numCentre | numCentre==numRight){
            numCentre = random.nextInt(10);
        }
        img_centre.setImageResource(array.images1[numCentre]); //достаем из массива картинку

        numRight = random.nextInt(10);
        while (numCentre==numRight | numRight==numLeft) {
            numRight = random.nextInt(10);
        }
        img_right.setImageResource(array.images1[numRight]); //достаем из массива картинку



        if (numLeft<numCentre) {
            text_card.setText(array.texts1[numRight]);
            saveNum = 1;


        } else if (numCentre>numRight) {
            text_card.setText(array.texts1[numCentre]);
            saveNum = 2;


        } else {
            text_card.setText(array.texts1[numLeft]);
            saveNum = 3;


        }

        //обработка нажатия на левую картинку - начало
        img_left.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки - начало
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //если коснулся картинки - начало
                    img_centre.setEnabled(false);
                    img_right.setEnabled(false);
                    if (saveNum == 3) {
                        img_left.setImageResource(R.drawable.img_true);
                    }else {
                        img_left.setImageResource(R.drawable.img_false);
                    }

                }else if (event.getAction()==MotionEvent.ACTION_UP) {
                    //если отпустил палец - начало
                    if(saveNum == 3) {
                        if(count<20){
                            count=count+1;
                        }

                        //закрашиваем прогресс цветом - начало
                        for (int i=0; i<20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс цветом - конец

                        //определяем правильные ответы и закрашиваем зеленым - начало
                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_progress);
                        }
                        //определяем правильные ответы и закрашиваем зеленым - конец
                    }else{
                        if(count>0){
                            if(count==1){
                                count=0;

                            }else{
                                count=count-2;

                            }
                        }
                        //закрашиваем прогресс цветом - начало
                        for (int i=0; i<19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс цветом - конец

                        //определяем правильные ответы и закрашиваем зеленым - начало
                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_progress);
                        }
                        //определяем правильные ответы и закрашиваем зеленым - конец

                    }
                    //если отпустил палец - конец
                    if(count==20){
                        //выход из уровня
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(10);
                        img_left.setImageResource(array.images1[numLeft]); //достаем из массива картинку
                        img_left.startAnimation(a);

                        numCentre = random.nextInt(10);
                        while (numLeft==numCentre | numCentre==numRight){
                            numCentre = random.nextInt(10);
                        }
                        img_centre.setImageResource(array.images1[numCentre]); //достаем из массива картинку
                        img_centre.startAnimation(a);

                        numRight = random.nextInt(10);
                        while (numCentre==numRight | numRight==numLeft) {
                            numRight = random.nextInt(10);
                        }
                        img_right.setImageResource(array.images1[numRight]); //достаем из массива картинку
                        img_right.startAnimation(a);

                        if (numLeft<numCentre) {
                            text_card.setText(array.texts1[numRight]);
                            saveNum = 1;

                        } else if (numCentre>numRight) {
                            text_card.setText(array.texts1[numCentre]);
                            saveNum = 2;

                        } else {
                            text_card.setText(array.texts1[numLeft]);
                            saveNum = 3;

                        }

                        img_centre.setEnabled(true);
                        img_right.setEnabled(true);

                    }

                }
                //условие касания картинки - конец
                return true;
            }
        });
        //обработка нажатия на левую картинку - конец

        //обработка нажатия на центральную картинку - начало
        img_centre.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки - начало
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //если коснулся картинки - начало
                    img_left.setEnabled(false);
                    img_right.setEnabled(false);
                    if (saveNum == 2) {
                        img_centre.setImageResource(R.drawable.img_true);
                    }else {
                        img_centre.setImageResource(R.drawable.img_false);
                    }

                }else if (event.getAction()==MotionEvent.ACTION_UP) {
                    //если отпустил палец - начало
                    if(saveNum == 2) {
                        if(count<20){
                            count=count+1;
                        }

                        //закрашиваем прогресс цветом - начало
                        for (int i=0; i<20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс цветом - конец

                        //определяем правильные ответы и закрашиваем зеленым - начало
                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_progress);
                        }
                        //определяем правильные ответы и закрашиваем зеленым - конец
                    }else{
                        if(count>0){
                            if(count==1){
                                count=0;

                            }else{
                                count=count-2;

                            }
                        }
                        //закрашиваем прогресс цветом - начало
                        for (int i=0; i<19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс цветом - конец

                        //определяем правильные ответы и закрашиваем зеленым - начало
                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_progress);
                        }
                        //определяем правильные ответы и закрашиваем зеленым - конец

                    }
                    //если отпустил палец - конец
                    if(count==20){
                        //выход из уровня
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(10);
                        img_left.setImageResource(array.images1[numLeft]); //достаем из массива картинку
                        img_left.startAnimation(a);

                        numCentre = random.nextInt(10);
                        while (numLeft==numCentre | numCentre==numRight){
                            numCentre = random.nextInt(10);
                        }
                        img_centre.setImageResource(array.images1[numCentre]); //достаем из массива картинку
                        img_centre.startAnimation(a);

                        numRight = random.nextInt(10);
                        while (numCentre==numRight | numRight==numLeft) {
                            numRight = random.nextInt(10);
                        }
                        img_right.setImageResource(array.images1[numRight]); //достаем из массива картинку
                        img_right.startAnimation(a);

                        if (numLeft<numCentre) {
                            text_card.setText(array.texts1[numRight]);
                            saveNum = 1;

                        } else if (numCentre>numRight) {
                            text_card.setText(array.texts1[numCentre]);
                            saveNum = 2;

                        } else {
                            text_card.setText(array.texts1[numLeft]);
                            saveNum = 3;

                        }

                        img_left.setEnabled(true);
                        img_right.setEnabled(true);

                    }

                }
                //условие касания картинки - конец
                return true;
            }
        });
        //обработка нажатия на центральную картинку - конец

        //обработка нажатия на правую картинку - начало
        img_right.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки - начало
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //если коснулся картинки - начало
                    img_centre.setEnabled(false);
                    img_left.setEnabled(false);
                    if (saveNum == 1) {
                        img_right.setImageResource(R.drawable.img_true);
                    }else {
                        img_right.setImageResource(R.drawable.img_false);
                    }

                }else if (event.getAction()==MotionEvent.ACTION_UP) {
                    //если отпустил палец - начало
                    if(saveNum == 1) {
                        if(count<20){
                            count=count+1;
                        }

                        //закрашиваем прогресс цветом - начало
                        for (int i=0; i<20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс цветом - конец

                        //определяем правильные ответы и закрашиваем зеленым - начало
                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_progress);
                        }
                        //определяем правильные ответы и закрашиваем зеленым - конец
                    }else{
                        if(count>0){
                            if(count==1){
                                count=0;

                            }else{
                                count=count-2;

                            }
                        }
                        //закрашиваем прогресс цветом - начало
                        for (int i=0; i<19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс цветом - конец

                        //определяем правильные ответы и закрашиваем зеленым - начало
                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_progress);
                        }
                        //определяем правильные ответы и закрашиваем зеленым - конец

                    }
                    //если отпустил палец - конец
                    if(count==20){
                        //выход из уровня
                        dialogEnd.show();

                    }else{
                        numLeft = random.nextInt(10);
                        img_left.setImageResource(array.images1[numLeft]); //достаем из массива картинку
                        img_left.startAnimation(a);

                        numCentre = random.nextInt(10);
                        while (numLeft==numCentre | numCentre==numRight){
                            numCentre = random.nextInt(10);
                        }
                        img_centre.setImageResource(array.images1[numCentre]); //достаем из массива картинку
                        img_centre.startAnimation(a);

                        numRight = random.nextInt(10);
                        while (numCentre==numRight | numRight==numLeft) {
                            numRight = random.nextInt(10);
                        }
                        img_right.setImageResource(array.images1[numRight]); //достаем из массива картинку
                        img_right.startAnimation(a);

                        if (numLeft<numCentre) {
                            text_card.setText(array.texts1[numRight]);
                            saveNum = 1;

                        } else if (numCentre>numRight) {
                            text_card.setText(array.texts1[numCentre]);
                            saveNum = 2;

                        } else {
                            text_card.setText(array.texts1[numLeft]);
                            saveNum = 3;

                        }

                        img_centre.setEnabled(true);
                        img_left.setEnabled(true);

                    }

                }
                //условие касания картинки - конец
                return true;
            }
        });
        //обработка нажатия на правую картинку - конец

    }


    //Системная кнопка "Назад"
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(CategoryAppearance.this, Categories.class);
            startActivity(intent);finish();
        }catch (Exception e) {

        }
    }
    
}