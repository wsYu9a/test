package nb;

import android.content.Context;
import android.text.TextUtils;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.manager.BookManager;
import java.util.Hashtable;
import java.util.Map;
import vb.e;
import wb.f;
import xb.b;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    public Map<String, pb.a> f28838a;

    /* renamed from: b */
    public final BookManager f28839b;

    /* renamed from: c */
    public final Context f28840c;

    public a(Context context, BookManager bookManager) {
        this.f28840c = context;
        this.f28839b = bookManager;
        d();
    }

    public void a(String str, b bVar) {
        f e10 = e(str);
        c(e10).v(e10, bVar, false);
    }

    public pb.a b(String str) {
        Map<String, pb.a> map;
        if (TextUtils.isEmpty(str) || (map = this.f28838a) == null || map.isEmpty()) {
            return null;
        }
        return this.f28838a.get(str);
    }

    public pb.a c(f fVar) {
        return b(fVar.getSourceName());
    }

    public void d() {
        this.f28838a = new Hashtable();
        f(new sb.a(this.f28840c, this.f28839b));
    }

    public final f e(String str) {
        return new Source(e.f31296c, str);
    }

    public void f(pb.a aVar) {
        this.f28838a.put(aVar.H(), aVar);
    }
}
