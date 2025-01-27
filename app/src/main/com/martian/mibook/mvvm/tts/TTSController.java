package com.martian.mibook.mvvm.tts;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import com.martian.mibook.mvvm.tts.TTSController;
import com.martian.mibook.mvvm.tts.TTSController.b;
import com.martian.mibook.mvvm.tts.TtsEnginesUtil;
import hf.e;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import xi.k;
import xi.l;

@SourceDebugExtension({"SMAP\nTTSController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TTSController.kt\ncom/martian/mibook/mvvm/tts/TTSController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,376:1\n288#2,2:377\n288#2,2:379\n*S KotlinDebug\n*F\n+ 1 TTSController.kt\ncom/martian/mibook/mvvm/tts/TTSController\n*L\n124#1:377,2\n141#1:379,2\n*E\n"})
/* loaded from: classes3.dex */
public final class TTSController implements TextToSpeech.OnInitListener {

    /* renamed from: a */
    public int f15030a = -1;

    /* renamed from: b */
    @l
    public Context f15031b;

    /* renamed from: c */
    @k
    public final Locale f15032c;

    /* renamed from: d */
    @l
    public TextToSpeech f15033d;

    /* renamed from: e */
    @k
    public final Lazy f15034e;

    /* renamed from: f */
    @l
    public a f15035f;

    /* renamed from: g */
    public boolean f15036g;

    /* renamed from: h */
    @l
    public List<Integer> f15037h;

    /* renamed from: i */
    @l
    public String f15038i;

    /* renamed from: j */
    public boolean f15039j;

    /* renamed from: k */
    public int f15040k;

    /* renamed from: l */
    public int f15041l;

    /* renamed from: m */
    @l
    public TtsStatus f15042m;

    /* renamed from: n */
    @l
    public Long f15043n;

    /* renamed from: o */
    @k
    public LinkedHashSet<String> f15044o;

    /* renamed from: p */
    public boolean f15045p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/martian/mibook/mvvm/tts/TTSController$TtsStatus;", "", "(Ljava/lang/String;I)V", "SS_STOP", "SS_START", "SS_PAUSE", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TtsStatus extends Enum<TtsStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TtsStatus[] $VALUES;
        public static final TtsStatus SS_STOP = new TtsStatus("SS_STOP", 0);
        public static final TtsStatus SS_START = new TtsStatus("SS_START", 1);
        public static final TtsStatus SS_PAUSE = new TtsStatus("SS_PAUSE", 2);

        private static final /* synthetic */ TtsStatus[] $values() {
            return new TtsStatus[]{SS_STOP, SS_START, SS_PAUSE};
        }

        static {
            TtsStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private TtsStatus(String str, int i10) {
            super(str, i10);
        }

        @k
        public static EnumEntries<TtsStatus> getEntries() {
            return $ENTRIES;
        }

        public static TtsStatus valueOf(String str) {
            return (TtsStatus) Enum.valueOf(TtsStatus.class, str);
        }

        public static TtsStatus[] values() {
            return (TtsStatus[]) $VALUES.clone();
        }
    }

    public interface a {
        void a(@l String str, boolean z10);

        void b();

        void c();

        void d(boolean z10);

        void e(@l String str, int i10, int i11);
    }

