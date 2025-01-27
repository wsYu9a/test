package com.opos.exoplayer.core.f.h;

import android.text.TextUtils;
import com.opos.exoplayer.core.i.m;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
final class g {

    /* renamed from: a */
    private static final Pattern f18803a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: b */
    private final m f18804b = new m();

    /* renamed from: c */
    private final StringBuilder f18805c = new StringBuilder();

    private static char a(m mVar, int i2) {
        return (char) mVar.f19048a[i2];
    }

    static String a(m mVar, StringBuilder sb) {
        b(mVar);
        if (mVar.b() == 0) {
            return null;
        }
        String d2 = d(mVar, sb);
        if (!"".equals(d2)) {
            return d2;
        }
        return "" + ((char) mVar.g());
    }

    private void a(b bVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        if (indexOf != -1) {
            Matcher matcher = f18803a.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                bVar.c(matcher.group(1));
            }
            str = str.substring(0, indexOf);
        }
        String[] split = str.split("\\.");
        String str2 = split[0];
        int indexOf2 = str2.indexOf(35);
        if (indexOf2 != -1) {
            bVar.b(str2.substring(0, indexOf2));
            bVar.a(str2.substring(indexOf2 + 1));
        } else {
            bVar.b(str2);
        }
        if (split.length > 1) {
            bVar.a((String[]) Arrays.copyOfRange(split, 1, split.length));
        }
    }

    private static void a(m mVar, b bVar, StringBuilder sb) {
        b(mVar);
        String d2 = d(mVar, sb);
        if (!"".equals(d2) && ":".equals(a(mVar, sb))) {
            b(mVar);
            String c2 = c(mVar, sb);
            if (c2 == null || "".equals(c2)) {
                return;
            }
            int d3 = mVar.d();
            String a2 = a(mVar, sb);
            if (!";".equals(a2)) {
                if (!"}".equals(a2)) {
                    return;
                } else {
                    mVar.c(d3);
                }
            }
            if ("color".equals(d2)) {
                bVar.a(com.opos.exoplayer.core.i.d.b(c2));
                return;
            }
            if ("background-color".equals(d2)) {
                bVar.b(com.opos.exoplayer.core.i.d.b(c2));
                return;
            }
            if ("text-decoration".equals(d2)) {
                if ("underline".equals(c2)) {
                    bVar.a(true);
                }
            } else {
                if ("font-family".equals(d2)) {
                    bVar.d(c2);
                    return;
                }
                if ("font-weight".equals(d2)) {
                    if ("bold".equals(c2)) {
                        bVar.b(true);
                    }
                } else if ("font-style".equals(d2) && "italic".equals(c2)) {
                    bVar.c(true);
                }
            }
        }
    }

    private static String b(m mVar, StringBuilder sb) {
        b(mVar);
        if (mVar.b() < 5 || !"::cue".equals(mVar.e(5))) {
            return null;
        }
        int d2 = mVar.d();
        String a2 = a(mVar, sb);
        if (a2 == null) {
            return null;
        }
        if ("{".equals(a2)) {
            mVar.c(d2);
            return "";
        }
        String d3 = "(".equals(a2) ? d(mVar) : null;
        String a3 = a(mVar, sb);
        if (!")".equals(a3) || a3 == null) {
            return null;
        }
        return d3;
    }

    static void b(m mVar) {
        while (true) {
            for (boolean z = true; mVar.b() > 0 && z; z = false) {
                if (!e(mVar) && !f(mVar)) {
                }
            }
            return;
        }
    }

    private static String c(m mVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int d2 = mVar.d();
            String a2 = a(mVar, sb);
            if (a2 == null) {
                return null;
            }
            if ("}".equals(a2) || ";".equals(a2)) {
                mVar.c(d2);
                z = true;
            } else {
                sb2.append(a2);
            }
        }
        return sb2.toString();
    }

    static void c(m mVar) {
        while (!TextUtils.isEmpty(mVar.z())) {
        }
    }

    private static String d(m mVar) {
        int d2 = mVar.d();
        int c2 = mVar.c();
        boolean z = false;
        while (d2 < c2 && !z) {
            z = ((char) mVar.f19048a[d2]) == ')';
            d2++;
        }
        return mVar.e((d2 - 1) - mVar.d()).trim();
    }

    private static String d(m mVar, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int d2 = mVar.d();
        int c2 = mVar.c();
        while (d2 < c2 && !z) {
            char c3 = (char) mVar.f19048a[d2];
            if ((c3 < 'A' || c3 > 'Z') && ((c3 < 'a' || c3 > 'z') && !((c3 >= '0' && c3 <= '9') || c3 == '#' || c3 == '-' || c3 == '.' || c3 == '_'))) {
                z = true;
            } else {
                d2++;
                sb.append(c3);
            }
        }
        mVar.d(d2 - mVar.d());
        return sb.toString();
    }

    private static boolean e(m mVar) {
        char a2 = a(mVar, mVar.d());
        if (a2 != '\t' && a2 != '\n' && a2 != '\f' && a2 != '\r' && a2 != ' ') {
            return false;
        }
        mVar.d(1);
        return true;
    }

    private static boolean f(m mVar) {
        int d2 = mVar.d();
        int c2 = mVar.c();
        byte[] bArr = mVar.f19048a;
        if (d2 + 2 <= c2) {
            int i2 = d2 + 1;
            if (bArr[d2] == 47) {
                int i3 = i2 + 1;
                if (bArr[i2] == 42) {
                    while (true) {
                        int i4 = i3 + 1;
                        if (i4 >= c2) {
                            mVar.d(c2 - mVar.d());
                            return true;
                        }
                        if (((char) bArr[i3]) == '*' && ((char) bArr[i4]) == '/') {
                            c2 = i4 + 1;
                            i3 = c2;
                        } else {
                            i3 = i4;
                        }
                    }
                }
            }
        }
        return false;
    }

    public b a(m mVar) {
        this.f18805c.setLength(0);
        int d2 = mVar.d();
        c(mVar);
        this.f18804b.a(mVar.f19048a, mVar.d());
        this.f18804b.c(d2);
        String b2 = b(this.f18804b, this.f18805c);
        if (b2 == null || !"{".equals(a(this.f18804b, this.f18805c))) {
            return null;
        }
        b bVar = new b();
        a(bVar, b2);
        String str = null;
        boolean z = false;
        while (!z) {
            int d3 = this.f18804b.d();
            str = a(this.f18804b, this.f18805c);
            boolean z2 = str == null || "}".equals(str);
            if (!z2) {
                this.f18804b.c(d3);
                a(this.f18804b, bVar, this.f18805c);
            }
            z = z2;
        }
        if ("}".equals(str)) {
            return bVar;
        }
        return null;
    }
}
