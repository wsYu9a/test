package com.kwad.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

/* loaded from: classes2.dex */
public final class h {
    private AudioManager ani;
    private AudioManager.OnAudioFocusChangeListener azi = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.h.1

        /* renamed from: com.kwad.sdk.utils.h$1$1 */
        final class RunnableC02321 implements Runnable {
            final /* synthetic */ int azk;

            RunnableC02321(int i2) {
                i2 = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (i2 < 0) {
                    h.this.gV.onAudioBeOccupied();
                } else {
                    h.this.gV.onAudioBeReleased();
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i2) {
            if (h.this.gV == null) {
                return;
            }
            bi.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.h.1.1
                final /* synthetic */ int azk;

                RunnableC02321(int i22) {
                    i2 = i22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (i2 < 0) {
                        h.this.gV.onAudioBeOccupied();
                    } else {
                        h.this.gV.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a gV;

    /* renamed from: com.kwad.sdk.utils.h$1 */
    final class AnonymousClass1 implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: com.kwad.sdk.utils.h$1$1 */
        final class RunnableC02321 implements Runnable {
            final /* synthetic */ int azk;

            RunnableC02321(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (i2 < 0) {
                    h.this.gV.onAudioBeOccupied();
                } else {
                    h.this.gV.onAudioBeReleased();
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i22) {
            if (h.this.gV == null) {
                return;
            }
            bi.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.h.1.1
                final /* synthetic */ int azk;

                RunnableC02321(int i222) {
                    i2 = i222;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (i2 < 0) {
                        h.this.gV.onAudioBeOccupied();
                    } else {
                        h.this.gV.onAudioBeReleased();
                    }
                }
            });
        }
    }

    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public h(Context context) {
        this.ani = (AudioManager) context.getSystemService("audio");
    }

    @TargetApi(26)
    private AudioFocusRequest CR() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.azi).build();
    }

    public final boolean CQ() {
        AudioManager audioManager;
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.azi;
        if (onAudioFocusChangeListener != null && (audioManager = this.ani) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return 1 == audioManager.requestAudioFocus(CR());
            }
            if (1 == audioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2)) {
                return true;
            }
        }
        return false;
    }

    public final void c(a aVar) {
        this.gV = aVar;
    }
}
