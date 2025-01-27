package com.zk_oaction.adengine.lk_view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.view.ViewGroup;
import com.zk_oaction.adengine.lk_view.n;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class c extends ViewGroup implements com.zk_oaction.adengine.lk_sdk.interfaces.f {

    /* renamed from: a */
    private com.zk_oaction.adengine.lk_sdk.c f35098a;

    /* renamed from: b */
    private n f35099b;

    /* renamed from: c */
    private Bitmap f35100c;

    /* renamed from: d */
    private String f35101d;

    class a implements n.i {

        /* renamed from: com.zk_oaction.adengine.lk_view.c$a$a */
        class RunnableC0819a implements Runnable {
            RunnableC0819a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.invalidate();
            }
        }

        a() {
        }

        @Override // com.zk_oaction.adengine.lk_view.n.i
        public void a() {
            if (c.this.f35100c != null && !c.this.f35100c.isRecycled()) {
                c.this.f35100c.recycle();
                c.this.f35100c = null;
            }
            Handler handler = c.this.getHandler();
            if (handler != null) {
                handler.postDelayed(new RunnableC0819a(), 0L);
            }
        }
    }

    public c(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar.F);
        this.f35098a = cVar;
        n nVar = new n(cVar, new a());
        this.f35099b = nVar;
        addView(nVar);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void a(String str) {
        this.f35099b.f(str);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void b(String str) {
    }

    public void c() {
        n nVar = this.f35099b;
        if (nVar != null) {
            nVar.u();
            this.f35099b = null;
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void c(String str) {
    }

    public void d(float f2) {
        this.f35099b.c(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        String str;
        super.dispatchDraw(canvas);
        if (this.f35099b.t || (str = this.f35101d) == null) {
            return;
        }
        if (this.f35100c == null) {
            this.f35100c = BitmapFactory.decodeFile(str);
        }
        Bitmap bitmap = this.f35100c;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight()), (Paint) null);
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public String e() {
        return this.f35099b.b();
    }

    public void e(String str, int i2, String str2, String str3, String str4) {
        this.f35099b.g(str, i2, str2, str3, str4);
    }

    public void f(boolean z) {
        this.f35099b.h(z);
    }

    public void g(boolean z, boolean z2) {
        this.f35099b.i(z, z2);
    }

    public boolean h(XmlPullParser xmlPullParser, String str) {
        return this.f35099b.k(xmlPullParser);
    }

    public void i() {
        this.f35099b.l();
    }

    public void j() {
        this.f35099b.r();
    }

    public float k() {
        return this.f35099b.y();
    }

    public void l(String str) {
        this.f35101d = this.f35098a.H + str;
    }

    public void m(String str) {
        this.f35099b.o(str);
    }

    public float n() {
        return this.f35099b.B();
    }

    public float o() {
        return this.f35099b.E();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.f35099b.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        this.f35099b.measure(i2, i3);
        setMeasuredDimension(this.f35099b.getMeasuredWidth(), this.f35099b.getMeasuredHeight());
    }

    public float p() {
        return this.f35099b.G();
    }
}
