package com.martian.mibook.mvvm.yuewen.adapter.holder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.databinding.ItemBookMallTypeReadingRecordBinding;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.yuewen.response.YWBookChannel;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.tts.TTSReadManager;
import com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.holder.ItemReadingRecordHolder;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookMallViewModel;
import id.c;
import je.i;
import kc.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import l9.t0;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/adapter/holder/ItemReadingRecordHolder;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookMallAdapter$ItemBaseHolder;", "Lcom/martian/mibook/databinding/ItemBookMallTypeReadingRecordBinding;", "binding", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;", "mViewModel", "<init>", "(Lcom/martian/mibook/databinding/ItemBookMallTypeReadingRecordBinding;Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookMallViewModel;)V", "Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;", "bookChannel", "", c.f26972i, "", "a", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;I)V", "k", "(Lcom/martian/mibook/lib/yuewen/response/YWBookChannel;)V", "g", "()V", "f", "(I)V", "Lcom/martian/mibook/databinding/ItemBookMallTypeReadingRecordBinding;", "j", "()Lcom/martian/mibook/databinding/ItemBookMallTypeReadingRecordBinding;", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nItemReadingRecordHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemReadingRecordHolder.kt\ncom/martian/mibook/mvvm/yuewen/adapter/holder/ItemReadingRecordHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,99:1\n1#2:100\n*E\n"})
/* loaded from: classes3.dex */
public final class ItemReadingRecordHolder extends BookMallAdapter.ItemBaseHolder {

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final ItemBookMallTypeReadingRecordBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemReadingRecordHolder(@k ItemBookMallTypeReadingRecordBinding binding, @l BookMallViewModel bookMallViewModel) {
        super(binding, bookMallViewModel);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public static final void l(View view) {
        b.u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(ItemReadingRecordHolder this$0, MiReadingRecord miReadingRecord, Ref.ObjectRef readingRecordBook, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(readingRecordBook, "$readingRecordBook");
        Context context = this$0.getCom.umeng.analytics.pro.f.X java.lang.String();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            if (miReadingRecord.isAudiobook()) {
                TTSReadManager.C(activity, (Book) readingRecordBook.element, miReadingRecord.getSourceString(), new Function0<Unit>() { // from class: com.martian.mibook.mvvm.yuewen.adapter.holder.ItemReadingRecordHolder$notifyReadingRecord$1$2$1$1
                    final /* synthetic */ Ref.ObjectRef<Book> $readingRecordBook;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public ItemReadingRecordHolder$notifyReadingRecord$1$2$1$1(Ref.ObjectRef<Book> readingRecordBook2) {
                        super(0);
                        readingRecordBook = readingRecordBook2;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke */
                    public final void invoke2() {
                        if (MiReadingRecord.this.isAudiobook()) {
                            int chapterIndex = MiReadingRecord.this.getChapterIndex();
                            Integer contentPos = MiReadingRecord.this.getContentPos();
                            b.e(readingRecordBook.element, chapterIndex, contentPos == null ? 0 : contentPos.intValue(), true, MiReadingRecord.this.getSourceString());
                        }
                    }
                });
            } else {
                if (i.U(activity, miReadingRecord)) {
                    return;
                }
                t0.b(activity, "无效的书籍记录");
            }
        }
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void a(@k YWBookChannel bookChannel, int r22) {
        Intrinsics.checkNotNullParameter(bookChannel, "bookChannel");
        k(bookChannel);
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void f(int r12) {
    }

    @Override // com.martian.mibook.mvvm.yuewen.adapter.BookMallAdapter.ItemBaseHolder
    public void g() {
    }

    @k
    /* renamed from: j, reason: from getter */
    public final ItemBookMallTypeReadingRecordBinding getBinding() {
        return this.binding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, com.martian.mibook.lib.model.data.abs.Book] */
    @SuppressLint({"SetTextI18n"})
    public final void k(@k YWBookChannel bookChannel) {
        Unit unit;
        boolean isLocal;
        String cover;
        String cover2;
        String str;
        Intrinsics.checkNotNullParameter(bookChannel, "bookChannel");
        MiReadingRecord readingRecord = bookChannel.getReadingRecord();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = bookChannel.getReadingRecordBook();
        if (readingRecord != null) {
            this.binding.getRoot().setVisibility(0);
            this.binding.tvReadingRecordTips.setText(ExtKt.c("阅\n读\n记\n录"));
            this.binding.tvBookName.setText(ExtKt.c(readingRecord.getBookName()));
            if (readingRecord.isAudiobook() || bookChannel.getBookWrapper() == null || !bookChannel.getBookWrapper().hasUpdate()) {
                this.binding.tvUpdateSign.setVisibility(8);
            } else {
                int updateChapterCount = bookChannel.getBookWrapper().getUpdateChapterCount();
                if (updateChapterCount > 100) {
                    str = "更新99+章";
                } else if (updateChapterCount > 0) {
                    str = "更新" + updateChapterCount + "章";
                } else {
                    str = "更新";
                }
                this.binding.tvUpdateSign.setText(str);
                this.binding.tvUpdateSign.setVisibility(0);
            }
            if (readingRecord.isAudiobook()) {
                this.binding.ivBookCover.setVisibility(8);
                this.binding.ivAudioBookCover.setVisibility(0);
                this.binding.ivAudioPlay.setVisibility(0);
                Book book = (Book) objectRef.element;
                isLocal = book != null ? book.isLocal() : false;
                Book book2 = (Book) objectRef.element;
                if (book2 == null || (cover2 = book2.getCover()) == null) {
                    cover2 = readingRecord.getCover();
                }
                MiBookManager.v1(getCom.umeng.analytics.pro.f.X java.lang.String(), cover2, isLocal, this.binding.ivAudioBookCover);
                this.binding.tvContent.setText(ExtKt.c("听到：") + ExtKt.c(readingRecord.getReadingStatus()));
                this.binding.recordReading.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.continue_listen));
            } else {
                this.binding.ivAudioBookCover.setVisibility(8);
                this.binding.ivAudioPlay.setVisibility(8);
                this.binding.ivBookCover.setVisibility(0);
                Book book3 = (Book) objectRef.element;
                isLocal = book3 != null ? book3.isLocal() : false;
                Book book4 = (Book) objectRef.element;
                if (book4 == null || (cover = book4.getCover()) == null) {
                    cover = readingRecord.getCover();
                }
                MiBookManager.v1(getCom.umeng.analytics.pro.f.X java.lang.String(), cover, isLocal, this.binding.ivBookCover);
                this.binding.tvContent.setText(ExtKt.c("读到：") + ExtKt.c(readingRecord.getReadingStatus()));
                this.binding.recordReading.setText(getCom.umeng.analytics.pro.f.X java.lang.String().getString(R.string.read_continue));
            }
            this.binding.llReadingRecord.setOnClickListener(new View.OnClickListener() { // from class: ud.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ItemReadingRecordHolder.l(view);
                }
            });
            this.binding.recordReading.setOnClickListener(new View.OnClickListener() { // from class: ud.t

                /* renamed from: c */
                public final /* synthetic */ MiReadingRecord f31030c;

                /* renamed from: d */
                public final /* synthetic */ Ref.ObjectRef f31031d;

                public /* synthetic */ t(MiReadingRecord readingRecord2, Ref.ObjectRef objectRef2) {
                    readingRecord = readingRecord2;
                    objectRef = objectRef2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ItemReadingRecordHolder.m(ItemReadingRecordHolder.this, readingRecord, objectRef, view);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.binding.getRoot().setVisibility(8);
        }
    }
}
