package com.example.shop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shop.service.NetworkService;
import com.example.shop.service.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private float oneNumber;
    private float twoNumber;

    private Character operation;
    private String tmpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.txtResult);
        result.setText("");
    }

    public void onClickBtnNum(View view) {
        Button button = (Button) view;
        String text = result.getText().toString();
        result.setText(text + button.getText());

    }

    public void onClickBtnClear(View view) {
        result.setText("");
    }

    public void onClickBtnBack(View view) {
        String text = result.getText().toString();
        text = text.substring(0, text.length() - 1);

        result.setText(text);
    }

    public void onClickBtnZero(View view) {
        String text = result.getText().toString();
        result.setText(text + "0");
    }

    public void onClickBtnDot(View view) {
        String text = result.getText().toString();

        if (text.length() == 0)
        {
            result.setText("0.");
        }
        else {
            result.setText(text + ".");
        }
    }

    public void onClickBtnOperation(View view) {
        Button button = (Button) view;
        String text = result.getText().toString();
        oneNumber = Float.parseFloat(result.getText().toString());

        switch (button.getText().toString()) {
            case "+":
                operation = '+';
                break;
            case "-":
                operation = '-';
                break;
            case "*":
                operation = '*';
                break;
            case "/":
                operation = '/';
                break;
            default:
                break;
        }
        result.setText("");
    }

    public void onClickBtnCalculate(View view) {
        String text = result.getText().toString();
        float tmpRes;
        twoNumber = Float.parseFloat(text);

        switch (operation) {
            case '+':
                tmpRes = oneNumber + twoNumber;
                result.setText(Float.toString(oneNumber) + " + " + Float.toString(twoNumber) + " = " + Float.toString(tmpRes));
                break;
            case '-':
                tmpRes = oneNumber - twoNumber;
                result.setText(Float.toString(oneNumber) + " - " + Float.toString(twoNumber) + " = " + Float.toString(tmpRes));
                break;
            case '*':
                tmpRes = oneNumber * twoNumber;
                result.setText(Float.toString(oneNumber) + " * " + Float.toString(twoNumber) + " = " + Float.toString(tmpRes));
                break;
            case '/':
                tmpRes = oneNumber / twoNumber;
                result.setText(Float.toString(oneNumber) + " / " + Float.toString(twoNumber) + " = " + Float.toString(tmpRes));
                break;
            default:
                break;
        }
    }
}