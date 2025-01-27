package com.zk_oaction.adengine.lk_animation;

import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class e extends b {

    /* renamed from: f */
    private com.zk_oaction.adengine.lk_sdk.interfaces.b f34774f;

    /* renamed from: h */
    private long f34776h;

    /* renamed from: j */
    private int f34778j;

    /* renamed from: g */
    private ArrayList<a> f34775g = new ArrayList<>();

    /* renamed from: i */
    private float f34777i = 0.0f;

    private static class a {

        /* renamed from: a */
        com.zk_oaction.adengine.lk_expression.a f34779a;

        /* renamed from: b */
        long f34780b;

        public a(com.zk_oaction.adengine.lk_expression.a aVar, long j2) {
            this.f34779a = aVar;
            this.f34780b = j2;
        }
    }

    public e(com.zk_oaction.adengine.lk_sdk.interfaces.b bVar) {
        this.f34774f = bVar;
    }

    private void j(com.zk_oaction.adengine.lk_expression.a aVar, long j2) {
        this.f34775g.add(new a(aVar, j2));
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public long a() {
        return this.f34776h;
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public void b(long j2) {
        int size = this.f34775g.size();
        float f2 = 0.0f;
        long j3 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f34775g.get(i2);
            long j4 = aVar.f34780b;
            if (j2 <= j4) {
                if (j2 == j4) {
                    if (Float.valueOf(aVar.f34779a.b()).equals(Float.valueOf(this.f34777i))) {
                        return;
                    }
                    int i3 = this.f34778j;
                    if (i3 == 0) {
                        this.f34774f.g(aVar.f34779a.b());
                    } else if (i3 == 1) {
                        this.f34774f.i(aVar.f34779a.b());
                    } else if (i3 == 2) {
                        this.f34774f.d(aVar.f34779a.b());
                    }
                    this.f34777i = aVar.f34779a.b();
                    return;
                }
                float b2 = ((aVar.f34779a.b() - f2) * ((j2 - j3) / (j4 - j3))) + f2;
                if (Float.valueOf(b2).equals(Float.valueOf(this.f34777i))) {
                    return;
                }
                int i4 = this.f34778j;
                if (i4 == 0) {
                    this.f34774f.g(b2);
                } else if (i4 == 1) {
                    this.f34774f.i(b2);
                } else if (i4 == 2) {
                    this.f34774f.d(b2);
                }
                this.f34777i = b2;
                return;
            }
            f2 = aVar.f34779a.b();
            j3 = aVar.f34780b;
        }
    }

    @Override // com.zk_oaction.adengine.lk_animation.b
    public boolean c(XmlPullParser xmlPullParser) {
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    return false;
                }
                if (next == 2) {
                    if (xmlPullParser.getName().equals("Rotation")) {
                        this.f34778j = 0;
                    } else if (xmlPullParser.getName().equals("RotationX")) {
                        this.f34778j = 1;
                    } else if (xmlPullParser.getName().equals("RotationY")) {
                        this.f34778j = 2;
                    }
                    com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.f34774f.b(), null, xmlPullParser.getAttributeValue(null, "angle"), 0.0f, null, false);
                    long parseLong = Long.parseLong(xmlPullParser.getAttributeValue(null, com.alipay.mobilesecuritysdk.deviceID.c.y));
                    if (parseLong > this.f34776h) {
                        this.f34776h = parseLong;
                    }
                    j(aVar, parseLong);
                } else if (next == 3 && xmlPullParser.getName().equals("RotationAnimation")) {
                    return true;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            } catch (XmlPullParserException e3) {
                e3.printStackTrace();
                return false;
            }
        }
    }
}
