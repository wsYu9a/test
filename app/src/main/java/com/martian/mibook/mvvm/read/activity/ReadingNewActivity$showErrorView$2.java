package com.martian.mibook.mvvm.read.activity;

import android.text.TextUtils;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import l9.i0;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReadingNewActivity$showErrorView$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ReadingNewActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingNewActivity$showErrorView$2(ReadingNewActivity readingNewActivity) {
        super(0);
        this.this$0 = readingNewActivity;
    }

    public static final void invoke$lambda$0(ReadingNewActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    public static final void invoke$lambda$1(ReadingNewActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke */
    public final void invoke2() {
        if (this.this$0.m1().getBook() != null) {
            ReadingViewModel m12 = this.this$0.m1();
            m12.z2(m12.getChapterListRetry() + 1);
            this.this$0.m1().P();
        } else if (TextUtils.isEmpty(this.this$0.m1().getSourceName()) || TextUtils.isEmpty(this.this$0.m1().getSourceId())) {
            i0.F0(this.this$0, ExtKt.c("信息获取失败"), ExtKt.c("很抱歉，无法获取本书信息"), "退出", new i0.k() { // from class: com.martian.mibook.mvvm.read.activity.e
                public /* synthetic */ e() {
                }

                @Override // l9.i0.k
                public final void a() {
                    ReadingNewActivity$showErrorView$2.invoke$lambda$0(ReadingNewActivity.this);
                }
            }, new i0.l() { // from class: com.martian.mibook.mvvm.read.activity.f
                public /* synthetic */ f() {
                }

                @Override // l9.i0.l
                public final void a() {
                    ReadingNewActivity$showErrorView$2.invoke$lambda$1(ReadingNewActivity.this);
                }
            });
        } else {
            this.this$0.m1().b2();
        }
    }
}
