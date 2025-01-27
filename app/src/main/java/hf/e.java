package hf;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a */
    public static final String f26694a = "_";

    /* renamed from: b */
    public static final String f26695b = "x";

    public static class a implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.substring(0, str.lastIndexOf(e.f26694a)).compareTo(str2.substring(0, str2.lastIndexOf(e.f26694a)));
        }
    }

    public static Comparator<String> a() {
        return new a();
    }

    public static List<String> b(String str, xe.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : cVar.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static List<Bitmap> c(String str, xe.c cVar) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : cVar.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(cVar.get(str2));
            }
        }
        return arrayList;
    }

    public static String d(String str, af.c cVar) {
        return str + f26694a + cVar.b() + "x" + cVar.a();
    }

    public static void e(String str, xe.c cVar) {
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
