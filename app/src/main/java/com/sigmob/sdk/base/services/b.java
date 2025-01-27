package com.sigmob.sdk.base.services;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.services.j;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.util.Date;
import java.util.List;

/* loaded from: classes4.dex */
public class b implements j.a {

    /* renamed from: a */
    public com.sigmob.sdk.base.services.a f18349a;

    /* renamed from: b */
    public k f18350b = k.STOP;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f18351a;

        public a(Context context) {
            this.f18351a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                List b10 = b.b(this.f18351a);
                if (b10 == null) {
                    return;
                }
                for (int i10 = 0; i10 < b10.size(); i10++) {
                    PackageInfo packageInfo = (PackageInfo) b10.get(i10);
                    if ((packageInfo.applicationInfo.flags & 1) == 0) {
                        b0.a(packageInfo, 0);
                    }
                }
                com.sigmob.sdk.base.utils.f.a("BuriedPointConfig").edit().putString(com.sigmob.sdk.base.k.f18170b, Constants.sdf.format(new Date())).apply();
            } catch (Throwable th2) {
                SigmobLog.e("update app info", th2);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.services.b$b */
    public class RunnableC0576b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f18352a;

        public RunnableC0576b(Context context) {
            this.f18352a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<String> o10 = com.sigmob.sdk.base.l.w().o();
            if (o10.isEmpty()) {
                return;
            }
            for (String str : o10) {
                b0.a(str, u.a(this.f18352a, str));
            }
            b.i();
        }
    }

    public b() {
        if (this.f18349a == null) {
            this.f18349a = new com.sigmob.sdk.base.services.a();
        }
    }

    public static List<PackageInfo> b(Context context) {
        try {
            return AppPackageUtil.getPackageManager(context).getInstalledPackages(0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void e() {
        WindCustomController customController;
        try {
            if (com.sigmob.sdk.base.f.f().b()) {
                WindAdOptions options = WindAds.sharedAds().getOptions();
                int a10 = com.sigmob.sdk.base.l.w().a();
                boolean z10 = true;
                if (a10 != 1) {
                    if (a10 != 2) {
                        if (((options == null || (customController = options.getCustomController()) == null) ? true : customController.isCanUseAppList()) && !com.sigmob.sdk.base.l.w().T()) {
                        }
                    }
                    z10 = false;
                }
                if (z10) {
                    j();
                }
            }
        } catch (Throwable th2) {
            SigmobLog.e("BuriedPointManager getInstance", th2);
        }
    }

    public static void f() {
        try {
            e();
        } catch (Throwable unused) {
        }
    }

    public static void g() {
        Context d10 = com.sigmob.sdk.a.d();
        if (d10 == null || !com.sigmob.sdk.base.f.f().b() || h()) {
            return;
        }
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new RunnableC0576b(d10));
    }

    @SuppressLint({"SimpleDateFormat"})
    public static boolean h() {
        return com.sigmob.sdk.base.utils.f.a("BuriedPointConfig").getString(com.sigmob.sdk.base.k.f18171c, "").equals(Constants.sdf.format(new Date()));
    }

    public static void i() {
        com.sigmob.sdk.base.utils.f.a("BuriedPointConfig").edit().putString(com.sigmob.sdk.base.k.f18171c, Constants.sdf.format(new Date())).apply();
    }

    public static void j() {
        Context d10 = com.sigmob.sdk.a.d();
        if (c(d10)) {
            return;
        }
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new a(d10));
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public k c() {
        return this.f18350b;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public Error d() {
        return null;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static boolean c(Context context) {
        return com.sigmob.sdk.base.utils.f.a("BuriedPointConfig").getString(com.sigmob.sdk.base.k.f18170b, "").equals(Constants.sdf.format(new Date()));
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public boolean a() {
        k kVar = this.f18350b;
        k kVar2 = k.RUNNING;
        if (kVar == kVar2) {
            return false;
        }
        d(com.sigmob.sdk.a.d());
        this.f18350b = kVar2;
        return true;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public void b() {
        if (this.f18350b == k.RUNNING) {
            e(com.sigmob.sdk.a.d());
            this.f18350b = k.STOP;
        }
    }

    public void d(Context context) {
        if (com.sigmob.sdk.base.l.w().S()) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.sigmob.sdk.base.utils.a.a(com.sigmob.sdk.base.k.J));
        if (Build.VERSION.SDK_INT >= 27) {
            intentFilter.addAction(com.sigmob.sdk.base.utils.a.a(com.sigmob.sdk.base.k.K));
        }
        intentFilter.addAction(com.sigmob.sdk.base.utils.a.a(com.sigmob.sdk.base.k.H));
        intentFilter.addAction(com.sigmob.sdk.base.utils.a.a(com.sigmob.sdk.base.k.G));
        intentFilter.addAction(com.sigmob.sdk.base.utils.a.a(com.sigmob.sdk.base.k.I));
        intentFilter.addDataScheme("package");
        u.a(context, this.f18349a, intentFilter);
    }

    public void e(Context context) {
        context.unregisterReceiver(this.f18349a);
    }
}
