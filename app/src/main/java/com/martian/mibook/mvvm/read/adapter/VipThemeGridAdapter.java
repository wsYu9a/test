package com.martian.mibook.mvvm.read.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.data.theme.ReaderThemeType;
import com.martian.mibook.databinding.ItemReadingVipThemeBinding;
import com.martian.mibook.mvvm.read.adapter.VipThemeGridAdapter;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.List;
import je.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u0004J#\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\u00020\u00072\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u000b0\u000b0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/VipThemeGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/read/adapter/VipThemeGridAdapter$ViewHolder;", "<init>", "()V", "Lcom/martian/mibook/mvvm/read/adapter/VipThemeGridAdapter$a;", "onThemeSelectListener", "", "n", "(Lcom/martian/mibook/mvvm/read/adapter/VipThemeGridAdapter$a;)V", "", "Lcom/martian/mibook/data/theme/MiReadingTheme;", "newData", "p", "(Ljava/util/List;)V", "k", "Landroid/view/ViewGroup;", "parent", "", "viewType", "m", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/VipThemeGridAdapter$ViewHolder;", "getItemCount", "()I", "holder", c.f26972i, t.f11204d, "(Lcom/martian/mibook/mvvm/read/adapter/VipThemeGridAdapter$ViewHolder;I)V", "c", "Lcom/martian/mibook/mvvm/read/adapter/VipThemeGridAdapter$a;", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "d", "Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer", "a", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class VipThemeGridAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public a onThemeSelectListener;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final AsyncListDiffer<MiReadingTheme> mDiffer = new AsyncListDiffer<>(this, new DiffUtil.ItemCallback<MiReadingTheme>() { // from class: com.martian.mibook.mvvm.read.adapter.VipThemeGridAdapter$mDiffer$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        /* renamed from: a */
        public boolean areContentsTheSame(@k MiReadingTheme oldItem, @k MiReadingTheme newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getDownloadPath(), newItem.getDownloadPath()) && Intrinsics.areEqual(oldItem.getDownloadUrl(), newItem.getDownloadUrl()) && Intrinsics.areEqual(oldItem.getBackgroundImagePath(), newItem.getBackgroundImagePath());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b */
        public boolean areItemsTheSame(@k MiReadingTheme oldItem, @k MiReadingTheme newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    });

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/VipThemeGridAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemReadingVipThemeBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/VipThemeGridAdapter;Lcom/martian/mibook/databinding/ItemReadingVipThemeBinding;)V", "Lcom/martian/mibook/data/theme/MiReadingTheme;", "readingTheme", "", e.TAG, "(Lcom/martian/mibook/data/theme/MiReadingTheme;)V", "g", "f", "b", "Lcom/martian/mibook/databinding/ItemReadingVipThemeBinding;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "c", "Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemReadingVipThemeBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ VipThemeGridAdapter f14591d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k VipThemeGridAdapter vipThemeGridAdapter, ItemReadingVipThemeBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14591d = vipThemeGridAdapter;
            this.binding = binding;
            this.com.umeng.analytics.pro.f.X java.lang.String = binding.getRoot().getContext();
            binding.llThemeStatus.setOnClickListener(new View.OnClickListener() { // from class: cd.f2

                /* renamed from: c */
                public final /* synthetic */ VipThemeGridAdapter f1811c;

                public /* synthetic */ f2(VipThemeGridAdapter vipThemeGridAdapter2) {
                    vipThemeGridAdapter = vipThemeGridAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VipThemeGridAdapter.ViewHolder.b(VipThemeGridAdapter.ViewHolder.this, vipThemeGridAdapter, view);
                }
            });
        }

        public static final void b(ViewHolder this$0, VipThemeGridAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.mDiffer.getCurrentList().size() || bindingAdapterPosition < 0) {
                return;
            }
            MiReadingTheme miReadingTheme = (MiReadingTheme) this$1.mDiffer.getCurrentList().get(bindingAdapterPosition);
            if (!miReadingTheme.isVipTheme() || MiConfigSingleton.b2().K2() || MiConfigSingleton.b2().B0()) {
                Intrinsics.checkNotNull(miReadingTheme);
                this$0.g(miReadingTheme);
                return;
            }
            Context context = this$0.com.umeng.analytics.pro.f.X java.lang.String;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            i.e0((Activity) context, "VIP主题-" + miReadingTheme.getThemeName(), "", "");
        }

        @SuppressLint({"SetTextI18n"})
        public final void e(@k MiReadingTheme readingTheme) {
            Intrinsics.checkNotNullParameter(readingTheme, "readingTheme");
            this.binding.ivThemePic.setImageResource(readingTheme.getPreviewImageRes());
            this.binding.tvThemeName.setText(readingTheme.getThemeName());
            if (readingTheme.isVipTheme()) {
                this.binding.tvThemeName.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(this.com.umeng.analytics.pro.f.X java.lang.String, R.drawable.icon_vip_tag), (Drawable) null);
            } else {
                this.binding.tvThemeName.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
            this.binding.llThemeStatus.setBackground(k10.getBorderLineBackgroundSelectedDrawable(this.com.umeng.analytics.pro.f.X java.lang.String));
            this.binding.tvThemeStatus.setTextColor(ContextCompat.getColor(this.com.umeng.analytics.pro.f.X java.lang.String, com.martian.libmars.R.color.white));
            if (k10.getThemeId() == readingTheme.getThemeId() && k10.getType() == ReaderThemeType.THEME_VIP_DOWNLOADED && k10.isDownloadFinishTheme()) {
                this.binding.llThemeStatus.setEnabled(false);
                this.binding.llThemeStatus.setAlpha(0.4f);
                this.binding.tvThemeStatus.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.in_use));
            } else {
                this.binding.llThemeStatus.setEnabled(true);
                this.binding.llThemeStatus.setAlpha(1.0f);
                this.binding.tvThemeStatus.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.immediate_use));
            }
        }

        public final void f(MiReadingTheme readingTheme) {
            z8.e.c(readingTheme.getDownloadUrl(), readingTheme.getDownloadPath(), new VipThemeGridAdapter$ViewHolder$downloadReadingTheme$1(readingTheme, this, this.f14591d));
        }

        public final void g(MiReadingTheme readingTheme) {
            if (!readingTheme.isVipDownloadTheme()) {
                a aVar = this.f14591d.onThemeSelectListener;
                if (aVar != null) {
                    aVar.a(readingTheme);
                    return;
                }
                return;
            }
            if (readingTheme.getDownLoadStatus() == 0) {
                if (!readingTheme.isDownloadFinishTheme()) {
                    f(readingTheme);
                    return;
                }
                a aVar2 = this.f14591d.onThemeSelectListener;
                if (aVar2 != null) {
                    aVar2.a(readingTheme);
                }
            }
        }
    }

    public interface a {
        void a(@k MiReadingTheme miReadingTheme);
    }

    public static /* synthetic */ void o(VipThemeGridAdapter vipThemeGridAdapter, a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        vipThemeGridAdapter.n(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.mDiffer.getCurrentList().size();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void k() {
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(@k ViewHolder holder, int i10) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MiReadingTheme miReadingTheme = this.mDiffer.getCurrentList().get(i10);
        Intrinsics.checkNotNull(miReadingTheme);
        holder.e(miReadingTheme);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: m */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemReadingVipThemeBinding inflate = ItemReadingVipThemeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this, inflate);
    }

    public final void n(@l a onThemeSelectListener) {
        this.onThemeSelectListener = onThemeSelectListener;
    }

    public final void p(@l List<MiReadingTheme> newData) {
        this.mDiffer.submitList(newData);
    }
}
