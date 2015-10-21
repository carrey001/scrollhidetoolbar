package com.carrey.scrollhidetoolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.carrey.scrollhidetoolbar.adapter.partone.RecyclerAdapter;
import com.carrey.scrollhidetoolbar.listener.partone.HidingScrollListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：carrey
 * 创建时间：2015/10/21 15:15
 */

public class PartFourActivity extends AppCompatActivity {
    private TextView mToolbar;
    private ImageButton mFabButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_four);
        mToolbar = (TextView) findViewById(R.id.toolbar);
        mToolbar.setText(getString(R.string.app_name));
        mFabButton = (ImageButton) findViewById(R.id.fabButton);
        initRecyclerView();
    }
    private void initRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(createItemList());
        recyclerView.setAdapter(recyclerAdapter);

        recyclerView.addOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                hideViews();
            }

            @Override
            public void onShow() {
                showViews();
            }
        });
    }

    private void hideViews() {
        mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));

        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mFabButton.getLayoutParams();
        int fabBottomMargin = lp.bottomMargin;
        mFabButton.animate().translationY(mFabButton.getHeight()+fabBottomMargin).setInterpolator(new AccelerateInterpolator(2)).start();
    }

    private void showViews() {
        mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
        mFabButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
    }

    private List<String> createItemList() {
        List<String> itemList = new ArrayList<>();
        for(int i=0;i<20;i++) {
            itemList.add("Item "+i);
        }
        return itemList;
    }
}
