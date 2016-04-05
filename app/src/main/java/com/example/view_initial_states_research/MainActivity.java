package com.example.view_initial_states_research;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.view_initial_states_research.widget.SimplestCustomView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final Class[] viewTypeClazzs = new Class[] {
            Button.class,
            TextView.class,
            EditText.class,
            ImageView.class,
            LinearLayout.class,
            RelativeLayout.class,
            FrameLayout.class,
            ListView.class,
            GridView.class,
            ViewPager.class,
            RecyclerView.class,
            SimplestCustomView.class,
    };

    private List<View> views = new LinkedList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            createViews();

            printEnabled();
            printClickable();
            printLongClickable();
            printFocusable();
            printFocusableInTouchMode();
            printFocused();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建各个常用的控件, 并将每一个创建出来的控件实例加入到 views 这个List中.
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private void createViews() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (Class clazz : viewTypeClazzs) {
            createView(clazz);
        }
    }

    /**
     * 根据给定的控件 T 的字节码实例, 按照 T(Context) 这个构造函数来创建控件 T 的一个实例.
     * @param viewClazz
     * @param <T> 控件的类型
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    @NonNull
    private <T extends View> T createView(Class<T> viewClazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<T> constructor = viewClazz.getConstructor(Context.class);
        T t = constructor.newInstance(MainActivity.this);
        views.add(t);
        return t;
    }

    /**
     * 打印各个控件默认的 enabled 状态.
     * @param <T> 控件的类型
     */
    private <T extends View> void printEnabled() {
        Log.d(TAG, "/*-------------- enabled  -------------------------*/");
        for (View v : views) {
            Log.d(TAG, getFormattedClassName(v) + " enabled = " + v.isEnabled());
        }
        Log.d(TAG, " ");
    }

    /**
     * 打印各个控件默认的 clickable 状态.
     * @param <T> 控件的类型
     */
    private <T extends View> void printClickable() {
        Log.d(TAG, "/*-------------- clickable  -------------------------*/");
        for (View v : views) {
            Log.d(TAG, getFormattedClassName(v) + " clickable = " + v.isClickable());
        }
        Log.d(TAG, " ");
    }

    /**
     * 打印各个控件默认的 longClickable 状态.
     * @param <T> 控件的类型
     */
    private <T extends View> void printLongClickable() {
        Log.d(TAG, "/*-------------- longClickable  -------------------------*/");
        for (View v : views) {
            Log.d(TAG, getFormattedClassName(v) + " clickable = " + v.isLongClickable());
        }
        Log.d(TAG, " ");
    }

    /**
     * 打印各个控件默认的 focusable 状态.
     * @param <T> 控件的类型
     */
    private <T extends View> void printFocusable() {
        Log.d(TAG, "/*-------------- focusable  -------------------------*/");
        for (View v : views) {
            Log.d(TAG, getFormattedClassName(v) + " focusable = " + v.isFocusable());
        }
        Log.d(TAG, " ");
    }

    /**
     * 打印各个控件默认的 focusableInTouchMode 状态.
     * @param <T> 控件的类型
     */
    private <T extends View> void printFocusableInTouchMode() {
        Log.d(TAG, "/*-------------- focusableInTouchMode  -------------------------*/");
        for (View v : views) {
            Log.d(TAG, getFormattedClassName(v) + " focusableInTouchMode = " + v.isFocusableInTouchMode());
        }
        Log.d(TAG, " ");
    }

    /**
     * 打印各个控件默认的 focused 状态.
     * @param <T> 控件的类型
     */
    private <T extends View> void printFocused() {
        Log.d(TAG, "/*-------------- focused  -------------------------*/");
        for (View v : views) {
            Log.d(TAG, getFormattedClassName(v) + " focused = " + v.isFocused());
        }
        Log.d(TAG, " ");
    }

    /**
     * 获取给定控件的类名的字符串, 并将其转换为统一的字符串格式, 使得返回的字符串的总长度为20个字符.
     * @param t 给定控件类型的实例
     * @param <T> 给定控件的类型
     * @return
     */
    private <T extends View> String getFormattedClassName(T t) {
        String className = t.getClass().getSimpleName();
        int remainingCharCount = 20 - className.length();
        StringBuilder sb = new StringBuilder(className);
        for(int i = 0; i < remainingCharCount; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}