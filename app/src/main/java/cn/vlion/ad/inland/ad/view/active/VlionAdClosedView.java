package cn.vlion.ad.inland.ad.view.active;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cn.vlion.ad.inland.base.R;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public class VlionAdClosedView extends FrameLayout {

    /* renamed from: a */
    public FrameLayout f2397a;

    /* renamed from: b */
    public ImageView f2398b;

    /* renamed from: c */
    public TextView f2399c;

    /* renamed from: d */
    public boolean f2400d;

    public class a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ d f2401a;

        public a(d dVar) {
            this.f2401a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                LogVlion.e("VlionAdClosedView Click " + VlionAdClosedView.this.f2400d);
                if (VlionAdClosedView.this.f2400d) {
                    d dVar = this.f2401a;
                    if (dVar != null) {
                        dVar.a(true);
                        return;
                    }
                    return;
                }
                d dVar2 = this.f2401a;
                if (dVar2 != null) {
                    dVar2.a(false);
                }
                VlionAdClosedView.this.f2400d = true;
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ d f2403a;

        public b(d dVar) {
            this.f2403a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                d dVar = this.f2403a;
                if (dVar != null) {
                    dVar.a();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ d f2404a;

        public c(d dVar) {
            this.f2404a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                d dVar = this.f2404a;
                if (dVar != null) {
                    dVar.a();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public interface d {
        void a();

        void a(boolean z10);
    }

    public VlionAdClosedView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:2:0x0000, B:7:0x0019, B:13:0x0032, B:14:0x005a, B:18:0x003d, B:19:0x0057, B:20:0x004b, B:22:0x0023), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r6, boolean r7, cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.d r8) {
        /*
            r5 = this;
            r5.f2400d = r7     // Catch: java.lang.Throwable -> L21
            int r7 = r6.hashCode()     // Catch: java.lang.Throwable -> L21
            r0 = 684762(0xa72da, float:9.59556E-40)
            java.lang.String r1 = "关闭"
            r2 = 1
            java.lang.String r3 = "跳过"
            r4 = 0
            if (r7 == r0) goto L23
            r0 = 1163316(0x11c034, float:1.630153E-39)
            if (r7 == r0) goto L19
            goto L2b
        L19:
            boolean r6 = r6.equals(r3)     // Catch: java.lang.Throwable -> L21
            if (r6 == 0) goto L2b
            r6 = 1
            goto L2c
        L21:
            r6 = move-exception
            goto L79
        L23:
            boolean r6 = r6.equals(r1)     // Catch: java.lang.Throwable -> L21
            if (r6 == 0) goto L2b
            r6 = 0
            goto L2c
        L2b:
            r6 = -1
        L2c:
            r7 = 8
            if (r6 == 0) goto L4b
            if (r6 == r2) goto L3d
            android.widget.ImageView r6 = r5.f2398b     // Catch: java.lang.Throwable -> L21
            r6.setVisibility(r4)     // Catch: java.lang.Throwable -> L21
            android.widget.TextView r6 = r5.f2399c     // Catch: java.lang.Throwable -> L21
            r6.setVisibility(r7)     // Catch: java.lang.Throwable -> L21
            goto L5a
        L3d:
            android.widget.ImageView r6 = r5.f2398b     // Catch: java.lang.Throwable -> L21
            r6.setVisibility(r7)     // Catch: java.lang.Throwable -> L21
            android.widget.TextView r6 = r5.f2399c     // Catch: java.lang.Throwable -> L21
            r6.setVisibility(r4)     // Catch: java.lang.Throwable -> L21
            android.widget.TextView r6 = r5.f2399c     // Catch: java.lang.Throwable -> L21
            r1 = r3
            goto L57
        L4b:
            android.widget.ImageView r6 = r5.f2398b     // Catch: java.lang.Throwable -> L21
            r6.setVisibility(r7)     // Catch: java.lang.Throwable -> L21
            android.widget.TextView r6 = r5.f2399c     // Catch: java.lang.Throwable -> L21
            r6.setVisibility(r4)     // Catch: java.lang.Throwable -> L21
            android.widget.TextView r6 = r5.f2399c     // Catch: java.lang.Throwable -> L21
        L57:
            r6.setText(r1)     // Catch: java.lang.Throwable -> L21
        L5a:
            android.widget.FrameLayout r6 = r5.f2397a     // Catch: java.lang.Throwable -> L21
            cn.vlion.ad.inland.ad.view.active.VlionAdClosedView$a r7 = new cn.vlion.ad.inland.ad.view.active.VlionAdClosedView$a     // Catch: java.lang.Throwable -> L21
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L21
            r6.setOnClickListener(r7)     // Catch: java.lang.Throwable -> L21
            android.widget.ImageView r6 = r5.f2398b     // Catch: java.lang.Throwable -> L21
            cn.vlion.ad.inland.ad.view.active.VlionAdClosedView$b r7 = new cn.vlion.ad.inland.ad.view.active.VlionAdClosedView$b     // Catch: java.lang.Throwable -> L21
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L21
            r6.setOnClickListener(r7)     // Catch: java.lang.Throwable -> L21
            android.widget.TextView r6 = r5.f2399c     // Catch: java.lang.Throwable -> L21
            cn.vlion.ad.inland.ad.view.active.VlionAdClosedView$c r7 = new cn.vlion.ad.inland.ad.view.active.VlionAdClosedView$c     // Catch: java.lang.Throwable -> L21
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L21
            r6.setOnClickListener(r7)     // Catch: java.lang.Throwable -> L21
            goto L80
        L79:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r7 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r7.upLoadCatchException(r6)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.ad.view.active.VlionAdClosedView.a(java.lang.String, boolean, cn.vlion.ad.inland.ad.view.active.VlionAdClosedView$d):void");
    }

    public VlionAdClosedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VlionAdClosedView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2400d = true;
        try {
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_closed, (ViewGroup) this, true);
            this.f2397a = (FrameLayout) findViewById(R.id.vilon_close_miss);
            this.f2398b = (ImageView) findViewById(R.id.vilon_close);
            this.f2399c = (TextView) findViewById(R.id.vilon_close_text);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
