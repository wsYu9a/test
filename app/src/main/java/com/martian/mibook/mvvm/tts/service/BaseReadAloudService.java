package com.martian.mibook.mvvm.tts.service;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.service.notification.StatusBarNotification;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.widget.RemoteViews;
import androidx.annotation.CallSuper;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.media.AudioFocusRequestCompat;
import androidx.media.AudioManagerCompat;
import ba.m;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.NotificationTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.base.BaseService;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import com.martian.mibook.mvvm.tts.ServiceLiveData;
import com.martian.mibook.mvvm.tts.receiver.MediaButtonReceiver;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import com.umeng.analytics.pro.bt;
import id.b;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import q.a0;
import q.z;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000×\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001|\b&\u0018\u0000 \u009a\u00012\u00020\u00012\u00020\u0002:\u0002\u009b\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\nH\u0017¢\u0006\u0004\b#\u0010\u0004J)\u0010(\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000eH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\nH\u0016¢\u0006\u0004\b*\u0010\u0004J\u000f\u0010+\u001a\u00020\nH\u0017¢\u0006\u0004\b+\u0010\u0004J\u0017\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00101\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\nH\u0017¢\u0006\u0004\b3\u0010\u0004J\u000f\u00104\u001a\u00020\nH\u0017¢\u0006\u0004\b4\u0010\u0004J\u0019\u00106\u001a\u00020\n2\b\b\u0002\u00105\u001a\u00020\u0005H\u0017¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\nH\u0017¢\u0006\u0004\b8\u0010\u0004J\u0017\u0010;\u001a\u00020\n2\u0006\u0010:\u001a\u000209H\u0017¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\nH\u0017¢\u0006\u0004\b=\u0010\u0004J\u000f\u0010>\u001a\u00020\nH\u0017¢\u0006\u0004\b>\u0010\u0004J\u0017\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u000eH\u0016¢\u0006\u0004\b@\u0010\u0011J\r\u0010A\u001a\u00020\u0005¢\u0006\u0004\bA\u0010\u0007J\u0011\u0010C\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0004\bC\u0010DJ\u0011\u0010E\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0004\bE\u0010DJ\u000f\u0010F\u001a\u00020\u0005H&¢\u0006\u0004\bF\u0010\u0007J\u0011\u0010H\u001a\u0004\u0018\u00010GH&¢\u0006\u0004\bH\u0010IJ\u0019\u0010K\u001a\u0004\u0018\u00010G2\u0006\u0010J\u001a\u00020BH&¢\u0006\u0004\bK\u0010LJ\u0019\u0010N\u001a\u00020\n2\b\b\u0002\u0010M\u001a\u00020\u0005H&¢\u0006\u0004\bN\u00107J\u001f\u0010Q\u001a\u00020\n2\u0006\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\u000eH&¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\nH&¢\u0006\u0004\bS\u0010\u0004R\u0014\u0010U\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\bT\u00101R\u0016\u0010V\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u00101R\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u001b\u0010`\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u001d\u0010e\u001a\u0004\u0018\u00010a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010]\u001a\u0004\bc\u0010dR!\u0010k\u001a\b\u0018\u00010fR\u00020g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010]\u001a\u0004\bi\u0010jR!\u0010q\u001a\b\u0018\u00010lR\u00020m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010]\u001a\u0004\bo\u0010pR\u001d\u0010v\u001a\u0004\u0018\u00010r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010]\u001a\u0004\bt\u0010uR\u001d\u0010{\u001a\u0004\u0018\u00010w8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010]\u001a\u0004\by\u0010zR\u0014\u0010\u007f\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\"\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0080\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0081\u0001\u0010]\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\"\u0010\u0088\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001b\u0010\u0093\u0001\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u0099\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001¨\u0006\u009c\u0001"}, d2 = {"Lcom/martian/mibook/mvvm/tts/service/BaseReadAloudService;", "Lcom/martian/mibook/mvvm/base/BaseService;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "<init>", "()V", "", "y", "()Z", "Q", ExifInterface.GPS_DIRECTION_TRUE, "", bt.aJ, "P", "O", "", "state", "q0", "(I)V", bq.f10843g, "c", "k0", "r0", "Landroid/widget/RemoteViews;", "K", "()Landroid/widget/RemoteViews;", "remoteView", "Landroid/app/Notification;", "notification", "f0", "(Landroid/widget/RemoteViews;Landroid/app/Notification;)V", "x", "()Landroid/app/Notification;", "Lcom/bumptech/glide/request/target/NotificationTarget;", "G", "(Landroid/widget/RemoteViews;Landroid/app/Notification;)Lcom/bumptech/glide/request/target/NotificationTarget;", "onCreate", "Landroid/content/Intent;", "intent", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "l0", "onDestroy", "Lcom/martian/mibook/mvvm/tts/ReadAloudBook$ReadAloudPlayerStatus;", "status", "a0", "(Lcom/martian/mibook/mvvm/tts/ReadAloudBook$ReadAloudPlayerStatus;)V", "speakTitle", "Z", "(Ljava/lang/Boolean;)V", "Y", "X", "abandonFocus", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Z)V", "d0", "", "second", "g0", "(J)V", "i0", "j0", "focusChange", "onAudioFocusChange", "c0", "", "I", "()Ljava/lang/String;", "J", "R", "Landroid/app/PendingIntent;", IAdInterListener.AdReqParam.WIDTH, "()Landroid/app/PendingIntent;", "actionStr", "b0", "(Ljava/lang/String;)Landroid/app/PendingIntent;", "reset", "m0", "mChapterIndex", "mContentPos", "U", "(II)V", "o0", "b", "useWakeLock", "needResumeOnAudioFocusGain", "Landroid/support/v4/media/session/MediaSessionCompat;", "d", "Landroid/support/v4/media/session/MediaSessionCompat;", "mediaSessionCompat", "Landroidx/media/AudioFocusRequestCompat;", e.TAG, "Lkotlin/Lazy;", "D", "()Landroidx/media/AudioFocusRequestCompat;", "mFocusRequest", "Landroid/media/AudioManager;", "f", "C", "()Landroid/media/AudioManager;", "audioManager", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "g", "M", "()Landroid/os/PowerManager$WakeLock;", "wakeLock", "Landroid/net/wifi/WifiManager$WifiLock;", "Landroid/net/wifi/WifiManager;", "h", "N", "()Landroid/net/wifi/WifiManager$WifiLock;", "wifiLock", "Landroid/app/NotificationManager;", "i", "F", "()Landroid/app/NotificationManager;", "notificationManager", "Landroid/media/MediaRouter;", "j", ExifInterface.LONGITUDE_EAST, "()Landroid/media/MediaRouter;", "mediaRouter", "com/martian/mibook/mvvm/tts/service/BaseReadAloudService$broadcastReceiver$1", "k", "Lcom/martian/mibook/mvvm/tts/service/BaseReadAloudService$broadcastReceiver$1;", "broadcastReceiver", "Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", t.f11204d, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/martian/mibook/mvvm/ui/viewmodel/AppViewModel;", "appViewModel", "Ljava/lang/ref/WeakReference;", "m", "Ljava/lang/ref/WeakReference;", "remoteViewWeakReference", "Lkotlinx/coroutines/Job;", "n", "Lkotlinx/coroutines/Job;", "dsJob", "Landroid/os/Handler;", "o", "Landroid/os/Handler;", "mHandler", "p", "Lcom/bumptech/glide/request/target/NotificationTarget;", "notificationTarget", "q", "Landroid/app/Notification;", "Landroid/media/MediaRouter$Callback;", t.f11211k, "Landroid/media/MediaRouter$Callback;", "mediaRouterCallback", "s", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBaseReadAloudService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseReadAloudService.kt\ncom/martian/mibook/mvvm/tts/service/BaseReadAloudService\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,777:1\n12474#2,2:778\n*S KotlinDebug\n*F\n+ 1 BaseReadAloudService.kt\ncom/martian/mibook/mvvm/tts/service/BaseReadAloudService\n*L\n231#1:778,2\n*E\n"})
/* loaded from: classes3.dex */
public abstract class BaseReadAloudService extends BaseService implements AudioManager.OnAudioFocusChangeListener {
    public static boolean A = false;
    public static long C = 0;
    public static long D = 0;

