package com.zk_oaction.adengine.lk_animation;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class a extends b {

    /* renamed from: f */
    private com.zk_oaction.adengine.lk_sdk.interfaces.b f34751f;

    /* renamed from: h */
    private long f34753h;

    /* renamed from: g */
    private ArrayList<C0806a> f34752g = new ArrayList<>();

    /* renamed from: i */
    private float f34754i = -1.0f;

    /* renamed from: com.zk_oaction.adengine.lk_animation.a$a */
    private static class C0806a {

        /* renamed from: a */
        com.zk_oaction.adengine.lk_expression.a f34755a;

        /* renamed from: b */
        long f34756b;

        public C0806a(com.zk_oaction.adengine.lk_expression.a aVar, long j2) {
            this.f34755a = aVar;
            this.f34756b = j2;
        }
    }

    public a(com.zk_oaction.adengine.lk_sdk.interfaces.b bVar) {
        this.f34751f = bVar;
    }

    private void j(com.zk_oaction.adengine.lk_expression.a aVar, long j2) {
        this.f34752g.add(new C0806a(aVar, j2));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f34753h;
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public void b(long j2) {
        int size = this.f34752g.size();
        float f2 = 0.0f;
        long j3 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            C0806a c0806a = this.f34752g.get(i2);
            long j4 = c0806a.f34756b;
            if (j2 <= j4) {
                if (j2 == j4) {
                    if (Float.valueOf(c0806a.f34755a.b()).equals(Float.valueOf(this.f34754i))) {
                        return;
                    }
                    this.f34751f.a(c0806a.f34755a.b());
                    this.f34754i = c0806a.f34755a.b();
                    return;
                }
                float b2 = ((c0806a.f34755a.b() - f2) * ((j2 - j3) / (j4 - j3))) + f2;
                if (Float.valueOf(b2).equals(Float.valueOf(this.f34754i))) {
                    return;
                }
                this.f34751f.a(b2);
                this.f34754i = b2;
                return;
            }
            f2 = c0806a.f34755a.b();
            j3 = c0806a.f34756b;
        }
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
                    if (next == 3 && xmlPullParser.getName().equals("AlphaAnimation")) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("Alpha")) {
                    com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.f34751f.b(), null, xmlPullParser.getAttributeValue(null, "a"), 0.0f, null, false);
                    long parseLong = Long.parseLong(xmlPullParser.getAttributeValue(null, com.alipay.mobilesecuritysdk.deviceID.c.y));
                    if (parseLong > this.f34753h) {
                        this.f34753h = parseLong;
                    }
                    j(aVar, parseLong);
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
