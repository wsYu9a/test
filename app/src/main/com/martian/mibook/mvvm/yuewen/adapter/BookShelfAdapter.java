package com.martian.mibook.mvvm.yuewen.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemBookShelfGridAdBinding;
import com.martian.mibook.databinding.ItemBookShelfGridAdderBinding;
import com.martian.mibook.databinding.ItemBookShelfGridBinding;
import com.martian.mibook.databinding.ItemBookShelfListAdBinding;
import com.martian.mibook.databinding.ItemBookShelfListAdderBinding;
import com.martian.mibook.databinding.ItemBookShelfListBinding;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.BookrackCategoryManager;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.utils.RecyclerViewExposeManager;
import com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import com.umeng.ccg.a;
import id.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import l9.m0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000e\b\u0016\u0018\u0000 T2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\tUVWXYZ[\\]B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0011J\u001d\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001b\u0010\u0005J\r\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u0005J\u0015\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\"\u0010 J\r\u0010#\u001a\u00020\t¢\u0006\u0004\b#\u0010\u0005J\u0015\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\t2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b,\u0010+J\r\u0010-\u001a\u00020\t¢\u0006\u0004\b-\u0010\u0005J\u0017\u0010.\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b.\u0010/J#\u00103\u001a\u00060\u0002R\u00020\u00002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u0012H\u0016¢\u0006\u0004\b3\u00104J#\u00106\u001a\u00020\t2\n\u00105\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0012H\u0016¢\u0006\u0004\b8\u0010\u0014J!\u00109\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\t2\u0006\u0010;\u001a\u00020\fH\u0002¢\u0006\u0004\b<\u0010\u000fJ\u0015\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010!\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00070P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006^"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$BaseBookViewHolder;", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager$OnItemExposeListener;", "<init>", "()V", "", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "newData", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/util/List;)V", "", a.f24245v, IAdInterListener.AdReqParam.WIDTH, "(Z)V", "p", "()Z", "", "n", "()I", "o", "q", "bookWrapper", c.f26972i, t.f11211k, "(Lcom/martian/mibook/lib/model/data/BookWrapper;I)V", "v", "k", "", "keyword", "x", "(Ljava/lang/String;)V", "category", "y", "B", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$b;", "onItemClickListener", bt.aJ, "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$b;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "m", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", bt.aO, "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$BaseBookViewHolder;", "holder", "s", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$BaseBookViewHolder;I)V", "getItemCount", "onItemViewVisible", "(ILandroidx/recyclerview/widget/RecyclerView;)V", "selectAll", "u", t.f11204d, "()Ljava/util/List;", "c", "Z", "isBatch", "d", "I", "selectNumber", e.TAG, "Ljava/lang/String;", "f", "bookNameKeyword", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "g", "Lcom/martian/mibook/mvvm/utils/RecyclerViewExposeManager;", "recyclerViewExposeManager", "h", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$b;", "mOnItemClickListener", "", "i", "Ljava/util/List;", "bookWrapperList", "j", "BaseBookViewHolder", "a", "ItemGridAdBookHolder", "ItemGridAdderBookHolder", "ItemGridBookHolder", "ItemListBookAdHolder", "ItemListBookAdderHolder", "ItemListBookHolder", "b", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public class BookShelfAdapter extends RecyclerView.Adapter<BaseBookViewHolder> implements RecyclerViewExposeManager.OnItemExposeListener {

    /* renamed from: k */
    public static final int f15461k = 0;

    /* renamed from: l */
    public static final int f15462l = 1;

    /* renamed from: m */
    public static final int f15463m = 2;

    /* renamed from: n */
    public static final int f15464n = 3;

    /* renamed from: o */
    public static final int f15465o = 4;

    /* renamed from: p */
    public static final int f15466p = 5;

    /* renamed from: c, reason: from kotlin metadata */
    public boolean isBatch;

    /* renamed from: d, reason: from kotlin metadata */
    public int selectNumber;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public String bookNameKeyword;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public RecyclerViewExposeManager recyclerViewExposeManager;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public b mOnItemClickListener;

    /* renamed from: e */
    @l
    public String category = BookrackCategoryManager.ALL_BOOK_CATEGORY;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public List<BookWrapper> bookWrapperList = new ArrayList();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b¦\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u00118\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$BaseBookViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/viewbinding/ViewBinding;", bt.aO, "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;Landroidx/viewbinding/ViewBinding;)V", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "bookWrapper", "", c.f26972i, "", e.TAG, "(Lcom/martian/mibook/lib/model/data/BookWrapper;I)V", "b", "Landroidx/viewbinding/ViewBinding;", "f", "()Landroidx/viewbinding/ViewBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public abstract class BaseBookViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ViewBinding com.umeng.analytics.pro.bt.aO java.lang.String;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ BookShelfAdapter f15476d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseBookViewHolder(@k BookShelfAdapter bookShelfAdapter, ViewBinding t10) {
            super(t10.getRoot());
            Intrinsics.checkNotNullParameter(t10, "t");
            this.f15476d = bookShelfAdapter;
            this.com.umeng.analytics.pro.bt.aO java.lang.String = t10;
            Context context = t10.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: td.m

                /* renamed from: c */
                public final /* synthetic */ BookShelfAdapter.BaseBookViewHolder f30828c;

                public /* synthetic */ m(BookShelfAdapter.BaseBookViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BookShelfAdapter.BaseBookViewHolder.c(BookShelfAdapter.this, this, view);
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: td.n

                /* renamed from: c */
                public final /* synthetic */ BookShelfAdapter.BaseBookViewHolder f30830c;

                public /* synthetic */ n(BookShelfAdapter.BaseBookViewHolder this) {
                    this = this;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean d10;
                    d10 = BookShelfAdapter.BaseBookViewHolder.d(BookShelfAdapter.this, this, view);
                    return d10;
                }
            });
        }

        public static final void c(BookShelfAdapter this$0, BaseBookViewHolder this$1, View view) {
            int bindingAdapterPosition;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.mOnItemClickListener == null || (bindingAdapterPosition = this$1.getBindingAdapterPosition()) >= this$0.bookWrapperList.size() || bindingAdapterPosition < 0) {
                return;
            }
            BookWrapper bookWrapper = (BookWrapper) this$0.bookWrapperList.get(bindingAdapterPosition);
            b bVar = this$0.mOnItemClickListener;
            if (bVar != null) {
                bVar.b(view, bookWrapper, bindingAdapterPosition);
            }
        }

        public static final boolean d(BookShelfAdapter this$0, BaseBookViewHolder this$1, View view) {
            int bindingAdapterPosition;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.mOnItemClickListener != null && (bindingAdapterPosition = this$1.getBindingAdapterPosition()) < this$0.bookWrapperList.size() && bindingAdapterPosition >= 0) {
                BookWrapper bookWrapper = (BookWrapper) this$0.bookWrapperList.get(bindingAdapterPosition);
                b bVar = this$0.mOnItemClickListener;
                if (bVar != null) {
                    bVar.a(view, bookWrapper, bindingAdapterPosition);
                }
            }
            return false;
        }

        public abstract void e(@l BookWrapper bookWrapper, int i10);

        @k
        /* renamed from: f, reason: from getter */
        public final ViewBinding getCom.umeng.analytics.pro.bt.aO java.lang.String() {
            return this.com.umeng.analytics.pro.bt.aO java.lang.String;
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$ItemGridAdBookHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$BaseBookViewHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;", "Lcom/martian/mibook/databinding/ItemBookShelfGridAdBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;Lcom/martian/mibook/databinding/ItemBookShelfGridAdBinding;)V", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "bookWrapper", "", c.f26972i, "", e.TAG, "(Lcom/martian/mibook/lib/model/data/BookWrapper;I)V", "Lcom/martian/mibook/databinding/ItemBookShelfGridAdBinding;", "g", "()Lcom/martian/mibook/databinding/ItemBookShelfGridAdBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ItemGridAdBookHolder extends BaseBookViewHolder {

        /* renamed from: e */
        @k
        public final ItemBookShelfGridAdBinding binding;

        /* renamed from: f */
        public final /* synthetic */ BookShelfAdapter f15478f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemGridAdBookHolder(@k BookShelfAdapter bookShelfAdapter, ItemBookShelfGridAdBinding binding) {
            super(bookShelfAdapter, binding);
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15478f = bookShelfAdapter;
            this.binding = binding;
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter.BaseBookViewHolder
        public void e(@l BookWrapper bookWrapper, int i10) {
            if (bookWrapper != null) {
                bookWrapper.isAdItem();
            }
        }

        @k
        /* renamed from: g, reason: from getter */
        public final ItemBookShelfGridAdBinding getBinding() {
            return this.binding;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$ItemGridAdderBookHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$BaseBookViewHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;", "Lcom/martian/mibook/databinding/ItemBookShelfGridAdderBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;Lcom/martian/mibook/databinding/ItemBookShelfGridAdderBinding;)V", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "bookWrapper", "", c.f26972i, "", e.TAG, "(Lcom/martian/mibook/lib/model/data/BookWrapper;I)V", "Lcom/martian/mibook/databinding/ItemBookShelfGridAdderBinding;", "g", "()Lcom/martian/mibook/databinding/ItemBookShelfGridAdderBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ItemGridAdderBookHolder extends BaseBookViewHolder {

        /* renamed from: e */
        @k
        public final ItemBookShelfGridAdderBinding binding;

        /* renamed from: f */
        public final /* synthetic */ BookShelfAdapter f15480f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemGridAdderBookHolder(@k BookShelfAdapter bookShelfAdapter, ItemBookShelfGridAdderBinding binding) {
            super(bookShelfAdapter, binding);
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15480f = bookShelfAdapter;
            this.binding = binding;
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter.BaseBookViewHolder
        public void e(@l BookWrapper bookWrapper, int i10) {
            if (bookWrapper == null || !bookWrapper.isAdderItem()) {
                return;
            }
            this.binding.bookAdderGridContainer.setVisibility(this.f15480f.getIsBatch() ? 8 : 0);
            this.binding.ivBookMoreView.setBackgroundResource(MiConfigSingleton.b2().A0() ? R.drawable.border_background_book_more_night_grid : R.drawable.border_background_book_more_day_grid);
        }

        @k
        /* renamed from: g, reason: from getter */
        public final ItemBookShelfGridAdderBinding getBinding() {
            return this.binding;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$ItemGridBookHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$BaseBookViewHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;", "Lcom/martian/mibook/databinding/ItemBookShelfGridBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;Lcom/martian/mibook/databinding/ItemBookShelfGridBinding;)V", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "bookWrapper", "", c.f26972i, "", e.TAG, "(Lcom/martian/mibook/lib/model/data/BookWrapper;I)V", "Lcom/martian/mibook/databinding/ItemBookShelfGridBinding;", "g", "()Lcom/martian/mibook/databinding/ItemBookShelfGridBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ItemGridBookHolder extends BaseBookViewHolder {

        /* renamed from: e */
        @k
        public final ItemBookShelfGridBinding binding;

        /* renamed from: f */
        public final /* synthetic */ BookShelfAdapter f15482f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemGridBookHolder(@k BookShelfAdapter bookShelfAdapter, ItemBookShelfGridBinding binding) {
            super(bookShelfAdapter, binding);
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15482f = bookShelfAdapter;
            this.binding = binding;
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter.BaseBookViewHolder
        @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
        public void e(@l BookWrapper bookWrapper, int i10) {
            String str;
            Integer chapterSize;
            if (bookWrapper == null) {
                return;
            }
            if (this.f15482f.getIsBatch()) {
                this.binding.bpItemSelect.setVisibility(0);
                if (bookWrapper.isSelect()) {
                    this.binding.bookGridCover.setColorFilter(Color.parseColor("#4d000000"));
                    this.binding.bpItemSelect.setImageResource(R.drawable.icon_bookrack_batch_checked);
                } else {
                    this.binding.bookGridCover.setColorFilter(0);
                    this.binding.bpItemSelect.setImageResource(R.drawable.icon_bookrack_batch_check_grid);
                }
            } else {
                this.binding.bookGridCover.setColorFilter(0);
                this.binding.bpItemSelect.setVisibility(8);
            }
            String bookName = bookWrapper.getBookName();
            this.binding.bookShelfGridBookName.setText(ExtKt.c(bookName));
            Book book = bookWrapper.book;
            if (book == null) {
                m0.b(getCom.umeng.analytics.pro.f.X java.lang.String(), this.binding.bookGridCover);
                this.binding.bookGridCover.setImageResource(R.drawable.cover_default);
                this.binding.bookShelfGridSign.setVisibility(8);
                this.binding.tvReadingRecord.setVisibility(4);
                return;
            }
            if (bookWrapper.item.getChapterSize() == null || ((chapterSize = bookWrapper.item.getChapterSize()) != null && chapterSize.intValue() == -1)) {
                bookWrapper.item.setChapterSize(book.getChapterSize());
                if (bookWrapper.item.getChapterSize() == null) {
                    bookWrapper.item.setChapterSize(0);
                }
            }
            if (book.isLocal() && ba.l.q(bookWrapper.getCover()) && !ba.l.q(bookName)) {
                this.binding.bookrackGridTitleName.setVisibility(0);
                this.binding.bookrackGridTitleName.setText(ExtKt.c(bookName));
            } else {
                this.binding.bookrackGridTitleName.setVisibility(8);
            }
            MiBookManager.u1(getCom.umeng.analytics.pro.f.X java.lang.String(), book, this.binding.bookGridCover);
            this.binding.tvReadingRecord.setVisibility(0);
            if (this.f15482f.getIsBatch()) {
                this.binding.tvReadingRecord.setText(ExtKt.c(bookWrapper.item.getDirName()));
            } else if (bookWrapper.item.isReaded()) {
                int intValue = bookWrapper.item.getReadingChapterIndex().intValue() + 1;
                Integer chapterSize2 = bookWrapper.item.getChapterSize();
                Intrinsics.checkNotNullExpressionValue(chapterSize2, "getChapterSize(...)");
                if (chapterSize2.intValue() > 0) {
                    Integer chapterSize3 = bookWrapper.item.getChapterSize();
                    Intrinsics.checkNotNull(chapterSize3);
                    if (chapterSize3.intValue() > 0) {
                        double intValue2 = (intValue * 100.0f) / chapterSize3.intValue();
                        if (intValue2 >= 99.94999694824219d && intValue != chapterSize3.intValue()) {
                            intValue2 = 99.9d;
                        }
                        ThemeTextView themeTextView = this.binding.tvReadingRecord;
                        String string = getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.reading_record_grid);
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(intValue2)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        themeTextView.setText(string + format + "%");
                    } else {
                        this.binding.tvReadingRecord.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.reading_rate) + intValue + ExtKt.c("章"));
                    }
                } else {
                    this.binding.tvReadingRecord.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.reading_record_grid) + intValue + ExtKt.c("章"));
                }
            } else {
                this.binding.tvReadingRecord.setText(ExtKt.c(book.getCategory()));
            }
            this.binding.bookShelfGridSign.setVisibility(0);
            this.binding.bookShelfGridSign.setAlpha(this.f15482f.getIsBatch() ? 0.4f : 1.0f);
            this.binding.bookGridCover.setMaskDrawable(getCom.umeng.analytics.pro.f.X java.lang.String().getDrawable(R.drawable.bg_book_shelf_cover_mask_default));
            if (MiConfigSingleton.b2().Y() < 3 && bookWrapper.item.isPromoteBook()) {
                this.binding.bookShelfGridSign.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.recommend));
                this.binding.bookShelfGridSign.setBackgroundResource(R.drawable.border_book_mark_recommend_grid);
                this.binding.bookGridCover.setMaskDrawable(getCom.umeng.analytics.pro.f.X java.lang.String().getDrawable(R.drawable.bg_book_shelf_cover_mask_recommend));
                return;
            }
            if (bookWrapper.item.isRecommendBook()) {
                this.binding.bookShelfGridSign.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.recommend));
                this.binding.bookShelfGridSign.setBackgroundResource(R.drawable.border_book_mark_blue_grid);
                return;
            }
            if (!bookWrapper.hasUpdate()) {
                if (!bookWrapper.item.isFlagTop()) {
                    this.binding.bookShelfGridSign.setVisibility(8);
                    return;
                } else {
                    this.binding.bookShelfGridSign.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.book_top));
                    this.binding.bookShelfGridSign.setBackgroundResource(R.drawable.border_book_mark_green_grid);
                    return;
                }
            }
            int updateChapterCount = bookWrapper.getUpdateChapterCount();
            if (updateChapterCount >= 100) {
                str = "99+章";
            } else if (updateChapterCount > 0) {
                str = updateChapterCount + "章";
            } else {
                str = "";
            }
            this.binding.bookShelfGridSign.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.update) + str);
            this.binding.bookShelfGridSign.setBackgroundResource(R.drawable.border_book_mark_red_grid);
        }

        @k
        /* renamed from: g, reason: from getter */
        public final ItemBookShelfGridBinding getBinding() {
            return this.binding;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$ItemListBookAdHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$BaseBookViewHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;", "Lcom/martian/mibook/databinding/ItemBookShelfListAdBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;Lcom/martian/mibook/databinding/ItemBookShelfListAdBinding;)V", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "bookWrapper", "", c.f26972i, "", e.TAG, "(Lcom/martian/mibook/lib/model/data/BookWrapper;I)V", "Lcom/martian/mibook/databinding/ItemBookShelfListAdBinding;", "g", "()Lcom/martian/mibook/databinding/ItemBookShelfListAdBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ItemListBookAdHolder extends BaseBookViewHolder {

        /* renamed from: e */
        @k
        public final ItemBookShelfListAdBinding binding;

        /* renamed from: f */
        public final /* synthetic */ BookShelfAdapter f15484f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemListBookAdHolder(@k BookShelfAdapter bookShelfAdapter, ItemBookShelfListAdBinding binding) {
            super(bookShelfAdapter, binding);
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15484f = bookShelfAdapter;
            this.binding = binding;
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter.BaseBookViewHolder
        public void e(@l BookWrapper bookWrapper, int i10) {
            if (bookWrapper != null) {
                bookWrapper.isAdItem();
            }
        }

        @k
        /* renamed from: g, reason: from getter */
        public final ItemBookShelfListAdBinding getBinding() {
            return this.binding;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$ItemListBookAdderHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$BaseBookViewHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;", "Lcom/martian/mibook/databinding/ItemBookShelfListAdderBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;Lcom/martian/mibook/databinding/ItemBookShelfListAdderBinding;)V", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "bookWrapper", "", c.f26972i, "", e.TAG, "(Lcom/martian/mibook/lib/model/data/BookWrapper;I)V", "Lcom/martian/mibook/databinding/ItemBookShelfListAdderBinding;", "g", "()Lcom/martian/mibook/databinding/ItemBookShelfListAdderBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ItemListBookAdderHolder extends BaseBookViewHolder {

        /* renamed from: e */
        @k
        public final ItemBookShelfListAdderBinding binding;

        /* renamed from: f */
        public final /* synthetic */ BookShelfAdapter f15486f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemListBookAdderHolder(@k BookShelfAdapter bookShelfAdapter, ItemBookShelfListAdderBinding binding) {
            super(bookShelfAdapter, binding);
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15486f = bookShelfAdapter;
            this.binding = binding;
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter.BaseBookViewHolder
        public void e(@l BookWrapper bookWrapper, int i10) {
            if (bookWrapper == null || !bookWrapper.isAdderItem()) {
                return;
            }
            this.binding.bookAdderListContainer.setVisibility(this.f15486f.getIsBatch() ? 8 : 0);
            this.binding.ivBookListMoreView.setBackgroundResource(MiConfigSingleton.b2().A0() ? R.drawable.border_background_book_more_night_list : R.drawable.border_background_book_more_day_list);
        }

        @k
        /* renamed from: g, reason: from getter */
        public final ItemBookShelfListAdderBinding getBinding() {
            return this.binding;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$ItemListBookHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter$BaseBookViewHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;", "Lcom/martian/mibook/databinding/ItemBookShelfListBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;Lcom/martian/mibook/databinding/ItemBookShelfListBinding;)V", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "bookWrapper", "", c.f26972i, "", e.TAG, "(Lcom/martian/mibook/lib/model/data/BookWrapper;I)V", "Lcom/martian/mibook/databinding/ItemBookShelfListBinding;", "g", "()Lcom/martian/mibook/databinding/ItemBookShelfListBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class ItemListBookHolder extends BaseBookViewHolder {

        /* renamed from: e */
        @k
        public final ItemBookShelfListBinding binding;

        /* renamed from: f */
        public final /* synthetic */ BookShelfAdapter f15488f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemListBookHolder(@k BookShelfAdapter bookShelfAdapter, ItemBookShelfListBinding binding) {
            super(bookShelfAdapter, binding);
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15488f = bookShelfAdapter;
            this.binding = binding;
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter.BaseBookViewHolder
        @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
        public void e(@l BookWrapper bookWrapper, int i10) {
            String str;
            String str2;
            Integer chapterSize;
            if (bookWrapper == null) {
                return;
            }
            if (this.f15488f.getIsBatch()) {
                this.binding.bpItemSelect.setVisibility(0);
                this.binding.bpItemSelect.setImageResource(bookWrapper.isSelect() ? R.drawable.icon_bookrack_batch_checked : R.drawable.icon_bookrack_batch_checkin);
            } else {
                this.binding.bpItemSelect.setVisibility(8);
            }
            String bookName = bookWrapper.getBookName();
            this.binding.tvUrlName.setText(ExtKt.c(bookName));
            Book book = bookWrapper.book;
            if (book == null) {
                m0.b(getCom.umeng.analytics.pro.f.X java.lang.String(), this.binding.bookListCover);
                this.binding.bookListCover.setImageResource(R.drawable.cover_default);
                this.binding.ivUpdateSign.setVisibility(8);
                this.binding.tvReadingRecord.setVisibility(8);
                return;
            }
            if (bookWrapper.item.getChapterSize() == null || ((chapterSize = bookWrapper.item.getChapterSize()) != null && chapterSize.intValue() == -1)) {
                bookWrapper.item.setChapterSize(book.getChapterSize());
                if (bookWrapper.item.getChapterSize() == null) {
                    bookWrapper.item.setChapterSize(0);
                }
            }
            this.binding.tvReadingRecord.setVisibility(0);
            if (bookWrapper.item.isReaded()) {
                int intValue = bookWrapper.item.getReadingChapterIndex().intValue() + 1;
                Integer chapterSize2 = bookWrapper.item.getChapterSize();
                Intrinsics.checkNotNull(chapterSize2);
                if (chapterSize2.intValue() > 0) {
                    this.binding.tvReadingRecord.setText(intValue + "/" + chapterSize2 + "章");
                } else {
                    this.binding.tvReadingRecord.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.reading_rate) + intValue + ExtKt.c("章"));
                }
            } else {
                this.binding.tvReadingRecord.setText(ExtKt.c("未读过"));
            }
            if (book.isLocal() && ba.l.q(bookWrapper.getCover()) && !ba.l.q(bookName)) {
                this.binding.tvTitleName.setVisibility(0);
                this.binding.tvTitleName.setText(ExtKt.c(bookName));
            } else {
                this.binding.tvTitleName.setVisibility(8);
            }
            MiBookManager.u1(getCom.umeng.analytics.pro.f.X java.lang.String(), bookWrapper.book, this.binding.bookListCover);
            String lastChapter = book.getLastChapter();
            String str3 = "";
            if (!bookWrapper.book.isSerialEnd()) {
                if (TextUtils.isEmpty(book.getUpdateDateString())) {
                    str = "";
                } else {
                    str = book.getUpdateDateString() + "更新";
                }
                if (TextUtils.isEmpty(lastChapter)) {
                    str2 = str;
                } else if (TextUtils.isEmpty(str)) {
                    str2 = "更新至:" + lastChapter;
                } else {
                    str2 = str + "·" + lastChapter;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.latest_chapter_empty);
                    Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
                }
            } else if (ba.l.q(lastChapter)) {
                str2 = ExtKt.c("已完结");
            } else {
                str2 = ExtKt.c("已完结·") + lastChapter;
            }
            this.binding.tvUrl.setText(ExtKt.c(str2));
            this.binding.ivUpdateSign.setVisibility(0);
            this.binding.ivUpdateSign.setAlpha(this.f15488f.getIsBatch() ? 0.4f : 1.0f);
            this.binding.bookListCover.setMaskDrawable(getCom.umeng.analytics.pro.f.X java.lang.String().getDrawable(R.drawable.bg_book_shelf_cover_mask_default));
            if (MiConfigSingleton.b2().Y() < 3 && bookWrapper.item.isPromoteBook()) {
                this.binding.ivUpdateSign.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.recommend));
                this.binding.ivUpdateSign.setBackgroundResource(R.drawable.border_book_mark_recommend_list);
                this.binding.bookListCover.setMaskDrawable(getCom.umeng.analytics.pro.f.X java.lang.String().getDrawable(R.drawable.bg_book_shelf_cover_mask_recommend));
                return;
            }
            if (bookWrapper.item.isRecommendBook()) {
                this.binding.ivUpdateSign.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.recommend));
                this.binding.ivUpdateSign.setBackgroundResource(R.drawable.border_book_mark_blue_list);
                return;
            }
            if (!bookWrapper.hasUpdate()) {
                if (!bookWrapper.item.isFlagTop()) {
                    this.binding.ivUpdateSign.setVisibility(8);
                    return;
                } else {
                    this.binding.ivUpdateSign.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.book_top));
                    this.binding.ivUpdateSign.setBackgroundResource(R.drawable.border_book_mark_green_list);
                    return;
                }
            }
            int updateChapterCount = bookWrapper.getUpdateChapterCount();
            if (updateChapterCount >= 100) {
                str3 = "99+章";
            } else if (updateChapterCount > 0) {
                str3 = updateChapterCount + "章";
            }
            this.binding.ivUpdateSign.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.update) + str3);
            this.binding.ivUpdateSign.setBackgroundResource(R.drawable.border_book_mark_red_list);
        }

        @k
        /* renamed from: g, reason: from getter */
        public final ItemBookShelfListBinding getBinding() {
            return this.binding;
        }
    }

    public interface b {
        boolean a(@l View view, @l BookWrapper bookWrapper, int i10);

        void b(@l View view, @l BookWrapper bookWrapper, int i10);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void A(@l List<? extends BookWrapper> list) {
        this.bookWrapperList.clear();
        if (list != null) {
            this.bookWrapperList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public final void B() {
        A(l());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.bookWrapperList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r22) {
        BookWrapper bookWrapper = this.bookWrapperList.get(r22);
        return MiConfigSingleton.b2().O1() == 0 ? bookWrapper.isAdderItem() ? 2 : 0 : bookWrapper.isAdderItem() ? 3 : 1;
    }

    public final void k() {
        this.selectNumber = 0;
        u(false);
    }

    public final List<BookWrapper> l() {
        List<BookWrapper> C = StringsKt.equals(BookrackCategoryManager.ALL_BOOK_CATEGORY, this.category, true) ? TextUtils.isEmpty(this.bookNameKeyword) ? MiConfigSingleton.b2().M1().C(true) : MiConfigSingleton.b2().M1().A(this.bookNameKeyword) : MiConfigSingleton.b2().M1().B(this.category, this.bookNameKeyword);
        Intrinsics.checkNotNull(C);
        return C;
    }

    public final void m() {
        RecyclerViewExposeManager recyclerViewExposeManager;
        if (!MiConfigSingleton.b2().M1().p2() || (recyclerViewExposeManager = this.recyclerViewExposeManager) == null) {
            return;
        }
        RecyclerViewExposeManager.handleCurrentVisibleItems$default(recyclerViewExposeManager, true, 0L, 2, null);
    }

    public final int n() {
        Iterator<BookWrapper> it = this.bookWrapperList.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (!it.next().notBookItem()) {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: o, reason: from getter */
    public final int getSelectNumber() {
        return this.selectNumber;
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
            recyclerViewExposeManager.setThreshold(0.0f);
        }
        RecyclerViewExposeManager recyclerViewExposeManager2 = this.recyclerViewExposeManager;
        if (recyclerViewExposeManager2 != null) {
            recyclerViewExposeManager2.setRecyclerItemExposeListener(recyclerView, this);
        }
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
    public void onItemViewVisible(int r22, @l RecyclerView recyclerView) {
        BookWrapper bookWrapper;
        MiBookStoreItem miBookStoreItem;
        if (this.bookWrapperList.isEmpty() || getPageSize() <= r22 || (miBookStoreItem = (bookWrapper = this.bookWrapperList.get(r22)).item) == null || miBookStoreItem.isReaded()) {
            return;
        }
        MiConfigSingleton.b2().M1().w1(recyclerView != null ? recyclerView.getContext() : null, bookWrapper.item.getSourceString());
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsBatch() {
        return this.isBatch;
    }

    public final boolean q() {
        if (getSelectNumber() != 1) {
            return false;
        }
        for (BookWrapper bookWrapper : this.bookWrapperList) {
            if (bookWrapper.isSelect()) {
                MiBookStoreItem miBookStoreItem = bookWrapper.item;
                return miBookStoreItem != null && miBookStoreItem.isRecommendBook();
            }
        }
        return false;
    }

    public final void r(@k BookWrapper bookWrapper, int i10) {
        Intrinsics.checkNotNullParameter(bookWrapper, "bookWrapper");
        bookWrapper.setSelect(!bookWrapper.isSelect());
        if (bookWrapper.isSelect()) {
            this.selectNumber++;
        } else {
            this.selectNumber--;
        }
        notifyItemChanged(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s */
    public void onBindViewHolder(@k BaseBookViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.e(this.bookWrapperList.get(r32), r32);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: t */
    public BaseBookViewHolder onCreateViewHolder(@k ViewGroup parent, int i10) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (i10 == 0) {
            ItemBookShelfListBinding inflate = ItemBookShelfListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new ItemListBookHolder(this, inflate);
        }
        if (i10 == 2) {
            ItemBookShelfListAdderBinding inflate2 = ItemBookShelfListAdderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            return new ItemListBookAdderHolder(this, inflate2);
        }
        if (i10 == 3) {
            ItemBookShelfGridAdderBinding inflate3 = ItemBookShelfGridAdderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(...)");
            return new ItemGridAdderBookHolder(this, inflate3);
        }
        if (i10 == 4) {
            ItemBookShelfListAdBinding inflate4 = ItemBookShelfListAdBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "inflate(...)");
            return new ItemListBookAdHolder(this, inflate4);
        }
        if (i10 != 5) {
            ItemBookShelfGridBinding inflate5 = ItemBookShelfGridBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate5, "inflate(...)");
            return new ItemGridBookHolder(this, inflate5);
        }
        ItemBookShelfGridAdBinding inflate6 = ItemBookShelfGridAdBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate6, "inflate(...)");
        return new ItemGridAdBookHolder(this, inflate6);
    }

    public final void u(boolean selectAll) {
        for (BookWrapper bookWrapper : this.bookWrapperList) {
            if (!bookWrapper.notBookItem()) {
                bookWrapper.setSelect(selectAll);
            }
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void v() {
        int n10 = n();
        if (this.selectNumber < n10) {
            this.selectNumber = n10;
            u(true);
        } else {
            this.selectNumber = 0;
            u(false);
        }
        notifyDataSetChanged();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void w(boolean z10) {
        this.isBatch = z10;
        notifyDataSetChanged();
    }

    public final void x(@k String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        this.bookNameKeyword = keyword;
        A(l());
    }

    public final void y(@l String category) {
        this.category = category;
        A(l());
    }

    public final void z(@k b onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.mOnItemClickListener = onItemClickListener;
    }
}
