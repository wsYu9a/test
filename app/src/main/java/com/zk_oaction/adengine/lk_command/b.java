package com.zk_oaction.adengine.lk_command;

import android.os.Handler;
import com.vivo.ic.dm.Downloads;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a */
    protected com.zk_oaction.adengine.lk_sdk.c f34813a;

    /* renamed from: b */
    protected com.zk_oaction.adengine.lk_expression.a f34814b;

    /* renamed from: c */
    protected int f34815c;

    /* renamed from: d */
    protected com.zk_oaction.adengine.lk_expression.a f34816d;

    /* renamed from: e */
    protected String f34817e;

    /* renamed from: g */
    protected com.zk_oaction.adengine.lk_expression.c f34819g;

    /* renamed from: h */
    protected String f34820h;

    /* renamed from: i */
    private String f34821i;

    /* renamed from: j */
    private String f34822j;
    private String k;

    /* renamed from: f */
    protected int f34818f = -1;
    private Runnable l = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            com.zk_oaction.adengine.lk_sdk.interfaces.f fVar = bVar.f34813a.L.get(bVar.f34821i);
            if (fVar != null) {
                if (b.this.f34822j.equals(Downloads.Column.VISIBILITY)) {
                    fVar.a(b.this.k);
                    return;
                }
                if (b.this.f34822j.equals("animation")) {
                    fVar.b(b.this.k);
                    return;
                }
                if (b.this.f34822j.equals("clickable")) {
                    fVar.c(b.this.k);
                    return;
                }
                try {
                    ((com.zk_oaction.adengine.lk_view.b) fVar).a(b.this.f34822j, Float.parseFloat(b.this.k));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public b(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f34813a = cVar;
    }

    public void b() {
        this.f34814b.a((String) null, (String) null);
        if (this.f34814b.b() != 0.0f) {
            if (this.f34816d.b() != 1.0f || this.f34815c == 0) {
                this.l.run();
            } else {
                new Handler().postDelayed(this.l, this.f34815c);
            }
        }
    }

    protected void c(XmlPullParser xmlPullParser) {
        try {
            String attributeValue = xmlPullParser.getAttributeValue(null, "scenetype");
            if (attributeValue != null) {
                this.f34818f = Integer.parseInt(attributeValue);
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "extend");
            if (attributeValue2 != null) {
                this.f34819g = new com.zk_oaction.adengine.lk_expression.c(this.f34813a, attributeValue2, null);
            }
            this.f34820h = xmlPullParser.getAttributeValue(null, "report");
            this.f34817e = xmlPullParser.getAttributeValue(null, "scene");
        } catch (Throwable unused) {
        }
    }

    public boolean d(XmlPullParser xmlPullParser, String str) {
        try {
            String attributeValue = xmlPullParser.getAttributeValue(null, "target");
            int indexOf = attributeValue.indexOf(46);
            this.f34821i = attributeValue.substring(0, indexOf);
            this.f34822j = attributeValue.substring(indexOf + 1);
            this.k = xmlPullParser.getAttributeValue(null, Downloads.RequestHeaders.COLUMN_VALUE);
            this.f34814b = new com.zk_oaction.adengine.lk_expression.a(this.f34813a, null, xmlPullParser.getAttributeValue(null, "condition"), 1.0f, null, false);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "delay");
            if (attributeValue2 != null) {
                this.f34815c = Integer.parseInt(attributeValue2);
            }
            this.f34816d = new com.zk_oaction.adengine.lk_expression.a(this.f34813a, null, xmlPullParser.getAttributeValue(null, "delayCondition"), 1.0f, null, false);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
