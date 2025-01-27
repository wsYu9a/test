package jc;

import com.martian.mibook.lib.yuewen.request.YWAllCategoryParams;
import com.martian.mibook.lib.yuewen.response.YWFreeType;
import com.martian.mibook.lib.yuewen.response.YWFreeTypeList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class b extends jb.d<YWAllCategoryParams, YWFreeTypeList> {
    public b() {
        super(YWAllCategoryParams.class, YWFreeTypeList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(YWFreeTypeList yWFreeTypeList) {
        if (yWFreeTypeList == null || yWFreeTypeList.getFreeTypeList() == null) {
            return false;
        }
        Iterator<YWFreeType> it = yWFreeTypeList.getFreeTypeList().iterator();
        while (it.hasNext()) {
            YWFreeType next = it.next();
            if (next == null || next.getCategoryList() == null || next.getCategoryList().isEmpty()) {
                it.remove();
            }
        }
        return super.onPreDataReceived(yWFreeTypeList);
    }
}
