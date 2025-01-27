package com.martian.mibook.mvvm.tts;

import ac.a;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.provider.Settings;
import ba.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import l9.p0;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class TtsEnginesUtil {

    /* renamed from: a */
    @k
    public static final TtsEnginesUtil f15062a = new TtsEnginesUtil();

    /* renamed from: b */
    @k
    public static final String f15063b = "engine_mode";

    /* renamed from: c */
    @k
    public static final String f15064c = "com.google.android.tts";

    /* renamed from: d */
    public static boolean f15065d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/martian/mibook/mvvm/tts/TtsEnginesUtil$EngineMode;", "", "modeValue", "", "(Ljava/lang/String;II)V", "getValue", "SYSTEM", "GOOGLE", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EngineMode extends Enum<EngineMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EngineMode[] $VALUES;
        private final int modeValue;
        public static final EngineMode SYSTEM = new EngineMode("SYSTEM", 0, 0);
        public static final EngineMode GOOGLE = new EngineMode("GOOGLE", 1, 1);

        private static final /* synthetic */ EngineMode[] $values() {
            return new EngineMode[]{SYSTEM, GOOGLE};
        }

        static {
            EngineMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private EngineMode(String str, int i10, int i11) {
            super(str, i10);
            this.modeValue = i11;
        }

        @k
        public static EnumEntries<EngineMode> getEntries() {
            return $ENTRIES;
        }

        public static EngineMode valueOf(String str) {
            return (EngineMode) Enum.valueOf(EngineMode.class, str);
        }

        public static EngineMode[] values() {
            return (EngineMode[]) $VALUES.clone();
        }

        /* renamed from: getValue, reason: from getter */
        public final int getModeValue() {
            return this.modeValue;
        }
    }

    @JvmStatic
    @l
    public static final String a(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = Settings.Secure.getString(context.getContentResolver(), "tts_default_synth");
        return g(context, string) ? string : f15062a.c(context);
    }

    @JvmStatic
    @k
    public static final EngineMode d(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        EngineMode engineMode = EngineMode.SYSTEM;
        int f10 = j.f(context, f15063b, engineMode.getModeValue());
        EngineMode engineMode2 = EngineMode.GOOGLE;
        if (f10 == engineMode2.getModeValue() && !i(context)) {
            f10 = engineMode.getModeValue();
            a.W(context, "Google模式失效");
            k(context, engineMode);
        }
        return f10 == engineMode2.getModeValue() ? engineMode2 : engineMode;
    }

    @JvmStatic
    public static final boolean f(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Intrinsics.areEqual(f15064c, a(context));
    }

    @JvmStatic
    public static final boolean g(@k Context context, @l String str) {
        PackageManager packageManager;
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null || str.length() == 0 || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.TTS_SERVICE");
        intent.setPackage(str);
        try {
            Intrinsics.checkNotNullExpressionValue(packageManager.queryIntentServices(intent, 65536), "queryIntentServices(...)");
            return !r3.isEmpty();
        } catch (Exception e10) {
            p0.b(e10.getMessage());
            return false;
        }
    }

    @JvmStatic
    public static final boolean i(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return g(context, f15064c);
    }

    @JvmStatic
    public static final void k(@k Context context, @k EngineMode engineMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(engineMode, "engineMode");
        j.m(context, f15063b, engineMode.getModeValue());
    }

    @JvmStatic
    public static final boolean l(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (!g(context, f15064c)) {
                return false;
            }
            Intent intent = new Intent();
            intent.setClassName(f15064c, "com.google.android.apps.speech.tts.googletts.local.voicepack.ui.VoiceDataInstallActivity");
            intent.setAction("android.speech.tts.engine.CHECK_TTS_DATA");
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    public static final boolean m(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent("com.android.settings.TTS_SETTINGS");
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @l
    public final List<ResolveInfo> b(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            return packageManager.queryIntentServices(new Intent("android.intent.action.TTS_SERVICE"), 65536);
        } catch (Exception e10) {
            p0.b(e10.getMessage());
            return null;
        }
    }

    public final String c(Context context) {
        List<ResolveInfo> b10 = b(context);
        List<ResolveInfo> list = b10;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return b10.get(0).serviceInfo.packageName;
    }

    public final boolean e(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return d(context) == EngineMode.GOOGLE;
    }

    public final boolean h() {
        return f15065d;
    }

    public final void j(boolean z10) {
        f15065d = z10;
    }
}
