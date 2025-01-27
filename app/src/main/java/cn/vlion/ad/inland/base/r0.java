package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class r0 implements y4 {

    /* renamed from: a */
    public final /* synthetic */ y4 f3333a;

    /* renamed from: b */
    public final /* synthetic */ q0 f3334b;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f3335a;

        public a(int i10) {
            this.f3335a = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            y4 y4Var = r0.this.f3333a;
            if (y4Var != null) {
                y4Var.onDownloadApkProgress(this.f3335a);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f3337a;

        public b(String str) {
            this.f3337a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            y4 y4Var = r0.this.f3333a;
            if (y4Var != null) {
                y4Var.onDownloadSuccess(this.f3337a);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            y4 y4Var = r0.this.f3333a;
            if (y4Var != null) {
                y4Var.b();
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            y4 y4Var = r0.this.f3333a;
            if (y4Var != null) {
                y4Var.onDownloadFailed();
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            y4 y4Var = r0.this.f3333a;
            if (y4Var != null) {
                y4Var.a();
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            y4 y4Var = r0.this.f3333a;
            if (y4Var != null) {
                y4Var.onDownloadPaused();
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            y4 y4Var = r0.this.f3333a;
            if (y4Var != null) {
                y4Var.onInstallComplete();
            }
        }
    }

    public r0(q0 q0Var, y4 y4Var) {
        this.f3334b = q0Var;
        this.f3333a = y4Var;
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a() {
        try {
            LogVlion.e("VlionApkDownStatueUtils onDownloadPending");
            VlionHandlerUtils.instant().post(new e());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void b() {
        try {
            LogVlion.e("VlionApkDownStatueUtils onDownloadNoMission");
            DownloadApkData downloadApkData = this.f3334b.f3297a;
            if (downloadApkData != null) {
                downloadApkData.onDownloadFailed();
            }
            VlionHandlerUtils.instant().post(new c());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadApkProgress(int i10) {
        LogVlion.e("VlionApkDownStatueUtils onDownloadApkProgress " + i10);
        VlionHandlerUtils.instant().post(new a(i10));
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadFailed() {
        try {
            LogVlion.e("VlionApkDownStatueUtils onDownloadFailed");
            DownloadApkData downloadApkData = this.f3334b.f3297a;
            if (downloadApkData != null) {
                downloadApkData.onDownloadFailed();
            }
            VlionHandlerUtils.instant().post(new d());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadPaused() {
        try {
            LogVlion.e("VlionApkDownStatueUtils onDownloadPaused");
            VlionHandlerUtils.instant().post(new f());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onDownloadSuccess(String str) {
        try {
            LogVlion.e("VlionApkDownStatueUtils onDownloadApkProgress " + str);
            DownloadApkData downloadApkData = this.f3334b.f3297a;
            if (downloadApkData != null) {
                downloadApkData.submitDownloadComplete(str);
            }
            VlionHandlerUtils.instant().post(new b(str));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void onInstallComplete() {
        try {
            LogVlion.e("VlionApkDownStatueUtils onInstallComplete");
            VlionHandlerUtils.instant().post(new g());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.y4
    public final void a(int i10) {
        LogVlion.e("VlionApkDownStatueUtils onDownloadLoading ");
    }
}