    @k
    public static final ServiceLiveData<ReadAloudBook.ReadAloudPlayerStatus> E;

    @k
    public static final ServiceLiveData<ReadAloudBook.ReadAloudPlayerStatus> F;

    @k
    public static final ServiceLiveData<Boolean> G;

    @k
    public static final ServiceLiveData<Boolean> H;

    @k
    public static final ServiceLiveData<Long> I;

    @k
    public static final ServiceLiveData<Long> J;

    @k
    public static final NonStickyLiveData<Long> K;

    @k
    public static final NonStickyLiveData<Long> L;

    @k
    public static final NonStickyLiveData<ReadAloudBook.a> M;

    @k
    public static final NonStickyLiveData<ReadAloudBook.a> N;

    /* renamed from: t */
    @k
    public static final String f15164t = "channel_read_aloud";

    /* renamed from: u */
    @k
    public static final String f15165u = "听书音频";

    /* renamed from: v */
    @k
    public static final String f15166v = "在通知栏显示听书音频播放控件";

    /* renamed from: w */
    public static final int f15167w = 1000001;

    /* renamed from: x */
    @k
    public static final String f15168x = "chapterIndex";

    /* renamed from: y */
    @k
    public static final String f15169y = "contentPos";

    /* renamed from: z */
    @k
    public static final String f15170z = "timerSecond";

