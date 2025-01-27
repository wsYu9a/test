package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.util.date.VlionDateUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class e0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ d0 f3582a;

    public e0(d0 d0Var) {
        this.f3582a = d0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VlionManagerBase loadTimeOverService end=");
            sb2.append(VlionDateUtils.getFormatDate(Long.valueOf(System.currentTimeMillis())));
            sb2.append(" (null != vlionLoadAdSourceManager)=");
            sb2.append(this.f3582a.f3573a != null);
            LogVlion.e(sb2.toString());
            d0.a(this.f3582a, true);
            this.f3582a.c();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
