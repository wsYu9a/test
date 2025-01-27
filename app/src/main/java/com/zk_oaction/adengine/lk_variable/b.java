package com.zk_oaction.adengine.lk_variable;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a */
    private com.zk_oaction.adengine.lk_sdk.c f35031a;

    /* renamed from: b */
    private String[] f35032b = new String[4];

    public b(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f35031a = cVar;
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "type");
        try {
            int next = xmlPullParser.next();
            while (next != 1) {
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals(str)) {
                        this.f35031a.G.l(attributeValue, this.f35032b);
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("Variable")) {
                    this.f35032b[Integer.parseInt(xmlPullParser.getAttributeValue(null, "index"))] = xmlPullParser.getAttributeValue(null, "name");
                }
                next = xmlPullParser.next();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
