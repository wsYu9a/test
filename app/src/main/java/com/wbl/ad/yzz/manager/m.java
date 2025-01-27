package com.wbl.ad.yzz.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.c.d;

/* loaded from: classes5.dex */
public final class m {

    /* renamed from: a */
    public static boolean f32967a = false;

    /* renamed from: b */
    public static boolean f32968b = true;

    /* renamed from: c */
    public static a f32969c;

    /* renamed from: d */
    public static Handler f32970d;

    /* renamed from: e */
    public static boolean f32971e;

    /* renamed from: f */
    @f.b.a.d
    public static final m f32972f = new m();

    public static final class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12598, this, context, intent);
        }
    }

    public static final class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ StringBuilder f32973a;

        public b(StringBuilder sb) {
            this.f32973a = sb;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12597, this, null);
        }
    }

    public static final class c implements Runnable {

        /* renamed from: a */
        public static final c f32974a = new c();

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12600, this, null);
        }
    }

    public static final class d implements Runnable {

        /* renamed from: a */
        public static final d f32975a = new d();

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12599, this, null);
        }
    }

    public static final class e implements d.b0<com.wbl.ad.yzz.network.b.b.s> {
        public void a(String str, com.wbl.ad.yzz.network.b.b.s sVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12594, this, str, sVar);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public void onFailed(String str, String str2) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12593, this, str, str2);
        }

        @Override // com.wbl.ad.yzz.network.c.d.b0
        public /* bridge */ /* synthetic */ void onSuccess(String str, com.wbl.ad.yzz.network.b.b.s sVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12596, this, str, sVar);
        }
    }

    public final PackageInfo a(Context context, String str) {
        return (PackageInfo) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12554, this, context, str);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12553, this, null);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12556, this, str);
    }

    public final boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12555, this, null);
    }

    public final void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12550, this, null);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12549, this, null);
    }

    public final void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12552, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12551, this, null);
    }
}
