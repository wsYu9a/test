package cn.vlion.ad.inland.ad.view.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public class VolumeControlView extends ImageView {

    /* renamed from: a */
    public boolean f2560a;

    /* renamed from: b */
    public b f2561b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                VolumeControlView volumeControlView = VolumeControlView.this;
                boolean z10 = !volumeControlView.f2560a;
                try {
                    try {
                        volumeControlView.f2560a = z10;
                        volumeControlView.setImageResource(z10 ? R.drawable.vlion_cn_ad_volume_close : R.drawable.vlion_cn_ad_volume_open);
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                    b bVar = volumeControlView.f2561b;
                    if (bVar != null) {
                        bVar.a(z10);
                    }
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                }
            } catch (Throwable th4) {
                VlionSDkManager.getInstance().upLoadCatchException(th4);
            }
        }
    }

    public interface b {
        void a(boolean z10);
    }

    public VolumeControlView(Context context) {
        this(context, null);
    }

    public final void a() {
        setOnClickListener(new a());
    }

    public void setVolumeControlListener(b bVar) {
        this.f2561b = bVar;
    }

    public VolumeControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VolumeControlView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2560a = false;
        a();
    }
}
