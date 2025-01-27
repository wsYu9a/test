package com.aggmoread.sdk.z.b.q;

import android.text.TextUtils;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.g.c;
import com.aggmoread.sdk.z.b.g.e;
import com.aggmoread.sdk.z.b.p.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    static int f4790a = 1;

    /* renamed from: com.aggmoread.sdk.z.b.q.a$a */
    public static class C0088a implements a.g {
        @Override // com.aggmoread.sdk.z.b.p.a.g
        public void a(int i10, byte[] bArr, e eVar) {
            d.a("APIRTAG", "statusCode %s, e %s", Integer.valueOf(i10), eVar);
        }
    }

    public static String a(String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String a10 = a(a(a(str, "__WIDTH__", String.valueOf(cVar.f4473e)), "__HEIGHT__", String.valueOf(cVar.f4474f)), "__UP_X__", String.valueOf(cVar.f4471c));
        int i10 = cVar.f4471c;
        int i11 = cVar.f4473e;
        if (i10 > i11) {
            cVar.f4471c = i11 - 1;
        } else if (i10 < 0) {
            cVar.f4471c = 1;
        }
        String a11 = a(a10, "__UP_Y__", String.valueOf(cVar.f4472d));
        int i12 = cVar.f4472d;
        int i13 = cVar.f4474f;
        if (i12 > i13) {
            cVar.f4472d = i13 - 1;
        } else if (i12 < 0) {
            cVar.f4472d = 1;
        }
        String a12 = a(a(a11, "__CLICK_ID__", String.valueOf(cVar.f4477i)), "__EVENT_TIME_END__", String.valueOf(cVar.f4476h));
        if (Math.abs(cVar.f4469a - cVar.f4471c) > f4790a) {
            cVar.f4469a = cVar.f4471c;
        }
        if (Math.abs(cVar.f4470b - cVar.f4472d) > f4790a) {
            cVar.f4470b = cVar.f4472d;
        }
        return a(a(a(a12, "__DOWN_X__", String.valueOf(cVar.f4469a)), "__DOWN_Y__", String.valueOf(cVar.f4470b)), "__EVENT_TIME_START__", String.valueOf(cVar.f4475g));
    }

    public static final String a(String str, String str2, String str3) {
        return str.contains(str2) ? str.replace(str2, str3) : str;
    }

    public static List<String> a(String str, List<String> list, c cVar) {
        d.c("APIRTAG", "startReport Dsp Api  (" + str + ")");
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                String a10 = a(list.get(i10), cVar);
                if (!TextUtils.isEmpty(a10)) {
                    arrayList.add(a10);
                }
            }
            a(str, arrayList);
        }
        return arrayList;
    }

    public static void a(String str, List<String> list) {
        d.c("APIRTAG", "startReport2 Dsp Api  (" + str + ")");
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str2 = list.get(i10);
            if (!TextUtils.isEmpty(str2)) {
                com.aggmoread.sdk.z.b.p.a.a(str2, null, new C0088a());
            }
        }
    }
}
