package com.martian.mibook.mvvm.tts;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import xb.e;
import xb.f;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class ReadAloudBook {

    /* renamed from: b */
    public static volatile int f15004b;

    /* renamed from: c */
    public static volatile int f15005c;

    /* renamed from: d */
    public static volatile int f15006d;

    /* renamed from: e */
    @l
    public static volatile ChapterList f15007e;

    /* renamed from: f */
    @l
    public static volatile Book f15008f;

    /* renamed from: g */
    @l
    public static volatile String f15009g;

    /* renamed from: i */
    @l
    public static volatile ChapterContent f15011i;

    /* renamed from: j */
    @l
    public static volatile MiReadingRecord f15012j;

    /* renamed from: k */
    @l
    public static volatile WeakReference<Bitmap> f15013k;

    /* renamed from: m */
    public static volatile int f15015m;

    /* renamed from: a */
    @k
    public static final ReadAloudBook f15003a = new ReadAloudBook();

    /* renamed from: h */
    public static volatile float f15010h = 100.0f;

    /* renamed from: l */
    public static volatile float f15014l = -1.0f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/martian/mibook/mvvm/tts/ReadAloudBook$EventAction;", "", "(Ljava/lang/String;I)V", "STATE_REPLENISH_TIME", "STATE_NONE_AVAILABLE_TIME", "STATE_NONE_NEXT", "STATE_NONE_LAST", "STATE_TTS_TRY_SWITCH_ENGINE", "STATE_TTS_NO_AVAILABLE_ENGINE", "STATE_TTS_GUIDE_INSTALL_GOOGLE_ENGINE", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EventAction extends Enum<EventAction> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EventAction[] $VALUES;
        public static final EventAction STATE_REPLENISH_TIME = new EventAction("STATE_REPLENISH_TIME", 0);
        public static final EventAction STATE_NONE_AVAILABLE_TIME = new EventAction("STATE_NONE_AVAILABLE_TIME", 1);
        public static final EventAction STATE_NONE_NEXT = new EventAction("STATE_NONE_NEXT", 2);
        public static final EventAction STATE_NONE_LAST = new EventAction("STATE_NONE_LAST", 3);
        public static final EventAction STATE_TTS_TRY_SWITCH_ENGINE = new EventAction("STATE_TTS_TRY_SWITCH_ENGINE", 4);
        public static final EventAction STATE_TTS_NO_AVAILABLE_ENGINE = new EventAction("STATE_TTS_NO_AVAILABLE_ENGINE", 5);
        public static final EventAction STATE_TTS_GUIDE_INSTALL_GOOGLE_ENGINE = new EventAction("STATE_TTS_GUIDE_INSTALL_GOOGLE_ENGINE", 6);

        private static final /* synthetic */ EventAction[] $values() {
            return new EventAction[]{STATE_REPLENISH_TIME, STATE_NONE_AVAILABLE_TIME, STATE_NONE_NEXT, STATE_NONE_LAST, STATE_TTS_TRY_SWITCH_ENGINE, STATE_TTS_NO_AVAILABLE_ENGINE, STATE_TTS_GUIDE_INSTALL_GOOGLE_ENGINE};
        }

        static {
            EventAction[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private EventAction(String str, int i10) {
            super(str, i10);
        }

        @k
        public static EnumEntries<EventAction> getEntries() {
            return $ENTRIES;
        }

        public static EventAction valueOf(String str) {
            return (EventAction) Enum.valueOf(EventAction.class, str);
        }

        public static EventAction[] values() {
            return (EventAction[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/martian/mibook/mvvm/tts/ReadAloudBook$ReadAloudPlayerStatus;", "", "(Ljava/lang/String;I)V", "STATE_NONE", "STATE_STOPPED", "STATE_PAUSED", "STATE_PLAYING", "STATE_PRE_PLAY", "STATE_NEXT", "STATE_PREVIOUS", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ReadAloudPlayerStatus extends Enum<ReadAloudPlayerStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ReadAloudPlayerStatus[] $VALUES;
        public static final ReadAloudPlayerStatus STATE_NONE = new ReadAloudPlayerStatus("STATE_NONE", 0);
        public static final ReadAloudPlayerStatus STATE_STOPPED = new ReadAloudPlayerStatus("STATE_STOPPED", 1);
        public static final ReadAloudPlayerStatus STATE_PAUSED = new ReadAloudPlayerStatus("STATE_PAUSED", 2);
        public static final ReadAloudPlayerStatus STATE_PLAYING = new ReadAloudPlayerStatus("STATE_PLAYING", 3);
        public static final ReadAloudPlayerStatus STATE_PRE_PLAY = new ReadAloudPlayerStatus("STATE_PRE_PLAY", 4);
        public static final ReadAloudPlayerStatus STATE_NEXT = new ReadAloudPlayerStatus("STATE_NEXT", 5);
        public static final ReadAloudPlayerStatus STATE_PREVIOUS = new ReadAloudPlayerStatus("STATE_PREVIOUS", 6);

        private static final /* synthetic */ ReadAloudPlayerStatus[] $values() {
            return new ReadAloudPlayerStatus[]{STATE_NONE, STATE_STOPPED, STATE_PAUSED, STATE_PLAYING, STATE_PRE_PLAY, STATE_NEXT, STATE_PREVIOUS};
        }

        static {
            ReadAloudPlayerStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private ReadAloudPlayerStatus(String str, int i10) {
            super(str, i10);
        }

        @k
        public static EnumEntries<ReadAloudPlayerStatus> getEntries() {
            return $ENTRIES;
        }

        public static ReadAloudPlayerStatus valueOf(String str) {
            return (ReadAloudPlayerStatus) Enum.valueOf(ReadAloudPlayerStatus.class, str);
        }

        public static ReadAloudPlayerStatus[] values() {
            return (ReadAloudPlayerStatus[]) $VALUES.clone();
        }
    }

    public static final class a {

        /* renamed from: a */
        @k
        public final EventAction f15016a;

        /* renamed from: b */
        @l
        public final Object f15017b;

        /* renamed from: c */
        public final int f15018c;

        public a(@k EventAction action, @l Object obj, int i10) {
            Intrinsics.checkNotNullParameter(action, "action");
            this.f15016a = action;
            this.f15017b = obj;
            this.f15018c = i10;
        }

        public static /* synthetic */ a e(a aVar, EventAction eventAction, Object obj, int i10, int i11, Object obj2) {
            if ((i11 & 1) != 0) {
                eventAction = aVar.f15016a;
            }
            if ((i11 & 2) != 0) {
                obj = aVar.f15017b;
            }
            if ((i11 & 4) != 0) {
                i10 = aVar.f15018c;
            }
            return aVar.d(eventAction, obj, i10);
        }

        @k
        public final EventAction a() {
            return this.f15016a;
        }

        @l
        public final Object b() {
            return this.f15017b;
        }

        public final int c() {
            return this.f15018c;
        }

        @k
        public final a d(@k EventAction action, @l Object obj, int i10) {
            Intrinsics.checkNotNullParameter(action, "action");
            return new a(action, obj, i10);
        }

        public boolean equals(@l Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f15016a == aVar.f15016a && Intrinsics.areEqual(this.f15017b, aVar.f15017b) && this.f15018c == aVar.f15018c;
        }

        @k
        public final EventAction f() {
            return this.f15016a;
        }

        @l
        public final Object g() {
            return this.f15017b;
        }

        public final int h() {
            return this.f15018c;
        }

        public int hashCode() {
            int hashCode = this.f15016a.hashCode() * 31;
            Object obj = this.f15017b;
            return ((hashCode + (obj == null ? 0 : obj.hashCode())) * 31) + this.f15018c;
        }

        @k
        public String toString() {
            return "ReadAloudEvent(action=" + this.f15016a + ", any=" + this.f15017b + ", what=" + this.f15018c + ")";
        }

        public /* synthetic */ a(EventAction eventAction, Object obj, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(eventAction, (i11 & 2) != 0 ? null : obj, (i11 & 4) != 0 ? 0 : i10);
        }
    }

    public static final class b extends f {

        /* renamed from: a */
        public final /* synthetic */ Book f15019a;

        /* renamed from: b */
        public final /* synthetic */ String f15020b;

        /* renamed from: c */
        public final /* synthetic */ int f15021c;

        /* renamed from: d */
        public final /* synthetic */ int f15022d;

        /* renamed from: e */
        public final /* synthetic */ Continuation<Boolean> f15023e;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Book book, String str, int i10, int i11, Continuation<? super Boolean> continuation) {
            this.f15019a = book;
            this.f15020b = str;
            this.f15021c = i10;
            this.f15022d = i11;
            this.f15023e = continuation;
        }

        @Override // xb.f
        public void a(boolean z10) {
        }

        @Override // xb.f
        public void c(@l ChapterList chapterList) {
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            readAloudBook.z(this.f15019a);
            readAloudBook.A(this.f15020b);
            readAloudBook.B(this.f15021c);
            readAloudBook.D(this.f15022d);
            readAloudBook.C(chapterList);
            Continuation<Boolean> continuation = this.f15023e;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m58constructorimpl(Boolean.TRUE));
        }

        @Override // xb.f
        public void d(@l x8.c cVar) {
            Continuation<Boolean> continuation = this.f15023e;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m58constructorimpl(Boolean.FALSE));
        }
    }

    public static final class c implements e {

        /* renamed from: a */
        public final /* synthetic */ int f15024a;

        /* renamed from: b */
        public final /* synthetic */ Continuation<Boolean> f15025b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(int i10, Continuation<? super Boolean> continuation) {
            this.f15024a = i10;
            this.f15025b = continuation;
        }

        @Override // xb.e
        public void a(@l Chapter chapter, @l String str) {
            Continuation<Boolean> continuation = this.f15025b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m58constructorimpl(Boolean.FALSE));
        }

        @Override // xb.e
        public void b(@l ChapterContent chapterContent) {
        }

        @Override // xb.e
        public void c(@l ChapterContent chapterContent) {
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            readAloudBook.F(chapterContent);
            int i10 = this.f15024a;
            ChapterContent i11 = readAloudBook.i();
            readAloudBook.D(RangesKt.coerceAtMost(i10, i11 != null ? i11.getContentLength() : 0));
            Continuation<Boolean> continuation = this.f15025b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m58constructorimpl(Boolean.TRUE));
        }

        @Override // xb.e
        public void onLoading(boolean z10) {
        }

        @Override // xb.e
        public void onResultError(@l x8.c cVar) {
            Continuation<Boolean> continuation = this.f15025b;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m58constructorimpl(Boolean.FALSE));
        }
    }

    public static /* synthetic */ float o(ReadAloudBook readAloudBook, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = Integer.valueOf(readAloudBook.r());
        }
        return readAloudBook.n(num);
    }

    public static /* synthetic */ float q(ReadAloudBook readAloudBook, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = Integer.valueOf(readAloudBook.r());
        }
        return readAloudBook.p(num);
    }

    public final void A(@l String str) {
        f15009g = str;
    }

    public final void B(int i10) {
        f15004b = i10;
    }

    public final void C(@l ChapterList chapterList) {
        f15007e = chapterList;
    }

    public final void D(int i10) {
        f15005c = i10;
    }

    public final void E(@l WeakReference<Bitmap> weakReference) {
        f15013k = weakReference;
    }

    public final void F(@l ChapterContent chapterContent) {
        f15011i = chapterContent;
    }

    public final void G(float f10) {
        f15014l = f10;
    }

    public final void H(int i10) {
        f15006d = i10;
    }

    public final void I(@l MiReadingRecord miReadingRecord) {
        f15012j = miReadingRecord;
    }

    public final void J(int i10) {
        f15015m = i10;
    }

    public final void K(float f10) {
        if (f10 <= 0.0f) {
            return;
        }
        f15010h = f10;
    }

    @l
    public final Book a() {
        return f15008f;
    }

    @l
    public final String b() {
        return f15009g;
    }

    public final int c() {
        ChapterList chapterList = f15007e;
        int count = chapterList != null ? chapterList.getCount() : 0;
        if (f15004b >= count) {
            f15004b = count - 1;
        }
        if (f15004b < 0) {
            f15004b = 0;
        }
        return f15004b;
    }

    @l
    public final ChapterList d() {
        return f15007e;
    }

    @l
    public final String e() {
        Chapter item;
        ChapterContent chapterContent = f15011i;
        String str = null;
        String title = chapterContent != null ? chapterContent.getTitle() : null;
        if (!TextUtils.isEmpty(title) || c() < 0 || f15007e == null) {
            return title;
        }
        ChapterList chapterList = f15007e;
        Intrinsics.checkNotNull(chapterList);
        if (chapterList.getCount() <= 0) {
            return title;
        }
        ChapterList chapterList2 = f15007e;
        if (chapterList2 != null && (item = chapterList2.getItem(c())) != null) {
            str = item.getTitle();
        }
        return str;
    }

    public final int f() {
        return f15005c;
    }

    @l
    public final Bitmap g() {
        WeakReference<Bitmap> weakReference = f15013k;
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    @l
    public final WeakReference<Bitmap> h() {
        return f15013k;
    }

    @l
    public final ChapterContent i() {
        return f15011i;
    }

    public final float j() {
        return f15014l;
    }

    @k
    public final String k() {
        if (f15008f == null || f15007e == null) {
            return "";
        }
        Book book = f15008f;
        if (!ba.l.q(book != null ? book.getStatus() : null)) {
            Book book2 = f15008f;
            String status = book2 != null ? book2.getStatus() : null;
            Intrinsics.checkNotNull(status);
            if (!StringsKt.contains$default((CharSequence) status, (CharSequence) Book.STATUS_FINISHED, false, 2, (Object) null)) {
                ChapterList chapterList = f15007e;
                return "连载至" + (chapterList != null ? Integer.valueOf(chapterList.getCount()) : null) + "章";
            }
        }
        ChapterList chapterList2 = f15007e;
        return "完结 共" + (chapterList2 != null ? Integer.valueOf(chapterList2.getCount()) : null) + "章";
    }

    public final int l() {
        if (f15006d < 0) {
            f15006d = 0;
        }
        if (f15006d < f15005c) {
            f15006d = f15005c;
        }
        return f15006d;
    }

    @l
    public final MiReadingRecord m() {
        return f15012j;
    }

    public final float n(@l Integer num) {
        float intValue = 100 * (((num != null ? num.intValue() : 5) * 0.1f) + 0.5f);
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String format = decimalFormat.format(Float.valueOf(intValue));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return Float.parseFloat(format);
    }

    public final float p(@l Integer num) {
        int intValue = num != null ? num.intValue() : 5;
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        String format = decimalFormat.format(Float.valueOf((intValue * 0.1f) + 0.5f));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return Float.parseFloat(format);
    }

    public final int r() {
        return (((int) (f15010h / 50.0f)) - 1) * 5;
    }

    public final int s() {
        return f15015m;
    }

    public final float t() {
        return f15010h;
    }

    @l
    public final Object u(@k Book book, @k String str, int i10, int i11, @k Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        MiConfigSingleton.b2().M1().m(book, 0, false, true, new b(book, str, i10, i11, safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @l
    public final Object v(int i10, @k Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            if (f15008f == null || f15007e == null) {
                Result.Companion companion = Result.INSTANCE;
                safeContinuation.resumeWith(Result.m58constructorimpl(Boxing.boxBoolean(false)));
            }
            MiConfigSingleton.b2().M1().l(f15008f, f15007e, f15003a.c(), new c(i10, safeContinuation));
        } catch (Exception unused) {
            Result.Companion companion2 = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m58constructorimpl(Boxing.boxBoolean(false)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @l
    public final Object w(@k Context context, @l String str, @k Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            FutureTarget<Bitmap> submit = Glide.with(context).asBitmap().load2(str).submit();
            Intrinsics.checkNotNullExpressionValue(submit, "submit(...)");
            f15013k = new WeakReference<>(submit.get());
            Glide.with(context).clear(submit);
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m58constructorimpl(Boxing.boxBoolean(true)));
        } catch (Exception e10) {
            e10.printStackTrace();
            Result.Companion companion2 = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m58constructorimpl(Boxing.boxBoolean(false)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void x() {
        f15007e = null;
        f15008f = null;
        f15011i = null;
        f15012j = null;
        f15014l = 0.0f;
        WeakReference<Bitmap> weakReference = f15013k;
        if (weakReference != null) {
            weakReference.clear();
        }
        f15013k = null;
    }

    public final synchronized void y() {
        Coroutine.Companion.async$default(Coroutine.INSTANCE, null, null, null, null, new ReadAloudBook$saveReadingRecord$1(this, null), 15, null);
    }

    public final void z(@l Book book) {
        f15008f = book;
    }
}
