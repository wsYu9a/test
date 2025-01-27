package com.opos.exoplayer.core.f.h;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.NonNull;
import com.cdo.oaps.ad.OapsKey;
import com.opos.exoplayer.core.f.h.c;
import com.opos.exoplayer.core.i.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    public static final Pattern f18786a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b */
    private static final Pattern f18787b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c */
    private final StringBuilder f18788c = new StringBuilder();

    private static final class a {

        /* renamed from: e */
        private static final String[] f18789e = new String[0];

        /* renamed from: a */
        public final String f18790a;

        /* renamed from: b */
        public final int f18791b;

        /* renamed from: c */
        public final String f18792c;

        /* renamed from: d */
        public final String[] f18793d;

        private a(String str, int i2, String str2, String[] strArr) {
            this.f18791b = i2;
            this.f18790a = str;
            this.f18792c = str2;
            this.f18793d = strArr;
        }

        public static a a() {
            return new a("", 0, "", new String[0]);
        }

        public static a a(String str, int i2) {
            String str2;
            String trim = str.trim();
            if (trim.isEmpty()) {
                return null;
            }
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] split = trim.split("\\.");
            return new a(split[0], i2, str2, split.length > 1 ? (String[]) Arrays.copyOfRange(split, 1, split.length) : f18789e);
        }
    }

    private static final class b implements Comparable<b> {

        /* renamed from: a */
        public final int f18794a;

        /* renamed from: b */
        public final com.opos.exoplayer.core.f.h.b f18795b;

        public b(int i2, com.opos.exoplayer.core.f.h.b bVar) {
            this.f18794a = i2;
            this.f18795b = bVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull b bVar) {
            return this.f18794a - bVar.f18794a;
        }
    }

    private static int a(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 1;
            case "end":
                return 2;
            case "start":
                return 0;
            default:
                com.opos.cmn.an.f.a.c("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static int a(String str, int i2) {
        int indexOf = str.indexOf(62, i2);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, com.opos.exoplayer.core.f.h.b bVar, int i2, int i3) {
        Object absoluteSizeSpan;
        if (bVar == null) {
            return;
        }
        if (bVar.b() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(bVar.b()), i2, i3, 33);
        }
        if (bVar.c()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, i3, 33);
        }
        if (bVar.d()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
        }
        if (bVar.g()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(bVar.f()), i2, i3, 33);
        }
        if (bVar.i()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(bVar.h()), i2, i3, 33);
        }
        if (bVar.e() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(bVar.e()), i2, i3, 33);
        }
        if (bVar.j() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(bVar.j()), i2, i3, 33);
        }
        int k = bVar.k();
        if (k == 1) {
            absoluteSizeSpan = new AbsoluteSizeSpan((int) bVar.l(), true);
        } else if (k == 2) {
            absoluteSizeSpan = new RelativeSizeSpan(bVar.l());
        } else if (k != 3) {
            return;
        } else {
            absoluteSizeSpan = new RelativeSizeSpan(bVar.l() / 100.0f);
        }
        spannableStringBuilder.setSpan(absoluteSizeSpan, i2, i3, 33);
    }

    private static void a(String str, SpannableStringBuilder spannableStringBuilder) {
        char c2;
        str.hashCode();
        switch (str) {
            case "gt":
                c2 = Typography.greater;
                break;
            case "lt":
                c2 = Typography.less;
                break;
            case "amp":
                c2 = Typography.amp;
                break;
            case "nbsp":
                c2 = ' ';
                break;
            default:
                com.opos.cmn.an.f.a.c("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                return;
        }
        spannableStringBuilder.append(c2);
    }

    static void a(String str, c.a aVar) {
        Matcher matcher = f18787b.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    b(group2, aVar);
                } else if ("align".equals(group)) {
                    aVar.a(b(group2));
                } else if ("position".equals(group)) {
                    c(group2, aVar);
                } else if (OapsKey.KEY_SIZE.equals(group)) {
                    aVar.c(f.b(group2));
                } else {
                    com.opos.cmn.an.f.a.c("WebvttCueParser", "Unknown cue setting " + group + ":" + group2);
                }
            } catch (NumberFormatException unused) {
                com.opos.cmn.an.f.a.c("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0089 A[LOOP:0: B:31:0x0087->B:32:0x0089, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.String r8, com.opos.exoplayer.core.f.h.d.a r9, android.text.SpannableStringBuilder r10, java.util.List<com.opos.exoplayer.core.f.h.b> r11, java.util.List<com.opos.exoplayer.core.f.h.d.b> r12) {
        /*
            int r0 = r9.f18791b
            int r1 = r10.length()
            java.lang.String r2 = r9.f18790a
            r2.hashCode()
            int r3 = r2.hashCode()
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = -1
            switch(r3) {
                case 0: goto L59;
                case 98: goto L4e;
                case 99: goto L43;
                case 105: goto L38;
                case 117: goto L2d;
                case 118: goto L22;
                case 3314158: goto L17;
                default: goto L16;
            }
        L16:
            goto L63
        L17:
            java.lang.String r3 = "lang"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L20
            goto L63
        L20:
            r7 = 6
            goto L63
        L22:
            java.lang.String r3 = "v"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L2b
            goto L63
        L2b:
            r7 = 5
            goto L63
        L2d:
            java.lang.String r3 = "u"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L36
            goto L63
        L36:
            r7 = 4
            goto L63
        L38:
            java.lang.String r3 = "i"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L41
            goto L63
        L41:
            r7 = 3
            goto L63
        L43:
            java.lang.String r3 = "c"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L4c
            goto L63
        L4c:
            r7 = 2
            goto L63
        L4e:
            java.lang.String r3 = "b"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L57
            goto L63
        L57:
            r7 = 1
            goto L63
        L59:
            java.lang.String r3 = ""
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L62
            goto L63
        L62:
            r7 = 0
        L63:
            r2 = 33
            switch(r7) {
                case 0: goto L7d;
                case 1: goto L75;
                case 2: goto L7d;
                case 3: goto L6f;
                case 4: goto L69;
                case 5: goto L7d;
                case 6: goto L7d;
                default: goto L68;
            }
        L68:
            goto L97
        L69:
            android.text.style.UnderlineSpan r3 = new android.text.style.UnderlineSpan
            r3.<init>()
            goto L7a
        L6f:
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r3.<init>(r4)
            goto L7a
        L75:
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r3.<init>(r6)
        L7a:
            r10.setSpan(r3, r0, r1, r2)
        L7d:
            r12.clear()
            a(r11, r8, r9, r12)
            int r8 = r12.size()
        L87:
            if (r5 >= r8) goto L97
            java.lang.Object r9 = r12.get(r5)
            com.opos.exoplayer.core.f.h.d$b r9 = (com.opos.exoplayer.core.f.h.d.b) r9
            com.opos.exoplayer.core.f.h.b r9 = r9.f18795b
            a(r10, r9, r0, r1)
            int r5 = r5 + 1
            goto L87
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.f.h.d.a(java.lang.String, com.opos.exoplayer.core.f.h.d$a, android.text.SpannableStringBuilder, java.util.List, java.util.List):void");
    }

    static void a(String str, String str2, c.a aVar, List<com.opos.exoplayer.core.f.h.b> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < str2.length()) {
            char charAt = str2.charAt(i2);
            if (charAt == '&') {
                i2++;
                int indexOf = str2.indexOf(59, i2);
                int indexOf2 = str2.indexOf(32, i2);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    a(str2.substring(i2, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i2 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i2++;
            } else {
                int i3 = i2 + 1;
                if (i3 < str2.length()) {
                    boolean z = str2.charAt(i3) == '/';
                    i3 = a(str2, i3);
                    int i4 = i3 - 2;
                    boolean z2 = str2.charAt(i4) == '/';
                    int i5 = z ? 2 : 1;
                    if (!z2) {
                        i4 = i3 - 1;
                    }
                    String substring = str2.substring(i5 + i2, i4);
                    String d2 = d(substring);
                    if (d2 != null && c(d2)) {
                        if (z) {
                            while (!stack.isEmpty()) {
                                a aVar2 = (a) stack.pop();
                                a(str, aVar2, spannableStringBuilder, list, arrayList);
                                if (aVar2.f18790a.equals(d2)) {
                                    break;
                                }
                            }
                        } else if (!z2) {
                            stack.push(a.a(substring, spannableStringBuilder.length()));
                        }
                    }
                }
                i2 = i3;
            }
        }
        while (!stack.isEmpty()) {
            a(str, (a) stack.pop(), spannableStringBuilder, list, arrayList);
        }
        a(str, a.a(), spannableStringBuilder, list, arrayList);
        aVar.a(spannableStringBuilder);
    }

    private static void a(List<com.opos.exoplayer.core.f.h.b> list, String str, a aVar, List<b> list2) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.opos.exoplayer.core.f.h.b bVar = list.get(i2);
            int a2 = bVar.a(str, aVar.f18790a, aVar.f18793d, aVar.f18792c);
            if (a2 > 0) {
                list2.add(new b(a2, bVar));
            }
        }
        Collections.sort(list2);
    }

    private static boolean a(String str, Matcher matcher, m mVar, c.a aVar, StringBuilder sb, List<com.opos.exoplayer.core.f.h.b> list) {
        try {
            aVar.a(f.a(matcher.group(1))).b(f.a(matcher.group(2)));
            a(matcher.group(3), aVar);
            sb.setLength(0);
            while (true) {
                String z = mVar.z();
                if (TextUtils.isEmpty(z)) {
                    a(str, sb.toString(), aVar, list);
                    return true;
                }
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(z.trim());
            }
        } catch (NumberFormatException unused) {
            com.opos.cmn.an.f.a.c("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }

    private static Layout.Alignment b(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                com.opos.cmn.an.f.a.c("WebvttCueParser", "Invalid alignment value: " + str);
                return null;
        }
    }

    private static void b(String str, c.a aVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            aVar.b(a(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            aVar.b(Integer.MIN_VALUE);
        }
        if (str.endsWith("%")) {
            aVar.a(f.b(str)).a(0);
            return;
        }
        int parseInt = Integer.parseInt(str);
        if (parseInt < 0) {
            parseInt--;
        }
        aVar.a(parseInt).a(1);
    }

    private static void c(String str, c.a aVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            aVar.c(a(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        } else {
            aVar.c(Integer.MIN_VALUE);
        }
        aVar.b(f.b(str));
    }

    private static boolean c(String str) {
        str.hashCode();
        switch (str) {
            case "b":
            case "c":
            case "i":
            case "u":
            case "v":
            case "lang":
                return true;
            default:
                return false;
        }
    }

    private static String d(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return trim.split("[ \\.]")[0];
    }

    public boolean a(m mVar, c.a aVar, List<com.opos.exoplayer.core.f.h.b> list) {
        String z = mVar.z();
        if (z != null) {
            Pattern pattern = f18786a;
            Matcher matcher = pattern.matcher(z);
            if (matcher.matches()) {
                return a(null, matcher, mVar, aVar, this.f18788c, list);
            }
            String z2 = mVar.z();
            if (z2 != null) {
                Matcher matcher2 = pattern.matcher(z2);
                if (matcher2.matches()) {
                    return a(z.trim(), matcher2, mVar, aVar, this.f18788c, list);
                }
            }
        }
        return false;
    }
}
