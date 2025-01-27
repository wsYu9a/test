package com.opos.cmn.i;

import android.content.pm.Signature;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    private static final char[] f17434a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final String a(String str) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("sha256");
        messageDigest.update(str.getBytes());
        return a(messageDigest.digest());
    }

    public static final String a(String str, Signature signature) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(signature.toByteArray());
        return a(messageDigest.digest());
    }

    public static final String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = f17434a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:13:0x002e
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static final android.content.pm.Signature[] a(android.content.Context r3) {
        /*
            android.content.pm.PackageManager r0 = r3.getPackageManager()
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L2e
            r2 = 28
            if (r1 < r2) goto L1f
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Throwable -> L2e
            r1 = 134217856(0x8000080, float:3.8519187E-34)
            android.content.pm.PackageInfo r3 = r0.getPackageInfo(r3, r1)     // Catch: java.lang.Throwable -> L2e
            if (r3 != 0) goto L18
            goto L2e
        L18:
            android.content.pm.SigningInfo r3 = r3.signingInfo     // Catch: java.lang.Throwable -> L2e
            android.content.pm.Signature[] r3 = r3.getApkContentsSigners()     // Catch: java.lang.Throwable -> L2e
            goto L2f
        L1f:
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Throwable -> L2e
            r1 = 192(0xc0, float:2.69E-43)
            android.content.pm.PackageInfo r3 = r0.getPackageInfo(r3, r1)     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L2e
            android.content.pm.Signature[] r3 = r3.signatures     // Catch: java.lang.Throwable -> L2e
            goto L2f
        L2e:
            r3 = 0
        L2f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.i.k.a(android.content.Context):android.content.pm.Signature[]");
    }
}
