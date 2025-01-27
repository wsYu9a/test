package com.opos.mobad.d.a;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    public final int f20418a;

    /* renamed from: b */
    public final boolean f20419b;

    /* renamed from: c */
    public final String f20420c;

    /* renamed from: d */
    public final String f20421d;

    /* renamed from: e */
    public final int f20422e;

    public static class a {

        /* renamed from: a */
        public int f20423a;

        /* renamed from: b */
        public boolean f20424b;

        /* renamed from: c */
        public String f20425c;

        /* renamed from: d */
        public String f20426d;

        /* renamed from: e */
        public int f20427e;

        public a a(int i2) {
            this.f20423a = i2;
            return this;
        }

        public a a(String str) {
            this.f20425c = str;
            return this;
        }

        public a a(boolean z) {
            this.f20424b = z;
            return this;
        }

        public e a() {
            return new e(this);
        }

        public a b(int i2) {
            this.f20427e = i2;
            return this;
        }

        public a b(String str) {
            this.f20426d = str;
            return this;
        }

        public String toString() {
            return "Builder{iconId=" + this.f20423a + ", autoCancel=" + this.f20424b + ", notificationChannelId=" + this.f20425c + ", notificationChannelName='" + this.f20426d + "', notificationChannelImportance=" + this.f20427e + '}';
        }
    }

    public e(a aVar) {
        this.f20418a = aVar.f20423a;
        this.f20419b = aVar.f20424b;
        this.f20420c = aVar.f20425c;
        this.f20421d = aVar.f20426d;
        this.f20422e = aVar.f20427e;
    }
}
