package com.opos.cmn.e.a.c.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import com.opos.cmn.e.a.c.c.e;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes4.dex */
public class d extends a implements c {

    /* renamed from: c */
    private com.opos.cmn.e.a.c.c.d f17003c;

    /* renamed from: d */
    private com.opos.cmn.e.a.c.a.a f17004d;

    /* renamed from: e */
    private View f17005e;

    /* renamed from: f */
    private String f17006f;

    /* renamed from: g */
    private boolean f17007g;

    /* renamed from: h */
    private Queue<com.opos.cmn.e.a.c.b.b> f17008h;

    /* renamed from: i */
    private final Handler f17009i;

    /* renamed from: com.opos.cmn.e.a.c.d.d$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    int i2 = message.what;
                    if (i2 == 1 || i2 == 2) {
                        d dVar = d.this;
                        dVar.b(null, null, dVar.f17006f, new Object[0]);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e2);
                }
            }
        }
    }

    public d(Context context, e eVar) {
        super(context, eVar);
        this.f17007g = false;
        this.f17008h = new ConcurrentLinkedQueue();
        this.f17009i = new Handler(Looper.getMainLooper()) { // from class: com.opos.cmn.e.a.c.d.d.1
            AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message != null) {
                    try {
                        int i2 = message.what;
                        if (i2 == 1 || i2 == 2) {
                            d dVar = d.this;
                            dVar.b(null, null, dVar.f17006f, new Object[0]);
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e2);
                    }
                }
            }
        };
        c();
    }

    private void a(com.opos.cmn.e.a.c.b.b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("show toastParams=");
        sb.append(bVar != null ? bVar.toString() : "null");
        com.opos.cmn.an.f.a.b("ReminderToastWidget", sb.toString());
        if (bVar != null) {
            this.f17004d.a(bVar.a(), bVar.b(), bVar.c());
            if (k()) {
                g();
            } else {
                if (this.f17005e == null) {
                    this.f17005e = this.f17004d.a();
                    d();
                }
                h();
            }
            String a2 = bVar.a();
            this.f17006f = a2;
            a((View) null, a2, new Object[0]);
            this.f17007g = true;
        }
    }

    private void c() {
        com.opos.cmn.e.a.c.a.b bVar = new com.opos.cmn.e.a.c.a.b(this.f16998a, this);
        this.f17004d = bVar;
        this.f17005e = bVar.a();
        if (k()) {
            e();
        } else {
            d();
        }
    }

    private void d() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 2002;
            layoutParams.flags = 136;
            layoutParams.width = com.opos.cmn.an.h.f.a.b(this.f16998a);
            layoutParams.height = com.opos.cmn.an.h.f.a.a(this.f16998a, 90.0f);
            layoutParams.gravity = 49;
            layoutParams.format = 1;
            View view = this.f17005e;
            if (view != null) {
                view.setVisibility(8);
                com.opos.cmn.an.h.f.a.a(this.f16998a, this.f17005e, layoutParams);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e2);
        }
    }

    private void e() {
        try {
            com.opos.cmn.e.a.c.c.c cVar = new com.opos.cmn.e.a.c.c.c(this.f16998a, null);
            this.f17003c = cVar;
            View view = this.f17005e;
            if (view != null) {
                cVar.a(view);
            }
            WindowManager.LayoutParams a2 = this.f17003c.a();
            if (a2 != null) {
                a2.flags = 136;
                a2.width = com.opos.cmn.an.h.f.a.b(this.f16998a);
                a2.height = com.opos.cmn.an.h.f.a.a(this.f16998a, 90.0f);
            }
            this.f17003c.a(49, 0, 0);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e2);
        }
    }

    private void f() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "showNext mIsShowing=" + this.f17007g);
        try {
            if (this.f17007g) {
                return;
            }
            a(this.f17008h.poll());
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e2);
        }
    }

    private void g() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "showCustomToast");
        try {
            this.f17003c.a(1);
            if (this.f17009i.hasMessages(2)) {
                this.f17009i.removeMessages(2);
            }
            this.f17003c.b();
            this.f17009i.sendEmptyMessageDelayed(2, 4000L);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e2);
        }
    }

    private void h() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "showFloatWindow ");
        try {
            if (this.f17009i.hasMessages(1)) {
                this.f17009i.removeMessages(1);
            }
            this.f17005e.setVisibility(0);
            this.f17005e.invalidate();
            this.f17009i.sendEmptyMessageDelayed(1, 3500L);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e2);
        }
    }

    private void i() {
        if (this.f17009i.hasMessages(2)) {
            this.f17009i.removeMessages(2);
        }
    }

    private void j() {
        if (this.f17009i.hasMessages(1)) {
            this.f17009i.removeMessages(1);
        }
        this.f17005e.setVisibility(8);
        this.f17005e.invalidate();
    }

    private boolean k() {
        boolean z;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e2);
        }
        if (com.opos.cmn.an.b.c.b() >= 19) {
            z = true;
            com.opos.cmn.an.f.a.b("ReminderToastWidget", "isToastSupportClick=" + z);
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "isToastSupportClick=" + z);
        return z;
    }

    @Override // com.opos.cmn.e.a.c.d.c
    public void a() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "cancelNotification");
        try {
            if (k()) {
                i();
            } else {
                j();
            }
            this.f17007g = false;
            f();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e2);
        }
    }

    public void a(View view, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onShow view=");
        sb.append(view != null ? view : "null");
        sb.append(",pkgName=");
        sb.append(str != null ? str : "null");
        sb.append(",objects=");
        sb.append(objArr != null ? objArr : "null");
        com.opos.cmn.an.f.a.b("ReminderToastWidget", sb.toString());
        this.f16999b.a(view, str, objArr);
    }

    @Override // com.opos.cmn.e.a.c.d.c
    public void a(View view, int[] iArr, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onClick view=");
        sb.append(view != null ? view : "null");
        sb.append(",pkgName=");
        sb.append(str != null ? str : "null");
        sb.append(",objects=");
        sb.append(objArr != null ? objArr : "null");
        com.opos.cmn.an.f.a.b("ReminderToastWidget", sb.toString());
        this.f16999b.a(view, iArr, str, objArr);
    }

    @Override // com.opos.cmn.e.a.c.d.c
    public void a(String str, boolean z, Object... objArr) {
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("show pkgName=");
            sb.append(str);
            sb.append(",gbClick=");
            sb.append(z);
            sb.append(",objects=");
            sb.append(objArr != null ? objArr : "null");
            com.opos.cmn.an.f.a.b("ReminderToastWidget", sb.toString());
            this.f17008h.offer(new com.opos.cmn.e.a.c.b.b(str, z, objArr));
            f();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e2);
        }
    }

    @Override // com.opos.cmn.e.a.c.d.c
    public void b() {
        com.opos.cmn.an.f.a.b("ReminderToastWidget", "destroyContext");
        try {
            if (k()) {
                com.opos.cmn.e.a.c.c.d dVar = this.f17003c;
                if (dVar != null) {
                    dVar.c();
                }
            } else {
                View view = this.f17005e;
                if (view != null) {
                    com.opos.cmn.an.h.f.a.a(this.f16998a, view);
                    this.f17005e = null;
                }
            }
            this.f17007g = false;
            this.f17008h.clear();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ReminderToastWidget", "", (Throwable) e2);
        }
    }

    @Override // com.opos.cmn.e.a.c.d.c
    public void b(View view, int[] iArr, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("onClose view=");
        sb.append(view != null ? view : "null");
        sb.append(",pkgName=");
        sb.append(str != null ? str : "null");
        sb.append(",objects=");
        sb.append(objArr != null ? objArr : "null");
        com.opos.cmn.an.f.a.b("ReminderToastWidget", sb.toString());
        this.f16999b.b(view, iArr, str, objArr);
    }
}
