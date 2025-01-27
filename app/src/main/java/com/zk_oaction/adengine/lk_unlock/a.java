package com.zk_oaction.adengine.lk_unlock;

import java.util.ArrayList;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a */
    private com.zk_oaction.adengine.lk_sdk.c f34978a;

    /* renamed from: b */
    private com.zk_oaction.adengine.lk_expression.a f34979b;

    /* renamed from: c */
    private com.zk_oaction.adengine.lk_expression.a f34980c;

    /* renamed from: d */
    private ArrayList<C0814a> f34981d = new ArrayList<>();

    /* renamed from: e */
    private float f34982e;

    /* renamed from: f */
    private float f34983f;

    /* renamed from: g */
    private boolean f34984g;

    /* renamed from: com.zk_oaction.adengine.lk_unlock.a$a */
    private static class C0814a {

        /* renamed from: a */
        com.zk_oaction.adengine.lk_expression.a f34985a;

        /* renamed from: b */
        com.zk_oaction.adengine.lk_expression.a f34986b;

        public C0814a(com.zk_oaction.adengine.lk_expression.a aVar, com.zk_oaction.adengine.lk_expression.a aVar2) {
            this.f34985a = aVar;
            this.f34986b = aVar2;
        }
    }

    public a(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f34978a = cVar;
    }

    private void c(float f2, boolean z) {
        C0814a c0814a;
        C0814a c0814a2;
        C0814a c0814a3;
        float b2;
        com.zk_oaction.adengine.lk_expression.a aVar;
        int i2 = 0;
        float b3 = this.f34981d.get(0).f34986b.b() + f2;
        C0814a c0814a4 = this.f34981d.get(0);
        float b4 = c0814a4.f34986b.b();
        ArrayList<C0814a> arrayList = this.f34981d;
        C0814a c0814a5 = arrayList.get(arrayList.size() - 1);
        float b5 = c0814a5.f34986b.b();
        if (b4 > b5) {
            c0814a5 = c0814a4;
            c0814a4 = c0814a5;
            b5 = b4;
            b4 = b5;
        }
        if (b3 <= b4 && !z) {
            this.f34982e = c0814a4.f34985a.b() + this.f34979b.b();
            aVar = c0814a4.f34986b;
        } else {
            if (b3 < b5 || z) {
                if (b3 <= b4 && z) {
                    c0814a = this.f34981d.get(0);
                    c0814a3 = this.f34981d.get(1);
                } else {
                    if (b3 < b5 || !z) {
                        c0814a = null;
                        c0814a2 = null;
                        while (i2 < this.f34981d.size() - 1) {
                            c0814a = this.f34981d.get(i2);
                            i2++;
                            c0814a2 = this.f34981d.get(i2);
                            if ((b3 - c0814a.f34986b.b()) * (b3 - c0814a2.f34986b.b()) <= 0.0f) {
                                break;
                            }
                        }
                        this.f34982e = c0814a.f34985a.b() + ((c0814a2.f34985a.b() - c0814a.f34985a.b()) * ((b3 - c0814a.f34986b.b()) / (c0814a2.f34986b.b() - c0814a.f34986b.b()))) + this.f34979b.b();
                        b2 = this.f34980c.b() + b3;
                        this.f34983f = b2;
                    }
                    c0814a = this.f34981d.get(r10.size() - 2);
                    ArrayList<C0814a> arrayList2 = this.f34981d;
                    c0814a3 = arrayList2.get(arrayList2.size() - 1);
                }
                c0814a2 = c0814a3;
                this.f34982e = c0814a.f34985a.b() + ((c0814a2.f34985a.b() - c0814a.f34985a.b()) * ((b3 - c0814a.f34986b.b()) / (c0814a2.f34986b.b() - c0814a.f34986b.b()))) + this.f34979b.b();
                b2 = this.f34980c.b() + b3;
                this.f34983f = b2;
            }
            this.f34982e = c0814a5.f34985a.b() + this.f34979b.b();
            aVar = c0814a5.f34986b;
        }
        b2 = aVar.b() + this.f34980c.b();
        this.f34983f = b2;
    }

    private void f(float f2, boolean z) {
        C0814a c0814a;
        C0814a c0814a2;
        C0814a c0814a3;
        float b2;
        com.zk_oaction.adengine.lk_expression.a aVar;
        int i2 = 0;
        float b3 = this.f34981d.get(0).f34985a.b() + f2;
        C0814a c0814a4 = this.f34981d.get(0);
        float b4 = c0814a4.f34985a.b();
        ArrayList<C0814a> arrayList = this.f34981d;
        C0814a c0814a5 = arrayList.get(arrayList.size() - 1);
        float b5 = c0814a5.f34985a.b();
        if (b4 > b5) {
            c0814a5 = c0814a4;
            c0814a4 = c0814a5;
            b5 = b4;
            b4 = b5;
        }
        if (b3 <= b4 && !z) {
            this.f34982e = c0814a4.f34985a.b() + this.f34979b.b();
            aVar = c0814a4.f34986b;
        } else {
            if (b3 < b5 || z) {
                if (b3 <= b4 && z) {
                    c0814a = this.f34981d.get(0);
                    c0814a3 = this.f34981d.get(1);
                } else {
                    if (b3 < b5 || !z) {
                        c0814a = null;
                        c0814a2 = null;
                        while (i2 < this.f34981d.size() - 1) {
                            c0814a = this.f34981d.get(i2);
                            i2++;
                            c0814a2 = this.f34981d.get(i2);
                            if ((b3 - c0814a.f34985a.b()) * (b3 - c0814a2.f34985a.b()) <= 0.0f) {
                                break;
                            }
                        }
                        float b6 = (b3 - c0814a.f34985a.b()) / (c0814a2.f34985a.b() - c0814a.f34985a.b());
                        float b7 = c0814a2.f34986b.b();
                        float b8 = c0814a.f34986b.b();
                        this.f34982e = this.f34979b.b() + b3;
                        b2 = c0814a.f34986b.b() + ((b7 - b8) * b6);
                        this.f34983f = b2 + this.f34980c.b();
                    }
                    c0814a = this.f34981d.get(r10.size() - 2);
                    ArrayList<C0814a> arrayList2 = this.f34981d;
                    c0814a3 = arrayList2.get(arrayList2.size() - 1);
                }
                c0814a2 = c0814a3;
                float b62 = (b3 - c0814a.f34985a.b()) / (c0814a2.f34985a.b() - c0814a.f34985a.b());
                float b72 = c0814a2.f34986b.b();
                float b82 = c0814a.f34986b.b();
                this.f34982e = this.f34979b.b() + b3;
                b2 = c0814a.f34986b.b() + ((b72 - b82) * b62);
                this.f34983f = b2 + this.f34980c.b();
            }
            this.f34982e = c0814a5.f34985a.b() + this.f34979b.b();
            aVar = c0814a5.f34986b;
        }
        b2 = aVar.b();
        this.f34983f = b2 + this.f34980c.b();
    }

    public float a() {
        return this.f34982e;
    }

    public void b(float f2, float f3, boolean z) {
        if (this.f34984g) {
            c(f3, z);
        } else {
            f(f2, z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        r0 = r29.f34981d.get(0);
        r2 = r29.f34981d;
        r2 = r2.get(r2.size() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0089, code lost:
    
        if (java.lang.Math.abs(r0.f34985a.b() - r2.f34985a.b()) >= java.lang.Math.abs(r0.f34986b.b() - r2.f34986b.b())) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008b, code lost:
    
        r29.f34984g = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(org.xmlpull.v1.XmlPullParser r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_unlock.a.d(org.xmlpull.v1.XmlPullParser, java.lang.String):boolean");
    }

    public float e() {
        return this.f34983f;
    }
}
