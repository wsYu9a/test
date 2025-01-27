package com.wbl.ad.yzz.util.f0.e;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes5.dex */
public class b implements a {

    /* renamed from: a */
    public a f34282a = new k(100);

    /* renamed from: b */
    public a f34283b;

    public b(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        this.f34283b = new e(externalCacheDir != null ? new File(externalCacheDir, "images_dis_cache") : externalCacheDir, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    @Override // com.wbl.ad.yzz.util.f0.e.a
    public synchronized com.wbl.ad.yzz.util.f0.c.a.c<?> a(String str) {
        return (com.wbl.ad.yzz.util.f0.c.a.c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9183, this, str);
    }

    @Override // com.wbl.ad.yzz.util.f0.e.a
    public synchronized com.wbl.ad.yzz.util.f0.c.a.c<?> a(String str, com.wbl.ad.yzz.util.f0.c.a.c<?> cVar) {
        return (com.wbl.ad.yzz.util.f0.c.a.c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9178, this, str, cVar);
    }
}
