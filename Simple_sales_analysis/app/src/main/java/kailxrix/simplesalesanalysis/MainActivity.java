package kailxrix.simplesalesanalysis;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edit1, edit2, edit3, edit4;
    private TextView text1, text2, text3;
    private Button but1, but2;
    SharedPreferences planP_Pref, planP_Pref2, planR_Pref3, planF_Pref3, tex1_Pref, tex2_Pref, tex3_Pref;
    final String SAVED_TEXT1 = "saved_text1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        edit1 = findViewById(R.id.editTextNumber);
        edit2 = findViewById(R.id.editTextNumber2);
        edit3 = findViewById(R.id.editTextNumber3);
        edit4 = findViewById(R.id.editTextNumber4);
        text1 = findViewById(R.id.textView5);
        text2 = findViewById(R.id.textView8);
        text3 = findViewById(R.id.textView10);
        but1 = findViewById(R.id.button);
        loadText();
    }


    private void saveText()
    {
        planP_Pref = getSharedPreferences("planP_Pref1", MODE_PRIVATE);
        SharedPreferences.Editor ed = planP_Pref.edit();
        ed.putString(SAVED_TEXT1, edit1.getText().toString());
        ed.commit();

        planP_Pref2 = getSharedPreferences("planP_Pref2", MODE_PRIVATE);
        SharedPreferences.Editor es = planP_Pref2.edit();
        es.putString(SAVED_TEXT1, edit2.getText().toString());
        es.commit();

        planR_Pref3 = getSharedPreferences("planR_Pref3", MODE_PRIVATE);
        SharedPreferences.Editor ee = planR_Pref3.edit();
        ee.putString(SAVED_TEXT1, edit3.getText().toString());
        ee.commit();

        planF_Pref3 = getSharedPreferences("planF_Pref3", MODE_PRIVATE);
        SharedPreferences.Editor tt = planF_Pref3.edit();
        tt.putString(SAVED_TEXT1, edit4.getText().toString());
        tt.commit();



        tex1_Pref = getSharedPreferences("tex1_Pref", MODE_PRIVATE);
        SharedPreferences.Editor gg = tex1_Pref.edit();
        gg.putString(SAVED_TEXT1, text1.getText().toString());
        gg.commit();

        tex2_Pref = getSharedPreferences("tex2_Pref", MODE_PRIVATE);
        SharedPreferences.Editor rr = tex2_Pref.edit();
        rr.putString(SAVED_TEXT1, text2.getText().toString());
        rr.commit();

        tex3_Pref = getSharedPreferences("tex3_Pref", MODE_PRIVATE);
        SharedPreferences.Editor uu = tex3_Pref.edit();
        uu.putString(SAVED_TEXT1, text3.getText().toString());
        uu.commit();

    }





    private void loadText(){
        planP_Pref = getSharedPreferences("planP_Pref1", MODE_PRIVATE);
        String savedText = planP_Pref.getString(SAVED_TEXT1, "");
        edit1.setText(savedText);

        planP_Pref2 = getSharedPreferences("planP_Pref2", MODE_PRIVATE);
        String savedText2 = planP_Pref2.getString(SAVED_TEXT1, "");
        edit2.setText(savedText2);

        planR_Pref3 = getSharedPreferences("planR_Pref3", MODE_PRIVATE);
        String savedText3 = planR_Pref3.getString(SAVED_TEXT1, "");
        edit3.setText(savedText3);

        planF_Pref3 = getSharedPreferences("planF_Pref3", MODE_PRIVATE);
        String savedText4 = planF_Pref3.getString(SAVED_TEXT1, "");
        edit4.setText(savedText4);

        tex1_Pref = getSharedPreferences("tex1_Pref", MODE_PRIVATE);
        String savedText5 = tex1_Pref.getString(SAVED_TEXT1, "");
        text1.setText(savedText5);

        tex2_Pref = getSharedPreferences("tex2_Pref", MODE_PRIVATE);
        String savedText6 = tex2_Pref.getString(SAVED_TEXT1, "");
        text2.setText(savedText6);

        tex3_Pref = getSharedPreferences("tex3_Pref", MODE_PRIVATE);
        String savedText7 = tex3_Pref.getString(SAVED_TEXT1, "");
        text3.setText(savedText7);

    }





    public void clicbut1(View view) {
        // убрать клавиатуру
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);



        double ed1, ed2, ed3, ed4;
        double tv1, tv2, tv3;

        if (edit1.getText().toString().isEmpty()){
            edit1.setText("0");
        }
        if (edit2.getText().toString().isEmpty()){
            edit2.setText("0");
        }
        if (edit3.getText().toString().isEmpty()){
            edit3.setText("0");
        }
        if (edit4.getText().toString().isEmpty()){
            edit4.setText("0");
        }

        ed1 = Double.parseDouble(edit1.getText().toString());
        ed2 = Double.parseDouble(edit2.getText().toString());
        ed3 = Double.parseDouble(edit3.getText().toString());
        ed4 = Double.parseDouble(edit4.getText().toString());
        tv1 = ((ed2 / ed4) / (ed1 / ed3)) * 100;
        tv2 = (ed2/ed1) *100;
        tv3 = (ed1 - ed2) / (ed3 - ed4);

        tv1 = tv1 *10;
        int i1 = (int)Math.round(tv1);
        tv1 = (double)i1/10;
        text1.setText(Double.toString(tv1) + "%");

        tv2 = tv2 *10;
        int i3 = (int)Math.round(tv2);
        tv2 = (double)i3/10;
        text2.setText(Double.toString(tv2) + "%");

        int i2 = (int)Math.round(tv3);
        text3.setText(Integer.toString(i2));

    }

    public void but2(View view) {
        // убрать клавиатуру
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(getApplicationContext(),
                R.string.Toost,
                duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        saveText();

    }
}