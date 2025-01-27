package com.martian.libmars.widget.linkage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.widget.linkage.BaseQuickLinkageAdapter;
import com.umeng.analytics.pro.bt;
import id.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002./B\u0019\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0015\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R*\u0010'\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r8\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0015R\u0018\u0010*\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/martian/libmars/widget/linkage/BaseLinkageItem;", "mDataList", "<init>", "(Ljava/util/List;)V", "newData", "", "q", "n", "()Ljava/util/List;", "", c.f26972i, "o", "(I)Lcom/martian/libmars/widget/linkage/BaseLinkageItem;", "getItemCount", "()I", "index", "u", "(I)V", "viewHolder", "k", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter$a;", "listener", t.f11211k, "(Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter$a;)V", "Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter$b;", "s", "(Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter$b;)V", "c", "Ljava/util/List;", "<set-?>", "d", "I", "p", bt.aO, "selectedPosition", e.TAG, "Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter$a;", TTDownloadField.TT_ITEM_CLICK_LISTENER, "f", "Lcom/martian/libmars/widget/linkage/BaseQuickLinkageAdapter$b;", "itemLongClickListener", "a", "b", "libmars_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public abstract class BaseQuickLinkageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public List<? extends BaseLinkageItem> mDataList;

    /* renamed from: d, reason: from kotlin metadata */
    public int selectedPosition;

    /* renamed from: e */
    @l
    public a itemClickListener;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public b itemLongClickListener;

    public interface a {
        void a(@l BaseLinkageItem baseLinkageItem, int i10);
    }

    public interface b {
        boolean a(@l View view, int i10);
    }

    public BaseQuickLinkageAdapter() {
        this(null, 1, null);
    }

    public static final void l(BaseQuickLinkageAdapter this$0, int i10, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.itemClickListener;
        Intrinsics.checkNotNull(aVar);
        aVar.a(this$0.o(i10), i10);
    }

    public static final boolean m(BaseQuickLinkageAdapter this$0, int i10, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.itemLongClickListener;
        Intrinsics.checkNotNull(bVar);
        return bVar.a(view, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.mDataList.size();
    }

    public final void k(@k RecyclerView.ViewHolder viewHolder, int r42) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (r42 != -1) {
            if (this.itemClickListener != null) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: p9.a

                    /* renamed from: c */
                    public final /* synthetic */ int f29855c;

                    public /* synthetic */ a(int r422) {
                        position = r422;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaseQuickLinkageAdapter.l(BaseQuickLinkageAdapter.this, position, view);
                    }
                });
            }
            if (this.itemLongClickListener != null) {
                viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: p9.b

                    /* renamed from: c */
                    public final /* synthetic */ int f29857c;

                    public /* synthetic */ b(int r422) {
                        position = r422;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean m10;
                        m10 = BaseQuickLinkageAdapter.m(BaseQuickLinkageAdapter.this, position, view);
                        return m10;
                    }
                });
            }
        }
    }

    @k
    public final List<? extends BaseLinkageItem> n() {
        return this.mDataList;
    }

    @k
    public final BaseLinkageItem o(int r22) {
        return this.mDataList.get(r22);
    }

    /* renamed from: p, reason: from getter */
    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void q(@l List<BaseLinkageItem> newData) {
        if (newData == null) {
            newData = new ArrayList<>();
        }
        this.mDataList = newData;
        notifyDataSetChanged();
    }

    public final void r(@k a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.itemClickListener = listener;
    }

    public final void s(@l b listener) {
        this.itemLongClickListener = listener;
    }

    public final void t(int i10) {
        this.selectedPosition = i10;
    }

    public final void u(int index) {
        this.selectedPosition = index;
        notifyDataSetChanged();
    }

    public BaseQuickLinkageAdapter(@k List<? extends BaseLinkageItem> mDataList) {
        Intrinsics.checkNotNullParameter(mDataList, "mDataList");
        this.mDataList = mDataList;
    }

    public /* synthetic */ BaseQuickLinkageAdapter(List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new ArrayList() : list);
    }
}
