package gj;

import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: e */
    public static final e f26296e = new e('0', '+', '-', '.');

    /* renamed from: f */
    public static final ConcurrentMap<Locale, e> f26297f = new ConcurrentHashMap(16, 0.75f, 2);

    /* renamed from: a */
    public final char f26298a;

    /* renamed from: b */
    public final char f26299b;

    /* renamed from: c */
    public final char f26300c;

    /* renamed from: d */
    public final char f26301d;

    public e(char c10, char c11, char c12, char c13) {
        this.f26298a = c10;
        this.f26299b = c11;
        this.f26300c = c12;
        this.f26301d = c13;
    }

    public static e c(Locale locale) {
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(locale);
        char zeroDigit = decimalFormatSymbols.getZeroDigit();
        char minusSign = decimalFormatSymbols.getMinusSign();
        char decimalSeparator = decimalFormatSymbols.getDecimalSeparator();
        return (zeroDigit == '0' && minusSign == '-' && decimalSeparator == '.') ? f26296e : new e(zeroDigit, '+', minusSign, decimalSeparator);
    }

    public static Set<Locale> d() {
        return new HashSet(Arrays.asList(DecimalFormatSymbols.getAvailableLocales()));
    }

    public static e i(Locale locale) {
        hj.d.j(locale, "locale");
        ConcurrentMap<Locale, e> concurrentMap = f26297f;
        e eVar = concurrentMap.get(locale);
        if (eVar != null) {
            return eVar;
        }
        concurrentMap.putIfAbsent(locale, c(locale));
        return concurrentMap.get(locale);
    }

    public static e j() {
        return i(Locale.getDefault());
    }

    public String a(String str) {
        char c10 = this.f26298a;
        if (c10 == '0') {
            return str;
        }
        int i10 = c10 - '0';
        char[] charArray = str.toCharArray();
        for (int i11 = 0; i11 < charArray.length; i11++) {
            charArray[i11] = (char) (charArray[i11] + i10);
        }
        return new String(charArray);
    }

    public int b(char c10) {
        int i10 = c10 - this.f26298a;
        if (i10 < 0 || i10 > 9) {
            return -1;
        }
        return i10;
    }

    public char e() {
        return this.f26301d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f26298a == eVar.f26298a && this.f26299b == eVar.f26299b && this.f26300c == eVar.f26300c && this.f26301d == eVar.f26301d;
    }

    public char f() {
        return this.f26300c;
    }

    public char g() {
        return this.f26299b;
    }

    public char h() {
        return this.f26298a;
    }

    public int hashCode() {
        return this.f26298a + this.f26299b + this.f26300c + this.f26301d;
    }

    public e k(char c10) {
        return c10 == this.f26301d ? this : new e(this.f26298a, this.f26299b, this.f26300c, c10);
    }

    public e l(char c10) {
        return c10 == this.f26300c ? this : new e(this.f26298a, this.f26299b, c10, this.f26301d);
    }

    public e m(char c10) {
        return c10 == this.f26299b ? this : new e(this.f26298a, c10, this.f26300c, this.f26301d);
    }

    public e n(char c10) {
        return c10 == this.f26298a ? this : new e(c10, this.f26299b, this.f26300c, this.f26301d);
    }

    public String toString() {
        return "DecimalStyle[" + this.f26298a + this.f26299b + this.f26300c + this.f26301d + "]";
    }
}
