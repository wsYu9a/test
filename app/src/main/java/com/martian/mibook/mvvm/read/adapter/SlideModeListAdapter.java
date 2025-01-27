package com.martian.mibook.mvvm.read.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReaderThemeManager;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.databinding.ItemSlideModeBinding;
import com.martian.mibook.mvvm.read.adapter.SlideModeListAdapter;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0012\u001a\u00020\u00072\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/SlideModeListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/read/adapter/SlideModeListAdapter$SlideModeViewHolder;", "<init>", "()V", "Lcom/martian/mibook/mvvm/read/adapter/SlideModeListAdapter$a;", "onItemClickListener", "", "m", "(Lcom/martian/mibook/mvvm/read/adapter/SlideModeListAdapter$a;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", t.f11204d, "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/SlideModeListAdapter$SlideModeViewHolder;", "holder", c.f26972i, "k", "(Lcom/martian/mibook/mvvm/read/adapter/SlideModeListAdapter$SlideModeViewHolder;I)V", "getItemCount", "()I", "c", "Lcom/martian/mibook/mvvm/read/adapter/SlideModeListAdapter$a;", "mOnItemClickListener", "", "Lcom/martian/mibook/application/ReadingInstance$SlideMode;", "d", "Ljava/util/List;", "slideModeList", "a", "SlideModeViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class SlideModeListAdapter extends RecyclerView.Adapter<SlideModeViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public a mOnItemClickListener;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final List<ReadingInstance.SlideMode> slideModeList = CollectionsKt.arrayListOf(ReadingInstance.SlideMode.OVERLAPPED_SLIDER, ReadingInstance.SlideMode.SIM_SLIDER, ReadingInstance.SlideMode.PAGER_SLIDER, ReadingInstance.SlideMode.SCROLL_SLIDER, ReadingInstance.SlideMode.STATIC_SLIDER);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/SlideModeListAdapter$SlideModeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemSlideModeBinding;", "slideModeBinding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/SlideModeListAdapter;Lcom/martian/mibook/databinding/ItemSlideModeBinding;)V", "Lcom/martian/mibook/application/ReadingInstance$SlideMode;", "slideMode", "", "c", "(Lcom/martian/mibook/application/ReadingInstance$SlideMode;)V", "b", "Lcom/martian/mibook/databinding/ItemSlideModeBinding;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class SlideModeViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemSlideModeBinding slideModeBinding;

        /* renamed from: c, reason: from kotlin metadata */
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ SlideModeListAdapter f14565d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SlideModeViewHolder(@k SlideModeListAdapter slideModeListAdapter, ItemSlideModeBinding slideModeBinding) {
            super(slideModeBinding.getRoot());
            Intrinsics.checkNotNullParameter(slideModeBinding, "slideModeBinding");
            this.f14565d = slideModeListAdapter;
            this.slideModeBinding = slideModeBinding;
            this.com.umeng.analytics.pro.f.X java.lang.String = slideModeBinding.getRoot().getContext();
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cd.c2

                /* renamed from: c */
                public final /* synthetic */ SlideModeListAdapter.SlideModeViewHolder f1790c;

                public /* synthetic */ c2(SlideModeListAdapter.SlideModeViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SlideModeListAdapter.SlideModeViewHolder.b(SlideModeListAdapter.this, this, view);
                }
            });
        }

        public static final void b(SlideModeListAdapter this$0, SlideModeViewHolder this$1, View view) {
            int bindingAdapterPosition;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.mOnItemClickListener == null || (bindingAdapterPosition = this$1.getBindingAdapterPosition()) >= this$0.slideModeList.size() || bindingAdapterPosition < 0) {
                return;
            }
            ReadingInstance.SlideMode slideMode = (ReadingInstance.SlideMode) this$0.slideModeList.get(bindingAdapterPosition);
            a aVar = this$0.mOnItemClickListener;
            if (aVar != null) {
                aVar.a(view, bindingAdapterPosition, slideMode);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public final void c(@k ReadingInstance.SlideMode slideMode) {
            Intrinsics.checkNotNullParameter(slideMode, "slideMode");
            this.slideModeBinding.tvModeName.setText(ReadingInstance.z().F(this.com.umeng.analytics.pro.f.X java.lang.String, slideMode.getSlideMode()));
            if (slideMode.getSlideMode() == 0) {
                this.slideModeBinding.ivMode.setImageResource(R.drawable.icon_pager_slider);
            } else if (slideMode.getSlideMode() == 1) {
                this.slideModeBinding.ivMode.setImageResource(R.drawable.icon_overlapped_slider);
            } else if (slideMode.getSlideMode() == 2) {
                this.slideModeBinding.ivMode.setImageResource(R.drawable.icon_scroll_slider);
            } else if (slideMode.getSlideMode() == 3) {
                this.slideModeBinding.ivMode.setImageResource(R.drawable.icon_static_slider);
            } else if (slideMode.getSlideMode() == 4) {
                this.slideModeBinding.ivMode.setImageResource(R.drawable.icon_sim_slider);
            } else {
                this.slideModeBinding.ivMode.setImageResource(-1);
            }
            ReaderThemeManager h22 = MiConfigSingleton.b2().h2();
            this.slideModeBinding.ivMode.setAlpha(h22.s() ? 0.5f : 1.0f);
            if (slideMode.getSlideMode() == ReadingInstance.z().E(this.com.umeng.analytics.pro.f.X java.lang.String)) {
                this.slideModeBinding.roundLayout.setRoundingBorderColor(h22.g());
            } else {
                this.slideModeBinding.roundLayout.setRoundingBorderColor(0);
            }
        }
    }

    public interface a {
        void a(@l View view, int i10, @k ReadingInstance.SlideMode slideMode);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.slideModeList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public void onBindViewHolder(@k SlideModeViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.c(this.slideModeList.get(r32));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: l */
    public SlideModeViewHolder onCreateViewHolder(@k ViewGroup parent, int i10) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemSlideModeBinding inflate = ItemSlideModeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SlideModeViewHolder(this, inflate);
    }

    public final void m(@k a onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.mOnItemClickListener = onItemClickListener;
    }
}
