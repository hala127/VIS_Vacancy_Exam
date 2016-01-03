package com.ntg.androidadministration.logicaltest_halafathymohamed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FibonancciNumberSeriesActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_get_fib;
    private EditText et_number;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonancci_number_series);

        setToolbarView();

        btn_get_fib = (Button) findViewById(R.id.btn_get_fib);
        et_number = (EditText) findViewById(R.id.et_number);
        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_get_fib.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get_fib:
                getFib(et_number.getText().toString());
                break;
        }
    }

    private int getFib(String numberString) {
        tv_result.setText(getString(R.string.result));
        int fib = 0;
        try {
            int number = Integer.parseInt(numberString);
            int prev1 = 0, prev2 = 1;
            int savePrev1 = 0;
            for (int i = 0; i < number; i++) {
                savePrev1 = prev1;
                prev1 = prev2;
                prev2 = savePrev1 + prev2;
                tv_result.append("\n" + getStringToBePrinted(prev1));
            }
            fib = prev1;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            tv_result.setText(getString(R.string.error));
        }

        return fib;
    }

    private String getStringToBePrinted(int numberToPrint) {
        String numString = "";

        if (numberToPrint % 5 != 0 && numberToPrint % 7 != 0)
            numString = numberToPrint + "";
        else {
            if (numberToPrint % 5 == 0)
                numString += getString(R.string.hello);
            if (numberToPrint % 7 == 0)
                numString += getString(R.string.world);
        }
        return numString;
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
