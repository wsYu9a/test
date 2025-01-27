package com.martian.mibook.mvvm.tts.activity;

import android.app.Activity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import com.martian.mibook.mvvm.tts.TTSReadManager;
import com.martian.mibook.mvvm.tts.TtsEnginesUtil;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import l9.i0;
import l9.t0;
import xi.k;
import ya.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/lifecycle/Observer;", "Lcom/martian/mibook/mvvm/tts/ReadAloudBook$a;", "invoke", "()Landroidx/lifecycle/Observer;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class AudiobookActivity$readAloudEventObserver$2 extends Lambda implements Function0<Observer<ReadAloudBook.a>> {
    final /* synthetic */ AudiobookActivity this$0;

    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f15108a;

        static {
            int[] iArr = new int[ReadAloudBook.EventAction.values().length];
            try {
                iArr[ReadAloudBook.EventAction.STATE_REPLENISH_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadAloudBook.EventAction.STATE_NONE_AVAILABLE_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadAloudBook.EventAction.STATE_NONE_NEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadAloudBook.EventAction.STATE_TTS_GUIDE_INSTALL_GOOGLE_ENGINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadAloudBook.EventAction.STATE_TTS_TRY_SWITCH_ENGINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadAloudBook.EventAction.STATE_TTS_NO_AVAILABLE_ENGINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f15108a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudiobookActivity$readAloudEventObserver$2(AudiobookActivity audiobookActivity) {
        super(0);
        this.this$0 = audiobookActivity;
    }

    public static final void invoke$lambda$4(AudiobookActivity this$0, ReadAloudBook.a aVar) {
        WeakReference<Activity> weakReference;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (aVar == null) {
        }
        Activity activity = null;
        switch (a.f15108a[aVar.f().ordinal()]) {
            case 1:
                if (aVar.g() instanceof Integer) {
                    this$0.isAudioPause = aVar.h() != 0;
                    this$0.K3(((Number) aVar.g()).intValue());
                    break;
                }
                break;
            case 2:
                this$0.T3();
                break;
            case 3:
                List<WeakReference<Activity>> d10 = n0.f33313a.d(AudiobookActivity.class);
                if (d10 != null && (weakReference = d10.get(0)) != null) {
                    activity = weakReference.get();
                }
                if (activity != null && (activity instanceof AudiobookActivity)) {
                    Book a10 = ReadAloudBook.f15003a.a();
                    t0.b(this$0, (a10 == null || !a10.isSerialEnd()) ? "您已听到最新章节，去听听其他书籍吧" : "您已听完本书，去听听其他书籍吧");
                    break;
                }
                break;
            case 4:
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this$0.m1()), null, null, new AudiobookActivity$readAloudEventObserver$2$1$1(this$0, null), 3, null);
                break;
            case 5:
                ac.a.W(this$0.getApplicationContext(), "切换引擎-曝光");
                i0.x0(this$0, ExtKt.c("听书启动失败"), ExtKt.c("是否切换其他引擎?"), ExtKt.c("关闭"), ExtKt.c("去切换"), false, new i0.l() { // from class: com.martian.mibook.mvvm.tts.activity.a
                    public /* synthetic */ a() {
                    }

                    @Override // l9.i0.l
                    public final void a() {
                        AudiobookActivity$readAloudEventObserver$2.invoke$lambda$4$lambda$0(AudiobookActivity.this);
                    }
                }, new i0.k() { // from class: com.martian.mibook.mvvm.tts.activity.b
                    public /* synthetic */ b() {
                    }

                    @Override // l9.i0.k
                    public final void a() {
                        AudiobookActivity$readAloudEventObserver$2.invoke$lambda$4$lambda$1(AudiobookActivity.this);
                    }
                });
                break;
            case 6:
                ac.a.W(this$0.getApplicationContext(), "无可用引擎-曝光");
                i0.x0(this$0, ExtKt.c("听书启动失败"), ExtKt.c("缺少可用语音插件"), ExtKt.c("关闭"), ExtKt.c("声音设置"), false, new i0.l() { // from class: com.martian.mibook.mvvm.tts.activity.c
                    public /* synthetic */ c() {
                    }

                    @Override // l9.i0.l
                    public final void a() {
                        AudiobookActivity$readAloudEventObserver$2.invoke$lambda$4$lambda$2(AudiobookActivity.this);
                    }
                }, new i0.k() { // from class: com.martian.mibook.mvvm.tts.activity.d
                    public /* synthetic */ d() {
                    }

                    @Override // l9.i0.k
                    public final void a() {
                        AudiobookActivity$readAloudEventObserver$2.invoke$lambda$4$lambda$3(AudiobookActivity.this);
                    }
                });
                break;
        }
    }

    public static final void invoke$lambda$4$lambda$0(AudiobookActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.W(this$0.getApplicationContext(), "切换引擎-点击");
        TtsEnginesUtil.m(this$0);
    }

    public static final void invoke$lambda$4$lambda$1(AudiobookActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TTSReadManager.l(this$0);
    }

    public static final void invoke$lambda$4$lambda$2(AudiobookActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.W(this$0.getApplicationContext(), "声音设置-点击");
        TtsEnginesUtil.m(this$0);
    }

    public static final void invoke$lambda$4$lambda$3(AudiobookActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TTSReadManager.l(this$0);
    }

    @Override // kotlin.jvm.functions.Function0
    @k
    public final Observer<ReadAloudBook.a> invoke() {
        return new Observer() { // from class: com.martian.mibook.mvvm.tts.activity.e
            public /* synthetic */ e() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AudiobookActivity$readAloudEventObserver$2.invoke$lambda$4(AudiobookActivity.this, (ReadAloudBook.a) obj);
            }
        };
    }
}
