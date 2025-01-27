package com.wbl.ad.yzz.util.f0.c.a;

import android.graphics.Bitmap;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.util.f0.e.d;
import java.io.File;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public class a implements c<Bitmap>, d {

    /* renamed from: a */
    public Bitmap f34248a;

    public a(Bitmap bitmap) {
        this.f34248a = bitmap;
    }

    public Bitmap a() {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9199, this, null);
    }

    @Override // com.wbl.ad.yzz.util.f0.e.d
    public boolean a(File file) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9194, this, file);
    }

    public boolean a(OutputStream outputStream) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-9193, this, outputStream);
    }

    public final Bitmap.CompressFormat b() {
        return (Bitmap.CompressFormat) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-9196, this, null);
    }
}
