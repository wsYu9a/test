package b.i.a.a.a;

import java.util.Random;

/* loaded from: classes4.dex */
public class g {
    /* JADX WARN: Removed duplicated region for block: B:5:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r1) {
        /*
            if (r1 == 0) goto L11
            java.lang.String r0 = "phone"
            java.lang.Object r1 = r1.getSystemService(r0)     // Catch: java.lang.Exception -> L11
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Exception -> L11
            if (r1 == 0) goto L11
            java.lang.String r1 = r1.getDeviceId()     // Catch: java.lang.Exception -> L11
            goto L12
        L11:
            r1 = 0
        L12:
            boolean r0 = b.i.a.a.a.i.b(r1)
            if (r0 == 0) goto L1c
            java.lang.String r1 = c()
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.a.a.g.a(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r1) {
        /*
            if (r1 == 0) goto L11
            java.lang.String r0 = "phone"
            java.lang.Object r1 = r1.getSystemService(r0)     // Catch: java.lang.Exception -> L11
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Exception -> L11
            if (r1 == 0) goto L11
            java.lang.String r1 = r1.getSubscriberId()     // Catch: java.lang.Exception -> L11
            goto L12
        L11:
            r1 = 0
        L12:
            boolean r0 = b.i.a.a.a.i.b(r1)
            if (r0 == 0) goto L1c
            java.lang.String r1 = c()
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.a.a.g.b(android.content.Context):java.lang.String");
    }

    public static final String c() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] a2 = e.a(currentTimeMillis);
        byte[] a3 = e.a(nanoTime);
        byte[] a4 = e.a(nextInt);
        byte[] a5 = e.a(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(a2, 0, bArr, 0, 4);
        System.arraycopy(a3, 0, bArr, 4, 4);
        System.arraycopy(a4, 0, bArr, 8, 4);
        System.arraycopy(a5, 0, bArr, 12, 4);
        return b.f(bArr, 2);
    }
}
