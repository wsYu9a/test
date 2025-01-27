package com.vivo.google.android.exoplayer3;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import com.cdo.oaps.ad.OapsKey;
import com.vivo.google.android.exoplayer3.a5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* loaded from: classes4.dex */
public final class b5 {

    /* renamed from: b */
    public static final Pattern f27217b = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: c */
    public static final Pattern f27218c = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: a */
    public final StringBuilder f27219a = new StringBuilder();

    public static final class a {

        /* renamed from: e */
        public static final String[] f27220e = new String[0];

        /* renamed from: a */
        public final String f27221a;

        /* renamed from: b */
        public final int f27222b;

        /* renamed from: c */
        public final String f27223c;

        /* renamed from: d */
        public final String[] f27224d;

        public a(String str, int i2, String str2, String[] strArr) {
            this.f27222b = i2;
            this.f27221a = str;
            this.f27223c = str2;
            this.f27224d = strArr;
        }
    }

    public static final class b implements Comparable<b> {

        /* renamed from: a */
        public final int f27225a;

        /* renamed from: b */
        public final z4 f27226b;

        public b(int i2, z4 z4Var) {
            this.f27225a = i2;
            this.f27226b = z4Var;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull b bVar) {
            return this.f27225a - bVar.f27225a;
        }
    }

