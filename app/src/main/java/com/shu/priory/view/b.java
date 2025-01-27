package com.shu.priory.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.a;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class b extends Handler {

    /* renamed from: a */
    private a.c f17448a;

    /* renamed from: b */
    private a f17449b;

    public interface a {
        void a();

        void a(Message message);

        void b();

        void b(Message message);

        void c();

        void c(Message message);
    }

    /* renamed from: com.shu.priory.view.b$b */
    public enum EnumC0559b {
        max,
        normal,
        min
    }

    public b(Looper looper, a aVar) {
        super(looper);
        this.f17448a = a.c.init;
        this.f17449b = aVar;
    }

    public synchronized a.c a() {
        return this.f17448a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            int i10 = message.what;
            if (i10 == 1) {
                this.f17449b.a(message);
            } else if (i10 == 2) {
                this.f17449b.a();
            } else if (i10 == 3) {
                this.f17449b.b();
            } else if (i10 == 4) {
                this.f17449b.b(message);
            } else if (i10 == 5) {
                this.f17449b.c(message);
            } else if (i10 == 7) {
                this.f17449b.c();
            }
        } catch (Exception e10) {
            a(a.c.end);
            h.d(SDKConstants.TAG, "process handle:" + e10.getMessage());
        }
    }

    public void a(int i10) {
        a(obtainMessage(i10), EnumC0559b.normal, 0);
    }

    public void a(int i10, int i11) {
        a(obtainMessage(i10, Integer.valueOf(i11)), EnumC0559b.normal, 0);
    }

    public void a(Message message, int i10) {
        a(message, EnumC0559b.normal, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.os.Message r4, com.shu.priory.view.b.EnumC0559b r5, int r6) {
        /*
            r3 = this;
            com.shu.priory.utils.a$c r0 = r3.a()
            com.shu.priory.utils.a$c r1 = com.shu.priory.utils.a.c.exit
            if (r0 != r1) goto L10
            java.lang.String r4 = "IFLY_AD_SDK"
            java.lang.String r5 = "Ad status is exit, invalid request!"
            com.shu.priory.utils.h.a(r4, r5)
            return
        L10:
            int r0 = r4.what
            if (r0 == 0) goto L37
            r2 = 1
            if (r0 == r2) goto L34
            r2 = 2
            if (r0 == r2) goto L31
            r2 = 3
            if (r0 == r2) goto L2e
            r2 = 5
            if (r0 == r2) goto L28
            r2 = 7
            if (r0 == r2) goto L24
            goto L3a
        L24:
            r3.a(r1)
            goto L3a
        L28:
            com.shu.priory.utils.a$c r0 = com.shu.priory.utils.a.c.end
        L2a:
            r3.a(r0)
            goto L3a
        L2e:
            com.shu.priory.utils.a$c r0 = com.shu.priory.utils.a.c.show
            goto L2a
        L31:
            com.shu.priory.utils.a$c r0 = com.shu.priory.utils.a.c.response
            goto L2a
        L34:
            com.shu.priory.utils.a$c r0 = com.shu.priory.utils.a.c.request
            goto L2a
        L37:
            com.shu.priory.utils.a$c r0 = com.shu.priory.utils.a.c.init
            goto L2a
        L3a:
            com.shu.priory.view.b$b r0 = com.shu.priory.view.b.EnumC0559b.max
            if (r0 != r5) goto L42
            r3.sendMessageAtFrontOfQueue(r4)
            goto L46
        L42:
            long r5 = (long) r6
            r3.sendMessageDelayed(r4, r5)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.view.b.a(android.os.Message, com.shu.priory.view.b$b, int):void");
    }

    public synchronized void a(a.c cVar) {
        h.a(SDKConstants.TAG, "setStatus: pre=" + this.f17448a + ", cur=" + cVar);
        if (this.f17448a == a.c.exit) {
            h.a(SDKConstants.TAG, "Invalid setting of ad status, current status is already exit!");
        } else {
            this.f17448a = cVar;
        }
    }
}
