package com.martian.libmars.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.SearchRecentSuggestions;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import ba.g;
import ba.l;
import com.baidu.mobads.sdk.internal.am;
import com.gyf.immersionbar.b;
import com.martian.libmars.R;
import com.martian.libmars.activity.BaseActivity;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.common.SearchSuggestionProvider;
import l9.l0;
import l9.p0;
import l9.t0;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import me.jessyan.autosize.internal.CustomAdapt;
import vi.d;

/* loaded from: classes3.dex */
public class BaseActivity extends SwipeBackActivity implements CustomAdapt {

    /* renamed from: l */
    public static final int f12018l = 885;

    /* renamed from: m */
    public static final int f12019m = 886;

    /* renamed from: n */
    public static final int f12020n = 5894;

    /* renamed from: o */
    public static final int f12021o = 5890;

    /* renamed from: p */
    public static final int f12022p = 5888;

    /* renamed from: q */
    public static final int f12023q = 4866;

    /* renamed from: c */
    public ValueCallback f12024c;

    /* renamed from: i */
    public String f12030i;

    /* renamed from: j */
    public View f12031j;

    /* renamed from: d */
    public Uri f12025d = null;

    /* renamed from: e */
    public a f12026e = null;

    /* renamed from: f */
    public boolean f12027f = true;

    /* renamed from: g */
    public boolean f12028g = false;

    /* renamed from: h */
    public boolean f12029h = false;

    /* renamed from: k */
    public boolean f12032k = false;

    public interface a {
        void a(Uri uri, String str);

        void onCancelled();
    }

    public static void F1(View view, boolean z10, boolean z11) {
        if (z10) {
            view.setSystemUiVisibility(f12020n);
        } else if (z11) {
            view.setSystemUiVisibility(f12022p);
        } else {
            view.setSystemUiVisibility(f12021o);
        }
    }

    public void A1(String str) {
        new SearchRecentSuggestions(this, SearchSuggestionProvider.f12121b, 1).saveRecentQuery(str, null);
    }

    public void B1(int i10) {
        if (i10 < 5) {
            i10 = 5;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = i10 / 255.0f;
        getWindow().setAttributes(attributes);
    }

    public void C1(boolean z10) {
        this.f12028g = z10;
    }

    public void D1(String str) {
        this.f12030i = str;
    }

    public void E1(boolean z10, boolean z11, boolean z12) {
        if (z10) {
            getWindow().addFlags(1024);
            getWindow().clearFlags(2048);
        } else {
            getWindow().addFlags(2048);
            getWindow().clearFlags(1024);
        }
        if (z11) {
            View decorView = getWindow().getDecorView();
            this.f12031j = decorView;
            F1(decorView, z10, z12);
        }
    }

    public void G1(a aVar) {
        this.f12026e = aVar;
    }

    public void H1() {
        setRequestedOrientation(1);
    }

    @Deprecated
    public void I1(int i10, boolean z10) {
    }

    @Deprecated
    public void J1(int i10) {
        I1(getResources().getColor(i10), false);
    }

    @Deprecated
    public void K1(int i10) {
        I1(getResources().getColor(i10), true);
    }

    @Deprecated
    public void L1() {
        getWindow().setFlags(67108864, 67108864);
    }

    public void M1(boolean z10) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (z10) {
            attributes.flags |= 768;
        } else {
            attributes.flags &= -769;
        }
        getWindow().setAttributes(attributes);
    }

    public void N1() {
        getWindow().setFlags(1024, 1024);
    }

    public void O1() {
        supportRequestWindowFeature(1);
    }

