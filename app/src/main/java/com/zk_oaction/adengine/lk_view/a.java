package com.zk_oaction.adengine.lk_view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.zk_oaction.adengine.lk_expression.a;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class a implements a.w {

    /* renamed from: a */
    protected com.zk_oaction.adengine.lk_sdk.c f35055a;

    /* renamed from: b */
    public Paint f35056b;

    /* renamed from: c */
    private String f35057c;

    /* renamed from: d */
    private com.zk_oaction.adengine.lk_expression.a f35058d;

    /* renamed from: e */
    private int f35059e;

    /* renamed from: f */
    private String f35060f;

    /* renamed from: g */
    private com.zk_oaction.adengine.lk_expression.a f35061g;

    /* renamed from: h */
    private Canvas f35062h;

    /* renamed from: i */
    private Bitmap f35063i;

    /* renamed from: j */
    private g f35064j;
    private boolean l;
    private HandlerThread m;
    private Handler n;
    private boolean p;
    private volatile boolean k = false;
    private Runnable o = new RunnableC0817a();

    /* renamed from: com.zk_oaction.adengine.lk_view.a$a */
    class RunnableC0817a implements Runnable {
        RunnableC0817a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f35063i == null || a.this.f35063i.isRecycled() || a.this.f35064j == null) {
                return;
            }
            int width = a.this.f35063i.getWidth();
            int height = a.this.f35063i.getHeight();
            int i2 = width * height;
            float f2 = i2;
            int[] iArr = new int[i2];
            a.this.f35063i.getPixels(iArr, 0, width, 0, 0, width, height);
            float f3 = 0.0f;
            for (int i3 = 0; i3 < width; i3++) {
                for (int i4 = 0; i4 < height; i4++) {
                    if (iArr[(i4 * width) + i3] == 0) {
                        f3 += 1.0f;
                    }
                }
            }
            if (f3 <= 0.0f || f2 <= 0.0f) {
                return;
            }
            int i5 = (int) ((f3 * 100.0f) / f2);
            a.this.d(i5);
            if (i5 >= a.this.f35061g.b()) {
                a.this.k = true;
                a.this.f35064j.postInvalidate();
                a.this.d(100);
            }
        }
    }

    public a(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f35055a = cVar;
        cVar.f34884i.add(this);
        HandlerThread handlerThread = new HandlerThread("brush_paint");
        this.m = handlerThread;
        handlerThread.start();
        this.n = new Handler(this.m.getLooper());
    }

    public void d(int i2) {
        if (TextUtils.isEmpty(this.f35057c)) {
            return;
        }
        this.f35055a.J.f(this.f35057c + ".wipe", "" + i2);
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        if (str == null || !str.equals("weight") || this.f35058d == null) {
            return;
        }
        this.f35056b.setStrokeWidth(f2);
    }

    public void c() {
        Paint paint = new Paint();
        this.f35056b = paint;
        paint.setAntiAlias(true);
        this.f35056b.setAlpha(0);
        this.f35056b.setStrokeCap(Paint.Cap.ROUND);
        this.f35056b.setStrokeJoin(Paint.Join.ROUND);
        this.f35056b.setStyle(Paint.Style.STROKE);
        this.f35056b.setStrokeWidth(this.f35058d.b());
        this.f35056b.setXfermode(com.zk_oaction.adengine.lk_util.a.a(this.f35060f));
        com.zk_oaction.adengine.lk_interfaces.b bVar = this.f35064j.a0;
        if (bVar != null) {
            this.f35063i = Bitmap.createBitmap(bVar.d(), this.f35064j.a0.c(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f35063i);
            this.f35062h = canvas;
            int i2 = this.f35059e;
            if (i2 != 0) {
                canvas.drawColor(i2);
            } else {
                Bitmap b2 = this.f35064j.a0.b();
                if (b2 != null) {
                    this.f35062h.drawBitmap(b2, 0.0f, 0.0f, (Paint) null);
                    this.p = true;
                }
            }
        }
        this.f35064j.invalidate();
    }

    public void f(g gVar) {
        this.f35064j = gVar;
    }

    public boolean h(XmlPullParser xmlPullParser) {
        try {
            this.f35057c = xmlPullParser.getAttributeValue(null, "name");
            this.f35058d = new com.zk_oaction.adengine.lk_expression.a(this.f35055a, "weight", xmlPullParser.getAttributeValue(null, "weight"), 0.0f, this, true);
            this.f35061g = new com.zk_oaction.adengine.lk_expression.a(this.f35055a, "clear_percent", xmlPullParser.getAttributeValue(null, "clear_percent"), 60.0f, this, false);
            String attributeValue = xmlPullParser.getAttributeValue(null, "color");
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "xfermode");
            if (!TextUtils.isEmpty(attributeValue)) {
                this.f35059e = Color.parseColor(attributeValue);
            }
            if (this.f35061g.b() > 100.0f) {
                this.f35061g.h(100.0f);
            } else if (this.f35061g.b() == 0.0f) {
                this.f35061g.h(60.0f);
            }
            if (TextUtils.isEmpty(attributeValue2)) {
                return true;
            }
            this.f35060f = attributeValue2;
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public Canvas i() {
        return this.f35062h;
    }

    public Bitmap k() {
        Bitmap b2;
        if (!this.p && (b2 = this.f35064j.a0.b()) != null) {
            this.f35062h.drawBitmap(b2, 0.0f, 0.0f, (Paint) null);
            this.p = true;
        }
        return this.f35063i;
    }

    public Paint m() {
        return this.f35056b;
    }

    public void n() {
        this.n.removeCallbacksAndMessages(null);
        this.n.postDelayed(this.o, 50L);
    }

    public boolean o() {
        return this.k;
    }

    public void p() {
        if (this.l) {
            return;
        }
        Bitmap bitmap = this.f35063i;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f35063i.recycle();
        }
        this.f35062h = null;
        this.l = true;
    }
}
