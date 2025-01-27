package b.h.a.h;

import android.text.TextUtils;
import b.h.a.c;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public final class c implements d {

    /* renamed from: a */
    private final b.h.a.a.b f4998a;

    public c(b.h.a.a.b bVar) {
        this.f4998a = bVar;
    }

    private static String d(String str) {
        long j2;
        try {
            j2 = Long.parseLong(str);
        } catch (Throwable unused) {
            j2 = 0;
        }
        return new DecimalFormat("##.##").format(j2 / 1048576.0f);
    }

    private static String e(c.d dVar) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(dVar.f4950c)) {
            sb.append(dVar.f4950c);
            sb.append("|");
        }
        sb.append(f(dVar));
        sb.append(dVar.f4949b);
        return sb.toString();
    }

    private static String f(c.d dVar) {
        String str;
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> hashMap = dVar.f4953f;
        if (hashMap != null) {
            Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String str2 = null;
                try {
                    str = next.getKey();
                    try {
                        str2 = next.getValue();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if ("RAMSize".equals(str)) {
                        str2 = d(str2) + "GB";
                    }
                    if ("InternalFreeSpace".equals(str)) {
                        str2 = d(str2) + "GB";
                    }
                    sb.append(str);
                    sb.append(":");
                    sb.append(str2);
                    if (it.hasNext()) {
                        sb.append(", ");
                    }
                }
            }
            sb.append("|");
        }
        return sb.toString();
    }

    @Override // b.h.a.h.d
    public final void a(c.d dVar) {
        b.h.a.a.b bVar = this.f4998a;
        if (bVar == null || !(dVar.f4949b instanceof String)) {
            return;
        }
        bVar.a(dVar.f4952e, e(dVar), dVar.f4951d, c());
    }

    @Override // b.h.a.h.d
    public final void b(c.d dVar) {
        b.h.a.a.b bVar = this.f4998a;
        if (bVar == null || !(dVar.f4949b instanceof String)) {
            return;
        }
        bVar.a(dVar.f4952e, e(dVar), dVar.f4951d, c());
    }

    public final int c() {
        return 104;
    }
}
