package com.martian.mibook.mvvm.read.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.BookCoverReadingGridItemBinding;
import com.martian.mibook.databinding.BookCoverReadingListItemBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.read.adapter.ReadingExitRecommendBookAdapter;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import je.i;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u000389:B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\f\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010!J!\u0010#\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b#\u0010$R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u0007R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010.\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006;"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReadingExitRecommendBookAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "", "isPortrait", "<init>", "(Z)V", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "bookList", "", "n", "(Ljava/util/List;Z)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "holder", c.f26972i, "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Lcom/martian/mibook/mvvm/read/adapter/ReadingExitRecommendBookAdapter$a;", "onClickListener", t.f11204d, "(Lcom/martian/mibook/mvvm/read/adapter/ReadingExitRecommendBookAdapter$a;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "onItemViewVisible", "(ILandroidx/recyclerview/widget/RecyclerView;)V", "c", "Z", "k", "()Z", "m", "d", "Lcom/martian/mibook/mvvm/read/adapter/ReadingExitRecommendBookAdapter$a;", e.TAG, "Ljava/util/List;", "mDataList", "", "", "f", "Ljava/util/Set;", "sourceIdSet", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "g", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "recyclerViewExposeManager", "a", "ViewHolderScreenLandscape", "ViewHolderScreenPortrait", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReadingExitRecommendBookAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements RecyclerViewExposeManager.OnItemExposeListener {

    /* renamed from: c, reason: from kotlin metadata */
    public boolean isPortrait;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public a onClickListener;

    /* renamed from: e */
    @l
    public List<? extends TYBookItem> mDataList;

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Set<String> sourceIdSet;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public RecyclerViewExposeManager recyclerViewExposeManager;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReadingExitRecommendBookAdapter$ViewHolderScreenLandscape;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/BookCoverReadingGridItemBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/ReadingExitRecommendBookAdapter;Lcom/martian/mibook/databinding/BookCoverReadingGridItemBinding;)V", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "book", "", e.TAG, "(Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "b", "Lcom/martian/mibook/databinding/BookCoverReadingGridItemBinding;", "f", "()Lcom/martian/mibook/databinding/BookCoverReadingGridItemBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolderScreenLandscape extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final BookCoverReadingGridItemBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ ReadingExitRecommendBookAdapter f14548d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderScreenLandscape(@k ReadingExitRecommendBookAdapter readingExitRecommendBookAdapter, BookCoverReadingGridItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14548d = readingExitRecommendBookAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.bookCover.setOnClickListener(new View.OnClickListener() { // from class: cd.w1

                /* renamed from: c */
                public final /* synthetic */ ReadingExitRecommendBookAdapter f1903c;

                public /* synthetic */ w1(ReadingExitRecommendBookAdapter readingExitRecommendBookAdapter2) {
                    readingExitRecommendBookAdapter = readingExitRecommendBookAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingExitRecommendBookAdapter.ViewHolderScreenLandscape.c(ReadingExitRecommendBookAdapter.ViewHolderScreenLandscape.this, readingExitRecommendBookAdapter, view);
                }
            });
            binding.gridItemView.setOnClickListener(new View.OnClickListener() { // from class: cd.x1

                /* renamed from: c */
                public final /* synthetic */ ReadingExitRecommendBookAdapter f1908c;

                public /* synthetic */ x1(ReadingExitRecommendBookAdapter readingExitRecommendBookAdapter2) {
                    readingExitRecommendBookAdapter = readingExitRecommendBookAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingExitRecommendBookAdapter.ViewHolderScreenLandscape.d(ReadingExitRecommendBookAdapter.ViewHolderScreenLandscape.this, readingExitRecommendBookAdapter, view);
                }
            });
        }

        public static final void c(ViewHolderScreenLandscape this$0, ReadingExitRecommendBookAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            List list = this$1.mDataList;
            TYBookItem tYBookItem = list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null;
            Context context = this$0.com.umeng.analytics.pro.f.X java.lang.String;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                ac.a.y(context, "退出弹窗-推荐-阅读");
                i.H(activity, tYBookItem);
            }
        }

        public static final void d(ViewHolderScreenLandscape this$0, ReadingExitRecommendBookAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            List list = this$1.mDataList;
            TYBookItem tYBookItem = list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null;
            Context context = this$0.com.umeng.analytics.pro.f.X java.lang.String;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                ac.a.y(context, "退出弹窗-推荐-阅读");
                i.H(activity, tYBookItem);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public final void e(@l TYBookItem tYBookItem) {
            MiBookManager.u1(this.com.umeng.analytics.pro.f.X java.lang.String, tYBookItem, this.binding.bookCover);
            this.binding.rdBookName.setText(tYBookItem != null ? tYBookItem.getBookName() : null);
            this.binding.rdBookAuthorName.setText(tYBookItem != null ? tYBookItem.getBookInfo() : null);
            String categoryInfo = tYBookItem != null ? tYBookItem.getCategoryInfo() : null;
            if (!TextUtils.isEmpty(categoryInfo)) {
                this.binding.rdBookAuthorName.setText(categoryInfo);
            }
            int score = tYBookItem != null ? tYBookItem.getScore() : 0;
            if (score <= 0) {
                this.binding.rdBookScore.setVisibility(8);
                return;
            }
            this.binding.rdBookScore.setVisibility(0);
            double d10 = score / 10.0d;
            TextView textView = this.binding.rdBookScore;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d10)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format + "分");
            this.binding.rdBookAuthorName.setVisibility(8);
        }

        @k
        /* renamed from: f, reason: from getter */
        public final BookCoverReadingGridItemBinding getBinding() {
            return this.binding;
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/martian/mibook/mvvm/read/adapter/ReadingExitRecommendBookAdapter$ViewHolderScreenPortrait;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/BookCoverReadingListItemBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/read/adapter/ReadingExitRecommendBookAdapter;Lcom/martian/mibook/databinding/BookCoverReadingListItemBinding;)V", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "book", "", "g", "(Lcom/martian/mibook/lib/model/data/TYBookItem;)V", "b", "Lcom/martian/mibook/databinding/BookCoverReadingListItemBinding;", "h", "()Lcom/martian/mibook/databinding/BookCoverReadingListItemBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ViewHolderScreenPortrait extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final BookCoverReadingListItemBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ ReadingExitRecommendBookAdapter f14551d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderScreenPortrait(@k ReadingExitRecommendBookAdapter readingExitRecommendBookAdapter, BookCoverReadingListItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f14551d = readingExitRecommendBookAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.bookCover.setOnClickListener(new View.OnClickListener() { // from class: cd.y1

                /* renamed from: c */
                public final /* synthetic */ ReadingExitRecommendBookAdapter f1912c;

                public /* synthetic */ y1(ReadingExitRecommendBookAdapter readingExitRecommendBookAdapter2) {
                    readingExitRecommendBookAdapter = readingExitRecommendBookAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingExitRecommendBookAdapter.ViewHolderScreenPortrait.d(ReadingExitRecommendBookAdapter.ViewHolderScreenPortrait.this, readingExitRecommendBookAdapter, view);
                }
            });
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: cd.z1

                /* renamed from: c */
                public final /* synthetic */ ReadingExitRecommendBookAdapter f1916c;

                public /* synthetic */ z1(ReadingExitRecommendBookAdapter readingExitRecommendBookAdapter2) {
                    readingExitRecommendBookAdapter = readingExitRecommendBookAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingExitRecommendBookAdapter.ViewHolderScreenPortrait.e(ReadingExitRecommendBookAdapter.ViewHolderScreenPortrait.this, readingExitRecommendBookAdapter, view);
                }
            });
            binding.llAddBookshelf.setOnClickListener(new View.OnClickListener() { // from class: cd.a2

                /* renamed from: c */
                public final /* synthetic */ ReadingExitRecommendBookAdapter f1776c;

                public /* synthetic */ a2(ReadingExitRecommendBookAdapter readingExitRecommendBookAdapter2) {
                    readingExitRecommendBookAdapter = readingExitRecommendBookAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingExitRecommendBookAdapter.ViewHolderScreenPortrait.f(ReadingExitRecommendBookAdapter.ViewHolderScreenPortrait.this, readingExitRecommendBookAdapter, view);
                }
            });
        }

        public static final void d(ViewHolderScreenPortrait this$0, ReadingExitRecommendBookAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            List list = this$1.mDataList;
            TYBookItem tYBookItem = list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null;
            Context context = this$0.com.umeng.analytics.pro.f.X java.lang.String;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                ac.a.y(context, "退出弹窗-推荐-阅读");
                i.H(activity, tYBookItem);
            }
        }

        public static final void e(ViewHolderScreenPortrait this$0, ReadingExitRecommendBookAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            List list = this$1.mDataList;
            TYBookItem tYBookItem = list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null;
            Context context = this$0.com.umeng.analytics.pro.f.X java.lang.String;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                ac.a.y(context, "退出弹窗-推荐-阅读");
                i.H(activity, tYBookItem);
            }
        }

        public static final void f(ViewHolderScreenPortrait this$0, ReadingExitRecommendBookAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            List list = this$1.mDataList;
            TYBookItem tYBookItem = list != null ? (TYBookItem) list.get(bindingAdapterPosition) : null;
            this$0.binding.llAddBookshelf.setEnabled(false);
            this$0.binding.llAddBookshelf.setAlpha(0.5f);
            a aVar = this$1.onClickListener;
            if (aVar != null) {
                ThemeTextView tvAddShelf = this$0.binding.tvAddShelf;
                Intrinsics.checkNotNullExpressionValue(tvAddShelf, "tvAddShelf");
                aVar.a(tYBookItem, tvAddShelf);
            }
        }

        @SuppressLint({"SetTextI18n"})
        public final void g(@l TYBookItem book) {
            MiBookManager.u1(this.com.umeng.analytics.pro.f.X java.lang.String, book, this.binding.bookCover);
            this.binding.rdBookName.setText(book != null ? book.getBookName() : null);
            this.binding.rdBookShortContent.setText(ba.l.y(book != null ? book.getShortIntro() : null));
            this.binding.rdBookAuthorName.setText(book != null ? book.getBookInfo() : null);
            if (!TextUtils.isEmpty(book != null ? book.getRecTitle() : null)) {
                this.binding.rdBookAuthorName.setText(book != null ? book.getRecTitle() : null);
            }
            int score = book != null ? book.getScore() : 0;
            if (score > 0) {
                this.binding.rdBookScore.setVisibility(0);
                double d10 = score / 10.0d;
                TextView textView = this.binding.rdBookScore;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d10)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format + "分");
                if (!this.f14551d.getIsPortrait()) {
                    this.binding.rdBookAuthorName.setVisibility(8);
                }
            } else {
                this.binding.rdBookScore.setVisibility(8);
            }
            boolean i02 = MiConfigSingleton.b2().M1().i0(book != null ? book.getSourceString() : null);
            if (book != null) {
                book.setInBookStore(i02);
            }
            if (i02) {
                this.binding.llAddBookshelf.setAlpha(0.5f);
                this.binding.llAddBookshelf.setEnabled(false);
                this.binding.tvAddShelf.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.already_in_bookrack));
            } else {
                this.binding.llAddBookshelf.setAlpha(1.0f);
                this.binding.llAddBookshelf.setEnabled(true);
                this.binding.tvAddShelf.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(R.string.add_to_book_store));
            }
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }

        @k
        /* renamed from: h, reason: from getter */
        public final BookCoverReadingListItemBinding getBinding() {
            return this.binding;
        }
    }

    public interface a {
        void a(@l TYBookItem tYBookItem, @k TextView textView);
    }

    public ReadingExitRecommendBookAdapter() {
        this(false, 1, null);
    }

    public static /* synthetic */ void o(ReadingExitRecommendBookAdapter readingExitRecommendBookAdapter, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        readingExitRecommendBookAdapter.n(list, z10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<? extends TYBookItem> list = this.mDataList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsPortrait() {
        return this.isPortrait;
    }

    public final void l(@k a onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.onClickListener = onClickListener;
    }

    public final void m(boolean z10) {
        this.isPortrait = z10;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void n(@l List<? extends TYBookItem> bookList, boolean isPortrait) {
        this.mDataList = bookList;
        this.isPortrait = isPortrait;
        notifyDataSetChanged();
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            RecyclerViewExposeManager.handleCurrentVisibleItems$default(recyclerViewExposeManager, false, 0L, 3, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@k RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        if (this.recyclerViewExposeManager == null) {
            this.recyclerViewExposeManager = new RecyclerViewExposeManager();
        }
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            recyclerViewExposeManager.setRecyclerItemExposeListener(recyclerView, this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@k RecyclerView.ViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<? extends TYBookItem> list = this.mDataList;
        TYBookItem tYBookItem = list != null ? list.get(r32) : null;
        if (holder instanceof ViewHolderScreenPortrait) {
            ((ViewHolderScreenPortrait) holder).g(tYBookItem);
        } else if (holder instanceof ViewHolderScreenLandscape) {
            ((ViewHolderScreenLandscape) holder).e(tYBookItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    public RecyclerView.ViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.isPortrait) {
            BookCoverReadingListItemBinding inflate = BookCoverReadingListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new ViewHolderScreenPortrait(this, inflate);
        }
        BookCoverReadingGridItemBinding inflate2 = BookCoverReadingGridItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new ViewHolderScreenLandscape(this, inflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@k RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        RecyclerViewExposeManager recyclerViewExposeManager = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager != null) {
            recyclerViewExposeManager.removeRecyclerItemExposeListener();
        }
    }

    @Override // com.martian.mibook.mvvm.utils.RecyclerViewExposeManager.OnItemExposeListener
    public void onItemViewVisible(int r92, @l RecyclerView recyclerView) {
        List<? extends TYBookItem> list;
        TYBookItem tYBookItem;
        List<? extends TYBookItem> list2 = this.mDataList;
        if (list2 == null || list2.isEmpty() || getPageSize() <= r92 || (list = this.mDataList) == null || (tYBookItem = list.get(r92)) == null) {
            return;
        }
        Set<String> set = this.sourceIdSet;
        String sourceId = tYBookItem.getSourceId();
        Intrinsics.checkNotNullExpressionValue(sourceId, "getSourceId(...)");
        if (set.add(sourceId)) {
            if (r92 == 0) {
                Context context = recyclerView != null ? recyclerView.getContext() : null;
                ac.a.K(context, tYBookItem.getRecommend() + tYBookItem.getSource(), "展示");
            }
            MiConfigSingleton.b2().V1().g(0, tYBookItem.getSourceName(), tYBookItem.getSourceId(), tYBookItem.getRecommendId(), "", "展示");
        }
    }

    public /* synthetic */ ReadingExitRecommendBookAdapter(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? true : z10);
    }

    public ReadingExitRecommendBookAdapter(boolean z10) {
        this.isPortrait = z10;
        this.sourceIdSet = new HashSet();
    }
}
