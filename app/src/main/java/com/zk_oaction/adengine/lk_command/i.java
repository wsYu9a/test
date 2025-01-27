package com.zk_oaction.adengine.lk_command;

import com.cdo.oaps.ad.OapsKey;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class i extends b {
    private String m;
    private String n;
    private com.zk_oaction.adengine.lk_expression.a o;
    private com.zk_oaction.adengine.lk_expression.a p;
    private com.zk_oaction.adengine.lk_expression.a q;

    public i(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public void b() {
        if (this.p.b() != -1.0f) {
            float b2 = this.p.b();
            this.f34813a.s(this.m, b2);
            this.f34813a.G(this.m, b2);
            return;
        }
        if (this.n == null) {
            this.f34813a.w(this.m, this.o.b() == 1.0f, this.q.b() == 1.0f);
            return;
        }
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f34813a;
        String str = this.m;
        String str2 = this.f34813a.H + this.n;
        String str3 = this.f34817e;
        int i2 = this.f34818f;
        com.zk_oaction.adengine.lk_expression.c cVar2 = this.f34819g;
        cVar.v(str, str2, str3, i2, cVar2 != null ? cVar2.b() : "", this.f34820h);
        this.f34813a.w(this.m, true, this.q.b() == 1.0f);
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public boolean d(XmlPullParser xmlPullParser, String str) {
        try {
            this.m = xmlPullParser.getAttributeValue(null, "name");
            this.n = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SRC);
            this.o = new com.zk_oaction.adengine.lk_expression.a(this.f34813a, "play", xmlPullParser.getAttributeValue(null, "play"), -1.0f, null, false);
            this.p = new com.zk_oaction.adengine.lk_expression.a(this.f34813a, "sound", xmlPullParser.getAttributeValue(null, "sound"), -1.0f, null, false);
            this.q = new com.zk_oaction.adengine.lk_expression.a(this.f34813a, "reset", xmlPullParser.getAttributeValue(null, "reset"), 1.0f, null, false);
            c(xmlPullParser);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
