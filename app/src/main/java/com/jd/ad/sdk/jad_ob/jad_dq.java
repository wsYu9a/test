package com.jd.ad.sdk.jad_ob;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class jad_dq {
    public static final int[] jad_an = {2, 3, 4, 5, 6, 7, 8, 9};

    public static class jad_an {
        public static final jad_dq jad_an = new jad_dq();
    }

    public int jad_an(boolean z10, int i10) {
        if (i10 == 1) {
            return z10 ? 6 : 2;
        }
        if (i10 == 2) {
            return z10 ? 9 : 5;
        }
        if (i10 == 4) {
            return z10 ? 7 : 3;
        }
        if (i10 != 5) {
            return -1;
        }
        return z10 ? 8 : 4;
    }

    public final boolean jad_an(List<com.jd.ad.sdk.jad_pc.jad_hu> list) {
        if (list.size() == 0) {
            return false;
        }
        Iterator<com.jd.ad.sdk.jad_pc.jad_hu> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().jad_an == 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        r0 = r4.jad_bo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
    
        r7 = jad_an(r7, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
    
        if (r7 == null) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        if (r7.size() > 0) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return r7.contains(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0042, code lost:
    
        r1 = new java.util.ArrayList();
        r1.addAll(java.util.Arrays.asList(r0.split(",")));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean jad_an(int r7, java.lang.String r8) {
        /*
            r6 = this;
            com.jd.ad.sdk.jad_pc.jad_cp r0 = com.jd.ad.sdk.jad_re.jad_an.jad_cp()
            r1 = 0
            if (r0 != 0) goto L9
            r0 = r1
            goto Lb
        L9:
            java.util.List<com.jd.ad.sdk.jad_pc.jad_hu> r0 = r0.jad_hu
        Lb:
            r2 = 0
            if (r0 == 0) goto L70
            int r3 = r0.size()
            if (r3 != 0) goto L15
            goto L70
        L15:
            boolean r3 = r6.jad_an(r0)     // Catch: java.lang.Exception -> L66
            if (r3 != 0) goto L6c
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L66
        L1f:
            boolean r4 = r0.hasNext()     // Catch: java.lang.Exception -> L66
            if (r4 == 0) goto L6c
            java.lang.Object r4 = r0.next()     // Catch: java.lang.Exception -> L66
            com.jd.ad.sdk.jad_pc.jad_hu r4 = (com.jd.ad.sdk.jad_pc.jad_hu) r4     // Catch: java.lang.Exception -> L66
            int r5 = r4.jad_an     // Catch: java.lang.Exception -> L66
            if (r5 != r7) goto L1f
            r0 = 0
        L30:
            int[] r3 = com.jd.ad.sdk.jad_ob.jad_dq.jad_an     // Catch: java.lang.Exception -> L66
            int r5 = r3.length     // Catch: java.lang.Exception -> L66
            if (r0 >= r5) goto L6b
            r3 = r3[r0]     // Catch: java.lang.Exception -> L66
            if (r7 != r3) goto L68
            java.lang.String r0 = r4.jad_bo     // Catch: java.lang.Exception -> L66
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L66
            if (r3 == 0) goto L42
            goto L54
        L42:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> L66
            r1.<init>()     // Catch: java.lang.Exception -> L66
            java.lang.String r3 = ","
            java.lang.String[] r0 = r0.split(r3)     // Catch: java.lang.Exception -> L66
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch: java.lang.Exception -> L66
            r1.addAll(r0)     // Catch: java.lang.Exception -> L66
        L54:
            java.util.List r7 = r6.jad_an(r7, r1)     // Catch: java.lang.Exception -> L66
            if (r7 == 0) goto L6b
            int r0 = r7.size()     // Catch: java.lang.Exception -> L66
            if (r0 > 0) goto L61
            goto L6b
        L61:
            boolean r3 = r7.contains(r8)     // Catch: java.lang.Exception -> L66
            goto L6c
        L66:
            r7 = move-exception
            goto L6d
        L68:
            int r0 = r0 + 1
            goto L30
        L6b:
            r3 = 1
        L6c:
            return r3
        L6d:
            r7.printStackTrace()
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ob.jad_dq.jad_an(int, java.lang.String):boolean");
    }

    public List<String> jad_an(int i10, List<String> list) {
        int i11;
        ArrayList arrayList;
        List<com.jd.ad.sdk.jad_pc.jad_er> list2;
        if (list != null && list.size() > 0) {
            switch (i10) {
                case 2:
                case 6:
                    i11 = 1;
                    break;
                case 3:
                case 7:
                    i11 = 4;
                    break;
                case 4:
                case 8:
                    i11 = 5;
                    break;
                case 5:
                case 9:
                    i11 = 2;
                    break;
                default:
                    i11 = -1;
                    break;
            }
            com.jd.ad.sdk.jad_pc.jad_cp jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
            if (jad_cp == null || (list2 = jad_cp.jad_jt) == null || list2.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (com.jd.ad.sdk.jad_pc.jad_er jad_erVar : list2) {
                    if (jad_erVar != null && i11 == jad_erVar.jad_bo) {
                        arrayList.add(jad_erVar.jad_an);
                    }
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (String str : list) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (str.equals((String) it.next())) {
                            arrayList2.add(str);
                        }
                    }
                }
                return arrayList2;
            }
        }
        return null;
    }
}
