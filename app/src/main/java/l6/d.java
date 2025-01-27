package l6;

import aj.e;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.martian.mibook.fragment.BookMarkFragment;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.bugly.beta.tinker.TinkerReport;
import j6.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k6.f;
import m6.j;
import t5.k;
import t5.l;

/* loaded from: classes2.dex */
public final class d extends k6.a {
    public static final int A = 11;

    /* renamed from: t */
    public static final int f27942t = 0;

    /* renamed from: u */
    public static final int f27943u = 1;

    /* renamed from: v */
    public static final int f27944v = 2;

    /* renamed from: w */
    public static final int f27945w = 3;

    /* renamed from: x */
    public static final int f27946x = 4;

    /* renamed from: y */
    public static final int f27947y = 5;

    /* renamed from: k */
    public final List<b> f27949k = new ArrayList(11);

    /* renamed from: l */
    public final List<c> f27950l = new ArrayList();

    /* renamed from: m */
    public final int[] f27951m = new int[2];

    /* renamed from: n */
    public boolean f27952n;

    /* renamed from: o */
    public static final int[] f27937o = {7, 5, 4, 3, 1};

    /* renamed from: p */
    public static final int[] f27938p = {4, 20, 52, 104, 204};

    /* renamed from: q */
    public static final int[] f27939q = {0, 348, 1388, 2948, 3988};

