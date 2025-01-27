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

    private void c0() {
        int i10 = this.f13033b;
        if (i10 == 3) {
            this.f13039h.setImageResource(R.drawable.jc_click_pause_selector);
        } else if (i10 == 7) {
            this.f13039h.setImageResource(R.drawable.jc_click_error_selector);
        } else {
            this.f13039h.setImageResource(R.drawable.jc_click_play_selector);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public void O(String str, int i10, Object... objArr) {
        super.O(str, i10, objArr);
        b0();
        this.f13041j.setVisibility(8);
    }

    public void b0() {
        if (this.f13034c == 2) {
            this.f13041j.setImageResource(R.drawable.jc_shrink);
        } else {
            this.f13041j.setImageResource(R.drawable.jc_enlarge);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer
    public int getLayoutId() {
        return R.layout.jc_layout_base;
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.fullscreen && this.f13033b == 0) {
            Toast.makeText(getContext(), "Play video first", 0).show();
        } else {
            super.onClick(view);
        }
    }

    @Override // com.martian.libvideoplayer.JCVideoPlayer, android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        if (z10 && this.f13033b == 0) {
            Toast.makeText(getContext(), "Play video first", 0).show();
        } else {
            super.onProgressChanged(seekBar, i10, z10);
        }
    }

    public JCVideoPlayerSimple(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
