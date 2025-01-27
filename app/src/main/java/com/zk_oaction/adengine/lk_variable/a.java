package com.zk_oaction.adengine.lk_variable;

import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.zk_oaction.adengine.lk_expression.c;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class a implements c.b {

    /* renamed from: a */
    private com.zk_oaction.adengine.lk_sdk.c f35029a;

    /* renamed from: b */
    private String f35030b;

    public a(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f35029a = cVar;
    }

    private void a(XmlPullParser xmlPullParser, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (xmlPullParser.getName().equals("Variable")) {
            arrayList.add(xmlPullParser.getAttributeValue(null, "name"));
            arrayList2.add(xmlPullParser.getAttributeValue(null, "column"));
        }
    }

    public boolean b(XmlPullParser xmlPullParser, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        String attributeValue = xmlPullParser.getAttributeValue(null, "uri");
        if (attributeValue == null) {
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "uriFormat");
            if (attributeValue2 != null) {
                new com.zk_oaction.adengine.lk_expression.b(this.f35029a, attributeValue2, xmlPullParser.getAttributeValue(null, "uriParas"), this);
            }
            return false;
        }
        this.f35030b = attributeValue;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "columns");
        String[] split = attributeValue3 != null ? attributeValue3.split(",") : null;
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "where");
        String attributeValue5 = xmlPullParser.getAttributeValue(null, ProcessBridgeProvider.KEY_ARGS);
        String[] split2 = attributeValue5 != null ? attributeValue5.split(",") : null;
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "order");
        String attributeValue7 = xmlPullParser.getAttributeValue(null, "countName");
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    break;
                }
                if (next == 2) {
                    a(xmlPullParser, arrayList, arrayList2);
                } else if (next == 3 && xmlPullParser.getName().equals(str)) {
                    this.f35029a.G.n(this.f35030b, split, attributeValue4, split2, attributeValue6, attributeValue7, (String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList.size()]));
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_expression.c.b
    public void m(String str) {
        this.f35030b = str;
    }
}
