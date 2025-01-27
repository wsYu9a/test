package b8;

/* loaded from: classes3.dex */
public class j {

    /* renamed from: a */
    public String f1437a;

    /* renamed from: b */
    public String f1438b;

    /* renamed from: c */
    public String f1439c;

    /* renamed from: d */
    public String f1440d;

    /* renamed from: e */
    public String f1441e;

    /* renamed from: f */
    public String f1442f;

    public j(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f1437a = "1";
        this.f1438b = "";
        this.f1439c = "";
        this.f1440d = "";
        this.f1441e = "";
        this.f1442f = "";
        if (!ba.l.q(str)) {
            this.f1437a = str;
        }
        if (!ba.l.q(str2)) {
            this.f1438b = str2;
        }
        if (!ba.l.q(str3)) {
            this.f1439c = str3;
        }
        if (!ba.l.q(str4)) {
            this.f1440d = str4;
        }
        if (!ba.l.q(str5)) {
            this.f1441e = str5;
        }
        if (ba.l.q(str6)) {
            return;
        }
        this.f1442f = str6.replaceAll(",", "/");
    }

    public String a() {
        return this.f1441e;
    }

    public String b() {
        return this.f1442f;
    }

    public String c() {
        return this.f1438b;
    }

    public String d() {
        return this.f1440d;
    }

    public String e() {
        return this.f1439c;
    }

    public String f() {
        return this.f1437a;
    }
}
