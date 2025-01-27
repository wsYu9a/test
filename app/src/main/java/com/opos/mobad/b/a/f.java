package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import java.io.IOException;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class f extends com.heytap.nearx.a.a.b<f, a> {

    /* renamed from: c */
    public static final com.heytap.nearx.a.a.e<f> f19696c = new b();
    private static final long serialVersionUID = 0;

    /* renamed from: d */
    public final String f19697d;

    /* renamed from: e */
    public final String f19698e;

    /* renamed from: f */
    public final String f19699f;

    /* renamed from: g */
    public final String f19700g;

    public static final class a extends b.a<f, a> {

        /* renamed from: c */
        public String f19701c;

        /* renamed from: d */
        public String f19702d;

        /* renamed from: e */
        public String f19703e;

        /* renamed from: f */
        public String f19704f;

        public a a(String str) {
            this.f19701c = str;
            return this;
        }

        public a b(String str) {
            this.f19702d = str;
            return this;
        }

        public f b() {
            return new f(this.f19701c, this.f19702d, this.f19703e, this.f19704f, super.a());
        }

        public a c(String str) {
            this.f19703e = str;
            return this;
        }

        public a d(String str) {
            this.f19704f = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<f> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, f.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(f fVar) {
            String str = fVar.f19697d;
            int a2 = str != null ? com.heytap.nearx.a.a.e.p.a(1, (int) str) : 0;
            String str2 = fVar.f19698e;
            int a3 = str2 != null ? com.heytap.nearx.a.a.e.p.a(2, (int) str2) : 0;
            String str3 = fVar.f19699f;
            int a4 = str3 != null ? com.heytap.nearx.a.a.e.p.a(3, (int) str3) : 0;
            String str4 = fVar.f19700g;
            return a4 + a3 + a2 + (str4 != null ? com.heytap.nearx.a.a.e.p.a(4, (int) str4) : 0) + fVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, f fVar) throws IOException {
            String str = fVar.f19697d;
            if (str != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, str);
            }
            String str2 = fVar.f19698e;
            if (str2 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, str2);
            }
            String str3 = fVar.f19699f;
            if (str3 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, str3);
            }
            String str4 = fVar.f19700g;
            if (str4 != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, str4);
            }
            gVar.a(fVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public f a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b2 = fVar.b();
                if (b2 == -1) {
                    fVar.a(a2);
                    return aVar.b();
                }
                if (b2 == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 == 2) {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 == 3) {
                    aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (b2 != 4) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b2, c2, c2.a().a(fVar));
                } else {
                    aVar.d(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public f(String str, String str2, String str3, String str4, ByteString byteString) {
        super(f19696c, byteString);
        this.f19697d = str;
        this.f19698e = str2;
        this.f19699f = str3;
        this.f19700g = str4;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f19697d != null) {
            sb.append(", url=");
            sb.append(this.f19697d);
        }
        if (this.f19698e != null) {
            sb.append(", md5=");
            sb.append(this.f19698e);
        }
        if (this.f19699f != null) {
            sb.append(", pkgName=");
            sb.append(this.f19699f);
        }
        if (this.f19700g != null) {
            sb.append(", appName=");
            sb.append(this.f19700g);
        }
        StringBuilder replace = sb.replace(0, 2, "AppDownInfo{");
        replace.append('}');
        return replace.toString();
    }
}
