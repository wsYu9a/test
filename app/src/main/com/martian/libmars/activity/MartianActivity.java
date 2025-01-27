package com.martian.libmars.activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import com.gyf.immersionbar.d;
import com.martian.libmars.R;
import com.martian.libmars.activity.MartianActivity;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.umeng.analytics.MobclickAgent;
import k9.b;

/* loaded from: classes3.dex */
public class MartianActivity extends BaseActivity implements b {

    /* renamed from: r */
    public boolean f12036r = true;

    /* renamed from: s */
    public long f12037s = -1;

    /* renamed from: t */
    public int f12038t = 0;

    /* renamed from: u */
    public int f12039u = 0;

    /* renamed from: v */
    public ProgressDialog f12040v;

    public interface a {
        void a(String str);
    }

    private void q2() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.night_mask);
        if (frameLayout != null) {
            ((ViewGroup) findViewById(android.R.id.content)).removeView(frameLayout);
        }
    }

    @Override // k9.b
    public void A0() {
        ConfigSingleton.D().q1();
        k2();
        w2();
    }

    public void e2() {
        boolean z10 = (getResources().getConfiguration().uiMode & 48) == 32;
        if (ConfigSingleton.D().A0() != z10) {
            p2(z10);
        }
    }

    public void f2(boolean z10) {
        d.q3(this).T2(z10).G1(z10).v1(ConfigSingleton.D().L(), 0.0f).a1();
    }

    public void g2() {
    }

    public boolean h2() {
        return this.f12036r;
    }

    public long i2() {
        return System.currentTimeMillis() + MTHttpGetParams.diffServerTime;
    }

    public final void j2(Intent intent) {
        if (this instanceof a) {
            new Handler().post(new Runnable() { // from class: d9.b

                /* renamed from: c */
                public final /* synthetic */ String f25294c;

                public /* synthetic */ b(String str) {
                    stringExtra = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MartianActivity.this.m2(stringExtra);
                }
            });
        }
    }

    public void k2() {
        boolean A0 = ConfigSingleton.D().A0();
        d.q3(this).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
    }

    public final boolean l2(Intent intent) {
        return "android.intent.action.SEARCH".equals(intent.getAction());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void m2(String str) {
        ((a) this).a(str);
    }

    public final /* synthetic */ void n2() {
        j2(getIntent());
    }

    public void o2() {
        if (f1()) {
            c1();
        } else {
            finish();
        }
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i10 = configuration.uiMode & 48;
        if (i10 == 16) {
            p2(false);
        } else {
            if (i10 != 32) {
                return;
            }
            p2(true);
        }
    }

    @Override // com.martian.libmars.activity.BaseActivity, me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (l2(getIntent()) && bundle == null) {
            new Handler().post(new Runnable() { // from class: d9.c
                public /* synthetic */ c() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MartianActivity.this.n2();
                }
            });
        }
        k2();
        w2();
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    public boolean onCreateOptionsMenu(Menu menu) {
        s2();
        return true;
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        q2();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        setIntent(intent);
        super.onNewIntent(intent);
        if (l2(intent)) {
            j2(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (!this.f12036r || menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        o2();
        return true;
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (ConfigSingleton.D().V0()) {
            MobclickAgent.onPause(this);
        }
        x2();
    }

    @Override // com.martian.libmars.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (ConfigSingleton.D().V0()) {
            MobclickAgent.onResume(this);
        }
        this.f12037s = i2();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public void p2(boolean z10) {
        ConfigSingleton.D().b1(z10);
        A0();
    }

    public void r2() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
    }

    public void s2() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.setNavigationMode(this.f12039u);
        r2();
    }

    public void t2(String str) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(str);
        } else {
            a1("Null Action Bar");
        }
    }

    public void u2(boolean z10) {
        this.f12036r = z10;
        if (z10) {
            overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        }
    }

    @Override // com.martian.libmars.activity.BaseActivity
    public void v1() {
        super.v1();
        if (h2()) {
            overridePendingTransition(R.anim.activity_back_in, R.anim.activity_back_out);
        }
    }

    public void v2(boolean z10) {
        ThemeImageView themeImageView = (ThemeImageView) findViewById(R.id.actionbar_divider);
        if (themeImageView != null) {
            if (z10) {
                themeImageView.setVisibility(0);
            } else {
                themeImageView.setVisibility(8);
            }
        }
    }

    public void w2() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.night_mask);
        if (!ConfigSingleton.D().H0()) {
            if (frameLayout == null) {
                return;
            }
            frameLayout.setVisibility(8);
        } else {
            if (frameLayout == null) {
                frameLayout = new FrameLayout(this);
                frameLayout.setId(R.id.night_mask);
                frameLayout.setBackgroundColor(getResources().getColor(R.color.semi_transparent_dark));
                getWindow().addContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            frameLayout.setVisibility(0);
        }
    }

    public void x2() {
        if (this.f12037s > 0) {
            this.f12038t = (int) (this.f12038t + ((i2() - this.f12037s) / 1000));
        }
        this.f12037s = i2();
    }

    public void y(boolean z10, String str) {
        if (isDestroyed()) {
            return;
        }
        if (this.f12040v == null) {
            this.f12040v = new ProgressDialog(this);
        }
        this.f12040v.setMessage(str);
        if (z10) {
            this.f12040v.show();
        } else {
            this.f12040v.dismiss();
        }
    }
}
