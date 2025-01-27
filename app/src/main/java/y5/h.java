package y5;

import androidx.core.net.MailTo;
import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class h extends q {

    /* renamed from: b */
    public final String[] f33013b;

    /* renamed from: c */
    public final String[] f33014c;

    /* renamed from: d */
    public final String[] f33015d;

    /* renamed from: e */
    public final String f33016e;

    /* renamed from: f */
    public final String f33017f;

    public h(String str) {
        this(new String[]{str}, null, null, null, null);
    }

    @Override // y5.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(30);
        q.c(this.f33013b, sb2);
        q.c(this.f33014c, sb2);
        q.c(this.f33015d, sb2);
        q.b(this.f33016e, sb2);
        q.b(this.f33017f, sb2);
        return sb2.toString();
    }

    public String[] d() {
        return this.f33015d;
    }

    public String e() {
        return this.f33017f;
    }

    public String[] f() {
        return this.f33014c;
    }

    @Deprecated
    public String g() {
        String[] strArr = this.f33013b;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[0];
    }

    @Deprecated
    public String h() {
        return MailTo.MAILTO_SCHEME;
    }

    public String i() {
        return this.f33016e;
    }

    public String[] j() {
        return this.f33013b;
    }

    public h(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(ParsedResultType.EMAIL_ADDRESS);
        this.f33013b = strArr;
        this.f33014c = strArr2;
        this.f33015d = strArr3;
        this.f33016e = str;
        this.f33017f = str2;
    }
}
