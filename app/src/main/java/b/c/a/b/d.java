package b.c.a.b;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private String f4303a;

    /* renamed from: b */
    private String f4304b;

    /* renamed from: c */
    private int f4305c;

    /* renamed from: d */
    private String f4306d;

    d(h hVar) {
        if (c.c(hVar.f4331b)) {
            this.f4303a = hVar.f4330a;
        } else if (c.e(hVar.f4331b)) {
            this.f4306d = hVar.f4330a;
        } else {
            this.f4304b = hVar.f4330a;
        }
        this.f4305c = hVar.f4331b;
    }

    public int a() {
        return this.f4305c & 255;
    }

    public String b() {
        return this.f4303a;
    }

    public int c() {
        return this.f4305c & 65280;
    }

    public String d() {
        return this.f4304b;
    }

    public int e() {
        return this.f4305c;
    }

    public int f() {
        return this.f4305c & 16711680;
    }

    public String g() {
        return this.f4306d;
    }

    public boolean h() {
        return TextUtils.isEmpty(this.f4303a);
    }

    public boolean i() {
        return TextUtils.isEmpty(this.f4304b);
    }

    public boolean j() {
        return TextUtils.isEmpty(this.f4306d);
    }

    public String toString() {
        return "ClientIdInfo{imei='" + this.f4303a + "', localId='" + this.f4304b + "', tvUUID='" + this.f4306d + "', retCode=" + this.f4305c + '}';
    }
}
