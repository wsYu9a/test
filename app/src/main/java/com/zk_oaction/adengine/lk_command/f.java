package com.zk_oaction.adengine.lk_command;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class f extends b {
    private String m;
    private float n;
    private boolean o;
    private boolean p;

    public f(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.n = 1.0f;
        this.o = false;
        this.p = false;
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public void b() {
        this.f34813a.G.q(this.m, this.n, this.o, this.p);
    }

    @Override // com.zk_oaction.adengine.lk_command.b
    public boolean d(XmlPullParser xmlPullParser, String str) {
        String attributeValue;
        try {
            attributeValue = xmlPullParser.getAttributeValue(null, "sound");
            this.m = attributeValue;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (attributeValue == null) {
            return false;
        }
        String str2 = this.f34813a.H + this.m;
        this.m = str2;
        this.f34813a.G.a(str2);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "volume");
        if (attributeValue2 != null) {
            this.n = Float.parseFloat(attributeValue2);
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "loop");
        if (attributeValue3 != null) {
            this.o = Boolean.parseBoolean(attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "keepCur");
        if (attributeValue4 != null) {
            this.p = Boolean.parseBoolean(attributeValue4);
        }
        return true;
    }
}
