package com.opos.exoplayer.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.f.j;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class d extends View implements j {

    /* renamed from: a */
    private final List<e> f17473a;

    /* renamed from: b */
    private List<com.opos.exoplayer.core.f.b> f17474b;

    /* renamed from: c */
    private int f17475c;

    /* renamed from: d */
    private float f17476d;

    /* renamed from: e */
    private boolean f17477e;

    /* renamed from: f */
    private boolean f17478f;

    /* renamed from: g */
    private com.opos.exoplayer.core.f.a f17479g;

    /* renamed from: h */
    private float f17480h;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17473a = new ArrayList();
        this.f17475c = 0;
        this.f17476d = 0.0533f;
        this.f17477e = true;
        this.f17478f = true;
        this.f17479g = com.opos.exoplayer.core.f.a.f18552a;
        this.f17480h = 0.08f;
    }

    private void a(int i2, float f2) {
        if (this.f17475c == i2 && this.f17476d == f2) {
            return;
        }
        this.f17475c = i2;
        this.f17476d = f2;
        invalidate();
    }

    @TargetApi(19)
    private float c() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    @TargetApi(19)
    private com.opos.exoplayer.core.f.a d() {
        return com.opos.exoplayer.core.f.a.a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }

    public void a() {
        a(((u.f19078a < 19 || isInEditMode()) ? 1.0f : c()) * 0.0533f);
    }

    public void a(float f2) {
        a(f2, false);
    }

    public void a(float f2, boolean z) {
        a(z ? 1 : 0, f2);
    }

    public void a(com.opos.exoplayer.core.f.a aVar) {
        if (this.f17479g == aVar) {
            return;
        }
        this.f17479g = aVar;
        invalidate();
    }

    @Override // com.opos.exoplayer.core.f.j
    public void a(List<com.opos.exoplayer.core.f.b> list) {
        b(list);
    }

    public void b() {
        a((u.f19078a < 19 || isInEditMode()) ? com.opos.exoplayer.core.f.a.f18552a : d());
    }

    public void b(@Nullable List<com.opos.exoplayer.core.f.b> list) {
        if (this.f17474b == list) {
            return;
        }
        this.f17474b = list;
        int size = list == null ? 0 : list.size();
        while (this.f17473a.size() < size) {
            this.f17473a.add(new e(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f2;
        List<com.opos.exoplayer.core.f.b> list = this.f17474b;
        int i2 = 0;
        int size = list == null ? 0 : list.size();
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = getPaddingTop() + top;
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom <= paddingTop || right <= left) {
            return;
        }
        int i3 = this.f17475c;
        if (i3 == 2) {
            f2 = this.f17476d;
        } else {
            f2 = (i3 == 0 ? paddingBottom - paddingTop : bottom - top) * this.f17476d;
        }
        if (f2 > 0.0f) {
            while (i2 < size) {
                int i4 = paddingBottom;
                int i5 = right;
                this.f17473a.get(i2).a(this.f17474b.get(i2), this.f17477e, this.f17478f, this.f17479g, f2, this.f17480h, canvas, left, paddingTop, i5, i4);
                i2++;
                paddingBottom = i4;
                right = i5;
            }
        }
    }
}
