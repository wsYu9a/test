package b.g.a.b;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a */
    private static final String f4919a = "_";

    /* renamed from: b */
    private static final String f4920b = "x";

    static class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.substring(0, str.lastIndexOf(e.f4919a)).compareTo(str2.substring(0, str2.lastIndexOf(e.f4919a)));
        }
    }

    private e() {
    }

    public static Comparator<String> a() {
        return new a();
    }

    public static List<String> b(String str, b.g.a.a.b.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : cVar.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static List<Bitmap> c(String str, b.g.a.a.b.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : cVar.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(cVar.get(str2));
            }
        }
        return arrayList;
    }

    public static String d(String str, com.nostra13.universalimageloader.core.assist.c cVar) {
        return str + f4919a + cVar.b() + f4920b + cVar.a();
    }

    public static void e(String str, b.g.a.a.b.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : cVar.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            cVar.remove((String) it.next());
        }
    }
}
