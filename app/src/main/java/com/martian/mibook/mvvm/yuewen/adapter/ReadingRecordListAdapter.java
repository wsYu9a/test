package com.martian.mibook.mvvm.yuewen.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ItemReadingRecordBinding;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.yuewen.adapter.ReadingRecordListAdapter;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import id.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import je.i;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import l9.o0;
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010#\n\u0002\b\u000e\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0004HIJKB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u001a\u001a\u00020\u00072\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001c\u001a\u00020\u00072\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J!\u0010'\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0005¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0005H\u0007¢\u0006\u0004\b,\u0010\tJ\r\u0010-\u001a\u00020\u0011¢\u0006\u0004\b-\u0010\u001fJ\r\u0010.\u001a\u00020\u0005¢\u0006\u0004\b.\u0010*J\u001f\u00100\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0007H\u0007¢\u0006\u0004\b2\u0010\u0004J\u0019\u00105\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0007H\u0007¢\u0006\u0004\b7\u0010\u0004J\r\u00108\u001a\u00020\u0007¢\u0006\u0004\b8\u0010\u0004J\r\u00109\u001a\u00020\u0007¢\u0006\u0004\b9\u0010\u0004J!\u0010:\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b:\u0010(R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000b0>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006L"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$BookViewHolder;", "<init>", "()V", "", "selectAll", "", "x", "(Z)V", "", "Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$b;", "newData", "C", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "u", "(Landroid/view/ViewGroup;I)Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$BookViewHolder;", "holder", c.f26972i, "", "", "payloads", bt.aO, "(Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$BookViewHolder;ILjava/util/List;)V", "s", "(Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$BookViewHolder;I)V", "getItemCount", "()I", "Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$a;", "onItemClickListener", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$a;)V", "Landroid/content/Context;", f.X, "readingRecordItem", "B", "(Landroid/content/Context;Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$b;)V", "q", "()Z", com.umeng.ccg.a.f24245v, bt.aJ, "p", "n", "miReadingRecordItem", "v", "(Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$b;I)V", "y", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "m", "(Landroid/app/Activity;)V", IAdInterListener.AdReqParam.WIDTH, "o", t.f11211k, t.f11204d, "c", "Ljava/util/List;", "readingRecordList", "", "d", "Ljava/util/Set;", "selectRecordList", e.TAG, "Z", "isBatch", "f", "Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$a;", "mOnItemClickListener", "BookShelfOperateType", "BookViewHolder", "a", "b", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReadingRecordListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadingRecordListAdapter.kt\ncom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,337:1\n1855#2,2:338\n766#2:340\n857#2,2:341\n*S KotlinDebug\n*F\n+ 1 ReadingRecordListAdapter.kt\ncom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter\n*L\n215#1:338,2\n289#1:340\n289#1:341,2\n*E\n"})
/* loaded from: classes3.dex */
public final class ReadingRecordListAdapter extends RecyclerView.Adapter<BookViewHolder> {

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public List<b> readingRecordList = new ArrayList();

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public Set<b> selectRecordList = new LinkedHashSet();

    /* renamed from: e */
    public boolean isBatch;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public a mOnItemClickListener;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$BookShelfOperateType;", "", "(Ljava/lang/String;I)V", "BATCH_ADD_BOOK_SHELF", "BATCH_REMOVE_BOOK_SHELF", "SINGLE_ADD_BOOK_SHELF", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BookShelfOperateType extends Enum<BookShelfOperateType> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BookShelfOperateType[] $VALUES;
        public static final BookShelfOperateType BATCH_ADD_BOOK_SHELF = new BookShelfOperateType("BATCH_ADD_BOOK_SHELF", 0);
        public static final BookShelfOperateType BATCH_REMOVE_BOOK_SHELF = new BookShelfOperateType("BATCH_REMOVE_BOOK_SHELF", 1);
        public static final BookShelfOperateType SINGLE_ADD_BOOK_SHELF = new BookShelfOperateType("SINGLE_ADD_BOOK_SHELF", 2);

        private static final /* synthetic */ BookShelfOperateType[] $values() {
            return new BookShelfOperateType[]{BATCH_ADD_BOOK_SHELF, BATCH_REMOVE_BOOK_SHELF, SINGLE_ADD_BOOK_SHELF};
        }

