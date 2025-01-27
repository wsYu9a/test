package com.zk_oaction.adengine.lk_sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a */
    private static float[] f34861a = {0.0f, 0.0f};

    /* renamed from: b */
    private float[] f34862b;

    /* renamed from: c */
    private int f34863c;

    /* renamed from: d */
    private float f34864d;

    /* renamed from: e */
    private float f34865e;

    /* renamed from: f */
    private float f34866f;

    /* renamed from: g */
    private float f34867g;

    /* renamed from: h */
    private Handler f34868h;

    /* renamed from: com.zk_oaction.adengine.lk_sdk.a$a */
    class HandlerC0808a extends Handler {

        /* renamed from: a */
        final /* synthetic */ long f34869a;

        /* renamed from: b */
        final /* synthetic */ float f34870b;

        /* renamed from: c */
        final /* synthetic */ float f34871c;

        /* renamed from: d */
        final /* synthetic */ float f34872d;

        /* renamed from: e */
        final /* synthetic */ b f34873e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        HandlerC0808a(Looper looper, long j2, float f2, float f3, float f4, b bVar) {
            super(looper);
            this.f34869a = j2;
            this.f34870b = f2;
            this.f34871c = f3;
            this.f34872d = f4;
            this.f34873e = bVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0101, code lost:
        
            if (com.zk_oaction.adengine.lk_sdk.a.this.f34863c < com.zk_oaction.adengine.lk_sdk.a.this.f34862b.length) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0180, code lost:
        
            if (com.zk_oaction.adengine.lk_sdk.a.this.f34863c < com.zk_oaction.adengine.lk_sdk.a.this.f34862b.length) goto L56;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0196  */
        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r7) {
            /*
                Method dump skipped, instructions count: 412
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_sdk.a.HandlerC0808a.handleMessage(android.os.Message):void");
        }
    }

    public interface b {
        void a();

        void a(float f2);
    }

    static /* synthetic */ int k(a aVar) {
        int i2 = aVar.f34863c;
        aVar.f34863c = i2 + 1;
        return i2;
    }

    public void c(float f2, float f3, float f4, b bVar, float[] fArr) {
        if (fArr != null) {
            this.f34862b = (float[]) fArr.clone();
        }
        if (this.f34862b == null) {
            this.f34862b = f34861a;
        }
        this.f34863c = 1;
        this.f34864d = 0.0f;
        this.f34865e = 0.0f;
        this.f34866f = 0.036f;
        this.f34867g = 6.0E-4f;
        HandlerC0808a handlerC0808a = new HandlerC0808a(Looper.getMainLooper(), SystemClock.uptimeMillis(), f4, f2, f3, bVar);
        this.f34868h = handlerC0808a;
        handlerC0808a.sendEmptyMessageDelayed(0, 16L);
    }
}
