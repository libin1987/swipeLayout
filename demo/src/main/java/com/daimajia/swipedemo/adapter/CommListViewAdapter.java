package com.daimajia.swipedemo.adapter;

import android.view.View;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.BaseCommSwipeAdapter;
import com.daimajia.swipedemo.R;
import com.simple.commonadapter.viewholders.GodViewHolder;

public class CommListViewAdapter<string> extends BaseCommSwipeAdapter<string> {

    public CommListViewAdapter() {
        super(R.layout.listview_item);
    }
    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    protected void onSwipeBindData(final GodViewHolder viewHolder, int position, string item) {
        SwipeLayout swipeLayout = (SwipeLayout) viewHolder.findViewById(getSwipeLayoutResourceId(position));
        swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.trash));
            }
        });
        swipeLayout.setOnDoubleClickListener(new SwipeLayout.DoubleClickListener() {
            @Override
            public void onDoubleClick(SwipeLayout layout, boolean surface) {
                Toast.makeText(viewHolder.getContext(), "DoubleClick", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(viewHolder.getContext(), "click delete", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
