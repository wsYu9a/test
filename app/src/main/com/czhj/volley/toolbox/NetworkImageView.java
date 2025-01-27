package com.czhj.volley.toolbox;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.ImageLoader;

/* loaded from: classes2.dex */
public class NetworkImageView extends ImageView {

    /* renamed from: a */
    public String f8819a;

    /* renamed from: b */
    public int f8820b;

    /* renamed from: c */
    public int f8821c;

    /* renamed from: d */
    public ImageLoader f8822d;

    /* renamed from: e */
    public ImageLoader.ImageContainer f8823e;

    /* renamed from: com.czhj.volley.toolbox.NetworkImageView$1 */
    public class AnonymousClass1 implements ImageLoader.ImageListener {

        /* renamed from: a */
        public final /* synthetic */ boolean f8824a;

        /* renamed from: com.czhj.volley.toolbox.NetworkImageView$1$1 */
        public class RunnableC02541 implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ ImageLoader.ImageContainer f8826a;

            public RunnableC02541(ImageLoader.ImageContainer imageContainer) {
                imageContainer = imageContainer;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass1.this.onResponse(imageContainer, false);
            }
        }

        public AnonymousClass1(boolean z10) {
            this.f8824a = z10;
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            if (NetworkImageView.this.f8821c != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f8821c);
            }
        }

        @Override // com.czhj.volley.toolbox.ImageLoader.ImageListener
        public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z10) {
            if (z10 && this.f8824a) {
                NetworkImageView.this.post(new Runnable() { // from class: com.czhj.volley.toolbox.NetworkImageView.1.1

                    /* renamed from: a */
                    public final /* synthetic */ ImageLoader.ImageContainer f8826a;

                    public RunnableC02541(ImageLoader.ImageContainer imageContainer2) {
                        imageContainer = imageContainer2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.onResponse(imageContainer, false);
                    }
                });
                return;
            }
            if (imageContainer2.getBitmap() != null) {
                NetworkImageView.this.setImageBitmap(imageContainer2.getBitmap());
            } else if (NetworkImageView.this.f8820b != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f8820b);
            }
        }
    }

    public NetworkImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        ImageLoader.ImageContainer imageContainer = this.f8823e;
        if (imageContainer != null) {
            imageContainer.cancelRequest();
            setImageBitmap(null);
            this.f8823e = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        a(true);
    }

    public void setDefaultImageResId(int i10) {
        this.f8820b = i10;
    }

    public void setErrorImageResId(int i10) {
        this.f8821c = i10;
    }

    public void setImageUrl(String str, ImageLoader imageLoader) {
        Threads.a();
        this.f8819a = str;
        this.f8822d = imageLoader;
        a(false);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r9) {
        /*
            r8 = this;
            int r0 = r8.getWidth()
            int r1 = r8.getHeight()
            android.widget.ImageView$ScaleType r7 = r8.getScaleType()
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L2c
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            int r2 = r2.width
            r5 = -2
            if (r2 != r5) goto L1f
            r2 = 1
            goto L20
        L1f:
            r2 = 0
        L20:
            android.view.ViewGroup$LayoutParams r6 = r8.getLayoutParams()
            int r6 = r6.height
            if (r6 != r5) goto L2a
            r5 = 1
            goto L2e
        L2a:
            r5 = 0
            goto L2e
        L2c:
            r2 = 0
            goto L2a
        L2e:
            if (r2 == 0) goto L33
            if (r5 == 0) goto L33
            goto L34
        L33:
            r3 = 0
        L34:
            if (r0 != 0) goto L3b
            if (r1 != 0) goto L3b
            if (r3 != 0) goto L3b
            return
        L3b:
            java.lang.String r3 = r8.f8819a
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L51
            com.czhj.volley.toolbox.ImageLoader$ImageContainer r9 = r8.f8823e
            if (r9 == 0) goto L4d
            r9.cancelRequest()
            r9 = 0
            r8.f8823e = r9
        L4d:
            r8.a()
            return
        L51:
            com.czhj.volley.toolbox.ImageLoader$ImageContainer r3 = r8.f8823e
            if (r3 == 0) goto L72
            java.lang.String r3 = r3.getRequestUrl()
            if (r3 == 0) goto L72
            com.czhj.volley.toolbox.ImageLoader$ImageContainer r3 = r8.f8823e
            java.lang.String r3 = r3.getRequestUrl()
            java.lang.String r6 = r8.f8819a
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L6a
            return
        L6a:
            com.czhj.volley.toolbox.ImageLoader$ImageContainer r3 = r8.f8823e
            r3.cancelRequest()
            r8.a()
        L72:
            if (r2 == 0) goto L75
            r0 = 0
        L75:
            if (r5 == 0) goto L79
            r6 = 0
            goto L7a
        L79:
            r6 = r1
        L7a:
            com.czhj.volley.toolbox.ImageLoader r2 = r8.f8822d
            java.lang.String r3 = r8.f8819a
            com.czhj.volley.toolbox.NetworkImageView$1 r4 = new com.czhj.volley.toolbox.NetworkImageView$1
            r4.<init>(r9)
            r5 = r0
            com.czhj.volley.toolbox.ImageLoader$ImageContainer r9 = r2.get(r3, r4, r5, r6, r7)
            r8.f8823e = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.volley.toolbox.NetworkImageView.a(boolean):void");
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public final void a() {
        int i10 = this.f8820b;
        if (i10 != 0) {
            setImageResource(i10);
        } else {
            setImageBitmap(null);
        }
    }
}
