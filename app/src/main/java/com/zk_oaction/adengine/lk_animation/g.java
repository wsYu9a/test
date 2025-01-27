package com.zk_oaction.adengine.lk_animation;

import com.cdo.oaps.ad.OapsKey;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class g extends b {

    /* renamed from: f */
    private com.zk_oaction.adengine.lk_view.g f34789f;

    /* renamed from: h */
    private long f34791h;

    /* renamed from: g */
    private ArrayList<a> f34790g = new ArrayList<>();

    /* renamed from: i */
    private String f34792i = "";

    private static class a {

        /* renamed from: a */
        String f34793a;

        /* renamed from: b */
        long f34794b;

        public a(String str, long j2) {
            this.f34793a = str;
            this.f34794b = j2;
        }
    }

    public g(com.zk_oaction.adengine.lk_view.g gVar) {
        this.f34789f = gVar;
    }

    private void j(String str, long j2) {
        this.f34790g.add(new a(str, j2));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f34791h;
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public void b(long j2) {
        int size = this.f34790g.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = i3;
                break;
            } else {
                if (j2 <= this.f34790g.get(i2).f34794b) {
                    break;
                }
                i3 = i2;
                i2++;
            }
        }
        a aVar = this.f34790g.get(i2);
        if (this.f34792i.equals(aVar.f34793a)) {
            return;
        }
        String str = aVar.f34793a;
        this.f34792i = str;
        this.f34789f.D(str);
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public boolean c(XmlPullParser xmlPullParser) {
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    break;
                }
                if (next != 2) {
                    if (next == 3 && xmlPullParser.getName().equals("SourcesAnimation")) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("Source")) {
                    String attributeValue = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SRC);
                    long parseLong = Long.parseLong(xmlPullParser.getAttributeValue(null, com.alipay.mobilesecuritysdk.deviceID.c.y));
                    if (parseLong > this.f34791h) {
                        this.f34791h = parseLong;
                    }
                    j(attributeValue, parseLong);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (XmlPullParserException e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }
}
