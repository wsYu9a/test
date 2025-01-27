package u3;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public final String f30939a;

    /* renamed from: b */
    public final String f30940b;

    /* renamed from: c */
    public final long f30941c;

    public a(String str, String str2, long j10) {
        this.f30939a = str;
        this.f30940b = str2;
        this.f30941c = j10;
    }

    public static boolean d(a aVar) {
        return aVar == null || TextUtils.isEmpty(aVar.f30939a);
    }

    public String a() {
        return this.f30939a;
    }

    public String b() {
        return this.f30940b;
    }

    public long c() {
        return this.f30941c;
    }
}
