package i2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public String f26828a;

    /* renamed from: b */
    public String f26829b;

    /* renamed from: c */
    public String f26830c;

    /* renamed from: d */
    public String f26831d;

    /* renamed from: e */
    public String f26832e;

    /* renamed from: f */
    public String f26833f;

    /* renamed from: g */
    public String f26834g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f26828a = str;
        this.f26829b = str2;
        this.f26830c = str3;
        this.f26831d = str4;
        this.f26832e = str5;
        this.f26833f = str6;
        this.f26834g = str7;
    }

    public final String toString() {
        StringBuilder sb2;
        String str;
        StringBuilder sb3;
        String str2;
        StringBuilder sb4;
        String str3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.f26828a);
        stringBuffer.append("," + this.f26829b);
        stringBuffer.append("," + this.f26830c);
        stringBuffer.append("," + this.f26831d);
        if (t3.a.c(this.f26832e) || this.f26832e.length() < 20) {
            sb2 = new StringBuilder(",");
            str = this.f26832e;
        } else {
            sb2 = new StringBuilder(",");
            str = this.f26832e.substring(0, 20);
        }
        sb2.append(str);
        stringBuffer.append(sb2.toString());
        if (t3.a.c(this.f26833f) || this.f26833f.length() < 20) {
            sb3 = new StringBuilder(",");
            str2 = this.f26833f;
        } else {
            sb3 = new StringBuilder(",");
            str2 = this.f26833f.substring(0, 20);
        }
        sb3.append(str2);
        stringBuffer.append(sb3.toString());
        if (t3.a.c(this.f26834g) || this.f26834g.length() < 20) {
            sb4 = new StringBuilder(",");
            str3 = this.f26834g;
        } else {
            sb4 = new StringBuilder(",");
            str3 = this.f26834g.substring(0, 20);
        }
        sb4.append(str3);
        stringBuffer.append(sb4.toString());
        return stringBuffer.toString();
    }
}
