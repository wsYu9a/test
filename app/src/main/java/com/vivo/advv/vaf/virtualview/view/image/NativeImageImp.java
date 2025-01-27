package com.vivo.advv.vaf.virtualview.view.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.vivo.advv.vaf.virtualview.container.ClickHelper;
import com.vivo.advv.vaf.virtualview.container.IActionListener;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.IView;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.util.ShowGifDelegate;
import java.io.File;

/* loaded from: classes4.dex */
public class NativeImageImp extends ImageView implements IView, IContainer {
    private static final String TAG = "NativeImageImp_TMTEST";
    private ShowGifDelegate mBgShowGifDelegate;
    private ShowGifDelegate.ShowGifListener mBgShowGifListener;
    private int mBorderBottomLeftRadius;
    private int mBorderBottomRightRadius;
    private int mBorderTopLeftRadius;
    private int mBorderTopRightRadius;
    private float[] mCorners;
    private RoundViewDelegate mRoundViewDelegate;
    private ShowGifDelegate mSrcShowGifDelegate;
    private ShowGifDelegate.ShowGifListener mSrcShowGifListener;
    protected ViewBase mVirtualView;

    /* renamed from: com.vivo.advv.vaf.virtualview.view.image.NativeImageImp$1 */
    class AnonymousClass1 implements ShowGifDelegate.ShowGifListener {
        AnonymousClass1() {
        }

        @Override // com.vivo.advv.vaf.virtualview.util.ShowGifDelegate.ShowGifListener
        public void onLoad(Drawable drawable) {
            NativeImageImp.this.setImageDrawable(drawable);
        }

        @Override // com.vivo.advv.vaf.virtualview.util.ShowGifDelegate.ShowGifListener
        public void onMeasureResult(int i2, int i3) {
            NativeImageImp.this.setMeasuredDimension(i2, i3);
        }
    }

    /* renamed from: com.vivo.advv.vaf.virtualview.view.image.NativeImageImp$2 */
    class AnonymousClass2 implements ShowGifDelegate.ShowGifListener {
        AnonymousClass2() {
        }

        @Override // com.vivo.advv.vaf.virtualview.util.ShowGifDelegate.ShowGifListener
        public void onLoad(Drawable drawable) {
            if (NativeImageImp.this.mSrcShowGifDelegate == null) {
                NativeImageImp.this.setBackground(drawable);
            }
        }

        @Override // com.vivo.advv.vaf.virtualview.util.ShowGifDelegate.ShowGifListener
        public void onMeasureResult(int i2, int i3) {
            if (NativeImageImp.this.mSrcShowGifDelegate == null) {
                NativeImageImp.this.setMeasuredDimension(i2, i3);
            }
        }
    }

