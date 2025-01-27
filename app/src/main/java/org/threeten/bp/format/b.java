package org.threeten.bp.format;

import ij.f;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import k0.e;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a */
    public static final AtomicReference<b> f29610a = new AtomicReference<>();

    public static class a {

        /* renamed from: a */
        public static final b f29611a = a();

        public static b a() {
            e.a(b.f29610a, null, new c());
            return (b) b.f29610a.get();
        }
    }

    public static b b() {
        return a.f29611a;
    }

    public static void e(b bVar) {
        if (!e.a(f29610a, null, bVar)) {
            throw new IllegalStateException("Provider was already set, possibly with a default during initialization");
        }
    }

    public abstract String c(f fVar, long j10, TextStyle textStyle, Locale locale);

    public abstract Iterator<Map.Entry<String, Long>> d(f fVar, TextStyle textStyle, Locale locale);
}
