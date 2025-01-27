package y5;

import com.google.zxing.client.result.ParsedResultType;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public final class v extends q {

    /* renamed from: b */
    public final String[] f33057b;

    /* renamed from: c */
    public final String[] f33058c;

    /* renamed from: d */
    public final String f33059d;

    /* renamed from: e */
    public final String f33060e;

    public v(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.f33057b = new String[]{str};
        this.f33058c = new String[]{str2};
        this.f33059d = str3;
        this.f33060e = str4;
    }

    @Override // y5.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(100);
        q.c(this.f33057b, sb2);
        q.b(this.f33059d, sb2);
        q.b(this.f33060e, sb2);
        return sb2.toString();
    }

    public String d() {
        return this.f33060e;
    }

    public String[] e() {
        return this.f33057b;
    }

    public String f() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sms:");
        boolean z10 = true;
        for (int i10 = 0; i10 < this.f33057b.length; i10++) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(',');
            }
            sb2.append(this.f33057b[i10]);
            String[] strArr = this.f33058c;
            if (strArr != null && strArr[i10] != null) {
                sb2.append(";via=");
                sb2.append(this.f33058c[i10]);
            }
        }
        boolean z11 = this.f33060e != null;
        boolean z12 = this.f33059d != null;
        if (z11 || z12) {
            sb2.append('?');
            if (z11) {
                sb2.append("body=");
                sb2.append(this.f33060e);
            }
            if (z12) {
                if (z11) {
                    sb2.append(Typography.amp);
                }
                sb2.append("subject=");
                sb2.append(this.f33059d);
            }
        }
        return sb2.toString();
    }

    public String g() {
        return this.f33059d;
    }

    public String[] h() {
        return this.f33058c;
    }

    public v(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.f33057b = strArr;
        this.f33058c = strArr2;
        this.f33059d = str;
        this.f33060e = str2;
    }
}
