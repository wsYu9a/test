package com.vivo.mobilead.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private TextureView f28722a;

    /* renamed from: b */
    private SurfaceView f28723b;

    /* renamed from: c */
    private c f28724c;

    /* renamed from: d */
    private TextureView.SurfaceTextureListener f28725d = new a();

    /* renamed from: e */
    private SurfaceHolder.Callback f28726e = new b();

    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            if (d.this.f28724c != null) {
                d.this.f28724c.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (d.this.f28724c == null) {
                return false;
            }
            d.this.f28724c.onSurfaceTextureDestroyed(surfaceTexture);
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    class b implements SurfaceHolder.Callback {
        b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (d.this.f28724c != null) {
                d.this.f28724c.surfaceCreated(surfaceHolder);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (d.this.f28724c != null) {
                d.this.f28724c.surfaceDestroyed(surfaceHolder);
            }
        }
    }

    public d(Context context, int i2) {
        if (i2 == 1) {
            TextureView textureView = new TextureView(context);
            this.f28722a = textureView;
            textureView.setSurfaceTextureListener(this.f28725d);
        } else {
            SurfaceView surfaceView = new SurfaceView(context);
            this.f28723b = surfaceView;
            surfaceView.getHolder().addCallback(this.f28726e);
        }
    }

    public View a() {
        TextureView textureView = this.f28722a;
        return textureView != null ? textureView : this.f28723b;
    }

    public void a(c cVar) {
        this.f28724c = cVar;
    }
}
