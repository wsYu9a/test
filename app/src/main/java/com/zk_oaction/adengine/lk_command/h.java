package com.zk_oaction.adengine.lk_command;

import android.os.Handler;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class h extends b {
    private String m;
    private String n;
    private com.zk_oaction.adengine.lk_expression.a o;
    private Runnable p;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.o.a((String) null, (String) null);
            String str = "" + h.this.o.b();
            h hVar = h.this;
            hVar.f34813a.u(hVar.m, str);
        }
    }

    public h(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.p = new a();
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public void b() {
        this.f34814b.a((String) null, (String) null);
        if (this.f34814b.b() != 0.0f) {
            if (this.f34816d.b() != 1.0f || this.f34815c == 0) {
                this.p.run();
            } else {
                new Handler().postDelayed(this.p, this.f34815c);
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public boolean d(XmlPullParser xmlPullParser, String str) {
        try {
            this.m = xmlPullParser.getAttributeValue(null, "name");
            this.n = xmlPullParser.getAttributeValue(null, "expression");
            this.o = new com.zk_oaction.adengine.lk_expression.a(this.f34813a, null, this.n, 0.0f, null, false);
            this.f34814b = new com.zk_oaction.adengine.lk_expression.a(this.f34813a, null, xmlPullParser.getAttributeValue(null, "condition"), 1.0f, null, false);
            String attributeValue = xmlPullParser.getAttributeValue(null, "delay");
            if (attributeValue != null) {
                this.f34815c = Integer.parseInt(attributeValue);
            }
            this.f34816d = new com.zk_oaction.adengine.lk_expression.a(this.f34813a, null, xmlPullParser.getAttributeValue(null, "delayCondition"), 1.0f, null, false);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
