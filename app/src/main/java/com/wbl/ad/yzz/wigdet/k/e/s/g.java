package com.wbl.ad.yzz.wigdet.k.e.s;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.File;

/* loaded from: classes5.dex */
public class g extends e {

    /* renamed from: b */
    public final int f34639b;

    public g(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.f34639b = i2;
    }

    @Override // com.wbl.ad.yzz.wigdet.k.e.s.e
    public boolean a(File file, long j2, int i2) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-7767, this, file, Long.valueOf(j2), Integer.valueOf(i2));
    }
}
