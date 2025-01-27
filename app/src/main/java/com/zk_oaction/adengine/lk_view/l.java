package com.zk_oaction.adengine.lk_view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.zk_oaction.adengine.lk_expression.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpHeaders;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class l extends View implements a.w, com.zk_oaction.adengine.lk_sdk.interfaces.a {

    /* renamed from: a */
    public com.zk_oaction.adengine.lk_expression.a f35159a;

    /* renamed from: b */
    public com.zk_oaction.adengine.lk_expression.a f35160b;

    /* renamed from: c */
    public com.zk_oaction.adengine.lk_expression.a f35161c;

    /* renamed from: d */
    public com.zk_oaction.adengine.lk_expression.a f35162d;

    /* renamed from: e */
    protected com.zk_oaction.adengine.lk_sdk.c f35163e;

    /* renamed from: f */
    public int f35164f;

    /* renamed from: g */
    private List<j> f35165g;

    /* renamed from: h */
    private List<Rect> f35166h;

    /* renamed from: i */
    private boolean f35167i;

    /* renamed from: j */
    private com.zk_oaction.adengine.lk_expression.a f35168j;
    private com.zk_oaction.adengine.lk_expression.a k;
    private com.zk_oaction.adengine.lk_expression.a l;
    private com.zk_oaction.adengine.lk_interfaces.b m;
    private k n;
    private Thread o;
    private float p;
    private float q;
    private boolean r;

    private class b implements View.OnTouchListener {
        private b() {
        }

        /* synthetic */ b(l lVar, a aVar) {
            this();
        }

        private void a(MotionEvent motionEvent) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float f2 = l.this.p;
            float f3 = l.this.q;
            if (Math.abs(x - f2) > 40.0f || Math.abs(y - f3) > 40.0f) {
                if (l.this.r) {
                    com.zk_oaction.adengine.lk_expression.a aVar = l.this.f35162d;
                    if (aVar == null || aVar.b() != 1.0f || l.this.x(x, y)) {
                        l.this.v(x, y);
                        return;
                    }
                    return;
                }
                int childCount = l.this.f35163e.I.getChildCount();
                boolean z = false;
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (l.this.f35163e.I.getChildAt(i2) instanceof l) {
                        z = true;
                    }
                }
                if (z) {
                    return;
                }
                l lVar = l.this;
                lVar.f35163e.I.g(lVar);
                l.this.r = true;
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 2) {
                    return true;
                }
                a(motionEvent);
                return true;
            }
            l.this.p = motionEvent.getX();
            l.this.q = motionEvent.getY();
            return true;
        }
    }

    private class c extends Thread {
        private c() {
        }

        /* synthetic */ c(l lVar, a aVar) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            while (l.this.f35167i) {
                synchronized (l.this.f35165g) {
                    l.this.n.f(l.this.f35165g, l.this);
                    if (l.this.f35165g.size() == 0) {
                        l.this.f35167i = false;
                        if (l.this.r) {
                            l lVar = l.this;
                            lVar.f35163e.I.m(lVar);
                            l.this.r = false;
                        }
                    }
                }
                l.this.postInvalidate();
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public l(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar.F);
        this.f35167i = false;
        this.r = false;
        this.f35163e = cVar;
        this.f35164f = com.zk_oaction.adengine.lk_sdk.c.f34877b;
        m();
    }

    private void m() {
        this.f35165g = Collections.synchronizedList(new ArrayList());
        this.f35166h = new ArrayList();
        this.n = new k();
        this.f35163e.I.f(new b());
        setLayerType(1, null);
    }

    private boolean p(XmlPullParser xmlPullParser, String str) {
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    break;
                }
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals(str)) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("PathData") && r(xmlPullParser, "PathData")) {
                    return true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    private boolean r(XmlPullParser xmlPullParser, String str) {
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return false;
                }
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals(str)) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals(HttpHeaders.RANGE)) {
                    String attributeValue = xmlPullParser.getAttributeValue(null, "rect");
                    if (!TextUtils.isEmpty(attributeValue)) {
                        String[] split = attributeValue.split(",");
                        if (split.length == 4) {
                            Rect rect = new Rect();
                            rect.left = (int) (Float.parseFloat(split[0]) * this.f35163e.P);
                            rect.top = (int) (Float.parseFloat(split[1]) * this.f35163e.P);
                            rect.right = (int) (Float.parseFloat(split[2]) * this.f35163e.P);
                            rect.bottom = (int) (Float.parseFloat(split[3]) * this.f35163e.P);
                            this.f35166h.add(rect);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }

    public void v(float f2, float f3) {
        int size = this.f35165g.size();
        w(f2, f3);
        if (size == 0) {
            this.f35167i = true;
            c cVar = new c();
            this.o = cVar;
            cVar.start();
        }
    }

    private void w(float f2, float f3) {
        synchronized (this.f35165g) {
            for (int i2 = 0; i2 < ((int) this.l.b()); i2++) {
                j jVar = new j();
                jVar.f35147a = f2;
                jVar.f35148b = f3;
                jVar.f35149c = this.f35168j.b();
                jVar.f35150d = this.k.b();
                jVar.f35153g = new Rect((int) f2, (int) f3, (int) (jVar.f35149c + f2), (int) (jVar.f35150d + f3));
                jVar.f35154h = this.n.c();
                this.f35165g.add(jVar);
            }
        }
    }

    public boolean x(float f2, float f3) {
        if (this.f35166h.size() > 0) {
            for (Rect rect : this.f35166h) {
                if (f2 >= rect.left && f2 <= rect.right && f3 >= rect.top && f3 <= rect.bottom) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void a() {
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean a(float f2, float f3) {
        return true;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public boolean c() {
        return false;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void d() {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void f(float f2, float f3) {
    }

    public boolean g(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, IAdInterListener.AdReqParam.WIDTH);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "h");
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "count");
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "move_radius");
        String attributeValue5 = xmlPullParser.getAttributeValue(null, "speek_sec");
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "reduce_size");
        String attributeValue7 = xmlPullParser.getAttributeValue(null, "set_path");
        String attributeValue8 = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SRC);
        this.f35168j = new com.zk_oaction.adengine.lk_expression.a(this.f35163e, IAdInterListener.AdReqParam.WIDTH, attributeValue, 60.0f, this, true);
        this.k = new com.zk_oaction.adengine.lk_expression.a(this.f35163e, "h", attributeValue2, 60.0f, this, true);
        this.l = new com.zk_oaction.adengine.lk_expression.a(this.f35163e, "count", attributeValue3, 6.0f, this, false);
        this.f35159a = new com.zk_oaction.adengine.lk_expression.a(this.f35163e, "speek_sec", attributeValue5, 2.5f, this, true);
        this.f35161c = new com.zk_oaction.adengine.lk_expression.a(this.f35163e, "move_radius", attributeValue4, 16.0f, this, true);
        this.f35160b = new com.zk_oaction.adengine.lk_expression.a(this.f35163e, "reduce_size", attributeValue6, 3.0f, this, true);
        this.f35162d = new com.zk_oaction.adengine.lk_expression.a(this.f35163e, "set_path", attributeValue7, 0.0f, this, false);
        if (!TextUtils.isEmpty(attributeValue8)) {
            if (attributeValue8.charAt(0) == '@') {
                attributeValue8 = this.f35163e.J.h(attributeValue8.substring(1));
            }
            this.m = this.f35163e.g(attributeValue8, this, 3);
        }
        if (this.f35162d.b() == 1.0f) {
            p(xmlPullParser, str);
        }
        return true;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void h(float f2, float f3) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void j(float f2, float f3) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
    public void k(float f2, float f3) {
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f35165g.clear();
        this.o = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        synchronized (this.f35165g) {
            Bitmap b2 = this.m.b();
            if (b2 != null && !b2.isRecycled()) {
                for (int i2 = 0; i2 < this.f35165g.size(); i2++) {
                    j jVar = this.f35165g.get(i2);
                    canvas.drawBitmap(b2, (Rect) null, jVar.f35153g, jVar.f35154h);
                }
            }
        }
    }
}
