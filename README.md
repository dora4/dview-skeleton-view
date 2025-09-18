dview-skeleton-view
![Release](https://jitpack.io/v/dora4/dview-skeleton-view.svg)
--------------------------------

#### 运行效果
![骨架屏加载](https://github.com/user-attachments/assets/de6ddb0e-f8a8-4816-84ae-389a5f65ab97)

#### 卡片
![DORA视图 视图法王的遗骸](https://github.com/user-attachments/assets/e34cfbf2-4764-463f-95e2-0aec29409ee4)
![DORA视图 视图法王](https://github.com/user-attachments/assets/2d32c589-0a10-4655-a982-653b2d77f9f7)

#### 规范标准
此控件遵循《Dora View规范手册》 https://github.com/dora4/dview-template/blob/main/Naming_Convention_Guide.md

#### Gradle依赖配置

```groovy
// 添加以下代码到项目根目录下的build.gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
// 添加以下代码到app模块的build.gradle
dependencies {
    implementation 'com.github.dora4:dview-skeleton-view:1.0'
}
```

#### 使用方式
layout_skeleton_content.xml
```xml
<?xml version="1.0" encoding="utf-8"?>

<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <dora.widget.DoraCircleImageView
            android:id="@+id/civ1"
            android:layout_width="60dp"
            android:layout_height="60dp"/>

        <dora.widget.DoraCircleImageView
            android:id="@+id/civ2"
            android:layout_width="60dp"
            android:layout_height="60dp"
            android:layout_marginStart="10dp"/>

        <dora.widget.DoraCircleImageView
            android:id="@+id/civ3"
            android:layout_width="60dp"
            android:layout_height="60dp"
            android:layout_marginStart="10dp"/>

        <dora.widget.DoraCircleImageView
            android:id="@+id/civ4"
            android:layout_width="60dp"
            android:layout_height="60dp"
            android:layout_marginStart="10dp"/>
    </LinearLayout>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        style="@style/ThemeTextNormal"
        android:text="苹果经典配色包括黑色、白色、粉色、紫色、银色、深空灰和金色等，这些低饱和度的金属色调搭配极简设计，传达出简洁与高级感，成为科技产品中极具代表性的视觉符号。这里的配色不代表苹果真实配色，仅供参考"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        style="@style/ThemeTextNormal"
        android:text="在产品迭代中，苹果不断加入新的配色，如午夜蓝和远峰蓝，保持视觉新鲜感的同时，也凸显年轻与时尚气息，形成了极具辨识度的产品风格。"/>


    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        style="@style/ThemeTextNormal"
        android:text="苹果产品的配色不仅是外观选择，更是一种情绪表达，银色代表纯粹与未来感，金色强调优雅与奢华，深空灰则凸显专业与冷静，满足多样化的用户需求。"/>
</LinearLayout>
```
activity_skeleton_view.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context=".ui.SkeletonViewActivity">

    <data>

    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/colorPanelBg"
        android:orientation="vertical">

        <dora.widget.DoraTitleBar
            android:id="@+id/titleBar"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:background="@color/colorPrimary"
            app:dview_title="@string/common_title" />

        <ViewStub
            android:id="@+id/content"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:inflatedId="@+id/skeletonLayout"
            android:layout="@layout/layout_skeleton_content" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:padding="16dp">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal">

                <!-- 圆形骨架 -->
                <dora.widget.DoraSkeletonView
                    android:id="@+id/skeletonCircle"
                    android:layout_width="60dp"
                    android:layout_height="60dp"
                    app:dview_sv_animDuration="2000"
                    app:dview_sv_primaryColor="@color/light_gray"
                    app:dview_sv_secondaryColor="@color/white"
                    app:dview_sv_shapeType="circle"
                    app:dview_sv_shimmer="true" />

                <dora.widget.DoraSkeletonView
                    android:id="@+id/skeletonCircle2"
                    android:layout_width="60dp"
                    android:layout_height="60dp"
                    android:layout_marginStart="10dp"
                    app:dview_sv_animDuration="2000"
                    app:dview_sv_primaryColor="@color/light_gray"
                    app:dview_sv_secondaryColor="@color/white"
                    app:dview_sv_shapeType="circle"
                    app:dview_sv_shimmer="true" />

                <dora.widget.DoraSkeletonView
                    android:id="@+id/skeletonCircle3"
                    android:layout_width="60dp"
                    android:layout_height="60dp"
                    android:layout_marginStart="10dp"
                    app:dview_sv_animDuration="2000"
                    app:dview_sv_primaryColor="@color/light_gray"
                    app:dview_sv_secondaryColor="@color/white"
                    app:dview_sv_shapeType="circle"
                    app:dview_sv_shimmer="true" />

                <dora.widget.DoraSkeletonView
                    android:id="@+id/skeletonCircle4"
                    android:layout_width="60dp"
                    android:layout_height="60dp"
                    android:layout_marginStart="10dp"
                    app:dview_sv_animDuration="2000"
                    app:dview_sv_primaryColor="@color/light_gray"
                    app:dview_sv_secondaryColor="@color/white"
                    app:dview_sv_shapeType="circle"
                    app:dview_sv_shimmer="true" />
            </LinearLayout>

            <!-- 矩形骨架 -->
            <dora.widget.DoraSkeletonView
                android:id="@+id/skeletonRect"
                android:layout_width="match_parent"
                android:layout_height="100dp"
                android:layout_marginTop="10dp"
                app:dview_sv_animDuration="1500"
                app:dview_sv_cornerRadius="16dp"
                app:dview_sv_primaryColor="@color/light_gray"
                app:dview_sv_secondaryColor="@color/white"
                app:dview_sv_shapeType="rectangle"
                app:dview_sv_shimmer="true" />

            <dora.widget.DoraSkeletonView
                android:id="@+id/skeletonRect2"
                android:layout_width="match_parent"
                android:layout_height="40dp"
                android:layout_marginTop="10dp"
                app:dview_sv_animDuration="1500"
                app:dview_sv_cornerRadius="16dp"
                app:dview_sv_primaryColor="@color/light_gray"
                app:dview_sv_secondaryColor="@color/white"
                app:dview_sv_shapeType="rectangle"
                app:dview_sv_shimmer="true" />

            <dora.widget.DoraSkeletonView
                android:id="@+id/skeletonRect3"
                android:layout_width="match_parent"
                android:layout_height="40dp"
                android:layout_marginTop="10dp"
                app:dview_sv_animDuration="1500"
                app:dview_sv_cornerRadius="16dp"
                app:dview_sv_primaryColor="@color/light_gray"
                app:dview_sv_secondaryColor="@color/white"
                app:dview_sv_shapeType="rectangle"
                app:dview_sv_shimmer="true" />
        </LinearLayout>

    </LinearLayout>

</layout>
```
Kotlin代码。
```kt
Handler(Looper.getMainLooper()).postDelayed({
            // 1. inflate 正文内容
            val inflated = binding.content.viewStub?.inflate()
            inflated?.apply {
                // 2. 设置圆形图片
                findViewById<DoraCircleImageView>(R.id.civ1)
                    .setImageResource(R.drawable.shape_circle_card1)
                findViewById<DoraCircleImageView>(R.id.civ2)
                    .setImageResource(R.drawable.shape_circle_card2)
                findViewById<DoraCircleImageView>(R.id.civ3)
                    .setImageResource(R.drawable.shape_circle_card3)
                findViewById<DoraCircleImageView>(R.id.civ4)
                    .setImageResource(R.drawable.shape_circle_card4)
            }
            // 3. 隐藏骨架屏
            binding.skeletonCircle.visibility = View.GONE
            binding.skeletonCircle2.visibility = View.GONE
            binding.skeletonCircle3.visibility = View.GONE
            binding.skeletonCircle4.visibility = View.GONE
            binding.skeletonRect.visibility = View.GONE
            binding.skeletonRect2.visibility = View.GONE
            binding.skeletonRect3.visibility = View.GONE
        }, 1000)
```
