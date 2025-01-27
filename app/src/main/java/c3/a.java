package c3;

import a3.f;
import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.bt;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public String f1692a;

    /* renamed from: b */
    public SharedPreferences f1693b;

    /* renamed from: c */
    public SharedPreferences.Editor f1694c = null;

    /* renamed from: d */
    public Context f1695d;

    /* renamed from: e */
    public boolean f1696e;

    public a(Context context, String str, String str2, boolean z10, boolean z11) {
        this.f1693b = null;
        this.f1696e = z11;
        this.f1692a = str2;
        this.f1695d = context;
        if (context != null) {
            this.f1693b = context.getSharedPreferences(str2, 0);
        }
    }

    public String a(String str) {
        SharedPreferences sharedPreferences = this.f1693b;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!f.b(string)) {
                return string;
            }
        }
        return "";
    }

    public void b(String str, String str2) {
        if (f.b(str) || str.equals(bt.aO)) {
            return;
        }
        d();
        SharedPreferences.Editor editor = this.f1694c;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }

    public boolean c() {
        boolean z10;
        Context context;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editor = this.f1694c;
        if (editor != null) {
            if (!this.f1696e && this.f1693b != null) {
                editor.putLong(bt.aO, currentTimeMillis);
            }
            if (!this.f1694c.commit()) {
                z10 = false;
                if (this.f1693b != null && (context = this.f1695d) != null) {
                    this.f1693b = context.getSharedPreferences(this.f1692a, 0);
                }
                return z10;
            }
        }
        z10 = true;
        if (this.f1693b != null) {
            this.f1693b = context.getSharedPreferences(this.f1692a, 0);
        }
        return z10;
    }

    public final void d() {
        SharedPreferences sharedPreferences;
        if (this.f1694c != null || (sharedPreferences = this.f1693b) == null) {
            return;
        }
        this.f1694c = sharedPreferences.edit();
    }

    public void e(String str) {
        if (f.b(str) || str.equals(bt.aO)) {
            return;
        }
        d();
        SharedPreferences.Editor editor = this.f1694c;
        if (editor != null) {
            editor.remove(str);
        }
    }
}
