package com.shu.priory.download.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: a */
    private Handler f16940a = new Handler(Looper.getMainLooper()) { // from class: com.shu.priory.download.b.b.1
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            com.shu.priory.download.d.a aVar = (com.shu.priory.download.d.a) message.obj;
            if (aVar == null || aVar.f() == null) {
                return;
            }
            com.shu.priory.download.a.a f10 = aVar.f();
            switch (message.arg1) {
                case 1:
                    f10.a(aVar.h());
                    break;
                case 2:
                    f10.a(aVar.e(), aVar.d(), aVar.h());
                    break;
                case 4:
                    f10.e(aVar.h());
                    break;
                case 5:
                    f10.a(aVar.a(), aVar.h());
                    break;
                case 6:
                    f10.b(aVar.h());
                    break;
                case 7:
                    f10.c(aVar.h());
                    break;
                case 8:
                    f10.d(aVar.h());
                    break;
            }
        }
    };

    /* renamed from: b */
    private com.shu.priory.download.c.a f16941b;

    /* renamed from: com.shu.priory.download.b.b$1 */
    public class AnonymousClass1 extends Handler {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            com.shu.priory.download.d.a aVar = (com.shu.priory.download.d.a) message.obj;
            if (aVar == null || aVar.f() == null) {
                return;
            }
            com.shu.priory.download.a.a f10 = aVar.f();
            switch (message.arg1) {
                case 1:
                    f10.a(aVar.h());
                    break;
                case 2:
                    f10.a(aVar.e(), aVar.d(), aVar.h());
                    break;
                case 4:
                    f10.e(aVar.h());
                    break;
                case 5:
                    f10.a(aVar.a(), aVar.h());
                    break;
                case 6:
                    f10.b(aVar.h());
                    break;
                case 7:
                    f10.c(aVar.h());
                    break;
                case 8:
                    f10.d(aVar.h());
                    break;
            }
        }
    }

    public b(com.shu.priory.download.c.a aVar) {
        this.f16941b = aVar;
    }

    @Override // com.shu.priory.download.b.a
    public void a(com.shu.priory.download.d.a aVar) {
        if (aVar == null) {
            return;
        }
        Message obtainMessage = this.f16940a.obtainMessage(aVar.h());
        obtainMessage.obj = aVar;
        obtainMessage.arg1 = aVar.g();
        obtainMessage.sendToTarget();
        if (aVar.g() == 4) {
            this.f16941b.a(aVar);
        }
    }
}
