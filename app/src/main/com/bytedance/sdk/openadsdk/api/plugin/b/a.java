package com.bytedance.sdk.openadsdk.api.plugin.b;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import m5.h;

/* loaded from: classes2.dex */
public final class a implements HostnameVerifier {

    /* renamed from: a */
    public static final a f8043a = new a();

    /* renamed from: b */
    private static final Pattern f8044b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private a() {
    }

    private boolean a(String str, X509Certificate x509Certificate) {
        return a(str) ? b(str, x509Certificate) : c(str, x509Certificate);
    }

    private boolean b(String str, X509Certificate x509Certificate) {
        List<String> a10 = a(x509Certificate, 7);
        int size = a10.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equalsIgnoreCase(a10.get(i10))) {
                return true;
            }
        }
        return false;
    }

    private boolean c(String str, X509Certificate x509Certificate) {
        String a10;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> a11 = a(x509Certificate, 2);
        int size = a11.size();
        int i10 = 0;
        boolean z10 = false;
        while (i10 < size) {
            if (a(lowerCase, a11.get(i10))) {
                return true;
            }
            i10++;
            z10 = true;
        }
        if (z10 || (a10 = new b(x509Certificate.getSubjectX500Principal()).a("cn")) == null) {
            return false;
        }
        return a(lowerCase, a10);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private static boolean a(String str) {
        return f8044b.matcher(str).matches();
    }

    private static List<String> a(X509Certificate x509Certificate, int i10) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i10 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private boolean a(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(p1.b.f29697h) && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(p1.b.f29697h) && !str2.endsWith("..")) {
            if (!str.endsWith(p1.b.f29697h)) {
                str = str + '.';
            }
            if (!str2.endsWith(p1.b.f29697h)) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains(h.f28447r)) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
