package com.google.zxing.oned.b0.g;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.k;
import com.google.zxing.l;
import com.google.zxing.oned.b0.f;
import com.google.zxing.oned.q;
import com.google.zxing.oned.rss.expanded.decoders.j;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.dm.Downloads;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class d extends com.google.zxing.oned.b0.a {
    private static final int p = 0;
    private static final int q = 1;
    private static final int r = 2;
    private static final int s = 3;
    private static final int t = 4;
    private static final int u = 5;
    private static final int w = 11;
    private boolean A;
    private final List<b> x = new ArrayList(11);
    private final List<c> y = new ArrayList();
    private final int[] z = new int[2];
    private static final int[] k = {7, 5, 4, 3, 1};
    private static final int[] l = {4, 20, 52, 104, 204};
    private static final int[] m = {0, 348, 1388, 2948, 3988};
    private static final int[][] n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, TinkerReport.KEY_APPLIED_VERSION_CHECK, 118, org.mozilla.universalchardet.prober.n.a.q, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{Downloads.Impl.STATUS_PAUSED_BY_APP, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, org.mozilla.universalchardet.prober.n.a.p, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE, 28, 84, 41, 123, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 52, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL}, new int[]{46, 138, 203, 187, 139, 206, 196, TTAdConstant.IMAGE_MODE_LIVE}, new int[]{76, 17, 51, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND, 37, 111, 122, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, org.mozilla.universalchardet.prober.n.c.m, 179, 115}, new int[]{134, 191, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META, 31, 93, 68, 204, Downloads.Impl.STATUS_PENDING}, new int[]{148, 22, 66, Downloads.Impl.STATUS_INSUFFICIENT_SPACE_ERROR, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, Downloads.Impl.STATUS_RUNNING, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND, 40}, new int[]{120, 149, 25, 75, 14, 42, org.mozilla.universalchardet.prober.o.a.n, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, TTAdConstant.IMAGE_MODE_SPLASH, TinkerReport.KEY_APPLIED_DEX_EXTRACT, 124}, new int[]{161, 61, TinkerReport.KEY_APPLIED_LIB_EXTRACT, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, Downloads.Impl.STATUS_WAITING_TO_RETRY, 160, 58, 174, 100, 89}};
    private static final int[][] v = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    private static int A(com.google.zxing.common.a aVar, int i2) {
        return aVar.h(i2) ? aVar.j(aVar.k(i2)) : aVar.k(aVar.j(i2));
    }

    private static boolean C(com.google.zxing.oned.b0.c cVar, boolean z, boolean z2) {
        return (cVar.c() == 0 && z && z2) ? false : true;
    }

    private static boolean D(Iterable<b> iterable, Iterable<c> iterable2) {
        boolean z;
        boolean z2;
        Iterator<c> it = iterable2.iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            c next = it.next();
            Iterator<b> it2 = iterable.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                b next2 = it2.next();
                Iterator<b> it3 = next.a().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (next2.equals(it3.next())) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    break;
                }
            }
        } while (!z);
        return true;
    }

    private static boolean E(List<b> list) {
        boolean z;
        for (int[] iArr : v) {
            if (list.size() <= iArr.length) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        z = true;
                        break;
                    }
                    if (list.get(i2).b().c() != iArr[i2]) {
                        z = false;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private com.google.zxing.oned.b0.c F(com.google.zxing.common.a aVar, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        if (z) {
            int i6 = this.z[0] - 1;
            while (i6 >= 0 && !aVar.h(i6)) {
                i6--;
            }
            int i7 = i6 + 1;
            int[] iArr = this.z;
            i5 = iArr[0] - i7;
            i3 = iArr[1];
            i4 = i7;
        } else {
            int[] iArr2 = this.z;
            int i8 = iArr2[0];
            int k2 = aVar.k(iArr2[1] + 1);
            i3 = k2;
            i4 = i8;
            i5 = k2 - this.z[1];
        }
        int[] k3 = k();
        System.arraycopy(k3, 0, k3, 1, k3.length - 1);
        k3[0] = i5;
        try {
            return new com.google.zxing.oned.b0.c(com.google.zxing.oned.b0.a.r(k3, n), new int[]{i4, i3}, i4, i3, i2);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private static void G(List<b> list, List<c> list2) {
        boolean z;
        Iterator<c> it = list2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a().size() != list.size()) {
                Iterator<b> it2 = next.a().iterator();
                while (true) {
                    z = false;
                    boolean z2 = true;
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = list.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z2 = false;
                            break;
                        } else if (next2.equals(it3.next())) {
                            break;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    private static void I(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    private void J(int i2, boolean z) {
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        while (true) {
            if (i3 >= this.y.size()) {
                break;
            }
            c cVar = this.y.get(i3);
            if (cVar.b() > i2) {
                z2 = cVar.c(this.x);
                break;
            } else {
                z3 = cVar.c(this.x);
                i3++;
            }
        }
        if (z2 || z3 || D(this.x, this.y)) {
            return;
        }
        this.y.add(i3, new c(this.x, i2, z));
        G(this.x, this.y);
    }

    private void s(int i2) throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int d2 = com.google.zxing.common.l.a.d(n());
        int d3 = com.google.zxing.common.l.a.d(l());
        boolean z5 = true;
        if (d2 > 13) {
            z = false;
            z2 = true;
        } else {
            z = d2 < 4;
            z2 = false;
        }
        if (d3 > 13) {
            z3 = false;
            z4 = true;
        } else {
            z3 = d3 < 4;
            z4 = false;
        }
        int i3 = (d2 + d3) - i2;
        boolean z6 = (d2 & 1) == 1;
        boolean z7 = (d3 & 1) == 0;
        if (i3 == 1) {
            if (z6) {
                if (z7) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z5 = z;
                z2 = true;
            } else {
                if (!z7) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z5 = z;
                z4 = true;
            }
        } else if (i3 == -1) {
            if (z6) {
                if (z7) {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else {
                if (!z7) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z5 = z;
                z3 = true;
            }
        } else {
            if (i3 != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (z6) {
                if (!z7) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (d2 >= d3) {
                    z5 = z;
                    z3 = true;
                    z2 = true;
                }
                z4 = true;
            } else {
                if (z7) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z5 = z;
            }
        }
        if (z5) {
            if (z2) {
                throw NotFoundException.getNotFoundInstance();
            }
            com.google.zxing.oned.b0.a.p(n(), o());
        }
        if (z2) {
            com.google.zxing.oned.b0.a.i(n(), o());
        }
        if (z3) {
            if (z4) {
                throw NotFoundException.getNotFoundInstance();
            }
            com.google.zxing.oned.b0.a.p(l(), o());
        }
        if (z4) {
            com.google.zxing.oned.b0.a.i(l(), m());
        }
    }

    private boolean t() {
        b bVar = this.x.get(0);
        com.google.zxing.oned.b0.b c2 = bVar.c();
        com.google.zxing.oned.b0.b d2 = bVar.d();
        if (d2 == null) {
            return false;
        }
        int a2 = d2.a();
        int i2 = 2;
        for (int i3 = 1; i3 < this.x.size(); i3++) {
            b bVar2 = this.x.get(i3);
            a2 += bVar2.c().a();
            i2++;
            com.google.zxing.oned.b0.b d3 = bVar2.d();
            if (d3 != null) {
                a2 += d3.a();
                i2++;
            }
        }
        return ((i2 + (-4)) * AdEventType.VIDEO_LOADING) + (a2 % AdEventType.VIDEO_LOADING) == c2.b();
    }

    private List<b> u(List<c> list, int i2) throws NotFoundException {
        while (i2 < this.y.size()) {
            c cVar = this.y.get(i2);
            this.x.clear();
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                this.x.addAll(it.next().a());
            }
            this.x.addAll(cVar.a());
            if (E(this.x)) {
                if (t()) {
                    return this.x;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(cVar);
                try {
                    return u(arrayList, i2 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private List<b> v(boolean z) {
        List<b> list = null;
        if (this.y.size() > 25) {
            this.y.clear();
            return null;
        }
        this.x.clear();
        if (z) {
            Collections.reverse(this.y);
        }
        try {
            list = u(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z) {
            Collections.reverse(this.y);
        }
        return list;
    }

    static k w(List<b> list) throws NotFoundException, FormatException {
        String d2 = j.a(a.a(list)).d();
        l[] a2 = list.get(0).b().a();
        l[] a3 = list.get(list.size() - 1).b().a();
        return new k(d2, null, new l[]{a2[0], a2[1], a3[0], a3[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private void z(com.google.zxing.common.a aVar, List<b> list, int i2) throws NotFoundException {
        int[] k2 = k();
        k2[0] = 0;
        k2[1] = 0;
        k2[2] = 0;
        k2[3] = 0;
        int l2 = aVar.l();
        if (i2 < 0) {
            i2 = list.isEmpty() ? 0 : list.get(list.size() - 1).b().b()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.A) {
            z = !z;
        }
        boolean z2 = false;
        while (i2 < l2) {
            z2 = !aVar.h(i2);
            if (!z2) {
                break;
            } else {
                i2++;
            }
        }
        boolean z3 = z2;
        int i3 = 0;
        int i4 = i2;
        while (i2 < l2) {
            if (aVar.h(i2) ^ z3) {
                k2[i3] = k2[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (z) {
                        I(k2);
                    }
                    if (com.google.zxing.oned.b0.a.q(k2)) {
                        int[] iArr = this.z;
                        iArr[0] = i4;
                        iArr[1] = i2;
                        return;
                    }
                    if (z) {
                        I(k2);
                    }
                    i4 += k2[0] + k2[1];
                    k2[0] = k2[2];
                    k2[1] = k2[3];
                    k2[2] = 0;
                    k2[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                k2[i3] = 1;
                z3 = !z3;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    List<c> B() {
        return this.y;
    }

    b H(com.google.zxing.common.a aVar, List<b> list, int i2) throws NotFoundException {
        com.google.zxing.oned.b0.c F;
        com.google.zxing.oned.b0.b bVar;
        boolean z = list.size() % 2 == 0;
        if (this.A) {
            z = !z;
        }
        int i3 = -1;
        boolean z2 = true;
        do {
            z(aVar, list, i3);
            F = F(aVar, i2, z);
            if (F == null) {
                i3 = A(aVar, this.z[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        com.google.zxing.oned.b0.b x = x(aVar, F, z, true);
        if (!list.isEmpty() && list.get(list.size() - 1).g()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            bVar = x(aVar, F, z, false);
        } catch (NotFoundException unused) {
            bVar = null;
        }
        return new b(x, bVar, F, true);
    }

    @Override // com.google.zxing.oned.q
    public k b(int i2, com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.x.clear();
        this.A = false;
        try {
            return w(y(i2, aVar));
        } catch (NotFoundException unused) {
            this.x.clear();
            this.A = true;
            return w(y(i2, aVar));
        }
    }

    @Override // com.google.zxing.oned.q, com.google.zxing.j
    public void reset() {
        this.x.clear();
        this.y.clear();
    }

    com.google.zxing.oned.b0.b x(com.google.zxing.common.a aVar, com.google.zxing.oned.b0.c cVar, boolean z, boolean z2) throws NotFoundException {
        int[] j2 = j();
        j2[0] = 0;
        j2[1] = 0;
        j2[2] = 0;
        j2[3] = 0;
        j2[4] = 0;
        j2[5] = 0;
        j2[6] = 0;
        j2[7] = 0;
        if (z2) {
            q.g(aVar, cVar.b()[0], j2);
        } else {
            q.f(aVar, cVar.b()[1], j2);
            int i2 = 0;
            for (int length = j2.length - 1; i2 < length; length--) {
                int i3 = j2[i2];
                j2[i2] = j2[length];
                j2[length] = i3;
                i2++;
            }
        }
        float d2 = com.google.zxing.common.l.a.d(j2) / 17.0f;
        float f2 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(d2 - f2) / f2 > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] n2 = n();
        int[] l2 = l();
        float[] o2 = o();
        float[] m2 = m();
        for (int i4 = 0; i4 < j2.length; i4++) {
            float f3 = (j2[i4] * 1.0f) / d2;
            int i5 = (int) (0.5f + f3);
            if (i5 <= 0) {
                if (f3 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i5 = 1;
            } else if (i5 > 8) {
                if (f3 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                n2[i6] = i5;
                o2[i6] = f3 - i5;
            } else {
                l2[i6] = i5;
                m2[i6] = f3 - i5;
            }
        }
        s(17);
        int c2 = (((cVar.c() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i7 = 0;
        int i8 = 0;
        for (int length2 = n2.length - 1; length2 >= 0; length2--) {
            if (C(cVar, z, z2)) {
                i7 += n2[length2] * o[c2][length2 * 2];
            }
            i8 += n2[length2];
        }
        int i9 = 0;
        for (int length3 = l2.length - 1; length3 >= 0; length3--) {
            if (C(cVar, z, z2)) {
                i9 += l2[length3] * o[c2][(length3 * 2) + 1];
            }
        }
        int i10 = i7 + i9;
        if ((i8 & 1) != 0 || i8 > 13 || i8 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i11 = (13 - i8) / 2;
        int i12 = k[i11];
        return new com.google.zxing.oned.b0.b((f.b(n2, i12, true) * l[i11]) + f.b(l2, 9 - i12, false) + m[i11], i10);
    }

    List<b> y(int i2, com.google.zxing.common.a aVar) throws NotFoundException {
        while (true) {
            try {
                this.x.add(H(aVar, this.x, i2));
            } catch (NotFoundException e2) {
                if (this.x.isEmpty()) {
                    throw e2;
                }
                if (t()) {
                    return this.x;
                }
                boolean z = !this.y.isEmpty();
                J(i2, false);
                if (z) {
                    List<b> v2 = v(false);
                    if (v2 != null) {
                        return v2;
                    }
                    List<b> v3 = v(true);
                    if (v3 != null) {
                        return v3;
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }
}
