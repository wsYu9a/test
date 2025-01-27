package com.martian.mibook.mvvm.read.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.ItemReadingBookChapterBinding;
import com.martian.mibook.lib.local.txt.data.TXTChapter;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.adapter.ReadingBookChapterListAdapter;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\b\u0016\u0018\u0000 V2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0006WXYZ[\\B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J1\u0010\u0018\u001a\u00020\r2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\bJ\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\bJ#\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010)J1\u0010.\u001a\u00020\r2\n\u0010*\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016¢\u0006\u0004\b.\u0010/J#\u00100\u001a\u00020\r2\n\u0010*\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b0\u00101J\u001d\u00104\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005¢\u0006\u0004\b4\u00105J!\u0010:\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u0001062\b\b\u0002\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\rH\u0007¢\u0006\u0004\b<\u0010\u0004R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000b0+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\"\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010IR\"\u0010S\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010N¨\u0006]"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$BaseViewHolder;", "<init>", "()V", "", c.f26972i, "v", "(I)I", IAdInterListener.AdReqParam.WIDTH, BaseReadAloudService.f15168x, "Lcom/martian/mibook/lib/model/data/abs/Chapter;", "chapter", "", "q", "(ILcom/martian/mibook/lib/model/data/abs/Chapter;)V", "", "x", "(I)Z", "y", "", "newData", "Lcom/martian/mibook/lib/model/data/abs/Book;", "book", "G", "(Ljava/util/List;ILcom/martian/mibook/lib/model/data/abs/Book;)V", "withCoverLastPageChapterIndex", "D", "(I)V", "Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$b;", "onItemClickListener", ExifInterface.LONGITUDE_EAST, "(Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$b;)V", "u", "getItemViewType", "Landroid/view/ViewGroup;", "parent", "viewType", "C", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$BaseViewHolder;", "getItemCount", "()I", "holder", "", "", "payloads", "B", "(Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$BaseViewHolder;ILjava/util/List;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$BaseViewHolder;I)V", "startIndex", "endIndex", bt.aO, "(II)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "delayTimeMillis", t.f11211k, "(Landroidx/recyclerview/widget/RecyclerView;J)V", "H", "c", "I", "currentPosition", "d", "Lcom/martian/mibook/lib/model/data/abs/Book;", e.TAG, "Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$b;", "f", "Ljava/util/List;", "dataItems", "", "g", "Ljava/util/Map;", "chapterContentCacheFlags", "h", "chapterFreeFlags", "i", "Z", bt.aJ, "()Z", "F", "(Z)V", "isReverseOrder", "j", "isOnlineBook", "k", "BaseViewHolder", "a", "FooterViewHolder", "HeaderViewHolder", "ItemViewHolder", "b", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReadingBookChapterListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadingBookChapterListAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter\n+ 2 ArrayMap.kt\nandroidx/collection/ArrayMapKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,339:1\n22#2:340\n22#2:341\n1#3:342\n*S KotlinDebug\n*F\n+ 1 ReadingBookChapterListAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter\n*L\n33#1:340\n36#1:341\n*E\n"})
/* loaded from: classes3.dex */
public final class ReadingBookChapterListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    /* renamed from: l */
    public static final int f14524l = 0;

    /* renamed from: m */
    public static final int f14525m = 1;

    /* renamed from: n */
    public static final int f14526n = 2;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public Book book;

    /* renamed from: e */
    @l
    public b onItemClickListener;

    /* renamed from: i, reason: from kotlin metadata */
    public boolean isReverseOrder;

    /* renamed from: c, reason: from kotlin metadata */
    public int currentPosition = -1;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public List<Chapter> dataItems = new ArrayList();

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public Map<Integer, Boolean> chapterContentCacheFlags = new ArrayMap();

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public Map<Integer, Boolean> chapterFreeFlags = new ArrayMap();

    /* renamed from: j, reason: from kotlin metadata */
    public boolean isOnlineBook = true;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemReadingBookChapterBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter;Lcom/martian/mibook/databinding/ItemReadingBookChapterBinding;)V", "", "a", "()V", "c", "b", "Lcom/martian/mibook/databinding/ItemReadingBookChapterBinding;", "()Lcom/martian/mibook/databinding/ItemReadingBookChapterBinding;", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemReadingBookChapterBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ ReadingBookChapterListAdapter f14537d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@k ReadingBookChapterListAdapter readingBookChapterListAdapter, ItemReadingBookChapterBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14537d = readingBookChapterListAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
        }

        public void a() {
        }

        @k
        /* renamed from: b, reason: from getter */
        public final ItemReadingBookChapterBinding getBinding() {
            return this.binding;
        }

        public final void c() {
            MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
            this.binding.tvChapterStatus.setTextColor(k10.getTextColorThirdly());
            if (this.f14537d.currentPosition != getBindingAdapterPosition()) {
                this.binding.ivChapterPosition.setVisibility(8);
                this.binding.tvChapterTitle.setTextColor(k10.getTextColorPrimary());
            } else {
                this.binding.ivChapterPosition.setVisibility(0);
                this.binding.tvChapterTitle.setTextColor(k10.getItemColorPrimary());
                this.binding.ivChapterPosition.setColorFilter(k10.getItemColorPrimary());
            }
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$FooterViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$BaseViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter;", "Lcom/martian/mibook/databinding/ItemReadingBookChapterBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter;Lcom/martian/mibook/databinding/ItemReadingBookChapterBinding;)V", "", "a", "()V", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class FooterViewHolder extends BaseViewHolder {

        /* renamed from: e */
        public final /* synthetic */ ReadingBookChapterListAdapter f14538e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FooterViewHolder(@k ReadingBookChapterListAdapter readingBookChapterListAdapter, ItemReadingBookChapterBinding binding) {
            super(readingBookChapterListAdapter, binding);
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14538e = readingBookChapterListAdapter;
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: cd.t1
                public /* synthetic */ t1() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingBookChapterListAdapter.FooterViewHolder.e(ReadingBookChapterListAdapter.this, view);
                }
            });
        }

        public static final void e(ReadingBookChapterListAdapter this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            b bVar = this$0.onItemClickListener;
            if (bVar != null) {
                bVar.a(this$0.getPageSize() - 2);
            }
        }

        @Override // com.martian.mibook.mvvm.read.adapter.ReadingBookChapterListAdapter.BaseViewHolder
        public void a() {
            getBinding().tvChapterTitle.setText(ExtKt.c("书末页"));
            c();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$HeaderViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$BaseViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter;", "Lcom/martian/mibook/databinding/ItemReadingBookChapterBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter;Lcom/martian/mibook/databinding/ItemReadingBookChapterBinding;)V", "", "a", "()V", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class HeaderViewHolder extends BaseViewHolder {

        /* renamed from: e */
        public final /* synthetic */ ReadingBookChapterListAdapter f14539e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(@k ReadingBookChapterListAdapter readingBookChapterListAdapter, ItemReadingBookChapterBinding binding) {
            super(readingBookChapterListAdapter, binding);
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14539e = readingBookChapterListAdapter;
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: cd.u1
                public /* synthetic */ u1() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingBookChapterListAdapter.HeaderViewHolder.e(ReadingBookChapterListAdapter.this, view);
                }
            });
        }

        public static final void e(ReadingBookChapterListAdapter this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            b bVar = this$0.onItemClickListener;
            if (bVar != null) {
                bVar.a(-1);
            }
        }

        @Override // com.martian.mibook.mvvm.read.adapter.ReadingBookChapterListAdapter.BaseViewHolder
        public void a() {
            getBinding().tvChapterTitle.setText(ExtKt.c("书封页"));
            c();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$ItemViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter$BaseViewHolder;", "Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter;", "Lcom/martian/mibook/databinding/ItemReadingBookChapterBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/ReadingBookChapterListAdapter;Lcom/martian/mibook/databinding/ItemReadingBookChapterBinding;)V", "Lcom/martian/mibook/lib/model/data/abs/Chapter;", "chapter", "", "f", "(Lcom/martian/mibook/lib/model/data/abs/Chapter;)V", "g", "()V", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ItemViewHolder extends BaseViewHolder {

        /* renamed from: e */
        public final /* synthetic */ ReadingBookChapterListAdapter f14540e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(@k ReadingBookChapterListAdapter readingBookChapterListAdapter, ItemReadingBookChapterBinding binding) {
            super(readingBookChapterListAdapter, binding);
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14540e = readingBookChapterListAdapter;
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: cd.v1

                /* renamed from: c */
                public final /* synthetic */ ReadingBookChapterListAdapter.ItemViewHolder f1897c;

                public /* synthetic */ v1(ReadingBookChapterListAdapter.ItemViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingBookChapterListAdapter.ItemViewHolder.e(ReadingBookChapterListAdapter.this, this, view);
                }
            });
        }

        public static final void e(ReadingBookChapterListAdapter this$0, ItemViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            b bVar = this$0.onItemClickListener;
            if (bVar != null) {
                bVar.a(this$0.v(this$1.getBindingAdapterPosition()));
            }
        }

        public final void f(@k Chapter chapter) {
            Intrinsics.checkNotNullParameter(chapter, "chapter");
            getBinding().tvChapterTitle.setText(ExtKt.c(chapter.getTitle()));
            c();
            g();
        }

        public final void g() {
            if (this.f14540e.x(getBindingAdapterPosition())) {
                getBinding().tvChapterStatus.setVisibility(0);
                getBinding().tvChapterStatus.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.cached));
            } else if (this.f14540e.y(getBindingAdapterPosition())) {
                getBinding().tvChapterStatus.setVisibility(4);
            } else {
                getBinding().tvChapterStatus.setVisibility(0);
                getBinding().tvChapterStatus.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.locked));
            }
        }
    }

    public interface b {
        void a(int i10);
    }

    public final void q(int r42, Chapter chapter) {
        Book book;
        if (chapter == null || (chapter instanceof TXTChapter) || (book = this.book) == null) {
            return;
        }
        if (this.isOnlineBook) {
            int i10 = this.currentPosition;
            if ((i10 - 1 == r42 || i10 == r42 || i10 + 1 == r42) && this.chapterContentCacheFlags.containsKey(Integer.valueOf(r42)) && Intrinsics.areEqual(this.chapterContentCacheFlags.get(Integer.valueOf(r42)), Boolean.FALSE)) {
                this.chapterContentCacheFlags.remove(Integer.valueOf(r42));
            }
        }
        if (this.chapterContentCacheFlags.containsKey(Integer.valueOf(r42))) {
            return;
        }
        if (this.isOnlineBook) {
            this.chapterContentCacheFlags.put(Integer.valueOf(r42), Boolean.valueOf(MiConfigSingleton.b2().M1().c0(new Source(book.getSourceName(), book.getSourceId()), chapter)));
            this.chapterFreeFlags.put(Integer.valueOf(r42), Boolean.valueOf(chapter.isFree()));
        } else {
            Integer valueOf = Integer.valueOf(r42);
            Map<Integer, Boolean> map = this.chapterContentCacheFlags;
            Boolean bool = Boolean.TRUE;
            map.put(valueOf, bool);
            this.chapterFreeFlags.put(Integer.valueOf(r42), bool);
        }
    }

    public static /* synthetic */ void s(ReadingBookChapterListAdapter readingBookChapterListAdapter, RecyclerView recyclerView, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        readingBookChapterListAdapter.r(recyclerView, j10);
    }

    public final boolean x(int r32) {
        if (!this.isOnlineBook) {
            return true;
        }
        int w10 = w(r32);
        if (this.dataItems.get(w10) instanceof TXTChapter) {
            return true;
        }
        Boolean bool = this.chapterContentCacheFlags.get(Integer.valueOf(w10));
        return bool != null && bool.booleanValue();
    }

    public final boolean y(int r32) {
        Boolean bool;
        if (!this.isOnlineBook) {
            return true;
        }
        int w10 = w(r32);
        return (this.dataItems.get(w10) instanceof TXTChapter) || (bool = this.chapterFreeFlags.get(Integer.valueOf(w10))) == null || bool.booleanValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: A */
    public void onBindViewHolder(@k BaseViewHolder holder, int i10) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (!(holder instanceof ItemViewHolder)) {
            holder.a();
            return;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.f(this.dataItems.get(w(i10)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: B */
    public void onBindViewHolder(@k BaseViewHolder holder, int r42, @k List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!(!payloads.isEmpty())) {
            onBindViewHolder(holder, r42);
            return;
        }
        if (Intrinsics.areEqual(payloads.get(0), (Object) 1)) {
            if (holder instanceof ItemViewHolder) {
                ((ItemViewHolder) holder).g();
            }
        } else if (Intrinsics.areEqual(payloads.get(0), (Object) 2)) {
            holder.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: C */
    public BaseViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemReadingBookChapterBinding inflate = ItemReadingBookChapterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        if (viewType == 0) {
            return new HeaderViewHolder(this, inflate);
        }
        if (viewType == 1) {
            return new ItemViewHolder(this, inflate);
        }
        if (viewType == 2) {
            return new FooterViewHolder(this, inflate);
        }
        throw new IllegalArgumentException("Invalid view type");
    }

    public final void D(int withCoverLastPageChapterIndex) {
        int i10 = this.currentPosition;
        int u10 = u(withCoverLastPageChapterIndex);
        this.currentPosition = u10;
        if (i10 != u10) {
            notifyItemChanged(i10, 2);
            notifyItemChanged(this.currentPosition, 2);
        }
    }

    public final void E(@l b bVar) {
        this.onItemClickListener = bVar;
    }

    public final void F(boolean z10) {
        this.isReverseOrder = z10;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void G(@l List<? extends Chapter> newData, int r32, @l Book book) {
        this.book = book;
        this.isOnlineBook = !(book != null ? book.isLocal() : true);
        this.currentPosition = u(r32);
        this.chapterContentCacheFlags.clear();
        this.chapterFreeFlags.clear();
        this.dataItems.clear();
        if (newData != null) {
            this.dataItems.addAll(newData);
        }
        notifyDataSetChanged();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void H() {
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.dataItems.size() + (this.isOnlineBook ? 2 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r32) {
        if (!this.isOnlineBook) {
            return 1;
        }
        if (r32 == 0) {
            return 0;
        }
        return r32 == getPageSize() - 1 ? 2 : 1;
    }

    public final void r(@l RecyclerView recyclerView, long j10) {
        if (this.isOnlineBook && recyclerView != null) {
            Coroutine.Companion.async$default(Coroutine.INSTANCE, null, null, null, null, new ReadingBookChapterListAdapter$checkChapterListContentCached$1$1(j10, recyclerView, this, null), 15, null);
        }
    }

    public final void t(int i10, int i11) {
        if (!this.isOnlineBook || i10 > i11) {
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

    public final int u(int r22) {
        return r22 + (this.isOnlineBook ? 1 : 0);
    }

    public final int v(int r22) {
        if (!this.isOnlineBook) {
            return w(r22);
        }
        if (r22 <= 0) {
            return -1;
        }
        return r22 >= getPageSize() ? this.dataItems.size() : r22 - 1;
    }

    public final int w(int i10) {
        if (i10 <= 0) {
            return 0;
        }
        return i10 > this.dataItems.size() ? this.dataItems.size() - 1 : i10 - (this.isOnlineBook ? 1 : 0);
    }

    /* renamed from: z, reason: from getter */
    public final boolean getIsReverseOrder() {
        return this.isReverseOrder;
    }
}
