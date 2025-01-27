package o6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public final Map<Integer, Integer> f29070a = new HashMap();

    public Integer a(int i10) {
        return this.f29070a.get(Integer.valueOf(i10));
    }

    public int[] b() {
        ArrayList arrayList = new ArrayList();
        int i10 = -1;
        for (Map.Entry<Integer, Integer> entry : this.f29070a.entrySet()) {
            if (entry.getValue().intValue() > i10) {
                i10 = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == i10) {
                arrayList.add(entry.getKey());
            }
        }
        return n6.a.c(arrayList);
    }

    public void c(int i10) {
        Integer num = this.f29070a.get(Integer.valueOf(i10));
        if (num == null) {
            num = 0;
        }
        this.f29070a.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() + 1));
    }
}
