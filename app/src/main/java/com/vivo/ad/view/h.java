package com.vivo.ad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.vivo.mobilead.lottie.FontAssetDelegate;
import com.vivo.mobilead.lottie.LottieAnimationView;
import com.vivo.mobilead.lottie.LottieComposition;
import com.vivo.mobilead.lottie.LottieCompositionFactory;
import com.vivo.mobilead.lottie.LottieListener;
import com.vivo.mobilead.lottie.LottieTask;
import com.vivo.mobilead.util.x0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.zip.ZipInputStream;

/* loaded from: classes4.dex */
public class h extends LottieAnimationView {

    /* renamed from: b */
    private static final String f27028b = h.class.getSimpleName();

    /* renamed from: a */
    private t f27029a;

    class a extends FontAssetDelegate {
        a(h hVar) {
        }

        @Override // com.vivo.mobilead.lottie.FontAssetDelegate
        public Typeface fetchFont(String str) {
            return Typeface.DEFAULT;
        }
    }

    class b implements LottieListener<Throwable> {
        b(h hVar) {
        }

        @Override // com.vivo.mobilead.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
        }
    }

    class c implements LottieListener<LottieComposition> {
        c() {
        }

        @Override // com.vivo.mobilead.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            h.this.setComposition(lottieComposition);
        }
    }

    public h(Context context) {
        this(context, null, 0);
    }

    public void a() {
        t tVar = this.f27029a;
        if (tVar != null) {
            tVar.e();
            this.f27029a = null;
        }
        cancelAnimation();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            super.draw(canvas);
        } catch (Exception e2) {
            x0.b(f27028b, "" + e2.getMessage());
        }
    }

    @Override // com.vivo.mobilead.lottie.LottieAnimationView
    public void loop(boolean z) {
        try {
            super.loop(z);
        } catch (Exception e2) {
            x0.b(f27028b, "" + e2.getMessage());
        }
    }

    @Override // com.vivo.mobilead.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        playAnimation();
    }

    @Override // com.vivo.mobilead.lottie.LottieAnimationView, android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            t tVar = this.f27029a;
            if (tVar != null) {
                tVar.d();
                return;
            }
            return;
        }
        t tVar2 = this.f27029a;
        if (tVar2 != null) {
            tVar2.e();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 0) {
            t tVar = this.f27029a;
            if (tVar != null) {
                tVar.d();
                return;
            }
            return;
        }
        t tVar2 = this.f27029a;
        if (tVar2 != null) {
            tVar2.e();
        }
    }

    @Override // com.vivo.mobilead.lottie.LottieAnimationView
    public void pauseAnimation() {
        super.pauseAnimation();
        t tVar = this.f27029a;
        if (tVar != null) {
            tVar.e();
        }
    }

    @Override // com.vivo.mobilead.lottie.LottieAnimationView
    public void playAnimation() {
        try {
            super.playAnimation();
        } catch (Exception e2) {
            x0.b(f27028b, "" + e2.getMessage());
        }
    }

    @Override // com.vivo.mobilead.lottie.LottieAnimationView
    public void resumeAnimation() {
        super.resumeAnimation();
        t tVar = this.f27029a;
        if (tVar != null) {
            tVar.d();
        }
    }

    @Override // com.vivo.mobilead.lottie.LottieAnimationView
    public void setAnimation(String str) {
        try {
            super.setAnimation(str);
        } catch (Exception e2) {
            x0.b(f27028b, "" + e2.getMessage());
        }
    }

    public void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        try {
            Method declaredMethod = LottieAnimationView.class.getDeclaredMethod("clearComposition", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, new Object[0]);
            Method declaredMethod2 = LottieAnimationView.class.getDeclaredMethod("cancelLoaderTask", new Class[0]);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(this, new Object[0]);
            lottieTask.addListener(new c()).addFailureListener(new b(this));
            Field declaredField = LottieAnimationView.class.getDeclaredField("compositionTask");
            declaredField.setAccessible(true);
            declaredField.set(this, lottieTask);
        } catch (Exception e2) {
            x0.b(f27028b, "" + e2.getMessage());
        }
    }

    public void setShakeManager(t tVar) {
        this.f27029a = tVar;
    }

    public h(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setFontAssetDelegate(new a(this));
    }

    public void a(String str, String str2) throws FileNotFoundException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            if (str2.endsWith(".json")) {
                setCompositionTask(LottieCompositionFactory.fromJsonInputStream(new FileInputStream(str), file.getName()));
            } else if (str2.endsWith(".zip")) {
                setCompositionTask(LottieCompositionFactory.fromZipStream(new ZipInputStream(new FileInputStream(str)), file.getName()));
            }
        }
    }
}
