package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Placeholder extends View {

    /* renamed from: a */
    private int f1341a;

    /* renamed from: b */
    private View f1342b;

    /* renamed from: c */
    private int f1343c;

    public Placeholder(Context context) {
        super(context);
        this.f1341a = -1;
        this.f1342b = null;
        this.f1343c = 4;
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        super.setVisibility(this.f1343c);
        this.f1341a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_placeholder_content) {
                    this.f1341a = obtainStyledAttributes.getResourceId(index, this.f1341a);
                } else if (index == R.styleable.ConstraintLayout_placeholder_emptyVisibility) {
                    this.f1343c = obtainStyledAttributes.getInt(index, this.f1343c);
                }
            }
        }
    }

    public View getContent() {
        return this.f1342b;
    }

    public int getEmptyVisibility() {
        return this.f1343c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i2) {
        View findViewById;
        if (this.f1341a == i2) {
            return;
        }
        View view = this.f1342b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.f1342b.getLayoutParams()).f1324h = false;
            this.f1342b = null;
        }
        this.f1341a = i2;
        if (i2 == -1 || (findViewById = ((View) getParent()).findViewById(i2)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i2) {
        this.f1343c = i2;
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
        if (this.f1342b == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f1342b.getLayoutParams();
        layoutParams2.s.setVisibility(0);
        layoutParams.s.setWidth(layoutParams2.s.getWidth());
        layoutParams.s.setHeight(layoutParams2.s.getHeight());
        layoutParams2.s.setVisibility(8);
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        if (this.f1341a == -1 && !isInEditMode()) {
            setVisibility(this.f1343c);
        }
        View findViewById = constraintLayout.findViewById(this.f1341a);
        this.f1342b = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.LayoutParams) findViewById.getLayoutParams()).f1324h = true;
            this.f1342b.setVisibility(0);
            setVisibility(0);
        }
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1341a = -1;
        this.f1342b = null;
        this.f1343c = 4;
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1341a = -1;
        this.f1342b = null;
        this.f1343c = 4;
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.f1341a = -1;
        this.f1342b = null;
        this.f1343c = 4;
        a(attributeSet);
    }
}
