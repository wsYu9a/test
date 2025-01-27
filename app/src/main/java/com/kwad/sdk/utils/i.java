package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

/* loaded from: classes3.dex */
public final class i {
    private AudioManager aFO;
    private AudioManager.OnAudioFocusChangeListener aSL = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.i.1

        /* renamed from: com.kwad.sdk.utils.i$1$1 */
        public class RunnableC05181 implements Runnable {
            final /* synthetic */ int aSN;

            public RunnableC05181(int i10) {
                i10 = i10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (i10 < 0) {
                    i.this.iF.onAudioBeOccupied();
                } else {
                    i.this.iF.onAudioBeReleased();
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i10) {
            if (i.this.iF == null) {
                return;
            }
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.i.1.1
                final /* synthetic */ int aSN;

                public RunnableC05181(int i102) {
                    i10 = i102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (i10 < 0) {
                        i.this.iF.onAudioBeOccupied();
                    } else {
                        i.this.iF.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a iF;

    /* renamed from: com.kwad.sdk.utils.i$1 */
    public class AnonymousClass1 implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: com.kwad.sdk.utils.i$1$1 */
        public class RunnableC05181 implements Runnable {
            final /* synthetic */ int aSN;

            public RunnableC05181(int i102) {
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (i10 < 0) {
                    i.this.iF.onAudioBeOccupied();
                } else {
                    i.this.iF.onAudioBeReleased();
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i102) {
            if (i.this.iF == null) {
                return;
            }
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.i.1.1
                final /* synthetic */ int aSN;

                public RunnableC05181(int i1022) {
                    i10 = i1022;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (i10 < 0) {
                        i.this.iF.onAudioBeOccupied();
                    } else {
                        i.this.iF.onAudioBeReleased();
                    }
                }
            });
        }
    }

    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public i(Context context) {
        this.aFO = (AudioManager) context.getSystemService("audio");
    }

    @TargetApi(26)
    private AudioFocusRequest MS() {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder acceptsDelayedFocusGain;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        audioAttributes = y1.g.a(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build());
        acceptsDelayedFocusGain = audioAttributes.setAcceptsDelayedFocusGain(false);
        onAudioFocusChangeListener = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(this.aSL);
        build = onAudioFocusChangeListener.build();
        return build;
    }

    public final boolean MR() {
        AudioManager audioManager;
        int requestAudioFocus;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.aSL;
        if (onAudioFocusChangeListener != null && (audioManager = this.aFO) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                requestAudioFocus = audioManager.requestAudioFocus(MS());
                return 1 == requestAudioFocus;
            }
            if (1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                return true;
            }
        }
        return false;
    }

    public final void c(a aVar) {
        this.iF = aVar;
    }
}
