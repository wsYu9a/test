package com.zk_oaction.adengine.lk_command;

import android.os.Handler;
import android.os.Looper;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class c extends b {
    private String m;
    private Runnable n;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.m.equals("unlock")) {
                c.this.f34813a.m(50L);
                c.this.f34813a.G.a();
            } else {
                if (c.this.m.equals("vibrate")) {
                    c.this.f34813a.m(50L);
                    return;
                }
                com.zk_oaction.adengine.lk_expression.c cVar = c.this.f34819g;
                String b2 = cVar != null ? cVar.b() : null;
                c cVar2 = c.this;
                cVar2.f34813a.G.j(cVar2.m, c.this.f34818f, b2);
            }
        }
    }

    public c(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.n = new a();
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public void b() {
        this.f34814b.a((String) null, (String) null);
        if (this.f34814b.b() != 0.0f) {
            if (this.f34816d.b() != 1.0f || this.f34815c == 0) {
                this.n.run();
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(this.n, this.f34815c);
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public boolean d(XmlPullParser xmlPullParser, String str) {
        try {
            this.m = xmlPullParser.getAttributeValue(null, com.heytap.mcssdk.n.b.P);
            this.f34814b = new com.zk_oaction.adengine.lk_expression.a(this.f34813a, null, xmlPullParser.getAttributeValue(null, "condition"), 1.0f, null, false);
            String attributeValue = xmlPullParser.getAttributeValue(null, "delay");
            if (attributeValue != null) {
                this.f34815c = Integer.parseInt(attributeValue);
            }
            this.f34816d = new com.zk_oaction.adengine.lk_expression.a(this.f34813a, null, xmlPullParser.getAttributeValue(null, "delayCondition"), 1.0f, null, false);
            c(xmlPullParser);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
