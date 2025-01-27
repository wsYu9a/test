package com.shu.priory.b;

import android.content.Context;
import com.shu.priory.IFLYAdSDK;
import com.shu.priory.config.AdError;
import com.shu.priory.config.ErrorCode;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.param.AdParam;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public abstract class b<T> {

    /* renamed from: a */
    protected AdParam f16819a;

    /* renamed from: b */
    protected Context f16820b;

    /* renamed from: c */
    protected com.shu.priory.g.b f16821c;

    /* renamed from: d */
    protected String f16822d;

    /* renamed from: f */
    private final com.shu.priory.request.c f16824f = new com.shu.priory.request.c() { // from class: com.shu.priory.b.b.1
        public AnonymousClass1() {
        }

        @Override // com.shu.priory.request.c
        public void a(int i10) {
            try {
                b.this.f16823e.a(1, new AdError(i10));
            } catch (Throwable unused) {
                h.d(SDKConstants.TAG, " ad request error " + i10);
            }
        }

        @Override // com.shu.priory.request.c
        public void a(byte[] bArr) {
            try {
                b.this.f16821c.a(bArr, false);
                b.this.a();
            } catch (AdError e10) {
                b.this.f16823e.a(1, e10);
            } catch (Throwable th2) {
                b.this.f16823e.a(1, new AdError(ErrorCode.ERROR_NETWORK));
                h.d(SDKConstants.TAG, th2.getMessage());
            }
        }
    };

    /* renamed from: e */
    protected a<T> f16823e = new a<>();

    /* renamed from: com.shu.priory.b.b$1 */
    public class AnonymousClass1 implements com.shu.priory.request.c {
        public AnonymousClass1() {
        }

        @Override // com.shu.priory.request.c
        public void a(int i10) {
            try {
                b.this.f16823e.a(1, new AdError(i10));
            } catch (Throwable unused) {
                h.d(SDKConstants.TAG, " ad request error " + i10);
            }
        }

        @Override // com.shu.priory.request.c
        public void a(byte[] bArr) {
            try {
                b.this.f16821c.a(bArr, false);
                b.this.a();
            } catch (AdError e10) {
                b.this.f16823e.a(1, e10);
            } catch (Throwable th2) {
                b.this.f16823e.a(1, new AdError(ErrorCode.ERROR_NETWORK));
                h.d(SDKConstants.TAG, th2.getMessage());
            }
        }
    }

    public b(Context context, String str) {
        this.f16820b = context;
        this.f16822d = str;
        this.f16819a = new AdParam(str);
        this.f16821c = new com.shu.priory.g.b(this.f16820b.getApplicationContext());
        h.a(SDKConstants.TAG, "personalizedState:" + IFLYAdSDK.getPersonalizedState());
    }

    public abstract void a();

    public void a(String str, Object obj) {
        this.f16819a.setParameter(str, obj);
    }

    public synchronized void b() {
        try {
            try {
                com.shu.priory.request.e.a(this.f16820b.getApplicationContext(), this.f16819a, this.f16824f);
            } catch (AdError e10) {
                this.f16823e.a(1, e10);
                h.a(SDKConstants.TAG, e10.getErrorDescription());
            } catch (Throwable th2) {
                h.d(SDKConstants.TAG, th2.getMessage());
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }
}
