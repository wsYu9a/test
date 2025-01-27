package cn.vlion.ad.inland.base;

import android.os.Handler;
import android.os.Message;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class j7 {

    /* renamed from: a */
    public static ExecutorService f2999a;

    public interface a {
        void a();

        void a(VlionAdBaseError vlionAdBaseError);

        void b();
    }

    public static class b extends Handler {

        /* renamed from: a */
        public a f3000a;

        public b(a aVar) {
            this.f3000a = aVar;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar;
            a aVar2;
            a aVar3;
            super.handleMessage(message);
            try {
                if (message.what == 4096 && (aVar3 = this.f3000a) != null) {
                    aVar3.b();
                }
                if (message.what == 4097 && (aVar2 = this.f3000a) != null) {
                    aVar2.a();
                }
                if (message.what != 4098 || (aVar = this.f3000a) == null) {
                    return;
                }
                aVar.a(new VlionAdBaseError(20007, (String) message.obj));
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }
}
