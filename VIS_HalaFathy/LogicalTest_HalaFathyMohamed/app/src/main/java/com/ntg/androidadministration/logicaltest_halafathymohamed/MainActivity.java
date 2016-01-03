package com.ntg.androidadministration.logicaltest_halafathymohamed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_start_fib_test;
    private Button btn_start_palindrome_test;
    private Button btn_start_pascal_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start_fib_test = (Button) findViewById(R.id.btn_start_fib_test);
        btn_start_palindrome_test = (Button) findViewById(R.id.btn_start_palindrome_test);
        btn_start_pascal_test = (Button) findViewById(R.id.btn_start_pascal_test);

        btn_start_palindrome_test.setOnClickListener(this);
        btn_start_fib_test.setOnClickListener(this);
        btn_start_pascal_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_fib_test:
                startActivity(new Intent(this, FibonancciNumberSeriesActivity.class));
                break;
            case R.id.btn_start_palindrome_test:
                startActivity(new Intent(this, PalindromeNumberCheckActivity.class));
                break;
            case R.id.btn_start_pascal_test:
                startActivity(new Intent(this, PascalLineActivity.class));
                break;
        }
    }
}
