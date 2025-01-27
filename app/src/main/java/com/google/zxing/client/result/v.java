package com.google.zxing.client.result;

import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class v extends q {

    /* renamed from: b */
    private final String[] f8279b;

    /* renamed from: c */
    private final String[] f8280c;

    /* renamed from: d */
    private final String f8281d;

    /* renamed from: e */
    private final String f8282e;

    public v(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.f8279b = new String[]{str};
        this.f8280c = new String[]{str2};
        this.f8281d = str3;
        this.f8282e = str4;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.c(this.f8279b, sb);
        q.b(this.f8281d, sb);
        q.b(this.f8282e, sb);
        return sb.toString();
    }

    public String d() {
        return this.f8282e;
    }

    public String[] e() {
        return this.f8279b;
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append("sms:");
        boolean z = true;
        for (int i2 = 0; i2 < this.f8279b.length; i2++) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append(this.f8279b[i2]);
            String[] strArr = this.f8280c;
            if (strArr != null && strArr[i2] != null) {
                sb.append(";via=");
                sb.append(this.f8280c[i2]);
            }
        }
        boolean z2 = this.f8282e != null;
        boolean z3 = this.f8281d != null;
        if (z2 || z3) {
            sb.append('?');
            if (z2) {
                sb.append("body=");
                sb.append(this.f8282e);
            }
            if (z3) {
                if (z2) {
                    sb.append(Typography.amp);
                }
                sb.append("subject=");
                sb.append(this.f8281d);
            }
        }
        return sb.toString();
    }

    public String g() {
        return this.f8281d;
    }

    public String[] h() {
        return this.f8280c;
    }

    public v(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.f8279b = strArr;
        this.f8280c = strArr2;
        this.f8281d = str;
        this.f8282e = str2;
    }
}
