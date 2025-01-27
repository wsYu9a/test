package com.martian.mibook.lib.yuewen.e;

import com.martian.mibook.lib.yuewen.request.YWAllCategoryParams;
import com.martian.mibook.lib.yuewen.response.YWFreeType;
import com.martian.mibook.lib.yuewen.response.YWFreeTypeList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class b extends com.martian.mibook.lib.account.d.f<YWAllCategoryParams, YWFreeTypeList> {
    public b() {
        super(YWAllCategoryParams.class, YWFreeTypeList.class);
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: p */
    public boolean onPreDataReceived(YWFreeTypeList ywFreeTypeList) {
        if (ywFreeTypeList == null || ywFreeTypeList.getFreeTypeList() == null) {
            return false;
        }
        Iterator<YWFreeType> it = ywFreeTypeList.getFreeTypeList().iterator();
        while (it.hasNext()) {
            YWFreeType next = it.next();
            if (next == null || next.getCategoryList() == null || next.getCategoryList().size() <= 0) {
                it.remove();
            }
        }
        return super.onPreDataReceived(ywFreeTypeList);
    }
}
