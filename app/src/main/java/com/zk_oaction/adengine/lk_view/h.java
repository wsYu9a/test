package com.zk_oaction.adengine.lk_view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.cdo.oaps.ad.OapsKey;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class h extends b {
    private g V;
    private com.zk_oaction.adengine.lk_interfaces.b W;
    private Paint a0;
    private String b0;
    private int c0;
    private Canvas d0;
    private Bitmap e0;
    private com.zk_oaction.adengine.lk_interfaces.b f0;

    public h(com.zk_oaction.adengine.lk_sdk.c cVar, g gVar) {
        super(cVar);
        this.V = gVar;
    }

    private boolean U() {
        try {
            this.W = this.v.g(this.b0, this.V, 3);
            if (this.z.b() == 0.0f || this.A.b() == 0.0f) {
                o(this.W.d(), this.W.c());
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int R() {
        return this.c0;
    }

    public boolean S(XmlPullParser xmlPullParser, String str) {
        s(xmlPullParser);
        this.b0 = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SRC);
        String attributeValue = xmlPullParser.getAttributeValue(null, "xfermode");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "align");
        if (attributeValue2 == null || !attributeValue2.equals("absolute")) {
            this.c0 = 0;
        } else {
            this.c0 = 1;
        }
        if (!U()) {
            return false;
        }
        Paint paint = new Paint();
        this.a0 = paint;
        paint.setAntiAlias(true);
        this.a0.setXfermode(com.zk_oaction.adengine.lk_util.a.a(attributeValue));
        this.f0 = this.v.G.m((int) this.V.z.b(), (int) this.V.A.b(), Bitmap.Config.ARGB_8888);
        return true;
    }

    public Bitmap T() {
        return this.e0;
    }

    @Override // com.zk_oaction.adengine.lk_view.b, com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        super.a(str, f2);
        if (this.c0 == 1 || str.equals("width") || str.equals("height")) {
            this.V.invalidate();
        }
    }

    public void y() {
        Canvas canvas;
        float b2;
        float b3;
        Bitmap b4 = this.f0.b();
        if (b4 == null) {
            return;
        }
        if (b4 != this.e0) {
            this.e0 = b4;
            this.d0 = new Canvas(this.e0);
        }
        this.e0.eraseColor(0);
        Bitmap a0 = this.V.a0();
        if (a0 != null) {
            this.d0.drawBitmap(a0, (Rect) null, this.V.s, (Paint) null);
        }
        this.d0.save();
        if (this.c0 == 1) {
            canvas = this.d0;
            b2 = this.x.b() - this.V.getTranslationX();
            b3 = this.y.b() - this.V.getTranslationY();
        } else {
            canvas = this.d0;
            b2 = this.x.b();
            b3 = this.y.b();
        }
        canvas.translate(b2, b3);
        this.d0.rotate(this.D.b(), this.B.b(), this.C.b());
        Bitmap b5 = this.W.b();
        if (b5 != null) {
            this.d0.drawBitmap(b5, (Rect) null, this.s, this.a0);
        }
        this.d0.restore();
    }
}
