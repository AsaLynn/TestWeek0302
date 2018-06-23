package com.test.month3.week2.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.test.month3.week2.R;
import com.test.month3.week2.fragment.MenuLeftFragment;

import java.util.ArrayList;
import java.util.List;

public class Test2Activity extends SlidingFragmentActivity {

    private List<Fragment> mFragments = new ArrayList<Fragment>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sliding_fragment);
        // 初始化SlideMenu
        initRightMenu();
    }


    private void initRightMenu() {
        Fragment leftMenuFragment = new MenuLeftFragment();
        setBehindContentView(R.layout.slidingmenulayout);
        /*getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_left_menu_frame, leftMenuFragment).commit();*/
        SlidingMenu menu = getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
//        menu.setShadowWidthRes(R.dimen.shadow_width);
//        menu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        // menu.setBehindScrollScale(1.0f);
//        menu.setSecondaryShadowDrawable(R.drawable.shadow);
        //设置右边（二级）侧滑菜单
//        menu.setSecondaryMenu(R.layout.right_menu_frame);
//        Fragment rightMenuFragment = new MenuRightFragment();
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.id_right_menu_frame, rightMenuFragment).commit();

    }

    public void showLeftMenu(View view) {
        getSlidingMenu().showMenu();
    }

    public void showRightMenu(View view) {
        getSlidingMenu().showSecondaryMenu();
    }
}
