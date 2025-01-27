package com.martian.mibook.mvvm.yuewen.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.yuewen.response.YWChannelBookList;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.request.YWRankBooksParams;
import com.martian.mibook.mvvm.yuewen.repository.BookRankRepository;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookRankViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.yuewen.viewmodel.BookRankViewModel$getBookRankList$1", f = "BookRankViewModel.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nBookRankViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BookRankViewModel.kt\ncom/martian/mibook/mvvm/yuewen/viewmodel/BookRankViewModel$getBookRankList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,178:1\n1855#2,2:179\n1855#2,2:181\n*S KotlinDebug\n*F\n+ 1 BookRankViewModel.kt\ncom/martian/mibook/mvvm/yuewen/viewmodel/BookRankViewModel$getBookRankList$1\n*L\n117#1:179,2\n133#1:181,2\n*E\n"})
/* loaded from: classes3.dex */
public final class BookRankViewModel$getBookRankList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ YWRankBooksParams $rankBooksParams;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BookRankViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookRankViewModel$getBookRankList$1(YWRankBooksParams yWRankBooksParams, BookRankViewModel bookRankViewModel, Continuation<? super BookRankViewModel$getBookRankList$1> continuation) {
        super(2, continuation);
        this.$rankBooksParams = yWRankBooksParams;
        this.this$0 = bookRankViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new BookRankViewModel$getBookRankList$1(this.$rankBooksParams, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        BookRankViewModel bookRankViewModel;
        YWRankBooksParams yWRankBooksParams;
        List<TYBookItem> bookList;
        MutableLiveData mutableLiveData;
        List<TYBookItem> bookList2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            Map<String, String> f10 = ExtKt.f(this.$rankBooksParams);
            bookRankViewModel = this.this$0;
            YWRankBooksParams yWRankBooksParams2 = this.$rankBooksParams;
            BookRankRepository f11 = bookRankViewModel.f();
            this.L$0 = bookRankViewModel;
            this.L$1 = yWRankBooksParams2;
            this.label = 1;
            obj = f11.f(f10, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            yWRankBooksParams = yWRankBooksParams2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            yWRankBooksParams = (YWRankBooksParams) this.L$1;
            bookRankViewModel = (BookRankViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        YWChannelBookList yWChannelBookList = (YWChannelBookList) obj;
        ArrayList arrayList = new ArrayList();
        if (yWRankBooksParams.getPage() == 0) {
            if (yWChannelBookList != null && (bookList2 = yWChannelBookList.getBookList()) != null) {
                arrayList.add(new BookRankViewModel.b(null, yWRankBooksParams.getBrtype(), yWRankBooksParams.getStatus(), null, 8, null));
                for (TYBookItem tYBookItem : bookList2) {
                    if (!TextUtils.isEmpty(bookRankViewModel.getSource())) {
                        tYBookItem.setRecommend(bookRankViewModel.getSource() + tYBookItem.getRecommend());
                    }
                    arrayList.add(new BookRankViewModel.b(tYBookItem, yWRankBooksParams.getBrtype(), yWRankBooksParams.getStatus(), null, 8, null));
                }
            }
        } else if (yWChannelBookList != null && (bookList = yWChannelBookList.getBookList()) != null) {
            Iterator<T> it = bookList.iterator();
            while (it.hasNext()) {
                arrayList.add(new BookRankViewModel.b((TYBookItem) it.next(), null, null, null, 12, null));
            }
        }
        mutableLiveData = bookRankViewModel._mRankBookListLiveData;
        mutableLiveData.postValue(arrayList);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((BookRankViewModel$getBookRankList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