    /* renamed from: c, reason: from kotlin metadata */
    public boolean needResumeOnAudioFocusGain;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public MediaSessionCompat mediaSessionCompat;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public WeakReference<RemoteViews> remoteViewWeakReference;

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public Job dsJob;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public Handler mHandler;

    /* renamed from: p, reason: from kotlin metadata */
    @l
    public NotificationTarget notificationTarget;

    /* renamed from: q, reason: from kotlin metadata */
    @l
    public Notification notification;

    /* renamed from: s, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);
    public static boolean B = true;

    /* renamed from: b, reason: from kotlin metadata */
    public final boolean useWakeLock = true;

    /* renamed from: e */
    @k
    public final Lazy mFocusRequest = LazyKt.lazy(new Function0<AudioFocusRequestCompat>() { // from class: com.martian.mibook.mvvm.tts.service.BaseReadAloudService$mFocusRequest$2
        public BaseReadAloudService$mFocusRequest$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final AudioFocusRequestCompat invoke() {
            return b.f26962a.b(BaseReadAloudService.this);
        }
    });

    /* renamed from: f, reason: from kotlin metadata */
    @k
    public final Lazy audioManager = LazyKt.lazy(new Function0<AudioManager>() { // from class: com.martian.mibook.mvvm.tts.service.BaseReadAloudService$audioManager$2
        public BaseReadAloudService$audioManager$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AudioManager invoke() {
            return b.f26962a.c(BaseReadAloudService.this);
        }
    });

    /* renamed from: g, reason: from kotlin metadata */
    @k
    public final Lazy wakeLock = LazyKt.lazy(new Function0<PowerManager.WakeLock>() { // from class: com.martian.mibook.mvvm.tts.service.BaseReadAloudService$wakeLock$2
        public BaseReadAloudService$wakeLock$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final PowerManager.WakeLock invoke() {
            PowerManager.WakeLock newWakeLock;
            PowerManager f10 = b.f26962a.f(BaseReadAloudService.this);
            if (f10 == null || (newWakeLock = f10.newWakeLock(1, "readAloud:ReadAloudService")) == null) {
                return null;
            }
            newWakeLock.setReferenceCounted(false);
            return newWakeLock;
        }
    });

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final Lazy wifiLock = LazyKt.lazy(new Function0<WifiManager.WifiLock>() { // from class: com.martian.mibook.mvvm.tts.service.BaseReadAloudService$wifiLock$2
        public BaseReadAloudService$wifiLock$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final WifiManager.WifiLock invoke() {
            WifiManager.WifiLock createWifiLock;
            WifiManager g10 = b.f26962a.g(BaseReadAloudService.this);
            if (g10 == null || (createWifiLock = g10.createWifiLock(3, "readAloud:AudioPlayService")) == null) {
                return null;
            }
            createWifiLock.setReferenceCounted(false);
            return createWifiLock;
        }
    });

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final Lazy notificationManager = LazyKt.lazy(new Function0<NotificationManager>() { // from class: com.martian.mibook.mvvm.tts.service.BaseReadAloudService$notificationManager$2
        public BaseReadAloudService$notificationManager$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final NotificationManager invoke() {
            return b.f26962a.e(BaseReadAloudService.this);
        }
    });

