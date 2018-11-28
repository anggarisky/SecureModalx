package com.example.anggarisky.securemodalx;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textLight, textMedium;
    EditText scOne, scTwo, scThree;
    Button btnPhone, btnVerify;
    ImageView icprotection;
    Animation iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = AnimationUtils.loadAnimation(this, R.anim.iv);

        textLight = (TextView) findViewById(R.id.textLight);
        textMedium = (TextView) findViewById(R.id.textMedium);

        icprotection = (ImageView) findViewById(R.id.icprotection);
        icprotection.setVisibility(View.GONE);

        scOne = (EditText) findViewById(R.id.scOne);
        scTwo = (EditText) findViewById(R.id.scTwo);
        scThree = (EditText) findViewById(R.id.scThree);

        btnPhone = (Button) findViewById(R.id.btnPhone);
        btnVerify = (Button) findViewById(R.id.btnVerify);

        Typeface lightx = Typeface.createFromAsset(getAssets(), "fonts/MontserratLight.ttf");
        Typeface mediumx = Typeface.createFromAsset(getAssets(), "fonts/MontserratMedium.ttf");

        textLight.setTypeface(lightx);
        textMedium.setTypeface(mediumx);

        scOne.setTypeface(mediumx);
        scTwo.setTypeface(mediumx);
        scThree.setTypeface(mediumx);

        btnVerify.setAlpha(0);
        btnVerify.setTranslationY(80);

        btnPhone.setTypeface(lightx);

        scThree.setOnEditorActionListener(new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    doValidate();
                    return false;
                } else {
                    return false;
                }
            }
        });


    }

    public void doValidate(){
        int answerx = 000;

        String onex = scOne.getText().toString();
        int finalOnex = Integer.parseInt(onex);

        String twox = scTwo.getText().toString();
        int finalTwox = Integer.parseInt(twox);

        String threex = scThree.getText().toString();
        int finalThreex = Integer.parseInt(threex);

        final int holderx = finalOnex + finalTwox + finalThreex;

        if (holderx == answerx) {

            icprotection.setVisibility(View.VISIBLE);

            icprotection.startAnimation(iv);

            scOne.animate().translationY(350).setDuration(600).start();
            scThree.animate().translationY(350).setDuration(600).start();
            scTwo.animate().translationY(350).setDuration(600).start();

            textLight.setText("The codes are good and correct.");
            textMedium.setText("Well Done");

            textLight.animate().translationY(500).setDuration(600).start();
            textMedium.animate().translationY(500).setDuration(600).start();

            btnPhone.animate().alpha(0).translationY(100).setDuration(600).setStartDelay(300).start();
            btnVerify.animate().alpha(1).translationY(0).setDuration(600).setStartDelay(300).start();
        }

    }

}












