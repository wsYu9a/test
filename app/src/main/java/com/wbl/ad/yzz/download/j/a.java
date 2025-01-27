package com.wbl.ad.yzz.download.j;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.download.f;
import f.b.a.e;
import java.io.File;

/* loaded from: classes5.dex */
public abstract class a implements c {

    /* renamed from: a */
    @e
    public final Context f32103a;

    /* renamed from: b */
    public final String f32104b;

    /* renamed from: c */
    public volatile int f32105c = -2;

    /* renamed from: d */
    public File f32106d;

    /* renamed from: e */
    public f f32107e;

    public a(@e Context context, @e String str) {
        this.f32103a = context != null ? context.getApplicationContext() : null;
        if (str != null) {
            this.f32104b = str;
        } else {
            this.f32104b = "";
        }
        e();
    }

    public String a(String str, String str2) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13906, this, str, str2);
    }

    public final void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13905, this, Integer.valueOf(i2));
    }

    public final void a(int i2, String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13908, this, Integer.valueOf(i2), str);
    }

    public final void a(long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13907, this, Long.valueOf(j2));
    }

    @Override // com.wbl.ad.yzz.download.j.c
    public void a(f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13998, this, fVar);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13997, this, str);
    }

    public boolean a(File file, String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14000, this, file, str);
    }

    public final void b(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13999, this, Integer.valueOf(i2));
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13994, this, null);
    }

    public void c(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13993, this, Integer.valueOf(i2));
    }

    public String d() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13996, this, null);
    }

    public final File e() {
        return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13995, this, null);
    }

    public int f() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13990, this, null);
    }
}
