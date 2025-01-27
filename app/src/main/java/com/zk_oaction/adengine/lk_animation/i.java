package com.zk_oaction.adengine.lk_animation;

import com.vivo.ic.dm.Downloads;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class i extends b {

    /* renamed from: f */
    private com.zk_oaction.adengine.lk_sdk.c f34796f;

    /* renamed from: g */
    private com.zk_oaction.adengine.lk_variable.d f34797g;

    /* renamed from: i */
    private long f34799i;

    /* renamed from: h */
    private ArrayList<a> f34798h = new ArrayList<>();

    /* renamed from: j */
    private float f34800j = Float.MAX_VALUE;

    private static class a {

        /* renamed from: a */
        com.zk_oaction.adengine.lk_expression.a f34801a;

        /* renamed from: b */
        long f34802b;

        public a(com.zk_oaction.adengine.lk_expression.a aVar, long j2) {
            this.f34801a = aVar;
            this.f34802b = j2;
        }
    }

    public i(com.zk_oaction.adengine.lk_sdk.c cVar, com.zk_oaction.adengine.lk_variable.d dVar) {
        this.f34796f = cVar;
        this.f34797g = dVar;
        d();
    }

    private void j(com.zk_oaction.adengine.lk_expression.a aVar, long j2) {
        this.f34798h.add(new a(aVar, j2));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f34799i;
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public void b(long j2) {
        int size = this.f34798h.size();
        float f2 = 0.0f;
        long j3 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f34798h.get(i2);
            long j4 = aVar.f34802b;
            if (j2 <= j4) {
                if (j2 == j4) {
                    if (Float.valueOf(aVar.f34801a.b()).equals(Float.valueOf(this.f34800j))) {
                        return;
                    }
                    this.f34797g.f("" + aVar.f34801a.b());
                    this.f34800j = aVar.f34801a.b();
                    return;
                }
                float b2 = ((aVar.f34801a.b() - f2) * ((j2 - j3) / (j4 - j3))) + f2;
                if (Float.valueOf(b2).equals(Float.valueOf(this.f34800j))) {
                    return;
                }
                this.f34797g.f("" + b2);
                this.f34800j = b2;
                return;
            }
            f2 = aVar.f34801a.b();
            j3 = aVar.f34802b;
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
                    if (next == 3 && xmlPullParser.getName().equals("VariableAnimation")) {
                        return true;
                    }
                } else if (xmlPullParser.getName().equals("AniFrame")) {
                    com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.f34796f, null, xmlPullParser.getAttributeValue(null, Downloads.RequestHeaders.COLUMN_VALUE), 0.0f, null, false);
                    long parseLong = Long.parseLong(xmlPullParser.getAttributeValue(null, com.alipay.mobilesecuritysdk.deviceID.c.y));
                    if (parseLong > this.f34799i) {
                        this.f34799i = parseLong;
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
