package com.zk_oaction.adengine.lk_view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import com.zk_oaction.adengine.lk_expression.c;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class g extends com.zk_oaction.adengine.lk_view.b implements c.b, com.zk_oaction.adengine.lk_sdk.interfaces.a {
    protected String V;
    protected String W;
    protected com.zk_oaction.adengine.lk_interfaces.b a0;
    protected Bitmap b0;
    protected Paint c0;
    protected Bitmap d0;
    protected h e0;
    protected String f0;
    protected Bitmap g0;
    protected Bitmap h0;
    protected BitmapFactory.Options i0;
    protected HandlerThread j0;
    protected Handler k0;
    protected boolean l0;
    protected int m0;
    ViewTreeObserver.OnGlobalLayoutListener n0;
    private com.zk_oaction.adengine.lk_view.a o0;
    private Path p0;
    private float q0;
    private float r0;
    private float s0;
    private float t0;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                com.zk_oaction.adengine.lk_sdk.c cVar = g.this.v;
                if (cVar == null || cVar.G == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(g.this.w)) {
                    hashMap.put("name", g.this.w);
                }
                hashMap.put("type", "onGlobalLayout");
                g gVar = g.this;
                gVar.v.G.b(gVar, hashMap);
                g.this.getViewTreeObserver().removeOnGlobalLayoutListener(g.this.n0);
                g.this.n0 = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                synchronized (g.this) {
                    g.this.h0 = BitmapFactory.decodeFile(g.this.v.H + message.obj, g.this.i0);
                }
                g.this.postInvalidate();
            } catch (Throwable unused) {
            }
        }
    }

    public g(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.b0 = null;
        this.c0 = null;
        this.m0 = 3;
    }

    private void R(Canvas canvas) {
        h hVar = this.e0;
        if (hVar != null) {
            hVar.y();
            canvas.drawBitmap(this.e0.T(), (Rect) null, this.s, (Paint) null);
            return;
        }
        Bitmap a0 = a0();
        if (J()) {
            S(canvas, a0);
            return;
        }
        if (a0 != null) {
            canvas.drawBitmap(a0, (Rect) null, this.s, this.c0);
            this.b0 = a0;
            return;
        }
        Bitmap bitmap = this.b0;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.b0, (Rect) null, this.s, this.c0);
    }

    private void S(Canvas canvas, Bitmap bitmap) {
        if (bitmap != null) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, com.zk_oaction.adengine.lk_sdk.c.f34877b, com.zk_oaction.adengine.lk_sdk.c.f34878c, this.c0, 31);
            f fVar = this.f35070e;
            if (fVar != null && fVar.Y().size() > 0) {
                Iterator<g> it = this.f35070e.Y().iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    Bitmap a0 = next.a0();
                    Rect c0 = next.c0();
                    if (a0 != null) {
                        canvas.drawBitmap(a0, (Rect) null, c0, (Paint) null);
                    }
                }
            }
            if (!TextUtils.isEmpty(this.f0)) {
                this.c0.setXfermode(com.zk_oaction.adengine.lk_util.a.a(this.f0));
            }
            canvas.drawBitmap(bitmap, (Rect) null, c0(), this.c0);
            this.c0.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        }
    }

    private boolean V(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.a aVar = new com.zk_oaction.adengine.lk_view.a(this.v);
        if (!aVar.h(xmlPullParser)) {
            return false;
        }
        aVar.f(this);
        aVar.c();
        T(aVar);
        return true;
    }

    private boolean X(XmlPullParser xmlPullParser) {
        this.W = this.V;
        return Z();
    }

    private void Y(String str) {
        try {
            if (TextUtils.isEmpty(str) || !"1".equals(str)) {
                return;
            }
            this.n0 = new a();
            getViewTreeObserver().addOnGlobalLayoutListener(this.n0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private Rect c0() {
        Rect rect = new Rect(this.s);
        float b2 = this.x.b();
        float b3 = this.y.b();
        rect.left = (int) (rect.left + b2);
        rect.top = (int) (rect.top + b3);
        rect.right = (int) (b2 + rect.right);
        rect.bottom = (int) (rect.bottom + b3);
        return rect;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bc A[Catch: all -> 0x00e4, TryCatch #0 {, blocks: (B:4:0x0001, B:6:0x0005, B:11:0x0008, B:13:0x0015, B:16:0x0020, B:18:0x0024, B:20:0x0045, B:22:0x0049, B:23:0x005c, B:24:0x00b6, B:25:0x00b8, B:27:0x00bc, B:28:0x00d5, B:29:0x005f, B:31:0x009a), top: B:3:0x0001, outer: #1 }] */
    @Override // com.zk_oaction.adengine.lk_view.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void D(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_view.g.D(java.lang.String):void");
    }

    @Override // com.zk_oaction.adengine.lk_view.b
    protected boolean J() {
        return (this.f35070e == null || TextUtils.isEmpty(this.f0)) ? false : true;
    }

    public void T(com.zk_oaction.adengine.lk_view.a aVar) {
        this.o0 = aVar;
        this.p0 = new Path();
        this.s0 = this.x.b();
        this.t0 = this.y.b();
        this.v.M.add(this);
    }

    public void U(String str, Bitmap bitmap) {
        this.V = str;
        this.d0 = bitmap;
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0066, code lost:
    
        if (X(r13) == false) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean W(org.xmlpull.v1.XmlPullParser r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "Mask"
            r12.s(r13)
            r1 = 1
            r2 = 0
            java.lang.String r3 = "src"
            r4 = 0
            java.lang.String r3 = r13.getAttributeValue(r4, r3)     // Catch: java.lang.Exception -> Lbe
            r12.V = r3     // Catch: java.lang.Exception -> Lbe
            java.lang.String r3 = "viewlistener"
            java.lang.String r3 = r13.getAttributeValue(r4, r3)     // Catch: java.lang.Exception -> Lbe
            r12.Y(r3)     // Catch: java.lang.Exception -> Lbe
            java.lang.String r3 = "xfermode"
            java.lang.String r3 = r13.getAttributeValue(r4, r3)     // Catch: java.lang.Exception -> Lbe
            r12.f0 = r3     // Catch: java.lang.Exception -> Lbe
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> Lbe
            if (r3 != 0) goto L31
            android.graphics.Paint r3 = new android.graphics.Paint     // Catch: java.lang.Exception -> Lbe
            r3.<init>()     // Catch: java.lang.Exception -> Lbe
            r12.c0 = r3     // Catch: java.lang.Exception -> Lbe
            r3.setAntiAlias(r1)     // Catch: java.lang.Exception -> Lbe
        L31:
            java.lang.String r3 = r12.V     // Catch: java.lang.Exception -> Lbe
            if (r3 == 0) goto L69
            char r3 = r3.charAt(r2)     // Catch: java.lang.Exception -> Lbe
            r5 = 64
            if (r3 != r5) goto L4d
            com.zk_oaction.adengine.lk_sdk.c r3 = r12.v     // Catch: java.lang.Exception -> Lbe
            com.zk_oaction.adengine.lk_variable.g r3 = r3.J     // Catch: java.lang.Exception -> Lbe
            java.lang.String r5 = r12.V     // Catch: java.lang.Exception -> Lbe
            java.lang.String r5 = r5.substring(r1)     // Catch: java.lang.Exception -> Lbe
            java.lang.String r3 = r3.h(r5)     // Catch: java.lang.Exception -> Lbe
            r12.V = r3     // Catch: java.lang.Exception -> Lbe
        L4d:
            java.lang.String r3 = "srcid"
            java.lang.String r8 = r13.getAttributeValue(r4, r3)     // Catch: java.lang.Exception -> Lbe
            if (r8 == 0) goto L62
            com.zk_oaction.adengine.lk_expression.a r5 = new com.zk_oaction.adengine.lk_expression.a     // Catch: java.lang.Exception -> Lbe
            com.zk_oaction.adengine.lk_sdk.c r6 = r12.v     // Catch: java.lang.Exception -> Lbe
            java.lang.String r7 = "srcid"
            r9 = 0
            r11 = 0
            r10 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> Lbe
            goto L78
        L62:
            boolean r3 = r12.X(r13)     // Catch: java.lang.Exception -> Lbe
            if (r3 != 0) goto L78
        L68:
            goto Lc2
        L69:
            java.lang.String r3 = "srcExp"
            java.lang.String r3 = r13.getAttributeValue(r4, r3)     // Catch: java.lang.Exception -> Lbe
            if (r3 == 0) goto L78
            com.zk_oaction.adengine.lk_expression.c r5 = new com.zk_oaction.adengine.lk_expression.c     // Catch: java.lang.Exception -> Lbe
            com.zk_oaction.adengine.lk_sdk.c r6 = r12.v     // Catch: java.lang.Exception -> Lbe
            r5.<init>(r6, r3, r12)     // Catch: java.lang.Exception -> Lbe
        L78:
            java.lang.String r3 = "forceLoad"
            java.lang.String r3 = r13.getAttributeValue(r4, r3)     // Catch: java.lang.Exception -> Lbe
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> Lbe
            if (r4 == 0) goto L8a
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Throwable -> L8a
            r12.m0 = r3     // Catch: java.lang.Throwable -> L8a
        L8a:
            boolean r14 = r12.t(r13, r14)     // Catch: java.lang.Exception -> Lbe
            if (r14 != 0) goto L91
            goto L68
        L91:
            java.lang.String r14 = r13.getName()     // Catch: java.lang.Exception -> Lbe
            boolean r14 = r14.equals(r0)     // Catch: java.lang.Exception -> Lbe
            if (r14 == 0) goto Lab
            com.zk_oaction.adengine.lk_view.h r14 = new com.zk_oaction.adengine.lk_view.h     // Catch: java.lang.Exception -> Lbe
            com.zk_oaction.adengine.lk_sdk.c r3 = r12.v     // Catch: java.lang.Exception -> Lbe
            r14.<init>(r3, r12)     // Catch: java.lang.Exception -> Lbe
            r12.e0 = r14     // Catch: java.lang.Exception -> Lbe
            boolean r13 = r14.S(r13, r0)     // Catch: java.lang.Exception -> Lbe
            if (r13 != 0) goto Lc3
            goto L68
        Lab:
            java.lang.String r14 = r13.getName()     // Catch: java.lang.Exception -> Lbe
            java.lang.String r0 = "Paint"
            boolean r14 = r14.equals(r0)     // Catch: java.lang.Exception -> Lbe
            if (r14 == 0) goto Lc3
            boolean r13 = r12.V(r13)     // Catch: java.lang.Exception -> Lbe
            if (r13 != 0) goto Lc3
            goto L68
        Lbe:
            r13 = move-exception
            r13.printStackTrace()
        Lc2:
            r1 = 0
        Lc3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_view.g.W(org.xmlpull.v1.XmlPullParser, java.lang.String):boolean");
    }

    protected boolean Z() {
        try {
            this.a0 = this.v.g(this.W, this, this.m0);
            if (this.z.b() == 0.0f || this.A.b() == 0.0f) {
                o(this.a0.d(), this.a0.c());
            }
            invalidate();
            return true;
        } catch (Exception unused) {
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void a() {
    }

    @Override // com.zk_oaction.adengine.lk_view.b, com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        if (str == null) {
            return;
        }
        if (!str.equals("srcid")) {
            super.a(str, f2);
            return;
        }
        int lastIndexOf = this.V.lastIndexOf(46);
        this.W = this.V.substring(0, lastIndexOf) + "_" + ((int) f2) + this.V.substring(lastIndexOf);
        Z();
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean a(float f2, float f3) {
        return true;
    }

    public Bitmap a0() {
        Bitmap bitmap = this.d0;
        return bitmap != null ? bitmap : this.a0.b();
    }

    public String b0() {
        return this.f0;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean c() {
        return false;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void d() {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.zk_oaction.adengine.lk_view.a aVar;
        try {
            synchronized (this) {
                Bitmap bitmap = this.h0;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, (Rect) null, this.s, this.c0);
                } else {
                    com.zk_oaction.adengine.lk_interfaces.b bVar = this.a0;
                    if (bVar != null || this.d0 != null) {
                        if (bVar == null || (aVar = this.o0) == null) {
                            R(canvas);
                        } else if (aVar.o()) {
                            this.o0.p();
                            this.o0 = null;
                            setVisibility(8);
                        } else {
                            this.o0.i().drawPath(this.p0, this.o0.m());
                            canvas.drawBitmap(this.o0.k(), 0.0f, 0.0f, (Paint) null);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void f(float f2, float f3) {
        if (this.o0 == null || getVisibility() != 0) {
            return;
        }
        this.q0 = f2;
        this.r0 = f3;
        this.p0.moveTo(f2 - this.s0, f3 - this.t0);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void h(float f2, float f3) {
        if (this.o0 == null || getVisibility() != 0) {
            return;
        }
        float abs = Math.abs(f2 - this.q0);
        float abs2 = Math.abs(f3 - this.r0);
        if (abs > 3.0f || abs2 > 3.0f) {
            this.p0.lineTo(f2 - this.s0, f3 - this.t0);
        }
        this.q0 = f2;
        this.r0 = f3;
        invalidate();
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void j(float f2, float f3) {
        if (this.o0 == null || getVisibility() != 0) {
            return;
        }
        this.o0.n();
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void k(float f2, float f3) {
    }

    @Override // com.zk_oaction.adengine.lk_expression.c.b
    public void m(String str) {
        this.W = str;
        Z();
    }

    @Override // android.view.View
    protected boolean onSetAlpha(int i2) {
        if (Build.VERSION.SDK_INT <= 19) {
            return false;
        }
        if (this.c0 == null) {
            Paint paint = new Paint();
            this.c0 = paint;
            paint.setAntiAlias(true);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 255) {
            i2 = 255;
        }
        this.c0.setAlpha(i2);
        return true;
    }

    @Override // com.zk_oaction.adengine.lk_view.b, android.view.View
    public void setTranslationX(float f2) {
        if (J()) {
            f2 = 0.0f;
        }
        super.setTranslationX(f2);
        h hVar = this.e0;
        if (hVar == null || hVar.R() != 1) {
            return;
        }
        invalidate();
    }

    @Override // com.zk_oaction.adengine.lk_view.b, android.view.View
    public void setTranslationY(float f2) {
        if (J()) {
            f2 = 0.0f;
        }
        super.setTranslationY(f2);
        h hVar = this.e0;
        if (hVar == null || hVar.R() != 1) {
            return;
        }
        invalidate();
    }
}
