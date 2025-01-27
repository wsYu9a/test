package com.martian.mibook.mvvm.read.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.ItemBookMarkBinding;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.adapter.BookMarkListAdapter;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003123B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001e\u001a\u00020\u00072\n\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020\u00072\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002¢\u0006\u0004\b$\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R(\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u00060(R\u00020\u0000\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\"\u00100\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u000b0\u000b0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00064"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter$ViewHolder;", "<init>", "()V", "Lcom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter$b;", "onItemClickListener", "", "q", "(Lcom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter$b;)V", "", "Lcom/martian/mibook/lib/model/data/MiBookMark;", "newData", t.f11211k, "(Ljava/util/List;)V", "s", "", id.c.f26972i, "k", "(I)Lcom/martian/mibook/lib/model/data/MiBookMark;", "p", "(I)V", "getItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "o", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter$ViewHolder;", "holder", "n", "(Lcom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter$ViewHolder;I)V", "bookmarks", t.f11204d, "(Ljava/util/List;)Ljava/util/List;", "bookMarks", "m", "c", "Lcom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter$b;", "", "Lcom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter$a;", "d", "Ljava/util/Map;", "groupMarkMap", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", e.TAG, "Landroidx/recyclerview/widget/AsyncListDiffer;", "mDiffer", "a", "b", "ViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBookMarkListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BookMarkListAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,189:1\n1477#2:190\n1502#2,3:191\n1505#2,3:201\n1360#2:204\n1446#2,5:205\n1855#2,2:210\n372#3,7:194\n*S KotlinDebug\n*F\n+ 1 BookMarkListAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter\n*L\n58#1:190\n58#1:191,3\n58#1:201,3\n61#1:204\n61#1:205,5\n72#1:210,2\n58#1:194,7\n*E\n"})
/* loaded from: classes3.dex */
public final class BookMarkListAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public b onItemClickListener;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public Map<Integer, a> groupMarkMap;

    /* renamed from: e */
    @k
    public final AsyncListDiffer<MiBookMark> mDiffer = new AsyncListDiffer<>(this, new DiffUtil.ItemCallback<MiBookMark>() { // from class: com.martian.mibook.mvvm.read.adapter.BookMarkListAdapter$mDiffer$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a */
        public boolean areContentsTheSame(@k MiBookMark oldItem, @k MiBookMark newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.get_id(), newItem.get_id()) && Intrinsics.areEqual(oldItem.getMarkTime(), newItem.getMarkTime());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b */
        public boolean areItemsTheSame(@k MiBookMark oldItem, @k MiBookMark newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem) || Intrinsics.areEqual(oldItem.get_id(), newItem.get_id());
        }
    });

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemBookMarkBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter;Lcom/martian/mibook/databinding/ItemBookMarkBinding;)V", "Lcom/martian/mibook/lib/model/data/MiBookMark;", "bookMark", "", e.TAG, "(Lcom/martian/mibook/lib/model/data/MiBookMark;)V", "b", "Lcom/martian/mibook/databinding/ItemBookMarkBinding;", "f", "()Lcom/martian/mibook/databinding/ItemBookMarkBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemBookMarkBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ BookMarkListAdapter f14399d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@k BookMarkListAdapter bookMarkListAdapter, ItemBookMarkBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14399d = bookMarkListAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: cd.f

                /* renamed from: c */
                public final /* synthetic */ BookMarkListAdapter.ViewHolder f1807c;

                public /* synthetic */ f(BookMarkListAdapter.ViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookMarkListAdapter.ViewHolder.c(BookMarkListAdapter.this, this, view);
                }
            });
            binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: cd.g

                /* renamed from: c */
                public final /* synthetic */ BookMarkListAdapter.ViewHolder f1813c;

                public /* synthetic */ g(BookMarkListAdapter.ViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean d10;
                    d10 = BookMarkListAdapter.ViewHolder.d(BookMarkListAdapter.this, this, view);
                    return d10;
                }
            });
        }

        public static final void c(BookMarkListAdapter this$0, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            b bVar = this$0.onItemClickListener;
            if (bVar != null) {
                bVar.a(view, this$1.getBindingAdapterPosition());
            }
        }

        public static final boolean d(BookMarkListAdapter this$0, ViewHolder this$1, View view) {
            Boolean b10;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            b bVar = this$0.onItemClickListener;
            if (bVar == null || (b10 = bVar.b(view, this$1.getBindingAdapterPosition())) == null) {
                return false;
            }
            return b10.booleanValue();
        }

        public final void e(@k MiBookMark bookMark) {
            List<MiBookMark> c10;
            MiBookMark miBookMark;
            Intrinsics.checkNotNullParameter(bookMark, "bookMark");
            this.binding.tvChapterTitle.setText(ExtKt.c(bookMark.getChapterTitle()));
            Map map = this.f14399d.groupMarkMap;
            Integer num = null;
            a aVar = map != null ? (a) map.get(bookMark.getChapterIndex()) : null;
            if (aVar != null && (c10 = aVar.c()) != null && (miBookMark = (MiBookMark) CollectionsKt.first((List) c10)) != null) {
                num = miBookMark.get_id();
            }
            if (Intrinsics.areEqual(num, bookMark.get_id())) {
                this.binding.tvChapterTitle.setVisibility(0);
            } else {
                this.binding.tvChapterTitle.setVisibility(8);
            }
            MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
            this.binding.tvSummary.setTextColor(k10.getTextColorPrimary());
            Typeface g10 = MiConfigSingleton.b2().i2().g();
            this.binding.tvSummary.setTypeface(g10);
            this.binding.tvSummary.setIncludeFontPadding(Intrinsics.areEqual(g10, Typeface.DEFAULT));
            this.binding.tvSummary.setUnderLineColor(k10.getItemColorPrimary());
            Integer type = bookMark.getType();
            if (type != null && type.intValue() == 1) {
                this.binding.ivMarkType.setImageResource(R.drawable.icon_reading_book_underline);
                this.binding.tvSummary.setUseUnderline(true);
            } else {
                this.binding.ivMarkType.setImageResource(R.drawable.icon_reading_book_mark);
                this.binding.tvSummary.setUseUnderline(false);
            }
            this.binding.tvSummary.setText(ExtKt.c(bookMark.getSummary()));
        }

        @k
        /* renamed from: f, reason: from getter */
        public final ItemBookMarkBinding getBinding() {
            return this.binding;
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }
    }

    public final class a {

        /* renamed from: a */
        @l
        public Integer f14400a;

        /* renamed from: b */
        @l
        public String f14401b;

        /* renamed from: c */
        @k
        public List<MiBookMark> f14402c = new ArrayList();

        public a() {
        }

        @l
        public final Integer a() {
            return this.f14400a;
        }

        @l
        public final String b() {
            return this.f14401b;
        }

        @k
        public final List<MiBookMark> c() {
            return this.f14402c;
        }

        public final void d(@l Integer num) {
            this.f14400a = num;
        }

        public final void e(@l String str) {
            this.f14401b = str;
        }

        public final void f(@k List<MiBookMark> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.f14402c = list;
        }
    }

    public interface b {
        void a(@l View view, int i10);

        @l
        Boolean b(@l View view, int i10);
    }

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 BookMarkListAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter\n*L\n1#1,328:1\n63#2:329\n*E\n"})
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return ComparisonsKt.compareValues(((MiBookMark) t10).getContentPos(), ((MiBookMark) t11).getContentPos());
        }
    }

    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1\n+ 2 BookMarkListAdapter.kt\ncom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter\n*L\n1#1,328:1\n64#2:329\n*E\n"})
    public static final class d<T> implements Comparator {

        /* renamed from: b */
        public final /* synthetic */ Comparator f14404b;

        public d(Comparator comparator) {
            this.f14404b = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int compare = this.f14404b.compare(t10, t11);
            return compare != 0 ? compare : ComparisonsKt.compareValues(((MiBookMark) t10).getMarkTime(), ((MiBookMark) t11).getMarkTime());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.mDiffer.getCurrentList().size();
    }

    @l
    public final MiBookMark k(int r22) {
        if (r22 < 0 || r22 >= this.mDiffer.getCurrentList().size()) {
            return null;
        }
        return this.mDiffer.getCurrentList().get(r22);
    }

    public final List<MiBookMark> l(List<? extends MiBookMark> list) {
        List<? extends MiBookMark> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Integer chapterIndex = ((MiBookMark) obj).getChapterIndex();
            Object obj2 = linkedHashMap.get(chapterIndex);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(chapterIndex, obj2);
            }
            ((List) obj2).add(obj);
        }
        Collection<List> values = MapsKt.toSortedMap(linkedHashMap).values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (List list3 : values) {
            Intrinsics.checkNotNull(list3);
            CollectionsKt.addAll(arrayList, CollectionsKt.sortedWith(list3, new d(new c())));
        }
        return arrayList;
    }

    public final void m(List<? extends MiBookMark> bookMarks) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (bookMarks != null) {
            for (MiBookMark miBookMark : bookMarks) {
                if (linkedHashMap.containsKey(miBookMark.getChapterIndex())) {
                    a aVar = (a) linkedHashMap.get(miBookMark.getChapterIndex());
                    if (aVar != null) {
                        aVar.c().add(miBookMark);
                    }
                } else {
                    a aVar2 = new a();
                    aVar2.d(miBookMark.getChapterIndex());
                    aVar2.e(miBookMark.getChapterTitle());
                    aVar2.f(CollectionsKt.mutableListOf(miBookMark));
                    Integer chapterIndex = miBookMark.getChapterIndex();
                    Intrinsics.checkNotNullExpressionValue(chapterIndex, "getChapterIndex(...)");
                    linkedHashMap.put(chapterIndex, aVar2);
                }
            }
        }
        this.groupMarkMap = linkedHashMap;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@k ViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MiBookMark miBookMark = this.mDiffer.getCurrentList().get(r32);
        if (miBookMark != null) {
            holder.e(miBookMark);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: o */
    public ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemBookMarkBinding inflate = ItemBookMarkBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(this, inflate);
    }

    public final void p(int r62) {
        MiBookMark k10 = k(r62);
        if (k10 != null) {
            List<MiBookMark> currentList = this.mDiffer.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            List<MiBookMark> mutableList = CollectionsKt.toMutableList((Collection) currentList);
            mutableList.remove(k10);
            Map<Integer, a> map = this.groupMarkMap;
            a aVar = map != null ? map.get(k10.getChapterIndex()) : null;
            int i10 = -1;
            if (aVar != null) {
                aVar.c().remove(k10);
                if (aVar.c().isEmpty()) {
                    Map<Integer, a> map2 = this.groupMarkMap;
                    if (map2 != null) {
                        map2.remove(k10.getChapterIndex());
                    }
                } else {
                    i10 = r62 + 1;
                }
            }
            this.mDiffer.submitList(mutableList);
            notifyItemChanged(i10);
        }
    }

    public final void q(@k b onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.onItemClickListener = onItemClickListener;
    }

    public final void r(@l List<? extends MiBookMark> list) {
        List<MiBookMark> l10 = l(list);
        m(l10);
        this.mDiffer.submitList(l10);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void s() {
        notifyDataSetChanged();
    }
}
