package com.martian.mibook.mvvm.yuewen.adapter;

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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.ReadingRecordItem;
import com.martian.mibook.databinding.ItemAccountReadingRecordBinding;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.yuewen.adapter.AccountReadingRecordAdapter;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.List;
import je.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\u00020\n2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/AccountReadingRecordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/AccountReadingRecordAdapter$RecordViewHolder;", "<init>", "()V", "", "Lcom/martian/mibook/data/ReadingRecordItem;", "recordList", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "m", "(Ljava/util/List;Landroidx/recyclerview/widget/RecyclerView;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", t.f11204d, "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/yuewen/adapter/AccountReadingRecordAdapter$RecordViewHolder;", "getItemCount", "()I", "holder", c.f26972i, "k", "(Lcom/martian/mibook/mvvm/yuewen/adapter/AccountReadingRecordAdapter$RecordViewHolder;I)V", "", "c", "Ljava/util/List;", "d", "Lcom/martian/mibook/data/ReadingRecordItem;", "firstReadingRecord", "RecordViewHolder", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class AccountReadingRecordAdapter extends RecyclerView.Adapter<RecordViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public List<ReadingRecordItem> recordList;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public ReadingRecordItem firstReadingRecord;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/AccountReadingRecordAdapter$RecordViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemAccountReadingRecordBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/AccountReadingRecordAdapter;Lcom/martian/mibook/databinding/ItemAccountReadingRecordBinding;)V", "", "j", "()V", "g", "Lcom/martian/mibook/data/ReadingRecordItem;", "recordItem", "h", "(Lcom/martian/mibook/data/ReadingRecordItem;)V", "b", "Lcom/martian/mibook/databinding/ItemAccountReadingRecordBinding;", "i", "()Lcom/martian/mibook/databinding/ItemAccountReadingRecordBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class RecordViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemAccountReadingRecordBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ AccountReadingRecordAdapter f15396d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecordViewHolder(@k AccountReadingRecordAdapter accountReadingRecordAdapter, ItemAccountReadingRecordBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15396d = accountReadingRecordAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.ivBookCover.setOnClickListener(new View.OnClickListener() { // from class: td.b
                public /* synthetic */ b() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountReadingRecordAdapter.RecordViewHolder.d(AccountReadingRecordAdapter.RecordViewHolder.this, view);
                }
            });
            binding.tvAddBookShelf.setOnClickListener(new View.OnClickListener() { // from class: td.c
                public /* synthetic */ c() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountReadingRecordAdapter.RecordViewHolder.e(AccountReadingRecordAdapter.RecordViewHolder.this, view);
                }
            });
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: td.d
                public /* synthetic */ d() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountReadingRecordAdapter.RecordViewHolder.f(AccountReadingRecordAdapter.RecordViewHolder.this, view);
                }
            });
        }

        public static final void d(RecordViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.j();
        }

        public static final void e(RecordViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.g();
        }

        public static final void f(RecordViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.j();
        }

        private final void g() {
            int bindingAdapterPosition = getBindingAdapterPosition();
            if (bindingAdapterPosition >= this.f15396d.getPageSize() || bindingAdapterPosition < 0) {
                return;
            }
            List list = this.f15396d.recordList;
            ReadingRecordItem readingRecordItem = list != null ? (ReadingRecordItem) list.get(bindingAdapterPosition) : null;
            if ((readingRecordItem != null ? readingRecordItem.getReadingRecord() : null) == null) {
                return;
            }
            MiBookManager M1 = MiConfigSingleton.b2().M1();
            MiReadingRecord readingRecord = readingRecordItem.getReadingRecord();
            Book D = M1.D(readingRecord != null ? readingRecord.getSourceString() : null);
            if (D == null) {
                return;
            }
            Context context = this.com.umeng.analytics.pro.f.X java.lang.String;
            MiConfigSingleton.b2().M1().g(context instanceof Activity ? (Activity) context : null, D);
            readingRecordItem.setInBookStore(true);
            this.binding.tvAddBookShelf.setVisibility(readingRecordItem.isInBookStore() ? 8 : 0);
            t0.b(this.com.umeng.analytics.pro.f.X java.lang.String, "已加入书架");
        }

        private final void j() {
            int bindingAdapterPosition = getBindingAdapterPosition();
            if (bindingAdapterPosition >= this.f15396d.getPageSize() || bindingAdapterPosition < 0 || !(this.com.umeng.analytics.pro.f.X java.lang.String instanceof Activity)) {
                return;
            }
            List list = this.f15396d.recordList;
            ReadingRecordItem readingRecordItem = list != null ? (ReadingRecordItem) list.get(bindingAdapterPosition) : null;
            if (i.U((Activity) this.com.umeng.analytics.pro.f.X java.lang.String, readingRecordItem != null ? readingRecordItem.getReadingRecord() : null)) {
                return;
            }
            t0.b(this.com.umeng.analytics.pro.f.X java.lang.String, "无效的书籍记录");
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }

        public final void h(@l ReadingRecordItem recordItem) {
            MiReadingRecord readingRecord;
            String bookName;
            MiReadingRecord readingRecord2;
            String bookName2;
            String str = null;
            String bookCover = recordItem != null ? recordItem.getBookCover() : null;
            int i10 = 0;
            boolean localBook = recordItem != null ? recordItem.getLocalBook() : false;
            String c10 = (recordItem == null || (readingRecord2 = recordItem.getReadingRecord()) == null || (bookName2 = readingRecord2.getBookName()) == null) ? null : ExtKt.c(bookName2);
            MiBookManager.v1(this.com.umeng.analytics.pro.f.X java.lang.String, bookCover, localBook, this.binding.ivBookCover);
            if (localBook && TextUtils.isEmpty(bookCover) && !TextUtils.isEmpty(c10)) {
                this.binding.tvTxtName.setVisibility(0);
                this.binding.tvTxtName.setText(ExtKt.c(c10));
            } else {
                this.binding.tvTxtName.setVisibility(8);
            }
            ThemeTextView themeTextView = this.binding.tvBookName;
            if (recordItem != null && (readingRecord = recordItem.getReadingRecord()) != null && (bookName = readingRecord.getBookName()) != null) {
                str = ExtKt.c(bookName);
            }
            themeTextView.setText(str);
            TextView textView = this.binding.tvAddBookShelf;
            if (recordItem != null && recordItem.isInBookStore()) {
                i10 = 8;
            }
            textView.setVisibility(i10);
        }

        @k
        /* renamed from: i, reason: from getter */
        public final ItemAccountReadingRecordBinding getBinding() {
            return this.binding;
        }
    }

    public static final void n(RecyclerView recyclerView) {
        recyclerView.scrollToPosition(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        List<ReadingRecordItem> list = this.recordList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public void onBindViewHolder(@k RecordViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<ReadingRecordItem> list = this.recordList;
        holder.h(list != null ? list.get(r32) : null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: l */
    public RecordViewHolder onCreateViewHolder(@k ViewGroup parent, int i10) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemAccountReadingRecordBinding inflate = ItemAccountReadingRecordBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new RecordViewHolder(this, inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void m(@l List<ReadingRecordItem> recordList, @l RecyclerView recyclerView) {
        MiReadingRecord readingRecord;
        String str = null;
        ReadingRecordItem readingRecordItem = recordList != null ? recordList.get(0) : null;
        this.recordList = recordList;
        notifyDataSetChanged();
        if (readingRecordItem != null) {
            MiReadingRecord readingRecord2 = readingRecordItem.getReadingRecord();
            String sourceString = readingRecord2 != null ? readingRecord2.getSourceString() : null;
            ReadingRecordItem readingRecordItem2 = this.firstReadingRecord;
            if (readingRecordItem2 != null && (readingRecord = readingRecordItem2.getReadingRecord()) != null) {
                str = readingRecord.getSourceString();
            }
            if (!Intrinsics.areEqual(sourceString, str) && recyclerView != null) {
                recyclerView.postDelayed(new Runnable() { // from class: td.a
                    public /* synthetic */ a() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        AccountReadingRecordAdapter.n(RecyclerView.this);
                    }
                }, 200L);
            }
        }
        this.firstReadingRecord = readingRecordItem;
    }
}