    /* renamed from: j, reason: from kotlin metadata */
    @k
    public final Lazy mediaRouter = LazyKt.lazy(new Function0<MediaRouter>() { // from class: com.martian.mibook.mvvm.tts.service.BaseReadAloudService$mediaRouter$2
        public BaseReadAloudService$mediaRouter$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final MediaRouter invoke() {
            return b.f26962a.d(BaseReadAloudService.this);
        }
    });

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final BaseReadAloudService$broadcastReceiver$1 broadcastReceiver = new BroadcastReceiver() { // from class: com.martian.mibook.mvvm.tts.service.BaseReadAloudService$broadcastReceiver$1
        public BaseReadAloudService$broadcastReceiver$1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@k Context r32, @k Intent intent) {
            Intrinsics.checkNotNullParameter(r32, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual("android.media.AUDIO_BECOMING_NOISY", intent.getAction())) {
                BaseReadAloudService.W(BaseReadAloudService.this, false, 1, null);
            }
        }
    };

    /* renamed from: l */
    @k
    public final Lazy appViewModel = LazyKt.lazy(new Function0<AppViewModel>() { // from class: com.martian.mibook.mvvm.tts.service.BaseReadAloudService$appViewModel$2
        public BaseReadAloudService$appViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @l
        public final AppViewModel invoke() {
            return lc.b.a(BaseReadAloudService.this);
        }
    });

    /* renamed from: r */
    @k
    public final MediaRouter.Callback mediaRouterCallback = new c();

    /* renamed from: com.martian.mibook.mvvm.tts.service.BaseReadAloudService$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void b() {
        }

        @JvmStatic
        public static /* synthetic */ void f() {
        }

        @JvmStatic
        public static /* synthetic */ void k() {
        }

        @JvmStatic
        public static /* synthetic */ void n() {
        }

        public final long a() {
            return BaseReadAloudService.D;
        }

        @k
        public final ServiceLiveData<Long> c() {
            return BaseReadAloudService.J;
        }

        @k
        public final NonStickyLiveData<ReadAloudBook.a> d() {
            return BaseReadAloudService.N;
        }

        public final boolean e() {
            return BaseReadAloudService.B;
        }

        @k
        public final ServiceLiveData<ReadAloudBook.ReadAloudPlayerStatus> g() {
            return BaseReadAloudService.F;
        }

        @k
        public final ServiceLiveData<Boolean> h() {
            return BaseReadAloudService.H;
        }

        @k
        public final NonStickyLiveData<Long> i() {
            return BaseReadAloudService.L;
        }

        public final long j() {
            return BaseReadAloudService.C;
        }

        public final boolean l() {
            return m() && !e();
        }

        public final boolean m() {
            return BaseReadAloudService.A;
        }

        public final void o(long j10) {
            BaseReadAloudService.D = j10;
        }

        public final void p(long j10) {
            BaseReadAloudService.C = j10;
        }

        public Companion() {
        }
    }

    public static final class b extends NotificationTarget {
        public b(BaseReadAloudService baseReadAloudService, RemoteViews remoteViews, Notification notification, int i10) {
            super(baseReadAloudService, i10, remoteViews, notification, BaseReadAloudService.f15167w);
        }

        @Override // com.bumptech.glide.request.target.NotificationTarget, com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }

        @Override // com.bumptech.glide.request.target.NotificationTarget
        public void onResourceReady(@k Bitmap resource, @l Transition<? super Bitmap> transition) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            super.onResourceReady(resource, transition);
        }
    }

    public static final class c extends MediaRouter.Callback {
        public c() {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteAdded(@l MediaRouter mediaRouter, @l MediaRouter.RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteChanged(@l MediaRouter mediaRouter, @l MediaRouter.RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteGrouped(@l MediaRouter mediaRouter, @l MediaRouter.RouteInfo routeInfo, @l MediaRouter.RouteGroup routeGroup, int i10) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteRemoved(@l MediaRouter mediaRouter, @l MediaRouter.RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteSelected(@l MediaRouter mediaRouter, int i10, @l MediaRouter.RouteInfo routeInfo) {
            MediaRouter E;
            MediaRouter E2 = BaseReadAloudService.this.E();
            MediaRouter.RouteInfo selectedRoute = E2 != null ? E2.getSelectedRoute(1) : null;
            if (routeInfo == null || Intrinsics.areEqual(routeInfo, selectedRoute) || (E = BaseReadAloudService.this.E()) == null) {
                return;
            }
            E.selectRoute(1, routeInfo);
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteUngrouped(@l MediaRouter mediaRouter, @l MediaRouter.RouteInfo routeInfo, @l MediaRouter.RouteGroup routeGroup) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteUnselected(@l MediaRouter mediaRouter, int i10, @l MediaRouter.RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteVolumeChanged(@l MediaRouter mediaRouter, @l MediaRouter.RouteInfo routeInfo) {
        }
    }

    static {
        ServiceLiveData<ReadAloudBook.ReadAloudPlayerStatus> serviceLiveData = new ServiceLiveData<>();
        E = serviceLiveData;
        F = serviceLiveData;
        ServiceLiveData<Boolean> serviceLiveData2 = new ServiceLiveData<>();
        G = serviceLiveData2;
        H = serviceLiveData2;
        ServiceLiveData<Long> serviceLiveData3 = new ServiceLiveData<>();
        I = serviceLiveData3;
        J = serviceLiveData3;
        NonStickyLiveData<Long> nonStickyLiveData = new NonStickyLiveData<>();
        K = nonStickyLiveData;
        L = nonStickyLiveData;
        NonStickyLiveData<ReadAloudBook.a> nonStickyLiveData2 = new NonStickyLiveData<>();
        M = nonStickyLiveData2;
        N = nonStickyLiveData2;
    }

    private final AppViewModel A() {
        return (AppViewModel) this.appViewModel.getValue();
    }

    public static final long B() {
        return INSTANCE.a();
    }

    public static final boolean H() {
        return INSTANCE.e();
    }

    public static final long L() {
        return INSTANCE.j();
    }

    public static final boolean S() {
        return INSTANCE.m();
    }

    public static /* synthetic */ void W(BaseReadAloudService baseReadAloudService, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pauseReadAloud");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        baseReadAloudService.V(z10);
    }

    public static final void e0(long j10) {
        INSTANCE.o(j10);
    }

    public static final void h0(long j10) {
        INSTANCE.p(j10);
    }

    public static /* synthetic */ void n0(BaseReadAloudService baseReadAloudService, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: upSpeechRate");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        baseReadAloudService.m0(z10);
    }

    public final AudioManager C() {
        return (AudioManager) this.audioManager.getValue();
    }

    public final AudioFocusRequestCompat D() {
        return (AudioFocusRequestCompat) this.mFocusRequest.getValue();
    }

    public final MediaRouter E() {
        return (MediaRouter) this.mediaRouter.getValue();
    }

    public final NotificationManager F() {
        return (NotificationManager) this.notificationManager.getValue();
    }

    public final NotificationTarget G(RemoteViews remoteView, Notification notification) {
        if (remoteView == null || notification == null) {
            return null;
        }
        if (this.notificationTarget == null) {
            this.notificationTarget = new b(this, remoteView, notification, R.id.tts_cover);
        }
        return this.notificationTarget;
    }

    @l
    public String I() {
        return ReadAloudBook.f15003a.e();
    }

    @l
    public String J() {
        Book a10 = ReadAloudBook.f15003a.a();
        if (a10 != null) {
            return a10.getBookName();
        }
        return null;
    }

    public final RemoteViews K() {
        WeakReference<RemoteViews> weakReference = this.remoteViewWeakReference;
        RemoteViews remoteViews = weakReference != null ? weakReference.get() : null;
        if (remoteViews != null) {
            return remoteViews;
        }
        RemoteViews remoteViews2 = new RemoteViews(getPackageName(), R.layout.remoteview_book_tts_item);
        this.remoteViewWeakReference = new WeakReference<>(remoteViews2);
        return remoteViews2;
    }

    public final PowerManager.WakeLock M() {
        return (PowerManager.WakeLock) this.wakeLock.getValue();
    }

    public final WifiManager.WifiLock N() {
        return (WifiManager.WifiLock) this.wifiLock.getValue();
    }

    public final void O() {
        registerReceiver(this.broadcastReceiver, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
    }

    public final void P() {
        MediaSessionCompat mediaSessionCompat;
        ComponentName componentName = new ComponentName(getApplicationContext(), (Class<?>) MediaButtonReceiver.class);
        getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, intent, 67108864);
        this.mHandler = new Handler(Looper.getMainLooper());
        MediaSessionCompat mediaSessionCompat2 = new MediaSessionCompat(this, "readAloud", componentName, null);
        this.mediaSessionCompat = mediaSessionCompat2;
        mediaSessionCompat2.setMediaButtonReceiver(broadcast);
        MediaSessionCompat mediaSessionCompat3 = this.mediaSessionCompat;
        if (mediaSessionCompat3 != null) {
            mediaSessionCompat3.setCallback(new MediaSessionCompat.Callback() { // from class: com.martian.mibook.mvvm.tts.service.BaseReadAloudService$initMediaSession$1
                public BaseReadAloudService$initMediaSession$1() {
                }

                @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                public boolean onMediaButtonEvent(@k Intent mediaButtonEvent) {
                    Intrinsics.checkNotNullParameter(mediaButtonEvent, "mediaButtonEvent");
                    return MediaButtonReceiver.INSTANCE.a(BaseReadAloudService.this, mediaButtonEvent);
                }

                @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                public void onPause() {
                    super.onPause();
                    BaseReadAloudService.W(BaseReadAloudService.this, false, 1, null);
                }

                @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                public void onPlay() {
                    super.onPlay();
                    BaseReadAloudService.this.d0();
                }

                @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                public void onSkipToNext() {
                    super.onSkipToNext();
                    BaseReadAloudService.this.i0();
                }

                @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                public void onSkipToPrevious() {
                    super.onSkipToPrevious();
                    BaseReadAloudService.this.j0();
                }

                @Override // android.support.v4.media.session.MediaSessionCompat.Callback
                public void onStop() {
                    super.onStop();
                    BaseReadAloudService.this.l0();
                }
            }, this.mHandler);
        }
        MediaSessionCompat mediaSessionCompat4 = this.mediaSessionCompat;
        if (mediaSessionCompat4 != null && mediaSessionCompat4 != null && !mediaSessionCompat4.isActive() && (mediaSessionCompat = this.mediaSessionCompat) != null) {
            mediaSessionCompat.setActive(true);
        }
        MediaRouter E2 = E();
        if (E2 != null) {
            E2.addCallback(1, this.mediaRouterCallback);
        }
    }

    public final boolean Q() {
        boolean isBackgroundRestricted;
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        Object systemService = getSystemService(TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        isBackgroundRestricted = ((ActivityManager) systemService).isBackgroundRestricted();
        return isBackgroundRestricted;
    }

    public abstract boolean R();

    public final boolean T() {
        StatusBarNotification[] activeNotifications;
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        activeNotifications = notificationManager.getActiveNotifications();
        Intrinsics.checkNotNull(activeNotifications);
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            if (statusBarNotification.getId() == 1000001) {
                return true;
            }
        }
        return false;
    }

    public abstract void U(int mChapterIndex, int mContentPos);

    @CallSuper
    public void V(boolean z10) {
        if (this.useWakeLock) {
            PowerManager.WakeLock M2 = M();
            if (M2 != null) {
                M2.release();
            }
            WifiManager.WifiLock N2 = N();
            if (N2 != null) {
                N2.release();
            }
        }
        B = true;
        if (z10) {
            c();
        }
        r0();
        q0(2);
        a0(ReadAloudBook.ReadAloudPlayerStatus.STATE_PAUSED);
    }

    @SuppressLint({"WakelockTimeout"})
    @CallSuper
    public void X() {
        if (this.useWakeLock) {
            PowerManager.WakeLock M2 = M();
            if (M2 != null) {
                M2.acquire();
            }
            WifiManager.WifiLock N2 = N();
            if (N2 != null) {
                N2.acquire();
            }
        }
        A = true;
        B = false;
        this.needResumeOnAudioFocusGain = false;
        r0();
        q0(3);
    }

    @SuppressLint({"WakelockTimeout"})
    @CallSuper
    public void Y() {
        if (this.useWakeLock) {
            PowerManager.WakeLock M2 = M();
            if (M2 != null) {
                M2.acquire();
            }
            WifiManager.WifiLock N2 = N();
            if (N2 != null) {
                N2.acquire();
            }
        }
        a0(ReadAloudBook.ReadAloudPlayerStatus.STATE_PRE_PLAY);
    }

    public void Z(@l Boolean speakTitle) {
        G.postValue(speakTitle);
    }

    public void a0(@k ReadAloudBook.ReadAloudPlayerStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        E.postValue(status);
    }

    @l
    public abstract PendingIntent b0(@k String actionStr);

    public final void c() {
        AudioManager C2 = C();
        if (C2 != null) {
            AudioManagerCompat.abandonAudioFocusRequest(C2, D());
        }
    }

    public final boolean c0() {
        boolean j10 = id.b.f26962a.j(C(), D());
        if (!j10) {
            V(false);
        }
        return j10;
    }

    @CallSuper
    public void d0() {
        A = true;
        B = false;
        r0();
        q0(3);
        a0(ReadAloudBook.ReadAloudPlayerStatus.STATE_PLAYING);
    }

    public final void f0(RemoteViews remoteView, Notification notification) {
        NotificationManager F2;
        if (remoteView != null) {
            remoteView.setTextViewText(R.id.tts_desc, I());
            remoteView.setTextViewText(R.id.tts_name, J());
            int i10 = R.id.tts_pre_chapter;
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            remoteView.setImageViewResource(i10, readAloudBook.c() == 0 ? R.drawable.tts_pre_chapter_unclickable : R.drawable.tts_pre_chapter);
            Integer valueOf = readAloudBook.d() != null ? Integer.valueOf(r0.getCount() - 1) : null;
            remoteView.setImageViewResource(R.id.tts_next_chapter, (valueOf != null && readAloudBook.c() == valueOf.intValue()) ? R.drawable.tts_next_chapter_unclickable : R.drawable.tts_next_chapter);
            int i11 = R.id.tts_play;
            Companion companion = INSTANCE;
            remoteView.setImageViewResource(i11, companion.l() ? R.drawable.tts_pause : R.drawable.tts_play);
            remoteView.setImageViewResource(R.id.tts_cover, R.drawable.tts_default_cover);
            remoteView.setOnClickPendingIntent(R.id.tts_play, b0(companion.l() ? "pause" : id.c.f26967d));
            remoteView.setOnClickPendingIntent(R.id.tts_pre_chapter, b0(id.c.f26969f));
            remoteView.setOnClickPendingIntent(R.id.tts_next_chapter, b0(id.c.f26970g));
            remoteView.setOnClickPendingIntent(R.id.tts_close, b0(id.c.f26966c));
        }
        if (notification == null || remoteView == null || (F2 = F()) == null) {
            return;
        }
        F2.notify(f15167w, notification);
    }

    @CallSuper
    public void g0(long second) {
        C = second;
        z();
    }

    @CallSuper
    public void i0() {
        A = true;
        B = false;
        this.needResumeOnAudioFocusGain = false;
        r0();
        q0(10);
        a0(ReadAloudBook.ReadAloudPlayerStatus.STATE_NEXT);
    }

    @CallSuper
    public void j0() {
        A = true;
        B = false;
        this.needResumeOnAudioFocusGain = false;
        r0();
        q0(9);
        a0(ReadAloudBook.ReadAloudPlayerStatus.STATE_PREVIOUS);
    }

    public final void k0() {
        Coroutine.onFinally$default(Coroutine.onSuccess$default(BaseService.b(this, null, null, null, null, new BaseReadAloudService$startReadAloudNotification$1(this, null), 15, null), null, new BaseReadAloudService$startReadAloudNotification$2(this, null), 1, null), null, new BaseReadAloudService$startReadAloudNotification$3(this, null), 1, null);
    }

    public void l0() {
        A = false;
        B = true;
        a0(ReadAloudBook.ReadAloudPlayerStatus.STATE_STOPPED);
        ReadAloudBook.f15003a.x();
        stopSelf();
    }

    public abstract void m0(boolean reset);

    public abstract void o0();

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        if (focusChange == -2) {
            if (B) {
                return;
            }
            this.needResumeOnAudioFocusGain = true;
            V(false);
            return;
        }
        if (focusChange == -1) {
            W(this, false, 1, null);
        } else if (focusChange == 1 && this.needResumeOnAudioFocusGain) {
            d0();
        }
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    @CallSuper
    public void onCreate() {
        MutableLiveData<Boolean> c02;
        super.onCreate();
        D = System.currentTimeMillis();
        k0();
        if (this.useWakeLock) {
            PowerManager.WakeLock M2 = M();
            if (M2 != null) {
                M2.release();
            }
            WifiManager.WifiLock N2 = N();
            if (N2 != null) {
                N2.release();
            }
        }
        A = true;
        B = false;
        AppViewModel A2 = A();
        if (A2 != null && (c02 = A2.c0()) != null) {
            c02.postValue(Boolean.TRUE);
        }
        q0(0);
        a0(ReadAloudBook.ReadAloudPlayerStatus.STATE_NONE);
        O();
        P();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    @CallSuper
    public void onDestroy() {
        MutableLiveData<Boolean> c02;
        super.onDestroy();
        A = false;
        B = true;
        D = 0L;
        Job job = this.dsJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.dsJob = null;
        ReadAloudBook.f15003a.A(null);
        WeakReference<RemoteViews> weakReference = this.remoteViewWeakReference;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.remoteViewWeakReference = null;
        c();
        unregisterReceiver(this.broadcastReceiver);
        ServiceLiveData<ReadAloudBook.ReadAloudPlayerStatus> serviceLiveData = E;
        serviceLiveData.setValue(ReadAloudBook.ReadAloudPlayerStatus.STATE_NONE);
        serviceLiveData.b();
        G.b();
        I.b();
        K.a();
        M.a();
        q0(1);
        AppViewModel A2 = A();
        if (A2 != null && (c02 = A2.c0()) != null) {
            c02.postValue(Boolean.FALSE);
        }
        MediaRouter E2 = E();
        if (E2 != null) {
            E2.removeCallback(this.mediaRouterCallback);
        }
        MediaSessionCompat mediaSessionCompat = this.mediaSessionCompat;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.release();
        }
        this.notificationTarget = null;
        this.notification = null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(@l Intent intent, int flags, int startId) {
        if (!T()) {
            if (this.notification == null) {
                this.notification = x();
            }
            if (Build.VERSION.SDK_INT >= 31 && y()) {
                return 2;
            }
            startForeground(f15167w, this.notification);
        }
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            switch (action.hashCode()) {
                case -934426579:
                    if (action.equals(id.c.f26967d)) {
                        d0();
                        break;
                    }
                    break;
                case -232000834:
                    if (action.equals(id.c.f26974k)) {
                        o0();
                        break;
                    }
                    break;
                case 3377907:
                    if (action.equals(id.c.f26970g)) {
                        i0();
                        break;
                    }
                    break;
                case 3443508:
                    if (action.equals("play")) {
                        Y();
                        break;
                    }
                    break;
                case 3449395:
                    if (action.equals(id.c.f26969f)) {
                        j0();
                        break;
                    }
                    break;
                case 3540994:
                    if (action.equals(id.c.f26966c)) {
                        l0();
                        break;
                    }
                    break;
                case 106440182:
                    if (action.equals("pause")) {
                        W(this, false, 1, null);
                        break;
                    }
                    break;
                case 533039194:
                    if (action.equals(id.c.f26973j)) {
                        n0(this, false, 1, null);
                        break;
                    }
                    break;
                case 747804969:
                    if (action.equals(id.c.f26972i)) {
                        U(intent.getIntExtra(f15168x, 0), intent.getIntExtra(f15169y, 0));
                        break;
                    }
                    break;
                case 1405077507:
                    if (action.equals(id.c.f26971h)) {
                        g0(intent.getLongExtra(f15170z, 0L));
                        break;
                    }
                    break;
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public final void p0() {
        MediaMetadataCompat.Builder builder = new MediaMetadataCompat.Builder();
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        Bitmap g10 = readAloudBook.g();
        String J2 = J();
        String I2 = I();
        builder.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, J2);
        builder.putString(MediaMetadataCompat.METADATA_KEY_DISPLAY_SUBTITLE, I2);
        builder.putString(MediaMetadataCompat.METADATA_KEY_TITLE, I2);
        builder.putString(MediaMetadataCompat.METADATA_KEY_ALBUM, J2);
        Book a10 = readAloudBook.a();
        builder.putString(MediaMetadataCompat.METADATA_KEY_ARTIST, a10 != null ? a10.getAuthor() : null);
        builder.putBitmap(MediaMetadataCompat.METADATA_KEY_ART, g10);
        MediaSessionCompat mediaSessionCompat = this.mediaSessionCompat;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.setMetadata(builder.build());
        }
    }

    public final void q0(int state) {
        MediaSessionCompat mediaSessionCompat = this.mediaSessionCompat;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.setPlaybackState(new PlaybackStateCompat.Builder().setActions(id.b.f26963b).setState(state, -1L, 1.0f).build());
        }
        p0();
    }

    public final void r0() {
        RemoteViews remoteViews;
        NotificationManager F2;
        WeakReference<RemoteViews> weakReference = this.remoteViewWeakReference;
        if ((weakReference != null ? weakReference.get() : null) == null && (F2 = F()) != null) {
            F2.notify(f15167w, x());
        }
        WeakReference<RemoteViews> weakReference2 = this.remoteViewWeakReference;
        if (weakReference2 == null || (remoteViews = weakReference2.get()) == null) {
            return;
        }
        f0(remoteViews, this.notification);
        NotificationTarget G2 = G(remoteViews, this.notification);
        if (G2 != null) {
            RequestBuilder<Bitmap> asBitmap = Glide.with(this).asBitmap();
            Book a10 = ReadAloudBook.f15003a.a();
        }
    }

    @l
    public abstract PendingIntent w();

    public final Notification x() {
        RemoteViews K2 = K();
        if (m.u()) {
            a0.a();
            NotificationChannel a10 = z.a(f15164t, f15165u, 3);
            a10.setDescription(f15166v);
            a10.setLockscreenVisibility(1);
            NotificationManager F2 = F();
            if (F2 != null) {
                F2.createNotificationChannel(a10);
            }
        }
        NotificationCompat.Builder visibility = new NotificationCompat.Builder(this, f15164t).setSmallIcon(R.drawable.ic_launcher).setCustomContentView(K2).setOnlyAlertOnce(true).setPriority(1).setContentIntent(w()).setSound(null).setOngoing(true).setAutoCancel(false).setVibrate(new long[]{0}).setDefaults(64).setVisibility(1);
        Intrinsics.checkNotNullExpressionValue(visibility, "setVisibility(...)");
        Notification build = visibility.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public final boolean y() {
        return !ConfigSingleton.D().x0() && Q();
    }

    public final synchronized void z() {
        Job launch$default;
        try {
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            if (readAloudBook.s() != 0 && readAloudBook.s() != 1) {
                long j10 = C;
                if (j10 > 0) {
                    K.postValue(Long.valueOf(j10));
                    r0();
                    Job job = this.dsJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BaseReadAloudService$doTimer$1(this, null), 3, null);
                    this.dsJob = launch$default;
                    return;
                }
            }
            Job job2 = this.dsJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            K.postValue(0L);
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
