package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes4.dex */
public class ca {

    /* renamed from: a */
    private static final String f23719a = "HttpClient";

    /* renamed from: f */
    private static HostnameVerifier f23720f;

    /* renamed from: b */
    private String f23721b;

    /* renamed from: c */
    private a f23722c;

    /* renamed from: d */
    private Map<String, String> f23723d;

    /* renamed from: e */
    private cb f23724e;

    /* renamed from: com.umeng.analytics.pro.ca$1 */
    public static class AnonymousClass1 implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return !TextUtils.isEmpty(str) && by.f23696a.equalsIgnoreCase(str);
        }
    }

    public enum a {
        POST,
        GET
    }

    public ca(String str, a aVar, Map<String, String> map, cb cbVar) {
        this.f23721b = str;
        this.f23722c = aVar;
        this.f23723d = map;
        this.f23724e = cbVar;
    }

    private static HostnameVerifier a() {
        if (f23720f == null) {
            f23720f = new HostnameVerifier() { // from class: com.umeng.analytics.pro.ca.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return !TextUtils.isEmpty(str) && by.f23696a.equalsIgnoreCase(str);
                }
            };
        }
        return f23720f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0101, code lost:
    
        if (r1 == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fe, code lost:
    
        if (r1 == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00fb, code lost:
    
        if (r1 == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f8, code lost:
    
        if (r1 == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f5, code lost:
    
        if (r1 == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00f2, code lost:
    
        if (r1 == null) goto L214;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(int r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.ca.a(int, java.lang.String):java.lang.String");
    }
}
