package com.martian.mibook.mvvm.tts.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.databinding.ItemAudioBookRecommendBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.tts.adapter.AudiobookRecommendAdapter;
import id.c;
import java.util.List;
import je.i;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\b2\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00060\u00060\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/martian/mibook/mvvm/tts/adapter/AudiobookRecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/tts/adapter/AudiobookRecommendAdapter$BookViewHolder;", "<init>", "()V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "newData", "", "o", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "n", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/tts/adapter/AudiobookRecommendAdapter$BookViewHolder;", "holder", c.f26972i, "m", "(Lcom/martian/mibook/mvvm/tts/adapter/AudiobookRecommendAdapter$BookViewHolder;I)V", "getItemCount", "()I", "", "getItemId", "(I)J", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "c", "Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer", "d", "BookViewHolder", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class AudiobookRecommendAdapter extends RecyclerView.Adapter<BookViewHolder> {

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e */
    public static int f15132e = 4;

    /* renamed from: f */
    public static int f15133f = 2;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public final AsyncListDiffer<TYBookItem> mDiffer;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/martian/mibook/mvvm/tts/adapter/AudiobookRecommendAdapter$BookViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemAudioBookRecommendBinding;", "bookBinding", "<init>", "(Lcom/martian/mibook/mvvm/tts/adapter/AudiobookRecommendAdapter;Lcom/martian/mibook/databinding/ItemAudioBookRecommendBinding;)V", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "tyBookItem", "", "c", "(Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "b", "Lcom/martian/mibook/databinding/ItemAudioBookRecommendBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class BookViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemAudioBookRecommendBinding bookBinding;

        /* renamed from: c */
        public final /* synthetic */ AudiobookRecommendAdapter f15136c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BookViewHolder(@k AudiobookRecommendAdapter audiobookRecommendAdapter, ItemAudioBookRecommendBinding bookBinding) {
            super(bookBinding.getRoot());
            Intrinsics.checkNotNullParameter(bookBinding, "bookBinding");
            this.f15136c = audiobookRecommendAdapter;
            this.bookBinding = bookBinding;
        }

        public static final void d(BookViewHolder this$0, TYBookItem tyBookItem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(tyBookItem, "$tyBookItem");
            Context context = this$0.bookBinding.getRoot().getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                i.H(activity, tyBookItem);
            }
        }

        public static final void e(BookViewHolder this$0, TYBookItem tyBookItem, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(tyBookItem, "$tyBookItem");
            Context context = this$0.bookBinding.getRoot().getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                i.H(activity, tyBookItem);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public final void c(@k TYBookItem tyBookItem) {
            Intrinsics.checkNotNullParameter(tyBookItem, "tyBookItem");
            MiBookManager.u1(this.bookBinding.getRoot().getContext(), tyBookItem, this.bookBinding.ivBookCover);
            tyBookItem.setGoReading(Boolean.FALSE);
            this.bookBinding.tvBookName.setText(ExtKt.c(tyBookItem.getTitle()));
            this.bookBinding.tvBookCategory.setText(ExtKt.c(tyBookItem.getCategory()));
            this.bookBinding.ivBookCover.setOnClickListener(new View.OnClickListener() { // from class: kd.b

                /* renamed from: c */
                public final /* synthetic */ TYBookItem f27773c;

                public /* synthetic */ b(TYBookItem tyBookItem2) {
                    tyBookItem = tyBookItem2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookRecommendAdapter.BookViewHolder.d(AudiobookRecommendAdapter.BookViewHolder.this, tyBookItem, view);
                }
            });
            this.bookBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: kd.c

                /* renamed from: c */
                public final /* synthetic */ TYBookItem f27775c;

                public /* synthetic */ c(TYBookItem tyBookItem2) {
                    tyBookItem = tyBookItem2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookRecommendAdapter.BookViewHolder.e(AudiobookRecommendAdapter.BookViewHolder.this, tyBookItem, view);
                }
            });
        }
    }

    /* renamed from: com.martian.mibook.mvvm.tts.adapter.AudiobookRecommendAdapter$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return AudiobookRecommendAdapter.f15132e;
        }

        public final int b() {
            return AudiobookRecommendAdapter.f15133f;
        }

        public final void c(int i10) {
            AudiobookRecommendAdapter.f15132e = i10;
        }

        public final void d(int i10) {
            AudiobookRecommendAdapter.f15133f = i10;
        }

        public Companion() {
        }
    }

    public AudiobookRecommendAdapter() {
        setHasStableIds(true);
        this.mDiffer = new AsyncListDiffer<>(this, new DiffUtil.ItemCallback<TYBookItem>() { // from class: com.martian.mibook.mvvm.tts.adapter.AudiobookRecommendAdapter$mDiffer$1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a */
            public boolean areContentsTheSame(@k TYBookItem oldItem, @k TYBookItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem.getBookId(), newItem.getBookId()) && Intrinsics.areEqual(oldItem.getBookName(), oldItem.getBookName());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b */
            public boolean areItemsTheSame(@k TYBookItem oldItem, @k TYBookItem newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return Math.min(this.mDiffer.getCurrentList().size(), f15132e * f15133f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r32) {
        return r32;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onBindViewHolder(@k BookViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        TYBookItem tYBookItem = this.mDiffer.getCurrentList().get(r32);
        Intrinsics.checkNotNull(tYBookItem);
        holder.c(tYBookItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: n */
    public BookViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemAudioBookRecommendBinding inflate = ItemAudioBookRecommendBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new BookViewHolder(this, inflate);
    }

    public final void o(@l List<? extends TYBookItem> newData) {
        this.mDiffer.submitList(null);
        this.mDiffer.submitList(newData);
    }
}
