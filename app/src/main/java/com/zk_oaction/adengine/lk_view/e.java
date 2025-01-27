package com.zk_oaction.adengine.lk_view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.cdo.oaps.ad.OapsKey;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class e extends com.zk_oaction.adengine.lk_view.b {
    ViewTreeObserver.OnGlobalLayoutListener V;
    private com.zk_oaction.adengine.lk_interfaces.b W;
    private boolean a0;
    private int b0;
    private Rect c0;
    private b d0;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                com.zk_oaction.adengine.lk_sdk.c cVar = e.this.v;
                if (cVar == null || cVar.G == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(e.this.w)) {
                    hashMap.put("name", e.this.w);
                }
                hashMap.put("type", "onGlobalLayout");
                e eVar = e.this;
                eVar.v.G.b(eVar, hashMap);
                e.this.getViewTreeObserver().removeOnGlobalLayoutListener(e.this.V);
                e.this.V = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public interface b {
        void a(View view, int i2);
    }

    public e(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar);
        this.a0 = true;
        this.b0 = 4;
        this.c0 = null;
    }

    private Rect R(View view) {
        if (view instanceof com.zk_oaction.adengine.lk_view.b) {
            return this.v.b((com.zk_oaction.adengine.lk_view.b) view);
        }
        if (view instanceof c) {
            return this.v.c((c) view);
        }
        return null;
    }

    private boolean S(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.c0 = R(this.v.B("jump"));
        }
        Rect rect = this.c0;
        if (rect != null) {
            return rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return false;
    }

    private void U(String str) {
        try {
            if (TextUtils.isEmpty(str) || !"1".equals(str)) {
                return;
            }
            this.V = new a();
            getViewTreeObserver().addOnGlobalLayoutListener(this.V);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean T(XmlPullParser xmlPullParser, String str) {
        try {
            s(xmlPullParser);
            U(xmlPullParser.getAttributeValue(null, "viewlistener"));
            String attributeValue = xmlPullParser.getAttributeValue(null, OapsKey.KEY_BG);
            if (attributeValue != null) {
                if (attributeValue.charAt(0) == '#') {
                    setBackgroundColor(Color.parseColor(attributeValue));
                } else {
                    this.W = this.v.g(attributeValue, this, 3);
                }
            }
            return t(xmlPullParser, str);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.zk_oaction.adengine.lk_view.b, com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void c(String str) {
        boolean z;
        if (str.equals("true")) {
            this.a0 = true;
            return;
        }
        if (str.equals("false")) {
            z = false;
        } else if (!str.equals("toggle")) {
            return;
        } else {
            z = !this.a0;
        }
        this.a0 = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a0 && !S(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.zk_oaction.adengine.lk_interfaces.b bVar = this.W;
        if (bVar != null && bVar.b() != null) {
            canvas.drawBitmap(this.W.b(), 0.0f, 0.0f, (Paint) null);
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    public boolean isClickable() {
        return this.a0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d0 = null;
        try {
            if (getChildCount() > 0) {
                removeAllViews();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        int visibility = getVisibility();
        this.b0 = visibility;
        b bVar = this.d0;
        if (bVar != null) {
            bVar.a(view, visibility);
        }
    }
}
