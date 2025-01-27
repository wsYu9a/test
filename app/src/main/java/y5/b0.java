package y5;

import com.google.zxing.client.result.ParsedResultType;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class b0 extends q {

    /* renamed from: d */
    public static final Pattern f32959d = Pattern.compile(":/*([^/@]+)@[^/]+");

    /* renamed from: b */
    public final String f32960b;

    /* renamed from: c */
    public final String f32961c;

    public b0(String str, String str2) {
        super(ParsedResultType.URI);
        this.f32960b = h(str);
        this.f32961c = str2;
    }

    public static boolean f(String str, int i10) {
        int i11 = i10 + 1;
        int indexOf = str.indexOf(47, i11);
        if (indexOf < 0) {
            indexOf = str.length();
        }
        return t.e(str, i11, indexOf - i11);
    }

    public static String h(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        if (indexOf >= 0 && !f(trim, indexOf)) {
            return trim;
        }
        return "http://" + trim;
    }

    @Override // y5.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(30);
        q.b(this.f32961c, sb2);
        q.b(this.f32960b, sb2);
        return sb2.toString();
    }

    public String d() {
        return this.f32961c;
    }

    public String e() {
        return this.f32960b;
    }

    public boolean g() {
        return f32959d.matcher(this.f32960b).find();
    }
}
