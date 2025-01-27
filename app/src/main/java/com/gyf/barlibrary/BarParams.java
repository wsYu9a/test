package com.gyf.barlibrary;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BarParams implements Cloneable {

    @ColorInt
    int flymeOSStatusBarFontColor;
    OnKeyboardListener onKeyboardListener;
    View statusBarView;
    View titleBarView;

    @ColorInt
    int statusBarColor = 0;

    @ColorInt
    int navigationBarColor = -16777216;
    int defaultNavigationBarColor = -16777216;

    @FloatRange(from = 0.0d, to = 1.0d)
    float statusBarAlpha = 0.0f;

    @FloatRange(from = 0.0d, to = 1.0d)
    float navigationBarAlpha = 0.0f;
    public boolean fullScreen = false;
    boolean hideNavigationBar = false;
    BarHide barHide = BarHide.FLAG_SHOW_BAR;
    boolean statusBarDarkFont = false;
    boolean navigationBarDarkIcon = false;
    boolean autoStatusBarDarkModeEnable = false;
    boolean autoNavigationBarDarkModeEnable = false;

    @FloatRange(from = 0.0d, to = 1.0d)
    float autoStatusBarDarkModeAlpha = 0.0f;

    @FloatRange(from = 0.0d, to = 1.0d)
    float autoNavigationBarDarkModeAlpha = 0.0f;
    boolean statusBarColorEnabled = true;

    @ColorInt
    int statusBarColorTransform = -16777216;

    @ColorInt
    int navigationBarColorTransform = -16777216;
    Map<View, Map<Integer, Integer>> viewMap = new HashMap();

    @FloatRange(from = 0.0d, to = 1.0d)
    float viewAlpha = 0.0f;

    @ColorInt
    int contentColor = 0;

    @ColorInt
    int contentColorTransform = -16777216;

    @FloatRange(from = 0.0d, to = 1.0d)
    float contentAlpha = 0.0f;
    public boolean fits = false;
    boolean isSupportActionBar = false;
    public boolean keyboardEnable = false;
    int keyboardMode = 18;
    boolean navigationBarEnable = true;
    boolean navigationBarWithKitkatEnable = true;
    boolean navigationBarWithEMUI3Enable = true;

    @Deprecated
    boolean fixMarginAtBottom = false;

    /* renamed from: clone */
    public BarParams m54clone() {
        try {
            return (BarParams) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
