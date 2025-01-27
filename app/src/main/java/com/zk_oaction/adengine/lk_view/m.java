package com.zk_oaction.adengine.lk_view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.zk_oaction.adengine.lk_expression.c;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class m extends b implements c.b {
    protected TextPaint V;
    protected Paint.FontMetrics W;
    protected String a0;
    private StaticLayout b0;
    private boolean c0;
    private Layout.Alignment d0;
    private com.zk_oaction.adengine.lk_expression.a e0;
    private com.zk_oaction.adengine.lk_expression.a f0;
    private com.zk_oaction.adengine.lk_expression.a g0;
    private int h0;
    private com.zk_oaction.adengine.lk_expression.a i0;
    private com.zk_oaction.adengine.lk_expression.a j0;

    public m(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.c0 = false;
        TextPaint textPaint = new TextPaint();
        this.V = textPaint;
        textPaint.setFlags(1);
    }

    private void S(String str) {
        int i2 = 0;
        try {
            int parseColor = Color.parseColor("#20000000");
            try {
                String[] split = str.split("\\|");
                this.e0 = new com.zk_oaction.adengine.lk_expression.a(this.v, "shadowRadius", split[0], 2.0f, this, true);
                this.f0 = new com.zk_oaction.adengine.lk_expression.a(this.v, "shadowDx", split[1], 1.0f, this, true);
                this.g0 = new com.zk_oaction.adengine.lk_expression.a(this.v, "shadowDy", split[1], 1.0f, this, true);
                this.h0 = split.length == 4 ? Color.parseColor(split[3].replace(" ", "")) : Color.parseColor("#20000000");
            } catch (Throwable unused) {
                i2 = parseColor;
                this.h0 = i2;
            }
        } catch (Throwable unused2) {
        }
    }

    public boolean R(XmlPullParser xmlPullParser, String str) {
        s(xmlPullParser);
        try {
            String attributeValue = xmlPullParser.getAttributeValue(null, "maxword");
            if (attributeValue != null) {
                this.j0 = new com.zk_oaction.adengine.lk_expression.a(this.v, null, attributeValue, 0.0f, null, false);
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "color");
            if (attributeValue2 != null) {
                this.V.setColor(Color.parseColor(attributeValue2));
            }
            String attributeValue3 = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SIZE);
            if (attributeValue3 != null) {
                new com.zk_oaction.adengine.lk_expression.a(this.v, OapsKey.KEY_SIZE, attributeValue3, 0.0f, this, true);
            }
            this.W = this.V.getFontMetrics();
            String attributeValue4 = xmlPullParser.getAttributeValue(null, "autoLineFeed");
            if (attributeValue4 == null || !attributeValue4.equals("true")) {
                this.c0 = false;
            } else {
                this.c0 = true;
            }
            String attributeValue5 = xmlPullParser.getAttributeValue(null, "textalign");
            this.d0 = (attributeValue5 == null || !attributeValue5.equals("center")) ? (attributeValue5 == null || !attributeValue5.equals("right")) ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
            if (xmlPullParser.getAttributeValue(null, "format") != null) {
                new com.zk_oaction.adengine.lk_expression.b(this.v, xmlPullParser.getAttributeValue(null, "format"), xmlPullParser.getAttributeValue(null, "paras"), this);
            } else {
                String attributeValue6 = xmlPullParser.getAttributeValue(null, "textExp");
                if (attributeValue6 == null) {
                    attributeValue6 = xmlPullParser.getAttributeValue(null, com.baidu.mobads.sdk.internal.a.f5473b);
                }
                if (attributeValue6 == null) {
                    return false;
                }
                new com.zk_oaction.adengine.lk_expression.c(this.v, attributeValue6, this);
            }
            try {
                String attributeValue7 = xmlPullParser.getAttributeValue(null, "shadow");
                if (!TextUtils.isEmpty(attributeValue7)) {
                    S(attributeValue7);
                    this.V.setShadowLayer(this.n > 0.0f ? this.e0.b() / 2.0f : 0.0f, this.f0.b(), this.g0.b(), this.h0);
                }
                String attributeValue8 = xmlPullParser.getAttributeValue(null, "bold");
                if (!TextUtils.isEmpty(attributeValue8)) {
                    com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.v, "bold", attributeValue8, 0.0f, this, false);
                    this.i0 = aVar;
                    this.V.setFakeBoldText(aVar.b() == 1.0f);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return t(xmlPullParser, str);
    }

    @Override // com.zk_oaction.adengine.lk_view.b, com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        com.zk_oaction.adengine.lk_expression.a aVar;
        if (str != null && str.equals(OapsKey.KEY_SIZE)) {
            this.V.setTextSize(f2);
            return;
        }
        if ((str.equals("shadowRadius") && this.e0 != null) || ((str.equals("shadowDx") && this.f0 != null) || (str.equals("shadowDy") && this.g0 != null))) {
            this.V.setShadowLayer(this.n > 0.0f ? this.e0.b() / 2.0f : 0.0f, this.f0.b(), this.g0.b(), this.h0);
        } else if (!str.equals("bold") || (aVar = this.i0) == null) {
            super.a(str, f2);
        } else {
            this.V.setFakeBoldText(aVar.b() == 1.0f);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.V.setAlpha((int) (this.n * this.f35075j));
        if (!this.c0) {
            canvas.drawText(this.a0, 0.0f, -this.W.top, this.V);
            return;
        }
        StaticLayout staticLayout = this.b0;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
    }

    @Override // com.zk_oaction.adengine.lk_expression.c.b
    public void m(String str) {
        int i2;
        int i3;
        int b2;
        try {
            if (str.equals("null")) {
                str = "";
            }
            this.a0 = str;
            com.zk_oaction.adengine.lk_expression.a aVar = this.j0;
            if (aVar != null && aVar.b() > 0.0f && this.a0.length() > (b2 = (int) this.j0.b())) {
                this.a0 = this.a0.substring(0, b2) + "...";
            }
            if (this.c0) {
                if (this.z.b() <= 0.0f) {
                    i3 = (int) this.V.measureText(this.a0);
                    Paint.FontMetrics fontMetrics = this.W;
                    i2 = (int) (fontMetrics.bottom - fontMetrics.top);
                } else {
                    int i4 = 1;
                    int measureText = (int) this.V.measureText(this.a0.substring(0, 1));
                    int i5 = 1;
                    while (i5 < this.a0.length() - 1) {
                        int i6 = i5 + 1;
                        int measureText2 = (int) this.V.measureText(this.a0.substring(i5, i6));
                        if (measureText < measureText2) {
                            measureText = measureText2;
                        }
                        i5 = i6;
                    }
                    int b3 = (int) (this.z.b() / measureText);
                    if (b3 > 0) {
                        i4 = b3;
                    }
                    int ceil = (int) Math.ceil((this.a0.length() * 1.0f) / i4);
                    int b4 = (int) this.z.b();
                    Paint.FontMetrics fontMetrics2 = this.W;
                    i2 = ceil * ((int) (fontMetrics2.bottom - fontMetrics2.top));
                    i3 = b4;
                }
                o(i3, i2);
                this.b0 = new StaticLayout(this.a0, this.V, (int) this.z.b(), this.d0, 1.0f, 0.0f, true);
                forceLayout();
                postInvalidate();
            } else {
                int measureText3 = (int) this.V.measureText(this.a0);
                Paint.FontMetrics fontMetrics3 = this.W;
                o(measureText3, (int) (fontMetrics3.bottom - fontMetrics3.top));
            }
            if (this.w != null) {
                this.v.u(this.w + ".text_width", "" + (this.z.b() / this.v.P));
                this.v.u(this.w + ".text_height", "" + (this.A.b() / this.v.P));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.view.View
    protected boolean onSetAlpha(int i2) {
        if (Build.VERSION.SDK_INT <= 19) {
            return false;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 255) {
            i2 = 255;
        }
        this.V.setAlpha(i2);
        return true;
    }
}
