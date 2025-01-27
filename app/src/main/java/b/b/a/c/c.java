package b.b.a.c;

import java.util.ArrayList;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public static final String f4224a = "application/octet-stream;binary/octet-stream";

    /* renamed from: b */
    public Header[] f4225b = null;

    /* renamed from: c */
    public String f4226c = null;

    /* renamed from: d */
    public String f4227d = null;

    private void b(String str) {
        this.f4226c = str;
    }

    private void c(Header[] headerArr) {
        this.f4225b = headerArr;
    }

    private void d(String str) {
        this.f4227d = str;
    }

    private Header[] e() {
        return this.f4225b;
    }

    private String f() {
        return this.f4226c;
    }

    private String g() {
        return this.f4227d;
    }

    private void h() {
        this.f4227d = null;
        this.f4226c = null;
    }

    public final ArrayList<BasicHeader> a() {
        Header[] headerArr = this.f4225b;
        if (headerArr == null || headerArr.length == 0) {
            return null;
        }
        ArrayList<BasicHeader> arrayList = new ArrayList<>();
        for (Header header : this.f4225b) {
            arrayList.add(new BasicHeader(header.getName(), header.getValue()));
        }
        return arrayList;
    }
}
