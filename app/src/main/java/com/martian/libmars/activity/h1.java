package com.martian.libmars.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.SearchRecentSuggestions;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.martian.libmars.R;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.lang.reflect.Method;
import me.jessyan.autosize.internal.CustomAdapt;

/* loaded from: classes.dex */
public class h1 extends me.imid.swipebacklayout.lib.d.a implements CustomAdapt {

    /* renamed from: b */
    private static final int f9780b = 885;

    /* renamed from: c */
    private static final int f9781c = 886;

    /* renamed from: d */
    public static final int f9782d = 5894;

    /* renamed from: e */
    public static final int f9783e = 5890;

    /* renamed from: f */
    public static final int f9784f = 5888;

    /* renamed from: g */
    public static final int f9785g = 4866;
    private String m;
    public View n;

    /* renamed from: h */
    Uri f9786h = null;

    /* renamed from: i */
    private a f9787i = null;

    /* renamed from: j */
    public boolean f9788j = true;
    private boolean k = false;
    protected boolean l = false;
    private int o = -1;
    private boolean p = false;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Uri uri, String filepath);

        void onCancelled();
    }

    private void H0(Uri imgUri) {
        if (imgUri != null) {
            String y0 = "content".equals(imgUri.getScheme()) ? y0(imgUri) : imgUri.getPath();
            a aVar = this.f9787i;
            if (aVar != null) {
                aVar.a(imgUri, y0);
            }
        } else {
            a aVar2 = this.f9787i;
            if (aVar2 != null) {
                aVar2.onCancelled();
            }
        }
        this.f9786h = null;
    }

    @TargetApi(14)
    private boolean I0() {
        String str = "";
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class);
                declaredMethod.setAccessible(true);
                str = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
            }
        }
        Resources resources = getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", BaseWrapper.BASE_PKG_SYSTEM);
        if (identifier == 0) {
            return !ViewConfiguration.get(this).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        if ("1".equals(str)) {
            return false;
        }
        if ("0".equals(str)) {
            return true;
        }
        return z;
    }

    public static boolean L0(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return com.martian.libsupport.l.n() ? !activity.isDestroyed() : !activity.isFinishing();
    }

    private boolean M0() {
        return (getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    /* renamed from: N0 */
    public /* synthetic */ void O0() {
        this.l = false;
    }

    public static void Z0(View v, boolean fullscreen, boolean showVirtualKey) {
        if (fullscreen) {
            v.setSystemUiVisibility(f9782d);
        } else if (showVirtualKey) {
            v.setSystemUiVisibility(f9784f);
        } else {
            v.setSystemUiVisibility(f9783e);
        }
    }

    @TargetApi(11)
    public static void a1(View v, boolean alwaysShowStatusBar, boolean showvirtualkey) {
        if (alwaysShowStatusBar) {
            v.setSystemUiVisibility(f9785g);
        } else if (showvirtualkey) {
            v.setSystemUiVisibility(f9784f);
        } else {
            v.setSystemUiVisibility(f9783e);
        }
    }

    private String y0(Uri contentUri) {
        return com.martian.libmars.utils.m0.b(this, contentUri);
    }

    public int A0() {
        return Math.min(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
    }

    public int B0() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    public Bundle C0() {
        return getIntent().getBundleExtra("app_data");
    }

    public String D0() {
        return getIntent().getStringExtra("query");
    }

    public String E0(String key) {
        Bundle C0 = C0();
        if (C0 != null) {
            return C0.getString(key);
        }
        return null;
    }

    public int F0() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", BaseWrapper.BASE_PKG_SYSTEM);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public String G0(String key) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getString(key);
        }
        return null;
    }

    public void J0(boolean enableImmersive, boolean hideStatusBarLayout, boolean hideNavigationLayout) {
        getWindow().addFlags(1024);
        getWindow().clearFlags(2048);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16) {
            return;
        }
        int i3 = 256;
        if (i2 >= 19 && enableImmersive) {
            i3 = 2304;
        }
        if (hideStatusBarLayout) {
            i3 |= DownloadErrorCode.ERROR_SAVE_PATH_EMPTY;
        }
        if (hideNavigationLayout) {
            i3 |= 514;
        }
        getWindow().getDecorView().setSystemUiVisibility(i3);
    }

    public boolean K0() {
        return this.p;
    }

    protected void P0() {
        this.l = true;
        k1(this.m);
        new Handler().postDelayed(new Runnable() { // from class: com.martian.libmars.activity.c
            @Override // java.lang.Runnable
            public final void run() {
                h1.this.O0();
            }
        }, 3000L);
    }

    protected void Q0() {
    }

    protected void R0(String dir) {
        try {
            Uri z = com.martian.libsupport.e.z(this, com.martian.libsupport.e.l("martian_", ".jpeg", dir));
            this.f9786h = z;
            if (z == null) {
                return;
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", this.f9786h);
            startActivityForResult(intent, f9780b);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S0() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, f9781c);
    }

    public void T0() {
        if (com.martian.libmars.d.h.F().m().equalsIgnoreCase("Play")) {
            org.codechimp.apprater.b.m(new org.codechimp.apprater.e());
            org.codechimp.apprater.b.g(this);
        } else {
            org.codechimp.apprater.b.m(new org.codechimp.apprater.e());
            org.codechimp.apprater.b.g(this);
        }
    }

    public void U0(String query) {
        new SearchRecentSuggestions(this, com.martian.libmars.d.j.f9893a, 1).saveRecentQuery(query, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V0(int brightness) {
        if (brightness < 5) {
            brightness = 5;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = brightness / 255.0f;
        getWindow().setAttributes(attributes);
    }

    public void W0(boolean enabled) {
        this.k = enabled;
    }

    public void X0(String msg) {
        this.m = msg;
    }

    protected void Y0(final boolean fullscreen, boolean enableImmersion, final boolean showvirtualkey) {
        if (!com.martian.libsupport.l.p()) {
            getWindow().addFlags(1024);
            getWindow().clearFlags(2048);
            return;
        }
        if (fullscreen) {
            getWindow().addFlags(1024);
            getWindow().clearFlags(2048);
        } else {
            getWindow().addFlags(2048);
            getWindow().clearFlags(1024);
        }
        if (enableImmersion) {
            View decorView = getWindow().getDecorView();
            this.n = decorView;
            Z0(decorView, fullscreen, showvirtualkey);
        }
    }

    public void b1(a l) {
        this.f9787i = l;
    }

    public void c1() {
        setRequestedOrientation(1);
    }

    @Deprecated
    public void d1(int color, boolean actionBarOverlay) {
    }

    @Deprecated
    public void e1(int statusBarColorId) {
        d1(getResources().getColor(statusBarColorId), false);
    }

    @Deprecated
    public void f1(int statusBarColorId) {
        d1(getResources().getColor(statusBarColorId), true);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        Q0();
    }

    @Deprecated
    public void g1() {
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setFlags(67108864, 67108864);
        }
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public float getSizeInDp() {
        return 360.0f;
    }

    protected void h1(boolean layoutInScreen) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (layoutInScreen) {
            attributes.flags |= 768;
        } else {
            attributes.flags &= -769;
        }
        getWindow().setAttributes(attributes);
    }

    protected void i1() {
        getWindow().setFlags(1024, 1024);
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public boolean isBaseOnWidth() {
        return this.f9788j;
    }

    protected void j1() {
        supportRequestWindowFeature(1);
    }

    public void k1(String msg) {
        if (com.martian.libsupport.k.p(msg)) {
            return;
        }
        e.a.a.a.e.b(getApplicationContext(), msg, 0).show();
    }

    public void l1(String msg) {
        if (com.martian.libsupport.k.p(msg)) {
            return;
        }
        e.a.a.a.e.b(getApplicationContext(), msg, 1).show();
    }

    public void m1(boolean hideStatusBarLayout, boolean hideNavigationLayout) {
        getWindow().addFlags(2048);
        getWindow().clearFlags(1024);
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        int i2 = hideStatusBarLayout ? TTAdConstant.EXT_PLUGIN_UNINSTALL : 256;
        if (hideNavigationLayout) {
            i2 |= 512;
        }
        getWindow().getDecorView().setSystemUiVisibility(i2);
    }

    public void n1(String url) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        startActivity(intent);
    }

    public void o1(String phonenumber) {
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + phonenumber));
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        startActivity(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == f9780b && resultCode == -1) {
            H0(this.f9786h);
        } else if (requestCode == f9781c && resultCode == -1) {
            Uri data2 = data.getData();
            this.f9786h = data2;
            H0(data2);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int i2 = newConfig.orientation;
        if (i2 == 1) {
            this.f9788j = true;
        } else {
            if (i2 != 2) {
                return;
            }
            this.f9788j = false;
        }
    }

    @Override // me.imid.swipebacklayout.lib.d.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.m = getString(R.string.one_more_click_to_exit);
        Configuration configuration = getResources().getConfiguration();
        if (configuration != null) {
            this.f9788j = configuration.orientation == 1;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        if (!this.k || this.l) {
            return super.onKeyDown(keyCode, event);
        }
        P0();
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.p = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.p = true;
    }

    public void p0() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = -1.0f;
        getWindow().setAttributes(attributes);
    }

    public void p1(String phonenumber) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + phonenumber));
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        startActivity(intent);
    }

    public void q0() {
        super.finish();
        Q0();
    }

    public void q1() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + getPackageName()));
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public boolean r0(String key, boolean defaultVal) {
        Bundle extras = getIntent().getExtras();
        return extras != null ? extras.getBoolean(key, defaultVal) : defaultVal;
    }

    public void r1(String packageName) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + packageName));
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    protected int s0() {
        try {
            return Settings.System.getInt(getContentResolver(), "screen_brightness");
        } catch (Exception unused) {
            return -1;
        }
    }

    public void s1(String marketPackage) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + getPackageName()));
            intent.setPackage(marketPackage);
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void startActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    public void startActivityForResult(Class<? extends Activity> clazz, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
    }

    public int t0(int attr) {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(attr, typedValue, true);
        return ContextCompat.getColor(this, typedValue.resourceId);
    }

    public void t1() {
        onSearchRequested();
    }

    public boolean u0() {
        return this.k;
    }

    public void u1(Bundle bundle) {
        super.startSearch(null, false, bundle, false);
    }

    public void v(String msg) {
        com.martian.libmars.utils.q0.e(msg);
    }

    public int v0(String key, int defaultVal) {
        Bundle extras = getIntent().getExtras();
        return extras != null ? extras.getInt(key, defaultVal) : defaultVal;
    }

    public void v1(String query) {
        super.startSearch(query, false, null, false);
    }

    public Long w0(String key, long defaultVal) {
        Bundle extras = getIntent().getExtras();
        return extras != null ? Long.valueOf(extras.getLong(key, defaultVal)) : Long.valueOf(defaultVal);
    }

    public void w1(String text) {
        x1(getString(R.string.share_title), text);
    }

    @TargetApi(14)
    public int x0() {
        int identifier;
        if (Build.VERSION.SDK_INT < 19) {
            return 0;
        }
        int i2 = this.o;
        if (i2 != -1) {
            return i2;
        }
        this.o = 0;
        if (I0()) {
            int i3 = getResources().getConfiguration().orientation;
            if (M0()) {
                identifier = getResources().getIdentifier(i3 != 1 ? "navigation_bar_height_landscape" : "navigation_bar_height", "dimen", BaseWrapper.BASE_PKG_SYSTEM);
            } else {
                identifier = getResources().getIdentifier(i3 != 1 ? "navigation_bar_width" : "navigation_bar_height", "dimen", BaseWrapper.BASE_PKG_SYSTEM);
            }
            if (identifier > 0) {
                this.o = getResources().getDimensionPixelSize(identifier);
            }
        }
        return this.o;
    }

    public void x1(String title, String text) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", title);
        intent.putExtra("android.intent.extra.TEXT", text);
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        startActivity(Intent.createChooser(intent, title));
    }

    public int z0() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    public void startActivity(Class<? extends Activity> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void startActivityForResult(Class<? extends Activity> clazz, int requestCode) {
        startActivityForResult(new Intent(this, clazz), requestCode);
    }
}
