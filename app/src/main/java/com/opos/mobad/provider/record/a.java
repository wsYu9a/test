package com.opos.mobad.provider.record;

import android.content.Context;
import android.net.Uri;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.process.bridge.provider.b;
import com.opos.process.bridge.provider.c;

/* loaded from: classes4.dex */
public final class a extends com.opos.process.bridge.provider.a {

    /* renamed from: c */
    private static final String f23154c = SdKRecord.class.getName();

    public a(Context context) {
        this.f23782a = context;
    }

    @Override // com.opos.process.bridge.provider.a
    protected Uri a(Context context) {
        return MobAdGlobalProvider.getUri(context);
    }

    public final CacheEntity a() throws c, b {
        return (CacheEntity) a(this.f23782a, f23154c, this.f23783b, 2, new Object[0]);
    }

    public final void a(CacheEntity cacheEntity) throws c, b {
        b(this.f23782a, f23154c, this.f23783b, 1, cacheEntity);
    }

    public final void a(ControlEntity controlEntity) throws c, b {
        b(this.f23782a, f23154c, this.f23783b, 7, controlEntity);
    }

    public final void a(CookieData cookieData) throws c, b {
        b(this.f23782a, f23154c, this.f23783b, 15, cookieData);
    }

    public final void a(String str) throws c, b {
        b(this.f23782a, f23154c, this.f23783b, 9, str);
    }

    public final void a(String str, String str2) throws c, b {
        b(this.f23782a, f23154c, this.f23783b, 13, str, str2);
    }

    public final CacheEntity b() throws c, b {
        return (CacheEntity) a(this.f23782a, f23154c, this.f23783b, 4, new Object[0]);
    }

    public final void b(CacheEntity cacheEntity) throws c, b {
        b(this.f23782a, f23154c, this.f23783b, 3, cacheEntity);
    }

    public final void c() throws c, b {
        b(this.f23782a, f23154c, this.f23783b, 5, new Object[0]);
    }

    public final ControlEntity d() throws c, b {
        return (ControlEntity) a(this.f23782a, f23154c, this.f23783b, 6, new Object[0]);
    }

    public final long e() throws c, b {
        return ((Long) a(this.f23782a, f23154c, this.f23783b, 8, new Object[0])).longValue();
    }

    public final int f() throws c, b {
        return ((Integer) a(this.f23782a, f23154c, this.f23783b, 10, new Object[0])).intValue();
    }

    public final long g() throws c, b {
        return ((Long) a(this.f23782a, f23154c, this.f23783b, 11, new Object[0])).longValue();
    }

    public final String h() throws c, b {
        return (String) a(this.f23782a, f23154c, this.f23783b, 12, new Object[0]);
    }

    public final String i() throws c, b {
        return (String) a(this.f23782a, f23154c, this.f23783b, 14, new Object[0]);
    }

    public final CookieData j() throws c, b {
        return (CookieData) a(this.f23782a, f23154c, this.f23783b, 16, new Object[0]);
    }
}
