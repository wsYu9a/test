package cn.vlion.ad.inland.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class e6 extends Handler {

    /* renamed from: a */
    public final /* synthetic */ f6 f2766a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e6(f6 f6Var, Looper looper) {
        super(looper);
        this.f2766a = f6Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        f6 f6Var = this.f2766a;
        f6Var.getClass();
        try {
            LogVlion.e("VlionSendMessageThread handleSendMessage");
            if (message == null) {
                return;
            }
            if (f6.f2802a != null) {
                f6.f2802a.removeMessages(message.what, message.obj);
            }
            int i10 = message.what;
            Object obj = message.obj;
            f6Var.a(i10, obj == null ? "" : obj.toString());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