    public void P0() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 886);
    }

    public void P1(String str) {
        if (l.q(str) || isFinishing()) {
            return;
        }
        t0.a(this, str);
    }

    public void Q1(String str) {
        if (l.q(str) || isFinishing()) {
            return;
        }
        t0.a(this, str);
    }

    public void R1(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public void S1(String str) {
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + str));
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public void T1(String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public void U1() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName()));
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void V1(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void W1(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName()));
            intent.setPackage(str);
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void X1() {
        onSearchRequested();
    }

    public void Y1(Bundle bundle) {
        super.startSearch(null, false, bundle, false);
    }

    public void Z1(String str) {
        super.startSearch(str, false, null, false);
    }

    public void a1(String str) {
        p0.b(str);
    }

    public void a2(String str) {
        b2(getString(R.string.share_title), str);
    }

    public void b1() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = -1.0f;
        getWindow().setAttributes(attributes);
    }

    public void b2(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(am.f6739e);
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.setFlags(268435456);
        startActivity(Intent.createChooser(intent, str));
    }

    public void c1() {
        super.finish();
        v1();
    }

    public boolean d1(String str, boolean z10) {
        Bundle extras = getIntent().getExtras();
        return extras != null ? extras.getBoolean(str, z10) : z10;
    }

    public int e1() {
        try {
            return Settings.System.getInt(getContentResolver(), "screen_brightness");
        } catch (Exception unused) {
            return -1;
        }
    }

    public boolean f1() {
        return this.f12028g;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        v1();
    }

    public int g1(String str, int i10) {
        Bundle extras = getIntent().getExtras();
        return extras != null ? extras.getInt(str, i10) : i10;
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public float getSizeInDp() {
        return 360.0f;
    }

    public Long h1(String str, long j10) {
        Bundle extras = getIntent().getExtras();
        return extras != null ? Long.valueOf(extras.getLong(str, j10)) : Long.valueOf(j10);
    }

    public final String i1(Uri uri) {
        return l0.b(this, uri);
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public boolean isBaseOnWidth() {
        return this.f12027f;
    }

    public int j1() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    public int k1() {
        return Math.min(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
    }

    public int l1() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    public Bundle m1() {
        return getIntent().getBundleExtra("app_data");
    }

    public String n1() {
        return getIntent().getStringExtra("query");
    }

    public String o1(String str) {
        Bundle m12 = m1();
        if (m12 != null) {
            return m12.getString(str);
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 885) {
            if (i11 == -1) {
                r1(this.f12025d);
                return;
            } else {
                this.f12024c.onReceiveValue(null);
                this.f12024c = null;
                return;
            }
        }
        if (i10 == 886) {
            if (i11 != -1) {
                this.f12024c.onReceiveValue(null);
                this.f12024c = null;
            } else {
                Uri data = intent.getData();
                this.f12025d = data;
                r1(data);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i10 = configuration.orientation;
        if (i10 == 1) {
            this.f12027f = true;
        } else {
            if (i10 != 2) {
                return;
            }
            this.f12027f = false;
        }
    }

    @Override // me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12030i = getString(R.string.one_more_click_to_exit);
        Configuration configuration = getResources().getConfiguration();
        if (configuration != null) {
            this.f12027f = configuration.orientation == 1;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (!this.f12028g || this.f12029h) {
            return super.onKeyDown(i10, keyEvent);
        }
        u1();
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f12032k = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f12032k = true;
    }

    public int p1() {
        int identifier = getResources().getIdentifier(b.f10638c, "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public String q1(String str) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getString(str);
        }
        return null;
    }

    public final void r1(Uri uri) {
        if (uri != null) {
            String i12 = "content".equals(uri.getScheme()) ? i1(uri) : uri.getPath();
            a aVar = this.f12026e;
            if (aVar != null) {
                aVar.a(uri, i12);
            }
        } else {
            a aVar2 = this.f12026e;
            if (aVar2 != null) {
                aVar2.onCancelled();
            }
        }
        this.f12025d = null;
    }

    public boolean s1() {
        return this.f12032k;
    }

    public void startActivity(Class<? extends Activity> cls) {
        startActivity(new Intent(this, cls));
    }

    public void startActivityForResult(Class<? extends Activity> cls, Bundle bundle, int i10) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivityForResult(intent, i10);
    }

    public final /* synthetic */ void t1() {
        this.f12029h = false;
    }

    public void u1() {
        this.f12029h = true;
        P1(this.f12030i);
        new Handler().postDelayed(new Runnable() { // from class: d9.a
            public /* synthetic */ a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.this.t1();
            }
        }, 3000L);
    }

    public void v1() {
    }

    public void w1(String str) {
        try {
            Uri z10 = g.z(this, g.l("martian_", ".jpeg", str));
            this.f12025d = z10;
            if (z10 == null) {
                return;
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", this.f12025d);
            startActivityForResult(intent, 885);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void x1(String str, ValueCallback valueCallback) {
        this.f12024c = valueCallback;
        w1(str);
    }

    public void y1(ValueCallback valueCallback) {
        this.f12024c = valueCallback;
        P0();
    }

    public void z1() {
        if (ConfigSingleton.D().r().equalsIgnoreCase("Play")) {
            org.codechimp.apprater.a.m(new d());
            org.codechimp.apprater.a.g(this);
        } else {
            org.codechimp.apprater.a.m(new d());
            org.codechimp.apprater.a.g(this);
        }
    }

    public void startActivity(Class<? extends Activity> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void startActivityForResult(Class<? extends Activity> cls, int i10) {
        startActivityForResult(new Intent(this, cls), i10);
    }
}
