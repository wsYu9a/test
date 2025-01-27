package com.wbl.ad.yzz.wigdet.k.e.s;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.kuaishou.weapon.p0.t;
import com.wbl.ad.yzz.wigdet.wblplayer.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes5.dex */
public class b implements com.wbl.ad.yzz.wigdet.k.e.a {

    /* renamed from: a */
    public final a f34633a;

    /* renamed from: b */
    public File f34634b;

    /* renamed from: c */
    public RandomAccessFile f34635c;

    public b(String str) throws ProxyCacheException {
        try {
            this.f34633a = new i();
            this.f34634b = new File(str);
            this.f34635c = new RandomAccessFile(this.f34634b, "rw");
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + this.f34634b + " as disc cache", e2);
        }
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.a
    public synchronized int a(byte[] bArr, long j2, int i2) throws ProxyCacheException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-7759, this, bArr, Long.valueOf(j2), Integer.valueOf(i2));
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.a
    public synchronized void a() throws ProxyCacheException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7754, this, null);
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.a
    public synchronized void a(byte[] bArr, int i2) throws ProxyCacheException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7753, this, bArr, Integer.valueOf(i2));
    }

    public final boolean a(File file) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7756, this, file);
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.a
    public synchronized long b() throws ProxyCacheException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-7755, this, null);
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.a
    public synchronized boolean c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7750, this, null);
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.a
    public synchronized void close() throws ProxyCacheException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-7749, this, null);
    }

    public b(File file, a aVar) throws ProxyCacheException {
        File file2;
        try {
            if (aVar != null) {
                this.f34633a = aVar;
                d.b(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    file2 = new File(file.getParentFile(), file.getName() + ".download");
                }
                this.f34634b = file2;
                this.f34635c = new RandomAccessFile(this.f34634b, exists ? t.k : "rw");
                return;
            }
            throw new NullPointerException();
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e2);
        }
    }
}
