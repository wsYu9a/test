package b.d.a;

import com.martian.libsupport.k;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a */
    private String f4351a;

    /* renamed from: b */
    private String f4352b;

    /* renamed from: c */
    private String f4353c;

    /* renamed from: d */
    private String f4354d;

    /* renamed from: e */
    private String f4355e;

    /* renamed from: f */
    private String f4356f;

    public a(String gender, String books, String title, String id, String category, String label) {
        this.f4351a = "1";
        this.f4352b = "";
        this.f4353c = "";
        this.f4354d = "";
        this.f4355e = "";
        this.f4356f = "";
        if (!k.p(gender)) {
            this.f4351a = gender;
        }
        if (!k.p(books)) {
            this.f4352b = books;
        }
        if (!k.p(title)) {
            this.f4353c = title;
        }
        if (!k.p(id)) {
            this.f4354d = id;
        }
        if (!k.p(category)) {
            this.f4355e = category;
        }
        if (k.p(label)) {
            return;
        }
        this.f4356f = label.replaceAll(",", "/");
    }

    public String a() {
        return this.f4355e;
    }

    public String b() {
        return this.f4356f;
    }

    public String c() {
        return this.f4352b;
    }

    public String d() {
        return this.f4354d;
    }

    public String e() {
        return this.f4353c;
    }

    public String f() {
        return this.f4351a;
    }

    public void g(String contentCategory) {
        this.f4355e = contentCategory;
    }

    public void h(String contentLabel) {
        this.f4356f = contentLabel;
    }

    public void i(String favoriteBooks) {
        this.f4352b = favoriteBooks;
    }

    public void j(String pageId) {
        this.f4354d = pageId;
    }

    public void k(String pageTitle) {
        this.f4353c = pageTitle;
    }

    public void l(String cType) {
        this.f4351a = cType;
    }
}
