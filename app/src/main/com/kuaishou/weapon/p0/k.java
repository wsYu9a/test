package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class k<T> implements Runnable {

    /* renamed from: a */
    private String f11116a;

    /* renamed from: b */
    private JSONObject f11117b;

    /* renamed from: c */
    private j f11118c;

    /* renamed from: d */
    private Context f11119d;

    /* renamed from: e */
    private String f11120e;

    /* renamed from: f */
    private String f11121f;

    /* renamed from: com.kuaishou.weapon.p0.k$1 */
    public class AnonymousClass1 implements j {
        public AnonymousClass1() {
        }

        @Override // com.kuaishou.weapon.p0.j
        public void a(String str) {
            e.c("WeaponHttpTask sendLog response: --- " + str);
            if (k.this.f11118c != null) {
                k.this.f11118c.a(str);
            }
        }

        @Override // com.kuaishou.weapon.p0.j
        public void b(String str) {
            e.c("WeaponHttpTask sendLog errorMsg: --- " + str);
            if (k.this.f11118c != null) {
                k.this.f11118c.b(str);
            }
        }
    }

    public k(Context context, String str, String str2, String str3, JSONObject jSONObject, j jVar) {
        this.f11119d = context;
        this.f11116a = str3;
        this.f11117b = jSONObject;
        this.f11118c = jVar;
        this.f11120e = str;
        this.f11121f = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            l a10 = l.a(this.f11119d);
            m mVar = new m(this.f11116a, this.f11117b);
            mVar.a(this.f11120e);
            mVar.b(this.f11121f);
            a10.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.k.1
                public AnonymousClass1() {
                }

                @Override // com.kuaishou.weapon.p0.j
                public void a(String str) {
                    e.c("WeaponHttpTask sendLog response: --- " + str);
                    if (k.this.f11118c != null) {
                        k.this.f11118c.a(str);
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str) {
                    e.c("WeaponHttpTask sendLog errorMsg: --- " + str);
                    if (k.this.f11118c != null) {
                        k.this.f11118c.b(str);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
