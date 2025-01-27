package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

/* loaded from: classes.dex */
class OpReorderer {

    /* renamed from: a */
    final Callback f3389a;

    interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i2, int i3, int i4, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    OpReorderer(Callback callback) {
        this.f3389a = callback;
    }

    private int a(List<AdapterHelper.UpdateOp> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f3133f != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<AdapterHelper.UpdateOp> list, int i2, AdapterHelper.UpdateOp updateOp, int i3, AdapterHelper.UpdateOp updateOp2) {
        int i4 = updateOp.f3136i;
        int i5 = updateOp2.f3134g;
        int i6 = i4 < i5 ? -1 : 0;
        int i7 = updateOp.f3134g;
        if (i7 < i5) {
            i6++;
        }
        if (i5 <= i7) {
            updateOp.f3134g = i7 + updateOp2.f3136i;
        }
        int i8 = updateOp2.f3134g;
        if (i8 <= i4) {
            updateOp.f3136i = i4 + updateOp2.f3136i;
        }
        updateOp2.f3134g = i8 + i6;
        list.set(i2, updateOp2);
        list.set(i3, updateOp);
    }

    private void d(List<AdapterHelper.UpdateOp> list, int i2, int i3) {
        AdapterHelper.UpdateOp updateOp = list.get(i2);
        AdapterHelper.UpdateOp updateOp2 = list.get(i3);
        int i4 = updateOp2.f3133f;
        if (i4 == 1) {
            c(list, i2, updateOp, i3, updateOp2);
        } else if (i4 == 2) {
            e(list, i2, updateOp, i3, updateOp2);
        } else {
            if (i4 != 4) {
                return;
            }
            f(list, i2, updateOp, i3, updateOp2);
        }
    }

    void b(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int a2 = a(list);
            if (a2 == -1) {
                return;
            } else {
                d(list, a2, a2 + 1);
            }
        }
    }

    void e(List<AdapterHelper.UpdateOp> list, int i2, AdapterHelper.UpdateOp updateOp, int i3, AdapterHelper.UpdateOp updateOp2) {
        boolean z;
        int i4 = updateOp.f3134g;
        int i5 = updateOp.f3136i;
        boolean z2 = false;
        if (i4 < i5) {
            if (updateOp2.f3134g == i4 && updateOp2.f3136i == i5 - i4) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (updateOp2.f3134g == i5 + 1 && updateOp2.f3136i == i4 - i5) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i6 = updateOp2.f3134g;
        if (i5 < i6) {
            updateOp2.f3134g = i6 - 1;
        } else {
            int i7 = updateOp2.f3136i;
            if (i5 < i6 + i7) {
                updateOp2.f3136i = i7 - 1;
                updateOp.f3133f = 2;
                updateOp.f3136i = 1;
                if (updateOp2.f3136i == 0) {
                    list.remove(i3);
                    this.f3389a.recycleUpdateOp(updateOp2);
                    return;
                }
                return;
            }
        }
        int i8 = updateOp.f3134g;
        int i9 = updateOp2.f3134g;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i8 <= i9) {
            updateOp2.f3134g = i9 + 1;
        } else {
            int i10 = updateOp2.f3136i;
            if (i8 < i9 + i10) {
                updateOp3 = this.f3389a.obtainUpdateOp(2, i8 + 1, (i9 + i10) - i8, null);
                updateOp2.f3136i = updateOp.f3134g - updateOp2.f3134g;
            }
        }
        if (z2) {
            list.set(i2, updateOp2);
            list.remove(i3);
            this.f3389a.recycleUpdateOp(updateOp);
            return;
        }
        if (z) {
            if (updateOp3 != null) {
                int i11 = updateOp.f3134g;
                if (i11 > updateOp3.f3134g) {
                    updateOp.f3134g = i11 - updateOp3.f3136i;
                }
                int i12 = updateOp.f3136i;
                if (i12 > updateOp3.f3134g) {
                    updateOp.f3136i = i12 - updateOp3.f3136i;
                }
            }
            int i13 = updateOp.f3134g;
            if (i13 > updateOp2.f3134g) {
                updateOp.f3134g = i13 - updateOp2.f3136i;
            }
            int i14 = updateOp.f3136i;
            if (i14 > updateOp2.f3134g) {
                updateOp.f3136i = i14 - updateOp2.f3136i;
            }
        } else {
            if (updateOp3 != null) {
                int i15 = updateOp.f3134g;
                if (i15 >= updateOp3.f3134g) {
                    updateOp.f3134g = i15 - updateOp3.f3136i;
                }
                int i16 = updateOp.f3136i;
                if (i16 >= updateOp3.f3134g) {
                    updateOp.f3136i = i16 - updateOp3.f3136i;
                }
            }
            int i17 = updateOp.f3134g;
            if (i17 >= updateOp2.f3134g) {
                updateOp.f3134g = i17 - updateOp2.f3136i;
            }
            int i18 = updateOp.f3136i;
            if (i18 >= updateOp2.f3134g) {
                updateOp.f3136i = i18 - updateOp2.f3136i;
            }
        }
        list.set(i2, updateOp2);
        if (updateOp.f3134g != updateOp.f3136i) {
            list.set(i3, updateOp);
        } else {
            list.remove(i3);
        }
        if (updateOp3 != null) {
            list.add(i2, updateOp3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void f(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.f3136i
            int r1 = r13.f3134g
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Ld
            int r1 = r1 - r4
            r13.f3134g = r1
            goto L20
        Ld:
            int r5 = r13.f3136i
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r4
            r13.f3136i = r5
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r8.f3389a
            int r1 = r11.f3134g
            java.lang.Object r5 = r13.f3135h
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.obtainUpdateOp(r2, r1, r4, r5)
            goto L21
        L20:
            r0 = r3
        L21:
            int r1 = r11.f3134g
            int r5 = r13.f3134g
            if (r1 > r5) goto L2b
            int r5 = r5 + r4
            r13.f3134g = r5
            goto L41
        L2b:
            int r6 = r13.f3136i
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r3 = r8.f3389a
            int r1 = r1 + r4
            java.lang.Object r4 = r13.f3135h
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r3 = r3.obtainUpdateOp(r2, r1, r5, r4)
            int r1 = r13.f3136i
            int r1 = r1 - r5
            r13.f3136i = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f3136i
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.OpReorderer$Callback r11 = r8.f3389a
            r11.recycleUpdateOp(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r3 == 0) goto L5e
            r9.add(r10, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.f(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}
