package com.test.month3.week2.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.demonstrate.DemonstrateUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.test.month3.week2.R;
import com.xadapter.OnItemClickListener;
import com.xadapter.OnXBindListener;
import com.xadapter.adapter.XRecyclerViewAdapter;
import com.xadapter.holder.XViewHolder;

import java.util.ArrayList;

public class Test0Activity extends AppCompatActivity {

    protected RecyclerView menuRv;
    protected LinearLayout bottomLl;
    private SlidingMenu mSlidingMenu;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_test0);

        //初始化顶部标题部分
        initToolbar();

        //设置状态栏透明
//        initTranslucentStatus();

        //加载侧滑菜单界面
        initSlidingMenu();
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // App Logo
//        mToolbar.setLogo(R.drawable.ic_menu_dark);
        // 主标题,默认为app_label的名字
//        mToolbar.setTitle("Title");
//        mToolbar.setTitleTextColor(Color.YELLOW);
        // 副标题
//        mToolbar.setSubtitle("Sub title");
//        mToolbar.setSubtitleTextColor(Color.parseColor("#80ff0000"));
        //侧边栏的按钮
        mToolbar.setNavigationIcon(R.drawable.ic_menu_dark);
        //取代原本的actionbar
        setSupportActionBar(mToolbar);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("");
        //设置NavigationIcon的点击事件,需要放在setSupportActionBar之后设置才会生效,
        //因为setSupportActionBar里面也会setNavigationOnClickListener
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DemonstrateUtil.showToastResult(Test0Activity.this, "左侧菜单!");
                /*if (mSlidingMenu.isMenuShowing()) {
                    mSlidingMenu.toggle();
                }else {
                    mSlidingMenu.showMenu();
                }*/
                mSlidingMenu.toggle();
            }
        });
        //设置toolBar上的MenuItem点击事件
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_box:
                        DemonstrateUtil.showToastResult(Test0Activity.this, "活动中心");
                        break;
//                    case R.id.action_overflow:
//                        //弹出自定义overflow
//                        popUpMyOverflow();
//                        return true;
                }

                return true;
            }
        });
    }

    private void initSlidingMenu() {
        mSlidingMenu = new SlidingMenu(this);

        //设置从左弹出/滑出SlidingMenu
        mSlidingMenu.setMode(SlidingMenu.LEFT);

        //设置触摸屏幕的模式,可选只MARGIN , CONTENT
        // TOUCHMODE_FULLSCREEN-->全屏触摸
        // TOUCHMODE_MARGIN-->边界触摸
        // TOUCHMODE_NONE-->任何位置不可触摸
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

        //绑定到哪一个Activity对象,添加到activity
        mSlidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);

        //设置弹出的SlidingMenu的布局文件
        mSlidingMenu.setMenu(R.layout.slidingmenulayout);

        //SlidingMenu设置菜单弹出后距离屏幕右侧距离
        //SlidingMenu设置菜单弹出后占居屏幕宽度大小的方法?
//        mSlidingMenu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
        mSlidingMenu.setBehindOffset(250);

        //设置滑动时菜单是否淡入淡出
        mSlidingMenu.setFadeEnabled(false);

        //设置淡入淡出的比例
        mSlidingMenu.setFadeDegree(0.5f);

        //设置滑动时拖拽效果:即slidingmenu的遮盖滑出效果
        mSlidingMenu.setBehindScrollScale(0);

        bottomLl = (LinearLayout) findViewById(R.id.bottom_ll);
        menuRv = (RecyclerView) findViewById(R.id.menu_rv);
        menuRv.setLayoutManager(new LinearLayoutManager(this) {
            {
                this.setOrientation(LinearLayoutManager.VERTICAL);
            }
        });
//        menuRv.setLayoutManager(new LinearLayoutManager(this));
        menuRv.setHasFixedSize(true);

        XRecyclerViewAdapter<String> xRecyclerViewAdapter = new XRecyclerViewAdapter<>();
        View view
                = LayoutInflater
                .from(this)
                .inflate(R.layout.layout_left_menu_header, (ViewGroup) findViewById(R.id.userLoginOutView), false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DemonstrateUtil.showToastResult(v.getContext(), "立即登录!");
            }
        });
        xRecyclerViewAdapter
                .setLayoutId(R.layout.item_left_menu)
                .addHeaderView(view)
                .onXBind(new OnXBindListener<String>() {
                    @Override
                    public void onXBind(XViewHolder holder, int position, String s) {
                        holder.setTextView(R.id.name_tv, s);
                        holder.getImageView(R.id.icon_iv)
                                .setImageResource(ivIds[position]);
                        if (position == 1) {
                            holder.getImageView(R.id.icon_iv2).setVisibility(View.VISIBLE);
                        } else {
                            holder.getImageView(R.id.icon_iv2).setVisibility(View.INVISIBLE);
                        }
                    }
                }).setOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(View view, int position, String info) {
                DemonstrateUtil.showToastResult(view.getContext(), info);
            }
        });

        menuRv.setAdapter(xRecyclerViewAdapter);
        ArrayList<String> data = new ArrayList<>();
        data.add("订单记录");
        data.add("我的钱包");
        data.add("收件信箱");
        data.add("邀请有奖");
        data.add("我的司机");
        data.add("客服中心");
        data.add("更多设置");
        xRecyclerViewAdapter.addAllData(data);
    }

    private void initTranslucentStatus() {

        //4.4 全透明状态栏（有的机子是过渡形式的透明）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        //5.0 全透明实现
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);// calculateStatusColor(Color.WHITE, (int) alphaValue)
        }
    }

    private int[] ivIds = {
            R.drawable.ic_orderrecord,
            R.drawable.ic_iwallet,
            R.drawable.ic_inbox_off,
            R.drawable.ic_recommend,
            R.drawable.ic_mydriver,
            R.drawable.ic_servicecenter,
            R.drawable.ic_set,
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test0, menu);
        menu.findItem(R.id.action_box).setVisible(true);
        return true;
    }

}
