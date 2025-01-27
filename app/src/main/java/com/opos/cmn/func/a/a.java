package com.opos.cmn.func.a;

import com.opos.cmn.an.g.f;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public final f f17014a;

    /* renamed from: b */
    public final String f17015b;

    /* renamed from: c */
    public final int f17016c;

    /* renamed from: d */
    public final String f17017d;

    /* renamed from: e */
    public final int f17018e;

    /* renamed from: f */
    public final String f17019f;

    /* renamed from: g */
    public final String f17020g;

    /* renamed from: com.opos.cmn.func.a.a$a */
    public static class C0385a {

        /* renamed from: a */
        private f f17021a;

        /* renamed from: b */
        private String f17022b;

        /* renamed from: d */
        private String f17024d;

        /* renamed from: f */
        private String f17026f;

        /* renamed from: g */
        private String f17027g;

        /* renamed from: c */
        private int f17023c = -1;

        /* renamed from: e */
        private int f17025e = 0;

        private boolean b(int i2) {
            return i2 == 0 || 1 == i2 || 2 == i2;
        }

        public C0385a a(int i2) {
            this.f17023c = i2;
            return this;
        }

        public C0385a a(f fVar) {
            this.f17021a = fVar;
            return this;
        }

        public C0385a a(String str) {
            this.f17022b = str;
            return this;
        }

        public a a() {
            if (this.f17021a == null) {
                throw new NullPointerException("netRequest is null.");
            }
            if (!b(this.f17023c)) {
                throw new Exception("saveType not support!saveType must be SAVE_TYPE_OF_SDCARD or SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE");
            }
            if (this.f17023c == 0 && com.opos.cmn.an.c.a.a(this.f17024d)) {
                throw new NullPointerException("when saveType is SAVE_TYPE_OF_SDCARD.savePath can't be null.");
            }
            int i2 = this.f17023c;
            if ((1 == i2 || 2 == i2) && com.opos.cmn.an.c.a.a(this.f17027g)) {
                throw new NullPointerException("when saveType is SAVE_TYPE_OF_APP_FILE or SAVE_TYPE_OF_APP_DIR_FILE.fileName can't be null.");
            }
            return new a(this);
        }

        public C0385a b(String str) {
            this.f17024d = str;
            return this;
        }
    }

    public a(C0385a c0385a) {
        this.f17014a = c0385a.f17021a;
        this.f17015b = c0385a.f17022b;
        this.f17016c = c0385a.f17023c;
        this.f17017d = c0385a.f17024d;
        this.f17018e = c0385a.f17025e;
        this.f17019f = c0385a.f17026f;
        this.f17020g = c0385a.f17027g;
    }

    public String toString() {
        return "DownloadRequest{netRequest=" + this.f17014a + ", md5='" + this.f17015b + "', saveType=" + this.f17016c + ", savePath='" + this.f17017d + "', mode=" + this.f17018e + ", dir='" + this.f17019f + "', fileName='" + this.f17020g + "'}";
    }
}
