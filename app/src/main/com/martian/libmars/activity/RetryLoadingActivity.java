package com.martian.libmars.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ba.l;
import com.gyf.immersionbar.d;
import com.martian.libmars.R;
import com.martian.libmars.activity.RetryLoadingActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.VerticalSwipeRefreshLayout;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.recyclerview.LoadingTip;

/* loaded from: classes3.dex */
public abstract class RetryLoadingActivity extends MartianActivity {
    public static int H = 1;
    public static int I = 2;
    public static int J = 3;
    public static int K = 4;
    public ThemeImageView A;
    public ThemeImageView B;
    public ThemeTextView C;
    public View D;
    public LoadingTip F;

    /* renamed from: x */
    public LinearLayout f12061x;

    /* renamed from: y */
    public ViewStub f12062y;

    /* renamed from: z */
    public View f12063z;

    /* renamed from: w */
    public boolean f12060w = false;
    public VerticalSwipeRefreshLayout E = null;
    public boolean G = false;

    public ViewStub A2() {
        return (ViewStub) findViewById(R.id.actionbar_container);
    }

    public ThemeTextView B2() {
        if (this.C == null) {
            this.C = (ThemeTextView) super.findViewById(R.id.actionbar_title);
        }
        return this.C;
    }

    public View C2() {
        ViewStub viewStub;
        if (this.f12063z == null && (viewStub = this.f12062y) != null) {
            this.f12063z = viewStub.inflate();
        }
        return this.f12063z;
    }

    public MagicIndicator D2() {
        return (MagicIndicator) findViewById(R.id.magic_indicator);
    }

    public int E2() {
        View view = this.D;
        if (view == null) {
            return 0;
        }
        view.measure(0, 0);
        return this.D.getMeasuredHeight();
    }

    public void F2() {
        this.F.setLoadingTip(LoadingTip.LoadStatus.empty);
    }

    public void G2(String str) {
        this.F.setLoadingTip(LoadingTip.LoadStatus.network_error);
        if (l.q(str)) {
            return;
        }
        this.F.setTips(str);
    }

    public void H2() {
        this.F.setLoadingTip(LoadingTip.LoadStatus.finish);
    }

    public void I2(String str) {
        this.F.setLoadingTip(LoadingTip.LoadStatus.loading);
        if (l.q(str)) {
            return;
        }
        this.F.setTips(str);
    }

    public abstract void J2();

    public void K2(float f10) {
        B2().setAlpha(f10);
    }

    public void L2(int i10) {
        B2().setBackgroundColor(i10);
        this.D.setBackgroundColor(i10);
    }

    public void M2(int i10) {
        B2().setTextColor(i10);
        z2().setColorFilter(i10);
    }

    public void N2() {
        this.f12062y.setPadding(0, d.i0(this), 0, 0);
    }

