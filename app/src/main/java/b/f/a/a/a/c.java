package b.f.a.a.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;
import org.mozilla.universalchardet.prober.g;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    private static final String f4806a = "c";

    /* renamed from: b */
    private static final int f4807b = 240;

    /* renamed from: c */
    private static final int f4808c = 240;

    /* renamed from: d */
    private static final int f4809d = 480;

    /* renamed from: e */
    private static final int f4810e = 360;

    /* renamed from: f */
    private static c f4811f;

    /* renamed from: g */
    static final int f4812g;

    /* renamed from: h */
    private final Context f4813h;

    /* renamed from: i */
    private final b f4814i;

    /* renamed from: j */
    private Camera f4815j;
    private Rect k;
    private Rect l;
    private boolean m;
    private boolean n;
    private final boolean o;
    private final f p;
    private final a q;

    static {
        int i2;
        try {
            i2 = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            i2 = 10000;
        }
        f4812g = i2;
    }

    private c(Context context) {
        this.f4813h = context;
        b bVar = new b(context);
        this.f4814i = bVar;
        boolean z = Integer.parseInt(Build.VERSION.SDK) > 3;
        this.o = z;
        this.p = new f(bVar, z);
        this.q = new a();
    }

    public static c c() {
        return f4811f;
    }

    public static void f(Context context) {
        if (f4811f == null) {
            f4811f = new c(context);
        }
    }

    public e a(byte[] data, int width, int height) {
        Rect e2 = e();
        int f2 = this.f4814i.f();
        String g2 = this.f4814i.g();
        if (f2 == 16 || f2 == 17) {
            return new e(data, width, height, e2.left, e2.top, e2.width(), e2.height());
        }
        if ("yuv420p".equals(g2)) {
            return new e(data, width, height, e2.left, e2.top, e2.width(), e2.height());
        }
        throw new IllegalArgumentException("Unsupported picture format: " + f2 + '/' + g2);
    }

    public void b() {
        if (this.f4815j != null) {
            d.a();
            this.f4815j.release();
            this.f4815j = null;
        }
    }

    public Rect d() {
        Point h2 = this.f4814i.h();
        if (this.k == null) {
            if (this.f4815j == null) {
                return null;
            }
            int i2 = h2.x;
            int i3 = (i2 * 3) / 4;
            int i4 = g.n;
            if (i3 < 240) {
                i3 = g.n;
            } else if (i3 > f4809d) {
                i3 = f4809d;
            }
            int i5 = h2.y;
            int i6 = (i5 * 3) / 4;
            if (i6 >= 240) {
                i4 = i6 > f4810e ? f4810e : i6;
            }
            int i7 = (i2 - i3) / 2;
            int i8 = (i5 - i4) / 2;
            this.k = new Rect(i7, i8, i3 + i7, i4 + i8);
            Log.d(f4806a, "Calculated framing rect: " + this.k);
        }
        return this.k;
    }

    public Rect e() {
        if (this.l == null) {
            Rect rect = new Rect(d());
            Point c2 = this.f4814i.c();
            Point h2 = this.f4814i.h();
            int i2 = rect.left;
            int i3 = c2.y;
            int i4 = h2.x;
            rect.left = (i2 * i3) / i4;
            rect.right = (rect.right * i3) / i4;
            int i5 = rect.top;
            int i6 = c2.x;
            int i7 = h2.y;
            rect.top = (i5 * i6) / i7;
            rect.bottom = (rect.bottom * i6) / i7;
            this.l = rect;
        }
        return this.l;
    }

    public void g(SurfaceHolder holder) throws IOException {
        if (this.f4815j == null) {
            Camera open = Camera.open();
            this.f4815j = open;
            if (open == null) {
                throw new IOException();
            }
            open.setPreviewDisplay(holder);
            if (!this.m) {
                this.m = true;
                this.f4814i.i(this.f4815j);
            }
            this.f4814i.j(this.f4815j);
            d.b();
        }
    }

    public Context getContext() {
        return this.f4813h;
    }

    public void h(Handler handler, int message) {
        if (this.f4815j == null || !this.n) {
            return;
        }
        this.q.a(handler, message);
        this.f4815j.autoFocus(this.q);
    }

    public void i(Handler handler, int message) {
        if (this.f4815j == null || !this.n) {
            return;
        }
        this.p.a(handler, message);
        if (this.o) {
            this.f4815j.setOneShotPreviewCallback(this.p);
        } else {
            this.f4815j.setPreviewCallback(this.p);
        }
    }

    public void j() {
        Camera camera = this.f4815j;
        if (camera == null || this.n) {
            return;
        }
        camera.startPreview();
        this.n = true;
    }

    public void k() {
        Camera camera = this.f4815j;
        if (camera == null || !this.n) {
            return;
        }
        if (!this.o) {
            camera.setPreviewCallback(null);
        }
        this.f4815j.stopPreview();
        this.p.a(null, 0);
        this.q.a(null, 0);
        this.n = false;
    }
}
