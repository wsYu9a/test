package com.wbl.ad.yzz.ui.f;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.dialog.d;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: e */
    public com.wbl.ad.yzz.dialog.d f34109e;

    /* renamed from: f */
    public int f34110f;

    /* renamed from: a */
    public boolean f34105a = true;

    /* renamed from: b */
    public boolean f34106b = false;

    /* renamed from: c */
    public Handler f34107c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    public boolean f34108d = false;

    /* renamed from: g */
    public Runnable f34111g = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8886, this, null);
        }
    }

    /* renamed from: com.wbl.ad.yzz.ui.f.b$b */
    public class C0789b implements d.b {

        /* renamed from: a */
        public final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d f34113a;

        public C0789b(com.wbl.ad.yzz.innerconfig.d.d dVar) {
            this.f34113a = dVar;
        }

        @Override // com.wbl.ad.yzz.dialog.d.b
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8885, this, null);
        }
    }

    public static boolean d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8882, null, null);
    }

    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8881, this, null);
    }

    public void a(int i2, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8884, this, Integer.valueOf(i2), dVar);
    }

    public void a(int i2, boolean z, boolean z2, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8883, this, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), dVar);
    }

    public void a(Activity activity, com.wbl.ad.yzz.innerconfig.d.d dVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8846, this, activity, dVar);
    }

    public void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8845, this, Boolean.valueOf(z));
    }

    public boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8848, this, null);
    }

    public boolean c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8847, this, null);
    }
}
