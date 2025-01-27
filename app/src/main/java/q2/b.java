package q2;

import android.content.Context;
import k2.d;
import o2.c;

/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a */
    public static a f29938a;

    /* renamed from: b */
    public static k2.a f29939b;

    public static a b(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (f29938a == null) {
            f29939b = d.b(context, str);
            f29938a = new b();
        }
        return f29938a;
    }

    @Override // q2.a
    public c a(o2.d dVar) {
        return o2.b.b(f29939b.a(o2.b.a(dVar)));
    }

    @Override // q2.a
    public boolean logCollect(String str) {
        return f29939b.logCollect(str);
    }
}
