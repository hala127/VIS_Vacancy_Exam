package com.ntg.androidadministration.logicaltest_halafathymohamed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PascalLineActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_print_pascal_line;
    private EditText et_number;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pascal_line);

        setToolbarView();

        btn_print_pascal_line = (Button) findViewById(R.id.btn_print_pascal_line);
        et_number = (EditText) findViewById(R.id.et_number);
        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_print_pascal_line.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_print_pascal_line:
                printPascalLine(et_number.getText().toString());
                break;
        }
    }

    private void printPascalLine(String numberString) {
        tv_result.setText(getString(R.string.result) + "\n");
        try {
            int line = Integer.parseInt(numberString);
            int num = 1;

            for (int i = 0; i <= line; i++) {
                tv_result.append(" " + num + "");
                num = num * (line - i) / (i + 1);
            }

        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            tv_result.setText(getString(R.string.error));
        }

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

