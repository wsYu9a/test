package com.shu.priory.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.shu.priory.c.c;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.utils.h;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: c */
    private b f16881c;

    /* renamed from: d */
    private String f16882d;

    /* renamed from: e */
    private InterfaceC0551a f16883e;

    /* renamed from: a */
    c.b f16879a = new c.b() { // from class: com.shu.priory.c.a.1
        public AnonymousClass1() {
        }

        @Override // com.shu.priory.c.c.b
        public void a(Bitmap bitmap) {
            a.this.f16880b.sendMessage(a.this.f16880b.obtainMessage(1, bitmap));
            a.this.f16881c.a(bitmap);
        }

        @Override // com.shu.priory.c.c.b
        public void a(Exception exc) {
            Handler handler = a.this.f16880b;
            handler.sendMessage(handler.obtainMessage(1, null));
            h.d(SDKConstants.TAG, "get image from network failed!");
        }
    };

    /* renamed from: f */
    private final int f16884f = 1;

    /* renamed from: b */
    Handler f16880b = new Handler(Looper.getMainLooper()) { // from class: com.shu.priory.c.a.2
        public AnonymousClass2(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            a.this.f16883e.imageLoad((Bitmap) message.obj);
        }
    };

    /* renamed from: com.shu.priory.c.a$1 */
    public class AnonymousClass1 implements c.b {
        public AnonymousClass1() {
        }

        @Override // com.shu.priory.c.c.b
        public void a(Bitmap bitmap) {
            a.this.f16880b.sendMessage(a.this.f16880b.obtainMessage(1, bitmap));
            a.this.f16881c.a(bitmap);
        }

        @Override // com.shu.priory.c.c.b
        public void a(Exception exc) {
            Handler handler = a.this.f16880b;
            handler.sendMessage(handler.obtainMessage(1, null));
            h.d(SDKConstants.TAG, "get image from network failed!");
        }
    }

    /* renamed from: com.shu.priory.c.a$2 */
    public class AnonymousClass2 extends Handler {
        public AnonymousClass2(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            a.this.f16883e.imageLoad((Bitmap) message.obj);
        }
    }

    /* renamed from: com.shu.priory.c.a$a */
    public interface InterfaceC0551a {
        void imageLoad(Bitmap bitmap);
    }

    public a(Context context, String str) {
        this.f16882d = str;
        this.f16881c = new b(context, str);
    }

    public void a(InterfaceC0551a interfaceC0551a) {
        this.f16883e = interfaceC0551a;
        if (TextUtils.isEmpty(this.f16882d)) {
            interfaceC0551a.imageLoad(null);
            return;
        }
        Bitmap a10 = this.f16881c.a();
        if (a10 != null) {
            interfaceC0551a.imageLoad(a10);
        } else {
            new c(this.f16882d, this.f16879a).a();
        }
    }
}
