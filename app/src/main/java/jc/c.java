package jc;

import com.martian.mibook.lib.yuewen.request.YWBookDiscountParams;
import com.martian.mibook.lib.yuewen.response.TYDiscountList;

/* loaded from: classes3.dex */
public abstract class c extends jb.d<YWBookDiscountParams, TYDiscountList> {
    public c() {
        super(YWBookDiscountParams.class, TYDiscountList.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(TYDiscountList tYDiscountList) {
        if (tYDiscountList == null || tYDiscountList.getDiscountList() == null) {
            return false;
        }
        return super.onPreDataReceived(tYDiscountList);
    }
}
