package com.wbl.ad.yzz.wigdet.k.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.wigdet.wblplayer.videocache.ProxyCacheException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* loaded from: classes5.dex */
public class i implements p {

    /* renamed from: a */
    public final com.wbl.ad.yzz.wigdet.k.e.u.c f34606a;

    /* renamed from: b */
    public final com.wbl.ad.yzz.wigdet.k.e.t.b f34607b;

    /* renamed from: c */
    public q f34608c;

    /* renamed from: d */
    public HttpURLConnection f34609d;

    /* renamed from: e */
    public InputStream f34610e;

    public i(String str) {
        this(str, com.wbl.ad.yzz.wigdet.k.e.u.d.a());
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.p
    public int a(byte[] bArr) throws ProxyCacheException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-7707, this, bArr);
    }

    public final long a(HttpURLConnection httpURLConnection) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-7702, this, httpURLConnection);
    }

    public final long a(HttpURLConnection httpURLConnection, long j2, int i2) throws IOException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-7701, this, httpURLConnection, Long.valueOf(j2), Integer.valueOf(i2));
    }

    public final HttpURLConnection a(long j2, int i2) throws IOException, ProxyCacheException {
        return (HttpURLConnection) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7704, this, Long.valueOf(j2), Integer.valueOf(i2));
    }

    public final void a() throws ProxyCacheException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7703, this, null);
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.p
    public void a(long j2) throws ProxyCacheException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7698, this, Long.valueOf(j2));
    }

    public final void a(HttpURLConnection httpURLConnection, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7697, this, httpURLConnection, str);
    }

    public synchronized String b() throws ProxyCacheException {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7700, this, null);
    }

    public String c() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7699, this, null);
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.p
    public void close() throws ProxyCacheException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7790, this, null);
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.p
    public synchronized long length() throws ProxyCacheException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-7789, this, null);
    }

    public String toString() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7792, this, null);
    }

    public i(String str, com.wbl.ad.yzz.wigdet.k.e.u.c cVar) {
        this(str, cVar, new com.wbl.ad.yzz.wigdet.k.e.t.a());
    }

    public i(String str, com.wbl.ad.yzz.wigdet.k.e.u.c cVar, com.wbl.ad.yzz.wigdet.k.e.t.b bVar) {
        this.f34606a = (com.wbl.ad.yzz.wigdet.k.e.u.c) m.a(cVar);
        this.f34607b = (com.wbl.ad.yzz.wigdet.k.e.t.b) m.a(bVar);
        q a2 = cVar.a(str);
        this.f34608c = a2 == null ? new q(str, -2147483648L, o.d(str)) : a2;
    }

    public i(i iVar) {
        this.f34608c = iVar.f34608c;
        this.f34606a = iVar.f34606a;
        this.f34607b = iVar.f34607b;
    }
}
