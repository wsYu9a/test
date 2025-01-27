package cn.vlion.ad.inland.base;

import android.text.TextUtils;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class c6 {

    /* renamed from: a */
    public static volatile c6 f2691a;

    /* renamed from: b */
    public static volatile f6 f2692b;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ n0 f2693a;

        public a(n0 n0Var) {
            this.f2693a = n0Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i10;
            try {
                n0 n0Var = this.f2693a;
                if (n0Var != null && !TextUtils.isEmpty(n0Var.f3109c)) {
                    LogVlion.e("VlionSendMessage addAdEvent:" + this.f2693a.f3109c);
                    try {
                        u4.a().a(this.f2693a);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        LogVlion.e("VlionSendMessage addAdEvent:Exception=" + e10);
                    }
                    p6.a().b();
                    if ("100".equals(this.f2693a.f3108b)) {
                        e6 e6Var = f6.f2802a;
                        i10 = 1;
                    } else {
                        e6 e6Var2 = f6.f2802a;
                        i10 = 2;
                    }
                    c6.this.getClass();
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
                    LogVlion.e("VlionSendMessageThread sendData:eventType=" + i10);
                    f6Var.a("", i10, 0);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static c6 a() {
        if (f2691a == null) {
            synchronized (c6.class) {
                try {
                    if (f2691a == null) {
                        f2691a = new c6();
                    }
                } finally {
                }
            }
        }
        return f2691a;
    }

    public final synchronized void a(n0 n0Var) {
        try {
            VlionHandlerUtils.instant().post(new a(n0Var));
        } finally {
        }
    }
}
