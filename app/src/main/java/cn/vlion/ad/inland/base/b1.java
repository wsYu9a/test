package cn.vlion.ad.inland.base;

import android.content.Context;
import android.media.MediaPlayer;
import cn.vlion.ad.inland.base.a7;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class b1 extends e1 {

    public class a implements MediaPlayer.OnInfoListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
            a7.b bVar;
            boolean z10;
            try {
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            if (b1.this.f2724e) {
                return false;
            }
            LogVlion.e("VlionBaseVideoViewCenter onInfo() what=" + i10 + " extra=" + i11);
            if (i10 == 701) {
                LogVlion.e("VlionBaseVideoViewCenter showProgressIcon = true  9999");
                if (b1.this.f2738s != null) {
                    LogVlion.e("VlionBaseVideoViewCenter showProgressIcon = true  77777");
                    bVar = (a7.b) b1.this.f2738s;
                    z10 = true;
                }
                return false;
            }
            if (i10 == 702) {
                if (b1.this.f2738s != null) {
                    LogVlion.e("VlionBaseVideoViewCenter showProgressIcon = false  100000");
                    bVar = (a7.b) b1.this.f2738s;
                    z10 = false;
                }
            } else if (i10 == 3) {
                LogVlion.e("VlionBaseVideoViewCenter onInfo() MEDIA_INFO_VIDEO_RENDERING_START what=" + i10);
                b1 b1Var = b1.this;
                b1Var.f2729j = false;
                if (b1Var.f2738s != null) {
                    LogVlion.e("VlionBaseVideoViewCenter showProgressIcon = false  88888");
                    ((a7.b) b1.this.f2738s).a(false);
                    ((a7.b) b1.this.f2738s).b(false);
                }
                b1.this.a(false);
            }
            return false;
            bVar.a(z10);
            return false;
        }
    }

    public b1(Context context) {
        super(context);
    }

    @Override // cn.vlion.ad.inland.base.e1
    public final void a() {
        super.a();
    }

    @Override // cn.vlion.ad.inland.base.e1
    public final void d() {
        super.d();
    }

    @Override // cn.vlion.ad.inland.base.e1
    public final void e() {
        try {
            MediaPlayer mediaPlayer = this.f2725f;
            if (mediaPlayer != null) {
                mediaPlayer.setOnInfoListener(new a());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.e1
    public final void a(String str, String str2) {
        super.a(str, str2);
        try {
            HttpRequestUtil.downloadBitmapNeedCache(this.f2735p, str2, new a1());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
