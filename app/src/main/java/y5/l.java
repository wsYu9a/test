package y5;

import com.alibaba.fastjson.parser.JSONLexer;
import com.google.zxing.BarcodeFormat;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public final class l extends t {
    public static String q(int i10, String str) {
        if (str.charAt(i10) != '(') {
            return null;
        }
        String substring = str.substring(i10 + 1);
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < substring.length(); i11++) {
            char charAt = substring.charAt(i11);
            if (charAt == ')') {
                return sb2.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    public static String r(int i10, String str) {
        StringBuilder sb2 = new StringBuilder();
        String substring = str.substring(i10);
        for (int i11 = 0; i11 < substring.length(); i11++) {
            char charAt = substring.charAt(i11);
            if (charAt != '(') {
                sb2.append(charAt);
            } else {
                if (q(i11, substring) != null) {
                    break;
                }
                sb2.append('(');
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // y5.t
    /* renamed from: s */
    public k k(t5.k kVar) {
        if (kVar.b() != BarcodeFormat.RSS_EXPANDED) {
            return null;
        }
        String c10 = t.c(kVar);
        HashMap hashMap = new HashMap();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        int i10 = 0;
        while (i10 < c10.length()) {
            String q10 = q(i10, c10);
            if (q10 == null) {
                return null;
            }
            int length = i10 + q10.length() + 2;
            String r10 = r(length, c10);
            i10 = length + r10.length();
            char c11 = 65535;
            switch (q10.hashCode()) {
                case 1536:
                    if (q10.equals(com.sigmob.sdk.archives.tar.e.S)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 1537:
                    if (q10.equals("01")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1567:
                    if (q10.equals("10")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1568:
                    if (q10.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 1570:
                    if (q10.equals("13")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 1572:
                    if (q10.equals(Constants.VIA_REPORT_TYPE_WPA_STATE)) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 1574:
                    if (q10.equals(Constants.VIA_REPORT_TYPE_START_GROUP)) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 1567966:
                    if (q10.equals("3100")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 1567967:
                    if (q10.equals("3101")) {
                        c11 = '\b';
                        break;
                    }
                    break;
                case 1567968:
                    if (q10.equals("3102")) {
                        c11 = '\t';
                        break;
                    }
                    break;
                case 1567969:
                    if (q10.equals("3103")) {
                        c11 = '\n';
                        break;
                    }
                    break;
                case 1567970:
                    if (q10.equals("3104")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 1567971:
                    if (q10.equals("3105")) {
                        c11 = '\f';
                        break;
                    }
                    break;
                case 1567972:
                    if (q10.equals("3106")) {
                        c11 = '\r';
                        break;
                    }
                    break;
                case 1567973:
                    if (q10.equals("3107")) {
                        c11 = 14;
                        break;
                    }
                    break;
                case 1567974:
                    if (q10.equals("3108")) {
                        c11 = 15;
                        break;
                    }
                    break;
                case 1567975:
                    if (q10.equals("3109")) {
                        c11 = 16;
                        break;
                    }
                    break;
                case 1568927:
                    if (q10.equals("3200")) {
                        c11 = 17;
                        break;
                    }
                    break;
                case 1568928:
                    if (q10.equals("3201")) {
                        c11 = 18;
                        break;
                    }
                    break;
                case 1568929:
                    if (q10.equals("3202")) {
                        c11 = 19;
                        break;
                    }
                    break;
                case 1568930:
                    if (q10.equals("3203")) {
                        c11 = 20;
                        break;
                    }
                    break;
                case 1568931:
                    if (q10.equals("3204")) {
                        c11 = 21;
                        break;
                    }
                    break;
                case 1568932:
                    if (q10.equals("3205")) {
                        c11 = 22;
                        break;
                    }
                    break;
                case 1568933:
                    if (q10.equals("3206")) {
                        c11 = 23;
                        break;
                    }
                    break;
                case 1568934:
                    if (q10.equals("3207")) {
                        c11 = 24;
                        break;
                    }
                    break;
                case 1568935:
                    if (q10.equals("3208")) {
                        c11 = 25;
                        break;
                    }
                    break;
                case 1568936:
                    if (q10.equals("3209")) {
                        c11 = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 1575716:
                    if (q10.equals("3920")) {
                        c11 = 27;
                        break;
                    }
                    break;
                case 1575717:
                    if (q10.equals("3921")) {
                        c11 = g6.b.f26170n;
                        break;
                    }
                    break;
                case 1575718:
                    if (q10.equals("3922")) {
                        c11 = g6.b.f26171o;
                        break;
                    }
                    break;
                case 1575719:
                    if (q10.equals("3923")) {
                        c11 = g6.b.f26172p;
                        break;
                    }
                    break;
                case 1575747:
                    if (q10.equals("3930")) {
                        c11 = r5.c.f30310b;
                        break;
                    }
                    break;
                case 1575748:
                    if (q10.equals("3931")) {
                        c11 = b5.a.O;
                        break;
                    }
                    break;
                case 1575749:
                    if (q10.equals("3932")) {
                        c11 = '!';
                        break;
                    }
                    break;
                case 1575750:
                    if (q10.equals("3933")) {
                        c11 = Typography.quote;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    str2 = r10;
                    continue;
                case 1:
                    str = r10;
                    continue;
                case 2:
                    str3 = r10;
                    continue;
                case 3:
                    str4 = r10;
                    continue;
                case 4:
                    str5 = r10;
                    continue;
                case 5:
                    str6 = r10;
                    continue;
                case 6:
                    str7 = r10;
                    continue;
                case 7:
                case '\b':
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                case 15:
                case 16:
                    str10 = q10.substring(3);
                    str9 = k.f33026q;
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                    str10 = q10.substring(3);
                    str9 = k.f33027r;
                    break;
                case 27:
                case 28:
                case 29:
                case 30:
                    str12 = q10.substring(3);
                    str11 = r10;
                    continue;
                case 31:
                case ' ':
                case '!':
                case '\"':
                    if (r10.length() < 4) {
                        return null;
                    }
                    str11 = r10.substring(3);
                    str13 = r10.substring(0, 3);
                    str12 = q10.substring(3);
                    continue;
                default:
                    hashMap.put(q10, r10);
                    continue;
            }
            str8 = r10;
        }
        return new k(c10, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, hashMap);
    }
}
