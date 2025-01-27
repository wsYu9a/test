package com.martian.mibook.mvvm.read.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import ba.g;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReaderTypefaceManager;
import com.martian.mibook.data.TypefaceItem;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.ItemReadingTypeFaceBinding;
import com.martian.mibook.mvvm.read.adapter.TypeFaceGridAdapter;
import com.martian.mibook.ui.reader.ReaderThemeProgressBar;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.io.File;
import java.util.Collection;
import java.util.List;
import je.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l9.t0;
import xi.k;
import xi.l;
import z8.e;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002=>B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\u0017\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001f\u0010 J#\u0010\"\u001a\u00020\u00072\n\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0011H\u0016¢\u0006\u0004\b$\u0010%JC\u0010'\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0003¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b)\u0010*JC\u0010-\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020+2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0002¢\u0006\u0004\b-\u0010.J-\u00100\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010&\u001a\u00020\u000b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b0\u00101R\"\u00106\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u00010\u000b0\u000b028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/TypeFaceGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/read/adapter/TypeFaceGridAdapter$TypeFaceViewHolder;", "<init>", "()V", "Lcom/martian/mibook/mvvm/read/adapter/TypeFaceGridAdapter$a;", "onItemClickListener", "", "v", "(Lcom/martian/mibook/mvvm/read/adapter/TypeFaceGridAdapter$a;)V", "", "Lcom/martian/mibook/data/TypefaceItem;", "newData", "y", "(Ljava/util/List;)V", "Landroid/content/Context;", f.X, "", id.c.f26972i, "Lcom/martian/mibook/databinding/ItemReadingTypeFaceBinding;", "itemBinding", "Lkotlin/Function0;", "notifyFontSizeChanged", t.f11211k, "(Landroid/content/Context;ILcom/martian/mibook/databinding/ItemReadingTypeFaceBinding;Lkotlin/jvm/functions/Function0;)V", "", "n", "(Landroid/content/Context;I)Z", "Landroid/view/ViewGroup;", "parent", "viewType", "q", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/TypeFaceGridAdapter$TypeFaceViewHolder;", "holder", "p", "(Lcom/martian/mibook/mvvm/read/adapter/TypeFaceGridAdapter$TypeFaceViewHolder;I)V", "getItemCount", "()I", "typefaceItem", "o", "(Landroid/content/Context;ILcom/martian/mibook/data/TypefaceItem;Lcom/martian/mibook/databinding/ItemReadingTypeFaceBinding;Lkotlin/jvm/functions/Function0;)V", IAdInterListener.AdReqParam.WIDTH, "(Landroid/content/Context;Lcom/martian/mibook/data/TypefaceItem;)V", "", TTDownloadField.TT_DOWNLOAD_PATH, "x", "(Landroid/content/Context;Lcom/martian/mibook/data/TypefaceItem;Ljava/lang/String;Lcom/martian/mibook/databinding/ItemReadingTypeFaceBinding;Lkotlin/jvm/functions/Function0;)V", "progress", bt.aO, "(Lcom/martian/mibook/databinding/ItemReadingTypeFaceBinding;Lcom/martian/mibook/data/TypefaceItem;Ljava/lang/Integer;)V", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "c", "Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer", "d", "Lcom/martian/mibook/mvvm/read/adapter/TypeFaceGridAdapter$a;", "mOnItemClickListener", e.TAG, "Ljava/lang/Integer;", "downloadPosition", "a", "TypeFaceViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class TypeFaceGridAdapter extends RecyclerView.Adapter<TypeFaceViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final AsyncListDiffer<TypefaceItem> mDiffer = new AsyncListDiffer<>(this, new DiffUtil.ItemCallback<TypefaceItem>() { // from class: com.martian.mibook.mvvm.read.adapter.TypeFaceGridAdapter$mDiffer$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        /* renamed from: a */
        public boolean areContentsTheSame(@k TypefaceItem oldItem, @k TypefaceItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getDownloadPath(), newItem.getDownloadPath()) && Intrinsics.areEqual(oldItem.getDownloadUrl(), newItem.getDownloadUrl()) && Intrinsics.areEqual(oldItem.getFilePath(), newItem.getFilePath());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b */
        public boolean areItemsTheSame(@k TypefaceItem oldItem, @k TypefaceItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    });

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public a mOnItemClickListener;

    /* renamed from: e */
    @l
    public Integer downloadPosition;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/TypeFaceGridAdapter$TypeFaceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemReadingTypeFaceBinding;", "typeFaceBinding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/TypeFaceGridAdapter;Lcom/martian/mibook/databinding/ItemReadingTypeFaceBinding;)V", "Lcom/martian/mibook/data/TypefaceItem;", "typefaceItem", "", e.TAG, "(Lcom/martian/mibook/data/TypefaceItem;)V", "b", "Lcom/martian/mibook/databinding/ItemReadingTypeFaceBinding;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "c", "Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class TypeFaceViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemReadingTypeFaceBinding typeFaceBinding;

        /* renamed from: c, reason: from kotlin metadata */
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ TypeFaceGridAdapter f14571d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TypeFaceViewHolder(@k TypeFaceGridAdapter typeFaceGridAdapter, ItemReadingTypeFaceBinding typeFaceBinding) {
            super(typeFaceBinding.getRoot());
            Intrinsics.checkNotNullParameter(typeFaceBinding, "typeFaceBinding");
            this.f14571d = typeFaceGridAdapter;
            this.typeFaceBinding = typeFaceBinding;
            this.com.umeng.analytics.pro.f.X java.lang.String = typeFaceBinding.getRoot().getContext();
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cd.d2

                /* renamed from: c */
                public final /* synthetic */ TypeFaceGridAdapter.TypeFaceViewHolder f1799c;

                public /* synthetic */ d2(TypeFaceGridAdapter.TypeFaceViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TypeFaceGridAdapter.TypeFaceViewHolder.c(TypeFaceGridAdapter.this, this, view);
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: cd.e2

                /* renamed from: c */
                public final /* synthetic */ TypeFaceGridAdapter.TypeFaceViewHolder f1805c;

                public /* synthetic */ e2(TypeFaceGridAdapter.TypeFaceViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean d10;
                    d10 = TypeFaceGridAdapter.TypeFaceViewHolder.d(TypeFaceGridAdapter.this, this, view);
                    return d10;
                }
            });
        }

        public static final void c(TypeFaceGridAdapter this$0, TypeFaceViewHolder this$1, View view) {
            int bindingAdapterPosition;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.mOnItemClickListener == null || (bindingAdapterPosition = this$1.getBindingAdapterPosition()) >= this$0.mDiffer.getCurrentList().size() || bindingAdapterPosition < 0) {
                return;
            }
            TypefaceItem typefaceItem = (TypefaceItem) this$0.mDiffer.getCurrentList().get(bindingAdapterPosition);
            if (typefaceItem.isVipTypeface() && !MiConfigSingleton.b2().K2() && !MiConfigSingleton.b2().B0()) {
                Context context = this$1.com.umeng.analytics.pro.f.X java.lang.String;
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                i.e0((Activity) context, "VIP字体", "", "");
            } else {
                a aVar = this$0.mOnItemClickListener;
                if (aVar != null) {
                    aVar.b(view, typefaceItem, bindingAdapterPosition, this$1.typeFaceBinding);
                }
            }
        }

        public static final boolean d(TypeFaceGridAdapter this$0, TypeFaceViewHolder this$1, View view) {
            int bindingAdapterPosition;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.mOnItemClickListener != null && (bindingAdapterPosition = this$1.getBindingAdapterPosition()) < this$0.mDiffer.getCurrentList().size() && bindingAdapterPosition >= 0) {
                TypefaceItem typefaceItem = (TypefaceItem) this$0.mDiffer.getCurrentList().get(bindingAdapterPosition);
                a aVar = this$0.mOnItemClickListener;
                if (aVar != null) {
                    aVar.a(view, typefaceItem, bindingAdapterPosition);
                }
            }
            return false;
        }

        @SuppressLint({"SetTextI18n"})
        public final void e(@k TypefaceItem typefaceItem) {
            Intrinsics.checkNotNullParameter(typefaceItem, "typefaceItem");
            MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
            this.typeFaceBinding.ivUseChecked.setColorFilter(k10.getItemColorPrimary());
            ReaderTypefaceManager i22 = MiConfigSingleton.b2().i2();
            boolean l10 = i22.l();
            boolean areEqual = Intrinsics.areEqual(typefaceItem.getFilePath(), i22.getTypefaceDirectoryRecord());
            if (typefaceItem.getType() == 1 || typefaceItem.getType() == 4) {
                this.typeFaceBinding.tvTypefaceName.setVisibility(8);
                this.typeFaceBinding.ivTypefacePreview.setVisibility(0);
                if (typefaceItem.isVipTypeface()) {
                    this.typeFaceBinding.ivVip.setVisibility(0);
                } else {
                    this.typeFaceBinding.ivVip.setVisibility(8);
                }
            } else {
                this.typeFaceBinding.tvTypefaceName.setVisibility(0);
                this.typeFaceBinding.ivTypefacePreview.setVisibility(8);
                this.typeFaceBinding.ivVip.setVisibility(8);
            }
            this.typeFaceBinding.tvTypefaceName.clearFocus();
            int type = typefaceItem.getType();
            if (type == 0) {
                this.typeFaceBinding.tvTypefaceName.setTypeface(Typeface.DEFAULT);
                this.typeFaceBinding.tvTypefaceName.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.system_used));
                if (l10) {
                    this.typeFaceBinding.tvTypefaceName.setTextColor(k10.getItemColorPrimary());
                    this.typeFaceBinding.tvTypefaceStatus.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.in_use));
                    this.typeFaceBinding.tvTypefaceStatus.setTextColor(k10.getItemColorPrimary());
                    this.typeFaceBinding.ivUseChecked.setVisibility(0);
                    return;
                }
                this.typeFaceBinding.tvTypefaceName.setTextColor(k10.getTextColorPrimary());
                this.typeFaceBinding.tvTypefaceStatus.setText("");
                this.typeFaceBinding.tvTypefaceStatus.setTextColor(k10.getTextColorPrimary());
                this.typeFaceBinding.ivUseChecked.setVisibility(8);
                return;
            }
            if (type == 1 || type == 4) {
                this.typeFaceBinding.ivTypefacePreview.setImageResource(typefaceItem.getRes());
                if (typefaceItem.getFaceStatus() == 0) {
                    if (new File(typefaceItem.getFilePath()).exists()) {
                        this.typeFaceBinding.tvTypefaceStatus.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.downloaded));
                    } else {
                        this.typeFaceBinding.tvTypefaceStatus.setText(typefaceItem.getFileSize());
                    }
                } else if (typefaceItem.getFaceStatus() == 3) {
                    this.typeFaceBinding.tvTypefaceStatus.setText(R.string.click_to_retry);
                } else if (typefaceItem.getFaceStatus() == 4) {
                    this.typeFaceBinding.tvTypefaceStatus.setText(R.string.wait_download);
                }
                if (l10 || !areEqual) {
                    this.typeFaceBinding.ivTypefacePreview.setColorFilter(k10.getTextColorPrimary());
                    this.typeFaceBinding.tvTypefaceStatus.setTextColor(k10.getTextColorPrimary());
                    this.typeFaceBinding.ivUseChecked.setVisibility(8);
                    return;
                } else {
                    this.typeFaceBinding.ivTypefacePreview.setColorFilter(k10.getItemColorPrimary());
                    this.typeFaceBinding.tvTypefaceStatus.setTextColor(k10.getItemColorPrimary());
                    this.typeFaceBinding.ivUseChecked.setVisibility(0);
                    this.typeFaceBinding.tvTypefaceStatus.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.in_use));
                    return;
                }
            }
            String filePath = typefaceItem.getFilePath();
            if (ba.l.q(filePath)) {
                return;
            }
            File file = new File(filePath);
            if (file.exists()) {
                Typeface h10 = MiConfigSingleton.b2().i2().h(filePath);
                if (h10 != null) {
                    this.typeFaceBinding.tvTypefaceName.setTypeface(h10);
                }
                TextView textView = this.typeFaceBinding.tvTypefaceName;
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String name2 = file.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                String substring = name.substring(0, StringsKt.indexOf$default((CharSequence) name2, '.', 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                textView.setText(substring);
            }
            if (l10 || !areEqual) {
                this.typeFaceBinding.tvTypefaceName.setTextColor(k10.getTextColorPrimary());
                this.typeFaceBinding.tvTypefaceStatus.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.imported));
                this.typeFaceBinding.tvTypefaceStatus.setTextColor(k10.getTextColorPrimary());
                this.typeFaceBinding.ivUseChecked.setVisibility(8);
                return;
            }
            this.typeFaceBinding.tvTypefaceName.setTextColor(k10.getItemColorPrimary());
            this.typeFaceBinding.tvTypefaceName.requestFocus();
            this.typeFaceBinding.tvTypefaceStatus.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.in_use));
            this.typeFaceBinding.tvTypefaceStatus.setTextColor(k10.getItemColorPrimary());
            this.typeFaceBinding.ivUseChecked.setVisibility(0);
        }
    }

    public interface a {
        boolean a(@l View view, @l TypefaceItem typefaceItem, int i10);

        void b(@l View view, @l TypefaceItem typefaceItem, int i10, @l ItemReadingTypeFaceBinding itemReadingTypeFaceBinding);
    }

    public static final class b implements e.b {

        /* renamed from: a */
        public final /* synthetic */ TypefaceItem f14572a;

        /* renamed from: b */
        public final /* synthetic */ ItemReadingTypeFaceBinding f14573b;

        /* renamed from: c */
        public final /* synthetic */ Context f14574c;

        /* renamed from: d */
        public final /* synthetic */ TypeFaceGridAdapter f14575d;

        /* renamed from: e */
        public final /* synthetic */ String f14576e;

        /* renamed from: f */
        public final /* synthetic */ Function0<Unit> f14577f;

        public b(TypefaceItem typefaceItem, ItemReadingTypeFaceBinding itemReadingTypeFaceBinding, Context context, TypeFaceGridAdapter typeFaceGridAdapter, String str, Function0<Unit> function0) {
            this.f14572a = typefaceItem;
            this.f14573b = itemReadingTypeFaceBinding;
            this.f14574c = context;
            this.f14575d = typeFaceGridAdapter;
            this.f14576e = str;
            this.f14577f = function0;
        }

        @Override // z8.e.b
        @SuppressLint({"SetTextI18n"})
        public void a(int i10, int i11) {
            int i12 = (i10 * 100) / i11;
            this.f14572a.setFaceStatus(1);
            ItemReadingTypeFaceBinding itemReadingTypeFaceBinding = this.f14573b;
            TextView textView = itemReadingTypeFaceBinding != null ? itemReadingTypeFaceBinding.tvTypefaceStatus : null;
            if (textView != null) {
                Context context = this.f14574c;
                textView.setText((context != null ? context.getString(R.string.download_desc) : null) + i12 + "%");
            }
            this.f14575d.t(this.f14573b, this.f14572a, Integer.valueOf(i12));
        }

        @Override // z8.e.b
        public void b(int i10) {
            this.f14572a.setFaceStatus(2);
            ItemReadingTypeFaceBinding itemReadingTypeFaceBinding = this.f14573b;
            TextView textView = itemReadingTypeFaceBinding != null ? itemReadingTypeFaceBinding.tvTypefaceStatus : null;
            if (textView != null) {
                Context context = this.f14574c;
                textView.setText(context != null ? context.getString(R.string.unzip_desc) : null);
            }
            TypeFaceGridAdapter typeFaceGridAdapter = this.f14575d;
            Context context2 = this.f14574c;
            TypefaceItem typefaceItem = this.f14572a;
            String downloadPath = this.f14576e;
            Intrinsics.checkNotNullExpressionValue(downloadPath, "$downloadPath");
            typeFaceGridAdapter.x(context2, typefaceItem, downloadPath, this.f14573b, this.f14577f);
            this.f14575d.t(this.f14573b, this.f14572a, 100);
        }

        @Override // z8.e.b
        public void c(@k x8.c errorResult) {
            Intrinsics.checkNotNullParameter(errorResult, "errorResult");
            this.f14575d.downloadPosition = null;
            this.f14572a.setFaceStatus(3);
            ItemReadingTypeFaceBinding itemReadingTypeFaceBinding = this.f14573b;
            TextView textView = itemReadingTypeFaceBinding != null ? itemReadingTypeFaceBinding.tvTypefaceStatus : null;
            if (textView != null) {
                Context context = this.f14574c;
                textView.setText(context != null ? context.getString(R.string.download_failed) : null);
            }
            TypeFaceGridAdapter.u(this.f14575d, this.f14573b, this.f14572a, null, 4, null);
        }

        @Override // z8.e.b
        public void onCancel() {
        }

        @Override // z8.e.b
        public void onStart() {
        }
    }

    public static final class c implements ea.b {

        /* renamed from: a */
        public final /* synthetic */ Context f14578a;

        /* renamed from: b */
        public final /* synthetic */ TypefaceItem f14579b;

        /* renamed from: c */
        public final /* synthetic */ TypeFaceGridAdapter f14580c;

        /* renamed from: d */
        public final /* synthetic */ Function0<Unit> f14581d;

        public c(Context context, TypefaceItem typefaceItem, TypeFaceGridAdapter typeFaceGridAdapter, Function0<Unit> function0) {
            this.f14578a = context;
            this.f14579b = typefaceItem;
            this.f14580c = typeFaceGridAdapter;
            this.f14581d = function0;
        }

        @Override // ea.b
        public void permissionDenied() {
        }

        @Override // ea.b
        public void permissionGranted() {
            MiConfigSingleton.b2().i2().u(this.f14578a, this.f14579b.getFilePath());
            MiConfigSingleton.b2().i2().v(this.f14578a, false);
            this.f14580c.notifyDataSetChanged();
            Function0<Unit> function0 = this.f14581d;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public static final class d implements g.b {

        /* renamed from: b */
        public final /* synthetic */ TypefaceItem f14583b;

        /* renamed from: c */
        public final /* synthetic */ ItemReadingTypeFaceBinding f14584c;

        /* renamed from: d */
        public final /* synthetic */ Context f14585d;

        /* renamed from: e */
        public final /* synthetic */ Function0<Unit> f14586e;

        public d(TypefaceItem typefaceItem, ItemReadingTypeFaceBinding itemReadingTypeFaceBinding, Context context, Function0<Unit> function0) {
            this.f14583b = typefaceItem;
            this.f14584c = itemReadingTypeFaceBinding;
            this.f14585d = context;
            this.f14586e = function0;
        }

        @Override // ba.g.b
        @SuppressLint({"NotifyDataSetChanged"})
        public void a(@k String destPath) {
            Intrinsics.checkNotNullParameter(destPath, "destPath");
            TypeFaceGridAdapter.this.downloadPosition = null;
            this.f14583b.setFaceStatus(0);
            ItemReadingTypeFaceBinding itemReadingTypeFaceBinding = this.f14584c;
            TextView textView = itemReadingTypeFaceBinding != null ? itemReadingTypeFaceBinding.tvTypefaceStatus : null;
            if (textView != null) {
                Context context = this.f14585d;
                textView.setText(context != null ? context.getString(R.string.unzip_finish) : null);
            }
            TypeFaceGridAdapter.u(TypeFaceGridAdapter.this, this.f14584c, this.f14583b, null, 4, null);
            String filePath = this.f14583b.getFilePath();
            if (new File(filePath).exists()) {
                MiConfigSingleton.b2().i2().u(this.f14585d, filePath);
                MiConfigSingleton.b2().i2().v(this.f14585d, false);
                Function0<Unit> function0 = this.f14586e;
                if (function0 != null) {
                    function0.invoke();
                }
            }
            TypeFaceGridAdapter.this.notifyDataSetChanged();
        }

        @Override // ba.g.b
        public void onError(@k String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            TypeFaceGridAdapter.this.downloadPosition = null;
            this.f14583b.setFaceStatus(3);
            ItemReadingTypeFaceBinding itemReadingTypeFaceBinding = this.f14584c;
            TextView textView = itemReadingTypeFaceBinding != null ? itemReadingTypeFaceBinding.tvTypefaceStatus : null;
            if (textView != null) {
                Context context = this.f14585d;
                textView.setText(context != null ? context.getString(R.string.unzip_failed) : null);
            }
            TypeFaceGridAdapter.u(TypeFaceGridAdapter.this, this.f14584c, this.f14583b, null, 4, null);
        }

        @Override // ba.g.b
        public void onLoading(boolean z10) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void s(TypeFaceGridAdapter typeFaceGridAdapter, Context context, int i10, ItemReadingTypeFaceBinding itemReadingTypeFaceBinding, Function0 function0, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            function0 = null;
        }
        typeFaceGridAdapter.r(context, i10, itemReadingTypeFaceBinding, function0);
    }

    public static /* synthetic */ void u(TypeFaceGridAdapter typeFaceGridAdapter, ItemReadingTypeFaceBinding itemReadingTypeFaceBinding, TypefaceItem typefaceItem, Integer num, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            num = null;
        }
        typeFaceGridAdapter.t(itemReadingTypeFaceBinding, typefaceItem, num);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.mDiffer.getCurrentList().size();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final boolean n(@l Context r52, int r62) {
        boolean z10;
        if (r52 == null) {
            return false;
        }
        TypefaceItem typefaceItem = this.mDiffer.getCurrentList().get(r62);
        if (typefaceItem == null || typefaceItem.getType() != 2) {
            z10 = false;
        } else {
            ReaderTypefaceManager i22 = MiConfigSingleton.b2().i2();
            if (Intrinsics.areEqual(typefaceItem.getFilePath(), i22.getTypefaceDirectoryRecord())) {
                z10 = true;
                MiConfigSingleton.b2().i2().v(r52, true);
            } else {
                z10 = false;
            }
            i22.b(typefaceItem.getFilePath());
        }
        List<TypefaceItem> currentList = this.mDiffer.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        List<TypefaceItem> mutableList = CollectionsKt.toMutableList((Collection) currentList);
        mutableList.remove(typefaceItem);
        this.mDiffer.submitList(mutableList);
        if (z10) {
            notifyItemChanged(0);
        }
        return z10;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void o(Context r10, int r11, TypefaceItem typefaceItem, ItemReadingTypeFaceBinding itemBinding, Function0<Unit> notifyFontSizeChanged) {
        Integer num = this.downloadPosition;
        if (num != null) {
            if ((num != null && num.intValue() == r11) || typefaceItem.getFaceStatus() == 4) {
                w(r10, typefaceItem);
                return;
            }
            List<TypefaceItem> currentList = this.mDiffer.getCurrentList();
            Integer num2 = this.downloadPosition;
            Intrinsics.checkNotNull(num2);
            w(r10, currentList.get(num2.intValue()));
            typefaceItem.setFaceStatus(4);
        }
        this.downloadPosition = Integer.valueOf(r11);
        String filePath = typefaceItem.getFilePath();
        if (!new File(filePath).exists()) {
            String downloadUrl = typefaceItem.getDownloadUrl();
            String downloadPath = typefaceItem.getDownloadPath();
            z8.e.c(downloadUrl, downloadPath, new b(typefaceItem, itemBinding, r10, this, downloadPath, notifyFontSizeChanged));
        } else {
            MiConfigSingleton.b2().i2().u(r10, filePath);
            MiConfigSingleton.b2().i2().v(r10, false);
            notifyDataSetChanged();
            if (notifyFontSizeChanged != null) {
                notifyFontSizeChanged.invoke();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(@k TypeFaceViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        TypefaceItem typefaceItem = this.mDiffer.getCurrentList().get(r32);
        Intrinsics.checkNotNull(typefaceItem);
        holder.e(typefaceItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: q */
    public TypeFaceViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemReadingTypeFaceBinding inflate = ItemReadingTypeFaceBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new TypeFaceViewHolder(this, inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void r(@l Context context, int i10, @l ItemReadingTypeFaceBinding itemReadingTypeFaceBinding, @l Function0<Unit> function0) {
        if (context == null) {
            return;
        }
        TypefaceItem typefaceItem = this.mDiffer.getCurrentList().get(i10);
        if (typefaceItem != null && typefaceItem.getType() == 0) {
            MiConfigSingleton.b2().i2().v(context, true);
            notifyDataSetChanged();
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        if (typefaceItem != null && typefaceItem.getType() == 2) {
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                ea.c.l(activity, "本地字体", MiConfigSingleton.b2().I0(), new c(context, typefaceItem, this, function0));
                return;
            }
            return;
        }
        if (((typefaceItem == null || typefaceItem.getType() != 1) && (typefaceItem == null || typefaceItem.getType() != 4)) || typefaceItem.getFaceStatus() != 0) {
            return;
        }
        String filePath = typefaceItem.getFilePath();
        if (!new File(filePath).exists()) {
            Intrinsics.checkNotNull(typefaceItem);
            o(context, i10, typefaceItem, itemReadingTypeFaceBinding, function0);
            return;
        }
        MiConfigSingleton.b2().i2().u(context, filePath);
        MiConfigSingleton.b2().i2().v(context, false);
        notifyDataSetChanged();
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void t(ItemReadingTypeFaceBinding itemReadingTypeFaceBinding, TypefaceItem typefaceItem, Integer num) {
        if (typefaceItem.getFaceStatus() != 4 && typefaceItem.getFaceStatus() != 1 && typefaceItem.getFaceStatus() != 2) {
            RoundedLayout roundedLayout = itemReadingTypeFaceBinding != null ? itemReadingTypeFaceBinding.roundLayout : null;
            if (roundedLayout == null) {
                return;
            }
            roundedLayout.setVisibility(8);
            return;
        }
        if (num == null) {
            RoundedLayout roundedLayout2 = itemReadingTypeFaceBinding != null ? itemReadingTypeFaceBinding.roundLayout : null;
            if (roundedLayout2 == null) {
                return;
            }
            roundedLayout2.setVisibility(8);
            return;
        }
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        RoundedLayout roundedLayout3 = itemReadingTypeFaceBinding != null ? itemReadingTypeFaceBinding.roundLayout : null;
        if (roundedLayout3 != null) {
            roundedLayout3.setVisibility(0);
        }
        RoundedLayout roundedLayout4 = itemReadingTypeFaceBinding != null ? itemReadingTypeFaceBinding.roundLayout : null;
        if (roundedLayout4 != null) {
            roundedLayout4.setRoundingBorderColor(k10.getItemColorPrimary());
        }
        ReaderThemeProgressBar readerThemeProgressBar = itemReadingTypeFaceBinding != null ? itemReadingTypeFaceBinding.rbsProgressBar : null;
        if (readerThemeProgressBar == null) {
            return;
        }
        readerThemeProgressBar.setProgress(num.intValue());
    }

    public final void v(@k a onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.mOnItemClickListener = onItemClickListener;
    }

    public final void w(Context context, TypefaceItem typefaceItem) {
        if (context == null || typefaceItem == null) {
            return;
        }
        int faceStatus = typefaceItem.getFaceStatus();
        if (faceStatus == 1) {
            t0.b(context, context.getString(R.string.download_hint2));
        } else if (faceStatus == 2) {
            t0.b(context, context.getString(R.string.unzip_hint));
        } else {
            if (faceStatus != 4) {
                return;
            }
            t0.b(context, context.getString(R.string.download_hint3));
        }
    }

    public final void x(Context r92, TypefaceItem typefaceItem, String r11, ItemReadingTypeFaceBinding itemBinding, Function0<Unit> notifyFontSizeChanged) {
        g.D(r11, ba.b.j(), new d(typefaceItem, itemBinding, r92, notifyFontSizeChanged));
    }

    public final void y(@l List<? extends TypefaceItem> newData) {
        this.mDiffer.submitList(newData);
    }
}
