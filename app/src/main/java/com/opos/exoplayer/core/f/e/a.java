package com.opos.exoplayer.core.f.e;

import android.text.Html;
import android.text.TextUtils;
import com.opos.exoplayer.core.f.c;
import com.opos.exoplayer.core.i.h;
import com.opos.exoplayer.core.i.m;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class a extends c {

    /* renamed from: a */
    private static final Pattern f18704a = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");

    /* renamed from: b */
    private final StringBuilder f18705b;

    public a() {
        super("SubripDecoder");
        this.f18705b = new StringBuilder();
    }

    private static long a(Matcher matcher, int i2) {
        return ((Long.parseLong(matcher.group(i2 + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 3)) * 1000) + Long.parseLong(matcher.group(i2 + 4))) * 1000;
    }

    @Override // com.opos.exoplayer.core.f.c
    /* renamed from: b */
    public b a(byte[] bArr, int i2, boolean z) {
        StringBuilder sb;
        String str;
        ArrayList arrayList = new ArrayList();
        h hVar = new h();
        m mVar = new m(bArr, i2);
        while (true) {
            String z2 = mVar.z();
            if (z2 == null) {
                break;
            }
            if (z2.length() != 0) {
                try {
                    Integer.parseInt(z2);
                    z2 = mVar.z();
                } catch (NumberFormatException unused) {
                    sb = new StringBuilder();
                    str = "Skipping invalid index: ";
                }
                if (z2 == null) {
                    com.opos.cmn.an.f.a.c("SubripDecoder", "Unexpected end");
                    break;
                }
                Matcher matcher = f18704a.matcher(z2);
                if (matcher.matches()) {
                    boolean z3 = true;
                    hVar.a(a(matcher, 1));
                    if (TextUtils.isEmpty(matcher.group(6))) {
                        z3 = false;
                    } else {
                        hVar.a(a(matcher, 6));
                    }
                    this.f18705b.setLength(0);
                    while (true) {
                        String z4 = mVar.z();
                        if (TextUtils.isEmpty(z4)) {
                            break;
                        }
                        if (this.f18705b.length() > 0) {
                            this.f18705b.append("<br>");
                        }
                        this.f18705b.append(z4.trim());
                    }
                    arrayList.add(new com.opos.exoplayer.core.f.b(Html.fromHtml(this.f18705b.toString())));
                    if (z3) {
                        arrayList.add(null);
                    }
                } else {
                    sb = new StringBuilder();
                    str = "Skipping invalid timing: ";
                    sb.append(str);
                    sb.append(z2);
                    com.opos.cmn.an.f.a.c("SubripDecoder", sb.toString());
                }
            }
        }
        com.opos.exoplayer.core.f.b[] bVarArr = new com.opos.exoplayer.core.f.b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return new b(bVarArr, hVar.b());
    }
}
