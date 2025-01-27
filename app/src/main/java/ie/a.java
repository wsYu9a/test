package ie;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: d */
    public static final int f26982d = Integer.MIN_VALUE;

    /* renamed from: e */
    public static final int f26983e = 0;

    /* renamed from: f */
    public static final int f26984f = 1;

    /* renamed from: a */
    public final RecyclerView.LayoutManager f26985a;

    /* renamed from: b */
    public int f26986b;

    /* renamed from: c */
    public final Rect f26987c;

    /* renamed from: ie.a$a */
    public class C0712a extends a {
        public C0712a(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager);
        }

        @Override // ie.a
        public int d(View view) {
            return this.f26985a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
        }

        @Override // ie.a
        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f26985a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // ie.a
        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f26985a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // ie.a
        public int g(View view) {
            return this.f26985a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
        }

        @Override // ie.a
        public int h() {
            return this.f26985a.getWidth();
        }

        @Override // ie.a
        public int i() {
            return this.f26985a.getWidth() - this.f26985a.getPaddingRight();
        }

        @Override // ie.a
        public int j() {
            return this.f26985a.getPaddingRight();
        }

        @Override // ie.a
        public int k() {
            return this.f26985a.getWidthMode();
        }

        @Override // ie.a
        public int l() {
            return this.f26985a.getHeightMode();
        }

        @Override // ie.a
        public int m() {
            return this.f26985a.getPaddingLeft();
        }

        @Override // ie.a
        public int n() {
            return (this.f26985a.getWidth() - this.f26985a.getPaddingLeft()) - this.f26985a.getPaddingRight();
        }

        @Override // ie.a
        public int p() {
            return (this.f26985a.getHeight() - this.f26985a.getPaddingTop()) - this.f26985a.getPaddingBottom();
        }

        @Override // ie.a
        public int q(View view) {
            this.f26985a.getTransformedBoundingBox(view, true, this.f26987c);
            return this.f26987c.right;
        }

        @Override // ie.a
        public int r(View view) {
            this.f26985a.getTransformedBoundingBox(view, true, this.f26987c);
            return this.f26987c.left;
        }
    }

    public class b extends a {
        public b(RecyclerView.LayoutManager layoutManager) {
            super(layoutManager);
        }

        @Override // ie.a
        public int d(View view) {
            return this.f26985a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
        }

        @Override // ie.a
        public int e(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f26985a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // ie.a
        public int f(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f26985a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }

        @Override // ie.a
        public int g(View view) {
            return this.f26985a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // ie.a
        public int h() {
            return this.f26985a.getHeight();
        }

        @Override // ie.a
        public int i() {
            return this.f26985a.getHeight() - this.f26985a.getPaddingBottom();
        }

        @Override // ie.a
        public int j() {
            return this.f26985a.getPaddingBottom();
        }

        @Override // ie.a
        public int k() {
            return this.f26985a.getHeightMode();
        }

        @Override // ie.a
        public int l() {
            return this.f26985a.getWidthMode();
        }

        @Override // ie.a
        public int m() {
            return this.f26985a.getPaddingTop();
        }

        @Override // ie.a
        public int n() {
            return (this.f26985a.getHeight() - this.f26985a.getPaddingTop()) - this.f26985a.getPaddingBottom();
        }

        @Override // ie.a
        public int p() {
            return (this.f26985a.getWidth() - this.f26985a.getPaddingLeft()) - this.f26985a.getPaddingRight();
        }

        @Override // ie.a
        public int q(View view) {
            this.f26985a.getTransformedBoundingBox(view, true, this.f26987c);
            return this.f26987c.bottom;
        }

        @Override // ie.a
        public int r(View view) {
            this.f26985a.getTransformedBoundingBox(view, true, this.f26987c);
            return this.f26987c.top;
        }
    }

    public /* synthetic */ a(RecyclerView.LayoutManager layoutManager, ie.b bVar) {
        this(layoutManager);
    }

    public static a a(RecyclerView.LayoutManager layoutManager) {
        return new C0712a(layoutManager);
    }

    public static a b(RecyclerView.LayoutManager layoutManager, int i10) {
        if (i10 == 0) {
            return a(layoutManager);
        }
        if (i10 == 1) {
            return c(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static a c(RecyclerView.LayoutManager layoutManager) {
        return new b(layoutManager);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f26986b) {
            return 0;
        }
        return n() - this.f26986b;
    }

    public abstract int p();

    public abstract int q(View view);

    public abstract int r(View view);

    public void s() {
        this.f26986b = n();
    }

    public a(RecyclerView.LayoutManager layoutManager) {
        this.f26986b = Integer.MIN_VALUE;
        this.f26987c = new Rect();
        this.f26985a = layoutManager;
    }
}
