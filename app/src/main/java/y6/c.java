package y6;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class c implements d {
    public static List<b7.d> c(Context context, Intent intent) {
        int i10;
        b7.d a10;
        if (intent == null) {
            return null;
        }
        try {
            i10 = Integer.parseInt(c7.a.a(intent.getStringExtra("type")));
        } catch (Exception e10) {
            c7.e.d("MessageParser--getMessageByIntent--Exception:" + e10.getMessage());
            i10 = 4096;
        }
        c7.e.a("MessageParser--getMessageByIntent--type:" + i10);
        ArrayList arrayList = new ArrayList();
        for (d dVar : x6.b.c0().g0()) {
            if (dVar != null && (a10 = dVar.a(context, i10, intent)) != null) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }

    public abstract b7.d b(Intent intent);
}
