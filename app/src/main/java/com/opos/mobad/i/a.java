package com.opos.mobad.i;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public final com.opos.cmn.func.b.b.d f20981a;

    /* renamed from: b */
    public final String f20982b;

    /* renamed from: c */
    public final int f20983c;

    /* renamed from: d */
    public final String f20984d;

    /* renamed from: e */
    public final int f20985e;

    /* renamed from: f */
    public final String f20986f;

    /* renamed from: g */
    public final String f20987g;

    /* renamed from: com.opos.mobad.i.a$a */
    public static class C0449a {

        /* renamed from: a */
        private com.opos.cmn.func.b.b.d f20988a;

        /* renamed from: b */
        private String f20989b;

        /* renamed from: d */
        private String f20991d;

        /* renamed from: f */
        private String f20993f;

        /* renamed from: g */
        private String f20994g;

        /* renamed from: c */
        private int f20990c = -1;

        /* renamed from: e */
        private int f20992e = 0;

        private boolean b(int i2) {
            return i2 == 0 || 1 == i2 || 2 == i2;
        }

        public C0449a a(int i2) {
            this.f20990c = i2;
            return this;
        }

        public C0449a a(com.opos.cmn.func.b.b.d dVar) {
            this.f20988a = dVar;
            return this;
        }

        public C0449a a(String str) {
            this.f20989b = str;
            return this;
        }

        public a a() throws Exception {
            if (this.f20988a == null) {
                throw new NullPointerException("netRequest is null.");
            }
            if (!b(this.f20990c)) {
                throw new Exception("saveType not support!saveType must be SAVE_TYPE_OF_SDCARD or SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE");
            }
            if (this.f20990c == 0 && com.opos.cmn.an.c.a.a(this.f20991d)) {
                throw new NullPointerException("when saveType is SAVE_TYPE_OF_SDCARD.savePath can't be null.");
            }
            int i2 = this.f20990c;
            if ((1 == i2 || 2 == i2) && com.opos.cmn.an.c.a.a(this.f20994g)) {
                throw new NullPointerException("when saveType is SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE.fileName can't be null.");
            }
            return new a(this);
        }

        public C0449a b(String str) {
            this.f20991d = str;
            return this;
        }
    }

    public a(C0449a c0449a) {
        this.f20981a = c0449a.f20988a;
        this.f20982b = c0449a.f20989b;
        this.f20983c = c0449a.f20990c;
        this.f20984d = c0449a.f20991d;
        this.f20985e = c0449a.f20992e;
        this.f20986f = c0449a.f20993f;
        this.f20987g = c0449a.f20994g;
    }

    public String toString() {
        return "DownloadRequest{netRequest=" + this.f20981a + ", md5='" + this.f20982b + "', saveType=" + this.f20983c + ", savePath='" + this.f20984d + "', mode=" + this.f20985e + ", dir='" + this.f20986f + "', fileName='" + this.f20987g + "'}";
    }
}
