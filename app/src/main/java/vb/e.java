package vb;

import android.text.TextUtils;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.abs.Book;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import wb.f;
import wb.g;

/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: b */
    public static final String f31295b = "txs";

    /* renamed from: c */
    public static final String f31296c = "txt";

    /* renamed from: d */
    public static final String f31297d = "dd";

    /* renamed from: e */
    public static final String f31298e = "mht";

    /* renamed from: f */
    public static final String f31299f = "yw";

    /* renamed from: g */
    public static final String f31300g = "tf";

    /* renamed from: a */
    public final Map<String, g> f31301a;

    public e() {
        HashMap hashMap = new HashMap();
        this.f31301a = hashMap;
        m(hashMap);
    }

    public static String a(String str, String str2) {
        return str + hf.e.f26694a + str2;
    }

    public static String b(f fVar) {
        return fVar.getSourceName() + hf.e.f26694a + fVar.getSourceId();
    }

    public static f c(String str, String str2) {
        Source source = new Source();
        source.setSourceName(str);
        source.setSourceId(str2);
        return source;
    }

    public static String d(String str) {
        String[] split = str.split("\\|");
        if (split.length == 1) {
            return split[0];
        }
        if (split.length == 2) {
            return split[1];
        }
        throw new IllegalStateException();
    }

    public static String e(String str) {
        return str.split("\\|")[0];
    }

    public static String f(String str) {
        str.hashCode();
        switch (str) {
            case "tf":
                return "[免费]";
            case "yw":
                return "[阅文]";
            case "txs":
                return "[小淘原创]";
            case "txt":
                return "[TXT]";
            default:
                return "[未知来源]";
        }
    }

    public static String j(String str, String str2) {
        return str + "|" + str2;
    }

    public static String k(f fVar) {
        return j(fVar.getSourceName(), fVar.getSourceId());
    }

    public static f l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\|", 2);
        if (split.length < 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) {
            return null;
        }
        Source source = new Source();
        source.setSourceName(split[0]);
        source.setSourceId(split[1]);
        return source;
    }

    public g g(Book book) {
        return this.f31301a.get(book.getSourceName());
    }

    public g h(String str) {
        return this.f31301a.get(str);
    }

    public Collection<g> i() {
        return this.f31301a.values();
    }

    public abstract void m(Map<String, g> map);
}
