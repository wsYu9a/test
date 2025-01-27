package com.bytedance.sdk.openadsdk.api.plugin.j;

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

/* loaded from: classes.dex */
public final class j implements HostnameVerifier {

    /* renamed from: j */
    public static final j f6430j = new j();
    private static final Pattern zx = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private j() {
    }

    private boolean i(String str, X509Certificate x509Certificate) {
        String j2;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> j3 = j(x509Certificate, 2);
        int size = j3.size();
        int i2 = 0;
        boolean z = false;
        while (i2 < size) {
            if (j(lowerCase, j3.get(i2))) {
                return true;
            }
            i2++;
            z = true;
        }
        if (z || (j2 = new zx(x509Certificate.getSubjectX500Principal()).j("cn")) == null) {
            return false;
        }
        return j(lowerCase, j2);
    }

    private boolean j(String str, X509Certificate x509Certificate) {
        return j(str) ? zx(str, x509Certificate) : i(str, x509Certificate);
    }

    private boolean zx(String str, X509Certificate x509Certificate) {
        List<String> j2 = j(x509Certificate, 7);
        int size = j2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equalsIgnoreCase(j2.get(i2))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return j(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private static boolean j(String str) {
        return zx.matcher(str).matches();
    }

    private static List<String> j(X509Certificate x509Certificate, int i2) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i2 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private boolean j(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
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