    @SourceDebugExtension({"SMAP\nTTSController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TTSController.kt\ncom/martian/mibook/mvvm/tts/TTSController$TTSUtteranceListener\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,376:1\n37#2,2:377\n37#2,2:379\n*S KotlinDebug\n*F\n+ 1 TTSController.kt\ncom/martian/mibook/mvvm/tts/TTSController$TTSUtteranceListener\n*L\n318#1:377,2\n341#1:379,2\n*E\n"})
    public final class b extends UtteranceProgressListener {
        public b() {
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onDone(@l String str) {
            List<String> split;
            String[] strArr = (str == null || (split = new Regex(e.f26694a).split(str, 2)) == null) ? null : (String[]) split.toArray(new String[0]);
            if (strArr == null || strArr.length == 0) {
                return;
            }
            int parseInt = Integer.parseInt(strArr[0]);
            String str2 = TTSController.this.f15038i;
            if (str2 == null || str2.hashCode() != parseInt) {
                return;
            }
            if (TTSController.this.f15039j) {
                TTSController.this.f15039j = false;
                return;
            }
            if (TTSController.this.f15040k == TTSController.this.f15041l - 1) {
                TTSController.this.f15037h = null;
                a aVar = TTSController.this.f15035f;
                if (aVar != null) {
                    aVar.d(true);
                }
            }
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onError(@l String str) {
            a aVar = TTSController.this.f15035f;
            if (aVar != null) {
                aVar.c();
            }
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onStart(@l String str) {
            List<String> split;
            String[] strArr = (str == null || (split = new Regex(e.f26694a).split(str, 2)) == null) ? null : (String[]) split.toArray(new String[0]);
            if (strArr == null || strArr.length == 0) {
                return;
            }
            int parseInt = Integer.parseInt(strArr[0]);
            String str2 = TTSController.this.f15038i;
            if (str2 == null || str2.hashCode() != parseInt) {
                return;
            }
            if (strArr.length > 1) {
                TTSController.this.f15040k = Integer.parseInt(strArr[1]);
            }
            a aVar = TTSController.this.f15035f;
            if (aVar != null) {
                String str3 = TTSController.this.f15038i;
                List list = TTSController.this.f15037h;
                int intValue = list != null ? ((Number) list.get(TTSController.this.f15040k)).intValue() : 0;
                List list2 = TTSController.this.f15037h;
                aVar.e(str3, intValue, (list2 != null ? ((Number) list2.get(TTSController.this.f15040k + 1)).intValue() : 0) - 1);
            }
            int i10 = TTSController.this.f15040k + 1;
            if (i10 < TTSController.this.f15041l) {
                TTSController tTSController = TTSController.this;
                tTSController.G(tTSController.k(i10), i10);
            }
        }
    }

    public TTSController() {
        Locale CHINA = Locale.CHINA;
        Intrinsics.checkNotNullExpressionValue(CHINA, "CHINA");
        this.f15032c = CHINA;
        this.f15034e = LazyKt.lazy(new Function0<b>() { // from class: com.martian.mibook.mvvm.tts.TTSController$mTTSUtteranceListener$2
            public TTSController$mTTSUtteranceListener$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final TTSController.b invoke() {
                return TTSController.this.new b();
            }
        });
        this.f15044o = new LinkedHashSet<>();
        this.f15045p = true;
    }

    public static /* synthetic */ void o(TTSController tTSController, Context context, a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        tTSController.n(context, aVar);
    }

    public static /* synthetic */ void y(TTSController tTSController, Exception exc, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            exc = null;
        }
        tTSController.x(exc);
    }

    public final boolean A() {
        TtsStatus ttsStatus = this.f15042m;
        TtsStatus ttsStatus2 = TtsStatus.SS_PAUSE;
        if (ttsStatus != ttsStatus2 && t()) {
            this.f15039j = true;
            TextToSpeech textToSpeech = this.f15033d;
            if (textToSpeech != null && textToSpeech.stop() == 0) {
                this.f15042m = ttsStatus2;
                return true;
            }
        }
        return false;
    }

    public final boolean B() {
        TtsStatus ttsStatus = this.f15042m;
        return (ttsStatus == TtsStatus.SS_PAUSE || ttsStatus == TtsStatus.SS_STOP) && t() && C();
    }

    public final boolean C() {
        this.f15039j = false;
        if (!G(k(this.f15040k), this.f15040k)) {
            return false;
        }
        this.f15042m = TtsStatus.SS_START;
        return true;
    }

    public final void D(float f10) {
        TextToSpeech textToSpeech;
        if (!t() || (textToSpeech = this.f15033d) == null) {
            return;
        }
        textToSpeech.setSpeechRate(f10 / 100.0f);
    }

    public final void E() {
        TextToSpeech textToSpeech = this.f15033d;
        if (textToSpeech != null) {
            textToSpeech.setOnUtteranceProgressListener(null);
        }
        TextToSpeech textToSpeech2 = this.f15033d;
        if (textToSpeech2 != null) {
            textToSpeech2.stop();
        }
        TextToSpeech textToSpeech3 = this.f15033d;
        if (textToSpeech3 != null) {
            textToSpeech3.shutdown();
        }
        this.f15031b = null;
        this.f15033d = null;
        this.f15030a = -1;
        this.f15035f = null;
        this.f15036g = false;
        this.f15037h = null;
        this.f15038i = null;
        this.f15039j = false;
        this.f15040k = 0;
        this.f15041l = 0;
        this.f15042m = null;
    }

    public final boolean F(String str, int i10, int i11) {
        TextToSpeech textToSpeech = this.f15033d;
        if (textToSpeech == null) {
            return false;
        }
        String str2 = this.f15038i;
        int hashCode = str2 != null ? str2.hashCode() : 0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(hashCode);
        sb2.append(e.f26694a);
        sb2.append(i11);
        return textToSpeech.speak(str, i10, null, sb2.toString()) == 0;
    }

    public final boolean G(@l String str, int i10) {
        String C = ba.l.C(str);
        while (true) {
            if (C != null && C.length() != 0) {
                this.f15043n = Long.valueOf(SystemClock.elapsedRealtime());
                TextToSpeech textToSpeech = this.f15033d;
                if (textToSpeech == null) {
                    return false;
                }
                String str2 = this.f15038i;
                int hashCode = str2 != null ? str2.hashCode() : 0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(hashCode);
                sb2.append(e.f26694a);
                sb2.append(i10);
                return textToSpeech.speak(C, 1, null, sb2.toString()) == 0;
            }
            i10++;
            int i11 = this.f15041l;
            if (i10 >= i11) {
                if (this.f15039j) {
                    this.f15039j = false;
                    return true;
                }
                if (this.f15040k == i11 - 1) {
                    this.f15037h = null;
                    a aVar = this.f15035f;
                    if (aVar != null) {
                        aVar.d(true);
                    }
                }
                return true;
            }
            C = ba.l.C(k(i10));
        }
    }

    public final void H(@l String str, int i10, @k UtteranceProgressListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        TextToSpeech textToSpeech = this.f15033d;
        if (textToSpeech != null) {
            textToSpeech.setOnUtteranceProgressListener(listener);
        }
        this.f15045p = false;
        TextToSpeech textToSpeech2 = this.f15033d;
        if (textToSpeech2 != null) {
            String str2 = this.f15038i;
            textToSpeech2.speak(str, 1, null, (str2 != null ? str2.hashCode() : 0) + e.f26694a + i10);
        }
    }

    public final boolean I(@l String str, int i10, boolean z10) {
        TextToSpeech textToSpeech;
        if (!t()) {
            return false;
        }
        if (!this.f15045p && (textToSpeech = this.f15033d) != null) {
            textToSpeech.setOnUtteranceProgressListener(m());
        }
        this.f15038i = str;
        if (ba.l.q(str)) {
            a aVar = this.f15035f;
            if (aVar != null) {
                aVar.d(z10);
            }
            return false;
        }
        List<Integer> w10 = ba.l.w(str, i10);
        this.f15037h = w10;
        this.f15041l = w10 != null ? w10.size() - 1 : 0;
        this.f15040k = 0;
        C();
        return true;
    }

    public final boolean J() {
        TtsStatus ttsStatus = this.f15042m;
        TtsStatus ttsStatus2 = TtsStatus.SS_STOP;
        if (ttsStatus != ttsStatus2 && t()) {
            this.f15040k = 0;
            this.f15039j = true;
            TextToSpeech textToSpeech = this.f15033d;
            if (textToSpeech != null && textToSpeech.stop() == 0) {
                this.f15042m = ttsStatus2;
                return true;
            }
        }
        return false;
    }

    public final String k(int i10) {
        int i11;
        Integer num;
        List<Integer> list = this.f15037h;
        if (list != null && i10 >= 0 && (i11 = i10 + 1) < list.size() && (num = (Integer) CollectionsKt.getOrNull(list, i10)) != null) {
            int intValue = num.intValue();
            Integer num2 = (Integer) CollectionsKt.getOrNull(list, i11);
            if (num2 != null) {
                int intValue2 = num2.intValue();
                String str = this.f15038i;
                if (str != null && intValue >= 0 && intValue2 <= str.length() && intValue <= intValue2) {
                    String substring = str.substring(intValue, intValue2);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    return substring;
                }
            }
        }
        return null;
    }

    @l
    public final Long l() {
        return this.f15043n;
    }

    public final b m() {
        return (b) this.f15034e.getValue();
    }

    public final void n(@k Context context, @l a aVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (this.f15033d != null) {
                E();
            }
            this.f15031b = context.getApplicationContext();
            this.f15035f = aVar;
            r();
        } catch (Exception e10) {
            x(e10);
        }
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public void onInit(int i10) {
        this.f15030a = i10;
        if (!t()) {
            y(this, null, 1, null);
            return;
        }
        if (this.f15036g) {
            return;
        }
        TextToSpeech textToSpeech = this.f15033d;
        Integer valueOf = textToSpeech != null ? Integer.valueOf(textToSpeech.setLanguage(this.f15032c)) : null;
        if ((valueOf != null && valueOf.intValue() == -1) || (valueOf != null && valueOf.intValue() == -2)) {
            String str = (String) CollectionsKt.last(this.f15044o);
            TextToSpeech textToSpeech2 = this.f15033d;
            w(str, textToSpeech2 != null ? textToSpeech2.getEngines() : null);
            return;
        }
        Context context = this.f15031b;
        if (context != null) {
            if (Intrinsics.areEqual(CollectionsKt.last(this.f15044o), TtsEnginesUtil.f15064c)) {
                TtsEnginesUtil.k(context, TtsEnginesUtil.EngineMode.GOOGLE);
                ac.a.W(context, "Google初始化成功");
            } else {
                TtsEnginesUtil.k(context, TtsEnginesUtil.EngineMode.SYSTEM);
                ac.a.W(context, "非Google初始化成功");
            }
        }
        z();
    }

    public final void p() {
        Context context = this.f15031b;
        if (context == null) {
            return;
        }
        this.f15044o.add(TtsEnginesUtil.f15064c);
        this.f15033d = new TextToSpeech(context, this, TtsEnginesUtil.f15064c);
    }

    public final void q() {
        Context context = this.f15031b;
        if (context == null) {
            return;
        }
        String a10 = TtsEnginesUtil.a(context);
        if (a10 != null) {
            this.f15044o.add(a10);
        }
        this.f15033d = new TextToSpeech(context, this);
    }

    public final void r() {
        Context context = this.f15031b;
        if (context == null) {
            return;
        }
        if (TtsEnginesUtil.d(context) == TtsEnginesUtil.EngineMode.GOOGLE) {
            p();
        } else {
            q();
        }
    }

    public final boolean s() {
        return this.f15030a == -1 || this.f15033d == null;
    }

    public final boolean t() {
        return this.f15030a == 0 && this.f15033d != null;
    }

    public final boolean u() {
        TextToSpeech textToSpeech;
        return t() && (textToSpeech = this.f15033d) != null && textToSpeech.isSpeaking();
    }

    public final boolean v() {
        return this.f15042m == TtsStatus.SS_START;
    }

    public final void w(String str, List<? extends TextToSpeech.EngineInfo> list) {
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!this.f15044o.contains(((TextToSpeech.EngineInfo) next).name)) {
                    obj = next;
                    break;
                }
            }
            obj = (TextToSpeech.EngineInfo) obj;
        }
        a aVar = this.f15035f;
        if (aVar != null) {
            aVar.a(str, obj != null);
        }
        E();
    }

    public final void x(Exception exc) {
        this.f15036g = false;
        Context context = this.f15031b;
        if (context == null) {
            return;
        }
        List<ResolveInfo> b10 = TtsEnginesUtil.f15062a.b(context);
        String str = (String) CollectionsKt.lastOrNull(this.f15044o);
        Object obj = null;
        if (b10 != null) {
            Iterator<T> it = b10.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!this.f15044o.contains(((ResolveInfo) next).serviceInfo.packageName)) {
                    obj = next;
                    break;
                }
            }
            obj = (ResolveInfo) obj;
        }
        a aVar = this.f15035f;
        if (aVar != null) {
            aVar.a(str, obj != null);
        }
        String str2 = obj == null ? "没有" : "有";
        if (Intrinsics.areEqual(str, TtsEnginesUtil.f15064c)) {
            ac.a.W(context, "Google初始化失败-" + str2 + "更多引擎");
        } else {
            ac.a.W(context, "非Google初始化失败-" + str2 + "更多引擎");
        }
        E();
    }

    public final void z() {
        this.f15036g = true;
        TextToSpeech textToSpeech = this.f15033d;
        if (textToSpeech != null) {
            textToSpeech.setOnUtteranceProgressListener(m());
        }
        this.f15045p = true;
        a aVar = this.f15035f;
        if (aVar != null) {
            aVar.b();
        }
    }
}
