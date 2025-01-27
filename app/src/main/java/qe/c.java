package qe;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: k */
    public static final String f30021k = "c";

    /* renamed from: l */
    public static final int f30022l = 240;

    /* renamed from: m */
    public static final int f30023m = 240;

    /* renamed from: n */
    public static final int f30024n = 480;

    /* renamed from: o */
    public static final int f30025o = 360;

    /* renamed from: p */
    public static c f30026p;

    /* renamed from: q */
    public static final int f30027q;

    /* renamed from: a */
    public final Context f30028a;

    /* renamed from: b */
    public final b f30029b;

    /* renamed from: c */
    public Camera f30030c;

    /* renamed from: d */
    public Rect f30031d;

    /* renamed from: e */
    public Rect f30032e;

    /* renamed from: f */
    public boolean f30033f;

    /* renamed from: g */
    public boolean f30034g;

    /* renamed from: h */
    public final boolean f30035h;

    /* renamed from: i */
    public final f f30036i;

    /* renamed from: j */
    public final a f30037j;

    static {
        int i10;
        try {
            i10 = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            i10 = 10000;
        }
        f30027q = i10;
    }

    public c(Context context) {
        this.f30028a = context;
        b bVar = new b(context);
        this.f30029b = bVar;
        boolean z10 = Integer.parseInt(Build.VERSION.SDK) > 3;
        this.f30035h = z10;
        this.f30036i = new f(bVar, z10);
        this.f30037j = new a();
    }

    public static c c() {
        return f30026p;
    }

    public static void f(Context context) {
        if (f30026p == null) {
            f30026p = new c(context);
        }
    }

    public e a(byte[] bArr, int i10, int i11) {
        Rect e10 = e();
        int f10 = this.f30029b.f();
        String g10 = this.f30029b.g();
        if (f10 == 16 || f10 == 17) {
            return new e(bArr, i10, i11, e10.left, e10.top, e10.width(), e10.height());
        }
        if ("yuv420p".equals(g10)) {
            return new e(bArr, i10, i11, e10.left, e10.top, e10.width(), e10.height());
        }
        throw new IllegalArgumentException("Unsupported picture format: " + f10 + '/' + g10);
    }

    public void b() {
        if (this.f30030c != null) {
            d.a();
            this.f30030c.release();
            this.f30030c = null;
        }
    }

    public Rect d() {
        Point h10 = this.f30029b.h();
        if (this.f30031d == null) {
            if (this.f30030c == null) {
                return null;
            }
            int i10 = h10.x;
            int i11 = (i10 * 3) / 4;
            int i12 = 240;
            if (i11 < 240) {
                i11 = 240;
            } else if (i11 > 480) {
                i11 = f30024n;
            }
            int i13 = h10.y;
            int i14 = (i13 * 3) / 4;
            if (i14 >= 240) {
                i12 = f30025o;
                if (i14 <= 360) {
                    i12 = i14;
                }
            }
            int i15 = (i10 - i11) / 2;
            int i16 = (i13 - i12) / 2;
            this.f30031d = new Rect(i15, i16, i11 + i15, i12 + i16);
            Log.d(f30021k, "Calculated framing rect: " + this.f30031d);
        }
        return this.f30031d;
    }

    public Rect e() {
        if (this.f30032e == null) {
            Rect rect = new Rect(d());
            Point c10 = this.f30029b.c();
            Point h10 = this.f30029b.h();
            int i10 = rect.left;
            int i11 = c10.y;
            int i12 = h10.x;
            rect.left = (i10 * i11) / i12;
            rect.right = (rect.right * i11) / i12;
            int i13 = rect.top;
            int i14 = c10.x;
            int i15 = h10.y;
            rect.top = (i13 * i14) / i15;
            rect.bottom = (rect.bottom * i14) / i15;
            this.f30032e = rect;
        }
        return this.f30032e;
    }

    public void g(SurfaceHolder surfaceHolder) throws IOException {
        if (this.f30030c == null) {
            Camera open = Camera.open();
            this.f30030c = open;
            if (open == null) {
                throw new IOException();
            }
            open.setPreviewDisplay(surfaceHolder);
            if (!this.f30033f) {
                this.f30033f = true;
                this.f30029b.i(this.f30030c);
            }
            this.f30029b.j(this.f30030c);
            d.b();
        }
    }

    public Context getContext() {
        return this.f30028a;
    }

    public void h(Handler handler, int i10) {
        if (this.f30030c == null || !this.f30034g) {
            return;
        }
        this.f30037j.a(handler, i10);
        this.f30030c.autoFocus(this.f30037j);
    }

    public void i(Handler handler, int i10) {
        if (this.f30030c == null || !this.f30034g) {
            return;
        }
        this.f30036i.a(handler, i10);
        if (this.f30035h) {
            this.f30030c.setOneShotPreviewCallback(this.f30036i);
        } else {
            this.f30030c.setPreviewCallback(this.f30036i);
        }
    }

    public void j() {
        Camera camera = this.f30030c;
        if (camera == null || this.f30034g) {
            return;
        }
        camera.startPreview();
        this.f30034g = true;
    }

    public void k() {
        Camera camera = this.f30030c;
        if (camera == null || !this.f30034g) {
            return;
        }
        if (!this.f30035h) {
            camera.setPreviewCallback(null);
        }
        this.f30030c.stopPreview();
        this.f30036i.a(null, 0);
        this.f30037j.a(null, 0);
        this.f30034g = false;
    }
}
