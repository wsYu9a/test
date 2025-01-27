package h2;

import android.content.Context;

/* loaded from: classes.dex */
public class c implements f2.b {

    /* renamed from: d */
    public static final int f26384d = 1;

    /* renamed from: a */
    public m3.b f26385a;

    /* renamed from: b */
    public boolean f26386b = false;

    /* renamed from: c */
    public boolean f26387c = false;

    @Override // f2.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f26386b) {
            m3.b bVar = new m3.b();
            this.f26385a = bVar;
            this.f26387c = bVar.a(context, null) == 1;
            this.f26386b = true;
        }
        j2.a.d("getOAID", "isSupported", Boolean.valueOf(this.f26387c));
        if (this.f26387c && this.f26385a.l()) {
            return this.f26385a.h();
        }
        return null;
    }
}
