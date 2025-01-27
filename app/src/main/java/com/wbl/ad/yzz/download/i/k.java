package com.wbl.ad.yzz.download.i;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.download.i.g;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public final class k implements g.c {

    /* renamed from: a */
    public final String f32100a;

    /* renamed from: b */
    public final String f32101b;

    public k(@f.b.a.e String str, @f.b.a.e String str2) {
        this.f32100a = str2;
        if (str != null) {
            this.f32101b = str;
        } else {
            this.f32101b = String.valueOf(System.currentTimeMillis());
        }
    }

    @Override // com.wbl.ad.yzz.download.i.g.c
    public boolean a(OutputStream[] outputStreamArr) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13912, this, outputStreamArr);
    }
}