    public static int a(String str) {
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
                String str2 = "Invalid anchor value: " + str;
                return Integer.MIN_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0112  */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v21, types: [int] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r17, com.vivo.google.android.exoplayer3.b5.a r18, android.text.SpannableStringBuilder r19, java.util.List<com.vivo.google.android.exoplayer3.z4> r20, java.util.List<com.vivo.google.android.exoplayer3.b5.b> r21) {
        /*
            Method dump skipped, instructions count: 556
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.b5.a(java.lang.String, com.vivo.google.android.exoplayer3.b5$a, android.text.SpannableStringBuilder, java.util.List, java.util.List):void");
    }

    public static Layout.Alignment b(String str) {
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
                String str2 = "Invalid alignment value: " + str;
                return null;
        }
    }

    public static boolean a(String str, Matcher matcher, n6 n6Var, a5.b bVar, StringBuilder sb, List<z4> list) {
        try {
            bVar.f27139a = d5.b(matcher.group(1));
            bVar.f27140b = d5.b(matcher.group(2));
            a(matcher.group(3), bVar);
            sb.setLength(0);
            while (true) {
                String d2 = n6Var.d();
                if (d2 == null || d2.isEmpty()) {
                    break;
                }
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(d2.trim());
            }
            a(str, sb.toString(), bVar, list);
            return true;
        } catch (NumberFormatException unused) {
            String str2 = "Skipping cue with bad header: " + matcher.group();
            return false;
        }
    }

    public static void a(String str, a5.b bVar) {
        Matcher matcher = f27218c.matcher(str);
        while (matcher.find()) {
            int i2 = 1;
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    int indexOf = group2.indexOf(44);
                    if (indexOf != -1) {
                        bVar.f27145g = a(group2.substring(indexOf + 1));
                        group2 = group2.substring(0, indexOf);
                    } else {
                        bVar.f27145g = Integer.MIN_VALUE;
                    }
                    if (group2.endsWith("%")) {
                        bVar.f27143e = d5.a(group2);
                        i2 = 0;
                    } else {
                        int parseInt = Integer.parseInt(group2);
                        if (parseInt < 0) {
                            parseInt--;
                        }
                        bVar.f27143e = parseInt;
                    }
                    bVar.f27144f = i2;
                } else if ("align".equals(group)) {
                    bVar.f27142d = b(group2);
                } else if ("position".equals(group)) {
                    int indexOf2 = group2.indexOf(44);
                    if (indexOf2 != -1) {
                        bVar.f27147i = a(group2.substring(indexOf2 + 1));
                        group2 = group2.substring(0, indexOf2);
                    } else {
                        bVar.f27147i = Integer.MIN_VALUE;
                    }
                    bVar.f27146h = d5.a(group2);
                } else if (OapsKey.KEY_SIZE.equals(group)) {
                    bVar.f27148j = d5.a(group2);
                } else {
                    String str2 = "Unknown cue setting " + group + ":" + group2;
                }
            } catch (NumberFormatException unused) {
                String str3 = "Skipping bad cue setting: " + matcher.group();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(String str, String str2, a5.b bVar, List<z4> list) {
        char c2;
        boolean z;
        a aVar;
        String substring;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Stack stack = new Stack();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String str3 = "";
            if (i3 >= str2.length()) {
                while (!stack.isEmpty()) {
                    a(str, (a) stack.pop(), spannableStringBuilder, list, arrayList);
                }
                a(str, new a("", 0, "", new String[0]), spannableStringBuilder, list, arrayList);
                bVar.f27141c = spannableStringBuilder;
                return;
            }
            char charAt = str2.charAt(i3);
            if (charAt == '&') {
                i3++;
                int indexOf = str2.indexOf(59, i3);
                int indexOf2 = str2.indexOf(32, i3);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    substring = str2.substring(i3, indexOf);
                    substring.hashCode();
                    switch (substring) {
                        case "gt":
                            spannableStringBuilder.append(Typography.greater);
                            break;
                        case "lt":
                            spannableStringBuilder.append(Typography.less);
                            break;
                        case "amp":
                            spannableStringBuilder.append(Typography.amp);
                            break;
                        case "nbsp":
                            spannableStringBuilder.append(' ');
                            break;
                        default:
                            String str4 = "ignoring unsupported entity: '&" + substring + ";'";
                            break;
                    }
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i3 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
                i2 = 0;
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i3++;
            } else {
                int i4 = i3 + 1;
                if (i4 < str2.length()) {
                    boolean z2 = str2.charAt(i4) == '/';
                    int indexOf3 = str2.indexOf(62, i4);
                    i4 = indexOf3 == -1 ? str2.length() : indexOf3 + 1;
                    int i5 = i4 - 2;
                    boolean z3 = str2.charAt(i5) == '/';
                    int i6 = i3 + (z2 ? 2 : 1);
                    if (!z3) {
                        i5 = i4 - 1;
                    }
                    String substring2 = str2.substring(i6, i5);
                    String trim = substring2.trim();
                    String str5 = trim.isEmpty() ? null : trim.split("[ \\.]")[i2];
                    if (str5 != null) {
                        switch (str5.hashCode()) {
                            case 98:
                                if (str5.equals("b")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 99:
                                if (str5.equals("c")) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 105:
                                if (str5.equals("i")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 117:
                                if (str5.equals("u")) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 118:
                                if (str5.equals("v")) {
                                    c2 = 4;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3314158:
                                if (str5.equals("lang")) {
                                    c2 = 5;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                                z = true;
                                break;
                            default:
                                z = false;
                                break;
                        }
                        if (z) {
                            if (z2) {
                                while (!stack.isEmpty()) {
                                    a aVar2 = (a) stack.pop();
                                    a(str, aVar2, spannableStringBuilder, list, arrayList);
                                    if (aVar2.f27221a.equals(str5)) {
                                    }
                                }
                            } else if (!z3) {
                                int length = spannableStringBuilder.length();
                                String trim2 = substring2.trim();
                                if (trim2.isEmpty()) {
                                    aVar = null;
                                } else {
                                    int indexOf4 = trim2.indexOf(" ");
                                    if (indexOf4 != -1) {
                                        str3 = trim2.substring(indexOf4).trim();
                                        trim2 = trim2.substring(i2, indexOf4);
                                    }
                                    String[] split = trim2.split("\\.");
                                    aVar = new a(split[i2], length, str3, split.length > 1 ? (String[]) Arrays.copyOfRange(split, 1, split.length) : a.f27220e);
                                }
                                stack.push(aVar);
                            }
                        }
                    }
                }
                i3 = i4;
            }
        }
    }
}
