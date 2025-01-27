package id;

import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRouter;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import androidx.media.AudioAttributesCompat;
import androidx.media.AudioFocusRequestCompat;
import androidx.media.AudioManagerCompat;
import com.martian.mibook.R;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@SourceDebugExtension({"SMAP\nMediaHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaHelper.kt\ncom/martian/mibook/mvvm/tts/MediaHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1#2:97\n*E\n"})
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a */
    @k
    public static final b f26962a = new b();

    /* renamed from: b */
    public static final long f26963b = 3670015;

    public static final void i(MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2) {
        mediaPlayer.release();
    }

    @k
    public final AudioFocusRequestCompat b(@k AudioManager.OnAudioFocusChangeListener audioFocusChangeListener) {
        Intrinsics.checkNotNullParameter(audioFocusChangeListener, "audioFocusChangeListener");
        AudioFocusRequestCompat build = new AudioFocusRequestCompat.Builder(1).setAudioAttributes(new AudioAttributesCompat.Builder().setUsage(1).setContentType(2).build()).setOnAudioFocusChangeListener(audioFocusChangeListener).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    @l
    public final AudioManager c(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("audio");
        if (systemService instanceof AudioManager) {
            return (AudioManager) systemService;
        }
        return null;
    }

    @l
    public final MediaRouter d(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("media_router");
        if (systemService instanceof MediaRouter) {
            return (MediaRouter) systemService;
        }
        return null;
    }

    @l
    public final NotificationManager e(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("notification");
        if (systemService instanceof NotificationManager) {
            return (NotificationManager) systemService;
        }
        return null;
    }

    @l
    public final PowerManager f(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("power");
        if (systemService instanceof PowerManager) {
            return (PowerManager) systemService;
        }
        return null;
    }

    @l
    public final WifiManager g(@k Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        if (systemService instanceof WifiManager) {
            return (WifiManager) systemService;
        }
        return null;
    }

    public final void h(@k Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        try {
            Result.Companion companion = Result.INSTANCE;
            MediaPlayer create = MediaPlayer.create(mContext, R.raw.silent_sound);
            create.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: id.a

                /* renamed from: b */
                public final /* synthetic */ MediaPlayer f26961b;

                public /* synthetic */ a(MediaPlayer create2) {
                    create = create2;
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    b.i(create, mediaPlayer);
                }
            });
            create2.start();
            Result.m58constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m58constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public final boolean j(@l AudioManager audioManager, @k AudioFocusRequestCompat focusRequest) {
        Intrinsics.checkNotNullParameter(focusRequest, "focusRequest");
        Integer valueOf = audioManager != null ? Integer.valueOf(AudioManagerCompat.requestAudioFocus(audioManager, focusRequest)) : null;
        return valueOf != null && valueOf.intValue() == 1;
    }
}
