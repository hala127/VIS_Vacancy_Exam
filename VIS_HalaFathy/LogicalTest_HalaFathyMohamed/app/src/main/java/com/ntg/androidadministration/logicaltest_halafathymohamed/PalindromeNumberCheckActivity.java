package com.ntg.androidadministration.logicaltest_halafathymohamed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PalindromeNumberCheckActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_check;
    private EditText et_number;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome_number_check);
        setToolbarView();

        btn_check = (Button) findViewById(R.id.btn_check);
        et_number = (EditText) findViewById(R.id.et_number);
        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_check.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_check:
                isPalindrome(et_number.getText().toString());
                break;
        }
    }

    private boolean isPalindrome(String numberString) {
        boolean isNumberPalindrome = false;

        tv_result.setText(getString(R.string.result));
        try {
            int number = Integer.parseInt(numberString);
            int numberTemp = number;
            int reverse = 0;

            while (numberTemp != 0) {
                int remainder = numberTemp % 10;
                reverse = reverse * 10 + remainder;
                numberTemp = numberTemp / 10;
            }

            if (number == reverse) {
                tv_result.setText(getString(R.string.palindrome));
                isNumberPalindrome = true;
            } else {
                tv_result.setText(getString(R.string.not_palindrome));
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            tv_result.setText(getString(R.string.error));
        }


        return isNumberPalindrome;
    }

    private void setToolbarView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                // NavUtils.navigateUpFromSameTask(this);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
