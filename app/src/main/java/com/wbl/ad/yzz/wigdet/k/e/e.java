package com.wbl.ad.yzz.wigdet.k.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.wigdet.wblplayer.videocache.ProxyCacheException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: classes5.dex */
public class e extends n {

    /* renamed from: i */
    public long f34564i;

    /* renamed from: j */
    public final i f34565j;
    public final com.wbl.ad.yzz.wigdet.k.e.s.b k;
    public b l;
    public boolean m;

    public e(i iVar, com.wbl.ad.yzz.wigdet.k.e.s.b bVar) {
        super(iVar, bVar);
        this.f34564i = 2097152L;
        this.k = bVar;
        this.f34565j = iVar;
    }

    public final String a(String str, Object... objArr) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7724, this, str, objArr);
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.n
    public void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7723, this, Integer.valueOf(i2));
    }

    public void a(b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7718, this, bVar);
    }

    public void a(d dVar, Socket socket) throws IOException, ProxyCacheException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7717, this, dVar, socket);
    }

    public final void a(OutputStream outputStream, long j2) throws ProxyCacheException, IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7720, this, outputStream, Long.valueOf(j2));
    }

    public final boolean a(d dVar) throws ProxyCacheException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7719, this, dVar);
    }

    public final String b(d dVar) throws IOException, ProxyCacheException {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-7714, this, dVar);
    }

    public final void b(OutputStream outputStream, long j2) throws ProxyCacheException, IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7713, this, outputStream, Long.valueOf(j2));
    }

    public void j() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7716, this, null);
    }
}
