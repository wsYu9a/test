package u2;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    public String f30926a;

    /* renamed from: b */
    public Boolean f30927b;

    public void a(boolean z10) {
        this.f30927b = Boolean.valueOf(z10);
    }

    public boolean b() {
        return this.f30927b != null;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f30926a, str);
    }

    public void d(String str) {
        this.f30926a = str;
    }

    public boolean e() {
        Boolean bool = this.f30927b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
