package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: h */
    private HandlerThread f34727h;

    /* renamed from: i */
    private d f34728i;

    /* renamed from: j */
    private HandlerC0805c f34729j;
    private HandlerC0805c k;
    private b l;

    /* renamed from: a */
    HashMap<String, com.zk_oaction.adengine.bitmap.b> f34720a = new HashMap<>();

    /* renamed from: b */
    com.zk_oaction.adengine.bitmap.a f34721b = new com.zk_oaction.adengine.bitmap.a();

    /* renamed from: c */
    com.zk_oaction.adengine.bitmap.d f34722c = new com.zk_oaction.adengine.bitmap.d();

    /* renamed from: d */
    Handler f34723d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private int f34724e = 1;

    /* renamed from: f */
    private float f34725f = 1.0f;

    /* renamed from: g */
    private float f34726g = 1.0f;
    private ArrayList<com.zk_oaction.adengine.bitmap.b> m = new ArrayList<>();
    private HashMap<com.zk_oaction.adengine.bitmap.b, Long> n = new HashMap<>();
    private long o = 0;
    private int p = -1;
    private int q = -1;
    private int r = 4;
    private int s = 0;
    private boolean t = false;
    private int u = -1;
    private boolean v = false;
    private boolean w = true;

    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f34730a;

        /* renamed from: b */
        final /* synthetic */ float f34731b;

        /* renamed from: c */
        final /* synthetic */ boolean f34732c;

        a(String str, float f2, boolean z) {
            this.f34730a = str;
            this.f34731b = f2;
            this.f34732c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.v(this.f34730a, this.f34731b, this.f34732c);
        }
    }

    class b extends Handler {

        /* renamed from: a */
        public volatile boolean f34734a;

        /* renamed from: b */
        public volatile boolean f34735b;

        /* renamed from: d */
        private volatile long f34737d;

        public b(Looper looper) {
            super(looper);
            this.f34734a = false;
            this.f34735b = false;
            this.f34737d = 0L;
        }

        public void a() {
            synchronized (this) {
                this.f34735b = false;
                notify();
            }
        }

        public void b(long j2) {
            synchronized (this) {
                this.f34735b = true;
                this.f34737d = j2;
            }
        }

        public void c(boolean z) {
            synchronized (this) {
                this.f34734a = z;
                a();
                removeMessages(0);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f34734a) {
                return;
            }
            synchronized (this) {
                if (this.f34735b) {
                    try {
                        wait(this.f34737d);
                    } catch (InterruptedException unused) {
                    }
                    this.f34735b = false;
                }
            }
            if (this.f34734a) {
                return;
            }
            com.zk_oaction.adengine.bitmap.b bVar = (com.zk_oaction.adengine.bitmap.b) message.obj;
            if (bVar.i() == null) {
                if (message.what == 0) {
                    c.this.f34721b.b(bVar.f34714a);
                    return;
                }
                Bitmap t = c.this.t(bVar.f34714a, bVar.f34715b);
                if (t != null) {
                    if (this.f34734a) {
                        t.recycle();
                    } else {
                        bVar.c(t);
                        c.this.s(bVar.f34714a, bVar.f34715b, true);
                    }
                }
            }
        }
    }

    /* renamed from: com.zk_oaction.adengine.bitmap.c$c */
    class HandlerC0805c extends Handler {
        public void a(boolean z) {
            throw null;
        }
    }

    class d extends Handler {
    }

    public c() {
        y();
    }

    private void A() {
        synchronized (this) {
            HandlerC0805c handlerC0805c = this.f34729j;
            if (handlerC0805c != null) {
                handlerC0805c.a(true);
            }
        }
    }

    private void B() {
        synchronized (this) {
            d dVar = this.f34728i;
            if (dVar != null) {
                dVar.removeMessages(0);
            }
        }
    }

    private BitmapFactory.Options g(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    private com.zk_oaction.adengine.bitmap.b i(String str, float f2, boolean z) {
        com.zk_oaction.adengine.bitmap.b bVar;
        synchronized (this) {
            String p = p(str, f2);
            bVar = this.f34720a.get(p);
            if (z && bVar == null) {
                bVar = new com.zk_oaction.adengine.bitmap.b(str, f2);
                this.f34720a.put(p, bVar);
            }
        }
        return bVar;
    }

    private void n(com.zk_oaction.adengine.bitmap.b bVar, boolean z) {
        synchronized (this) {
            if (this.l == null) {
                this.l = new b(this.f34727h.getLooper());
            }
            if (this.w) {
                int i2 = !z ? 1 : 0;
                if (!this.l.hasMessages(i2, bVar)) {
                    this.l.sendMessage(this.l.obtainMessage(i2, bVar));
                }
            }
        }
    }

    public void s(String str, float f2, boolean z) {
        if (this.v) {
            return;
        }
        this.f34723d.post(new a(str, f2, z));
    }

    public Bitmap t(String str, float f2) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (f2 == -1.0f) {
            synchronized (this) {
                i4 = this.p;
                i5 = this.q;
            }
            i2 = i4;
            i3 = i5;
        } else {
            i2 = 0;
            i3 = 0;
        }
        try {
            com.zk_oaction.adengine.bitmap.d dVar = this.f34722c;
            if (dVar != null) {
                return dVar.a(str, f2, i2, i3, this.f34721b.b(str));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void v(String str, float f2, boolean z) {
        com.zk_oaction.adengine.bitmap.b i2;
        if (this.v || (i2 = i(str, f2, false)) == null || i2.a() == 0) {
            return;
        }
        i2.e(z);
    }

    private void y() {
        HandlerThread handlerThread = new HandlerThread("BitmapManager", -1);
        this.f34727h = handlerThread;
        handlerThread.start();
    }

    private void z() {
        synchronized (this) {
            HandlerC0805c handlerC0805c = this.k;
            if (handlerC0805c != null) {
                handlerC0805c.a(true);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:15|(3:45|46|(5:48|(3:3e|22|23)(1:71)|55|66|62))|17|18|(1:20)(2:26|(1:28)(3:(2:32|aa)|22|23))|21|22|23) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap a(java.lang.String r11, float r12, int r13) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.bitmap.c.a(java.lang.String, float, int):android.graphics.Bitmap");
    }

    public void e(String str, float f2, h hVar) {
        i(str, f2, true).d(hVar);
    }

    public com.zk_oaction.adengine.bitmap.b h(String str, float f2) {
        com.zk_oaction.adengine.bitmap.b bVar;
        synchronized (this) {
            bVar = this.f34720a.get(p(str, f2));
        }
        return bVar;
    }

    public void j() {
        synchronized (this) {
            A();
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                com.zk_oaction.adengine.bitmap.b bVar = this.m.get(i2);
                bVar.f();
                s(bVar.f34714a, bVar.f34715b, false);
            }
        }
    }

    public void k(int i2) {
        synchronized (this) {
            this.f34724e = i2;
        }
    }

    public void l(int i2, int i3) {
        synchronized (this) {
            if (i2 == 480 && i3 == 853) {
                i3 = 854;
            }
            this.p = i2;
            this.q = i3;
            this.o = i2 * i3 * 4;
        }
    }

    public void m(long j2) {
        synchronized (this) {
            if (this.l == null) {
                this.l = new b(this.f34727h.getLooper());
            }
            this.l.b(j2);
        }
    }

    protected String p(String str, float f2) {
        return str + "_" + f2;
    }

    public void q() {
        synchronized (this) {
            z();
            this.f34721b.a();
        }
    }

    public void u() {
        synchronized (this) {
            b bVar = this.l;
            if (bVar != null) {
                bVar.c(true);
                this.l = null;
            }
        }
    }

    public void w() {
        synchronized (this) {
            this.v = true;
            u();
            j();
            q();
            this.f34727h.quit();
            B();
            this.f34720a.clear();
            this.f34721b.a();
            this.f34722c = null;
            this.m.clear();
            this.n.clear();
        }
    }

    public void x() {
        synchronized (this) {
            b bVar = this.l;
            if (bVar != null) {
                bVar.a();
            }
        }
    }
}
