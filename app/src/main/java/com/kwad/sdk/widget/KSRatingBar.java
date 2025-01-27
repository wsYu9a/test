package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import java.math.BigDecimal;

/* loaded from: classes2.dex */
public class KSRatingBar extends LinearLayout {
    private boolean aCY;
    private boolean aCZ;
    private int aDa;
    private int aDb;
    private a aDc;
    private float aDd;
    private float aDe;
    private float aDf;
    private Drawable aDg;
    private Drawable aDh;
    private Drawable aDi;
    private boolean aDj;
    private int y;

    /* renamed from: com.kwad.sdk.widget.KSRatingBar$1 */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (KSRatingBar.this.aCY) {
                if (!KSRatingBar.this.aCZ) {
                    KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                    if (KSRatingBar.this.aDc != null) {
                        a unused = KSRatingBar.this.aDc;
                        KSRatingBar.this.indexOfChild(view);
                        return;
                    }
                    return;
                }
                if (KSRatingBar.this.y % 2 == 0) {
                    KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                } else {
                    KSRatingBar.this.setStar(r0.indexOfChild(view) + 0.5f);
                }
                if (KSRatingBar.this.aDc != null) {
                    int i2 = KSRatingBar.this.y % 2;
                    a unused2 = KSRatingBar.this.aDc;
                    KSRatingBar.this.indexOfChild(view);
                    KSRatingBar.e(KSRatingBar.this);
                }
            }
        }
    }

    public interface a {
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 1;
        this.aDj = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.aDi = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.aDg = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.aDh = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.aDd = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.aDe = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.aDf = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.aDa = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.aDb = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.aCY = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.aCZ = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i2 = 0; i2 < this.aDa; i2++) {
            ImageView w = w(context, this.aDj);
            w.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (KSRatingBar.this.aCY) {
                        if (!KSRatingBar.this.aCZ) {
                            KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                            if (KSRatingBar.this.aDc != null) {
                                a unused = KSRatingBar.this.aDc;
                                KSRatingBar.this.indexOfChild(view);
                                return;
                            }
                            return;
                        }
                        if (KSRatingBar.this.y % 2 == 0) {
                            KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                        } else {
                            KSRatingBar.this.setStar(r0.indexOfChild(view) + 0.5f);
                        }
                        if (KSRatingBar.this.aDc != null) {
                            int i22 = KSRatingBar.this.y % 2;
                            a unused2 = KSRatingBar.this.aDc;
                            KSRatingBar.this.indexOfChild(view);
                            KSRatingBar.e(KSRatingBar.this);
                        }
                    }
                }
            });
            addView(w);
        }
        setStar(this.aDb);
    }

    static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i2 = kSRatingBar.y;
        kSRatingBar.y = i2 + 1;
        return i2;
    }

    private ImageView w(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.aDd), Math.round(this.aDe)));
        imageView.setPadding(0, 0, Math.round(this.aDf), 0);
        imageView.setImageDrawable(z ? this.aDg : this.aDh);
        return imageView;
    }

    public void setImagePadding(float f2) {
        this.aDf = f2;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.aDc = aVar;
    }

    public void setStar(float f2) {
        int i2 = (int) f2;
        float floatValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Integer.toString(i2))).floatValue();
        int i3 = this.aDa;
        float f3 = i2 > i3 ? i3 : i2;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        for (int i4 = 0; i4 < f3; i4++) {
            ((ImageView) getChildAt(i4)).setImageDrawable(this.aDh);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i2)).setImageDrawable(this.aDi);
            int i5 = this.aDa;
            while (true) {
                i5--;
                if (i5 < 1.0f + f3) {
                    return;
                } else {
                    ((ImageView) getChildAt(i5)).setImageDrawable(this.aDg);
                }
            }
        } else {
            int i6 = this.aDa;
            while (true) {
                i6--;
                if (i6 < f3) {
                    return;
                } else {
                    ((ImageView) getChildAt(i6)).setImageDrawable(this.aDg);
                }
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.aDg = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.aDh = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.aDi = drawable;
    }

    public void setStarImageHeight(float f2) {
        this.aDe = f2;
    }

    public void setStarImageWidth(float f2) {
        this.aDd = f2;
    }

    public void setTotalStarCount(int i2) {
        this.aDa = i2;
    }

    public void setmClickable(boolean z) {
        this.aCY = z;
    }
}
