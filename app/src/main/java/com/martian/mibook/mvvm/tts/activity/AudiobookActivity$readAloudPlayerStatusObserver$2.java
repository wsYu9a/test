package com.martian.mibook.mvvm.tts.activity;

import androidx.lifecycle.Observer;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import xi.k;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/Observer;", "Lcom/martian/mibook/mvvm/tts/ReadAloudBook$ReadAloudPlayerStatus;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AudiobookActivity$readAloudPlayerStatusObserver$2 extends Lambda implements Function0<Observer<ReadAloudBook.ReadAloudPlayerStatus>> {
    final /* synthetic */ AudiobookActivity this$0;

    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f15109a;

        static {
            int[] iArr = new int[ReadAloudBook.ReadAloudPlayerStatus.values().length];
            try {
                iArr[ReadAloudBook.ReadAloudPlayerStatus.STATE_PRE_PLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadAloudBook.ReadAloudPlayerStatus.STATE_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadAloudBook.ReadAloudPlayerStatus.STATE_PLAYING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadAloudBook.ReadAloudPlayerStatus.STATE_NEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadAloudBook.ReadAloudPlayerStatus.STATE_PREVIOUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadAloudBook.ReadAloudPlayerStatus.STATE_STOPPED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f15109a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudiobookActivity$readAloudPlayerStatusObserver$2(AudiobookActivity audiobookActivity) {
        super(0);
        this.this$0 = audiobookActivity;
    }

    public static final void invoke$lambda$0(AudiobookActivity this$0, ReadAloudBook.ReadAloudPlayerStatus readAloudPlayerStatus) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (readAloudPlayerStatus == null ? -1 : a.f15109a[readAloudPlayerStatus.ordinal()]) {
            case 1:
                this$0.a3();
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                this$0.b3();
                break;
            case 6:
                if (!this$0.m1().getIsRestarting()) {
                    this$0.finish();
                    break;
                } else {
                    this$0.m1().H(false);
                    break;
                }
        }
    }

    @Override // kotlin.jvm.functions.Function0
    @k
    public final Observer<ReadAloudBook.ReadAloudPlayerStatus> invoke() {
        return new Observer() { // from class: com.martian.mibook.mvvm.tts.activity.g
            public /* synthetic */ g() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudiobookActivity$readAloudPlayerStatusObserver$2.invoke$lambda$0(AudiobookActivity.this, (ReadAloudBook.ReadAloudPlayerStatus) obj);
            }
        };
    }
}
