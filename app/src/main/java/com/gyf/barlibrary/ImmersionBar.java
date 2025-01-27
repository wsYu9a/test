package com.gyf.barlibrary;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.database.ContentObserver;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@TargetApi(19)
/* loaded from: classes.dex */
public class ImmersionBar {
    private static final int BOUNDARY_COLOR = -4539718;
    private static final int FLAG_FITS_DEFAULT = 0;
    private static final int FLAG_FITS_STATUS = 3;
    private static final int FLAG_FITS_SYSTEM_WINDOWS = 4;
    private static final int FLAG_FITS_TITLE = 1;
    private static final int FLAG_FITS_TITLE_MARGIN_TOP = 2;
    private static final String MIUI_NAVIGATION_BAR_DARK = "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE";
    private static final String MIUI_STATUS_BAR_DARK = "EXTRA_FLAG_STATUS_BAR_DARK_MODE";
    private static final String NAVIGATIONBAR_IS_MIN = "navigationbar_is_min";
    private Activity mActivity;
    private BarConfig mBarConfig;
    private BarParams mBarParams;
    private ViewGroup mContentView;
    private ViewGroup mDecorView;
    private Dialog mDialog;
    private FitsKeyboard mFitsKeyboard;
    private int mFitsStatusBarType;
    private Fragment mFragment;
    private boolean mHasNavigationBarColor;
    private String mImmersionBarName;
    private boolean mIsFitsLayoutOverlap;
    private boolean mIsFitsNotch;
    private boolean mIsFragment;
    private int mNavigationBarHeight;
    private int mNavigationBarWidth;
    private ContentObserver mNavigationObserver;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private Map<String, BarParams> mTagMap;
    private Window mWindow;
    private static final int IMMERSION_STATUS_BAR_VIEW = R.id.immersion_status_bar_view;
    private static final int IMMERSION_NAVIGATION_BAR_VIEW = R.id.immersion_navigation_bar_view;
    private static Map<String, ImmersionBar> mImmersionBarMap = new HashMap();

