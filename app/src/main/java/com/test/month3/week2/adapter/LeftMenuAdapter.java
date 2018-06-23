package com.test.month3.week2.adapter;

import com.test.month3.week2.R;
import com.xadapter.OnXBindListener;
import com.xadapter.adapter.XRecyclerViewAdapter;
import com.xadapter.holder.XViewHolder;

/**
 * Created by think on 2018/3/12.
 */

public class LeftMenuAdapter extends XRecyclerViewAdapter<String> {

    public LeftMenuAdapter() {
//        this.initXData(new ArrayList<String>() {
//            {
//                this.add("订单记录");
//                this.add("我的钱包");
//                this.add("收件信箱");
//                this.add("邀请有奖");
//                this.add("我的司机");
//                this.add("客服中心");
//                this.add("更多设置");
//            }
//        })
        this.setLayoutId(R.layout.item_left_menu)
//                    .addHeaderView(null)
                .onXBind(new OnXBindListener<String>() {
                    @Override
                    public void onXBind(XViewHolder holder, int position, String s) {
                        holder.setTextView(R.id.name_tv, s);
                    }
                });

    }

}
