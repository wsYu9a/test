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

/* loaded from: classes3.dex */
public class KSRatingBar extends LinearLayout {
    private boolean aXm;
    private boolean aXn;
    private int aXo;
    private int aXp;
    private a aXq;
    private float aXr;
    private float aXs;
    private float aXt;
    private Drawable aXu;
    private Drawable aXv;
    private Drawable aXw;
    private boolean aXx;

    /* renamed from: y */
    private int f11982y;

    /* renamed from: com.kwad.sdk.widget.KSRatingBar$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (KSRatingBar.this.aXm) {
                if (!KSRatingBar.this.aXn) {
                    KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                    if (KSRatingBar.this.aXq != null) {
                        a unused = KSRatingBar.this.aXq;
                        KSRatingBar.this.indexOfChild(view);
                        return;
                    }
                    return;
                }
                if (KSRatingBar.this.f11982y % 2 == 0) {
                    KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                } else {
                    KSRatingBar.this.setStar(r0.indexOfChild(view) + 0.5f);
                }
                if (KSRatingBar.this.aXq != null) {
                    if (KSRatingBar.this.f11982y % 2 == 0) {
                        a unused2 = KSRatingBar.this.aXq;
                        KSRatingBar.this.indexOfChild(view);
                        KSRatingBar.e(KSRatingBar.this);
                    } else {
                        a unused3 = KSRatingBar.this.aXq;
                        KSRatingBar.this.indexOfChild(view);
                        KSRatingBar.e(KSRatingBar.this);
                    }
                }
            }
        }
    }

    public interface a {
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11982y = 1;
        this.aXx = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.aXw = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.aXu = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.aXv = obtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.aXr = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.aXs = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.aXt = obtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.aXo = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.aXp = obtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.aXm = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.aXn = obtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i10 = 0; i10 < this.aXo; i10++) {
            ImageView w10 = w(context, this.aXx);
            w10.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                public AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (KSRatingBar.this.aXm) {
                        if (!KSRatingBar.this.aXn) {
                            KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                            if (KSRatingBar.this.aXq != null) {
                                a unused = KSRatingBar.this.aXq;
                                KSRatingBar.this.indexOfChild(view);
                                return;
                            }
                            return;
                        }
                        if (KSRatingBar.this.f11982y % 2 == 0) {
                            KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                        } else {
                            KSRatingBar.this.setStar(r0.indexOfChild(view) + 0.5f);
                        }
                        if (KSRatingBar.this.aXq != null) {
                            if (KSRatingBar.this.f11982y % 2 == 0) {
                                a unused2 = KSRatingBar.this.aXq;
                                KSRatingBar.this.indexOfChild(view);
                                KSRatingBar.e(KSRatingBar.this);
                            } else {
                                a unused3 = KSRatingBar.this.aXq;
                                KSRatingBar.this.indexOfChild(view);
                                KSRatingBar.e(KSRatingBar.this);
                            }
                        }
                    }
                }
            });
            addView(w10);
        }
        setStar(this.aXp);
    }

    public static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i10 = kSRatingBar.f11982y;
        kSRatingBar.f11982y = i10 + 1;
        return i10;
    }

    private ImageView w(Context context, boolean z10) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.aXr), Math.round(this.aXs)));
        imageView.setPadding(0, 0, Math.round(this.aXt), 0);
        if (z10) {
            imageView.setImageDrawable(this.aXu);
        } else {
            imageView.setImageDrawable(this.aXv);
        }
        return imageView;
    }

    public void setImagePadding(float f10) {
        this.aXt = f10;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.aXq = aVar;
    }

    public void setStar(float f10) {
        int i10 = (int) f10;
        float floatValue = new BigDecimal(Float.toString(f10)).subtract(new BigDecimal(Integer.toString(i10))).floatValue();
        int i11 = this.aXo;
        float f11 = i10 > i11 ? i11 : i10;
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        for (int i12 = 0; i12 < f11; i12++) {
            ((ImageView) getChildAt(i12)).setImageDrawable(this.aXv);
        }
        if (floatValue > 0.0f) {
            ((ImageView) getChildAt(i10)).setImageDrawable(this.aXw);
            int i13 = this.aXo;
            while (true) {
                i13--;
                if (i13 < 1.0f + f11) {
                    return;
                } else {
                    ((ImageView) getChildAt(i13)).setImageDrawable(this.aXu);
                }
            }
        } else {
            int i14 = this.aXo;
            while (true) {
                i14--;
                if (i14 < f11) {
                    return;
                } else {
                    ((ImageView) getChildAt(i14)).setImageDrawable(this.aXu);
                }
            }
        }
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.aXu = drawable;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.aXv = drawable;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.aXw = drawable;
    }

    public void setStarImageHeight(float f10) {
        this.aXs = f10;
    }

    public void setStarImageWidth(float f10) {
        this.aXr = f10;
    }

    public void setTotalStarCount(int i10) {
        this.aXo = i10;
    }

    public void setmClickable(boolean z10) {
        this.aXm = z10;
    }
}