    /* renamed from: r */
    public static final int[][] f27940r = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* renamed from: s */
    public static final int[][] f27941s = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, TinkerReport.KEY_APPLIED_VERSION_CHECK, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST, 143, 7, 21, 63}, new int[]{189, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION, 13, 39, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, 209, 205}, new int[]{193, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 49, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME, 19, 57, 171, 91}, new int[]{62, 186, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 197, 169, 85, 44, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID}, new int[]{185, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 52, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL}, new int[]{46, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, 203, 187, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL, 206, e.f201j, TTAdConstant.IMAGE_MODE_LIVE}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_SDK_MONITOR_SCENE, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH}, new int[]{16, 48, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS, 10, 30, 90, 59, 177}, new int[]{109, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 130, 179, TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY}, new int[]{TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, 191, 151, 31, 93, 68, 204, 190}, new int[]{TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 40}, new int[]{120, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, BookMarkFragment.f13618i, 175}, new int[]{103, 98, 83, 38, 114, 131, TinkerReport.KEY_APPLIED_DEX_EXTRACT, 124}, new int[]{161, 61, TinkerReport.KEY_APPLIED_LIB_EXTRACT, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_LOG_EXTRA, 194, 160, 58, 174, 100, 89}};

    /* renamed from: z */
    public static final int[][] f27948z = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    public static int A(z5.a aVar, int i10) {
        return aVar.h(i10) ? aVar.j(aVar.k(i10)) : aVar.k(aVar.j(i10));
    }

    public static boolean C(k6.c cVar, boolean z10, boolean z11) {
        return (cVar.c() == 0 && z10 && z11) ? false : true;
    }

    public static boolean D(Iterable<b> iterable, Iterable<c> iterable2) {
        for (c cVar : iterable2) {
            for (b bVar : iterable) {
                Iterator<b> it = cVar.a().iterator();
                while (it.hasNext()) {
                    if (bVar.equals(it.next())) {
                        break;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean E(List<b> list) {
        for (int[] iArr : f27948z) {
            if (list.size() <= iArr.length) {
                for (int i10 = 0; i10 < list.size(); i10++) {
                    if (list.get(i10).b().c() != iArr[i10]) {
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void G(List<b> list, List<c> list2) {
        Iterator<c> it = list2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != list.size()) {
                Iterator<b> it2 = next.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = list.iterator();
                    while (it3.hasNext()) {
                        if (next2.equals(it3.next())) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void I(int[] iArr) {
        int length = iArr.length;
        for (int i10 = 0; i10 < length / 2; i10++) {
            int i11 = iArr[i10];
            int i12 = (length - i10) - 1;
            iArr[i10] = iArr[i12];
            iArr[i12] = i11;
        }
    }

    public static k w(List<b> list) throws NotFoundException, FormatException {
        String d10 = j.a(a.a(list)).d();
        l[] a10 = list.get(0).b().a();
        l[] a11 = list.get(list.size() - 1).b().a();
        return new k(d10, null, new l[]{a10[0], a10[1], a11[0], a11[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    public List<c> B() {
        return this.f27950l;
    }

    public final k6.c F(z5.a aVar, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        if (z10) {
            int i14 = this.f27951m[0] - 1;
            while (i14 >= 0 && !aVar.h(i14)) {
                i14--;
            }
            int i15 = i14 + 1;
            int[] iArr = this.f27951m;
            i13 = iArr[0] - i15;
            i11 = iArr[1];
            i12 = i15;
        } else {
            int[] iArr2 = this.f27951m;
            int i16 = iArr2[0];
            int k10 = aVar.k(iArr2[1] + 1);
            i11 = k10;
            i12 = i16;
            i13 = k10 - this.f27951m[1];
        }
        int[] k11 = k();
        System.arraycopy(k11, 0, k11, 1, k11.length - 1);
        k11[0] = i13;
        try {
            return new k6.c(k6.a.r(k11, f27940r), new int[]{i12, i11}, i12, i11, i10);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public b H(z5.a aVar, List<b> list, int i10) throws NotFoundException {
        k6.c F;
        k6.b bVar;
        boolean z10 = list.size() % 2 == 0;
        if (this.f27952n) {
            z10 = !z10;
        }
        int i11 = -1;
        boolean z11 = true;
        do {
            z(aVar, list, i11);
            F = F(aVar, i10, z10);
            if (F == null) {
                i11 = A(aVar, this.f27951m[0]);
            } else {
                z11 = false;
            }
        } while (z11);
        k6.b x10 = x(aVar, F, z10, true);
        if (!list.isEmpty() && list.get(list.size() - 1).g()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            bVar = x(aVar, F, z10, false);
        } catch (NotFoundException unused) {
            bVar = null;
        }
        return new b(x10, bVar, F, true);
    }

    public final void J(int i10, boolean z10) {
        boolean z11 = false;
        int i11 = 0;
        boolean z12 = false;
        while (true) {
            if (i11 >= this.f27950l.size()) {
                break;
            }
            c cVar = this.f27950l.get(i11);
            if (cVar.b() > i10) {
                z11 = cVar.c(this.f27949k);
                break;
            } else {
                z12 = cVar.c(this.f27949k);
                i11++;
            }
        }
        if (z11 || z12 || D(this.f27949k, this.f27950l)) {
            return;
        }
        this.f27950l.add(i11, new c(this.f27949k, i10, z10));
        G(this.f27949k, this.f27950l);
    }

    @Override // j6.q
    public k c(int i10, z5.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.f27949k.clear();
        this.f27952n = false;
        try {
            return w(y(i10, aVar));
        } catch (NotFoundException unused) {
            this.f27949k.clear();
            this.f27952n = true;
            return w(y(i10, aVar));
        }
    }

    @Override // j6.q, t5.j
    public void reset() {
        this.f27949k.clear();
        this.f27950l.clear();
    }

    public final void s(int i10) throws NotFoundException {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int d10 = a6.a.d(n());
        int d11 = a6.a.d(l());
        boolean z14 = true;
        if (d10 > 13) {
            z10 = false;
            z11 = true;
        } else {
            z10 = d10 < 4;
            z11 = false;
        }
        if (d11 > 13) {
            z12 = false;
            z13 = true;
        } else {
            z12 = d11 < 4;
            z13 = false;
        }
        int i11 = (d10 + d11) - i10;
        boolean z15 = (d10 & 1) == 1;
        boolean z16 = (d11 & 1) == 0;
        if (i11 == 1) {
            if (z15) {
                if (z16) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z14 = z10;
                z11 = true;
            } else {
                if (!z16) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z14 = z10;
                z13 = true;
            }
        } else if (i11 == -1) {
            if (z15) {
                if (z16) {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else {
                if (!z16) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z14 = z10;
                z12 = true;
            }
        } else {
            if (i11 != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (z15) {
                if (!z16) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (d10 >= d11) {
                    z14 = z10;
                    z12 = true;
                    z11 = true;
                }
                z13 = true;
            } else {
                if (z16) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z14 = z10;
            }
        }
        if (z14) {
            if (z11) {
                throw NotFoundException.getNotFoundInstance();
            }
            k6.a.p(n(), o());
        }
        if (z11) {
            k6.a.i(n(), o());
        }
        if (z12) {
            if (z13) {
                throw NotFoundException.getNotFoundInstance();
            }
            k6.a.p(l(), o());
        }
        if (z13) {
            k6.a.i(l(), m());
        }
    }

    public final boolean t() {
        b bVar = this.f27949k.get(0);
        k6.b c10 = bVar.c();
        k6.b d10 = bVar.d();
        if (d10 == null) {
            return false;
        }
        int a10 = d10.a();
        int i10 = 2;
        for (int i11 = 1; i11 < this.f27949k.size(); i11++) {
            b bVar2 = this.f27949k.get(i11);
            a10 += bVar2.c().a();
            int i12 = i10 + 1;
            k6.b d11 = bVar2.d();
            if (d11 != null) {
                a10 += d11.a();
                i10 += 2;
            } else {
                i10 = i12;
            }
        }
        return ((i10 + (-4)) * AdEventType.VIDEO_LOADING) + (a10 % AdEventType.VIDEO_LOADING) == c10.b();
    }

    public final List<b> u(List<c> list, int i10) throws NotFoundException {
        while (i10 < this.f27950l.size()) {
            c cVar = this.f27950l.get(i10);
            this.f27949k.clear();
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                this.f27949k.addAll(it.next().a());
            }
            this.f27949k.addAll(cVar.a());
            if (E(this.f27949k)) {
                if (t()) {
                    return this.f27949k;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(cVar);
                try {
                    return u(arrayList, i10 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final List<b> v(boolean z10) {
        List<b> list = null;
        if (this.f27950l.size() > 25) {
            this.f27950l.clear();
            return null;
        }
        this.f27949k.clear();
        if (z10) {
            Collections.reverse(this.f27950l);
        }
        try {
            list = u(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z10) {
            Collections.reverse(this.f27950l);
        }
        return list;
    }

    public k6.b x(z5.a aVar, k6.c cVar, boolean z10, boolean z11) throws NotFoundException {
        int[] j10 = j();
        j10[0] = 0;
        j10[1] = 0;
        j10[2] = 0;
        j10[3] = 0;
        j10[4] = 0;
        j10[5] = 0;
        j10[6] = 0;
        j10[7] = 0;
        if (z11) {
            q.g(aVar, cVar.b()[0], j10);
        } else {
            q.f(aVar, cVar.b()[1], j10);
            int i10 = 0;
            for (int length = j10.length - 1; i10 < length; length--) {
                int i11 = j10[i10];
                j10[i10] = j10[length];
                j10[length] = i11;
                i10++;
            }
        }
        float d10 = a6.a.d(j10) / 17.0f;
        float f10 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(d10 - f10) / f10 > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] n10 = n();
        int[] l10 = l();
        float[] o10 = o();
        float[] m10 = m();
        for (int i12 = 0; i12 < j10.length; i12++) {
            float f11 = (j10[i12] * 1.0f) / d10;
            int i13 = (int) (0.5f + f11);
            if (i13 <= 0) {
                if (f11 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i13 = 1;
            } else if (i13 > 8) {
                if (f11 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i13 = 8;
            }
            int i14 = i12 / 2;
            if ((i12 & 1) == 0) {
                n10[i14] = i13;
                o10[i14] = f11 - i13;
            } else {
                l10[i14] = i13;
                m10[i14] = f11 - i13;
            }
        }
        s(17);
        int c10 = (((cVar.c() * 4) + (z10 ? 0 : 2)) + (!z11 ? 1 : 0)) - 1;
        int i15 = 0;
        int i16 = 0;
        for (int length2 = n10.length - 1; length2 >= 0; length2--) {
            if (C(cVar, z10, z11)) {
                i15 += n10[length2] * f27941s[c10][length2 * 2];
            }
            i16 += n10[length2];
        }
        int i17 = 0;
        for (int length3 = l10.length - 1; length3 >= 0; length3--) {
            if (C(cVar, z10, z11)) {
                i17 += l10[length3] * f27941s[c10][(length3 * 2) + 1];
            }
        }
        int i18 = i15 + i17;
        if ((i16 & 1) != 0 || i16 > 13 || i16 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i19 = (13 - i16) / 2;
        int i20 = f27937o[i19];
        return new k6.b((f.b(n10, i20, true) * f27938p[i19]) + f.b(l10, 9 - i20, false) + f27939q[i19], i18);
    }

    public List<b> y(int i10, z5.a aVar) throws NotFoundException {
        while (true) {
            try {
                this.f27949k.add(H(aVar, this.f27949k, i10));
            } catch (NotFoundException e10) {
                if (this.f27949k.isEmpty()) {
                    throw e10;
                }
                if (t()) {
                    return this.f27949k;
                }
                boolean z10 = !this.f27950l.isEmpty();
                J(i10, false);
                if (z10) {
                    List<b> v10 = v(false);
                    if (v10 != null) {
                        return v10;
                    }
                    List<b> v11 = v(true);
                    if (v11 != null) {
                        return v11;
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public final void z(z5.a aVar, List<b> list, int i10) throws NotFoundException {
        int[] k10 = k();
        k10[0] = 0;
        k10[1] = 0;
        k10[2] = 0;
        k10[3] = 0;
        int l10 = aVar.l();
        if (i10 < 0) {
            i10 = list.isEmpty() ? 0 : list.get(list.size() - 1).b().b()[1];
        }
        boolean z10 = list.size() % 2 != 0;
        if (this.f27952n) {
            z10 = !z10;
        }
        boolean z11 = false;
        while (i10 < l10) {
            z11 = !aVar.h(i10);
            if (!z11) {
                break;
            } else {
                i10++;
            }
        }
        boolean z12 = z11;
        int i11 = 0;
        int i12 = i10;
        while (i10 < l10) {
            if (aVar.h(i10) ^ z12) {
                k10[i11] = k10[i11] + 1;
            } else {
                if (i11 == 3) {
                    if (z10) {
                        I(k10);
                    }
                    if (k6.a.q(k10)) {
                        int[] iArr = this.f27951m;
                        iArr[0] = i12;
                        iArr[1] = i10;
                        return;
                    }
                    if (z10) {
                        I(k10);
                    }
                    i12 += k10[0] + k10[1];
                    k10[0] = k10[2];
                    k10[1] = k10[3];
                    k10[2] = 0;
                    k10[3] = 0;
                    i11--;
                } else {
                    i11++;
                }
                k10[i11] = 1;
                z12 = !z12;
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
