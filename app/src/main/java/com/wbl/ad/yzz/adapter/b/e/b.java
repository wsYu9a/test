package com.wbl.ad.yzz.adapter.b.e;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.adapter.base.loadmore.LoadMoreStatus;
import com.wbl.ad.yzz.adapter.base.viewholder.BaseViewHolder;
import f.b.a.d;

/* loaded from: classes5.dex */
public abstract class b {
    @d
    public abstract View a(@d ViewGroup viewGroup);

    @d
    public abstract View a(@d BaseViewHolder baseViewHolder);

    public final void a(View view, boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15916, this, view, Boolean.valueOf(z));
    }

    public void a(BaseViewHolder baseViewHolder, int i2, LoadMoreStatus loadMoreStatus) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15915, this, baseViewHolder, Integer.valueOf(i2), loadMoreStatus);
    }

    @d
    public abstract View b(@d BaseViewHolder baseViewHolder);

    @d
    public abstract View c(@d BaseViewHolder baseViewHolder);

    @d
    public abstract View d(@d BaseViewHolder baseViewHolder);
}
