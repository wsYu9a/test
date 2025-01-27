package com.wbl.ad.yzz.download;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.download.h.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a */
    public final List<com.wbl.ad.yzz.download.h.a> f32013a;

    /* renamed from: b */
    public Handler f32014b;

    /* renamed from: c */
    public final a.c f32015c;

    public static final class a implements a.c {
        public a() {
        }

        @Override // com.wbl.ad.yzz.download.h.a.c
        public void a(com.wbl.ad.yzz.download.h.a aVar, int i2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14724, this, aVar, Integer.valueOf(i2));
        }
    }

    public static final class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.download.h.a f32017a;

        public b(com.wbl.ad.yzz.download.h.a aVar) {
            this.f32017a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14723, this, null);
        }
    }

    public static final class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.download.h.a f32018a;

        /* renamed from: b */
        public final /* synthetic */ f f32019b;

        public c(com.wbl.ad.yzz.download.h.a aVar, f fVar) {
            this.f32018a = aVar;
            this.f32019b = fVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14750, this, null);
        }
    }

    public g() {
        new ArrayList();
        this.f32013a = new ArrayList();
        c();
        this.f32015c = new a();
    }

    public final void a(long j2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14751, this, Long.valueOf(j2));
    }

    public final void a(Activity activity, String str, String str2, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14746, this, activity, str, str2, fVar);
    }

    public final void a(Activity activity, String str, String str2, boolean z, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14745, this, activity, str, str2, Boolean.valueOf(z), fVar);
    }

    public final void a(Context context, String str, String str2, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14748, this, context, str, str2, fVar);
    }

    public final void a(Context context, String str, boolean z, String str2, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14747, this, context, str, Boolean.valueOf(z), str2, fVar);
    }

    public final void a(com.wbl.ad.yzz.download.h.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14742, this, aVar);
    }

    public final void a(com.wbl.ad.yzz.download.h.a aVar, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14741, this, aVar, fVar);
    }

    public final boolean a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14744, this, null);
    }

    public final int b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14743, this, null);
    }

    public final void b(Activity activity, String str, String str2, f fVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14738, this, activity, str, str2, fVar);
    }

    public final void b(com.wbl.ad.yzz.download.h.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14737, this, aVar);
    }

    public final Handler c() {
        return (Handler) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14740, this, null);
    }

    public final void c(com.wbl.ad.yzz.download.h.a aVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14739, this, aVar);
    }
}
