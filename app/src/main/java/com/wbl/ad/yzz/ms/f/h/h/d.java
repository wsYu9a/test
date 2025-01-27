package com.wbl.ad.yzz.ms.f.h.h;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ms.supporter.domain.SelfAdInfo;

/* loaded from: classes5.dex */
public class d extends com.wbl.ad.yzz.ms.f.k.b<b> {
    public int l;
    public int m;
    public float n;
    public float o;
    public boolean p;

    public d(@NonNull Activity activity, @NonNull String str, @Nullable Integer num, b bVar) {
        this(activity, str, num, bVar, 1);
    }

    public final com.wbl.ad.yzz.ms.e.d.f.c a(com.wbl.ad.yzz.ms.d.e.f fVar, SelfAdInfo selfAdInfo) {
        return (com.wbl.ad.yzz.ms.e.d.f.c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12185, this, fVar, selfAdInfo);
    }

    @Override // com.wbl.ad.yzz.ms.f.k.b
    public com.wbl.ad.yzz.ms.f.k.g a(Activity activity, SelfAdInfo selfAdInfo) {
        return (com.wbl.ad.yzz.ms.f.k.g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12188, this, activity, selfAdInfo);
    }

    @Override // com.wbl.ad.yzz.ms.f.k.b
    public com.wbl.ad.yzz.ms.f.k.g a(com.wbl.ad.yzz.ms.f.i.b bVar, SelfAdInfo selfAdInfo) {
        return (com.wbl.ad.yzz.ms.f.k.g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12187, this, bVar, selfAdInfo);
    }

    public int h() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-12182, this, null);
    }

    public float i() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.f(-12181, this, null);
    }

    public float j() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.f(-12184, this, null);
    }

    public boolean k() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12183, this, null);
    }

    @Deprecated
    public d(@NonNull Activity activity, @NonNull String str, @Nullable Integer num, b bVar, int i2) {
        super(activity, str, bVar);
        this.l = num == null ? 1 : num.intValue();
        this.m = i2;
    }
}
