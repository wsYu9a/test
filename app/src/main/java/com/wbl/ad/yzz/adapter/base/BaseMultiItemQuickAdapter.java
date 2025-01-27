package com.wbl.ad.yzz.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.martian.mibook.application.MiConfigSingleton;
import com.wbl.ad.yzz.adapter.b.c.a;
import com.wbl.ad.yzz.adapter.base.viewholder.BaseViewHolder;
import f.b.a.e;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0019\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\b\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\rR\u001d\u0010\u0013\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/wbl/ad/yzz/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/wbl/ad/yzz/adapter/b/c/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "VH", "Lcom/wbl/ad/yzz/adapter/base/BaseQuickAdapter;", "", "position", "b", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "(Landroid/view/ViewGroup;I)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "Landroid/util/SparseIntArray;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/Lazy;", "p", "()Landroid/util/SparseIntArray;", "layouts", "", MiConfigSingleton.t0, "<init>", "(Ljava/util/List;)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public abstract class BaseMultiItemQuickAdapter<T extends a, VH extends BaseViewHolder> extends BaseQuickAdapter<T, VH> {

    /* renamed from: A */
    public final Lazy layouts;

    public BaseMultiItemQuickAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ BaseMultiItemQuickAdapter(List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : list);
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public int b(int position) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15968, this, Integer.valueOf(position));
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter
    public VH b(ViewGroup parent, int viewType) {
        return (VH) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15967, this, parent, Integer.valueOf(viewType));
    }

    @Override // com.wbl.ad.yzz.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15962, this, viewHolder);
    }

    public final SparseIntArray p() {
        return (SparseIntArray) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15961, this, null);
    }

    public BaseMultiItemQuickAdapter(@e List<T> list) {
        super(0, list);
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SparseIntArray>() { // from class: com.wbl.ad.yzz.adapter.base.BaseMultiItemQuickAdapter$layouts$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SparseIntArray invoke() {
                return (SparseIntArray) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15904, this, null);
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [android.util.SparseIntArray, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ SparseIntArray invoke() {
                return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15903, this, null);
            }
        });
        this.layouts = lazy;
    }
}