    /* renamed from: com.gyf.barlibrary.ImmersionBar$1 */
    class AnonymousClass1 extends ContentObserver {
        final /* synthetic */ View val$navigationBarView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Handler handler, View view) {
            super(handler);
            findViewById = view;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            int i2;
            int i3;
            ImmersionBar immersionBar = ImmersionBar.this;
            immersionBar.mBarConfig = new BarConfig(immersionBar.mActivity);
            int paddingBottom = ImmersionBar.this.mContentView.getPaddingBottom();
            int paddingRight = ImmersionBar.this.mContentView.getPaddingRight();
            if (ImmersionBar.this.mActivity != null && ImmersionBar.this.mActivity.getContentResolver() != null) {
                if (Settings.System.getInt(ImmersionBar.this.mActivity.getContentResolver(), ImmersionBar.NAVIGATIONBAR_IS_MIN, 0) == 1) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                    if (!ImmersionBar.checkFitsSystemWindows(ImmersionBar.this.mDecorView.findViewById(android.R.id.content))) {
                        if (ImmersionBar.this.mNavigationBarHeight == 0) {
                            ImmersionBar immersionBar2 = ImmersionBar.this;
                            immersionBar2.mNavigationBarHeight = immersionBar2.mBarConfig.getNavigationBarHeight();
                        }
                        if (ImmersionBar.this.mNavigationBarWidth == 0) {
                            ImmersionBar immersionBar3 = ImmersionBar.this;
                            immersionBar3.mNavigationBarWidth = immersionBar3.mBarConfig.getNavigationBarWidth();
                        }
                        if (!ImmersionBar.this.mBarParams.hideNavigationBar) {
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                            if (ImmersionBar.this.mBarConfig.isNavigationAtBottom()) {
                                layoutParams.gravity = 80;
                                layoutParams.height = ImmersionBar.this.mNavigationBarHeight;
                                i3 = !ImmersionBar.this.mBarParams.fullScreen ? ImmersionBar.this.mNavigationBarHeight : 0;
                                i2 = 0;
                            } else {
                                layoutParams.gravity = 8388613;
                                layoutParams.width = ImmersionBar.this.mNavigationBarWidth;
                                i2 = !ImmersionBar.this.mBarParams.fullScreen ? ImmersionBar.this.mNavigationBarWidth : 0;
                                i3 = 0;
                            }
                            findViewById.setLayoutParams(layoutParams);
                            paddingBottom = i3;
                            paddingRight = i2;
                        }
                    }
                }
                paddingBottom = 0;
                paddingRight = 0;
            }
            ImmersionBar immersionBar4 = ImmersionBar.this;
            immersionBar4.setPadding(0, immersionBar4.mContentView.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    /* renamed from: com.gyf.barlibrary.ImmersionBar$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ ViewGroup.LayoutParams val$layoutParams;
        final /* synthetic */ View val$view;

        AnonymousClass2(ViewGroup.LayoutParams layoutParams, View view, Activity activity) {
            layoutParams = layoutParams;
            view = view;
            activity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            layoutParams.height = view.getHeight() + ImmersionBar.getStatusBarHeight(activity);
            View view = view;
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + ImmersionBar.getStatusBarHeight(activity), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    /* renamed from: com.gyf.barlibrary.ImmersionBar$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$gyf$barlibrary$BarHide;

        static {
            int[] iArr = new int[BarHide.values().length];
            $SwitchMap$com$gyf$barlibrary$BarHide = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$gyf$barlibrary$BarHide[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$gyf$barlibrary$BarHide[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$gyf$barlibrary$BarHide[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private ImmersionBar(Activity activity) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = activity;
        this.mWindow = activity.getWindow();
        this.mImmersionBarName = this.mActivity.toString();
        this.mBarParams = new BarParams();
        ViewGroup viewGroup = (ViewGroup) this.mWindow.getDecorView();
        this.mDecorView = viewGroup;
        this.mContentView = (ViewGroup) viewGroup.findViewById(android.R.id.content);
    }

    private void adjustDarkModeParams() {
        BarParams barParams = this.mBarParams;
        if (barParams.autoStatusBarDarkModeEnable) {
            int i2 = barParams.statusBarColor;
            statusBarDarkFont(i2 != 0 && i2 > BOUNDARY_COLOR, barParams.autoStatusBarDarkModeAlpha);
        }
        BarParams barParams2 = this.mBarParams;
        if (barParams2.autoNavigationBarDarkModeEnable) {
            int i3 = barParams2.navigationBarColor;
            navigationBarDarkIcon(i3 != 0 && i3 > BOUNDARY_COLOR, barParams2.autoNavigationBarDarkModeAlpha);
        }
    }

    private void cancelListener() {
        Activity activity = this.mActivity;
        if (activity != null) {
            if (this.mNavigationObserver != null) {
                activity.getContentResolver().unregisterContentObserver(this.mNavigationObserver);
                this.mNavigationObserver = null;
            }
            FitsKeyboard fitsKeyboard = this.mFitsKeyboard;
            if (fitsKeyboard != null) {
                fitsKeyboard.cancel();
                this.mFitsKeyboard = null;
            }
        }
    }

    public static boolean checkFitsSystemWindows(View view) {
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (((childAt instanceof DrawerLayout) && checkFitsSystemWindows(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void fitsKeyboard() {
        if (Build.VERSION.SDK_INT >= 19) {
            if (!this.mIsFragment) {
                if (this.mBarParams.keyboardEnable) {
                    if (this.mFitsKeyboard == null) {
                        this.mFitsKeyboard = new FitsKeyboard(this, this.mActivity, this.mWindow);
                    }
                    this.mFitsKeyboard.enable(this.mBarParams.keyboardMode);
                    return;
                } else {
                    FitsKeyboard fitsKeyboard = this.mFitsKeyboard;
                    if (fitsKeyboard != null) {
                        fitsKeyboard.disable();
                        return;
                    }
                    return;
                }
            }
            ImmersionBar immersionBar = mImmersionBarMap.get(this.mActivity.toString());
            if (immersionBar != null) {
                if (immersionBar.mBarParams.keyboardEnable) {
                    if (immersionBar.mFitsKeyboard == null) {
                        immersionBar.mFitsKeyboard = new FitsKeyboard(immersionBar, immersionBar.mActivity, immersionBar.mWindow);
                    }
                    immersionBar.mFitsKeyboard.enable(immersionBar.mBarParams.keyboardMode);
                } else {
                    FitsKeyboard fitsKeyboard2 = immersionBar.mFitsKeyboard;
                    if (fitsKeyboard2 != null) {
                        fitsKeyboard2.disable();
                    }
                }
            }
        }
    }

    private void fitsLayoutOverlap() {
        if (Build.VERSION.SDK_INT < 19 || this.mIsFitsLayoutOverlap) {
            return;
        }
        int i2 = this.mFitsStatusBarType;
        if (i2 == 1) {
            setTitleBar(this.mActivity, this.mBarParams.titleBarView);
            this.mIsFitsLayoutOverlap = true;
        } else if (i2 == 2) {
            setTitleBarMarginTop(this.mActivity, this.mBarParams.titleBarView);
            this.mIsFitsLayoutOverlap = true;
        } else {
            if (i2 != 3) {
                return;
            }
            setStatusBarView(this.mActivity, this.mBarParams.statusBarView);
            this.mIsFitsLayoutOverlap = true;
        }
    }

    private void fitsNotchScreen() {
        if (Build.VERSION.SDK_INT < 28 || this.mIsFitsNotch) {
            return;
        }
        WindowManager.LayoutParams attributes = this.mWindow.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        this.mWindow.setAttributes(attributes);
        this.mIsFitsNotch = true;
    }

    private void fitsWindows() {
        if (Build.VERSION.SDK_INT >= 21 && !OSUtils.isEMUI3_x()) {
            fitsWindowsAboveLOLLIPOP();
            return;
        }
        fitsWindowsBelowLOLLIPOP();
        if (this.mIsFragment || !OSUtils.isEMUI3_x()) {
            return;
        }
        fitsWindowsEMUI();
    }

    private void fitsWindowsAboveLOLLIPOP() {
        if (checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content))) {
            if (this.mBarParams.isSupportActionBar) {
                setPadding(0, this.mBarConfig.getActionBarHeight(), 0, 0);
            }
        } else {
            int statusBarHeight = (this.mBarParams.fits && this.mFitsStatusBarType == 4) ? this.mBarConfig.getStatusBarHeight() : 0;
            if (this.mBarParams.isSupportActionBar) {
                statusBarHeight = this.mBarConfig.getStatusBarHeight() + this.mBarConfig.getActionBarHeight();
            }
            setPadding(0, statusBarHeight, 0, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void fitsWindowsBelowLOLLIPOP() {
        /*
            r5 = this;
            android.view.ViewGroup r0 = r5.mDecorView
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r1)
            boolean r0 = checkFitsSystemWindows(r0)
            r1 = 0
            if (r0 == 0) goto L20
            com.gyf.barlibrary.BarParams r0 = r5.mBarParams
            boolean r0 = r0.isSupportActionBar
            if (r0 == 0) goto L1f
            com.gyf.barlibrary.BarConfig r0 = r5.mBarConfig
            int r0 = r0.getActionBarHeight()
            r5.setPadding(r1, r0, r1, r1)
        L1f:
            return
        L20:
            com.gyf.barlibrary.BarParams r0 = r5.mBarParams
            boolean r0 = r0.fits
            if (r0 == 0) goto L32
            int r0 = r5.mFitsStatusBarType
            r2 = 4
            if (r0 != r2) goto L32
            com.gyf.barlibrary.BarConfig r0 = r5.mBarConfig
            int r0 = r0.getStatusBarHeight()
            goto L33
        L32:
            r0 = 0
        L33:
            com.gyf.barlibrary.BarParams r2 = r5.mBarParams
            boolean r2 = r2.isSupportActionBar
            if (r2 == 0) goto L46
            com.gyf.barlibrary.BarConfig r0 = r5.mBarConfig
            int r0 = r0.getStatusBarHeight()
            com.gyf.barlibrary.BarConfig r2 = r5.mBarConfig
            int r2 = r2.getActionBarHeight()
            int r0 = r0 + r2
        L46:
            com.gyf.barlibrary.BarConfig r2 = r5.mBarConfig
            boolean r2 = r2.hasNavigationBar()
            if (r2 == 0) goto L96
            com.gyf.barlibrary.BarParams r2 = r5.mBarParams
            boolean r3 = r2.navigationBarEnable
            if (r3 == 0) goto L96
            boolean r3 = r2.navigationBarWithKitkatEnable
            if (r3 == 0) goto L96
            boolean r2 = r2.fullScreen
            if (r2 != 0) goto L74
            com.gyf.barlibrary.BarConfig r2 = r5.mBarConfig
            boolean r2 = r2.isNavigationAtBottom()
            if (r2 == 0) goto L6d
            com.gyf.barlibrary.BarConfig r2 = r5.mBarConfig
            int r2 = r2.getNavigationBarHeight()
            r3 = r2
            r2 = 0
            goto L76
        L6d:
            com.gyf.barlibrary.BarConfig r2 = r5.mBarConfig
            int r2 = r2.getNavigationBarWidth()
            goto L75
        L74:
            r2 = 0
        L75:
            r3 = 0
        L76:
            com.gyf.barlibrary.BarParams r4 = r5.mBarParams
            boolean r4 = r4.hideNavigationBar
            if (r4 == 0) goto L87
            com.gyf.barlibrary.BarConfig r4 = r5.mBarConfig
            boolean r4 = r4.isNavigationAtBottom()
            if (r4 == 0) goto L85
            goto L97
        L85:
            r2 = 0
            goto L98
        L87:
            com.gyf.barlibrary.BarConfig r4 = r5.mBarConfig
            boolean r4 = r4.isNavigationAtBottom()
            if (r4 != 0) goto L98
            com.gyf.barlibrary.BarConfig r2 = r5.mBarConfig
            int r2 = r2.getNavigationBarWidth()
            goto L98
        L96:
            r2 = 0
        L97:
            r3 = 0
        L98:
            r5.setPadding(r1, r0, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.barlibrary.ImmersionBar.fitsWindowsBelowLOLLIPOP():void");
    }

    private void fitsWindowsEMUI() {
        View findViewById = this.mDecorView.findViewById(IMMERSION_NAVIGATION_BAR_VIEW);
        BarParams barParams = this.mBarParams;
        if (!barParams.navigationBarEnable || !barParams.navigationBarWithKitkatEnable) {
            findViewById.setVisibility(8);
            return;
        }
        if (findViewById == null || this.mNavigationObserver != null) {
            return;
        }
        this.mNavigationObserver = new ContentObserver(new Handler()) { // from class: com.gyf.barlibrary.ImmersionBar.1
            final /* synthetic */ View val$navigationBarView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Handler handler, View findViewById2) {
                super(handler);
                findViewById = findViewById2;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                int i2;
                int i3;
                ImmersionBar immersionBar = ImmersionBar.this;
                immersionBar.mBarConfig = new BarConfig(immersionBar.mActivity);
                int paddingBottom = ImmersionBar.this.mContentView.getPaddingBottom();
                int paddingRight = ImmersionBar.this.mContentView.getPaddingRight();
                if (ImmersionBar.this.mActivity != null && ImmersionBar.this.mActivity.getContentResolver() != null) {
                    if (Settings.System.getInt(ImmersionBar.this.mActivity.getContentResolver(), ImmersionBar.NAVIGATIONBAR_IS_MIN, 0) == 1) {
                        findViewById.setVisibility(8);
                    } else {
                        findViewById.setVisibility(0);
                        if (!ImmersionBar.checkFitsSystemWindows(ImmersionBar.this.mDecorView.findViewById(android.R.id.content))) {
                            if (ImmersionBar.this.mNavigationBarHeight == 0) {
                                ImmersionBar immersionBar2 = ImmersionBar.this;
                                immersionBar2.mNavigationBarHeight = immersionBar2.mBarConfig.getNavigationBarHeight();
                            }
                            if (ImmersionBar.this.mNavigationBarWidth == 0) {
                                ImmersionBar immersionBar3 = ImmersionBar.this;
                                immersionBar3.mNavigationBarWidth = immersionBar3.mBarConfig.getNavigationBarWidth();
                            }
                            if (!ImmersionBar.this.mBarParams.hideNavigationBar) {
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                                if (ImmersionBar.this.mBarConfig.isNavigationAtBottom()) {
                                    layoutParams.gravity = 80;
                                    layoutParams.height = ImmersionBar.this.mNavigationBarHeight;
                                    i3 = !ImmersionBar.this.mBarParams.fullScreen ? ImmersionBar.this.mNavigationBarHeight : 0;
                                    i2 = 0;
                                } else {
                                    layoutParams.gravity = 8388613;
                                    layoutParams.width = ImmersionBar.this.mNavigationBarWidth;
                                    i2 = !ImmersionBar.this.mBarParams.fullScreen ? ImmersionBar.this.mNavigationBarWidth : 0;
                                    i3 = 0;
                                }
                                findViewById.setLayoutParams(layoutParams);
                                paddingBottom = i3;
                                paddingRight = i2;
                            }
                        }
                    }
                    paddingBottom = 0;
                    paddingRight = 0;
                }
                ImmersionBar immersionBar4 = ImmersionBar.this;
                immersionBar4.setPadding(0, immersionBar4.mContentView.getPaddingTop(), paddingRight, paddingBottom);
            }
        };
        Activity activity = this.mActivity;
        if (activity == null || activity.getContentResolver() == null || this.mNavigationObserver == null) {
            return;
        }
        this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor(NAVIGATIONBAR_IS_MIN), true, this.mNavigationObserver);
    }

    @TargetApi(14)
    public static int getActionBarHeight(@NonNull Activity activity) {
        return new BarConfig(activity).getActionBarHeight();
    }

    @TargetApi(14)
    public static int getNavigationBarHeight(@NonNull Activity activity) {
        return new BarConfig(activity).getNavigationBarHeight();
    }

    @TargetApi(14)
    public static int getNavigationBarWidth(@NonNull Activity activity) {
        return new BarConfig(activity).getNavigationBarWidth();
    }

    @TargetApi(14)
    public static int getStatusBarHeight(@NonNull Activity activity) {
        return new BarConfig(activity).getStatusBarHeight();
    }

    @TargetApi(14)
    public static boolean hasNavigationBar(@NonNull Activity activity) {
        return new BarConfig(activity).hasNavigationBar();
    }

    public static boolean hasNotchScreen(@NonNull Activity activity) {
        return new BarConfig(activity).hasNotchScreen();
    }

    public static void hideStatusBar(@NonNull Window window) {
        window.setFlags(1024, 1024);
    }

    @RequiresApi(api = 21)
    private int initBarAboveLOLLIPOP(int i2) {
        if (!this.mHasNavigationBarColor) {
            this.mBarParams.defaultNavigationBarColor = this.mWindow.getNavigationBarColor();
            this.mHasNavigationBarColor = true;
        }
        int i3 = i2 | 1024;
        BarParams barParams = this.mBarParams;
        if (barParams.fullScreen && barParams.navigationBarEnable) {
            i3 |= 512;
        }
        this.mWindow.clearFlags(67108864);
        if (this.mBarConfig.hasNavigationBar()) {
            this.mWindow.clearFlags(134217728);
        }
        this.mWindow.addFlags(Integer.MIN_VALUE);
        BarParams barParams2 = this.mBarParams;
        if (barParams2.statusBarColorEnabled) {
            this.mWindow.setStatusBarColor(ColorUtils.blendARGB(barParams2.statusBarColor, barParams2.statusBarColorTransform, barParams2.statusBarAlpha));
        } else {
            this.mWindow.setStatusBarColor(ColorUtils.blendARGB(barParams2.statusBarColor, 0, barParams2.statusBarAlpha));
        }
        BarParams barParams3 = this.mBarParams;
        if (barParams3.navigationBarEnable) {
            this.mWindow.setNavigationBarColor(ColorUtils.blendARGB(barParams3.navigationBarColor, barParams3.navigationBarColorTransform, barParams3.navigationBarAlpha));
        } else {
            this.mWindow.setNavigationBarColor(barParams3.defaultNavigationBarColor);
        }
        return i3;
    }

    private void initBarBelowLOLLIPOP() {
        this.mWindow.addFlags(67108864);
        setupStatusBarView();
        if (this.mBarConfig.hasNavigationBar() || OSUtils.isEMUI3_x()) {
            BarParams barParams = this.mBarParams;
            if (barParams.navigationBarEnable && barParams.navigationBarWithKitkatEnable) {
                this.mWindow.addFlags(134217728);
            } else {
                this.mWindow.clearFlags(134217728);
            }
            if (this.mNavigationBarHeight == 0) {
                this.mNavigationBarHeight = this.mBarConfig.getNavigationBarHeight();
            }
            if (this.mNavigationBarWidth == 0) {
                this.mNavigationBarWidth = this.mBarConfig.getNavigationBarWidth();
            }
            setupNavBarView();
        }
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    @TargetApi(14)
    public static boolean isNavigationAtBottom(@NonNull Activity activity) {
        return new BarConfig(activity).isNavigationAtBottom();
    }

    public static boolean isSupportNavigationIconDark() {
        return OSUtils.isMIUI6Later() || Build.VERSION.SDK_INT >= 26;
    }

    public static boolean isSupportStatusBarDarkFont() {
        return OSUtils.isMIUI6Later() || OSUtils.isFlymeOS4Later() || Build.VERSION.SDK_INT >= 23;
    }

    private void setBar() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            int i3 = 256;
            if (i2 < 21 || OSUtils.isEMUI3_x()) {
                initBarBelowLOLLIPOP();
            } else {
                fitsNotchScreen();
                i3 = setNavigationIconDark(setStatusBarDarkFont(initBarAboveLOLLIPOP(256)));
            }
            int hideBar = hideBar(i3);
            fitsWindows();
            this.mDecorView.setSystemUiVisibility(hideBar);
        }
        if (OSUtils.isMIUI6Later()) {
            setMIUIBarDark(this.mWindow, MIUI_STATUS_BAR_DARK, this.mBarParams.statusBarDarkFont);
            BarParams barParams = this.mBarParams;
            if (barParams.navigationBarEnable) {
                setMIUIBarDark(this.mWindow, MIUI_NAVIGATION_BAR_DARK, barParams.navigationBarDarkIcon);
            }
        }
        if (OSUtils.isFlymeOS4Later()) {
            BarParams barParams2 = this.mBarParams;
            int i4 = barParams2.flymeOSStatusBarFontColor;
            if (i4 != 0) {
                FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(this.mActivity, i4);
            } else {
                FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(this.mActivity, barParams2.statusBarDarkFont);
            }
        }
    }

    public static void setFitsSystemWindows(Activity activity) {
        if (activity == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof ViewGroup) && !(childAt instanceof DrawerLayout)) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    private void setMIUIBarDark(Window window, String str, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField(str).getInt(cls2);
                Class<?> cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", cls3, cls3);
                if (z) {
                    method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i2));
                }
            } catch (Exception unused) {
            }
        }
    }

    private int setNavigationIconDark(int i2) {
        return (Build.VERSION.SDK_INT < 26 || !this.mBarParams.navigationBarDarkIcon) ? i2 : i2 | 16;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup != null) {
            viewGroup.setPadding(i2, i3, i4, i5);
        }
        this.mPaddingLeft = i2;
        this.mPaddingTop = i3;
        this.mPaddingRight = i4;
        this.mPaddingBottom = i5;
    }

    private int setStatusBarDarkFont(int i2) {
        return (Build.VERSION.SDK_INT < 23 || !this.mBarParams.statusBarDarkFont) ? i2 : i2 | 8192;
    }

    public static void setStatusBarView(Activity activity, View view) {
        if (activity == null || view == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = getStatusBarHeight(activity);
        view.setLayoutParams(layoutParams);
    }

    public static void setTitleBar(Activity activity, View view) {
        if (activity == null || view == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i2 = layoutParams.height;
        if (i2 == -2 || i2 == -1) {
            view.post(new Runnable() { // from class: com.gyf.barlibrary.ImmersionBar.2
                final /* synthetic */ Activity val$activity;
                final /* synthetic */ ViewGroup.LayoutParams val$layoutParams;
                final /* synthetic */ View val$view;

                AnonymousClass2(ViewGroup.LayoutParams layoutParams2, View view2, Activity activity2) {
                    layoutParams = layoutParams2;
                    view = view2;
                    activity = activity2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    layoutParams.height = view.getHeight() + ImmersionBar.getStatusBarHeight(activity);
                    View view2 = view;
                    view2.setPadding(view2.getPaddingLeft(), view.getPaddingTop() + ImmersionBar.getStatusBarHeight(activity), view.getPaddingRight(), view.getPaddingBottom());
                }
            });
        } else {
            layoutParams2.height = i2 + getStatusBarHeight(activity2);
            view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop() + getStatusBarHeight(activity2), view2.getPaddingRight(), view2.getPaddingBottom());
        }
    }

    public static void setTitleBarMarginTop(Activity activity, View view) {
        if (activity == null || view == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + getStatusBarHeight(activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
    }

    private void setupNavBarView() {
        FrameLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.mDecorView;
        int i2 = IMMERSION_NAVIGATION_BAR_VIEW;
        View findViewById = viewGroup.findViewById(i2);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            findViewById.setId(i2);
            this.mDecorView.addView(findViewById);
        }
        if (this.mBarConfig.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.mBarConfig.getNavigationBarWidth(), -1);
            layoutParams.gravity = 8388613;
        }
        findViewById.setLayoutParams(layoutParams);
        BarParams barParams = this.mBarParams;
        findViewById.setBackgroundColor(ColorUtils.blendARGB(barParams.navigationBarColor, barParams.navigationBarColorTransform, barParams.navigationBarAlpha));
        BarParams barParams2 = this.mBarParams;
        if (barParams2.navigationBarEnable && barParams2.navigationBarWithKitkatEnable && !barParams2.hideNavigationBar) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    private void setupStatusBarView() {
        ViewGroup viewGroup = this.mDecorView;
        int i2 = IMMERSION_STATUS_BAR_VIEW;
        View findViewById = viewGroup.findViewById(i2);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.getStatusBarHeight());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(i2);
            this.mDecorView.addView(findViewById);
        }
        BarParams barParams = this.mBarParams;
        if (barParams.statusBarColorEnabled) {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(barParams.statusBarColor, barParams.statusBarColorTransform, barParams.statusBarAlpha));
        } else {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(barParams.statusBarColor, 0, barParams.statusBarAlpha));
        }
    }

    private void transformView() {
        if (this.mBarParams.viewMap.size() != 0) {
            for (Map.Entry<View, Map<Integer, Integer>> entry : this.mBarParams.viewMap.entrySet()) {
                View key = entry.getKey();
                Map<Integer, Integer> value = entry.getValue();
                Integer valueOf = Integer.valueOf(this.mBarParams.statusBarColor);
                Integer valueOf2 = Integer.valueOf(this.mBarParams.statusBarColorTransform);
                for (Map.Entry<Integer, Integer> entry2 : value.entrySet()) {
                    Integer key2 = entry2.getKey();
                    valueOf2 = entry2.getValue();
                    valueOf = key2;
                }
                if (key != null) {
                    if (Math.abs(this.mBarParams.viewAlpha - 0.0f) == 0.0f) {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.mBarParams.statusBarAlpha));
                    } else {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.mBarParams.viewAlpha));
                    }
                }
            }
        }
    }

    private void updateBarParams() {
        ImmersionBar immersionBar;
        adjustDarkModeParams();
        if (Build.VERSION.SDK_INT >= 19) {
            if (OSUtils.isEMUI3_x()) {
                BarParams barParams = this.mBarParams;
                if (barParams.navigationBarWithKitkatEnable) {
                    barParams.navigationBarWithKitkatEnable = barParams.navigationBarWithEMUI3Enable;
                }
            }
            this.mBarConfig = new BarConfig(this.mActivity);
            if (!this.mIsFragment || (immersionBar = mImmersionBarMap.get(this.mActivity.toString())) == null) {
                return;
            }
            immersionBar.mBarParams = this.mBarParams;
        }
    }

    public static ImmersionBar with(@NonNull Activity activity) {
        ImmersionBar immersionBar = mImmersionBarMap.get(activity.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(activity);
        mImmersionBarMap.put(activity.toString(), immersionBar2);
        return immersionBar2;
    }

    public ImmersionBar addTag(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        this.mTagMap.put(str, this.mBarParams.m54clone());
        return this;
    }

    public ImmersionBar addViewSupportTransformColor(View view) {
        return addViewSupportTransformColorInt(view, this.mBarParams.statusBarColorTransform);
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, @ColorInt int i2) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(this.mBarParams.statusBarColor), Integer.valueOf(i2));
        this.mBarParams.viewMap.put(view, hashMap);
        return this;
    }

    public ImmersionBar autoDarkModeEnable(boolean z) {
        return autoDarkModeEnable(z, 0.0f);
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        BarParams barParams = this.mBarParams;
        barParams.autoNavigationBarDarkModeEnable = z;
        barParams.autoNavigationBarDarkModeAlpha = f2;
        return this;
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        BarParams barParams = this.mBarParams;
        barParams.autoStatusBarDarkModeEnable = z;
        barParams.autoStatusBarDarkModeAlpha = f2;
        return this;
    }

    public ImmersionBar barAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarAlpha = f2;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar barColor(@ColorRes int i2) {
        return barColorInt(ContextCompat.getColor(this.mActivity, i2));
    }

    public ImmersionBar barColorInt(@ColorInt int i2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i2;
        barParams.navigationBarColor = i2;
        return this;
    }

    public ImmersionBar barColorTransform(@ColorRes int i2) {
        return barColorTransformInt(ContextCompat.getColor(this.mActivity, i2));
    }

    public ImmersionBar barColorTransformInt(@ColorInt int i2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColorTransform = i2;
        barParams.navigationBarColorTransform = i2;
        return this;
    }

    public void destroy() {
        cancelListener();
        Iterator<Map.Entry<String, ImmersionBar>> it = mImmersionBarMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, ImmersionBar> next = it.next();
            if (next.getKey().contains(this.mImmersionBarName) || next.getKey().equals(this.mImmersionBarName)) {
                it.remove();
            }
        }
    }

    public ImmersionBar fitsSystemWindows(boolean z) {
        this.mBarParams.fits = z;
        if (!z) {
            this.mFitsStatusBarType = 0;
        } else if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 4;
        }
        return this;
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, @ColorInt int i2) {
        return fitsSystemWindowsInt(z, i2, -16777216, 0.0f);
    }

    @Deprecated
    public ImmersionBar fixMarginAtBottom(boolean z) {
        this.mBarParams.fixMarginAtBottom = z;
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(@ColorRes int i2) {
        this.mBarParams.flymeOSStatusBarFontColor = ContextCompat.getColor(this.mActivity, i2);
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColorInt(@ColorInt int i2) {
        this.mBarParams.flymeOSStatusBarFontColor = i2;
        return this;
    }

    public ImmersionBar fullScreen(boolean z) {
        this.mBarParams.fullScreen = z;
        return this;
    }

    public BarParams getBarParams() {
        return this.mBarParams;
    }

    int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    int getPaddingRight() {
        return this.mPaddingRight;
    }

    int getPaddingTop() {
        return this.mPaddingTop;
    }

    public ImmersionBar getTag(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        BarParams barParams = this.mTagMap.get(str);
        if (barParams != null) {
            this.mBarParams = barParams.m54clone();
        }
        return this;
    }

    public ImmersionBar hideBar(BarHide barHide) {
        this.mBarParams.barHide = barHide;
        if (Build.VERSION.SDK_INT == 19 || OSUtils.isEMUI3_x()) {
            BarParams barParams = this.mBarParams;
            BarHide barHide2 = barParams.barHide;
            if (barHide2 == BarHide.FLAG_HIDE_NAVIGATION_BAR || barHide2 == BarHide.FLAG_HIDE_BAR) {
                barParams.hideNavigationBar = true;
            } else {
                barParams.hideNavigationBar = false;
            }
        }
        return this;
    }

    public void init() {
        updateBarParams();
        setBar();
        fitsLayoutOverlap();
        fitsKeyboard();
        transformView();
    }

    public ImmersionBar keyboardEnable(boolean z) {
        return keyboardEnable(z, this.mBarParams.keyboardMode);
    }

    public ImmersionBar keyboardMode(int i2) {
        this.mBarParams.keyboardMode = i2;
        return this;
    }

    public ImmersionBar navigationBarAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.mBarParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar navigationBarColor(@ColorRes int i2) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, i2));
    }

    public ImmersionBar navigationBarColorInt(@ColorInt int i2) {
        this.mBarParams.navigationBarColor = i2;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(@ColorRes int i2) {
        return navigationBarColorTransformInt(ContextCompat.getColor(this.mActivity, i2));
    }

    public ImmersionBar navigationBarColorTransformInt(@ColorInt int i2) {
        this.mBarParams.navigationBarColorTransform = i2;
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean z) {
        return navigationBarDarkIcon(z, 0.0f);
    }

    public ImmersionBar navigationBarEnable(boolean z) {
        this.mBarParams.navigationBarEnable = z;
        return this;
    }

    public ImmersionBar navigationBarWithEMUI3Enable(boolean z) {
        this.mBarParams.navigationBarWithEMUI3Enable = z;
        return this;
    }

    public ImmersionBar navigationBarWithKitkatEnable(boolean z) {
        this.mBarParams.navigationBarWithKitkatEnable = z;
        return this;
    }

    public ImmersionBar removeSupportAllView() {
        if (this.mBarParams.viewMap.size() != 0) {
            this.mBarParams.viewMap.clear();
        }
        return this;
    }

    public ImmersionBar removeSupportView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        if (this.mBarParams.viewMap.get(view).size() != 0) {
            this.mBarParams.viewMap.remove(view);
        }
        return this;
    }

    public ImmersionBar reset() {
        this.mBarParams = new BarParams();
        this.mFitsStatusBarType = 0;
        return this;
    }

    public ImmersionBar setOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        BarParams barParams = this.mBarParams;
        if (barParams.onKeyboardListener == null) {
            barParams.onKeyboardListener = onKeyboardListener;
        }
        return this;
    }

    public ImmersionBar statusBarAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.mBarParams.statusBarAlpha = f2;
        return this;
    }

    public ImmersionBar statusBarColor(@ColorRes int i2) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, i2));
    }

    public ImmersionBar statusBarColorInt(@ColorInt int i2) {
        this.mBarParams.statusBarColor = i2;
        return this;
    }

    public ImmersionBar statusBarColorTransform(@ColorRes int i2) {
        return statusBarColorTransformInt(ContextCompat.getColor(this.mActivity, i2));
    }

    public ImmersionBar statusBarColorTransformEnable(boolean z) {
        this.mBarParams.statusBarColorEnabled = z;
        return this;
    }

    public ImmersionBar statusBarColorTransformInt(@ColorInt int i2) {
        this.mBarParams.statusBarColorTransform = i2;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean z) {
        return statusBarDarkFont(z, 0.0f);
    }

    public ImmersionBar statusBarView(View view) {
        if (view == null) {
            return this;
        }
        this.mBarParams.statusBarView = view;
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 3;
        }
        return this;
    }

    public ImmersionBar supportActionBar(boolean z) {
        this.mBarParams.isSupportActionBar = z;
        return this;
    }

    public ImmersionBar titleBar(View view) {
        return view == null ? this : titleBar(view, true);
    }

    public ImmersionBar titleBarMarginTop(@IdRes int i2) {
        Fragment fragment = this.mFragment;
        return (fragment == null || fragment.getView() == null) ? titleBarMarginTop(this.mActivity.findViewById(i2)) : titleBarMarginTop(this.mFragment.getView().findViewById(i2));
    }

    public ImmersionBar transparentBar() {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = 0;
        barParams.navigationBarColor = 0;
        barParams.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentNavigationBar() {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarColor = 0;
        barParams.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentStatusBar() {
        this.mBarParams.statusBarColor = 0;
        return this;
    }

    public ImmersionBar viewAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.mBarParams.viewAlpha = f2;
        return this;
    }

    public ImmersionBar addViewSupportTransformColor(View view, @ColorRes int i2) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.mActivity, i2));
    }

    public ImmersionBar autoDarkModeEnable(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        BarParams barParams = this.mBarParams;
        barParams.autoStatusBarDarkModeEnable = z;
        barParams.autoStatusBarDarkModeAlpha = f2;
        barParams.autoNavigationBarDarkModeEnable = z;
        barParams.autoNavigationBarDarkModeAlpha = f2;
        return this;
    }

    public ImmersionBar barColor(@ColorRes int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return barColorInt(ContextCompat.getColor(this.mActivity, i2), i2);
    }

    public ImmersionBar barColorTransform(String str) {
        return barColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, @ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        BarParams barParams = this.mBarParams;
        barParams.fits = z;
        barParams.contentColor = i2;
        barParams.contentColorTransform = i3;
        barParams.contentAlpha = f2;
        if (!z) {
            this.mFitsStatusBarType = 0;
        } else if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 4;
        }
        this.mContentView.setBackgroundColor(ColorUtils.blendARGB(i2, i3, f2));
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(String str) {
        this.mBarParams.flymeOSStatusBarFontColor = Color.parseColor(str);
        return this;
    }

    public ImmersionBar keyboardEnable(boolean z, int i2) {
        BarParams barParams = this.mBarParams;
        barParams.keyboardEnable = z;
        barParams.keyboardMode = i2;
        return this;
    }

    public ImmersionBar navigationBarColor(@ColorRes int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, i2), f2);
    }

    public ImmersionBar navigationBarColorInt(@ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarColor = i2;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(String str) {
        return navigationBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarDarkIcon(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.mBarParams.navigationBarDarkIcon = z;
        if (!z || isSupportNavigationIconDark()) {
            this.mBarParams.navigationBarAlpha = 0.0f;
        } else {
            this.mBarParams.navigationBarAlpha = f2;
        }
        return this;
    }

    public ImmersionBar statusBarColor(@ColorRes int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, i2), f2);
    }

    public ImmersionBar statusBarColorInt(@ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i2;
        barParams.statusBarAlpha = f2;
        return this;
    }

    public ImmersionBar statusBarColorTransform(String str) {
        return statusBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarDarkFont(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.mBarParams.statusBarDarkFont = z;
        if (!z || isSupportStatusBarDarkFont()) {
            BarParams barParams = this.mBarParams;
            barParams.flymeOSStatusBarFontColor = 0;
            barParams.statusBarAlpha = 0.0f;
        } else {
            this.mBarParams.statusBarAlpha = f2;
        }
        return this;
    }

    public ImmersionBar titleBar(View view, boolean z) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 1;
        }
        BarParams barParams = this.mBarParams;
        barParams.titleBarView = view;
        barParams.statusBarColorEnabled = z;
        return this;
    }

    public static boolean hasNotchScreen(@NonNull View view) {
        return NotchUtils.hasNotchScreen(view);
    }

    public ImmersionBar addViewSupportTransformColor(View view, @ColorRes int i2, @ColorRes int i3) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.mActivity, i2), ContextCompat.getColor(this.mActivity, i3));
    }

    public ImmersionBar barColor(@ColorRes int i2, @ColorRes int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return barColorInt(ContextCompat.getColor(this.mActivity, i2), ContextCompat.getColor(this.mActivity, i3), f2);
    }

    public ImmersionBar barColorInt(@ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i2;
        barParams.navigationBarColor = i2;
        barParams.statusBarAlpha = f2;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar navigationBarColor(@ColorRes int i2, @ColorRes int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, i2), ContextCompat.getColor(this.mActivity, i3), f2);
    }

    public ImmersionBar statusBarColor(@ColorRes int i2, @ColorRes int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, i2), ContextCompat.getColor(this.mActivity, i3), f2);
    }

    public static ImmersionBar with(@NonNull Fragment fragment) {
        if (fragment.getActivity() != null) {
            ImmersionBar immersionBar = mImmersionBarMap.get(fragment.getActivity().toString() + fragment.toString());
            if (immersionBar != null) {
                return immersionBar;
            }
            ImmersionBar immersionBar2 = new ImmersionBar(fragment);
            mImmersionBarMap.put(fragment.getActivity().toString() + fragment.toString(), immersionBar2);
            return immersionBar2;
        }
        throw new IllegalArgumentException("Activity不能为空!!!");
    }

    public ImmersionBar navigationBarColorInt(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarColor = i2;
        barParams.navigationBarColorTransform = i3;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar statusBarColorInt(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i2;
        barParams.statusBarColorTransform = i3;
        barParams.statusBarAlpha = f2;
        return this;
    }

    public ImmersionBar statusBarView(@IdRes int i2) {
        return statusBarView(this.mActivity.findViewById(i2));
    }

    public ImmersionBar titleBarMarginTop(@IdRes int i2, View view) {
        return titleBarMarginTop(view.findViewById(i2));
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, @ColorInt int i2, @ColorInt int i3) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(i2), Integer.valueOf(i3));
            this.mBarParams.viewMap.put(view, hashMap);
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar fitsSystemWindows(boolean z, @ColorRes int i2) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.mActivity, i2));
    }

    public ImmersionBar statusBarView(@IdRes int i2, View view) {
        return statusBarView(view.findViewById(i2));
    }

    public ImmersionBar titleBarMarginTop(View view) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 2;
        }
        this.mBarParams.titleBarView = view;
        return this;
    }

    private int hideBar(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            int i3 = AnonymousClass3.$SwitchMap$com$gyf$barlibrary$BarHide[this.mBarParams.barHide.ordinal()];
            if (i3 == 1) {
                i2 |= 518;
            } else if (i3 == 2) {
                i2 |= DownloadErrorCode.ERROR_SAVE_PATH_EMPTY;
            } else if (i3 == 3) {
                i2 |= 514;
            } else if (i3 == 4) {
                i2 |= 0;
            }
        }
        return i2 | 4096;
    }

    public ImmersionBar barColor(String str) {
        return barColorInt(Color.parseColor(str));
    }

    public ImmersionBar fitsSystemWindows(boolean z, @ColorRes int i2, @ColorRes int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.mActivity, i2), ContextCompat.getColor(this.mActivity, i3), f2);
    }

    public ImmersionBar navigationBarColor(String str) {
        return navigationBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColor(String str) {
        return statusBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar titleBar(@IdRes int i2) {
        return titleBar(i2, true);
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str));
    }

    public ImmersionBar barColor(String str, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return barColorInt(Color.parseColor(str), f2);
    }

    public ImmersionBar barColorInt(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i2;
        barParams.navigationBarColor = i2;
        barParams.statusBarColorTransform = i3;
        barParams.navigationBarColorTransform = i3;
        barParams.statusBarAlpha = f2;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar navigationBarColor(String str, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return navigationBarColorInt(Color.parseColor(str), f2);
    }

    public ImmersionBar statusBarColor(String str, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return statusBarColorInt(Color.parseColor(str), f2);
    }

    public ImmersionBar titleBar(@IdRes int i2, boolean z) {
        Fragment fragment = this.mFragment;
        if (fragment != null && fragment.getView() != null) {
            return titleBar(this.mFragment.getView().findViewById(i2), z);
        }
        return titleBar(this.mActivity.findViewById(i2), z);
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str, String str2) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str), Color.parseColor(str2));
    }

    public ImmersionBar barColor(String str, String str2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return barColorInt(Color.parseColor(str), Color.parseColor(str2), f2);
    }

    public ImmersionBar navigationBarColor(String str, String str2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return navigationBarColorInt(Color.parseColor(str), Color.parseColor(str2), f2);
    }

    public ImmersionBar statusBarColor(String str, String str2, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return statusBarColorInt(Color.parseColor(str), Color.parseColor(str2), f2);
    }

    public static ImmersionBar with(@NonNull Activity activity, @NonNull Fragment fragment) {
        ImmersionBar immersionBar = mImmersionBarMap.get(activity.toString() + fragment.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(activity, fragment);
        mImmersionBarMap.put(activity.toString() + fragment.toString(), immersionBar2);
        return immersionBar2;
    }

    public ImmersionBar titleBar(@IdRes int i2, View view) {
        return titleBar(view.findViewById(i2), true);
    }

    public ImmersionBar titleBar(@IdRes int i2, View view, boolean z) {
        return titleBar(view.findViewById(i2), z);
    }

    public static ImmersionBar with(@NonNull DialogFragment dialogFragment) {
        if (dialogFragment.getActivity() != null) {
            ImmersionBar immersionBar = mImmersionBarMap.get(dialogFragment.getActivity().toString() + dialogFragment.toString());
            if (immersionBar != null) {
                return immersionBar;
            }
            ImmersionBar immersionBar2 = new ImmersionBar(dialogFragment);
            mImmersionBarMap.put(dialogFragment.getActivity().toString() + dialogFragment.toString(), immersionBar2);
            return immersionBar2;
        }
        throw new IllegalArgumentException("Activity不能为空!!!");
    }

    @Deprecated
    public static ImmersionBar with(@NonNull DialogFragment dialogFragment, @NonNull Dialog dialog) {
        if (dialogFragment.getActivity() != null) {
            ImmersionBar immersionBar = mImmersionBarMap.get(dialogFragment.getActivity().toString() + dialogFragment.toString());
            if (immersionBar != null) {
                return immersionBar;
            }
            ImmersionBar immersionBar2 = new ImmersionBar(dialogFragment, dialog);
            mImmersionBarMap.put(dialogFragment.getActivity().toString() + dialogFragment.toString(), immersionBar2);
            return immersionBar2;
        }
        throw new IllegalArgumentException("Activity不能为空!!!");
    }

    private ImmersionBar(Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    private ImmersionBar(Activity activity, Fragment fragment) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = activity;
        this.mFragment = fragment;
        if (activity != null) {
            if (mImmersionBarMap.get(activity.toString()) != null) {
                this.mIsFragment = true;
                this.mWindow = this.mActivity.getWindow();
                this.mImmersionBarName = activity.toString() + fragment.toString();
                this.mBarParams = new BarParams();
                ViewGroup viewGroup = (ViewGroup) this.mWindow.getDecorView();
                this.mDecorView = viewGroup;
                this.mContentView = (ViewGroup) viewGroup.findViewById(android.R.id.content);
                return;
            }
            throw new IllegalArgumentException("必须先在宿主Activity初始化");
        }
        throw new IllegalArgumentException("Activity不能为空!!!");
    }

    public static ImmersionBar with(@NonNull Activity activity, @NonNull Dialog dialog) {
        ImmersionBar immersionBar = mImmersionBarMap.get(activity.toString() + dialog.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(activity, dialog);
        mImmersionBarMap.put(activity.toString() + dialog.toString(), immersionBar2);
        return immersionBar2;
    }

    @Deprecated
    public static ImmersionBar with(@NonNull Activity activity, @NonNull Dialog dialog, @NonNull String str) {
        ImmersionBar immersionBar = mImmersionBarMap.get(activity.toString() + dialog.toString() + str);
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(activity, dialog, str);
        mImmersionBarMap.put(activity.toString() + dialog.toString() + str, immersionBar2);
        return immersionBar2;
    }

    private ImmersionBar(DialogFragment dialogFragment) {
        this(dialogFragment, dialogFragment.getDialog());
    }

    private ImmersionBar(DialogFragment dialogFragment, Dialog dialog) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        FragmentActivity activity = dialogFragment.getActivity();
        this.mActivity = activity;
        this.mFragment = dialogFragment;
        this.mDialog = dialog;
        if (activity == null) {
            throw new IllegalArgumentException("Activity不能为空!!!");
        }
        if (dialog != null) {
            if (mImmersionBarMap.get(activity.toString()) != null) {
                this.mWindow = this.mDialog.getWindow();
                this.mImmersionBarName = this.mActivity.toString() + dialogFragment.toString();
                this.mBarParams = new BarParams();
                ViewGroup viewGroup = (ViewGroup) this.mWindow.getDecorView();
                this.mDecorView = viewGroup;
                this.mContentView = (ViewGroup) viewGroup.findViewById(android.R.id.content);
                return;
            }
            throw new IllegalArgumentException("必须先在宿主Activity初始化");
        }
        throw new IllegalArgumentException("DialogFragment中的dialog不能为空");
    }

    private ImmersionBar(Activity activity, Dialog dialog) {
        this(activity, dialog, "");
    }

    private ImmersionBar(Activity activity, Dialog dialog, String str) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = activity;
        this.mDialog = dialog;
        if (activity == null) {
            throw new IllegalArgumentException("Activity不能为空!!!");
        }
        if (dialog != null) {
            if (mImmersionBarMap.get(activity.toString()) != null) {
                this.mWindow = this.mDialog.getWindow();
                this.mImmersionBarName = activity.toString() + dialog.toString() + str;
                this.mBarParams = new BarParams();
                ViewGroup viewGroup = (ViewGroup) this.mWindow.getDecorView();
                this.mDecorView = viewGroup;
                this.mContentView = (ViewGroup) viewGroup.findViewById(android.R.id.content);
                return;
            }
            throw new IllegalArgumentException("必须先在宿主Activity初始化");
        }
        throw new IllegalArgumentException("dialog不能为空");
    }
}
