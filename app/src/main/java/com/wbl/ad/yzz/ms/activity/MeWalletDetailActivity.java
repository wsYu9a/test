package com.wbl.ad.yzz.ms.activity;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ms.d.e.g;

/* loaded from: classes5.dex */
public class MeWalletDetailActivity extends AppCompatActivity {

    /* renamed from: h */
    public static g f33019h;

    /* renamed from: b */
    public int f33021b;

    /* renamed from: c */
    public int f33022c;

    /* renamed from: d */
    public WebView f33023d;

    /* renamed from: e */
    public g f33024e;

    /* renamed from: a */
    public final String f33020a = getClass().getSimpleName();

    /* renamed from: f */
    public com.wbl.ad.yzz.ms.c.a f33025f = new com.wbl.ad.yzz.ms.c.a((Activity) this);

    /* renamed from: g */
    public MediaPlayer.OnInfoListener f33026g = new a();

    public class a implements MediaPlayer.OnInfoListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12706, this, mediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12705, this, view);
        }
    }

    public class c implements TextureView.SurfaceTextureListener {

        /* renamed from: a */
        public final /* synthetic */ TextureView f33029a;

        public c(TextureView textureView) {
            this.f33029a = textureView;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12708, this, surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12707, this, surfaceTexture);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12734, this, surfaceTexture, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12733, this, surfaceTexture);
        }
    }

    public class d implements MediaPlayer.OnVideoSizeChangedListener {

        /* renamed from: a */
        public final /* synthetic */ TextureView f33031a;

        public d(TextureView textureView) {
            this.f33031a = textureView;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12736, this, mediaPlayer, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public class e extends WebViewClient {
        public e(MeWalletDetailActivity meWalletDetailActivity) {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12735, this, webView, webResourceRequest);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12730, this, view);
        }
    }

    public static /* synthetic */ com.wbl.ad.yzz.ms.c.a a(MeWalletDetailActivity meWalletDetailActivity) {
        return (com.wbl.ad.yzz.ms.c.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12732, null, meWalletDetailActivity);
    }

    public static void a(g gVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12731, null, gVar);
    }

    public static /* synthetic */ g e(MeWalletDetailActivity meWalletDetailActivity) {
        return (g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12722, null, meWalletDetailActivity);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12721, this, null);
    }

    public final void a(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12724, this, str);
    }

    public final void a(String str, String str2, String str3, float f2, int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12723, this, str, str2, str3, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12686, this, bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12685, this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12688, this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12687, this, null);
    }
}
