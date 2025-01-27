package com.martian.mibook.mvvm.read.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.mibook.lib.model.data.abs.Chapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.ReadingBookChapterListAdapter$checkChapterListContentCached$1$1", f = "ReadingBookChapterListAdapter.kt", i = {}, l = {286, 294}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ReadingBookChapterListAdapter$checkChapterListContentCached$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTimeMillis;
    final /* synthetic */ RecyclerView $recyclerView;
    int label;
    final /* synthetic */ ReadingBookChapterListAdapter this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.ReadingBookChapterListAdapter$checkChapterListContentCached$1$1$1", f = "ReadingBookChapterListAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.martian.mibook.mvvm.read.adapter.ReadingBookChapterListAdapter$checkChapterListContentCached$1$1$1 */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $visibleEnd;
        final /* synthetic */ int $visibleStart;
        int label;
        final /* synthetic */ ReadingBookChapterListAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i10, int i11, ReadingBookChapterListAdapter readingBookChapterListAdapter, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$visibleStart = i10;
            this.$visibleEnd = i11;
            this.this$0 = readingBookChapterListAdapter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @k
        public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
            return new AnonymousClass1(this.$visibleStart, this.$visibleEnd, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @l
        public final Object invokeSuspend(@k Object obj) {
            int i10;
            int i11;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.$visibleStart >= 0 && this.$visibleEnd <= this.this$0.getPageSize() && (i10 = this.$visibleEnd) >= (i11 = this.$visibleStart)) {
                this.this$0.notifyItemRangeChanged(i11, (i10 - i11) + 1, Boxing.boxInt(1));
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @l
        public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingBookChapterListAdapter$checkChapterListContentCached$1$1(long j10, RecyclerView recyclerView, ReadingBookChapterListAdapter readingBookChapterListAdapter, Continuation<? super ReadingBookChapterListAdapter$checkChapterListContentCached$1$1> continuation) {
        super(2, continuation);
        this.$delayTimeMillis = j10;
        this.$recyclerView = recyclerView;
        this.this$0 = readingBookChapterListAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new ReadingBookChapterListAdapter$checkChapterListContentCached$1$1(this.$delayTimeMillis, this.$recyclerView, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        int w10;
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(obj);
            long j10 = this.$delayTimeMillis;
            this.label = 1;
            if (DelayKt.delay(j10, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        RecyclerView.LayoutManager layoutManager = this.$recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition() + 1;
        if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            int i11 = findFirstVisibleItemPosition;
            while (true) {
                w10 = this.this$0.w(i11);
                ReadingBookChapterListAdapter readingBookChapterListAdapter = this.this$0;
                list = readingBookChapterListAdapter.dataItems;
                readingBookChapterListAdapter.q(w10, (Chapter) list.get(w10));
                if (i11 == findLastVisibleItemPosition) {
                    break;
                }
                i11++;
            }
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(findFirstVisibleItemPosition, findLastVisibleItemPosition, this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((ReadingBookChapterListAdapter$checkChapterListContentCached$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
