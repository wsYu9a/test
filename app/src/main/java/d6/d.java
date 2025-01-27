package d6;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.FormatException;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: h */
    public static final d[] f25267h = a();

    /* renamed from: a */
    public final int f25268a;

    /* renamed from: b */
    public final int f25269b;

    /* renamed from: c */
    public final int f25270c;

    /* renamed from: d */
    public final int f25271d;

    /* renamed from: e */
    public final int f25272e;

    /* renamed from: f */
    public final c f25273f;

    /* renamed from: g */
    public final int f25274g;

    public static final class b {

        /* renamed from: a */
        public final int f25275a;

        /* renamed from: b */
        public final int f25276b;

        public /* synthetic */ b(int i10, int i11, a aVar) {
            this(i10, i11);
        }

        public int a() {
            return this.f25275a;
        }

        public int b() {
            return this.f25276b;
        }

        public b(int i10, int i11) {
            this.f25275a = i10;
            this.f25276b = i11;
        }
    }

    public static final class c {

        /* renamed from: a */
        public final int f25277a;

        /* renamed from: b */
        public final b[] f25278b;

        public /* synthetic */ c(int i10, b bVar, a aVar) {
            this(i10, bVar);
        }

        public b[] a() {
            return this.f25278b;
        }

        public int b() {
            return this.f25277a;
        }

        public /* synthetic */ c(int i10, b bVar, b bVar2, a aVar) {
            this(i10, bVar, bVar2);
        }

        public c(int i10, b bVar) {
            this.f25277a = i10;
            this.f25278b = new b[]{bVar};
        }

        public c(int i10, b bVar, b bVar2) {
            this.f25277a = i10;
            this.f25278b = new b[]{bVar, bVar2};
        }
    }

    public d(int i10, int i11, int i12, int i13, int i14, c cVar) {
        this.f25268a = i10;
        this.f25269b = i11;
        this.f25270c = i12;
        this.f25271d = i13;
        this.f25272e = i14;
        this.f25273f = cVar;
        int b10 = cVar.b();
        int i15 = 0;
        for (b bVar : cVar.a()) {
            i15 += bVar.a() * (bVar.b() + b10);
        }
        this.f25274g = i15;
    }

    public static d[] a() {
        return new d[]{new d(1, 10, 10, 8, 8, new c(5, new b(1, 3))), new d(2, 12, 12, 10, 10, new c(7, new b(1, 5))), new d(3, 14, 14, 12, 12, new c(10, new b(1, 8))), new d(4, 16, 16, 14, 14, new c(12, new b(1, 12))), new d(5, 18, 18, 16, 16, new c(14, new b(1, 18))), new d(6, 20, 20, 18, 18, new c(18, new b(1, 22))), new d(7, 22, 22, 20, 20, new c(20, new b(1, 30))), new d(8, 24, 24, 22, 22, new c(24, new b(1, 36))), new d(9, 26, 26, 24, 24, new c(28, new b(1, 44))), new d(10, 32, 32, 14, 14, new c(36, new b(1, 62))), new d(11, 36, 36, 16, 16, new c(42, new b(1, 86))), new d(12, 40, 40, 18, 18, new c(48, new b(1, 114))), new d(13, 44, 44, 20, 20, new c(56, new b(1, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS))), new d(14, 48, 48, 22, 22, new c(68, new b(1, 174))), new d(15, 52, 52, 24, 24, new c(42, new b(2, 102))), new d(16, 64, 64, 14, 14, new c(56, new b(2, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL))), new d(17, 72, 72, 16, 16, new c(36, new b(4, 92))), new d(18, 80, 80, 18, 18, new c(48, new b(4, 114))), new d(19, 88, 88, 20, 20, new c(56, new b(4, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS))), new d(20, 96, 96, 22, 22, new c(68, new b(4, 174))), new d(21, 104, 104, 24, 24, new c(56, new b(6, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME))), new d(22, 120, 120, 18, 18, new c(68, new b(6, 175))), new d(23, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, 20, 20, new c(62, new b(8, 163))), new d(24, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS, 22, 22, new c(62, new b(8, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL), new b(2, 155))), new d(25, 8, 18, 6, 16, new c(7, new b(1, 5))), new d(26, 8, 32, 6, 14, new c(11, new b(1, 10))), new d(27, 12, 26, 10, 24, new c(14, new b(1, 16))), new d(28, 12, 36, 10, 16, new c(18, new b(1, 22))), new d(29, 16, 36, 14, 16, new c(24, new b(1, 32))), new d(30, 16, 48, 14, 22, new c(28, new b(1, 49)))};
    }

    public static d h(int i10, int i11) throws FormatException {
        if ((i10 & 1) != 0 || (i11 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        for (d dVar : f25267h) {
            if (dVar.f25269b == i10 && dVar.f25270c == i11) {
                return dVar;
            }
        }
        throw FormatException.getFormatInstance();
    }

    public int b() {
        return this.f25272e;
    }

    public int c() {
        return this.f25271d;
    }

    public c d() {
        return this.f25273f;
    }

    public int e() {
        return this.f25270c;
    }

    public int f() {
        return this.f25269b;
    }

    public int g() {
        return this.f25274g;
    }

    public int i() {
        return this.f25268a;
    }

    public String toString() {
        return String.valueOf(this.f25268a);
    }
}
