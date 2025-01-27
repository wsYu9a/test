package cn.vlion.ad.inland.base;

import android.text.TextUtils;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class p6 {

    /* renamed from: b */
    public static volatile p6 f3295b;

    /* renamed from: a */
    public volatile ScheduledThreadPoolExecutor f3296a;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            LogVlion.e("VlionTimerManager 定时到，上报事件！");
            c6.a().getClass();
            try {
                String reportUrl = VlionServiceConfigParse.getInstance().getReportUrl();
                e6 e6Var = f6.f2802a;
                if (TextUtils.isEmpty(reportUrl)) {
                    LogVlion.e("2,上报所有事件，但没有配置url！");
                    return;
                }
                LogVlion.e("2,上报所有事件，发送消息，读取本地所有事件进行上报！");
                if (c6.f2692b == null) {
                    synchronized (f6.class) {
                        try {
                            if (c6.f2692b == null) {
                                c6.f2692b = new f6();
                            }
                        } finally {
                        }
                    }
                }
                f6 f6Var = c6.f2692b;
                f6Var.getClass();
                LogVlion.e("VlionSendMessageThread sendData:eventType=2");
                f6Var.a("", 2, 0);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static p6 a() {
        if (f3295b == null) {
            synchronized (p6.class) {
                try {
                    if (f3295b == null) {
                        f3295b = new p6();
                    }
                } finally {
                }
            }
        }
        return f3295b;
    }

    public final synchronized void b() {
        try {
        } finally {
        }
        if (this.f3296a == null || this.f3296a.isShutdown()) {
            LogVlion.e("VlionTimerManager开启定时器");
            this.f3296a = new ScheduledThreadPoolExecutor(1);
            this.f3296a.scheduleAtFixedRate(new a(), 0L, 15L, TimeUnit.SECONDS);
        }
    }
}
