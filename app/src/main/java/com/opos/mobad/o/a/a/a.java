package com.opos.mobad.o.a.a;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public String f22952a;

    /* renamed from: b */
    public ArrayList<b> f22953b;

    /* renamed from: com.opos.mobad.o.a.a.a$a */
    public static class C0470a {

        /* renamed from: a */
        private String f22954a = "";

        /* renamed from: b */
        private ArrayList<b> f22955b = new ArrayList<>();

        public C0470a a(b bVar) {
            if (!this.f22955b.contains(bVar)) {
                this.f22955b.add(bVar);
            }
            return this;
        }

        public C0470a a(String str) {
            this.f22954a = str;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    public a(C0470a c0470a) {
        this.f22953b = c0470a.f22955b;
        this.f22952a = c0470a.f22954a;
    }
}
