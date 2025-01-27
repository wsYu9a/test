package com.zk_oaction.adengine.lk_command;

import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a */
    protected com.zk_oaction.adengine.lk_sdk.c f34825a;

    /* renamed from: b */
    public ArrayList<g> f34826b = new ArrayList<>();

    public d(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f34825a = cVar;
    }

    public void a(String str) {
        Iterator<g> it = this.f34826b.iterator();
        while (it.hasNext()) {
            g next = it.next();
            String str2 = next.f34828a;
            if (str2 != null && str2.equals(str)) {
                next.a();
            }
        }
    }

    public boolean b(XmlPullParser xmlPullParser, String str) {
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
                } else if (xmlPullParser.getName().equals("Trigger")) {
                    g gVar = new g(this.f34825a);
                    if (gVar.c(xmlPullParser, "Trigger")) {
                        this.f34826b.add(gVar);
                    }
                }
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
