package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.utils.LruCache;

/* loaded from: classes4.dex */
public class c extends LruCache<Long, com.ss.android.downloadlib.addownload.b.b> {

    public static class a {

        /* renamed from: a */
        private static c f21298a = new c();
    }

    public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static c a() {
        return a.f21298a;
    }

    private c() {
        super(16, 16);
    }

    public void a(com.ss.android.downloadlib.addownload.b.b bVar) {
        if (bVar == null) {
            return;
        }
        put(Long.valueOf(bVar.a()), bVar);
    }

    public com.ss.android.downloadlib.addownload.b.b a(long j10, long j11) {
        return get(get(Long.valueOf(j10)) != null ? Long.valueOf(j10) : Long.valueOf(j11));
    }

    public com.ss.android.downloadlib.addownload.b.b a(long j10) {
        return get(Long.valueOf(j10));
    }
}
