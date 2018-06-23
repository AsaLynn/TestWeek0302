package com.test.month3.week2.listener;

import android.app.Activity;

import com.example.demonstrate.DialogPage;
import com.test.month3.week2.R;
import com.test.month3.week2.activity.Test0Activity;
import com.test.month3.week2.activity.Test1Activity;

/**
 * Created by think on 2018/3/11.
 */

public class DialogPageListener0 implements DialogPage.OnDialogItemListener {


    private final Activity mActivity;

    public DialogPageListener0(Activity activity) {
        mActivity = activity;
    }

    @Override
    public Activity getActivity() {
        return mActivity;
    }

    @Override
    public String getTitle() {
//        return能硬件周考2列表1";
        return mActivity
                .getString(R.string.test3_name)
                .concat(mActivity.getString(R.string.week_num2))
                .concat(mActivity.getString(R.string.page_num1));
    }

    @Override
    public Class<?> getStartActivity(int which) {
        if (which == 0) {
            return Test0Activity.class;
        } else if (which == 1) {
            return Test1Activity.class;
        }
        return null;
    }
}
