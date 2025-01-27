package c7;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a */
    public static final String f1743a = "type";

    /* renamed from: b */
    public static final String f1744b = "count";

    /* renamed from: c */
    public static final String f1745c = "list";

    /* renamed from: d */
    public static final int f1746d = 1017;

    public static boolean a(Context context) {
        String e02 = x6.b.e0(context);
        return i.i(context, e02) && i.f(context, e02) >= 1017;
    }

    public static void b(Context context, b7.e eVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(eVar);
        c(context, linkedList);
    }

    public static void c(Context context, List<b7.e> list) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        e.a("isSupportStatisticByMcs:" + a(context) + ",list size:" + linkedList.size());
        if (linkedList.size() <= 0 || !a(context)) {
            return;
        }
        d(context, linkedList);
    }

    public static void d(Context context, List<b7.e> list) {
        try {
            Intent intent = new Intent();
            intent.setAction(x6.b.m0(context));
            intent.setPackage(x6.b.e0(context));
            intent.putExtra("appPackage", context.getPackageName());
            intent.putExtra("type", b7.b.f1310g0);
            intent.putExtra(f1744b, list.size());
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<b7.e> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().p());
            }
            intent.putStringArrayListExtra(f1745c, arrayList);
            context.startService(intent);
        } catch (Exception e10) {
            e.d("statisticMessage--Exception" + e10.getMessage());
        }
    }
}
