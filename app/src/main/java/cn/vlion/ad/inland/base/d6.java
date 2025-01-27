package cn.vlion.ad.inland.base;

import android.text.TextUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class d6 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ l0 f2710a;

    /* renamed from: b */
    public final /* synthetic */ c6 f2711b;

    public d6(c6 c6Var, l0 l0Var) {
        this.f2711b = c6Var;
        this.f2710a = l0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            l0 l0Var = this.f2710a;
            if (l0Var != null && !TextUtils.isEmpty(l0Var.f3058b)) {
                LogVlion.e("VlionSendMessage addAdxEvents:" + this.f2710a.f3058b);
                try {
                    o0.a().a(this.f2710a);
                } catch (Exception e10) {
                    e10.printStackTrace();
                    LogVlion.e("VlionSendMessage addAdxEvents:Exception=" + e10);
                }
                p6.a().b();
                e6 e6Var = f6.f2802a;
                this.f2711b.getClass();
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
                LogVlion.e("VlionSendMessageThread sendData:eventType=1");
                f6Var.a("", 1, 0);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