    public void O2() {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) findViewById(R.id.actionbar_root_view);
        if (themeLinearLayout != null) {
            themeLinearLayout.setBackgroundType(8);
        }
    }

    public void P2(String str) {
        TextView textView = (TextView) findViewById(R.id.actionbar_action);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    public void Q2(String str, Typeface typeface, int i10) {
        ThemeTextView themeTextView = (ThemeTextView) findViewById(R.id.actionbar_action);
        if (themeTextView != null) {
            themeTextView.setTextColorType(-1);
            themeTextView.setVisibility(0);
            themeTextView.setText(str);
            if (typeface != null) {
                themeTextView.setTypeface(typeface);
            }
            themeTextView.setTextColor(ContextCompat.getColor(this, i10));
        }
    }

    public void R2(int i10) {
        ThemeImageView themeImageView = (ThemeImageView) findViewById(R.id.actionbar_action_icon);
        if (themeImageView != null) {
            themeImageView.setVisibility(0);
            themeImageView.setImageResource(i10);
        }
    }

    public void S2(int i10) {
        if (i10 == H) {
            K2(0.0f);
            v2(false);
            O2();
            V2();
            return;
        }
        if (i10 == I) {
            d3(false);
            V2();
            return;
        }
        if (i10 == J) {
            O2();
            B2().setBackgroundType(0);
            B2().setTextColorType(-1);
            z2().setEnableFilter(false);
            return;
        }
        if (i10 == K) {
            B2().setBackgroundType(0);
            B2().setTextColorType(-1);
            z2().setColorFilterType(5);
            M2(ContextCompat.getColor(this, R.color.white));
            L2(ContextCompat.getColor(this, R.color.transparent));
            v2(false);
            O2();
            V2();
        }
    }

    public void T2(float f10) {
        this.D.setAlpha(f10);
    }

    public void U2() {
        this.f12062y.setPadding(0, d.i0(this) + d.H0(this), 0, 0);
    }

    public void V2() {
        this.f12061x.setPadding(0, 0, 0, 0);
    }

    public void W2(int i10) {
        this.E.setColorSchemeResources(i10);
    }

    public void X2() {
        if (this.E.isRefreshing()) {
            this.E.setRefreshing(false);
            P1("更新完毕");
        }
        this.G = false;
    }

    public void Y2(boolean z10) {
        VerticalSwipeRefreshLayout verticalSwipeRefreshLayout = this.E;
        if (verticalSwipeRefreshLayout != null) {
            verticalSwipeRefreshLayout.setEnabled(z10);
        }
    }

    public void Z2(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        this.E.setOnRefreshListener(onRefreshListener);
    }

    public void a3(boolean z10) {
        this.E.setRefreshing(z10);
    }

    public void b3() {
        d.q3(this).V2(R.id.actionbar_top_view).a1();
        this.f12061x.setPadding(0, d.H0(this) + d.i0(this), 0, 0);
    }

    public void c3(boolean z10) {
        super.u2(z10);
        if (z10) {
            U2();
        }
    }

    public void d3(boolean z10) {
        View view = this.D;
        if (view == null) {
            return;
        }
        if (z10) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public void e3(boolean z10) {
        if (z10) {
            z2().setVisibility(0);
        } else {
            z2().setVisibility(8);
        }
    }

    public void f3(boolean z10) {
        if (z10) {
            I2(getString(R.string.loading));
        }
    }

    @Override // me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public View findViewById(int i10) {
        View C2;
        View findViewById = super.findViewById(i10);
        return (findViewById != null || (C2 = C2()) == null) ? findViewById : C2.findViewById(i10);
    }

    public void g3() {
        J2();
    }

    public void onBackClick(View view) {
        finish();
    }

    @Override // com.martian.libmars.activity.MartianActivity, com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.f12060w) {
            return;
        }
        g3();
        this.f12060w = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        super.setContentView(R.layout.libmars_retry_loading_activity);
        this.f12061x = (LinearLayout) super.findViewById(R.id.libmars_container_view_layout);
        ViewStub viewStub = (ViewStub) super.findViewById(R.id.libmars_container_view);
        this.f12062y = viewStub;
        viewStub.setLayoutResource(i10);
        this.D = super.findViewById(R.id.libmars_action_bar);
        this.B = (ThemeImageView) super.findViewById(R.id.actionbar_divider);
        B2().setText(getTitle());
        VerticalSwipeRefreshLayout verticalSwipeRefreshLayout = (VerticalSwipeRefreshLayout) super.findViewById(R.id.libmars_str_refresh_layout);
        this.E = verticalSwipeRefreshLayout;
        verticalSwipeRefreshLayout.setColorSchemeResources(ConfigSingleton.D().l0());
        this.E.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: d9.j
            public /* synthetic */ j() {
            }

            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                RetryLoadingActivity.this.J2();
            }
        });
        LoadingTip loadingTip = (LoadingTip) super.findViewById(R.id.loadedTip);
        this.F = loadingTip;
        loadingTip.setOnReloadListener(new LoadingTip.b() { // from class: d9.k
            public /* synthetic */ k() {
            }

            @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
            public final void a() {
                RetryLoadingActivity.this.J2();
            }
        });
        b3();
    }

    @Override // com.martian.libmars.activity.MartianActivity
    public void t2(String str) {
        B2().setText(str);
    }

    @Override // com.martian.libmars.activity.MartianActivity
    public void v2(boolean z10) {
        if (z10) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
    }

    public boolean y2() {
        if (this.G) {
            return false;
        }
        this.G = true;
        return true;
    }

    public ThemeImageView z2() {
        if (this.A == null) {
            this.A = (ThemeImageView) super.findViewById(R.id.actionbar_back);
        }
        return this.A;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        throw new IllegalStateException("Should not call this function");
    }
}
