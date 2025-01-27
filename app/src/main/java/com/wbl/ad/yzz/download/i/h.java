package com.wbl.ad.yzz.download.i;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.download.i.g;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes5.dex */
public final class h implements g.b {

    /* renamed from: a */
    public final File f32088a;

    /* renamed from: b */
    public final InputStream[] f32089b;

    /* renamed from: c */
    public boolean f32090c;

    public h(@f.b.a.e File file, @f.b.a.e InputStream[] inputStreamArr) {
        this.f32088a = file;
        this.f32089b = inputStreamArr;
    }

    @Override // com.wbl.ad.yzz.download.i.g.b
    public InputStream a(int i2) {
        return (InputStream) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13896, this, Integer.valueOf(i2));
    }

    @Override // com.wbl.ad.yzz.download.i.g.b
    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13895, this, null);
    }

    @Override // com.wbl.ad.yzz.download.i.g.b
    public InputStream b() {
        return (InputStream) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13890, this, null);
    }

    @Override // com.wbl.ad.yzz.download.i.g.b
    public File c() {
        return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13889, this, null);
    }
}
