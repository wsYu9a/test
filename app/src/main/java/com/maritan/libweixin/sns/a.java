package com.maritan.libweixin.sns;

import com.cdo.oaps.ad.p;

/* loaded from: classes2.dex */
public class a extends e<a> {

    /* renamed from: c */
    public String f9597c;

    /* renamed from: d */
    public int f9598d = p.f6558j;

    /* renamed from: e */
    public long f9599e = System.currentTimeMillis();

    /* renamed from: f */
    public String f9600f;

    /* renamed from: g */
    public String f9601g;

    @Override // com.maritan.libweixin.sns.d
    /* renamed from: f */
    public a a() {
        return this;
    }

    public boolean g() {
        return !e() && System.currentTimeMillis() - this.f9599e > ((long) (this.f9598d * 1000));
    }
}
