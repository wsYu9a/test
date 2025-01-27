package com.martian.appwall.c.d;

import com.martian.appwall.request.auth.MidongMinaListParams;
import com.martian.appwall.response.MiDongMina;
import com.martian.appwall.response.MiDongMinaList;
import com.martian.libmars.activity.j1;
import com.martian.rpauth.MartianIUserManager;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes2.dex */
public abstract class f extends b<MidongMinaListParams, MiDongMinaList> {
    public f(j1 activity) {
        super(activity, MartianIUserManager.b(), MidongMinaListParams.class, MiDongMinaList.class);
    }

    static /* synthetic */ int r(MiDongMina lhs, MiDongMina rhs) {
        if (lhs == null || rhs == null || lhs.getPrice() == null || rhs.getPrice() == null) {
            return 0;
        }
        return (int) (rhs.getPrice().doubleValue() - lhs.getPrice().doubleValue());
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: s */
    public boolean onPreDataReceived(MiDongMinaList miDongMinaList) {
        if (miDongMinaList == null || miDongMinaList.getMinaList() == null) {
            return false;
        }
        Collections.sort(miDongMinaList.getMinaList(), new Comparator() { // from class: com.martian.appwall.c.d.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return f.r((MiDongMina) obj, (MiDongMina) obj2);
            }
        });
        return super.onPreDataReceived(miDongMinaList);
    }
}
