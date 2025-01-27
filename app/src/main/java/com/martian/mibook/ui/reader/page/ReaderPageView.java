package com.martian.mibook.ui.reader.page;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Magnifier;
import android.widget.PopupWindow;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import ba.m;
import com.google.android.material.badge.BadgeDrawable;
import com.martian.mibook.R;
import com.martian.mibook.data.book.CommentCount;
import com.martian.mibook.ui.reader.page.ActionMenu;
import com.martian.mibook.ui.reader.page.ReaderPageView;
import ge.d;
import ge.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class ReaderPageView extends View {
    public static final int A = 500;
    public static int B;
    public static int C;

    /* renamed from: b */
    public final int f16054b;

    /* renamed from: c */
    public final int f16055c;

    /* renamed from: d */
    public d f16056d;

    /* renamed from: e */
    public ActionMenu.a f16057e;

    /* renamed from: f */
    public PopupWindow f16058f;

    /* renamed from: g */
    public a f16059g;

    /* renamed from: h */
    public ActionMenu f16060h;

    /* renamed from: i */
    public Paint f16061i;

    /* renamed from: j */
    public boolean f16062j;

    /* renamed from: k */
    public boolean f16063k;

    /* renamed from: l */
    public float f16064l;

    /* renamed from: m */
    public float f16065m;

    /* renamed from: n */
    public boolean f16066n;

    /* renamed from: o */
    public int f16067o;

    /* renamed from: p */
    public int[] f16068p;

    /* renamed from: q */
    public Map<Integer, Rect> f16069q;

    /* renamed from: r */
    public List<CommentCount> f16070r;

    /* renamed from: s */
    public TextPaint f16071s;

    /* renamed from: t */
    public Drawable f16072t;

    /* renamed from: u */
    public Drawable f16073u;

    /* renamed from: v */
    public Magnifier f16074v;

    /* renamed from: w */
    public final Runnable f16075w;

    /* renamed from: x */
    public final View.OnClickListener f16076x;

    /* renamed from: y */
    public boolean f16077y;

    /* renamed from: z */
    public boolean f16078z;

    public interface a {
        void a(ReaderPageView readerPageView, int i10);
    }

    public ReaderPageView(Context context) {
        super(context);
        this.f16054b = 1;
        this.f16055c = 2;
        this.f16060h = null;
        this.f16062j = false;
        this.f16063k = false;
        this.f16066n = false;
        this.f16067o = 0;
        this.f16074v = null;
        this.f16075w = new Runnable() { // from class: ge.o
            public /* synthetic */ o() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReaderPageView.this.z();
            }
        };
        this.f16076x = new View.OnClickListener() { // from class: ge.p
            public /* synthetic */ p() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderPageView.this.A(view);
            }
        };
        this.f16077y = true;
        this.f16078z = true;
        x(context);
    }

    public static /* synthetic */ void B() {
    }

    private TextPaint getContentPaint() {
        d dVar = this.f16056d;
        if (dVar != null) {
            return dVar.f();
        }
        return null;
    }

    private TextPaint getTitlePaint() {
        d dVar = this.f16056d;
        if (dVar != null) {
            return dVar.x();
        }
        return null;
    }

    private void setContentColorInternal(int i10) {
        d dVar = this.f16056d;
        if (dVar != null) {
            dVar.N(i10);
        }
    }

    private void setTitleColorInternal(int i10) {
        d dVar = this.f16056d;
        if (dVar != null) {
            dVar.W(i10);
        }
    }

    public final /* synthetic */ void A(View view) {
        if (this.f16057e == null) {
            g();
            return;
        }
        int id2 = view.getId();
        ActionMenu.b bVar = null;
        ActionMenu.b bVar2 = (this.f16056d.w() == null || !this.f16056d.w().S()) ? null : new ActionMenu.b(this.f16056d.w().M(), this.f16056d.w().J(), this.f16056d.w().H());
        if (this.f16056d.e() != null && this.f16056d.e().S()) {
            bVar = new ActionMenu.b(this.f16056d.e().M(), this.f16056d.e().J(), this.f16056d.e().H());
        }
        ActionMenu.b bVar3 = bVar;
        if (id2 == R.id.reader_page_action_menu_comment) {
            this.f16057e.b(this, ActionMenu.ActionType.COMMENT, bVar2, bVar3, this.f16056d.t(), this.f16056d.r());
        } else if (id2 == R.id.reader_page_action_menu_copy) {
            this.f16057e.b(this, ActionMenu.ActionType.COPY, bVar2, bVar3, this.f16056d.t(), this.f16056d.r());
        } else if (id2 == R.id.reader_page_action_menu_tts) {
            this.f16057e.b(this, ActionMenu.ActionType.TTS, bVar2, bVar3, this.f16056d.t(), this.f16056d.r());
        } else if (id2 == R.id.reader_page_action_menu_underline) {
            this.f16057e.b(this, ActionMenu.ActionType.UNDERLINE, bVar2, bVar3, this.f16056d.t(), this.f16056d.r());
        } else if (id2 == R.id.reader_page_action_menu_del_underline) {
            this.f16057e.b(this, ActionMenu.ActionType.DEL_UNDERLINE, bVar2, bVar3, this.f16056d.t(), this.f16056d.r());
        } else if (id2 == R.id.reader_page_action_wrong_words_feedback) {
            this.f16057e.b(this, ActionMenu.ActionType.TYPO_FEEDBACK, bVar2, bVar3, this.f16056d.t(), this.f16056d.r());
        }
        g();
    }

    public final /* synthetic */ void C(float f10, float f11, boolean z10) {
        if (this.f16058f == null || this.f16060h == null) {
            return;
        }
        int m10 = m(f10);
        int n10 = n(f11, z10);
        int l10 = l(m10);
        this.f16060h.b(z10, l10);
        this.f16058f.update(m10 + l10, n10, -1, -1);
        this.f16060h.setVisibility(0);
    }

    public final void D(int i10) {
        a aVar = this.f16059g;
        if (aVar != null) {
            aVar.a(this, i10);
        }
    }

    public final boolean E(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z10 = true;
        if (action == 0) {
            this.f16064l = motionEvent.getX();
            this.f16065m = motionEvent.getY();
            this.f16066n = false;
            i(motionEvent.getX(), motionEvent.getY());
            return true;
        }
        if (action == 1) {
            removeCallbacks(this.f16075w);
            if (this.f16062j) {
                if (!this.f16063k) {
                    this.f16063k = true;
                } else if (this.f16067o == 0) {
                    g();
                } else {
                    S(motionEvent.getX(), motionEvent.getY());
                    w();
                    O();
                }
            } else if (this.f16066n) {
                z10 = false;
            } else {
                boolean z11 = false;
                for (Map.Entry<Integer, Rect> entry : this.f16069q.entrySet()) {
                    if (entry.getValue().contains((int) (motionEvent.getX() - getPaddingLeft()), (int) (motionEvent.getY() - getPaddingTop()))) {
                        D(entry.getKey().intValue());
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            this.f16067o = 0;
            getParent().requestDisallowInterceptTouchEvent(false);
            return z10;
        }
        if (action == 2) {
            if (Math.abs(motionEvent.getX() - this.f16064l) >= B || Math.abs(motionEvent.getY() - this.f16065m) >= B) {
                this.f16066n = true;
            }
            if (!this.f16066n) {
                return true;
            }
            removeCallbacks(this.f16075w);
            if (this.f16062j) {
                int i10 = this.f16067o;
                if (i10 == 1 || i10 == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    S(motionEvent.getX(), motionEvent.getY());
                    v();
                    return true;
                }
                getParent().requestDisallowInterceptTouchEvent(false);
                g();
            }
        } else if (action == 3) {
            removeCallbacks(this.f16075w);
            if (this.f16062j) {
                if (this.f16067o == 0) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    g();
                } else {
                    S(motionEvent.getX(), motionEvent.getY());
                    w();
                    O();
                }
            }
            this.f16067o = 0;
        }
        return false;
    }

    public void F(List<CommentCount> list) {
        d dVar = this.f16056d;
        if (dVar != null) {
            this.f16070r = dVar.C(list);
        }
    }

    public void G(TreeMap<Integer, CommentCount> treeMap) {
        d dVar = this.f16056d;
        if (dVar != null) {
            this.f16070r = dVar.C(treeMap.values());
        }
    }

    public void H() {
        d dVar = this.f16056d;
        if (dVar != null) {
            dVar.G();
        }
    }

    public void I() {
        d dVar = this.f16056d;
        if (dVar != null) {
            dVar.H();
        }
    }

    public void J(int i10, int i11) {
        d dVar = this.f16056d;
        if (dVar != null) {
            dVar.M(i10, i11);
        }
    }

    public void K(ActionMenu.b bVar, ActionMenu.b bVar2) {
        int i10;
        int i11;
        if (bVar != null) {
            i10 = bVar.b() - bVar.d().length();
            i11 = bVar.a() - bVar.d().length();
        } else {
            i10 = Integer.MIN_VALUE;
            i11 = Integer.MIN_VALUE;
        }
        if (bVar2 != null) {
            if (i10 == Integer.MIN_VALUE) {
                i10 = bVar2.b();
            }
            i11 = bVar2.a();
        }
        d dVar = this.f16056d;
        if (dVar != null) {
            dVar.M(i10, i11);
        }
    }

    public boolean L(int i10, int i11) {
        d dVar = this.f16056d;
        if (dVar != null) {
            return dVar.P(i10, i11);
        }
        return false;
    }

    public final boolean M(float f10, float f11) {
        d dVar = this.f16056d;
        if (dVar != null) {
            return dVar.U(f10 - getPaddingLeft(), f11 - getPaddingTop());
        }
        return false;
    }

    public boolean N(int i10, int i11) {
        d dVar = this.f16056d;
        if (dVar != null) {
            return dVar.V(i10, i11);
        }
        return false;
    }

    public final void O() {
        RectF u10 = this.f16056d.u();
        int a10 = m.a(getContext(), 52.0f);
        if (u10 != null && u10.top >= a10) {
            P(((u10.right + u10.left) / 2.0f) + getPaddingLeft(), u10.top + getPaddingTop(), true);
            return;
        }
        RectF s10 = this.f16056d.s();
        if (s10 != null && getHeight() - s10.bottom >= a10) {
            P(((s10.right + s10.left) / 2.0f) + getPaddingLeft(), s10.bottom + getPaddingTop(), false);
        } else if (s10 != null) {
            P(((s10.right + s10.left) / 2.0f) + getPaddingLeft(), s10.top + getPaddingTop(), true);
        }
    }

    public final void P(float f10, float f11, boolean z10) {
        y();
        if (this.f16058f == null) {
            PopupWindow popupWindow = new PopupWindow((View) this.f16060h, -2, -2, false);
            this.f16058f = popupWindow;
            popupWindow.setFocusable(false);
            this.f16058f.setOutsideTouchable(false);
            this.f16058f.setBackgroundDrawable(new ColorDrawable(0));
            this.f16058f.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ge.n
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    ReaderPageView.B();
                }
            });
        }
        if (this.f16058f.isShowing()) {
            this.f16058f.dismiss();
        }
        int m10 = m(f10);
        int n10 = n(f11, z10);
        int l10 = l(m10);
        this.f16060h.b(z10, l10);
        this.f16058f.showAtLocation(this, BadgeDrawable.TOP_START, m10 + l10, n10);
        if (this.f16060h.getWidth() == 0) {
            R(f10, f11, z10);
        }
    }

    public final void Q(float f10, float f11) {
        Magnifier.Builder size;
        Magnifier.Builder cornerRadius;
        Magnifier.Builder initialZoom;
        Magnifier.Builder defaultSourceToMagnifierOffset;
        Magnifier build;
        if (Build.VERSION.SDK_INT <= 28) {
            return;
        }
        if (this.f16074v == null) {
            int b10 = m.b(getResources(), 100.0f);
            int b11 = m.b(getResources(), 40.0f);
            size = l.a(this).setSize(b10, b10);
            cornerRadius = size.setCornerRadius(b10 / 2.0f);
            initialZoom = cornerRadius.setInitialZoom(1.0f);
            defaultSourceToMagnifierOffset = initialZoom.setDefaultSourceToMagnifierOffset(0, ((-b10) / 2) - b11);
            build = defaultSourceToMagnifierOffset.build();
            this.f16074v = build;
        }
        this.f16074v.show(f10, f11);
    }

    public final void R(float f10, float f11, boolean z10) {
        this.f16060h.setVisibility(4);
        post(new Runnable() { // from class: ge.m

            /* renamed from: c */
            public final /* synthetic */ float f26248c;

            /* renamed from: d */
            public final /* synthetic */ float f26249d;

            /* renamed from: e */
            public final /* synthetic */ boolean f26250e;

            public /* synthetic */ m(float f102, float f112, boolean z102) {
                f10 = f102;
                f11 = f112;
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReaderPageView.this.C(f10, f11, z10);
            }
        });
    }

    public final void S(float f10, float f11) {
        if (this.f16056d == null) {
            return;
        }
        int i10 = this.f16067o;
        if (i10 == 1) {
            Q(f10, f11);
            if (this.f16056d.c0(f10 - getPaddingLeft(), f11 - getPaddingTop()) == 2) {
                this.f16067o = 2;
                return;
            }
            return;
        }
        if (i10 == 2) {
            Q(f10, f11);
            if (this.f16056d.b0(f10 - getPaddingLeft(), f11 - getPaddingTop()) == 2) {
                this.f16067o = 1;
            }
        }
    }

    @Override // android.view.View
    public void cancelLongPress() {
        g();
        super.cancelLongPress();
    }

    public void e(ActionMenu.b bVar, ActionMenu.b bVar2) {
        int i10;
        int i11;
        if (bVar != null) {
            i10 = bVar.b() - bVar.d().length();
            i11 = bVar.a() - bVar.d().length();
        } else {
            i10 = Integer.MIN_VALUE;
            i11 = Integer.MIN_VALUE;
        }
        if (bVar2 != null) {
            if (i10 == Integer.MIN_VALUE) {
                i10 = bVar2.b();
            }
            i11 = bVar2.a();
        }
        d dVar = this.f16056d;
        if (dVar != null) {
            dVar.a(i10, i11);
        }
    }

    public boolean f(int i10, int i11) {
        d dVar = this.f16056d;
        if (dVar != null) {
            return dVar.a(i10, i11);
        }
        return false;
    }

    public final void g() {
        I();
        q();
        this.f16062j = false;
        this.f16063k = false;
    }

    public int getLayoutHeight() {
        d dVar = this.f16056d;
        if (dVar != null) {
            return dVar.i() + getPaddingTop();
        }
        return 0;
    }

    public int getPageHeight() {
        d dVar = this.f16056d;
        return dVar == null ? (getHeight() - getPaddingTop()) - getPaddingBottom() : dVar.l();
    }

    public d getPageLayout() {
        return this.f16056d;
    }

    public int getPageWidth() {
        d dVar = this.f16056d;
        return dVar == null ? (getWidth() - getPaddingLeft()) - getPaddingRight() : dVar.n();
    }

    public final boolean h(float f10, float f11) {
        removeCallbacks(this.f16075w);
        if (!M(f10, f11)) {
            return false;
        }
        this.f16062j = true;
        this.f16063k = false;
        getParent().requestDisallowInterceptTouchEvent(true);
        O();
        ActionMenu.a aVar = this.f16057e;
        if (aVar != null) {
            aVar.a(this);
        }
        return true;
    }

    public final void i(float f10, float f11) {
        int o10 = o(f10, f11);
        this.f16067o = o10;
        if (o10 != 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else {
            removeCallbacks(this.f16075w);
            postDelayed(this.f16075w, 500L);
        }
    }

    public void j() {
        this.f16070r = null;
    }

    public void k() {
        d dVar = this.f16056d;
        if (dVar != null) {
            dVar.b();
        }
    }

    public final int l(int i10) {
        int width = this.f16060h.getWidth();
        if (i10 < 0) {
            return -i10;
        }
        int i11 = getResources().getDisplayMetrics().widthPixels;
        if (i10 > i11 - width) {
            return (i11 - i10) - width;
        }
        return 0;
    }

    public final int m(float f10) {
        if (this.f16068p == null) {
            int[] iArr = new int[2];
            this.f16068p = iArr;
            getLocationOnScreen(iArr);
        }
        return (int) (f10 - (this.f16060h.getWidth() / 2.0f));
    }

    public final int n(float f10, boolean z10) {
        if (this.f16068p == null) {
            int[] iArr = new int[2];
            this.f16068p = iArr;
            getLocationOnScreen(iArr);
        }
        int a10 = m.a(getContext(), 5.0f);
        return (int) (z10 ? ((f10 - a10) + this.f16068p[1]) - this.f16060h.getHeight() : f10 + a10 + this.f16068p[1]);
    }

    public final int o(float f10, float f11) {
        if (!this.f16062j) {
            return 0;
        }
        RectF u10 = this.f16056d.u();
        if (u10 != null && new RectF((u10.left - C) + getPaddingLeft(), (u10.top - C) + getPaddingTop(), u10.left + C + getPaddingLeft(), u10.bottom + getPaddingTop()).contains(f10, f11)) {
            return 1;
        }
        RectF s10 = this.f16056d.s();
        return (s10 == null || !new RectF((s10.right - ((float) C)) + ((float) getPaddingLeft()), s10.top + ((float) getPaddingTop()), (s10.right + ((float) C)) + ((float) getPaddingLeft()), (s10.bottom + ((float) C)) + ((float) getPaddingTop())).contains(f10, f11)) ? 0 : 2;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        d dVar = this.f16056d;
        if (dVar != null) {
            dVar.c(canvas);
            r(canvas);
            if (this.f16062j) {
                RectF u10 = this.f16056d.u();
                if (u10 != null) {
                    s(canvas, u10.left, u10.top, u10.bottom, true);
                }
                RectF s10 = this.f16056d.s();
                if (s10 != null) {
                    s(canvas, s10.right, s10.top, s10.bottom, false);
                }
            }
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode != 1073741824) {
            d dVar = this.f16056d;
            size = (dVar != null ? dVar.n() : 0) + getPaddingLeft() + getPaddingRight();
        }
        if (mode2 != 1073741824) {
            d dVar2 = this.f16056d;
            size2 = getPaddingTop() + getPaddingBottom() + (dVar2 != null ? dVar2.i() : 0);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return E(motionEvent);
    }

    public final ActionMenu p() {
        ActionMenu actionMenu = new ActionMenu(getContext());
        actionMenu.setFocusable(false);
        actionMenu.setFocusableInTouchMode(false);
        actionMenu.setMenuItemClickListener(this.f16076x);
        return actionMenu;
    }

    public final void q() {
        PopupWindow popupWindow = this.f16058f;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.f16058f = null;
        }
    }

    public final void r(Canvas canvas) {
        this.f16069q.clear();
        List<CommentCount> list = this.f16070r;
        if (list == null || list.isEmpty()) {
            return;
        }
        int b10 = m.b(getResources(), 24.0f);
        for (CommentCount commentCount : this.f16070r) {
            Integer paragraphIdx = commentCount.getParagraphIdx();
            paragraphIdx.intValue();
            Rect o10 = this.f16056d.o(commentCount.getParagraphIdx().intValue(), b10);
            if (o10 != null) {
                Drawable t10 = t(commentCount.getHasComment() != null && commentCount.getHasComment().booleanValue());
                t10.setBounds(o10);
                t10.setColorFilter(new PorterDuffColorFilter(this.f16071s.getColor(), PorterDuff.Mode.SRC_ATOP));
                this.f16069q.put(paragraphIdx, o10);
                t10.draw(canvas);
                String str = commentCount.getNComments() > 99 ? "99+" : commentCount.getNComments() + "";
                float f10 = b10;
                canvas.drawText(str, o10.left + ((f10 - this.f16071s.measureText(str)) / 2.0f), (o10.top + ((f10 - Math.abs(this.f16071s.getFontMetrics().bottom - this.f16071s.getFontMetrics().top)) / 2.0f)) - this.f16071s.getFontMetrics().top, this.f16071s);
            }
        }
    }

    public final void s(Canvas canvas, float f10, float f11, float f12, boolean z10) {
        float a10 = m.a(getContext(), 2.0f);
        if (z10) {
            f10 -= a10;
        }
        float f13 = f10;
        float a11 = m.a(getContext(), 5.0f);
        canvas.drawCircle((a10 / 2.0f) + f13, z10 ? f11 - a11 : f12 + a11, a11, this.f16061i);
        canvas.drawRect(f13, f11, f13 + a10, f12, this.f16061i);
    }

    public void setActionMenuCallBack(ActionMenu.a aVar) {
        this.f16057e = aVar;
    }

    public void setActionMenuConfig(boolean z10) {
        this.f16077y = z10;
        this.f16078z = z10;
    }

    public void setContentColor(int i10) {
        setContentColorInternal(i10);
        invalidate();
    }

    public void setHighlightBgColor(int i10) {
        d dVar = this.f16056d;
        if (dVar != null) {
            dVar.Q(i10);
        }
        invalidate();
    }

    public void setOnParagraphCommentClickListener(a aVar) {
        this.f16059g = aVar;
    }

    public void setPageLayout(d dVar) {
        this.f16056d = dVar;
        if (dVar != null) {
            dVar.Z(this);
        }
        invalidate();
    }

    public void setParagraphCommentCountColor(int i10) {
        this.f16071s.setColor(i10);
    }

    public void setSelectionCursorColor(int i10) {
        this.f16061i.setColor(i10);
    }

    public void setTextColor(int i10) {
        setContentColorInternal(i10);
        setTitleColorInternal(i10);
        invalidate();
    }

    public void setTitleColor(int i10) {
        setTitleColorInternal(i10);
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        TextPaint titlePaint = getTitlePaint();
        if (titlePaint != null) {
            titlePaint.setTypeface(typeface);
        }
        TextPaint contentPaint = getContentPaint();
        if (contentPaint != null) {
            contentPaint.setTypeface(typeface);
        }
    }

    public void setUnderlineColor(int i10) {
        d dVar = this.f16056d;
        if (dVar != null) {
            dVar.X(i10);
        }
    }

    public final Drawable t(boolean z10) {
        if (z10) {
            if (this.f16073u == null) {
                this.f16073u = ResourcesCompat.getDrawable(getResources(), R.drawable.reader_page_paragraph_comment_posted, null);
            }
            return this.f16073u;
        }
        if (this.f16072t == null) {
            this.f16072t = ResourcesCompat.getDrawable(getResources(), R.drawable.reader_page_paragraph_comment, null);
        }
        return this.f16072t;
    }

    public int u(int i10) {
        d dVar = this.f16056d;
        if (dVar != null) {
            return dVar.p(i10);
        }
        return -1;
    }

    public final void v() {
        PopupWindow popupWindow = this.f16058f;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void w() {
        Magnifier magnifier;
        if (Build.VERSION.SDK_INT > 28 && (magnifier = this.f16074v) != null) {
            magnifier.dismiss();
        }
    }

    public final void x(Context context) {
        Paint paint = new Paint(1);
        this.f16061i = paint;
        paint.setStyle(Paint.Style.FILL);
        B = m.a(context, 10.0f);
        C = m.a(context, 20.0f);
        this.f16069q = new HashMap();
        TextPaint textPaint = new TextPaint(1);
        this.f16071s = textPaint;
        textPaint.setTextSize(m.a(context, 8.0f));
    }

    public final void y() {
        if (this.f16060h == null) {
            this.f16060h = p();
        }
        this.f16060h.d(this.f16056d.a0());
        this.f16060h.c(this.f16077y);
        this.f16060h.e(this.f16078z);
    }

    public final /* synthetic */ void z() {
        h(this.f16064l, this.f16065m);
    }

    public ReaderPageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16054b = 1;
        this.f16055c = 2;
        this.f16060h = null;
        this.f16062j = false;
        this.f16063k = false;
        this.f16066n = false;
        this.f16067o = 0;
        this.f16074v = null;
        this.f16075w = new Runnable() { // from class: ge.o
            public /* synthetic */ o() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReaderPageView.this.z();
            }
        };
        this.f16076x = new View.OnClickListener() { // from class: ge.p
            public /* synthetic */ p() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderPageView.this.A(view);
            }
        };
        this.f16077y = true;
        this.f16078z = true;
        x(context);
    }

    public ReaderPageView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16054b = 1;
        this.f16055c = 2;
        this.f16060h = null;
        this.f16062j = false;
        this.f16063k = false;
        this.f16066n = false;
        this.f16067o = 0;
        this.f16074v = null;
        this.f16075w = new Runnable() { // from class: ge.o
            public /* synthetic */ o() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReaderPageView.this.z();
            }
        };
        this.f16076x = new View.OnClickListener() { // from class: ge.p
            public /* synthetic */ p() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReaderPageView.this.A(view);
            }
        };
        this.f16077y = true;
        this.f16078z = true;
        x(context);
    }
}
