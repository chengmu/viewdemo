package com.chengmu.viewdemo;

import android.widget.Toast;
import android.content.Context;
import android.view.Gravity;

/**
 * Created by chengmu on 14-7-17.
 */
public class MyObj {

    Context mContext;

    MyObj(Context c)
    {
        mContext = c;
    }

    public void showToast(String name)
    {

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(mContext, name + ", 你好！", duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
}
