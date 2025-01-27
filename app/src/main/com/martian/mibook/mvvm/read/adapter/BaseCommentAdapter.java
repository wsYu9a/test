package com.martian.mibook.mvvm.read.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.bm;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.mvvm.read.adapter.BaseCommentAdapter;
import com.martian.mibook.mvvm.read.comment.ItemExpand;
import com.sigmob.sdk.downloader.core.breakpoint.e;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b&\b&\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J=\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0003\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J0\u0010\u0015\u001a\u00020\u00122!\u0010\u0014\u001a\u001d\u0012\b\u0012\u00060\u0002R\u00020\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\nH&¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010\"\u001a\u00020\u00122\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\"\u0010#J#\u0010$\u001a\u00020\u00122\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010'J!\u0010)\u001a\u00020\u00122\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010(H\u0007¢\u0006\u0004\b)\u0010*J\u001f\u0010+\u001a\u00020\u00122\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010(¢\u0006\u0004\b+\u0010*J5\u0010.\u001a\u00020\u00122\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010(2\b\b\u0002\u0010,\u001a\u00020\b2\b\b\u0003\u0010-\u001a\u00020\nH\u0007¢\u0006\u0004\b.\u0010/J\u001d\u00101\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u001002\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b1\u00102J!\u00103\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00122\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b5\u00106R$\u0010<\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010\u001aR$\u0010D\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010K\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010N\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010F\u001a\u0004\bM\u0010H\"\u0004\b0\u0010JR\u0016\u0010P\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010)R3\u0010S\u001a\u001f\u0012\b\u0012\u00060\u0002R\u00020\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0002\b\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR,\u0010Y\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010*R\u0014\u0010[\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010'R8\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010(2\u0010\u0010\\\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010(8F@GX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010W\"\u0004\b^\u0010*R4\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u000e\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b_\u0010W\"\u0004\b`\u0010*¨\u0006c"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "<init>", "()V", "", "", "models", "", "expand", "", "depth", bt.aO, "(Ljava/util/List;Ljava/lang/Boolean;I)Ljava/util/List;", c.f26972i, "v", "(I)Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", e.f19025e, "H", "(Lkotlin/jvm/functions/Function2;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Landroid/view/ViewGroup;", "parent", "viewType", "G", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "holder", "payloads", "F", "(Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;ILjava/util/List;)V", ExifInterface.LONGITUDE_EAST, "(Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;I)V", "getItemCount", "()I", "", "I", "(Ljava/util/List;)V", "n", "animation", "index", "o", "(Ljava/util/List;ZI)V", "M", "x", "(I)Ljava/lang/Object;", t.f11211k, "(II)I", "J", "(I)V", "c", "Landroidx/recyclerview/widget/RecyclerView;", "C", "()Landroidx/recyclerview/widget/RecyclerView;", "Q", "rv", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "L", "(Landroid/content/Context;)V", f.X, com.kwad.sdk.m.e.TAG, "Z", "D", "()Z", "R", "(Z)V", "singleExpandMode", "f", IAdInterListener.AdReqParam.WIDTH, "expandAnimationEnabled", "g", "previousExpandPosition", "h", "Lkotlin/jvm/functions/Function2;", "onExpand", "i", "Ljava/util/List;", "y", "()Ljava/util/List;", "N", "mDataList", bt.aJ, "modelCount", "value", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "B", "P", "mutable", "BaseCommentViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBaseCommentAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseCommentAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,419:1\n1#2:420\n1855#3:421\n1747#3,3:422\n1856#3:425\n*S KotlinDebug\n*F\n+ 1 BaseCommentAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter\n*L\n191#1:421\n192#1:422,3\n191#1:425\n*E\n"})
/* loaded from: classes3.dex */
public abstract class BaseCommentAdapter extends RecyclerView.Adapter<BaseCommentViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public RecyclerView rv;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public Context com.umeng.analytics.pro.f.X java.lang.String;

    /* renamed from: e */
    public boolean singleExpandMode;

    /* renamed from: f, reason: from kotlin metadata */
    public boolean expandAnimationEnabled = true;

    /* renamed from: g, reason: from kotlin metadata */
    public int previousExpandPosition = -1;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public Function2<? super BaseCommentViewHolder, ? super Boolean, Unit> onExpand;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public List<Object> mDataList;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b¦\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000e\u0010\rJ/\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0003\u0010\u0019\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u000f2\b\b\u0003\u0010\u0019\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0003\u0010\u0019\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001bJ\r\u0010\u001f\u001a\u00020\u000f¢\u0006\u0004\b\u001f\u0010\u0016J\u0013\u0010!\u001a\b\u0018\u00010\u0000R\u00020 ¢\u0006\u0004\b!\u0010\"R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0017\u0010-\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R$\u00103\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010/\u001a\u0004\b1\u0010\b\"\u0004\b2\u0010\r¨\u00064"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/viewbinding/ViewBinding;", "viewBinding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter;Landroidx/viewbinding/ViewBinding;)V", "M", "m", "()Ljava/lang/Object;", "", bm.f6904i, "", "b", "(Ljava/lang/Object;)V", "a", "", c.f26972i, "", "payloads", "o", "(ILjava/util/List;Ljava/lang/Object;)V", t.f11204d, "()I", "", "scrollTop", "depth", com.kwad.sdk.m.e.TAG, "(ZI)I", "c", "(I)I", "g", "i", "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter;", "j", "()Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter$BaseCommentViewHolder;", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "p", "(Landroid/content/Context;)V", f.X, "Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter;", "k", "()Lcom/martian/mibook/mvvm/read/adapter/BaseCommentAdapter;", "adapter", "d", "Ljava/lang/Object;", "_data", "n", "q", TTDownloadField.TT_TAG, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public abstract class BaseCommentViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final BaseCommentAdapter adapter;

        /* renamed from: d, reason: from kotlin metadata */
        @l
        public Object _data;

        /* renamed from: e */
        @l
        public Object tag;

        /* renamed from: f */
        public final /* synthetic */ BaseCommentAdapter f14385f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseCommentViewHolder(@k BaseCommentAdapter baseCommentAdapter, ViewBinding viewBinding) {
            super(viewBinding.getRoot());
            Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
            this.f14385f = baseCommentAdapter;
            Context context = baseCommentAdapter.getCom.umeng.analytics.pro.f.X java.lang.String();
            Intrinsics.checkNotNull(context);
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            this.adapter = baseCommentAdapter;
        }

        public static /* synthetic */ int d(BaseCommentViewHolder baseCommentViewHolder, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
            }
            if ((i11 & 1) != 0) {
                i10 = 0;
            }
            return baseCommentViewHolder.c(i10);
        }

        public static /* synthetic */ int f(BaseCommentViewHolder baseCommentViewHolder, boolean z10, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
            }
            if ((i11 & 1) != 0) {
                z10 = false;
            }
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return baseCommentViewHolder.e(z10, i10);
        }

        public static /* synthetic */ int h(BaseCommentViewHolder baseCommentViewHolder, boolean z10, int i10, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandOrCollapse");
            }
            if ((i11 & 1) != 0) {
                z10 = false;
            }
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return baseCommentViewHolder.g(z10, i10);
        }

        public abstract void a(@l Object r12);

        public final void b(@l Object r12) {
            this._data = r12;
            a(r12);
        }

        @SuppressLint({"NotifyDataSetChanged"})
        public final int c(@IntRange(from = -1) int depth) {
            ItemExpand itemExpand = (ItemExpand) m();
            if (itemExpand == null || !itemExpand.getIsExpand()) {
                return 0;
            }
            int l10 = l();
            Function2 function2 = this.f14385f.onExpand;
            if (function2 != null) {
                function2.invoke(this, Boolean.FALSE);
            }
            List<Object> itemSublist = itemExpand.getItemSublist();
            itemExpand.setExpand(false);
            List<Object> list = itemSublist;
            if (list == null || list.isEmpty()) {
                this.f14385f.notifyItemChanged(l10, itemExpand);
                return 0;
            }
            List t10 = this.f14385f.t(new ArrayList(list), Boolean.FALSE, depth);
            List<Object> A = this.f14385f.A();
            Intrinsics.checkNotNull(A, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
            int i10 = l10 + 1;
            TypeIntrinsics.asMutableList(A).subList(i10, t10.size() + i10).clear();
            if (this.f14385f.getExpandAnimationEnabled()) {
                this.f14385f.notifyItemChanged(l10, itemExpand);
                this.f14385f.notifyItemRangeRemoved(i10, t10.size());
            } else {
                this.f14385f.notifyDataSetChanged();
            }
            return t10.size();
        }

        @SuppressLint({"NotifyDataSetChanged"})
        public final int e(boolean z10, @IntRange(from = -1) int i10) {
            RecyclerView rv;
            ItemExpand itemExpand = (ItemExpand) m();
            if (itemExpand == null || itemExpand.getIsExpand()) {
                return 0;
            }
            int l10 = l();
            if (this.f14385f.getSingleExpandMode() && this.f14385f.previousExpandPosition != -1 && i() != this.f14385f.previousExpandPosition) {
                int s10 = BaseCommentAdapter.s(this.adapter, this.f14385f.previousExpandPosition, 0, 2, null);
                if (l10 > this.f14385f.previousExpandPosition) {
                    l10 -= s10;
                }
            }
            Function2 function2 = this.f14385f.onExpand;
            if (function2 != null) {
                function2.invoke(this, Boolean.TRUE);
            }
            List<Object> itemSublist = itemExpand.getItemSublist();
            itemExpand.setExpand(true);
            this.f14385f.previousExpandPosition = l10;
            List<Object> list = itemSublist;
            if (list == null || list.isEmpty()) {
                this.f14385f.notifyItemChanged(l10);
                return 0;
            }
            List t10 = this.f14385f.t(new ArrayList(list), Boolean.TRUE, i10);
            List<Object> A = this.f14385f.A();
            Intrinsics.checkNotNull(A, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
            int i11 = l10 + 1;
            TypeIntrinsics.asMutableList(A).addAll(i11, t10);
            if (this.f14385f.getExpandAnimationEnabled()) {
                this.f14385f.notifyItemChanged(l10);
                this.f14385f.notifyItemRangeInserted(i11, t10.size());
            } else {
                this.f14385f.notifyDataSetChanged();
            }
            if (z10 && (rv = this.f14385f.getRv()) != null) {
                rv.scrollToPosition(l10);
                RecyclerView.LayoutManager layoutManager = rv.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager != null) {
                    linearLayoutManager.scrollToPositionWithOffset(l10, 0);
                }
            }
            return t10.size();
        }

        public final int g(boolean scrollTop, @IntRange(from = -1) int depth) {
            ItemExpand itemExpand = (ItemExpand) m();
            if (itemExpand != null) {
                return itemExpand.getIsExpand() ? c(depth) : e(scrollTop, depth);
            }
            return 0;
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }

        public final int i() {
            List<Object> A;
            Object orNull;
            List<Object> itemSublist;
            for (int l10 = l() - 1; -1 < l10 && (A = this.f14385f.A()) != null && (orNull = CollectionsKt.getOrNull(A, l10)) != null; l10--) {
                if ((orNull instanceof ItemExpand) && (itemSublist = ((ItemExpand) orNull).getItemSublist()) != null && itemSublist.contains(this._data)) {
                    return l10;
                }
            }
            return -1;
        }

        @l
        public final BaseCommentViewHolder j() {
            RecyclerView rv = this.f14385f.getRv();
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = rv != null ? rv.findViewHolderForLayoutPosition(i()) : null;
            if (findViewHolderForLayoutPosition instanceof BaseCommentViewHolder) {
                return (BaseCommentViewHolder) findViewHolderForLayoutPosition;
            }
            return null;
        }

        @k
        /* renamed from: k, reason: from getter */
        public final BaseCommentAdapter getAdapter() {
            return this.adapter;
        }

        public final int l() {
            return getBindingAdapterPosition() == -1 ? getLayoutPosition() : getBindingAdapterPosition();
        }

        @l
        public final <M> M m() {
            M m10 = (M) this._data;
            if (m10 == null) {
                return null;
            }
            return m10;
        }

        @l
        /* renamed from: n, reason: from getter */
        public final Object getTag() {
            return this.tag;
        }

        public abstract void o(int r12, @k List<Object> payloads, @l Object r32);

        public final void p(@k Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
        }

        public final void q(@l Object obj) {
            this.tag = obj;
        }
    }

    public static /* synthetic */ void K(BaseCommentAdapter baseCommentAdapter, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollTop");
        }
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        baseCommentAdapter.J(i10);
    }

    public static /* synthetic */ void p(BaseCommentAdapter baseCommentAdapter, List list, boolean z10, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addModels");
        }
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        if ((i11 & 4) != 0) {
            i10 = -1;
        }
        baseCommentAdapter.o(list, z10, i10);
    }

    public static final void q(BaseCommentAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.rv;
        if (recyclerView != null) {
            recyclerView.invalidateItemDecorations();
        }
    }

    public static /* synthetic */ int s(BaseCommentAdapter baseCommentAdapter, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return baseCommentAdapter.r(i10, i11);
    }

    public static /* synthetic */ List u(BaseCommentAdapter baseCommentAdapter, List list, Boolean bool, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flat");
        }
        if ((i11 & 2) != 0) {
            bool = null;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return baseCommentAdapter.t(list, bool, i10);
    }

    @l
    public final List<Object> A() {
        return this.mDataList;
    }

    @k
    public final List<Object> B() {
        if (this.mDataList == null) {
            this.mDataList = new ArrayList();
        }
        List<Object> list = this.mDataList;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>");
        return (ArrayList) list;
    }

    @l
    /* renamed from: C, reason: from getter */
    public final RecyclerView getRv() {
        return this.rv;
    }

    /* renamed from: D, reason: from getter */
    public final boolean getSingleExpandMode() {
        return this.singleExpandMode;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: E */
    public void onBindViewHolder(@k BaseCommentViewHolder holder, int i10) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.b(x(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: F */
    public void onBindViewHolder(@k BaseCommentViewHolder holder, int r32, @k List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.isEmpty()) {
            holder.o(r32, payloads, x(r32));
        } else {
            onBindViewHolder(holder, r32);
        }
    }

    @k
    /* renamed from: G */
    public abstract BaseCommentViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType);

    public final void H(@k Function2<? super BaseCommentViewHolder, ? super Boolean, Unit> r22) {
        Intrinsics.checkNotNullParameter(r22, "block");
        this.onExpand = r22;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void I(@l List<? extends Object> models) {
        List<? extends Object> list = models;
        List mutableList = (list == null || list.isEmpty()) ? null : CollectionsKt.toMutableList((Collection) list);
        if (A() != null && TypeIntrinsics.isMutableList(A())) {
            List<Object> A = A();
            Intrinsics.checkNotNull(A, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
            TypeIntrinsics.asMutableList(A).clear();
        }
        if (mutableList != null) {
            List<Object> A2 = A();
            List<Object> list2 = TypeIntrinsics.isMutableList(A2) ? A2 : null;
            if (list2 != null) {
                list2.addAll(u(this, mutableList, null, 0, 6, null));
            }
        }
        notifyDataSetChanged();
    }

    public final void J(int r32) {
        RecyclerView recyclerView = this.rv;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(r32);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager != null) {
                linearLayoutManager.scrollToPositionWithOffset(r32, 0);
            }
        }
    }

    public final void L(@l Context context) {
        this.com.umeng.analytics.pro.f.X java.lang.String = context;
    }

    public final void M(boolean z10) {
        this.expandAnimationEnabled = z10;
    }

    public final void N(@l List<Object> list) {
        this.mDataList = list;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void O(@l List<? extends Object> list) {
        this.mDataList = list instanceof ArrayList ? u(this, list, null, 0, 6, null) : list != null ? u(this, CollectionsKt.toMutableList((Collection) list), null, 0, 6, null) : null;
        notifyDataSetChanged();
    }

    public final void P(@k List<Object> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        O(value);
    }

    public final void Q(@l RecyclerView recyclerView) {
        this.rv = recyclerView;
    }

    public final void R(boolean z10) {
        this.singleExpandMode = z10;
    }

    @l
    /* renamed from: getContext, reason: from getter */
    public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
        return this.com.umeng.analytics.pro.f.X java.lang.String;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return z();
    }

    public final void n(@l List<? extends Object> models) {
        o(models, true, -1);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void o(@l List<? extends Object> models, boolean animation, @IntRange(from = -1) int index) {
        List<? extends Object> list = models;
        if (list == null || list.isEmpty()) {
            return;
        }
        List mutableList = CollectionsKt.toMutableList((Collection) list);
        if (A() == null) {
            O(u(this, mutableList, null, 0, 6, null));
            notifyDataSetChanged();
            return;
        }
        List<Object> A = A();
        if (A != null && A.isEmpty()) {
            List<Object> A2 = A();
            if (!TypeIntrinsics.isMutableList(A2)) {
                A2 = null;
            }
            if (A2 != null) {
                A2.addAll(u(this, mutableList, null, 0, 6, null));
                notifyDataSetChanged();
                return;
            }
            return;
        }
        List<Object> A3 = A();
        Intrinsics.checkNotNull(A3, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any?>");
        List asMutableList = TypeIntrinsics.asMutableList(A3);
        if (index == -1 || asMutableList.size() < index) {
            index = asMutableList.size();
            asMutableList.addAll(u(this, mutableList, null, 0, 6, null));
        } else {
            asMutableList.addAll(index, u(this, mutableList, null, 0, 6, null));
        }
        if (!animation) {
            notifyDataSetChanged();
            return;
        }
        notifyItemRangeInserted(index, mutableList.size());
        RecyclerView recyclerView = this.rv;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: cd.a
                public /* synthetic */ a() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    BaseCommentAdapter.q(BaseCommentAdapter.this);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@k RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.rv = recyclerView;
        if (this.com.umeng.analytics.pro.f.X java.lang.String == null) {
            this.com.umeng.analytics.pro.f.X java.lang.String = recyclerView.getContext();
        }
    }

    public final int r(@IntRange(from = 0) int i10, @IntRange(from = -1) int i11) {
        BaseCommentViewHolder v10 = v(i10);
        if (v10 == null) {
            return 0;
        }
        return v10.c(i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<java.lang.Object> t(java.util.List<java.lang.Object> r10, java.lang.Boolean r11, @androidx.annotation.IntRange(from = -1) int r12) {
        /*
            r9 = this;
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L7
            return r10
        L7:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r10
            java.util.Collection r1 = (java.util.Collection) r1
            r0.<init>(r1)
            r10.clear()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r2 = 0
            r3 = r2
            r4 = 0
        L1a:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto Lba
            java.lang.Object r5 = r0.next()
            if (r3 == 0) goto L48
            r6 = r10
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r7 = r6 instanceof java.util.Collection
            if (r7 == 0) goto L37
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L37
            goto L48
        L37:
            java.util.Iterator r6 = r6.iterator()
        L3b:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L48
            java.lang.Object r7 = r6.next()
            if (r5 != r7) goto L3b
            goto L1a
        L48:
            r10.add(r5)
            boolean r3 = r5 instanceof com.martian.mibook.mvvm.read.comment.ItemExpand
            if (r3 == 0) goto Lb5
            com.martian.mibook.mvvm.read.comment.ItemExpand r5 = (com.martian.mibook.mvvm.read.comment.ItemExpand) r5
            r5.setItemGroupPosition(r4)
            if (r11 == 0) goto L64
            if (r12 == 0) goto L64
            boolean r3 = r11.booleanValue()
            r5.setExpand(r3)
            if (r12 <= 0) goto L64
            int r3 = r12 + (-1)
            goto L65
        L64:
            r3 = r12
        L65:
            java.util.List r6 = r5.getItemSublist()
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            if (r7 == 0) goto L90
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L75
            goto L90
        L75:
            boolean r5 = r5.getIsExpand()
            if (r5 != 0) goto L7f
            if (r12 == 0) goto Lb3
            if (r11 == 0) goto Lb3
        L7f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            java.util.List r5 = kotlin.collections.CollectionsKt.toMutableList(r7)
            java.util.List r3 = r9.t(r5, r11, r3)
            java.util.Collection r3 = (java.util.Collection) r3
            r10.addAll(r3)
            goto Lb3
        L90:
            boolean r3 = r5.getIsExpand()
            if (r3 != 0) goto Lb3
            if (r12 != 0) goto Lb3
            r3 = 1
            r5.setExpand(r3)
            java.util.List r3 = r5.addDefaultExpandItemSubList()
            if (r3 == 0) goto Lb3
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.List r3 = kotlin.collections.CollectionsKt.toMutableList(r3)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            java.util.List r3 = r9.t(r3, r5, r1)
            java.util.Collection r3 = (java.util.Collection) r3
            r10.addAll(r3)
        Lb3:
            r3 = r6
            goto Lb6
        Lb5:
            r3 = r2
        Lb6:
            int r4 = r4 + 1
            goto L1a
        Lba:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.adapter.BaseCommentAdapter.t(java.util.List, java.lang.Boolean, int):java.util.List");
    }

    public final BaseCommentViewHolder v(int r52) {
        RecyclerView recyclerView = this.rv;
        BaseCommentViewHolder baseCommentViewHolder = null;
        if (recyclerView == null) {
            return null;
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(r52);
        BaseCommentViewHolder baseCommentViewHolder2 = findViewHolderForLayoutPosition instanceof BaseCommentViewHolder ? (BaseCommentViewHolder) findViewHolderForLayoutPosition : null;
        if (baseCommentViewHolder2 != null) {
            return baseCommentViewHolder2;
        }
        try {
            RecyclerView.ViewHolder createViewHolder = createViewHolder(recyclerView, getItemViewType(r52));
            Intrinsics.checkNotNullExpressionValue(createViewHolder, "createViewHolder(...)");
            BaseCommentViewHolder baseCommentViewHolder3 = (BaseCommentViewHolder) createViewHolder;
            bindViewHolder(baseCommentViewHolder3, r52);
            baseCommentViewHolder = baseCommentViewHolder3;
        } catch (Exception unused) {
        }
        return baseCommentViewHolder;
    }

    /* renamed from: w, reason: from getter */
    public final boolean getExpandAnimationEnabled() {
        return this.expandAnimationEnabled;
    }

    @l
    public final <M> M x(int r32) {
        M m10;
        List<Object> A = A();
        if (A == null || (m10 = (M) CollectionsKt.getOrNull(A, r32)) == null) {
            return null;
        }
        return m10;
    }

    @l
    public final List<Object> y() {
        return this.mDataList;
    }

    public final int z() {
        List<Object> A = A();
        if (A != null) {
            return A.size();
        }
        return 0;
    }
}
