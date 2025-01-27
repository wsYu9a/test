package com.opos.cmn.an.f.a;

import android.os.HandlerThread;
import android.os.Message;
import com.opos.cmn.an.f.a.b.a;
import com.opos.cmn.an.f.a.b.c;
import com.opos.cmn.an.f.a.b.d;
import com.opos.cmn.an.f.a.b.f;

/* loaded from: classes4.dex */
public class e implements b {

    /* renamed from: a */
    private HandlerThread f16446a;

    /* renamed from: b */
    private d f16447b;

    /* renamed from: c */
    private volatile boolean f16448c = false;

    private void a(int i2, String str, Object obj, Throwable th, int i3) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            i3 = 1;
            obj = "null";
        }
        try {
            if (this.f16448c) {
                Message obtain = Message.obtain();
                com.opos.cmn.an.f.a.b.d a2 = new d.a().a(i2).a(obj).a(str).a(th).a(Thread.currentThread().getId()).b(Thread.currentThread().getName()).b(System.currentTimeMillis()).b(i3).a();
                obtain.what = 2;
                obtain.obj = a2;
                this.f16447b.sendMessage(obtain);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a() {
        if (this.f16448c) {
            this.f16448c = false;
            try {
                Message obtain = Message.obtain();
                com.opos.cmn.an.f.a.b.a a2 = new a.C0370a().a();
                obtain.what = 5;
                obtain.obj = a2;
                this.f16447b.sendMessage(obtain);
                this.f16446a.quitSafely();
                this.f16446a = null;
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(com.opos.cmn.an.f.b.b bVar) {
        try {
            HandlerThread handlerThread = new HandlerThread("adLoganThread");
            this.f16446a = handlerThread;
            handlerThread.start();
            this.f16447b = new d(this.f16446a.getLooper());
            Message obtain = Message.obtain();
            com.opos.cmn.an.f.a.b.c a2 = new c.a().a(bVar).a();
            obtain.what = 1;
            obtain.obj = a2;
            this.f16447b.sendMessage(obtain);
            this.f16448c = true;
        } catch (Exception unused) {
        }
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(com.opos.cmn.an.f.b.c cVar, com.opos.cmn.an.f.b.a aVar) {
        if (this.f16448c) {
            try {
                Message obtain = Message.obtain();
                com.opos.cmn.an.f.a.b.f a2 = new f.a().a(cVar).a(aVar).a();
                obtain.what = 3;
                obtain.obj = a2;
                this.f16447b.sendMessage(obtain);
            } catch (Exception unused) {
                if (aVar != null) {
                    aVar.onUploaderFailed("unkown error");
                }
            }
        }
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(String str, Object obj) {
        a(2, str, obj, null, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(String str, Object obj, Throwable th) {
        a(3, str, obj, th, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(String str, String str2) {
        a(3, str, str2, null, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(String str, String str2, Throwable th) {
        a(3, str, str2, th, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void a(String str, Object... objArr) {
        a(3, str, objArr, null, 2);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void b(String str, String str2) {
        a(2, str, str2, null, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void b(String str, String str2, Throwable th) {
        a(2, str, str2, th, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void b(String str, Object... objArr) {
        a(2, str, objArr, null, 2);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void c(String str, String str2) {
        a(4, str, str2, null, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void c(String str, String str2, Throwable th) {
        a(4, str, str2, th, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void c(String str, Object... objArr) {
        a(4, str, objArr, null, 2);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void d(String str, String str2) {
        a(5, str, str2, null, 1);
    }

    @Override // com.opos.cmn.an.f.a.b
    public void d(String str, String str2, Throwable th) {
        a(5, str, str2, th, 1);
    }
}
