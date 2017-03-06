# GBanner
#图片轮番控件

![image](https://github.com/GuoZhiHao9396/GBanner/blob/master/app/src/main/res/raw/test.gif)

AndroidStudio使用Gradle构建添加依赖（推荐）

Add it in your root build.gradle at the end of repositories:
```java
	 repositories {
            flatDir {
                dirs 'libs'
            }
     }

     dependencies {
         compile 'com.nineoldandroids:library:2.4.0'
         compile (name:'gbannerlibrary-v1.0.0',ext:'aar')
     }
```

#属性介绍

| 属性名 | 属性说明 | 属性值 |
| ------------ | ------------- | ------------ |
| isAutoPlay| 是否支持自动轮播 | boolean类型，默认为true |
| AutoPlayTime| 图片轮播时间间隔 | int值，默认为5s |
| pointNormal| 指示器未选中时状态点 | drawable，不设置的话为默认状态点 |
| pointSelect| 指示器选中时状态点 | drawable，不设置的话为默认状态点 |
| pointsVisibility| 是否显示指示器 | boolean类型，默认为true |
| pointsPosition| 指示点显示位置 | LEFT、CENTER、RIGHT类型，默认为CENTER |
| pointsContainerBackground| 指示器背景 | 可自定义设置指示器背景 |
| pointContainerPosition| 指示器显示位置 | TOP、BOTTOM类型，默认为BOTTOM |
| pointContainerLeftRightPadding| 指示点容器左右内间距 | dimension，默认为10dp |
| pointTopBottomPadding| 指示点上下内间距 | dimension，默认为6dp |
| pointLeftRightPadding| 指示点左右内间距 | dimension，默认为3dp |
| tipTextColor| 提示文案的文字颜色 | reference|color，默认为white |
| tipTextSize| 提示文案的文字大小| dimension，默认为10dp |
| isShowNumberIndicator| 是否显示数字指示器| boolean,默认为false不显示 |
| numberIndicatorBacgroud|数字指示器背景| reference |
| isShowIndicatorOnlyOne|当只有一张图片的时候是否显示指示点| boolean，默认为false，不显示 |
| pageChangeDuration|图片切换速度| int值，默认为1000ms |

#方法介绍

```java
      stopAutoPlay()：停止播放
      startAutoPlay()：开始播放
      getRealCount()：获取页面数量
      setmAdapter(mAdapter)：设置适配器
      setData(models,tips)：设置数据模型和文案
      setPageTransformer(transformer)：设置翻页动画效果
      setmAutoPlayAble(mAutoPlayAble)：设置是否自动轮播
      setPointsIsVisible(isVisible)：设置指示点是否可见
      setOnItemClickListener(listener)：设置Item的点击事件
      setmAutoPalyTime(mAutoPalyTime)：设置自动轮播时间间隔
      setPageChangeDuration(duration)：设置ViewPager切换速度
      setCustomPageTransformer(transformer)：自定义翻页动画效果
      setAllowUserScrollable(allowUserScrollable)：设置是否允许用户手指滑动
      setOnPageChangeListener(onPageChangeListener)：添加ViewPager滚动监听器
      setSlideScrollMode(slideScrollMode)：设置图片从最后一张滚动到第一张的动画效果
      setPoinstPosition(position)：设置指示器布局位置（对应位置 CENTER,RIGHT,LEFT）
      setmPointContainerPosition(position)：设置指示器容器的位置（对应位置 TOP,BOTTOM）
```

#使用介绍

1.在xml布局中添加相关属性
```xml
    <com.gzh.bannerlibrary.GBanner
        android:id="@+id/xbanner"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        gzh:pointSelect="@drawable/shape_selected"
        gzh:pointsContainerBackground="#84000000"
        gzh:tipTextSize="20sp"
        gzh:pointsPosition="RIGHT"
        gzh:pointNormal="@drawable/shape_noraml"
        gzh:isShowIndicatorOnlyOne="true"/>
```

2.在java代码中设置关键性方法
```java
     //绑定数据（第一个参数为图片数据集合；第二个参数为提示文字资源集合）
     mGBanner.setData(imgesUrl, titles);
     //设置适配器
     mGBanner.setmAdapter(new GBanner.XBannerAdapter() {
          @Override
          public void loadBanner(GBanner banner, Object model, View view, int position) {
              Glide.with(MainActivity.this).load(imgesUrl.get(position)).into((ImageView) view);
          }
     });
```
3.添加相关权限
```xml
   <uses-permission android:name="android.permission.INTERNET" />
```

#致谢

   [Mr.XIAO](https://github.com/xiaohaibin)

#License
```text
Copyright 2017 ZhiHao Guo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
