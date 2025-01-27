package com.martian.libmars.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.VerticalSwipeRefreshLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;

/* loaded from: classes2.dex */
public abstract class k1 extends j1 {
    public static int B = 1;
    public static int C = 2;
    public static int D = 3;
    public static int E = 4;
    private LinearLayout G;
    private ViewStub H;
    private View I;
    protected ThemeImageView J;
    private ThemeImageView K;
    protected ThemeTextView L;
    private View M;
    private LoadingTip O;
    private boolean F = false;
    public VerticalSwipeRefreshLayout N = null;
    private boolean P = false;

    public void A2(int color) {
        this.N.setColorSchemeResources(color);
    }

    public void B2() {
        if (this.N.isRefreshing()) {
            this.N.setRefreshing(false);
            k1("更新完毕");
        }
        this.P = false;
    }

    public void C2(boolean enable) {
        VerticalSwipeRefreshLayout verticalSwipeRefreshLayout = this.N;
        if (verticalSwipeRefreshLayout != null) {
            verticalSwipeRefreshLayout.setEnabled(enable);
        }
    }

    public void D2(SwipeRefreshLayout.OnRefreshListener listener) {
        this.N.setOnRefreshListener(listener);
    }

    public void E2(boolean refresh) {
        this.N.setRefreshing(refresh);
    }

    public void F2() {
        ImmersionBar.with(this).statusBarView(R.id.actionbar_top_view).init();
        this.G.setPadding(0, ImmersionBar.getStatusBarHeight(this) + ImmersionBar.getActionBarHeight(this), 0, 0);
    }

    public void G2(boolean z) {
        ThemeTextView themeTextView = this.L;
        if (themeTextView != null) {
            themeTextView.setWithTypeFace(z ? 1 : 0);
        }
    }

    public void H2(boolean backable) {
        super.a2(backable);
        if (backable) {
            y2();
        }
    }

    public void I2(boolean show) {
        View view = this.M;
        if (view == null) {
            return;
        }
        if (show) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void J2(boolean show) {
        if (show) {
            this.J.setVisibility(0);
        } else {
            this.J.setVisibility(8);
        }
    }

    public void K2(boolean show) {
        if (show) {
            m2(getString(R.string.loading));
        }
    }

    public void L2() {
        n2();
    }

    @Override // com.martian.libmars.activity.j1
    public void Z1(String title) {
        ThemeTextView themeTextView = this.L;
        if (themeTextView != null) {
            themeTextView.setText(title);
        }
    }

    @Override // com.martian.libmars.activity.j1
    public void d2(boolean show) {
        if (show) {
            this.K.setVisibility(0);
        } else {
            this.K.setVisibility(8);
        }
    }

    @Override // me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int id) {
        View findViewById = super.findViewById(id);
        return findViewById == null ? h2().findViewById(id) : findViewById;
    }

    public boolean g2() {
        if (this.P) {
            return false;
        }
        this.P = true;
        return true;
    }

    public View h2() {
        if (this.I == null) {
            this.I = this.H.inflate();
        }
        return this.I;
    }

    public int i2() {
        View view = this.M;
        if (view == null) {
            return 0;
        }
        view.measure(0, 0);
        return this.M.getMeasuredHeight();
    }

    public void j2() {
        this.O.setLoadingTip(LoadingTip.LoadStatus.empty);
    }

    public void k2(String reason) {
        this.O.setLoadingTip(LoadingTip.LoadStatus.error);
        if (com.martian.libsupport.k.p(reason)) {
            return;
        }
        this.O.setTips(reason);
    }

    public void l2() {
        this.O.setLoadingTip(LoadingTip.LoadStatus.finish);
    }

    public void m2(String tips) {
        this.O.setLoadingTip(LoadingTip.LoadStatus.loading);
        if (com.martian.libsupport.k.p(tips)) {
            return;
        }
        this.O.setTips(tips);
    }

    public abstract void n2();

    public void o2(float alpha) {
        ThemeTextView themeTextView = this.L;
        if (themeTextView != null) {
            themeTextView.setAlpha(alpha);
        }
    }

    public void onBackClick(View view) {
        finish();
    }