        static {
            BookShelfOperateType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private BookShelfOperateType(String str, int i10) {
            super(str, i10);
        }

        @k
        public static EnumEntries<BookShelfOperateType> getEntries() {
            return $ENTRIES;
        }

        public static BookShelfOperateType valueOf(String str) {
            return (BookShelfOperateType) Enum.valueOf(BookShelfOperateType.class, str);
        }

        public static BookShelfOperateType[] values() {
            return (BookShelfOperateType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$BookViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/martian/mibook/databinding/ItemReadingRecordBinding;", "binding", "<init>", "(Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter;Lcom/martian/mibook/databinding/ItemReadingRecordBinding;)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$b;", "readingRecordItem", "", c.f26972i, "", "f", "(Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$b;I)V", "i", "(Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter$b;)V", "b", "Lcom/martian/mibook/databinding/ItemReadingRecordBinding;", "h", "()Lcom/martian/mibook/databinding/ItemReadingRecordBinding;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", f.X, "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
    public final class BookViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: b, reason: from kotlin metadata */
        @k
        public final ItemReadingRecordBinding binding;

        /* renamed from: c, reason: from kotlin metadata */
        @k
        public final Context com.umeng.analytics.pro.f.X java.lang.String;

        /* renamed from: d */
        public final /* synthetic */ ReadingRecordListAdapter f15517d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BookViewHolder(@k ReadingRecordListAdapter readingRecordListAdapter, ItemReadingRecordBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15517d = readingRecordListAdapter;
            this.binding = binding;
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.com.umeng.analytics.pro.f.X java.lang.String = context;
            binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: td.u

                /* renamed from: c */
                public final /* synthetic */ ReadingRecordListAdapter f30847c;

                public /* synthetic */ u(ReadingRecordListAdapter readingRecordListAdapter2) {
                    readingRecordListAdapter = readingRecordListAdapter2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingRecordListAdapter.BookViewHolder.d(ReadingRecordListAdapter.BookViewHolder.this, readingRecordListAdapter, view);
                }
            });
            binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: td.v

                /* renamed from: c */
                public final /* synthetic */ ReadingRecordListAdapter f30849c;

                public /* synthetic */ v(ReadingRecordListAdapter readingRecordListAdapter2) {
                    readingRecordListAdapter = readingRecordListAdapter2;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean e10;
                    e10 = ReadingRecordListAdapter.BookViewHolder.e(ReadingRecordListAdapter.BookViewHolder.this, readingRecordListAdapter, view);
                    return e10;
                }
            });
        }

        public static final void d(BookViewHolder this$0, ReadingRecordListAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition >= this$1.readingRecordList.size() || bindingAdapterPosition < 0) {
                return;
            }
            b bVar = (b) this$1.readingRecordList.get(bindingAdapterPosition);
            a aVar = this$1.mOnItemClickListener;
            if (aVar != null) {
                aVar.c(view, bVar, bindingAdapterPosition);
            }
        }

        public static final boolean e(BookViewHolder this$0, ReadingRecordListAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            int bindingAdapterPosition = this$0.getBindingAdapterPosition();
            if (bindingAdapterPosition < this$1.readingRecordList.size() && bindingAdapterPosition >= 0) {
                b bVar = (b) this$1.readingRecordList.get(bindingAdapterPosition);
                a aVar = this$1.mOnItemClickListener;
                if (aVar != null) {
                    aVar.a(view, bVar, bindingAdapterPosition);
                }
            }
            return false;
        }

        public static final void g(b bVar, ReadingRecordListAdapter this$0, BookViewHolder this$1, int i10, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (bVar.c()) {
                this$0.B(this$1.com.umeng.analytics.pro.f.X java.lang.String, bVar);
                return;
            }
            this$0.l(this$1.com.umeng.analytics.pro.f.X java.lang.String, bVar);
            this$0.notifyItemChanged(i10);
            a aVar = this$0.mOnItemClickListener;
            if (aVar != null) {
                aVar.b(BookShelfOperateType.SINGLE_ADD_BOOK_SHELF);
            }
        }

        public final void f(@l b readingRecordItem, int r62) {
            if (readingRecordItem == null) {
                return;
            }
            MiBookManager.v1(this.com.umeng.analytics.pro.f.X java.lang.String, readingRecordItem.a(), readingRecordItem.d(), this.binding.bookHistoryCover);
            MiReadingRecord b10 = readingRecordItem.b();
            String bookName = b10 != null ? b10.getBookName() : null;
            if (readingRecordItem.d() && ba.l.q(readingRecordItem.a()) && !ba.l.q(bookName)) {
                this.binding.tvTitleName.setVisibility(0);
                this.binding.tvTitleName.setText(ExtKt.c(bookName));
            } else {
                this.binding.tvTitleName.setVisibility(8);
            }
            i(readingRecordItem);
            this.binding.recordAddBookrack.setOnClickListener(new View.OnClickListener() { // from class: td.w

                /* renamed from: c */
                public final /* synthetic */ ReadingRecordListAdapter f30851c;

                /* renamed from: d */
                public final /* synthetic */ ReadingRecordListAdapter.BookViewHolder f30852d;

                /* renamed from: e */
                public final /* synthetic */ int f30853e;

                public /* synthetic */ w(ReadingRecordListAdapter readingRecordListAdapter, ReadingRecordListAdapter.BookViewHolder this, int r622) {
                    readingRecordListAdapter = readingRecordListAdapter;
                    this = this;
                    position = r622;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingRecordListAdapter.BookViewHolder.g(ReadingRecordListAdapter.b.this, readingRecordListAdapter, this, position, view);
                }
            });
            MiReadingRecord b11 = readingRecordItem.b();
            if (b11 == null) {
                return;
            }
            this.binding.tvBookName.setText(ExtKt.c(b11.getBookName()));
            this.binding.tvChapterTitle.setText(ExtKt.c("读到：") + ExtKt.c(b11.getReadingStatus()));
            long lastReadingTime = b11.getLastReadingTime();
            this.binding.tvLastReadingTime.setText(lastReadingTime <= 0 ? "" : o0.C(new Date(lastReadingTime)));
        }

        @k
        /* renamed from: getContext, reason: from getter */
        public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
            return this.com.umeng.analytics.pro.f.X java.lang.String;
        }

        @k
        /* renamed from: h, reason: from getter */
        public final ItemReadingRecordBinding getBinding() {
            return this.binding;
        }

        public final void i(@l b readingRecordItem) {
            if (readingRecordItem == null) {
                return;
            }
            boolean A0 = ConfigSingleton.D().A0();
            if (readingRecordItem.c()) {
                this.binding.recordAddBookrack.setBackgroundResource(A0 ? R.drawable.border_search_background_night_card : R.drawable.border_search_background_day);
                this.binding.recordAddBookrack.setTextColor(MiConfigSingleton.b2().k0());
                this.binding.recordAddBookrack.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(com.martian.mibook.R.string.already_in_bookrack));
            } else {
                this.binding.recordAddBookrack.setBackgroundResource(A0 ? R.drawable.border_search_background_night_card : com.martian.mibook.R.drawable.border_mission_button);
                this.binding.recordAddBookrack.setTextColor(ExtKt.e(this.com.umeng.analytics.pro.f.X java.lang.String, MiConfigSingleton.b2().l0()));
                this.binding.recordAddBookrack.setText(this.com.umeng.analytics.pro.f.X java.lang.String.getString(com.martian.mibook.R.string.add_to_book_store));
            }
            if (!this.f15517d.getIsBatch()) {
                this.binding.recordAddBookrack.setVisibility(0);
                this.binding.bpItemSelect.setVisibility(8);
            } else {
                this.binding.recordAddBookrack.setVisibility(8);
                this.binding.bpItemSelect.setVisibility(0);
                this.binding.bpItemSelect.setImageResource(readingRecordItem.e() ? com.martian.mibook.R.drawable.icon_bookrack_batch_checked : com.martian.mibook.R.drawable.icon_bookrack_batch_checkin);
            }
        }
    }

    public interface a {
        void a(@l View view, @l b bVar, int i10);

        void b(@k BookShelfOperateType bookShelfOperateType);

        void c(@l View view, @l b bVar, int i10);
    }

    public static final class b {

        /* renamed from: a */
        @l
        public MiReadingRecord f15518a;

        /* renamed from: b */
        @l
        public String f15519b;

        /* renamed from: c */
        public boolean f15520c;

        /* renamed from: d */
        public boolean f15521d;

        /* renamed from: e */
        public boolean f15522e;

        @l
        public final String a() {
            return this.f15519b;
        }

        @l
        public final MiReadingRecord b() {
            return this.f15518a;
        }

        public final boolean c() {
            return this.f15520c;
        }

        public final boolean d() {
            return this.f15521d;
        }

        public final boolean e() {
            return this.f15522e;
        }

        public final void f(@l String str) {
            this.f15519b = str;
        }

        public final void g(boolean z10) {
            this.f15520c = z10;
        }

        public final void h(boolean z10) {
            this.f15521d = z10;
        }

        public final void i(@l MiReadingRecord miReadingRecord) {
            this.f15518a = miReadingRecord;
        }

        public final void j(boolean z10) {
            this.f15522e = z10;
        }
    }

    private final void x(boolean selectAll) {
        for (b bVar : this.readingRecordList) {
            bVar.j(selectAll);
            if (selectAll) {
                this.selectRecordList.add(bVar);
            } else {
                this.selectRecordList.remove(bVar);
            }
        }
    }

    public final void A(@k a onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.mOnItemClickListener = onItemClickListener;
    }

    public final void B(@l Context r32, @l b readingRecordItem) {
        if (i.U(r32 instanceof Activity ? (Activity) r32 : null, readingRecordItem != null ? readingRecordItem.b() : null)) {
            return;
        }
        t0.b(r32, "无效的书籍记录");
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void C(@l List<b> newData) {
        this.readingRecordList.clear();
        this.selectRecordList.clear();
        List<b> list = newData;
        if (list != null && !list.isEmpty()) {
            this.readingRecordList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.readingRecordList.size();
    }

    public final void l(Context context, b bVar) {
        if ((bVar != null ? bVar.b() : null) == null) {
            return;
        }
        MiBookManager M1 = MiConfigSingleton.b2().M1();
        MiReadingRecord b10 = bVar.b();
        Book D = M1.D(b10 != null ? b10.getSourceString() : null);
        if (D == null) {
            return;
        }
        MiConfigSingleton.b2().M1().g(context instanceof Activity ? (Activity) context : null, D);
        bVar.g(true);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void m(@l Activity r42) {
        if (r42 == null) {
            return;
        }
        if (this.readingRecordList.isEmpty()) {
            a aVar = this.mOnItemClickListener;
            if (aVar != null) {
                aVar.b(BookShelfOperateType.BATCH_ADD_BOOK_SHELF);
                return;
            }
            return;
        }
        for (b bVar : this.readingRecordList) {
            if (bVar.e() && !bVar.c()) {
                l(r42, bVar);
            }
        }
        a aVar2 = this.mOnItemClickListener;
        if (aVar2 != null) {
            aVar2.b(BookShelfOperateType.BATCH_ADD_BOOK_SHELF);
        }
        notifyDataSetChanged();
    }

    public final boolean n() {
        if (this.selectRecordList.size() <= 0) {
            return false;
        }
        Iterator<T> it = this.selectRecordList.iterator();
        while (it.hasNext()) {
            if (!((b) it.next()).c()) {
                return true;
            }
        }
        return false;
    }

    public final void o() {
        x(false);
    }

    public final int p() {
        return this.selectRecordList.size();
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsBatch() {
        return this.isBatch;
    }

    public final void r() {
        notifyItemRangeChanged(0, getPageSize(), 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s */
    public void onBindViewHolder(@k BookViewHolder holder, int r32) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.f(this.readingRecordList.get(r32), r32);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t */
    public void onBindViewHolder(@k BookViewHolder holder, int i10, @k List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, i10);
        } else {
            holder.i(this.readingRecordList.get(i10));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @k
    /* renamed from: u */
    public BookViewHolder onCreateViewHolder(@k ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemReadingRecordBinding inflate = ItemReadingRecordBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new BookViewHolder(this, inflate);
    }

    public final void v(@l b miReadingRecordItem, int r32) {
        if (miReadingRecordItem != null) {
            miReadingRecordItem.j(!miReadingRecordItem.e());
            if (miReadingRecordItem.e()) {
                this.selectRecordList.add(miReadingRecordItem);
            } else {
                this.selectRecordList.remove(miReadingRecordItem);
            }
            notifyItemChanged(r32);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void w() {
        if (this.readingRecordList.isEmpty()) {
            a aVar = this.mOnItemClickListener;
            if (aVar != null) {
                aVar.b(BookShelfOperateType.BATCH_REMOVE_BOOK_SHELF);
                return;
            }
            return;
        }
        List<b> list = this.readingRecordList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            b bVar = (b) obj;
            boolean e10 = bVar.e();
            if (e10) {
                MiConfigSingleton.b2().M1().x0(bVar.b());
            }
            if (!e10) {
                arrayList.add(obj);
            }
        }
        C(arrayList);
        a aVar2 = this.mOnItemClickListener;
        if (aVar2 != null) {
            aVar2.b(BookShelfOperateType.BATCH_REMOVE_BOOK_SHELF);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void y() {
        if (this.selectRecordList.size() < getPageSize()) {
            x(true);
        } else {
            x(false);
        }
        notifyDataSetChanged();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void z(boolean z10) {
        this.isBatch = z10;
        notifyDataSetChanged();
    }
}
