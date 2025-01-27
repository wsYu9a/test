package com.cdo.oaps.ad;

import com.baidu.mobads.sdk.internal.bu;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class h {
    private static MessageDigest a() {
        return a(bu.f5659a);
    }

    static MessageDigest a(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2.getMessage());
        }
    }

    public static byte[] a(byte[] bArr) {
        return a().digest(bArr);
    }

    public static String b(byte[] bArr) {
        return new String(g.a(a(bArr)));
    }

    private static MessageDigest b() {
        return a("SHA");
    }

    public static byte[] b(String str) {
        return a(str.getBytes());
    }

    public static String c(String str) {
        return new String(g.a(b(str)));
    }

    public static byte[] c(byte[] bArr) {
        return b().digest(bArr);
    }

    public static String d(byte[] bArr) {
        return new String(g.a(c(bArr)));
    }

    public static byte[] d(String str) {
        return c(str.getBytes());
    }

    public static String e(String str) {
        return new String(g.a(d(str)));
    }
}
