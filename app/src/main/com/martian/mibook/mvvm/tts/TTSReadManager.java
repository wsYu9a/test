package com.martian.mibook.mvvm.tts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import com.martian.mibook.mvvm.tts.service.BaseReadAloudService;
import com.martian.mibook.mvvm.tts.service.TTSReadAloudService;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import id.c;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import xc.a;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class TTSReadManager {

    /* renamed from: a */
    @k
    public static final TTSReadManager f15059a = new TTSReadManager();

    /* renamed from: b */
    @k
    public static Class<? extends BaseReadAloudService> f15060b = o();

    /* renamed from: c */
    @l
    public static Long f15061c = -1L;

    @JvmStatic
    public static final void A(@k Observer<? super ReadAloudBook.a> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        BaseReadAloudService.INSTANCE.d().removeObserver(observer);
    }

    @JvmStatic
    public static final void B() {
        f15061c = Long.valueOf(a.f31995a.a() + 60000);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a A[Catch: all -> 0x0011, TryCatch #0 {all -> 0x0011, blocks: (B:4:0x0003, B:6:0x000a, B:9:0x0014, B:11:0x001a, B:15:0x001f, B:17:0x0025, B:19:0x003c), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f A[Catch: all -> 0x0011, TryCatch #0 {all -> 0x0011, blocks: (B:4:0x0003, B:6:0x000a, B:9:0x0014, B:11:0x001a, B:15:0x001f, B:17:0x0025, B:19:0x003c), top: B:3:0x0003 }] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final synchronized void C(@xi.k android.app.Activity r2, @xi.l com.martian.mibook.lib.model.data.abs.Book r3, @xi.l java.lang.String r4, @xi.l kotlin.jvm.functions.Function0<kotlin.Unit> r5) {
        /*
            java.lang.Class<com.martian.mibook.mvvm.tts.TTSReadManager> r0 = com.martian.mibook.mvvm.tts.TTSReadManager.class
            monitor-enter(r0)
            java.lang.String r1 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)     // Catch: java.lang.Throwable -> L11
            if (r3 == 0) goto L13
            java.lang.String r1 = r3.getSourceString()     // Catch: java.lang.Throwable -> L11
            if (r1 != 0) goto L14
            goto L13
        L11:
            r2 = move-exception
            goto L41
        L13:
            r1 = r4
        L14:
            boolean r1 = r(r1)     // Catch: java.lang.Throwable -> L11
            if (r1 == 0) goto L1f
            r2 = 0
            kc.b.e(r3, r2, r2, r2, r4)     // Catch: java.lang.Throwable -> L11
            goto L3f
        L1f:
            boolean r3 = q()     // Catch: java.lang.Throwable -> L11
            if (r3 == 0) goto L3a
            int r3 = com.martian.mibook.R.string.confirm_message     // Catch: java.lang.Throwable -> L11
            java.lang.String r3 = r2.getString(r3)     // Catch: java.lang.Throwable -> L11
            int r4 = com.martian.mibook.R.string.tts_another     // Catch: java.lang.Throwable -> L11
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L11
            id.j r1 = new id.j     // Catch: java.lang.Throwable -> L11
            r1.<init>()     // Catch: java.lang.Throwable -> L11
            l9.i0.z0(r2, r3, r4, r1)     // Catch: java.lang.Throwable -> L11
            goto L3f
        L3a:
            if (r5 == 0) goto L3f
            r5.invoke()     // Catch: java.lang.Throwable -> L11
        L3f:
            monitor-exit(r0)
            return
        L41:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.tts.TTSReadManager.C(android.app.Activity, com.martian.mibook.lib.model.data.abs.Book, java.lang.String, kotlin.jvm.functions.Function0):void");
    }

    public static /* synthetic */ void D(Activity activity, Book book, String str, Function0 function0, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str = null;
        }
        if ((i10 & 8) != 0) {
            function0 = null;
        }
        C(activity, book, str, function0);
    }

    public static final void E(Activity activity, Function0 function0) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Coroutine.Companion.async$default(Coroutine.INSTANCE, null, null, null, null, new TTSReadManager$startTtsReading$1$1(activity, function0, null), 15, null);
    }

    @JvmStatic
    public static final boolean b() {
        if (MiConfigSingleton.b2().C2() || MiConfigSingleton.b2().K2()) {
            return false;
        }
        TtsTimeController ttsTimeController = TtsTimeController.f15066a;
        if (ttsTimeController.e() <= 0 || ttsTimeController.n() <= 0) {
            return false;
        }
        Long l10 = f15061c;
        Intrinsics.checkNotNull(l10);
        if (l10.longValue() >= 0) {
            long a10 = a.f31995a.a();
            Long l11 = f15061c;
            Intrinsics.checkNotNull(l11);
            if (a10 <= l11.longValue()) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final synchronized void c(@k Context context) {
        synchronized (TTSReadManager.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, f15060b);
            intent.setAction(c.f26970g);
            ContextCompat.startForegroundService(context, intent);
        }
    }

    @JvmStatic
    public static final synchronized void d(@k Context context) {
        synchronized (TTSReadManager.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (BaseReadAloudService.INSTANCE.m()) {
                Intent intent = new Intent(context, f15060b);
                intent.setAction("pause");
                ContextCompat.startForegroundService(context, intent);
            }
        }
    }

    @JvmStatic
    public static final synchronized void e(@k Context context) {
        synchronized (TTSReadManager.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, f15060b);
            intent.setAction("play");
            ReadAloudBook.f15003a.K(ReadingInstance.z().H(context));
            ContextCompat.startForegroundService(context, intent);
        }
    }

    @JvmStatic
    public static final synchronized void f(@k Context context, int i10, int i11) {
        synchronized (TTSReadManager.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, f15060b);
            intent.setAction(c.f26972i);
            intent.putExtra(BaseReadAloudService.f15168x, i10);
            intent.putExtra(BaseReadAloudService.f15169y, i11);
            ContextCompat.startForegroundService(context, intent);
        }
    }

    @JvmStatic
    public static final synchronized void g(@k Context context) {
        synchronized (TTSReadManager.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, f15060b);
            intent.setAction(c.f26969f);
            ContextCompat.startForegroundService(context, intent);
        }
    }

    @JvmStatic
    public static final synchronized void h(@k Context context) {
        synchronized (TTSReadManager.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (BaseReadAloudService.INSTANCE.m()) {
                Intent intent = new Intent(context, f15060b);
                intent.setAction(c.f26967d);
                ContextCompat.startForegroundService(context, intent);
            }
        }
    }

    @JvmStatic
    public static final synchronized void i(@k Context context) {
        synchronized (TTSReadManager.class) {
            try {
                Intrinsics.checkNotNullParameter(context, "context");
                if (BaseReadAloudService.INSTANCE.l()) {
                    d(context);
                } else {
                    h(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @JvmStatic
    public static final synchronized void j(@k Context context, float f10) {
        synchronized (TTSReadManager.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, f15060b);
            intent.setAction(c.f26973j);
            ReadAloudBook.f15003a.K(f10);
            ContextCompat.startForegroundService(context, intent);
        }
    }

    @JvmStatic
    public static final void k(@k Context context, @k String bookSource, int i10, int i11) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bookSource, "bookSource");
        Coroutine.onFinally$default(Coroutine.Companion.async$default(Coroutine.INSTANCE, null, null, null, null, new TTSReadManager$doStartService$1(context, bookSource, i10, i11, null), 15, null), null, new TTSReadManager$doStartService$2(context, null), 1, null);
    }

    @JvmStatic
    public static final synchronized void l(@k Context context) {
        synchronized (TTSReadManager.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (BaseReadAloudService.INSTANCE.m()) {
                Intent intent = new Intent(context, f15060b);
                intent.setAction(c.f26966c);
                ContextCompat.startForegroundService(context, intent);
            }
        }
    }

    @JvmStatic
    public static final synchronized void m(@k Context context, long j10) {
        synchronized (TTSReadManager.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, f15060b);
            intent.setAction(c.f26971h);
            intent.putExtra(BaseReadAloudService.f15170z, j10);
            ContextCompat.startForegroundService(context, intent);
        }
    }

    @JvmStatic
    @k
    public static final Class<? extends BaseReadAloudService> o() {
        return TTSReadAloudService.class;
    }

    @JvmStatic
    public static final boolean p() {
        return BaseReadAloudService.INSTANCE.l();
    }

    @JvmStatic
    public static final boolean q() {
        return BaseReadAloudService.INSTANCE.m() && !TextUtils.isEmpty(ReadAloudBook.f15003a.b());
    }

    @JvmStatic
    public static final boolean r(@l String str) {
        if (BaseReadAloudService.INSTANCE.m()) {
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            if (!TextUtils.isEmpty(readAloudBook.b()) && !TextUtils.isEmpty(str) && StringsKt.equals(readAloudBook.b(), str, true)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final void s(@k LifecycleOwner owner, @k Observer<Long> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        BaseReadAloudService.Companion companion = BaseReadAloudService.INSTANCE;
        if (companion.c().a(owner)) {
            return;
        }
        companion.c().observe(owner, observer);
    }

    @JvmStatic
    public static final void t(@k Observer<ReadAloudBook.ReadAloudPlayerStatus> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        BaseReadAloudService.INSTANCE.g().observeForever(observer);
    }

    @JvmStatic
    public static final void u(@k Observer<ReadAloudBook.a> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        BaseReadAloudService.INSTANCE.d().observeForever(observer);
    }

    @JvmStatic
    public static final void v(@k LifecycleOwner owner, @k Observer<ReadAloudBook.ReadAloudPlayerStatus> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        BaseReadAloudService.INSTANCE.g().observe(owner, observer);
    }

    @JvmStatic
    public static final void w(@k LifecycleOwner owner, @k Observer<ReadAloudBook.a> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        BaseReadAloudService.INSTANCE.d().observe(owner, observer);
    }

    @JvmStatic
    public static final void x(@k LifecycleOwner owner, @k Observer<Boolean> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        BaseReadAloudService.Companion companion = BaseReadAloudService.INSTANCE;
        if (companion.h().a(owner)) {
            return;
        }
        companion.h().observe(owner, observer);
    }

    @JvmStatic
    public static final void y(@k LifecycleOwner owner, @k Observer<Long> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        BaseReadAloudService.INSTANCE.i().observe(owner, observer);
    }

    @JvmStatic
    public static final void z(@k Observer<? super ReadAloudBook.ReadAloudPlayerStatus> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        BaseReadAloudService.Companion companion = BaseReadAloudService.INSTANCE;
        companion.g().setValue(ReadAloudBook.ReadAloudPlayerStatus.STATE_NONE);
        companion.g().removeObserver(observer);
    }

    public final long n() {
        return BaseReadAloudService.INSTANCE.a();
    }
}