    @Override // com.martian.libmars.activity.j1, com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.F) {
            return;
        }
        L2();
        this.F = true;
    }

    public void p2(int color) {
        this.L.setBackgroundColor(color);
        this.M.setBackgroundColor(color);
    }

    public void q2(int color) {
        this.L.setTextColor(color);
        this.J.setColorFilter(color);
    }

    public void r2() {
        this.H.setPadding(0, ImmersionBar.getActionBarHeight(this), 0, 0);
    }

    public void s2() {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) findViewById(R.id.actionbar_root_view);
        if (themeLinearLayout != null) {
            themeLinearLayout.setBackgroundType(8);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.libmars_retry_loading_activity);
        this.G = (LinearLayout) super.findViewById(R.id.libmars_container_view_layout);
        ViewStub viewStub = (ViewStub) super.findViewById(R.id.libmars_container_view);
        this.H = viewStub;
        viewStub.setLayoutResource(layoutResID);
        this.M = super.findViewById(R.id.libmars_action_bar);
        this.J = (ThemeImageView) super.findViewById(R.id.actionbar_back);
        this.K = (ThemeImageView) super.findViewById(R.id.actionbar_divider);
        ThemeTextView themeTextView = (ThemeTextView) super.findViewById(R.id.actionbar_title);
        this.L = themeTextView;
        themeTextView.setText(getTitle());
        VerticalSwipeRefreshLayout verticalSwipeRefreshLayout = (VerticalSwipeRefreshLayout) super.findViewById(R.id.libmars_str_refresh_layout);
        this.N = verticalSwipeRefreshLayout;
        verticalSwipeRefreshLayout.setColorSchemeResources(com.martian.libmars.d.h.F().t0());
        this.N.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.martian.libmars.activity.d1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                k1.this.n2();
            }
        });
        LoadingTip loadingTip = (LoadingTip) super.findViewById(R.id.loadedTip);
        this.O = loadingTip;
        loadingTip.setOnReloadListener(new LoadingTip.b() { // from class: com.martian.libmars.activity.h
            @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
            public final void a() {
                k1.this.n2();
            }
        });
        F2();
    }

    public void t2(String menu) {
        TextView textView = (TextView) findViewById(R.id.actionbar_action);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(menu);
        }
    }

    public void u2(String menu, Typeface typeface, int textColor) {
        ThemeTextView themeTextView = (ThemeTextView) findViewById(R.id.actionbar_action);
        if (themeTextView != null) {
            themeTextView.setTextColorType(-1);
            themeTextView.setVisibility(0);
            themeTextView.setText(menu);
            if (typeface != null) {
                themeTextView.setTypeface(typeface);
            }
            themeTextView.setTextColor(ContextCompat.getColor(this, textColor));
        }
    }

    public void v2(int resId) {
        ThemeImageView themeImageView = (ThemeImageView) findViewById(R.id.actionbar_action_icon);
        if (themeImageView != null) {
            themeImageView.setVisibility(0);
            themeImageView.setImageResource(resId);
        }
    }

    public void w2(int activityMode) {
        if (activityMode == B) {
            o2(0.0f);
            d2(false);
            s2();
            z2();
            return;
        }
        if (activityMode == C) {
            I2(false);
            z2();
            return;
        }
        if (activityMode == D) {
            s2();
            this.L.setBackgroundType(0);
            this.L.setTextColorType(-1);
            this.J.setEnableFilter(false);
            return;
        }
        if (activityMode == E) {
            this.L.setBackgroundType(0);
            this.L.setTextColorType(-1);
            this.J.setColorFilterType(5);
            q2(ContextCompat.getColor(this, R.color.white));
            p2(ContextCompat.getColor(this, R.color.transparent));
            d2(false);
            s2();
            z2();
        }
    }

    public void x2(float alpha) {
        this.M.setAlpha(alpha);
    }

    public void y2() {
        this.H.setPadding(0, ImmersionBar.getActionBarHeight(this) + ImmersionBar.getStatusBarHeight(this), 0, 0);
    }

    public void z2() {
        this.G.setPadding(0, 0, 0, 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void setContentView(View view) {
        throw new IllegalStateException("Should not call this function");
    }
}
