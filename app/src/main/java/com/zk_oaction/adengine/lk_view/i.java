package com.zk_oaction.adengine.lk_view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import com.cdo.oaps.ad.OapsKey;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class i extends b {
    private String V;
    private String W;
    private com.zk_oaction.adengine.lk_expression.a a0;
    private com.zk_oaction.adengine.lk_interfaces.b[] b0;
    private Paint c0;

    public i(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.c0 = null;
        this.b0 = new com.zk_oaction.adengine.lk_interfaces.b[10];
    }

    private void a() {
        try {
            String str = "" + ((int) this.a0.b());
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < str.length()) {
                com.zk_oaction.adengine.lk_interfaces.b bVar = this.b0[str.charAt(i2) - '0'];
                int d2 = bVar.d();
                if (i4 < bVar.c()) {
                    i4 = bVar.c();
                }
                i2++;
                i3 += d2;
            }
            o(i3, i4);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean R(XmlPullParser xmlPullParser, String str) {
        s(xmlPullParser);
        try {
            String attributeValue = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SRC);
            int lastIndexOf = attributeValue.lastIndexOf(46);
            this.V = attributeValue.substring(0, lastIndexOf);
            this.W = attributeValue.substring(lastIndexOf);
            this.a0 = new com.zk_oaction.adengine.lk_expression.a(this.v, "number", xmlPullParser.getAttributeValue(null, "number"), 0.0f, null, false);
            for (int i2 = 0; i2 < 10; i2++) {
                try {
                    this.b0[i2] = this.v.g(this.V + "_" + i2 + this.W, this, 3);
                } catch (Exception unused) {
                }
            }
            this.a0.i(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return t(xmlPullParser, str);
    }

    @Override // com.zk_oaction.adengine.lk_view.b, com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        if (str.equals("number")) {
            a();
        } else {
            super.a(str, f2);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            String str = "" + ((int) this.a0.b());
            int i2 = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                Bitmap b2 = this.b0[str.charAt(i3) - '0'].b();
                if (b2 != null) {
                    canvas.drawBitmap(b2, i2, 0.0f, this.c0);
                    i2 += b2.getWidth();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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
}
