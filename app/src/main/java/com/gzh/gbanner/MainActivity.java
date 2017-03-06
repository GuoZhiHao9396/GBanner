package com.gzh.gbanner;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gzh.bannerlibrary.GBanner;
import com.gzh.bannerlibrary.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MainActivity
 * @Description: 描述类的作用
 * @author: GZH
 */
public class MainActivity extends AppCompatActivity {
    GBanner mGBanner;
    RecyclerView mRecyclerView;
    NestedScrollView mNestedScrollView;
    List<String> imgesUrl;
    List<String> titles;
    String[] anims = {"Default", "Alpha", "Rotate", "Cube", "Flip", "Accordion", "ZoomFade", "ZoomCenter", "ZoomStack", "Stack", "Depth", "Zoom"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGBanner = (GBanner) findViewById(R.id.xbanner);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nv);
        //***设置NestedScrollView置顶***
        mNestedScrollView.smoothScrollTo(0, 0);
        //***是否启用NestedScrolling的滚动***
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(this, anims);
        mRecyclerView.setAdapter(myAdapter);
        //切换广告显示动画
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position) {
                Toast.makeText(MainActivity.this, anims[position], Toast.LENGTH_SHORT).show();
                changeAnim(position);
            }
        });
        //
        imgesUrl = new ArrayList<>();
        imgesUrl.add("https://cdn.pixabay.com/photo/2017/01/20/15/06/orange-1995056_960_720.jpg");
        imgesUrl.add("https://cdn.pixabay.com/photo/2017/02/02/14/04/grapes-2032838_960_720.jpg");
        imgesUrl.add("https://cdn.pixabay.com/photo/2017/01/10/19/05/watermelon-1969949_960_720.jpg");
        titles = new ArrayList<>();
        titles.add("橘子");
        titles.add("葡萄");
        titles.add("西瓜");
        //绑定数据
        mGBanner.setData(imgesUrl, titles);//（第一个参数为图片数据集合；第二个参数为提示文字资源集合）
        //设置适配器
        mGBanner.setmAdapter(new GBanner.XBannerAdapter() {
            @Override
            public void loadBanner(GBanner banner, Object model, View view, int position) {
                Glide.with(MainActivity.this).load(imgesUrl.get(position)).into((ImageView) view);
            }
        });
        //设置Item点击事件
        mGBanner.setOnItemClickListener(new GBanner.OnItemClickListener() {
            @Override
            public void onItemClick(GBanner banner, int position) {
                Toast.makeText(MainActivity.this, "第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //开始-自动轮播
        mGBanner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //停止-自动轮播
        mGBanner.stopAutoPlay();
    }

    /**
     * 切换动画
     *
     * @param position
     */
    private void changeAnim(int position) {
        switch (position) {
            case 0://默认切换动画
                mGBanner.setPageTransformer(Transformer.Default);
                break;
            case 1:
                mGBanner.setPageTransformer(Transformer.Alpha);
                break;
            case 2:
                mGBanner.setPageTransformer(Transformer.Rotate);
                break;
            case 3:
                mGBanner.setPageTransformer(Transformer.Cube);
                break;
            case 4:
                mGBanner.setPageTransformer(Transformer.Flip);
                break;
            case 5:
                mGBanner.setPageTransformer(Transformer.Accordion);
                break;
            case 6:
                mGBanner.setPageTransformer(Transformer.ZoomFade);
                break;
            case 7:
                mGBanner.setPageTransformer(Transformer.ZoomCenter);
                break;
            case 8:
                mGBanner.setPageTransformer(Transformer.ZoomStack);
                break;
            case 9:
                mGBanner.setPageTransformer(Transformer.Stack);
                break;
            case 10:
                mGBanner.setPageTransformer(Transformer.Depth);
                break;
            case 11:
                mGBanner.setPageTransformer(Transformer.Zoom);
                break;
        }
    }
}
