package t6;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.FormatException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: e */
    public static final int[] f30739e = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    /* renamed from: f */
    public static final f[] f30740f = b();

    /* renamed from: a */
    public final int f30741a;

    /* renamed from: b */
    public final int[] f30742b;

    /* renamed from: c */
    public final b[] f30743c;

    /* renamed from: d */
    public final int f30744d;

    public static final class a {

        /* renamed from: a */
        public final int f30745a;

        /* renamed from: b */
        public final int f30746b;

        public a(int i10, int i11) {
            this.f30745a = i10;
            this.f30746b = i11;
        }

        public int a() {
            return this.f30745a;
        }

        public int b() {
            return this.f30746b;
        }
    }

    public static final class b {

        /* renamed from: a */
        public final int f30747a;

        /* renamed from: b */
        public final a[] f30748b;

        public b(int i10, a... aVarArr) {
            this.f30747a = i10;
            this.f30748b = aVarArr;
        }

        public a[] a() {
            return this.f30748b;
        }

        public int b() {
            return this.f30747a;
        }

        public int c() {
            int i10 = 0;
            for (a aVar : this.f30748b) {
                i10 += aVar.a();
            }
            return i10;
        }

        public int d() {
            return this.f30747a * c();
        }
    }

    public f(int i10, int[] iArr, b... bVarArr) {
        this.f30741a = i10;
        this.f30742b = iArr;
        this.f30743c = bVarArr;
        int b10 = bVarArr[0].b();
        int i11 = 0;
        for (a aVar : bVarArr[0].a()) {
            i11 += aVar.a() * (aVar.b() + b10);
        }
        this.f30744d = i11;
    }

    public static f[] b() {
        return new f[]{new f(1, new int[0], new b(7, new a(1, 19)), new b(10, new a(1, 16)), new b(13, new a(1, 13)), new b(17, new a(1, 9))), new f(2, new int[]{6, 18}, new b(10, new a(1, 34)), new b(16, new a(1, 28)), new b(22, new a(1, 22)), new b(28, new a(1, 16))), new f(3, new int[]{6, 22}, new b(15, new a(1, 55)), new b(26, new a(1, 44)), new b(18, new a(2, 17)), new b(22, new a(2, 13))), new f(4, new int[]{6, 26}, new b(20, new a(1, 80)), new b(18, new a(2, 32)), new b(26, new a(2, 24)), new b(16, new a(4, 9))), new f(5, new int[]{6, 30}, new b(26, new a(1, 108)), new b(24, new a(2, 43)), new b(18, new a(2, 15), new a(2, 16)), new b(22, new a(2, 11), new a(2, 12))), new f(6, new int[]{6, 34}, new b(18, new a(2, 68)), new b(16, new a(4, 27)), new b(24, new a(4, 19)), new b(28, new a(4, 15))), new f(7, new int[]{6, 22, 38}, new b(20, new a(2, 78)), new b(18, new a(4, 31)), new b(18, new a(2, 14), new a(4, 15)), new b(26, new a(4, 13), new a(1, 14))), new f(8, new int[]{6, 24, 42}, new b(24, new a(2, 97)), new b(22, new a(2, 38), new a(2, 39)), new b(22, new a(4, 18), new a(2, 19)), new b(26, new a(4, 14), new a(2, 15))), new f(9, new int[]{6, 26, 46}, new b(30, new a(2, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP)), new b(22, new a(3, 36), new a(2, 37)), new b(20, new a(4, 16), new a(4, 17)), new b(24, new a(4, 12), new a(4, 13))), new f(10, new int[]{6, 28, 50}, new b(18, new a(2, 68), new a(2, 69)), new b(26, new a(4, 43), new a(1, 44)), new b(24, new a(6, 19), new a(2, 20)), new b(28, new a(6, 15), new a(2, 16))), new f(11, new int[]{6, 30, 54}, new b(20, new a(4, 81)), new b(30, new a(1, 50), new a(4, 51)), new b(28, new a(4, 22), new a(4, 23)), new b(24, new a(3, 12), new a(8, 13))), new f(12, new int[]{6, 32, 58}, new b(24, new a(2, 92), new a(2, 93)), new b(22, new a(6, 36), new a(2, 37)), new b(26, new a(4, 20), new a(6, 21)), new b(28, new a(7, 14), new a(4, 15))), new f(13, new int[]{6, 34, 62}, new b(26, new a(4, 107)), new b(22, new a(8, 37), new a(1, 38)), new b(24, new a(8, 20), new a(4, 21)), new b(22, new a(12, 11), new a(4, 12))), new f(14, new int[]{6, 26, 46, 66}, new b(30, new a(3, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY), new a(1, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP)), new b(24, new a(4, 40), new a(5, 41)), new b(20, new a(11, 16), new a(5, 17)), new b(24, new a(11, 12), new a(5, 13))), new f(15, new int[]{6, 26, 48, 70}, new b(22, new a(5, 87), new a(1, 88)), new b(24, new a(5, 41), new a(5, 42)), new b(30, new a(5, 24), new a(7, 25)), new b(24, new a(11, 12), new a(7, 13))), new f(16, new int[]{6, 26, 50, 74}, new b(24, new a(5, 98), new a(1, 99)), new b(28, new a(7, 45), new a(3, 46)), new b(24, new a(15, 19), new a(2, 20)), new b(30, new a(3, 15), new a(13, 16))), new f(17, new int[]{6, 30, 54, 78}, new b(28, new a(1, 107), new a(5, 108)), new b(28, new a(10, 46), new a(1, 47)), new b(28, new a(1, 22), new a(15, 23)), new b(28, new a(2, 14), new a(17, 15))), new f(18, new int[]{6, 30, 56, 82}, new b(30, new a(5, 120), new a(1, 121)), new b(26, new a(9, 43), new a(4, 44)), new b(28, new a(17, 22), new a(1, 23)), new b(28, new a(2, 14), new a(19, 15))), new f(19, new int[]{6, 30, 58, 86}, new b(28, new a(3, 113), new a(4, 114)), new b(26, new a(3, 44), new a(11, 45)), new b(26, new a(17, 21), new a(4, 22)), new b(26, new a(9, 13), new a(16, 14))), new f(20, new int[]{6, 34, 62, 90}, new b(28, new a(3, 107), new a(5, 108)), new b(26, new a(3, 41), new a(13, 42)), new b(30, new a(15, 24), new a(5, 25)), new b(28, new a(15, 15), new a(10, 16))), new f(21, new int[]{6, 28, 50, 72, 94}, new b(28, new a(4, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP), new a(4, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE)), new b(26, new a(17, 42)), new b(28, new a(17, 22), new a(6, 23)), new b(30, new a(19, 16), new a(6, 17))), new f(22, new int[]{6, 26, 50, 74, 98}, new b(28, new a(2, 111), new a(7, 112)), new b(28, new a(17, 46)), new b(30, new a(7, 24), new a(16, 25)), new b(24, new a(34, 13))), new f(23, new int[]{6, 30, 54, 78, 102}, new b(30, new a(4, 121), new a(5, 122)), new b(28, new a(4, 47), new a(14, 48)), new b(30, new a(11, 24), new a(14, 25)), new b(30, new a(16, 15), new a(14, 16))), new f(24, new int[]{6, 28, 54, 80, 106}, new b(30, new a(6, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE), new a(4, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST)), new b(28, new a(6, 45), new a(14, 46)), new b(30, new a(11, 24), new a(16, 25)), new b(30, new a(30, 16), new a(2, 17))), new f(25, new int[]{6, 32, 58, 84, 110}, new b(26, new a(8, 106), new a(4, 107)), new b(28, new a(8, 47), new a(13, 48)), new b(30, new a(7, 24), new a(22, 25)), new b(30, new a(22, 15), new a(13, 16))), new f(26, new int[]{6, 30, 58, 86, 114}, new b(28, new a(10, 114), new a(2, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY)), new b(28, new a(19, 46), new a(4, 47)), new b(28, new a(28, 22), new a(6, 23)), new b(30, new a(33, 16), new a(4, 17))), new f(27, new int[]{6, 34, 62, 90, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST}, new b(30, new a(8, 122), new a(4, 123)), new b(28, new a(22, 45), new a(3, 46)), new b(30, new a(8, 23), new a(26, 24)), new b(30, new a(12, 15), new a(28, 16))), new f(28, new int[]{6, 26, 50, 74, 98, 122}, new b(30, new a(3, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE), new a(10, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST)), new b(28, new a(3, 45), new a(23, 46)), new b(30, new a(4, 24), new a(31, 25)), new b(30, new a(11, 15), new a(31, 16))), new f(29, new int[]{6, 30, 54, 78, 102, 126}, new b(30, new a(7, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP), new a(7, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE)), new b(28, new a(21, 45), new a(7, 46)), new b(30, new a(1, 23), new a(37, 24)), new b(30, new a(19, 15), new a(26, 16))), new f(30, new int[]{6, 26, 52, 78, 104, 130}, new b(30, new a(5, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY), new a(10, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP)), new b(28, new a(19, 47), new a(10, 48)), new b(30, new a(15, 24), new a(25, 25)), new b(30, new a(23, 15), new a(25, 16))), new f(31, new int[]{6, 30, 56, 82, 108, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE}, new b(30, new a(13, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY), new a(3, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP)), new b(28, new a(2, 46), new a(29, 47)), new b(30, new a(42, 24), new a(1, 25)), new b(30, new a(23, 15), new a(28, 16))), new f(32, new int[]{6, 34, 60, 86, 112, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK}, new b(30, new a(17, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY)), new b(28, new a(10, 46), new a(23, 47)), new b(30, new a(10, 24), new a(35, 25)), new b(30, new a(19, 15), new a(35, 16))), new f(33, new int[]{6, 30, 58, 86, 114, 142}, new b(30, new a(17, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY), new a(1, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP)), new b(28, new a(14, 46), new a(21, 47)), new b(30, new a(29, 24), new a(19, 25)), new b(30, new a(11, 15), new a(46, 16))), new f(34, new int[]{6, 34, 62, 90, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH}, new b(30, new a(13, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY), new a(6, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP)), new b(28, new a(14, 46), new a(23, 47)), new b(30, new a(44, 24), new a(7, 25)), new b(30, new a(59, 16), new a(1, 17))), new f(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new b(30, new a(12, 121), new a(7, 122)), new b(28, new a(12, 47), new a(26, 48)), new b(30, new a(39, 24), new a(14, 25)), new b(30, new a(22, 15), new a(41, 16))), new f(36, new int[]{6, 24, 50, 76, 102, 128, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND}, new b(30, new a(6, 121), new a(14, 122)), new b(28, new a(6, 47), new a(34, 48)), new b(30, new a(46, 24), new a(10, 25)), new b(30, new a(2, 15), new a(64, 16))), new f(37, new int[]{6, 28, 54, 80, 106, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT}, new b(30, new a(17, 122), new a(4, 123)), new b(28, new a(29, 46), new a(14, 47)), new b(30, new a(49, 24), new a(10, 25)), new b(30, new a(24, 15), new a(46, 16))), new f(38, new int[]{6, 32, 58, 84, 110, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 162}, new b(30, new a(4, 122), new a(18, 123)), new b(28, new a(13, 46), new a(32, 47)), new b(30, new a(48, 24), new a(14, 25)), new b(30, new a(42, 15), new a(32, 16))), new f(39, new int[]{6, 26, 54, 82, 110, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, TTAdConstant.IMAGE_MODE_LIVE}, new b(30, new a(20, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE), new a(4, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST)), new b(28, new a(40, 47), new a(7, 48)), new b(30, new a(43, 24), new a(22, 25)), new b(30, new a(10, 15), new a(67, 16))), new f(40, new int[]{6, 30, 58, 86, 114, 142, 170}, new b(30, new a(19, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST), new a(6, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_SDK_MONITOR_SCENE)), new b(28, new a(18, 47), new a(31, 48)), new b(30, new a(34, 24), new a(34, 25)), new b(30, new a(20, 15), new a(61, 16)))};
    }

    public static f c(int i10) {
        int i11 = Integer.MAX_VALUE;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int[] iArr = f30739e;
            if (i12 >= iArr.length) {
                if (i11 <= 3) {
                    return i(i13);
                }
                return null;
            }
            int i14 = iArr[i12];
            if (i14 == i10) {
                return i(i12 + 7);
            }
            int e10 = d.e(i10, i14);
            if (e10 < i11) {
                i13 = i12 + 7;
                i11 = e10;
            }
            i12++;
        }
    }

    public static f g(int i10) throws FormatException {
        if (i10 % 4 != 1) {
            throw FormatException.getFormatInstance();
        }
        try {
            return i((i10 - 17) / 4);
        } catch (IllegalArgumentException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static f i(int i10) {
        if (i10 <= 0 || i10 > 40) {
            throw new IllegalArgumentException();
        }
        return f30740f[i10 - 1];
    }

    public z5.b a() {
        int e10 = e();
        z5.b bVar = new z5.b(e10);
        bVar.p(0, 0, 9, 9);
        int i10 = e10 - 8;
        bVar.p(i10, 0, 8, 9);
        bVar.p(0, i10, 9, 8);
        int length = this.f30742b.length;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = this.f30742b[i11] - 2;
            for (int i13 = 0; i13 < length; i13++) {
                if ((i11 != 0 || (i13 != 0 && i13 != length - 1)) && (i11 != length - 1 || i13 != 0)) {
                    bVar.p(this.f30742b[i13] - 2, i12, 5, 5);
                }
            }
        }
        int i14 = e10 - 17;
        bVar.p(6, 9, 1, i14);
        bVar.p(9, 6, i14, 1);
        if (this.f30741a > 6) {
            int i15 = e10 - 11;
            bVar.p(i15, 0, 3, 6);
            bVar.p(0, i15, 6, 3);
        }
        return bVar;
    }

    public int[] d() {
        return this.f30742b;
    }

    public int e() {
        return (this.f30741a * 4) + 17;
    }

    public b f(ErrorCorrectionLevel errorCorrectionLevel) {
        return this.f30743c[errorCorrectionLevel.ordinal()];
    }

    public int h() {
        return this.f30744d;
    }

    public int j() {
        return this.f30741a;
    }

    public String toString() {
        return String.valueOf(this.f30741a);
    }
}
