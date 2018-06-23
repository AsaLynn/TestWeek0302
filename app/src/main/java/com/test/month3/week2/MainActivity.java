package com.test.month3.week2;

import com.example.demonstrate.DialogPage;
import com.example.demonstrate.FirstActivity;
import com.test.month3.week2.listener.DialogPageListener0;

public class MainActivity extends FirstActivity {


    @Override
    protected void click0() {
        DialogPage
                .getInstance()
                .setOnOnDialogItemListener(new DialogPageListener0(this));
    }
}
