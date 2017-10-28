package my.edu.tarc.lab12bmi;

import android.icu.text.DecimalFormat;
import android.nfc.FormatException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText bodyHeightText;
    EditText bodyMassText;
    TextView textView;
    ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bodyHeightText = (EditText)findViewById(R.id.bodyHeight);
        bodyMassText=(EditText)findViewById(R.id.bodyMass);
        textView=(TextView)findViewById(R.id.textView);
        resultImage=(ImageView)findViewById(R.id.imageView);
    }
    public  void calculate(View v){
        java.text.DecimalFormat df=new java.text.DecimalFormat("0.##");
        try{
            double bodyMass;
            bodyMass=Double.parseDouble(bodyMassText.getText().toString());
            double bodyHeight;
            bodyHeight=Double.parseDouble(bodyHeightText.getText().toString());
            double result;
            result=bodyMass/(bodyHeight*bodyHeight);
            textView.setText(getResources().getString(R.string.result)+ df.format(result));
            if(result<=18.5){
                resultImage.setImageResource(R.drawable.under);
            }
            else if(result>18.5&&result<25){
                resultImage.setImageResource(R.drawable.normal);
            }
            else{
                resultImage.setImageResource(R.drawable.over);
            }
        }
        catch (Exception ex){
            Toast.makeText(this,"Please Enter number only",Toast.LENGTH_LONG).show();

        }



    }
    public void reset(View v){
        bodyHeightText.setText("");
        bodyMassText.setText("");
        textView.setText("");
        resultImage.setImageResource(R.drawable.empty);
    }
}
