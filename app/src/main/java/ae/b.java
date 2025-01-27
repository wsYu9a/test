package ae;

import android.app.Activity;
import android.content.Intent;
import l9.t0;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    public String f160a;

    /* renamed from: b */
    public String f161b;

    /* renamed from: c */
    public Intent f162c;

    /* renamed from: d */
    public boolean f163d;

    public b(Intent intent, String str, String str2, boolean z10) {
        this.f162c = intent;
        this.f160a = str;
        this.f161b = str2;
        this.f163d = z10;
    }

    public String a() {
        return this.f161b;
    }

    public Intent b() {
        return this.f162c;
    }

    public String c() {
        return this.f160a;
    }

    public boolean d() {
        return this.f163d;
    }

    public b e(String str) {
        this.f161b = str;
        return this;
    }

    public b f(Intent intent) {
        this.f162c = intent;
        return this;
    }

    public b g(boolean z10) {
        this.f163d = z10;
        return this;
    }

    public b h(String str) {
        this.f160a = str;
        return this;
    }

    public void i(Activity activity) {
        if (this.f163d) {
            t0.b(activity, "您已设置");
        }
        Intent intent = this.f162c;
        if (intent != null) {
            try {
                intent.addFlags(268435456);
                activity.startActivityForResult(this.f162c, 1025);
            } catch (Exception unused) {
                activity.startActivity(new Intent("android.settings.SETTINGS"));
            }
        }
    }
}
