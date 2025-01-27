package com.vivo.ad.c;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.kuaishou.weapon.p0.g;
import com.vivo.google.android.exoplayer3.upstream.DataSource;
import com.vivo.google.android.exoplayer3.upstream.DefaultBandwidthMeter;
import com.vivo.google.android.exoplayer3.upstream.DefaultDataSourceFactory;
import com.vivo.google.android.exoplayer3.upstream.DefaultHttpDataSourceFactory;
import com.vivo.google.android.exoplayer3.upstream.FileDataSource;
import com.vivo.google.android.exoplayer3.upstream.cache.CacheDataSink;
import com.vivo.google.android.exoplayer3.upstream.cache.CacheDataSource;
import com.vivo.google.android.exoplayer3.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.vivo.google.android.exoplayer3.upstream.cache.SimpleCache;
import com.vivo.google.android.exoplayer3.util.Util;
import com.vivo.mobilead.util.h0;
import java.io.File;

/* loaded from: classes4.dex */
public class b implements DataSource.Factory {

    /* renamed from: a */
    private final Context f26583a;

    /* renamed from: b */
    private final DefaultDataSourceFactory f26584b;

    public b(Context context) {
        this.f26583a = context;
        String userAgent = Util.getUserAgent(context, "vivo_adsdk");
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
        this.f26584b = new DefaultDataSourceFactory(context, defaultBandwidthMeter, new DefaultHttpDataSourceFactory(userAgent, defaultBandwidthMeter));
    }

    private SimpleCache a() {
        File file;
        LeastRecentlyUsedCacheEvictor leastRecentlyUsedCacheEvictor;
        int i2 = Build.VERSION.SDK_INT;
        boolean z = false;
        boolean z2 = i2 < 23 || (this.f26583a.checkSelfPermission(g.f9325j) == 0 && this.f26583a.checkSelfPermission(g.f9324i) == 0);
        if (i2 >= 30) {
            z2 = Environment.isExternalStorageManager();
        }
        if (z2 && h0.K().J()) {
            z = true;
        }
        try {
            if (z) {
                file = new File(Environment.getExternalStorageDirectory(), "vvmedia");
                leastRecentlyUsedCacheEvictor = new LeastRecentlyUsedCacheEvictor(314572800L);
            } else {
                file = new File(this.f26583a.getCacheDir(), "vvmedia");
                leastRecentlyUsedCacheEvictor = new LeastRecentlyUsedCacheEvictor(104857600L);
            }
        } catch (Exception unused) {
            file = new File(this.f26583a.getCacheDir(), "vvmedia");
            leastRecentlyUsedCacheEvictor = new LeastRecentlyUsedCacheEvictor(104857600L);
        }
        return new SimpleCache(file, leastRecentlyUsedCacheEvictor);
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource.Factory
    public DataSource createDataSource() {
        SimpleCache a2 = a();
        return new CacheDataSource(a2, this.f26584b.createDataSource(), new FileDataSource(), new CacheDataSink(a2, 3145728L), 3, null);
    }
}
