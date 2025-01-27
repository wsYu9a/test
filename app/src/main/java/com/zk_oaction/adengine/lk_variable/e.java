package com.zk_oaction.adengine.lk_variable;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a */
    private com.zk_oaction.adengine.lk_sdk.c f35049a;

    public e(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f35049a = cVar;
    }

    public boolean a(XmlPullParser xmlPullParser, String str) {
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
                } else if (xmlPullParser.getName().equals("ContentProviderBinder")) {
                    new a(this.f35049a).b(xmlPullParser, "ContentProviderBinder");
                } else if (xmlPullParser.getName().equals("SensorBinder")) {
                    new b(this.f35049a).a(xmlPullParser, "SensorBinder");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
