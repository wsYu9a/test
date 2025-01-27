package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k<T> implements Runnable {

    /* renamed from: a */
    private String f9331a;

    /* renamed from: b */
    private JSONObject f9332b;

    /* renamed from: c */
    private j f9333c;

    /* renamed from: d */
    private Context f9334d;

    /* renamed from: e */
    private String f9335e;

    /* renamed from: f */
    private String f9336f;

    /* renamed from: com.kuaishou.weapon.p0.k$1 */
    class AnonymousClass1 implements j {
        AnonymousClass1() {
        }

        @Override // com.kuaishou.weapon.p0.j
        public void a(String str) {
            e.c("WeaponHttpTask sendLog response: --- " + str);
            if (k.this.f9333c != null) {
                k.this.f9333c.a(str);
            }
        }

        @Override // com.kuaishou.weapon.p0.j
        public void b(String str) {
            e.c("WeaponHttpTask sendLog errorMsg: --- " + str);
            if (k.this.f9333c != null) {
                k.this.f9333c.b(str);
            }
        }
    }

    public k(Context context, String str, String str2, String str3, JSONObject jSONObject, j jVar) {
        this.f9334d = context;
        this.f9331a = str3;
        this.f9332b = jSONObject;
        this.f9333c = jVar;
        this.f9335e = str;
        this.f9336f = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            l a2 = l.a(this.f9334d);
            m mVar = new m(this.f9331a, this.f9332b);
            mVar.a(this.f9335e);
            mVar.b(this.f9336f);
            a2.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.k.1
                AnonymousClass1() {
                }

                @Override // com.kuaishou.weapon.p0.j
                public void a(String str) {
                    e.c("WeaponHttpTask sendLog response: --- " + str);
                    if (k.this.f9333c != null) {
                        k.this.f9333c.a(str);
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str) {
                    e.c("WeaponHttpTask sendLog errorMsg: --- " + str);
                    if (k.this.f9333c != null) {
                        k.this.f9333c.b(str);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
