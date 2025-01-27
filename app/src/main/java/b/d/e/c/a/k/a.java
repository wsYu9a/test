package b.d.e.c.a.k;

import android.text.TextUtils;
import b.d.e.c.a.d;
import b.d.e.c.a.f.c;
import b.d.e.c.a.f.e;
import b.d.e.c.a.j.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    static final String f4667a = "a";

    /* renamed from: b */
    static int f4668b = 1;

    /* renamed from: b.d.e.c.a.k.a$a */
    static class C0030a implements a.g {
        C0030a() {
        }

        @Override // b.d.e.c.a.j.a.g
        public void a(int i2, byte[] bArr, e eVar) {
            d.f(a.f4667a, "statusCode %s, e %s", Integer.valueOf(i2), eVar);
        }
    }

    public static String a(String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String b2 = b(b(b(str, "__WIDTH__", String.valueOf(cVar.f4589e)), "__HEIGHT__", String.valueOf(cVar.f4590f)), "__UP_X__", String.valueOf(cVar.f4587c));
        int i2 = cVar.f4587c;
        int i3 = cVar.f4589e;
        if (i2 > i3) {
            cVar.f4587c = i3 - 1;
        } else if (i2 < 0) {
            cVar.f4587c = 1;
        }
        String b3 = b(b2, "__UP_Y__", String.valueOf(cVar.f4588d));
        int i4 = cVar.f4588d;
        int i5 = cVar.f4590f;
        if (i4 > i5) {
            cVar.f4588d = i5 - 1;
        } else if (i4 < 0) {
            cVar.f4588d = 1;
        }
        String b4 = b(b(b3, "__CLICK_ID__", String.valueOf(cVar.f4593i)), "__EVENT_TIME_END__", String.valueOf(cVar.f4592h));
        if (Math.abs(cVar.f4585a - cVar.f4587c) > f4668b) {
            cVar.f4585a = cVar.f4587c;
        }
        if (Math.abs(cVar.f4586b - cVar.f4588d) > f4668b) {
            cVar.f4586b = cVar.f4588d;
        }
        return b(b(b(b4, "__DOWN_X__", String.valueOf(cVar.f4585a)), "__DOWN_Y__", String.valueOf(cVar.f4586b)), "__EVENT_TIME_START__", String.valueOf(cVar.f4591g));
    }

    public static final String b(String str, String str2, String str3) {
        return str.contains(str2) ? str.replace(str2, str3) : str;
    }

    public static List<String> c(String str, List<String> list, c cVar) {
        d.k(f4667a, "startReport Dsp Api  (" + str + ")");
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                String a2 = a(list.get(i2), cVar);
                if (!TextUtils.isEmpty(a2)) {
                    arrayList.add(a2);
                }
            }
            d(str, arrayList);
        }
        return arrayList;
    }

    public static void d(String str, List<String> list) {
        d.k(f4667a, "startReport2 Dsp Api  (" + str + ")");
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = list.get(i2);
            if (!TextUtils.isEmpty(str2)) {
                b.d.e.c.a.j.a.b(str2, null, new C0030a());
            }
        }
    }
}
