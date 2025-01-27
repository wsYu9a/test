package com.jd.ad.sdk.jad_hk;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class jad_fs extends AbstractList<jad_cp> implements RandomAccess {
    public final jad_cp[] jad_an;
    public final int[] jad_bo;

    public jad_fs(jad_cp[] jad_cpVarArr, int[] iArr) {
        this.jad_an = jad_cpVarArr;
        this.jad_bo = iArr;
    }

    public static void jad_an(long j10, jad_an jad_anVar, int i10, List<jad_cp> list, int i11, int i12, List<Integer> list2) {
        int i13;
        int i14;
        int i15;
        long j11;
        jad_an jad_anVar2;
        int i16;
        int i17;
        jad_an jad_anVar3;
        if (i11 >= i12) {
            throw new AssertionError();
        }
        for (int i18 = i11; i18 < i12; i18++) {
            if (list.get(i18).jad_cp() < i10) {
                throw new AssertionError();
            }
        }
        jad_cp jad_cpVar = list.get(i11);
        jad_cp jad_cpVar2 = list.get(i12 - 1);
        if (i10 == jad_cpVar.jad_cp()) {
            int i19 = i11 + 1;
            i14 = i19;
            i13 = list2.get(i11).intValue();
            jad_cpVar = list.get(i19);
        } else {
            i13 = -1;
            i14 = i11;
        }
        long j12 = 4;
        if (jad_cpVar.jad_an(i10) != jad_cpVar2.jad_an(i10)) {
            int i20 = 1;
            for (int i21 = i14 + 1; i21 < i12; i21++) {
                if (list.get(i21 - 1).jad_an(i10) != list.get(i21).jad_an(i10)) {
                    i20++;
                }
            }
            long j13 = j10 + ((int) (jad_anVar.jad_bo / 4)) + 2 + (i20 * 2);
            jad_anVar.jad_cp(i20);
            jad_anVar.jad_cp(i13);
            for (int i22 = i14; i22 < i12; i22++) {
                byte jad_an = list.get(i22).jad_an(i10);
                if (i22 == i14 || jad_an != list.get(i22 - 1).jad_an(i10)) {
                    jad_anVar.jad_cp(jad_an & 255);
                }
            }
            jad_anVar2 = new jad_an();
            int i23 = i14;
            while (i23 < i12) {
                byte jad_an2 = list.get(i23).jad_an(i10);
                int i24 = i23 + 1;
                int i25 = i24;
                while (true) {
                    if (i25 >= i12) {
                        i16 = i12;
                        break;
                    } else {
                        if (jad_an2 != list.get(i25).jad_an(i10)) {
                            i16 = i25;
                            break;
                        }
                        i25++;
                    }
                }
                if (i24 == i16 && i10 + 1 == list.get(i23).jad_cp()) {
                    jad_anVar.jad_cp(list2.get(i23).intValue());
                    i17 = i16;
                    jad_anVar3 = jad_anVar2;
                } else {
                    jad_anVar.jad_cp((int) ((((int) (jad_anVar2.jad_bo / j12)) + j13) * (-1)));
                    i17 = i16;
                    jad_anVar3 = jad_anVar2;
                    jad_an(j13, jad_anVar2, i10 + 1, list, i23, i16, list2);
                }
                jad_anVar2 = jad_anVar3;
                i23 = i17;
                j12 = 4;
            }
            j11 = jad_anVar2.jad_bo;
        } else {
            int min = Math.min(jad_cpVar.jad_cp(), jad_cpVar2.jad_cp());
            int i26 = 0;
            for (int i27 = i10; i27 < min && jad_cpVar.jad_an(i27) == jad_cpVar2.jad_an(i27); i27++) {
                i26++;
            }
            long j14 = 1 + j10 + ((int) (jad_anVar.jad_bo / 4)) + 2 + i26;
            jad_anVar.jad_cp(-i26);
            jad_anVar.jad_cp(i13);
            int i28 = i10;
            while (true) {
                i15 = i10 + i26;
                if (i28 >= i15) {
                    break;
                }
                jad_anVar.jad_cp(jad_cpVar.jad_an(i28) & 255);
                i28++;
            }
            if (i14 + 1 == i12) {
                if (i15 != list.get(i14).jad_cp()) {
                    throw new AssertionError();
                }
                jad_anVar.jad_cp(list2.get(i14).intValue());
                return;
            } else {
                jad_an jad_anVar4 = new jad_an();
                jad_anVar.jad_cp((int) ((((int) (jad_anVar4.jad_bo / 4)) + j14) * (-1)));
                jad_an(j14, jad_anVar4, i15, list, i14, i12, list2);
                j11 = jad_anVar4.jad_bo;
                jad_anVar2 = jad_anVar4;
            }
        }
        jad_anVar.jad_bo(jad_anVar2, j11);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i10) {
        return this.jad_an[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.jad_an.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c1, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.jd.ad.sdk.jad_hk.jad_fs jad_an(com.jd.ad.sdk.jad_hk.jad_cp... r15) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_hk.jad_fs.jad_an(com.jd.ad.sdk.jad_hk.jad_cp[]):com.jd.ad.sdk.jad_hk.jad_fs");
    }
}
