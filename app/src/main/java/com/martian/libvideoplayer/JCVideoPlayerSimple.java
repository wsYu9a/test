package com.martian.libvideoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

/* loaded from: classes3.dex */
public class JCVideoPlayerSimple extends JCVideoPlayer {
    public JCVideoPlayerSimple(Context context) {
        super(context);
    }

    private void b0() {
        int i2 = this.E;
        if (i2 == 3) {
            this.K.setImageResource(R.drawable.jc_click_pause_selector);
        } else if (i2 == 7) {
            this.K.setImageResource(R.drawable.jc_click_error_selector);
        } else {
            this.K.setImageResource(R.drawable.jc_click_play_selector);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void N(String url, int screen, Object... objects) {
        super.N(url, screen, objects);
        a0();
        this.M.setVisibility(8);
    }

    public void a0() {
        if (this.F == 2) {
            this.M.setImageResource(R.drawable.jc_shrink);
        } else {
            this.M.setImageResource(R.drawable.jc_enlarge);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public int getLayoutId() {
        return R.layout.jc_layout_base;
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer, android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == R.id.fullscreen && this.E == 0) {
            Toast.makeText(getContext(), "Play video first", 0).show();
        } else {
            super.onClick(v);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer, android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser && this.E == 0) {
            Toast.makeText(getContext(), "Play video first", 0).show();
        } else {
            super.onProgressChanged(seekBar, progress, fromUser);
        }
    }

    public JCVideoPlayerSimple(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
