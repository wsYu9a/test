package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class BidiFormatter {

    /* renamed from: a */
    static final TextDirectionHeuristicCompat f1904a;

    /* renamed from: b */
    private static final char f1905b = 8234;

    /* renamed from: c */
    private static final char f1906c = 8235;

    /* renamed from: d */
    private static final char f1907d = 8236;

    /* renamed from: e */
    private static final char f1908e = 8206;

    /* renamed from: f */
    private static final char f1909f = 8207;

    /* renamed from: g */
    private static final String f1910g;

    /* renamed from: h */
    private static final String f1911h;

    /* renamed from: i */
    private static final String f1912i = "";

    /* renamed from: j */
    private static final int f1913j = 2;
    private static final int k = 2;
    static final BidiFormatter l;
    static final BidiFormatter m;
    private static final int n = -1;
    private static final int o = 0;
    private static final int p = 1;
    private final boolean q;
    private final int r;
    private final TextDirectionHeuristicCompat s;

    private static class DirectionalityEstimator {

        /* renamed from: a */
        private static final int f1917a = 1792;

        /* renamed from: b */
        private static final byte[] f1918b = new byte[f1917a];

        /* renamed from: c */
        private final CharSequence f1919c;

        /* renamed from: d */
        private final boolean f1920d;

        /* renamed from: e */
        private final int f1921e;

        /* renamed from: f */
        private int f1922f;

        /* renamed from: g */
        private char f1923g;

        static {
            for (int i2 = 0; i2 < f1917a; i2++) {
                f1918b[i2] = Character.getDirectionality(i2);
            }
        }

        DirectionalityEstimator(CharSequence charSequence, boolean z) {
            this.f1919c = charSequence;
            this.f1920d = z;
            this.f1921e = charSequence.length();
        }

        private static byte c(char c2) {
            return c2 < f1917a ? f1918b[c2] : Character.getDirectionality(c2);
        }

        private byte f() {
            char charAt;
            int i2 = this.f1922f;
            do {
                int i3 = this.f1922f;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f1919c;
                int i4 = i3 - 1;
                this.f1922f = i4;
                charAt = charSequence.charAt(i4);
                this.f1923g = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f1922f = i2;
            this.f1923g = ';';
            return (byte) 13;
        }

        private byte g() {
            char charAt;
            do {
                int i2 = this.f1922f;
                if (i2 >= this.f1921e) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f1919c;
                this.f1922f = i2 + 1;
                charAt = charSequence.charAt(i2);
                this.f1923g = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i2 = this.f1922f;
            while (true) {
                int i3 = this.f1922f;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f1919c;
                int i4 = i3 - 1;
                this.f1922f = i4;
                char charAt2 = charSequence.charAt(i4);
                this.f1923g = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i5 = this.f1922f;
                        if (i5 > 0) {
                            CharSequence charSequence2 = this.f1919c;
                            int i6 = i5 - 1;
                            this.f1922f = i6;
                            charAt = charSequence2.charAt(i6);
                            this.f1923g = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.f1922f = i2;
            this.f1923g = Typography.greater;
            return (byte) 13;
        }

        private byte i() {
            char charAt;
            int i2 = this.f1922f;
            while (true) {
                int i3 = this.f1922f;
                if (i3 >= this.f1921e) {
                    this.f1922f = i2;
                    this.f1923g = Typography.less;
                    return (byte) 13;
                }
                CharSequence charSequence = this.f1919c;
                this.f1922f = i3 + 1;
                char charAt2 = charSequence.charAt(i3);
                this.f1923g = charAt2;
                if (charAt2 == '>') {
                    return (byte) 12;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i4 = this.f1922f;
                        if (i4 < this.f1921e) {
                            CharSequence charSequence2 = this.f1919c;
                            this.f1922f = i4 + 1;
                            charAt = charSequence2.charAt(i4);
                            this.f1923g = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
        }

        byte a() {
            char charAt = this.f1919c.charAt(this.f1922f - 1);
            this.f1923g = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f1919c, this.f1922f);
                this.f1922f -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f1922f--;
            byte c2 = c(this.f1923g);
            if (!this.f1920d) {
                return c2;
            }
            char c3 = this.f1923g;
            return c3 == '>' ? h() : c3 == ';' ? f() : c2;
        }

        byte b() {
            char charAt = this.f1919c.charAt(this.f1922f);
            this.f1923g = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f1919c, this.f1922f);
                this.f1922f += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f1922f++;
            byte c2 = c(this.f1923g);
            if (!this.f1920d) {
                return c2;
            }
            char c3 = this.f1923g;
            return c3 == '<' ? i() : c3 == '&' ? g() : c2;
        }

        int d() {
            this.f1922f = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (this.f1922f < this.f1921e && i2 == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i4 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i4++;
                                i3 = -1;
                                continue;
                            case 16:
                            case 17:
                                i4++;
                                i3 = 1;
                                continue;
                            case 18:
                                i4--;
                                i3 = 0;
                                continue;
                        }
                    }
                } else if (i4 == 0) {
                    return -1;
                }
                i2 = i4;
            }
            if (i2 == 0) {
                return 0;
            }
            if (i3 != 0) {
                return i3;
            }
            while (this.f1922f > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i2 == i4) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i2 == i4) {
                            return 1;
                        }
                        break;
                    case 18:
                        i4++;
                        continue;
                }
                i4--;
            }
            return 0;
        }

        int e() {
            this.f1922f = this.f1921e;
            int i2 = 0;
            int i3 = 0;
            while (this.f1922f > 0) {
                byte a2 = a();
                if (a2 != 0) {
                    if (a2 == 1 || a2 == 2) {
                        if (i2 == 0) {
                            return 1;
                        }
                        if (i3 == 0) {
                            i3 = i2;
                        }
                    } else if (a2 != 9) {
                        switch (a2) {
                            case 14:
                            case 15:
                                if (i3 == i2) {
                                    return -1;
                                }
                                i2--;
                                break;
                            case 16:
                            case 17:
                                if (i3 == i2) {
                                    return 1;
                                }
                                i2--;
                                break;
                            case 18:
                                i2++;
                                break;
                            default:
                                if (i3 != 0) {
                                    break;
                                } else {
                                    i3 = i2;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else {
                    if (i2 == 0) {
                        return -1;
                    }
                    if (i3 == 0) {
                        i3 = i2;
                    }
                }
            }
            return 0;
        }
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        f1904a = textDirectionHeuristicCompat;
        f1910g = Character.toString(f1908e);
        f1911h = Character.toString(f1909f);
        l = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        m = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    BidiFormatter(boolean z, int i2, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.q = z;
        this.r = i2;
        this.s = textDirectionHeuristicCompat;
    }

    private static int a(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).e();
    }

    static boolean c(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private String d(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        return (this.q || !(isRtl || b(charSequence) == 1)) ? this.q ? (!isRtl || b(charSequence) == -1) ? f1911h : "" : "" : f1910g;
    }

    private String e(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        return (this.q || !(isRtl || a(charSequence) == 1)) ? this.q ? (!isRtl || a(charSequence) == -1) ? f1911h : "" : "" : f1910g;
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public boolean getStereoReset() {
        return (this.r & 2) != 0;
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.q;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z).toString();
    }

    public static final class Builder {

        /* renamed from: a */
        private boolean f1914a;

        /* renamed from: b */
        private int f1915b;

        /* renamed from: c */
        private TextDirectionHeuristicCompat f1916c;

        public Builder() {
            b(BidiFormatter.c(Locale.getDefault()));
        }

        private static BidiFormatter a(boolean z) {
            return z ? BidiFormatter.m : BidiFormatter.l;
        }

        private void b(boolean z) {
            this.f1914a = z;
            this.f1916c = BidiFormatter.f1904a;
            this.f1915b = 2;
        }

        public BidiFormatter build() {
            return (this.f1915b == 2 && this.f1916c == BidiFormatter.f1904a) ? a(this.f1914a) : new BidiFormatter(this.f1914a, this.f1915b, this.f1916c);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.f1916c = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z) {
            if (z) {
                this.f1915b |= 2;
            } else {
                this.f1915b &= -3;
            }
            return this;
        }

        public Builder(boolean z) {
            b(z);
        }

        public Builder(Locale locale) {
            b(BidiFormatter.c(locale));
        }
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.s.isRtl(charSequence, 0, charSequence.length());
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z) {
            spannableStringBuilder.append((CharSequence) e(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.q) {
            spannableStringBuilder.append(isRtl ? f1906c : f1905b);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(f1907d);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) d(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.s, z);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z) {
        return unicodeWrap(charSequence, this.s, z);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.s, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.s, true);
    }
}
