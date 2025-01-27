package com.martian.mibook.mvvm.tts.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.UtteranceProgressListener;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.mibook.application.EventManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.mvvm.base.BaseService;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import com.martian.mibook.mvvm.tts.TTSController;
import com.martian.mibook.mvvm.tts.TtsEnginesUtil;
import com.martian.mibook.mvvm.tts.TtsTimeController;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import id.b;
import java.util.concurrent.CancellationException;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import xc.a;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004*\u0001H\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u0015J\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u0003J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\u0015J\u001f\u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\nH\u0016¢\u0006\u0004\b(\u0010\fJ\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0019\u0010.\u001a\u0004\u0018\u00010)2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/R\u001c\u00103\u001a\b\u0012\u0002\b\u0003\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010;R\u0014\u0010>\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010D\u001a\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010I¨\u0006K"}, d2 = {"Lcom/martian/mibook/mvvm/tts/service/TTSReadAloudService;", "Lcom/martian/mibook/mvvm/tts/service/BaseReadAloudService;", "<init>", "()V", "", "I0", "", BaseReadAloudService.f15169y, "J0", "(I)V", "", "D0", "()Z", "L0", "M0", "seconds", "C0", "G0", "H0", "speakTitle", "K0", "(Z)V", "E0", "onCreate", "j0", "i0", "Y", "abandonFocus", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "d0", "X", "o0", "reset", "m0", "mChapterIndex", "mContentPos", "U", "(II)V", "l0", "onDestroy", "R", "Landroid/app/PendingIntent;", IAdInterListener.AdReqParam.WIDTH, "()Landroid/app/PendingIntent;", "", "actionStr", "b0", "(Ljava/lang/String;)Landroid/app/PendingIntent;", "Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;", "O", "Lcom/martian/mibook/mvvm/utils/coroutine/Coroutine;", "speakJob", "P", "Z", "mSpeakTitle", "Lkotlinx/coroutines/Job;", "Q", "Lkotlinx/coroutines/Job;", "timeJob", "I", "processSeconds", ExifInterface.LATITUDE_SOUTH, "fullSeconds", "", ExifInterface.GPS_DIRECTION_TRUE, "J", "naturalTimeDiff", "Lcom/martian/mibook/mvvm/tts/TTSController;", "Lkotlin/Lazy;", "F0", "()Lcom/martian/mibook/mvvm/tts/TTSController;", "mTTSController", "com/martian/mibook/mvvm/tts/service/TTSReadAloudService$ttsActionListener$1", "Lcom/martian/mibook/mvvm/tts/service/TTSReadAloudService$ttsActionListener$1;", "ttsActionListener", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class TTSReadAloudService extends BaseReadAloudService {

    /* renamed from: O, reason: from kotlin metadata */
    @l
    public Coroutine<?> speakJob;

    /* renamed from: P, reason: from kotlin metadata */
    public boolean mSpeakTitle;

    /* renamed from: Q, reason: from kotlin metadata */
    @l
    public Job timeJob;

    /* renamed from: R, reason: from kotlin metadata */
    public int processSeconds;

    /* renamed from: S */
    public final int fullSeconds = 120;

    /* renamed from: T */
    public long naturalTimeDiff = -1;

    /* renamed from: U, reason: from kotlin metadata */
    @k
    public final Lazy mTTSController = LazyKt.lazy(TTSReadAloudService$mTTSController$2.INSTANCE);

    /* renamed from: V */
    @k
    public final TTSReadAloudService$ttsActionListener$1 ttsActionListener = new TTSController.a() { // from class: com.martian.mibook.mvvm.tts.service.TTSReadAloudService$ttsActionListener$1

        /* renamed from: a */
        public int f15191a = -1;

        /* renamed from: b */
        @l
        public String f15192b;

        public static final class a extends UtteranceProgressListener {

            /* renamed from: a */
            public final /* synthetic */ TTSReadAloudService f15194a;

            public a(TTSReadAloudService tTSReadAloudService) {
                this.f15194a = tTSReadAloudService;
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public void onDone(@l String str) {
                BaseReadAloudService.W(this.f15194a, false, 1, null);
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public void onError(@l String str) {
                BaseReadAloudService.W(this.f15194a, false, 1, null);
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public void onStart(@l String str) {
            }
        }

        public TTSReadAloudService$ttsActionListener$1() {
        }

        @Override // com.martian.mibook.mvvm.tts.TTSController.a
        public void a(@l String str, boolean z10) {
            BaseReadAloudService.W(TTSReadAloudService.this, false, 1, null);
            if (z10) {
                BaseReadAloudService.INSTANCE.d().postValue(new ReadAloudBook.a(ReadAloudBook.EventAction.STATE_TTS_TRY_SWITCH_ENGINE, null, 0, 6, null));
                return;
            }
            Context applicationContext = TTSReadAloudService.this.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            if (TtsEnginesUtil.g(applicationContext, TtsEnginesUtil.f15064c)) {
                BaseReadAloudService.INSTANCE.d().postValue(new ReadAloudBook.a(ReadAloudBook.EventAction.STATE_TTS_NO_AVAILABLE_ENGINE, null, 0, 6, null));
            } else {
                TtsEnginesUtil.f15062a.j(true);
                BaseReadAloudService.INSTANCE.d().postValue(new ReadAloudBook.a(ReadAloudBook.EventAction.STATE_TTS_GUIDE_INSTALL_GOOGLE_ENGINE, null, 0, 6, null));
            }
        }

        @Override // com.martian.mibook.mvvm.tts.TTSController.a
        public void b() {
            TTSReadAloudService.this.Y();
        }

        @Override // com.martian.mibook.mvvm.tts.TTSController.a
        public void c() {
            BaseReadAloudService.W(TTSReadAloudService.this, false, 1, null);
        }

        @Override // com.martian.mibook.mvvm.tts.TTSController.a
        public void d(boolean z10) {
            boolean z11;
            String str;
            TTSController F0;
            z11 = TTSReadAloudService.this.mSpeakTitle;
            if (z11) {
                ReadAloudBook.f15003a.D(0);
                TTSReadAloudService.this.K0(false);
                return;
            }
            TTSReadAloudService.this.Z(null);
            BaseReadAloudService.Companion companion = BaseReadAloudService.INSTANCE;
            if (companion.j() == -1) {
                companion.p(0L);
                ReadAloudBook.f15003a.J(0);
                BaseReadAloudService.W(TTSReadAloudService.this, false, 1, null);
                companion.i().postValue(Long.valueOf(companion.j()));
                return;
            }
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            int c10 = readAloudBook.c() + 1;
            ChapterList d10 = readAloudBook.d();
            if (c10 < (d10 != null ? d10.getCount() : 0)) {
                Coroutine.Companion.async$default(Coroutine.INSTANCE, null, null, null, null, new TTSReadAloudService$ttsActionListener$1$onTtsDone$2(TTSReadAloudService.this, null), 15, null);
                return;
            }
            Book a10 = readAloudBook.a();
            if (a10 == null || !a10.isSerialEnd()) {
                str = i.j(TTSReadAloudService.this.getApplicationContext()) + "提醒，您已听到最新章节，去听听其他书籍吧";
            } else {
                str = i.j(TTSReadAloudService.this.getApplicationContext()) + "提醒，您已听完本书，去听听其他书籍吧";
            }
            F0 = TTSReadAloudService.this.F0();
            F0.H(str, 0, new a(TTSReadAloudService.this));
            readAloudBook.D(readAloudBook.l());
            ChapterList d11 = readAloudBook.d();
            readAloudBook.B((d11 != null ? d11.getCount() : 1) - 1);
            companion.d().postValue(new ReadAloudBook.a(ReadAloudBook.EventAction.STATE_NONE_NEXT, null, 0, 6, null));
        }

        @Override // com.martian.mibook.mvvm.tts.TTSController.a
        public void e(@l String str, int i10, int i11) {
            boolean z10;
            z10 = TTSReadAloudService.this.mSpeakTitle;
            if (z10) {
                ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
                readAloudBook.D(-(str != null ? str.length() : 0));
                readAloudBook.H(0);
                this.f15191a = -1;
                TTSReadAloudService.this.Z(Boolean.TRUE);
            } else {
                ReadAloudBook readAloudBook2 = ReadAloudBook.f15003a;
                readAloudBook2.D(i10);
                readAloudBook2.H(i11);
                TTSReadAloudService.this.Z(Boolean.FALSE);
            }
            if (this.f15192b == null) {
                this.f15192b = str;
            }
            if (i10 - this.f15191a > 100 || this.f15192b != str) {
                ReadAloudBook.f15003a.y();
                this.f15191a = i10;
                this.f15192b = str;
            }
        }

        @l
        public final String f() {
            return this.f15192b;
        }

        public final int g() {
            return this.f15191a;
        }

        public final void h(@l String str) {
            this.f15192b = str;
        }

        public final void i(int i10) {
            this.f15191a = i10;
        }
    };

    public final void C0(int seconds) {
        EventManager V1 = MiConfigSingleton.b2().V1();
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        Book a10 = readAloudBook.a();
        String sourceName = a10 != null ? a10.getSourceName() : null;
        Book a11 = readAloudBook.a();
        String sourceId = a11 != null ? a11.getSourceId() : null;
        Book a12 = readAloudBook.a();
        TYBookItem tYBookItem = a12 instanceof TYBookItem ? (TYBookItem) a12 : null;
        String recommendId = tYBookItem != null ? tYBookItem.getRecommendId() : null;
        String str = recommendId == null ? "" : recommendId;
        int c10 = readAloudBook.c();
        MiReadingRecord m10 = readAloudBook.m();
        V1.h(9, sourceName, sourceId, str, "", "", seconds, c10, "", m10 != null && m10.isFirstRead());
    }

    public final boolean D0() {
        if (TtsTimeController.t()) {
            BaseReadAloudService.INSTANCE.c().postValue(-1L);
            return true;
        }
        int b10 = TtsTimeController.b(this);
        if (b10 > 0) {
            BaseReadAloudService.Companion companion = BaseReadAloudService.INSTANCE;
            boolean l10 = companion.l();
            if (l10) {
                BaseReadAloudService.W(this, false, 1, null);
            }
            companion.c().postValue(Long.valueOf(TtsTimeController.g()));
            companion.d().postValue(new ReadAloudBook.a(ReadAloudBook.EventAction.STATE_REPLENISH_TIME, Integer.valueOf(b10), l10 ? 1 : 0));
            return false;
        }
        if (!TtsTimeController.s()) {
            return true;
        }
        if (TtsTimeController.f15066a.h() == TtsTimeController.TimeMode.MODE_NATURAL_TIME) {
            TtsTimeController.w(this, 0L);
        } else {
            TtsTimeController.v(this, 0L);
        }
        BaseReadAloudService.W(this, false, 1, null);
        BaseReadAloudService.Companion companion2 = BaseReadAloudService.INSTANCE;
        companion2.c().postValue(0L);
        companion2.d().postValue(new ReadAloudBook.a(ReadAloudBook.EventAction.STATE_NONE_AVAILABLE_TIME, null, 0, 6, null));
        return false;
    }

    public final synchronized void E0() {
        F0().E();
    }

    public final TTSController F0() {
        return (TTSController) this.mTTSController.getValue();
    }

    public final void G0() {
        TtsTimeController ttsTimeController = TtsTimeController.f15066a;
        if (ttsTimeController.e() <= 0) {
            return;
        }
        ttsTimeController.x(ttsTimeController.e() - 1);
        if (ttsTimeController.e() == 0) {
            if (MiConfigSingleton.b2().K2()) {
                ttsTimeController.x(-1L);
            } else {
                BaseReadAloudService.W(this, false, 1, null);
                TtsTimeController.v(this, 0L);
                BaseReadAloudService.INSTANCE.d().postValue(new ReadAloudBook.a(ReadAloudBook.EventAction.STATE_NONE_AVAILABLE_TIME, null, 0, 6, null));
            }
        }
        BaseReadAloudService.INSTANCE.c().postValue(Long.valueOf(ttsTimeController.e()));
    }

    public final void H0() {
        TtsTimeController ttsTimeController = TtsTimeController.f15066a;
        if (ttsTimeController.n() <= 0) {
            return;
        }
        long coerceAtLeast = RangesKt.coerceAtLeast(ttsTimeController.n() - a.f31995a.a(), 0L) / 1000;
        if (this.naturalTimeDiff == -1 && coerceAtLeast == 0) {
            return;
        }
        this.naturalTimeDiff = coerceAtLeast;
        if (coerceAtLeast > 0) {
            BaseReadAloudService.INSTANCE.c().postValue(Long.valueOf(this.naturalTimeDiff));
            return;
        }
        if (MiConfigSingleton.b2().K2()) {
            ttsTimeController.z(-1L);
            return;
        }
        BaseReadAloudService.Companion companion = BaseReadAloudService.INSTANCE;
        companion.c().postValue(0L);
        BaseReadAloudService.W(this, false, 1, null);
        TtsTimeController.w(this, 0L);
        companion.d().postValue(new ReadAloudBook.a(ReadAloudBook.EventAction.STATE_NONE_AVAILABLE_TIME, null, 0, 6, null));
    }

    public final synchronized void I0() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new TTSReadAloudService$initTTS$1(this, null), 2, null);
    }

    public final void J0(int r15) {
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        int c10 = readAloudBook.c();
        ChapterList d10 = readAloudBook.d();
        if (c10 < (d10 != null ? d10.getCount() : 0)) {
            Coroutine<?> coroutine = this.speakJob;
            if (coroutine != null) {
                coroutine.cancel();
            }
            this.speakJob = Coroutine.onSuccess$default(BaseService.b(this, null, null, null, null, new TTSReadAloudService$loadContentAndStart$1(r15, null), 15, null), null, new TTSReadAloudService$loadContentAndStart$2(this, null), 1, null);
            return;
        }
        ChapterList d11 = readAloudBook.d();
        readAloudBook.B((d11 != null ? d11.getCount() : 1) - 1);
        readAloudBook.D(readAloudBook.l());
        BaseReadAloudService.W(this, false, 1, null);
        Z(null);
        BaseReadAloudService.INSTANCE.d().postValue(new ReadAloudBook.a(ReadAloudBook.EventAction.STATE_NONE_NEXT, null, 0, 6, null));
    }

    public final void K0(boolean speakTitle) {
        this.mSpeakTitle = speakTitle;
        if (speakTitle) {
            F0().I(ReadAloudBook.f15003a.e(), 0, true);
            return;
        }
        TTSController F0 = F0();
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        ChapterContent i10 = readAloudBook.i();
        F0.I(i10 != null ? i10.getContent() : null, readAloudBook.f(), true);
    }

    public final void L0() {
        Job launch$default;
        M0();
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getDefault(), null, new TTSReadAloudService$startTtsTimer$1(this, null), 2, null);
        this.timeJob = launch$default;
    }

    public final void M0() {
        Job job = this.timeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.naturalTimeDiff = -1L;
        int i10 = this.processSeconds;
        if (i10 > 0) {
            C0(i10);
        }
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    public boolean R() {
        return F0().t();
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    public void U(int mChapterIndex, int mContentPos) {
        if (F0().J()) {
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            int c10 = readAloudBook.c();
            readAloudBook.B(mChapterIndex);
            readAloudBook.D(mContentPos);
            if (c10 != mChapterIndex) {
                readAloudBook.y();
            }
            J0(mContentPos);
        }
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    public void V(boolean z10) {
        super.V(z10);
        Coroutine<?> coroutine = this.speakJob;
        if (coroutine != null) {
            coroutine.cancel();
        }
        F0().A();
        TtsTimeController.u(this);
        ReadAloudBook.f15003a.y();
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    public void X() {
        if (D0()) {
            super.X();
            a0(ReadAloudBook.ReadAloudPlayerStatus.STATE_PLAYING);
            K0(ReadAloudBook.f15003a.f() <= 0);
        }
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    public void Y() {
        if (R() && c0()) {
            super.Y();
            b.f26962a.h(this);
            m0(false);
            J0(ReadAloudBook.f15003a.f());
        }
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    @l
    public PendingIntent b0(@k String actionStr) {
        Intrinsics.checkNotNullParameter(actionStr, "actionStr");
        Intent intent = new Intent(this, (Class<?>) TTSReadAloudService.class);
        intent.setAction(actionStr);
        return PendingIntent.getService(this, 0, intent, 134217728);
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    public void d0() {
        if (!R()) {
            I0();
            return;
        }
        if (D0()) {
            super.d0();
            Coroutine<?> coroutine = this.speakJob;
            if (coroutine != null) {
                coroutine.cancel();
            }
            if (F0().v()) {
                F0().B();
            } else {
                K0(ReadAloudBook.f15003a.f() <= 0);
            }
        }
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    public void i0() {
        if (D0()) {
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            int c10 = readAloudBook.c() + 1;
            ChapterList d10 = readAloudBook.d();
            if (c10 >= (d10 != null ? d10.getCount() : 0)) {
                BaseReadAloudService.INSTANCE.d().postValue(new ReadAloudBook.a(ReadAloudBook.EventAction.STATE_NONE_NEXT, null, 0, 6, null));
                return;
            }
            Coroutine<?> coroutine = this.speakJob;
            if (coroutine != null) {
                coroutine.cancel();
            }
            F0().J();
            readAloudBook.B(readAloudBook.c() + 1);
            readAloudBook.D(0);
            super.i0();
            J0(0);
        }
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    public void j0() {
        if (D0()) {
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            if (readAloudBook.c() == 0) {
                BaseReadAloudService.INSTANCE.d().postValue(new ReadAloudBook.a(ReadAloudBook.EventAction.STATE_NONE_LAST, null, 0, 6, null));
                return;
            }
            Coroutine<?> coroutine = this.speakJob;
            if (coroutine != null) {
                coroutine.cancel();
            }
            F0().J();
            readAloudBook.B(readAloudBook.c() - 1);
            readAloudBook.D(0);
            super.j0();
            J0(0);
        }
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    public void l0() {
        Coroutine<?> coroutine = this.speakJob;
        if (coroutine != null) {
            coroutine.cancel();
        }
        E0();
        BaseReadAloudService.INSTANCE.p(0L);
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        readAloudBook.J(0);
        readAloudBook.G(0.0f);
        TtsTimeController.u(this);
        readAloudBook.y();
        super.l0();
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    public void m0(boolean reset) {
        if (reset) {
            E0();
            I0();
            return;
        }
        ReadingInstance z10 = ReadingInstance.z();
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        z10.Y(this, (int) readAloudBook.t());
        F0().D(readAloudBook.t());
        if (F0().A() && TtsTimeController.p()) {
            F0().B();
        }
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    public void o0() {
        D0();
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService, androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        I0();
        L0();
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService, androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        M0();
        TtsTimeController.u(this);
        super.onDestroy();
    }

    @Override // com.martian.mibook.mvvm.tts.service.BaseReadAloudService
    @k
    public PendingIntent w() {
        PendingIntent activity = PendingIntent.getActivity(this, 0, kc.b.a(this), 134217728);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }
}