    public NativeImageImp(Context context) {
        super(context);
        this.mBorderTopLeftRadius = 0;
        this.mBorderTopRightRadius = 0;
        this.mBorderBottomLeftRadius = 0;
        this.mBorderBottomRightRadius = 0;
        this.mSrcShowGifListener = new ShowGifDelegate.ShowGifListener() { // from class: com.vivo.advv.vaf.virtualview.view.image.NativeImageImp.1
            AnonymousClass1() {
            }

            @Override // com.vivo.advv.vaf.virtualview.util.ShowGifDelegate.ShowGifListener
            public void onLoad(Drawable drawable) {
                NativeImageImp.this.setImageDrawable(drawable);
            }

            @Override // com.vivo.advv.vaf.virtualview.util.ShowGifDelegate.ShowGifListener
            public void onMeasureResult(int i2, int i3) {
                NativeImageImp.this.setMeasuredDimension(i2, i3);
            }
        };
        this.mBgShowGifListener = new ShowGifDelegate.ShowGifListener() { // from class: com.vivo.advv.vaf.virtualview.view.image.NativeImageImp.2
            AnonymousClass2() {
            }

            @Override // com.vivo.advv.vaf.virtualview.util.ShowGifDelegate.ShowGifListener
            public void onLoad(Drawable drawable) {
                if (NativeImageImp.this.mSrcShowGifDelegate == null) {
                    NativeImageImp.this.setBackground(drawable);
                }
            }

            @Override // com.vivo.advv.vaf.virtualview.util.ShowGifDelegate.ShowGifListener
            public void onMeasureResult(int i2, int i3) {
                if (NativeImageImp.this.mSrcShowGifDelegate == null) {
                    NativeImageImp.this.setMeasuredDimension(i2, i3);
                }
            }
        };
        this.mRoundViewDelegate = new RoundViewDelegate(this, context);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void attachViews() {
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        layout(i2, i3, i4, i5);
    }

    public void decode2Bg(byte[] bArr, File file) {
        if (this.mSrcShowGifDelegate != null) {
            return;
        }
        if (this.mBgShowGifDelegate == null) {
            ShowGifDelegate showGifDelegate = new ShowGifDelegate(this);
            this.mBgShowGifDelegate = showGifDelegate;
            showGifDelegate.setShowGifListener(this.mBgShowGifListener);
        }
        this.mBgShowGifDelegate.decode(this, bArr, file);
    }

    public void decode2Src(byte[] bArr, File file) {
        if (this.mSrcShowGifDelegate == null) {
            ShowGifDelegate showGifDelegate = new ShowGifDelegate(this);
            this.mSrcShowGifDelegate = showGifDelegate;
            showGifDelegate.setShowGifListener(this.mSrcShowGifListener);
        }
        this.mSrcShowGifDelegate.decode(this, bArr, file);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void destroy() {
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0075 A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000f, B:7:0x0013, B:9:0x0017, B:11:0x001b, B:13:0x001f, B:16:0x0023, B:18:0x0028, B:19:0x0053, B:21:0x0059, B:23:0x005f, B:25:0x0063, B:26:0x0070, B:28:0x0075, B:30:0x0068, B:32:0x006c, B:34:0x0079, B:36:0x007f, B:38:0x0085, B:39:0x0089, B:41:0x0008, B:43:0x000c), top: B:1:0x0000 }] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r6) {
        /*
            r5 = this;
            com.vivo.advv.vaf.virtualview.util.ShowGifDelegate r0 = r5.mSrcShowGifDelegate     // Catch: java.lang.Exception -> L96
            if (r0 == 0) goto L8
            r0.viewDraw(r5, r6)     // Catch: java.lang.Exception -> L96
            goto Lf
        L8:
            com.vivo.advv.vaf.virtualview.util.ShowGifDelegate r0 = r5.mBgShowGifDelegate     // Catch: java.lang.Exception -> L96
            if (r0 == 0) goto Lf
            r0.viewDraw(r5, r6)     // Catch: java.lang.Exception -> L96
        Lf:
            int r0 = r5.mBorderTopLeftRadius     // Catch: java.lang.Exception -> L96
            if (r0 != 0) goto L23
            int r1 = r5.mBorderTopRightRadius     // Catch: java.lang.Exception -> L96
            if (r1 != 0) goto L23
            int r1 = r5.mBorderBottomLeftRadius     // Catch: java.lang.Exception -> L96
            if (r1 != 0) goto L23
            int r1 = r5.mBorderBottomRightRadius     // Catch: java.lang.Exception -> L96
            if (r1 != 0) goto L23
            super.draw(r6)     // Catch: java.lang.Exception -> L96
            return
        L23:
            float[] r1 = r5.mCorners     // Catch: java.lang.Exception -> L96
            r2 = 1
            if (r1 != 0) goto L53
            r1 = 8
            float[] r1 = new float[r1]     // Catch: java.lang.Exception -> L96
            r3 = 0
            float r4 = (float) r0     // Catch: java.lang.Exception -> L96
            r1[r3] = r4     // Catch: java.lang.Exception -> L96
            float r0 = (float) r0     // Catch: java.lang.Exception -> L96
            r1[r2] = r0     // Catch: java.lang.Exception -> L96
            r0 = 2
            int r3 = r5.mBorderTopRightRadius     // Catch: java.lang.Exception -> L96
            float r3 = (float) r3     // Catch: java.lang.Exception -> L96
            r1[r0] = r3     // Catch: java.lang.Exception -> L96
            r0 = 3
            int r3 = r5.mBorderBottomRightRadius     // Catch: java.lang.Exception -> L96
            float r4 = (float) r3     // Catch: java.lang.Exception -> L96
            r1[r0] = r4     // Catch: java.lang.Exception -> L96
            r0 = 4
            float r4 = (float) r3     // Catch: java.lang.Exception -> L96
            r1[r0] = r4     // Catch: java.lang.Exception -> L96
            r0 = 5
            float r3 = (float) r3     // Catch: java.lang.Exception -> L96
            r1[r0] = r3     // Catch: java.lang.Exception -> L96
            r0 = 6
            int r3 = r5.mBorderBottomLeftRadius     // Catch: java.lang.Exception -> L96
            float r4 = (float) r3     // Catch: java.lang.Exception -> L96
            r1[r0] = r4     // Catch: java.lang.Exception -> L96
            r0 = 7
            float r3 = (float) r3     // Catch: java.lang.Exception -> L96
            r1[r0] = r3     // Catch: java.lang.Exception -> L96
            r5.mCorners = r1     // Catch: java.lang.Exception -> L96
        L53:
            android.graphics.drawable.Drawable r0 = r5.getDrawable()     // Catch: java.lang.Exception -> L96
            if (r0 != 0) goto L79
            android.graphics.drawable.Drawable r0 = r5.getBackground()     // Catch: java.lang.Exception -> L96
            if (r0 != 0) goto L79
            com.vivo.advv.vaf.virtualview.util.ShowGifDelegate r0 = r5.mSrcShowGifDelegate     // Catch: java.lang.Exception -> L96
            if (r0 == 0) goto L68
            boolean r0 = r0.isDecodeMovie()     // Catch: java.lang.Exception -> L96
            goto L70
        L68:
            com.vivo.advv.vaf.virtualview.util.ShowGifDelegate r0 = r5.mBgShowGifDelegate     // Catch: java.lang.Exception -> L96
            if (r0 == 0) goto L72
            boolean r0 = r0.isDecodeMovie()     // Catch: java.lang.Exception -> L96
        L70:
            r0 = r0 ^ r2
            goto L73
        L72:
            r0 = 1
        L73:
            if (r0 == 0) goto L79
            super.draw(r6)     // Catch: java.lang.Exception -> L96
            return
        L79:
            boolean r0 = r6.isHardwareAccelerated()     // Catch: java.lang.Exception -> L96
            if (r0 == 0) goto L89
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L96
            r1 = 18
            if (r0 >= r1) goto L89
            r0 = 0
            r5.setLayerType(r2, r0)     // Catch: java.lang.Exception -> L96
        L89:
            float[] r0 = r5.mCorners     // Catch: java.lang.Exception -> L96
            com.vivo.advv.vaf.virtualview.view.image.RoundViewDelegate r1 = r5.mRoundViewDelegate     // Catch: java.lang.Exception -> L96
            r1.canvasSetLayer(r6, r0)     // Catch: java.lang.Exception -> L96
            super.draw(r6)     // Catch: java.lang.Exception -> L96
            r6.restore()     // Catch: java.lang.Exception -> L96
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.view.image.NativeImageImp.draw(android.graphics.Canvas):void");
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public View getHolderView() {
        return this;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public int getType() {
        return -1;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public ViewBase getVirtualView() {
        return this.mVirtualView;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        measure(i2, i3);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    @SuppressLint({"WrongCall"})
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        onLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    @SuppressLint({"WrongCall"})
    public void onComMeasure(int i2, int i3) {
        onMeasure(i2, i3);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean viewOnDraw;
        ShowGifDelegate showGifDelegate = this.mSrcShowGifDelegate;
        if (showGifDelegate != null) {
            viewOnDraw = showGifDelegate.viewOnDraw(this, canvas);
        } else {
            ShowGifDelegate showGifDelegate2 = this.mBgShowGifDelegate;
            viewOnDraw = showGifDelegate2 != null ? showGifDelegate2.viewOnDraw(this, canvas) : false;
        }
        if (viewOnDraw) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        int width = getWidth();
        int height = getHeight();
        ShowGifDelegate showGifDelegate = this.mSrcShowGifDelegate;
        if (showGifDelegate != null) {
            showGifDelegate.viewOnLayout(this, z, i2, i3, i4, i5, width, height);
        } else {
            ShowGifDelegate showGifDelegate2 = this.mBgShowGifDelegate;
            if (showGifDelegate2 != null) {
                showGifDelegate2.viewOnLayout(this, z, i2, i3, i4, i5, width, height);
            }
        }
        this.mRoundViewDelegate.roundRectSet(width, height);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        ShowGifDelegate showGifDelegate = this.mSrcShowGifDelegate;
        if (showGifDelegate != null) {
            showGifDelegate.viewOnMeasure(this, i2, i3);
            return;
        }
        ShowGifDelegate showGifDelegate2 = this.mBgShowGifDelegate;
        if (showGifDelegate2 != null) {
            showGifDelegate2.viewOnMeasure(this, i2, i3);
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i2) {
        super.onScreenStateChanged(i2);
        ShowGifDelegate showGifDelegate = this.mSrcShowGifDelegate;
        if (showGifDelegate != null) {
            showGifDelegate.viewOnScreenStateChanged(this, i2);
            return;
        }
        ShowGifDelegate showGifDelegate2 = this.mBgShowGifDelegate;
        if (showGifDelegate2 != null) {
            showGifDelegate2.viewOnScreenStateChanged(this, i2);
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        ShowGifDelegate showGifDelegate = this.mSrcShowGifDelegate;
        if (showGifDelegate != null) {
            showGifDelegate.viewOnVisibilityChanged(view, i2);
            return;
        }
        ShowGifDelegate showGifDelegate2 = this.mBgShowGifDelegate;
        if (showGifDelegate2 != null) {
            showGifDelegate2.viewOnVisibilityChanged(view, i2);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        ShowGifDelegate showGifDelegate = this.mSrcShowGifDelegate;
        if (showGifDelegate != null) {
            showGifDelegate.viewOnWindowVisibilityChanged(this, i2);
            return;
        }
        ShowGifDelegate showGifDelegate2 = this.mBgShowGifDelegate;
        if (showGifDelegate2 != null) {
            showGifDelegate2.viewOnWindowVisibilityChanged(this, i2);
        }
    }

    public void setBorderBottomLeftRadius(int i2) {
        this.mBorderBottomLeftRadius = i2;
    }

    public void setBorderBottomRightRadius(int i2) {
        this.mBorderBottomRightRadius = i2;
    }

    public void setBorderTopLeftRadius(int i2) {
        this.mBorderTopLeftRadius = i2;
    }

    public void setBorderTopRightRadius(int i2) {
        this.mBorderTopRightRadius = i2;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IContainer
    public void setVirtualView(ViewBase viewBase, IActionListener iActionListener) {
        this.mVirtualView = viewBase;
        viewBase.setHoldView(this);
        new ClickHelper(this, iActionListener);
    }
}
