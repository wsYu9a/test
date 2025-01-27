package com.opos.exoplayer.core.f.d;

import android.text.TextUtils;
import com.opos.exoplayer.core.f.c;
import com.opos.exoplayer.core.i.h;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;
import com.vivo.google.android.exoplayer3.C;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class a extends c {

    /* renamed from: a */
    private static final Pattern f18696a = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");

    /* renamed from: b */
    private final boolean f18697b;

    /* renamed from: c */
    private int f18698c;

    /* renamed from: d */
    private int f18699d;

    /* renamed from: e */
    private int f18700e;

    /* renamed from: f */
    private int f18701f;

    public a() {
        this(null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        if (list == null || list.isEmpty()) {
            this.f18697b = false;
            return;
        }
        this.f18697b = true;
        String str = new String(list.get(0));
        com.opos.exoplayer.core.i.a.a(str.startsWith("Format: "));
        b(str);
        a(new m(list.get(1)));
    }

    public static long a(String str) {
        Matcher matcher = f18696a.matcher(str);
        if (!matcher.matches()) {
            return C.TIME_UNSET;
        }
        long parseLong = Long.parseLong(matcher.group(1));
        long parseLong2 = Long.parseLong(matcher.group(2));
        long parseLong3 = Long.parseLong(matcher.group(3));
        return (parseLong * 60 * 60 * C.MICROS_PER_SECOND) + (parseLong2 * 60 * C.MICROS_PER_SECOND) + (parseLong3 * C.MICROS_PER_SECOND) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    private void a(m mVar) {
        String z;
        do {
            z = mVar.z();
            if (z == null) {
                return;
            }
        } while (!z.startsWith("[Events]"));
    }

    private void a(m mVar, List<com.opos.exoplayer.core.f.b> list, h hVar) {
        while (true) {
            String z = mVar.z();
            if (z == null) {
                return;
            }
            if (!this.f18697b && z.startsWith("Format: ")) {
                b(z);
            } else if (z.startsWith("Dialogue: ")) {
                a(z, list, hVar);
            }
        }
    }

    private void a(String str, List<com.opos.exoplayer.core.f.b> list, h hVar) {
        long j2;
        StringBuilder sb;
        String str2;
        if (this.f18698c == 0) {
            sb = new StringBuilder();
            str2 = "Skipping dialogue line before complete format: ";
        } else {
            String[] split = str.substring(10).split(",", this.f18698c);
            if (split.length == this.f18698c) {
                long a2 = a(split[this.f18699d]);
                if (a2 != C.TIME_UNSET) {
                    String str3 = split[this.f18700e];
                    if (str3.trim().isEmpty()) {
                        j2 = -9223372036854775807L;
                    } else {
                        j2 = a(str3);
                        if (j2 == C.TIME_UNSET) {
                            sb = new StringBuilder();
                        }
                    }
                    list.add(new com.opos.exoplayer.core.f.b(split[this.f18701f].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
                    hVar.a(a2);
                    if (j2 != C.TIME_UNSET) {
                        list.add(null);
                        hVar.a(j2);
                        return;
                    }
                    return;
                }
                sb = new StringBuilder();
                sb.append("Skipping invalid timing: ");
                sb.append(str);
                com.opos.cmn.an.f.a.c("SsaDecoder", sb.toString());
            }
            sb = new StringBuilder();
            str2 = "Skipping dialogue line with fewer columns than format: ";
        }
        sb.append(str2);
        sb.append(str);
        com.opos.cmn.an.f.a.c("SsaDecoder", sb.toString());
    }

    private void b(String str) {
        char c2;
        String[] split = TextUtils.split(str.substring(8), ",");
        this.f18698c = split.length;
        this.f18699d = -1;
        this.f18700e = -1;
        this.f18701f = -1;
        for (int i2 = 0; i2 < this.f18698c; i2++) {
            String d2 = u.d(split[i2].trim());
            int hashCode = d2.hashCode();
            if (hashCode == 100571) {
                if (d2.equals("end")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode != 3556653) {
                if (hashCode == 109757538 && d2.equals("start")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (d2.equals(com.baidu.mobads.sdk.internal.a.f5473b)) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                this.f18699d = i2;
            } else if (c2 == 1) {
                this.f18700e = i2;
            } else if (c2 == 2) {
                this.f18701f = i2;
            }
        }
        if (this.f18699d == -1 || this.f18700e == -1 || this.f18701f == -1) {
            this.f18698c = 0;
        }
    }

    @Override // com.opos.exoplayer.core.f.c
    /* renamed from: b */
    public b a(byte[] bArr, int i2, boolean z) {
        ArrayList arrayList = new ArrayList();
        h hVar = new h();
        m mVar = new m(bArr, i2);
        if (!this.f18697b) {
            a(mVar);
        }
        a(mVar, arrayList, hVar);
        com.opos.exoplayer.core.f.b[] bVarArr = new com.opos.exoplayer.core.f.b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return new b(bVarArr, hVar.b());
    }
}
