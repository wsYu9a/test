package com.wbl.ad.yzz.network.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.network.b.b.u;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    @f.b.a.e
    public com.wbl.ad.yzz.adrequest.c.c f33612a;

    /* renamed from: b */
    public boolean f33613b;

    /* renamed from: e */
    public InterfaceC0770a f33616e;

    /* renamed from: c */
    public long f33614c = 20000;

    /* renamed from: d */
    public ArrayList<b> f33615d = new ArrayList<>(12);

    /* renamed from: f */
    public Handler f33617f = new Handler(Looper.getMainLooper());

    /* renamed from: g */
    public Runnable f33618g = new e();

    /* renamed from: com.wbl.ad.yzz.network.c.a$a */
    public interface InterfaceC0770a {
        void loadAdError(int i2, @f.b.a.d String str);

        void loadAdSuccess(@f.b.a.d List<com.wbl.ad.yzz.adapter.d.b> list);
    }

    public static final class b {

        /* renamed from: a */
        public boolean f33619a;

        /* renamed from: b */
        @f.b.a.e
        public com.wbl.ad.yzz.adapter.d.b f33620b;

        public final void a(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11209, this, bVar);
        }

        public final void a(boolean z) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11212, this, Boolean.valueOf(z));
        }

        public final boolean a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-11211, this, null);
        }

        public final com.wbl.ad.yzz.adapter.d.b b() {
            return (com.wbl.ad.yzz.adapter.d.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11206, this, null);
        }
    }

    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11205, this, null);
        }
    }

    public static final class d implements com.wbl.ad.yzz.network.c.e.c {

        /* renamed from: b */
        public final /* synthetic */ b f33623b;

        /* renamed from: c */
        public final /* synthetic */ int f33624c;

        public d(b bVar, int i2) {
            this.f33623b = bVar;
            this.f33624c = i2;
        }

        @Override // com.wbl.ad.yzz.network.c.e.c
        public void a(com.wbl.ad.yzz.adapter.d.b bVar) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11208, this, bVar);
        }

        @Override // com.wbl.ad.yzz.network.c.e.c
        public void loadAdError(int i2, String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11207, this, Integer.valueOf(i2), str);
        }
    }

    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11202, this, null);
        }
    }

    public final void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11203, this, Integer.valueOf(i2));
    }

    public final void a(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11230, this, context);
    }

    public final void a(Context context, u uVar, String str, com.wbl.ad.yzz.innerconfig.d.d dVar, InterfaceC0770a interfaceC0770a) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11229, this, context, uVar, str, dVar, interfaceC0770a);
    }

    public final void a(Context context, String str, com.wbl.ad.yzz.innerconfig.d.d dVar, List<com.wbl.ad.yzz.network.b.b.d> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11232, this, context, str, dVar, list);
    }

    public final void a(Context context, List<com.wbl.ad.yzz.network.b.b.d> list, String str, com.wbl.ad.yzz.innerconfig.d.d dVar, InterfaceC0770a interfaceC0770a) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11231, this, context, list, str, dVar, interfaceC0770a);
    }

    public final void a(com.wbl.ad.yzz.adrequest.c.c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11226, this, cVar);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11225, this, str);
    }

    public final boolean a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-11228, this, null);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11227, this, null);
    }
}
