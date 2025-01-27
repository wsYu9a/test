package com.alimm.tanx.core.view.player.core.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import java.lang.ref.WeakReference;
import y1.g;

/* loaded from: classes.dex */
public class MediaPlayerAudioManager implements IAudioManager {
    private final AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
    private AudioFocusRequest audioFocusRequest;
    private final AudioManager audioManager;
    private final Context context;
    private final ITanxPlayer iTanxPlayer;
    private final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;

    public MediaPlayerAudioManager(Context context, ITanxPlayer iTanxPlayer) {
        this.context = context;
        this.iTanxPlayer = iTanxPlayer;
        this.audioManager = (AudioManager) context.getSystemService("audio");
        this.onAudioFocusChangeListener = new DefaultAudioFocusChangeListener(new WeakReference(context), this, iTanxPlayer);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void abandonAudioFocus() {
        if (Build.VERSION.SDK_INT < 26) {
            this.audioManager.abandonAudioFocus(this.onAudioFocusChangeListener);
            return;
        }
        AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
        if (audioFocusRequest != null) {
            this.audioManager.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public int getMaxVolume() {
        return this.audioManager.getStreamMaxVolume(3);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public int getVolume() {
        return this.audioManager.getStreamVolume(3);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void mute() {
        ITanxPlayer iTanxPlayer = this.iTanxPlayer;
        if (iTanxPlayer != null) {
            iTanxPlayer.setVolume(0.0f);
        }
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void requestAudioFocus() {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder acceptsDelayedFocusGain;
        AudioFocusRequest.Builder onAudioFocusChangeListener;
        AudioFocusRequest build;
        if (Build.VERSION.SDK_INT < 26) {
            this.audioManager.requestAudioFocus(this.onAudioFocusChangeListener, 3, 1);
            return;
        }
        audioAttributes = g.a(1).setAudioAttributes(this.audioAttributes);
        acceptsDelayedFocusGain = audioAttributes.setAcceptsDelayedFocusGain(false);
        onAudioFocusChangeListener = acceptsDelayedFocusGain.setOnAudioFocusChangeListener(this.onAudioFocusChangeListener);
        build = onAudioFocusChangeListener.build();
        this.audioFocusRequest = build;
        this.audioManager.requestAudioFocus(build);
    }

    @Override // com.alimm.tanx.core.view.player.core.audio.IAudioManager
    public void setVolume(int i10) {
        if (i10 >= 1) {
            this.iTanxPlayer.setVolume(1.0f);
        } else {
            this.iTanxPlayer.setVolume(i10);
        }
    }
}
