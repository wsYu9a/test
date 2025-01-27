package com.martian.mibook.mvvm.tts.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.mibook.mvvm.tts.TTSReadManager;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/martian/mibook/mvvm/tts/receiver/MediaButtonReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", f.X, "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class MediaButtonReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.martian.mibook.mvvm.tts.receiver.MediaButtonReceiver$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public final boolean a(@k Context context, @k Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual("android.intent.action.MEDIA_BUTTON", intent.getAction())) {
                Parcelable parcelableExtra = intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                KeyEvent keyEvent = parcelableExtra instanceof KeyEvent ? (KeyEvent) parcelableExtra : null;
                if (keyEvent == null) {
                    return false;
                }
                if (keyEvent.getAction() == 1) {
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 79) {
                        if (keyCode == 126) {
                            TTSReadManager.h(context);
                        } else if (keyCode != 127) {
                            switch (keyCode) {
                                case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_BACKUP_URLS /* 86 */:
                                    TTSReadManager.l(context);
                                    break;
                                case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_NOTIFICATION_JUMP_URL /* 87 */:
                                    TTSReadManager.c(context);
                                    break;
                                case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_NAME /* 88 */:
                                    TTSReadManager.g(context);
                                    break;
                            }
                        } else {
                            TTSReadManager.d(context);
                        }
                    }
                    TTSReadManager.i(context);
                }
            }
            return true;
        }

        public Companion() {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@k Context r22, @k Intent intent) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (INSTANCE.a(r22, intent) && isOrderedBroadcast()) {
            abortBroadcast();
        }
    }
}
