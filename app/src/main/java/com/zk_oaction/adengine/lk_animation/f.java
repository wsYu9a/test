package com.zk_oaction.adengine.lk_animation;

import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class f extends b {

    /* renamed from: f */
    private com.zk_oaction.adengine.lk_sdk.interfaces.b f34781f;

    /* renamed from: h */
    private long f34783h;

    /* renamed from: g */
    private ArrayList<a> f34782g = new ArrayList<>();

    /* renamed from: i */
    private float f34784i = -1.0f;

    /* renamed from: j */
    private float f34785j = -1.0f;

    private static class a {

        /* renamed from: a */
        com.zk_oaction.adengine.lk_expression.a f34786a;

        /* renamed from: b */
        com.zk_oaction.adengine.lk_expression.a f34787b;

        /* renamed from: c */
        long f34788c;

        public a(com.zk_oaction.adengine.lk_expression.a aVar, com.zk_oaction.adengine.lk_expression.a aVar2, long j2) {
            this.f34786a = aVar;
            this.f34787b = aVar2;
            this.f34788c = j2;
        }
    }

    public f(com.zk_oaction.adengine.lk_sdk.interfaces.b bVar) {
        this.f34781f = bVar;
    }

    private void j(com.zk_oaction.adengine.lk_expression.a aVar, com.zk_oaction.adengine.lk_expression.a aVar2, long j2) {
        this.f34782g.add(new a(aVar, aVar2, j2));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f34783h;
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public void b(long j2) {
        int size = this.f34782g.size();
        float f2 = 0.0f;
        long j3 = 0;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f34782g.get(i2);
            long j4 = aVar.f34788c;
            if (j2 <= j4) {
                if (j2 == j4) {
                    if (Float.valueOf(aVar.f34786a.b()).equals(Float.valueOf(this.f34784i)) && Float.valueOf(aVar.f34787b.b()).equals(Float.valueOf(this.f34785j))) {
                        return;
                    }
                    this.f34781f.e(aVar.f34786a.b(), aVar.f34787b.b());
                    this.f34784i = aVar.f34786a.b();
                    this.f34785j = aVar.f34787b.b();
                    return;
                }
                float f4 = (j2 - j3) / (j4 - j3);
                float b2 = ((aVar.f34786a.b() - f2) * f4) + f2;
                float b3 = ((aVar.f34787b.b() - f3) * f4) + f3;
                if (Float.valueOf(b2).equals(Float.valueOf(this.f34784i)) && Float.valueOf(b3).equals(Float.valueOf(this.f34785j))) {
                    return;
                }
                this.f34781f.e(b2, b3);
                this.f34784i = b2;
                this.f34785j = b3;
                return;
            }
            f2 = aVar.f34786a.b();
            f3 = aVar.f34787b.b();
            j3 = aVar.f34788c;
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
                    if (next == 3 && xmlPullParser.getName().equals("SizeAnimation")) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("Size")) {
                    com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.f34781f.b(), null, xmlPullParser.getAttributeValue(null, IAdInterListener.AdReqParam.WIDTH), 0.0f, null, true);
                    com.zk_oaction.adengine.lk_expression.a aVar2 = new com.zk_oaction.adengine.lk_expression.a(this.f34781f.b(), null, xmlPullParser.getAttributeValue(null, "h"), 0.0f, null, true);
                    long parseLong = Long.parseLong(xmlPullParser.getAttributeValue(null, com.alipay.mobilesecuritysdk.deviceID.c.y));
                    if (parseLong > this.f34783h) {
                        this.f34783h = parseLong;
                    }
                    j(aVar, aVar2, parseLong);
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
