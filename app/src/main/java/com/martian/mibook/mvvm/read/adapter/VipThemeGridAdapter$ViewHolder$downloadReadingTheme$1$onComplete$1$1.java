package com.martian.mibook.mvvm.read.adapter;

import android.content.Context;
import android.widget.TextView;
import com.martian.mibook.R;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.martian.mibook.databinding.ItemReadingVipThemeBinding;
import com.martian.mibook.mvvm.read.adapter.VipThemeGridAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.martian.mibook.mvvm.read.adapter.VipThemeGridAdapter$ViewHolder$downloadReadingTheme$1$onComplete$1$1", f = "VipThemeGridAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class VipThemeGridAdapter$ViewHolder$downloadReadingTheme$1$onComplete$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MiReadingTheme $readingTheme;
    int label;
    final /* synthetic */ VipThemeGridAdapter.ViewHolder this$0;
    final /* synthetic */ VipThemeGridAdapter this$1;
    final /* synthetic */ VipThemeGridAdapter$ViewHolder$downloadReadingTheme$1 this$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipThemeGridAdapter$ViewHolder$downloadReadingTheme$1$onComplete$1$1(MiReadingTheme miReadingTheme, VipThemeGridAdapter.ViewHolder viewHolder, VipThemeGridAdapter vipThemeGridAdapter, VipThemeGridAdapter$ViewHolder$downloadReadingTheme$1 vipThemeGridAdapter$ViewHolder$downloadReadingTheme$1, Continuation<? super VipThemeGridAdapter$ViewHolder$downloadReadingTheme$1$onComplete$1$1> continuation) {
        super(2, continuation);
        this.$readingTheme = miReadingTheme;
        this.this$0 = viewHolder;
        this.this$1 = vipThemeGridAdapter;
        this.this$2 = vipThemeGridAdapter$ViewHolder$downloadReadingTheme$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final Continuation<Unit> create(@l Object obj, @k Continuation<?> continuation) {
        return new VipThemeGridAdapter$ViewHolder$downloadReadingTheme$1$onComplete$1$1(this.$readingTheme, this.this$0, this.this$1, this.this$2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object invokeSuspend(@k Object obj) {
        ItemReadingVipThemeBinding itemReadingVipThemeBinding;
        Context context;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$readingTheme.downloadFileCopyToFilePath()) {
            this.$readingTheme.setDownLoadStatus(0);
            itemReadingVipThemeBinding = this.this$0.binding;
            TextView textView = itemReadingVipThemeBinding.tvThemeStatus;
            context = this.this$0.com.umeng.analytics.pro.f.X java.lang.String;
            textView.setText(context.getString(R.string.download_finish));
            VipThemeGridAdapter.a aVar = this.this$1.onThemeSelectListener;
            if (aVar != null) {
                aVar.a(this.$readingTheme);
            }
        } else {
            this.this$2.c(null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @l
    public final Object invoke(@k CoroutineScope coroutineScope, @l Continuation<? super Unit> continuation) {
        return ((VipThemeGridAdapter$ViewHolder$downloadReadingTheme$1$onComplete$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
