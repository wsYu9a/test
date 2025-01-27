package com.martian.mibook.mvvm.tts.adapter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemAudioBookChapterBinding;
import com.martian.mibook.lib.local.txt.data.TXTChapter;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.tts.adapter.AudiobookChapterAdapter;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002RSB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ/\u0010\u0016\u001a\u00020\t2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J#\u0010$\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010'J1\u0010,\u001a\u00020\t2\n\u0010(\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u00052\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016¢\u0006\u0004\b,\u0010-J#\u0010.\u001a\u00020\t2\n\u0010(\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010/J\u001d\u00102\u001a\u00020\t2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005¢\u0006\u0004\b2\u00103J!\u00108\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u0001042\b\b\u0002\u00107\u001a\u000206¢\u0006\u0004\b8\u00109R\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\"\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010BR\"\u0010L\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010Q\u001a\u0010\u0012\f\u0012\n N*\u0004\u0018\u00010\u00070\u00070M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006T"}, d2 = {"Lcom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter$ViewHolder;", "<init>", "()V", "", "index", "Lcom/martian/mibook/lib/model/data/abs/Chapter;", "chapter", "", "o", "(ILcom/martian/mibook/lib/model/data/abs/Chapter;)V", c.f26972i, "", bt.aO, "(I)Z", "u", "", "newData", "currentPosition", "Lcom/martian/mibook/lib/model/data/abs/Book;", "book", "D", "(Ljava/util/List;ILcom/martian/mibook/lib/model/data/abs/Book;)V", BaseReadAloudService.f15168x, bt.aJ, "(I)V", "Lcom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter$a;", "onItemClickListener", "B", "(Lcom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter$a;)V", "s", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "y", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter$ViewHolder;", "getItemCount", "()I", "holder", "", "", "payloads", "x", "(Lcom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter$ViewHolder;ILjava/util/List;)V", IAdInterListener.AdReqParam.WIDTH, "(Lcom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter$ViewHolder;I)V", "startIndex", "endIndex", t.f11211k, "(II)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "delayTimeMillis", "p", "(Landroidx/recyclerview/widget/RecyclerView;J)V", "c", "I", "d", "Lcom/martian/mibook/lib/model/data/abs/Book;", e.TAG, "Lcom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter$a;", "", "f", "Ljava/util/Map;", "chapterContentCacheFlags", "g", "chapterFreeFlags", "h", "Z", "v", "()Z", "C", "(Z)V", "isReverseOrder", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "i", "Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer", "a", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAudiobookChapterAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudiobookChapterAdapter.kt\ncom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter\n+ 2 ArrayMap.kt\nandroidx/collection/ArrayMapKt\n*L\n1#1,239:1\n22#2:240\n22#2:241\n*S KotlinDebug\n*F\n+ 1 AudiobookChapterAdapter.kt\ncom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter\n*L\n31#1:240\n33#1:241\n*E\n"})
/* loaded from: classes3.dex */
public final class AudiobookChapterAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public Book book;

    /* renamed from: e */
    @l
    public a onItemClickListener;

    /* renamed from: h, reason: from kotlin metadata */
    public boolean isReverseOrder;

    /* renamed from: c, reason: from kotlin metadata */
    public int currentPosition = -1;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public Map<Integer, Boolean> chapterContentCacheFlags = new ArrayMap();

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public Map<Integer, Boolean> chapterFreeFlags = new ArrayMap();

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final AsyncListDiffer<Chapter> mDiffer = new AsyncListDiffer<>(this, new DiffUtil.ItemCallback<Chapter>() { // from class: com.martian.mibook.mvvm.tts.adapter.AudiobookChapterAdapter$mDiffer$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a */
        public boolean areContentsTheSame(@k Chapter oldItem, @k Chapter newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getChapterId(), newItem.getChapterId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b */
        public boolean areItemsTheSame(@k Chapter oldItem, @k Chapter newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    });

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemAudioBookChapterBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/tts/adapter/AudiobookChapterAdapter;Lcom/martian/mibook/databinding/ItemAudioBookChapterBinding;)V", "Lcom/martian/mibook/lib/model/data/abs/Chapter;", "chapter", "", "c", "(Lcom/martian/mibook/lib/model/data/abs/Chapter;)V", "f", "()V", e.TAG, "b", "Lcom/martian/mibook/databinding/ItemAudioBookChapterBinding;", "d", "()Lcom/martian/mibook/databinding/ItemAudioBookChapterBinding;", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemAudioBookChapterBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ AudiobookChapterAdapter f15130d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k AudiobookChapterAdapter audiobookChapterAdapter, ItemAudioBookChapterBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15130d = audiobookChapterAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: kd.a

                /* renamed from: c */
                public final /* synthetic */ AudiobookChapterAdapter.ViewHolder f27771c;

                public /* synthetic */ a(AudiobookChapterAdapter.ViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiobookChapterAdapter.ViewHolder.b(AudiobookChapterAdapter.this, this, view);
                }
            });
        }

        public static final void b(AudiobookChapterAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            a aVar = this$0.onItemClickListener;
            if (aVar != null) {
                aVar.a(this$1.getBindingAdapterPosition());
            }
        }

        public final void c(@k Chapter chapter) {
            Intrinsics.checkNotNullParameter(chapter, "chapter");
            this.binding.tvChapterTitle.setText(ExtKt.c(chapter.getTitle()));
            f();
            e();
        }

        @k
        /* renamed from: d, reason: from getter */
        public final ItemAudioBookChapterBinding getBinding() {
            return this.binding;
        }

        public final void e() {
            if (this.f15130d.t(getBindingAdapterPosition())) {
                this.binding.tvChapterStatus.setVisibility(0);
                this.binding.tvChapterStatus.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.cached));
            } else if (this.f15130d.u(getBindingAdapterPosition())) {
                this.binding.tvChapterStatus.setVisibility(4);
            } else {
                this.binding.tvChapterStatus.setVisibility(0);
                this.binding.tvChapterStatus.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.locked));
            }
        }

        public final void f() {
            AnimationDrawable animationDrawable;
            ImageView imageView = this.binding.ivChapterPosition;
            int i10 = 0;
            if (this.f15130d.currentPosition == getBindingAdapterPosition()) {
                this.binding.ivChapterPosition.setImageResource(R.drawable.audio_book_current_chapter_animation_list);
                Drawable drawable = this.binding.ivChapterPosition.getDrawable();
                animationDrawable = drawable instanceof AnimationDrawable ? (AnimationDrawable) drawable : null;
                if (animationDrawable != null) {
                    animationDrawable.start();
                }
                this.binding.tvChapterTitle.setTextColorType(4);
                this.binding.tvChapterTitle.p();
            } else {
                this.binding.tvChapterTitle.setTextColorType(0);
                this.binding.tvChapterTitle.p();
                Drawable drawable2 = this.binding.ivChapterPosition.getDrawable();
                animationDrawable = drawable2 instanceof AnimationDrawable ? (AnimationDrawable) drawable2 : null;
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
                i10 = 8;
            }
            imageView.setVisibility(i10);
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }
    }

    public interface a {
        void a(int i10);
    }

    public static /* synthetic */ void A(AudiobookChapterAdapter audiobookChapterAdapter, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0 && (i10 = audiobookChapterAdapter.currentPosition) < 0) {
            i10 = 0;
        }
        audiobookChapterAdapter.z(i10);
    }

    public final void o(int index, Chapter chapter) {
        Book book;
        if (chapter == null || (chapter instanceof TXTChapter) || (book = this.book) == null) {
            return;
        }
        int i10 = this.currentPosition;
        if ((i10 - 1 == index || i10 == index || i10 + 1 == index) && this.chapterContentCacheFlags.containsKey(Integer.valueOf(index)) && Intrinsics.areEqual(this.chapterContentCacheFlags.get(Integer.valueOf(index)), Boolean.FALSE)) {
            this.chapterContentCacheFlags.remove(Integer.valueOf(index));
        }
        if (this.chapterContentCacheFlags.containsKey(Integer.valueOf(index))) {
            return;
        }
        this.chapterContentCacheFlags.put(Integer.valueOf(index), Boolean.valueOf(MiConfigSingleton.b2().M1().c0(new Source(book.getSourceName(), book.getSourceId()), chapter)));
        this.chapterFreeFlags.put(Integer.valueOf(index), Boolean.valueOf(chapter.isFree()));
    }

    public static /* synthetic */ void q(AudiobookChapterAdapter audiobookChapterAdapter, RecyclerView recyclerView, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        audiobookChapterAdapter.p(recyclerView, j10);
    }

    public final boolean t(int i10) {
        if (this.mDiffer.getCurrentList().get(i10) instanceof TXTChapter) {
            return true;
        }
        Boolean bool = this.chapterContentCacheFlags.get(Integer.valueOf(i10));
        return bool != null && bool.booleanValue();
    }

    public final boolean u(int r32) {
        Boolean bool;
        return (this.mDiffer.getCurrentList().get(r32) instanceof TXTChapter) || (bool = this.chapterFreeFlags.get(Integer.valueOf(r32))) == null || bool.booleanValue();
    }

    public final void B(@l a onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public final void C(boolean z10) {
        this.isReverseOrder = z10;
    }

    public final void D(@l List<? extends Chapter> newData, int currentPosition, @l Book book) {
        this.currentPosition = currentPosition;
        this.book = book;
        this.chapterContentCacheFlags.clear();
        this.chapterFreeFlags.clear();
        this.mDiffer.submitList(newData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.mDiffer.getCurrentList().size();
    }

    public final void p(@l RecyclerView recyclerView, long delayTimeMillis) {
        if (recyclerView != null) {
            Coroutine.Companion.async$default(Coroutine.INSTANCE, null, null, null, null, new AudiobookChapterAdapter$checkChapterListContentCached$1$1(delayTimeMillis, recyclerView, this, null), 15, null);
        }
    }

    public final void r(int i10, int i11) {
        if (i10 > i11) {
            return;
        }
        while (true) {
            this.chapterContentCacheFlags.remove(Integer.valueOf(i10));
            if (i10 == i11) {
                return;
            } else {
                i10++;
            }
        }
    }

    public final int s(int r22) {
        return this.isReverseOrder ? (this.mDiffer.getCurrentList().size() - r22) - 1 : r22;
    }

    /* renamed from: v, reason: from getter */
    public final boolean getIsReverseOrder() {
        return this.isReverseOrder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: w */
    public void onBindViewHolder(@k ViewHolder holder, int i10) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Chapter chapter = this.mDiffer.getCurrentList().get(i10);
        if (chapter != null) {
            holder.c(chapter);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: x */
    public void onBindViewHolder(@k ViewHolder holder, int r42, @k List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder(holder, r42, payloads);
        if (!(!payloads.isEmpty())) {
            Chapter chapter = this.mDiffer.getCurrentList().get(r42);
            if (chapter != null) {
                holder.c(chapter);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(payloads.get(0), (Object) 1)) {
            holder.e();
        } else if (Intrinsics.areEqual(payloads.get(0), (Object) 2)) {
            holder.f();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: y */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemAudioBookChapterBinding inflate = ItemAudioBookChapterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this, inflate);
    }

    public final void z(int i10) {
        notifyItemChanged(this.currentPosition, 2);
        this.currentPosition = i10;
        notifyItemChanged(i10, 2);
    }
}
