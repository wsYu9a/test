package y5;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.BarcodeFormat;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class h0 extends t {

    /* renamed from: f */
    public static final Pattern f33018f = Pattern.compile("[IOQ]");

    /* renamed from: g */
    public static final Pattern f33019g = Pattern.compile("[A-Z0-9]{17}");

    public static char q(int i10) {
        if (i10 < 10) {
            return (char) (i10 + 48);
        }
        if (i10 == 10) {
            return 'X';
        }
        throw new IllegalArgumentException();
    }

    public static boolean r(CharSequence charSequence) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            int i12 = i10 + 1;
            i11 += w(i12) * v(charSequence.charAt(i10));
            i10 = i12;
        }
        return charSequence.charAt(8) == q(i11 % 11);
    }

    public static String s(CharSequence charSequence) {
        char charAt = charSequence.charAt(0);
        char charAt2 = charSequence.charAt(1);
        if (charAt == '9') {
            if (charAt2 >= 'A' && charAt2 <= 'E') {
                return "BR";
            }
            if (charAt2 < '3' || charAt2 > '9') {
                return null;
            }
            return "BR";
        }
        if (charAt == 'S') {
            if (charAt2 >= 'A' && charAt2 <= 'M') {
                return "UK";
            }
            if (charAt2 < 'N' || charAt2 > 'T') {
                return null;
            }
            return "DE";
        }
        if (charAt == 'Z') {
            if (charAt2 < 'A' || charAt2 > 'R') {
                return null;
            }
            return "IT";
        }
        switch (charAt) {
            case '1':
            case '4':
            case '5':
                return "US";
            case '2':
                return "CA";
            case '3':
                if (charAt2 < 'A' || charAt2 > 'W') {
                    return null;
                }
                return "MX";
            default:
                switch (charAt) {
                    case 'J':
                        if (charAt2 < 'A' || charAt2 > 'T') {
                            return null;
                        }
                        return "JP";
                    case 'K':
                        if (charAt2 < 'L' || charAt2 > 'R') {
                            return null;
                        }
                        return "KO";
                    case 'L':
                        return "CN";
                    case 'M':
                        if (charAt2 < 'A' || charAt2 > 'E') {
                            return null;
                        }
                        return "IN";
                    default:
                        switch (charAt) {
                            case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_BACKUP_URLS /* 86 */:
                                if (charAt2 >= 'F' && charAt2 <= 'R') {
                                    return "FR";
                                }
                                if (charAt2 < 'S' || charAt2 > 'W') {
                                    return null;
                                }
                                return "ES";
                            case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_NOTIFICATION_JUMP_URL /* 87 */:
                                return "DE";
                            case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_NAME /* 88 */:
                                if (charAt2 == '0') {
                                    return "RU";
                                }
                                if (charAt2 < '3' || charAt2 > '9') {
                                    return null;
                                }
                                return "RU";
                            default:
                                return null;
                        }
                }
        }
    }

    public static int t(char c10) {
        if (c10 >= 'E' && c10 <= 'H') {
            return c10 + 1915;
        }
        if (c10 >= 'J' && c10 <= 'N') {
            return c10 + 1914;
        }
        if (c10 == 'P') {
            return 1993;
        }
        if (c10 >= 'R' && c10 <= 'T') {
            return c10 + 1912;
        }
        if (c10 >= 'V' && c10 <= 'Y') {
            return c10 + 1911;
        }
        if (c10 >= '1' && c10 <= '9') {
            return c10 + 1952;
        }
        if (c10 < 'A' || c10 > 'D') {
            throw new IllegalArgumentException();
        }
        return c10 + 1945;
    }

    public static int v(char c10) {
        if (c10 >= 'A' && c10 <= 'I') {
            return c10 - '@';
        }
        if (c10 >= 'J' && c10 <= 'R') {
            return c10 - 'I';
        }
        if (c10 >= 'S' && c10 <= 'Z') {
            return c10 - 'Q';
        }
        if (c10 < '0' || c10 > '9') {
            throw new IllegalArgumentException();
        }
        return c10 - '0';
    }

    public static int w(int i10) {
        if (i10 > 0 && i10 <= 7) {
            return 9 - i10;
        }
        if (i10 == 8) {
            return 10;
        }
        if (i10 == 9) {
            return 0;
        }
        if (i10 < 10 || i10 > 17) {
            throw new IllegalArgumentException();
        }
        return 19 - i10;
    }

    @Override // y5.t
    /* renamed from: u */
    public g0 k(t5.k kVar) {
        if (kVar.b() != BarcodeFormat.CODE_39) {
            return null;
        }
        String trim = f33018f.matcher(kVar.g()).replaceAll("").trim();
        if (!f33019g.matcher(trim).matches()) {
            return null;
        }
        try {
            if (!r(trim)) {
                return null;
            }
            String substring = trim.substring(0, 3);
            return new g0(trim, substring, trim.substring(3, 9), trim.substring(9, 17), s(substring), trim.substring(3, 8), t(trim.charAt(9)), trim.charAt(10), trim.substring(11));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
