package com.zk_oaction.adengine.lk_animation;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class d extends b {

    /* renamed from: f */
    private com.zk_oaction.adengine.lk_sdk.interfaces.b f34766f;

    /* renamed from: h */
    private long f34768h;

    /* renamed from: g */
    private ArrayList<a> f34767g = new ArrayList<>();

    /* renamed from: i */
    private float f34769i = -1.0f;

    /* renamed from: j */
    private float f34770j = -1.0f;

    private static class a {

        /* renamed from: a */
        com.zk_oaction.adengine.lk_expression.a f34771a;

        /* renamed from: b */
        com.zk_oaction.adengine.lk_expression.a f34772b;

        /* renamed from: c */
        long f34773c;

        public a(com.zk_oaction.adengine.lk_expression.a aVar, com.zk_oaction.adengine.lk_expression.a aVar2, long j2) {
            this.f34771a = aVar;
            this.f34772b = aVar2;
            this.f34773c = j2;
        }
    }

    public d(com.zk_oaction.adengine.lk_sdk.interfaces.b bVar) {
        this.f34766f = bVar;
    }

    private void j(com.zk_oaction.adengine.lk_expression.a aVar, com.zk_oaction.adengine.lk_expression.a aVar2, long j2) {
        this.f34767g.add(new a(aVar, aVar2, j2));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f34768h;
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public void b(long j2) {
        int size = this.f34767g.size();
        float f2 = 0.0f;
        long j3 = 0;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f34767g.get(i2);
            long j4 = aVar.f34773c;
            if (j2 <= j4) {
                if (j2 == j4) {
                    if (Float.valueOf(aVar.f34771a.b()).equals(Float.valueOf(this.f34769i)) && Float.valueOf(aVar.f34772b.b()).equals(Float.valueOf(this.f34770j))) {
                        return;
                    }
                    this.f34766f.d(aVar.f34771a.b(), aVar.f34772b.b());
                    this.f34769i = aVar.f34771a.b();
                    this.f34770j = aVar.f34772b.b();
                    return;
                }
                float f4 = (j2 - j3) / (j4 - j3);
                float b2 = ((aVar.f34771a.b() - f2) * f4) + f2;
                float b3 = ((aVar.f34772b.b() - f3) * f4) + f3;
                if (Float.valueOf(b2).equals(Float.valueOf(this.f34769i)) && Float.valueOf(b3).equals(Float.valueOf(this.f34770j))) {
                    return;
                }
                this.f34766f.d(b2, b3);
                this.f34769i = b2;
                this.f34770j = b3;
                return;
            }
            f2 = aVar.f34771a.b();
            f3 = aVar.f34772b.b();
            j3 = aVar.f34773c;
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
                    if (next == 3 && xmlPullParser.getName().equals("PositionAnimation")) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("Position")) {
                    com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.f34766f.b(), null, xmlPullParser.getAttributeValue(null, "x"), 0.0f, null, true);
                    com.zk_oaction.adengine.lk_expression.a aVar2 = new com.zk_oaction.adengine.lk_expression.a(this.f34766f.b(), null, xmlPullParser.getAttributeValue(null, "y"), 0.0f, null, true);
                    long parseLong = Long.parseLong(xmlPullParser.getAttributeValue(null, com.alipay.mobilesecuritysdk.deviceID.c.y));
                    if (parseLong > this.f34768h) {
                        this.f34768h = parseLong;
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
