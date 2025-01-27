package com.martian.libmars.activity;

import android.R;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.OSUtils;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.widget.OnSwipeTouchListener;
import com.umeng.analytics.MobclickAgent;

/* loaded from: classes.dex */
public class j1 extends h1 implements g.b {
    private ProgressDialog A;
    private int s;
    protected MenuItem x;
    protected SearchView y;
    private boolean q = true;
    private boolean r = false;
    private boolean t = false;
    private long u = -1;
    protected int v = 0;
    private final OnSwipeTouchListener w = null;
    protected int z = 0;

    /* loaded from: classes2.dex */
    public interface a {
        void a(final String query);
    }

    private boolean J1(Intent intent) {
        if (!(this instanceof a)) {
            return false;
        }
        final String stringExtra = intent.getStringExtra("query");
        new Handler().post(new Runnable() { // from class: com.martian.libmars.activity.e
            @Override // java.lang.Runnable
            public final void run() {
                j1.this.Q1(stringExtra);
            }
        });
        return true;
    }

    private boolean O1(Intent intent) {
        boolean equals = "android.intent.action.SEARCH".equals(intent.getAction());
        this.t = equals;
        return equals;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: P1 */
    public /* synthetic */ void Q1(final String query) {
        ((a) this).a(query);
    }

    /* renamed from: R1 */
    public /* synthetic */ void S1() {
        J1(getIntent());
    }

    public void A1(boolean darkMode) {
        ImmersionBar.with(this).statusBarDarkFont(darkMode).init();
    }

    public void B1() {
    }

    public int C1() {
        TypedValue typedValue = new TypedValue();
        if (getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        return 0;
    }

    public boolean D1() {
        return this.q;
    }

    public long E1() {
        return System.currentTimeMillis() + MTHttpGetParams.diffServerTime;
    }

    public int F1() {
        return com.martian.libsupport.l.w(this) ? ImmersionBar.getStatusBarHeight(this) + com.martian.libmars.d.h.b(8.0f) : com.martian.libmars.d.h.b(23.0f);
    }

    public MenuItem G1() {
        return this.x;
    }

    public SearchView H1() {
        return this.y;
    }

    public boolean I1() {
        return this.r;
    }

    public void K1() {
        ImmersionBar.with(this).statusBarDarkFont(!com.martian.libmars.d.h.F().I0()).init();
        if (ImmersionBar.hasNavigationBar(this)) {
            ImmersionBar.with(this).navigationBarColor(com.martian.libmars.d.h.F().T()).init();
        }
    }

    public boolean L1() {
        return this.t;
    }

    public boolean M1() {
        return true;
    }

    public boolean N1() {
        return true;
    }

    @Override // com.martian.libmars.activity.h1
    protected void Q0() {
        super.Q0();
        if (D1()) {
            overridePendingTransition(com.martian.libmars.R.anim.activity_back_in, com.martian.libmars.R.anim.activity_back_out);
        }
    }

    protected void T1() {
        if (u0()) {
            q0();
        } else {
            finish();
        }
    }

    protected void U1(boolean darkMode) {
        com.martian.libmars.d.h.F().o1(darkMode);
        j0();
    }

    public void V1(int resid, Fragment frag) {
        frag.setRetainInstance(true);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(resid, frag);
        beginTransaction.commit();
    }

    public void W1() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
    }

    public void X1() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.setNavigationMode(this.z);
        W1();
    }

    public void Y1() {
        supportRequestWindowFeature(9);
    }

    public void Z1(String title) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(title);
        } else {
            v("Null Action Bar");
        }
    }

    public void a2(boolean backable) {
        this.q = backable;
        if (backable) {
            overridePendingTransition(com.martian.libmars.R.anim.activity_in, com.martian.libmars.R.anim.activity_out);
        }
    }

    public void b2(int resid) {
        this.s = resid;
    }

    public void c2(boolean searchable) {
        this.r = searchable;
        supportInvalidateOptionsMenu();
    }

    public void d2(boolean isShow) {
        ThemeImageView themeImageView = (ThemeImageView) findViewById(com.martian.libmars.R.id.actionbar_divider);
        if (themeImageView != null) {
            if (isShow) {
                themeImageView.setVisibility(0);
            } else {
                themeImageView.setVisibility(8);
            }
        }
    }

    public void e2(boolean loading, String msg) {
        if (this.A == null) {
            this.A = new ProgressDialog(this);
        }
        this.A.setMessage(msg);
        if (loading) {
            this.A.show();
        } else {
            this.A.dismiss();
        }
    }

    protected void f2() {
        if (this.u > 0) {
            this.v = (int) (this.v + ((E1() - this.u) / 1000));
        }
        this.u = E1();
    }

    @Override // g.b
    public void j0() {
        i.a.c(findViewById(R.id.content));
        K1();
        com.martian.libmars.d.h.F().D1(this);
    }

    @Override // com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int i2 = newConfig.uiMode & 48;
        if (i2 == 16) {
            U1(false);
        } else {
            if (i2 != 32) {
                return;
            }
            U1(true);
        }
    }

    @Override // com.martian.libmars.activity.h1, me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (O1(getIntent()) && savedInstanceState == null) {
            new Handler().post(new Runnable() { // from class: com.martian.libmars.activity.f
                @Override // java.lang.Runnable
                public final void run() {
                    j1.this.S1();
                }
            });
        }
        K1();
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.r) {
            z1(menu);
        }
        X1();
        return true;
    }

    @Override // com.martian.libmars.activity.h1, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        super.onNewIntent(intent);
        if (O1(intent)) {
            J1(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (this.q && item.getItemId() == 16908332) {
            T1();
            return true;
        }
        if (!this.r || M1() || item.getItemId() != com.martian.libmars.R.id.action_search) {
            return super.onOptionsItemSelected(item);
        }
        onSearchRequested();
        return true;
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (com.martian.libmars.d.h.F().h1()) {
            MobclickAgent.onPause(this);
        }
        f2();
    }

    @Override // com.martian.libmars.activity.h1, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (com.martian.libmars.d.h.F().h1()) {
            MobclickAgent.onResume(this);
        }
        if (OSUtils.isEMUI3_x()) {
            ImmersionBar.with(this).init();
        }
        this.u = E1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    protected void y1() {
        boolean z = (getResources().getConfiguration().uiMode & 48) == 32;
        if (com.martian.libmars.d.h.F().I0() != z) {
            U1(z);
        }
    }

    @SuppressLint({"NewApi"})
    protected void z1(Menu menu) {
        getMenuInflater().inflate(com.martian.libmars.R.menu.search_view, menu);
        MenuItem findItem = menu.findItem(com.martian.libmars.R.id.action_search);
        this.x = findItem;
        findItem.setIcon(this.s);
        if (M1()) {
            this.y = (SearchView) MenuItemCompat.getActionView(this.x);
            this.y.setSearchableInfo(((SearchManager) getSystemService("search")).getSearchableInfo(getComponentName()));
            this.y.setIconifiedByDefault(true);
        }
    }
}
