package cn.vlion.ad.inland.core;

import android.content.Context;
import cn.vlion.ad.inland.base.adapter.VlionBidderSource;
import cn.vlion.ad.inland.base.adapter.VlionLossReason;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.date.VlionDateUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import cn.vlion.ad.inland.core.init.b;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class d0 {

    /* renamed from: a */
    public u f3573a;

    /* renamed from: b */
    public j0 f3574b;

    /* renamed from: c */
    public Context f3575c;

    /* renamed from: d */
    public boolean f3576d = false;

    /* renamed from: e */
    public int f3577e;

    /* renamed from: f */
    public ScheduledExecutorService f3578f;

    /* renamed from: g */
    public ScheduledExecutorService f3579g;

    public class a implements b.InterfaceC0029b {
        public a() {
        }

        public final void a() {
            try {
                LogVlion.e("VlionManagerBase loadAdConfig  onSuccess isFinished=" + d0.this.f3576d);
                if (d0.this.f3576d) {
                    return;
                }
                LogVlion.e("VlionManagerBase loadAdConfig  onSuccess vlionSlot.getAdType()=" + d0.this.f3574b.a() + " vlionSlot.getSlotID()=" + d0.this.f3574b.e());
                VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean = VlionServiceConfigParse.getInstance().getPlacementBean(d0.this.f3574b.a(), d0.this.f3574b.e());
                if (placementBean == null || placementBean.getSources() == null || placementBean.getSources().size() <= 0) {
                    d0 d0Var = d0.this;
                    d0Var.f3576d = true;
                    d0Var.a();
                    LogVlion.e("VlionManagerBase loadAdConfig  onSuccess no find source");
                    d0 d0Var2 = d0.this;
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_AD_CONFIG_ERROR;
                    d0Var2.a(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                    return;
                }
                d0 d0Var3 = d0.this;
                if (d0Var3.f3576d) {
                    return;
                }
                d0Var3.f3577e = placementBean.getCacheTime();
                d0.a(d0.this, r1.f3577e);
                d0.this.a(placementBean);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        public final void a(VlionAdBaseError vlionAdBaseError) {
            try {
                LogVlion.e("VlionManagerBase loadAdConfig  onFail isFinished=" + d0.this.f3576d);
                if (vlionAdBaseError != null) {
                    LogVlion.e("VlionManagerBase loadAdConfig  onFail vlionAdError=" + vlionAdBaseError.toString());
                }
                d0 d0Var = d0.this;
                if (d0Var.f3576d) {
                    return;
                }
                d0Var.f3576d = true;
                d0Var.a();
                if (vlionAdBaseError != null) {
                    d0.this.a(new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage()));
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VlionManagerBase loadTimeOver end=");
                sb2.append(VlionDateUtils.getFormatDate(Long.valueOf(System.currentTimeMillis())));
                sb2.append(" (null != vlionLoadAdSourceManager)=");
                sb2.append(d0.this.f3573a != null);
                LogVlion.e(sb2.toString());
                d0.a(d0.this, false);
                d0.this.a();
                d0.this.c();
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public d0(Context context) {
        this.f3575c = context;
    }

    public abstract void a(VlionServiceConfig.DataBean.AdBean.PlacementBean placementBean);

    public abstract void a(VlionAdError vlionAdError);

    public final void b() {
        try {
            LogVlion.e("VlionManagerBase cancelScheduledFutureAll");
            a();
            c();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final synchronized void c() {
        try {
            LogVlion.e("VlionManagerBase cancelScheduledFutureService");
            ScheduledExecutorService scheduledExecutorService = this.f3579g;
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                this.f3579g.shutdownNow();
                this.f3579g = null;
            }
        } finally {
        }
    }

    public void d() {
        try {
            a();
            u uVar = this.f3573a;
            if (uVar != null) {
                uVar.a();
                this.f3573a = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void e() {
        try {
            j0 j0Var = this.f3574b;
            long f10 = j0Var != null ? (long) j0Var.f() : 5L;
            LogVlion.e("VlionManagerBase loadAdConfig  tolerateTime=" + f10);
            a(f10);
            cn.vlion.ad.inland.core.init.b.a(new a());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a() {
        try {
            LogVlion.e("VlionManagerBase cancelScheduledFuture");
            ScheduledExecutorService scheduledExecutorService = this.f3578f;
            if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                return;
            }
            this.f3578f.shutdownNow();
            this.f3578f = null;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(double d10, VlionBidderSource vlionBidderSource) {
        try {
            u uVar = this.f3573a;
            if (uVar != null) {
                uVar.a(d10, vlionBidderSource);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(double d10, VlionBidderSource vlionBidderSource, VlionLossReason vlionLossReason) {
        try {
            u uVar = this.f3573a;
            if (uVar != null) {
                uVar.a(d10, vlionBidderSource, vlionLossReason);
            } else {
                LogVlion.e("VlionManagerBase notifyWinPriceFailure ad is not ready");
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(long j10) {
        try {
            a();
            LogVlion.e("VlionManagerBase loadTimeOver   start =" + VlionDateUtils.getFormatDate(Long.valueOf(System.currentTimeMillis())) + " vlionSlot.getTolerateTime()=" + this.f3574b.f() + " cacheTime=" + this.f3577e);
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.f3578f = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new b(), j10, TimeUnit.SECONDS);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(d0 d0Var, long j10) {
        d0Var.getClass();
        if (j10 <= 0) {
            return;
        }
        try {
            d0Var.c();
            LogVlion.e("VlionManagerBase loadTimeOverService   start =" + VlionDateUtils.getFormatDate(Long.valueOf(System.currentTimeMillis())) + " vlionSlot.getTolerateTime()=" + d0Var.f3574b.f() + " cacheTime=" + j10);
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            d0Var.f3579g = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new e0(d0Var), j10, TimeUnit.MILLISECONDS);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(d0 d0Var, boolean z10) {
        synchronized (d0Var) {
            try {
                LogVlion.e("VlionManagerBase checkScheduled isFinished=" + d0Var.f3576d + " isServiceTimeOut=" + z10);
                if (!d0Var.f3576d) {
                    if (!z10) {
                        d0Var.f3576d = true;
                    }
                    VlionHandlerUtils.instant().post(new f0(d0Var, z10));
                }
            } finally {
            }
        }
    }
}
