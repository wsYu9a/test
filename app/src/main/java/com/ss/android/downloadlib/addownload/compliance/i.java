package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.utils.LruCache;

/* loaded from: classes4.dex */
public class i extends LruCache<Long, com.ss.android.downloadlib.addownload.zx.zx> {

    private static class j {

        /* renamed from: j */
        private static i f24121j = new i();
    }

    /* synthetic */ i(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static i j() {
        return j.f24121j;
    }

    private i() {
        super(16, 16);
    }

    public void j(com.ss.android.downloadlib.addownload.zx.zx zxVar) {
        if (zxVar == null) {
            return;
        }
        put(Long.valueOf(zxVar.j()), zxVar);
    }

    public com.ss.android.downloadlib.addownload.zx.zx j(long j2, long j3) {
        return get(get(Long.valueOf(j2)) != null ? Long.valueOf(j2) : Long.valueOf(j3));
    }

    public com.ss.android.downloadlib.addownload.zx.zx j(long j2) {
        return get(Long.valueOf(j2));
    }
}
