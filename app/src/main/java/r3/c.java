package r3;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public abstract class c extends FrameLayout {

    /* renamed from: d */
    public static final String f30241d = "v1";

    /* renamed from: e */
    public static final String f30242e = "v2";

    /* renamed from: b */
    public Activity f30243b;

    /* renamed from: c */
    public final String f30244c;

    public c(Activity activity, String str) {
        super(activity);
        this.f30243b = activity;
        this.f30244c = str;
    }

    public static void j(WebView webView) {
        if (webView != null) {
            try {
                webView.resumeTimers();
            } catch (Throwable unused) {
            }
        }
    }

    public abstract void k(String str);

    public void l(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        CookieSyncManager.createInstance(this.f30243b.getApplicationContext()).sync();
        CookieManager.getInstance().setCookie(str, str2);
        CookieSyncManager.getInstance().sync();
    }

    public boolean m() {
        return f30241d.equals(this.f30244c);
    }

    public abstract boolean n();

    public abstract void o();
}
