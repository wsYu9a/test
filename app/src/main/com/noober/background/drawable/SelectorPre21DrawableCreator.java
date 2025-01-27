package com.noober.background.drawable;

import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleableRes;
import com.noober.background.R;

/* loaded from: classes3.dex */
public class SelectorPre21DrawableCreator implements ICreateDrawable {
    private TypedArray typedArray;

    public SelectorPre21DrawableCreator(TypedArray typedArray) {
        this.typedArray = typedArray;
    }

    private void setSelectorDrawable(StateListDrawable stateListDrawable, @StyleableRes int i10, @StyleableRes int i11, @AttrRes int i12) throws Exception {
        if (this.typedArray.hasValue(i10) || this.typedArray.hasValue(i11)) {
            GradientDrawable drawable = DrawableFactory.getDrawable(this.typedArray);
            if (this.typedArray.hasValue(i10)) {
                drawable.setColor(this.typedArray.getColor(i10, 0));
            }
            if (this.typedArray.hasValue(i11)) {
                drawable.setStroke(this.typedArray.getDimensionPixelSize(R.styleable.background_bl_stroke_width, 0), this.typedArray.getColor(i11, 0), this.typedArray.getDimension(R.styleable.background_bl_stroke_dashWidth, 0.0f), this.typedArray.getDimension(R.styleable.background_bl_stroke_dashGap, 0.0f));
            }
            stateListDrawable.addState(new int[]{i12}, drawable);
        }
    }

    @Override // com.noober.background.drawable.ICreateDrawable
    public StateListDrawable create() throws Exception {
        StateListDrawable stateListDrawable = new StateListDrawable();
        setSelectorDrawable(stateListDrawable, R.styleable.background_bl_checkable_solid_color, R.styleable.background_bl_checkable_stroke_color, android.R.attr.state_checkable);
        setSelectorDrawable(stateListDrawable, R.styleable.background_bl_unCheckable_solid_color, R.styleable.background_bl_unCheckable_stroke_color, -16842911);
        setSelectorDrawable(stateListDrawable, R.styleable.background_bl_checked_solid_color, R.styleable.background_bl_checked_stroke_color, android.R.attr.state_checked);
        setSelectorDrawable(stateListDrawable, R.styleable.background_bl_unChecked_solid_color, R.styleable.background_bl_unChecked_stroke_color, -16842912);
        setSelectorDrawable(stateListDrawable, R.styleable.background_bl_enabled_solid_color, R.styleable.background_bl_enabled_stroke_color, android.R.attr.state_enabled);
        setSelectorDrawable(stateListDrawable, R.styleable.background_bl_unEnabled_solid_color, R.styleable.background_bl_unEnabled_stroke_color, -16842910);
        setSelectorDrawable(stateListDrawable, R.styleable.background_bl_selected_solid_color, R.styleable.background_bl_selected_stroke_color, android.R.attr.state_selected);
        setSelectorDrawable(stateListDrawable, R.styleable.background_bl_unSelected_solid_color, R.styleable.background_bl_unSelected_stroke_color, -16842913);
        setSelectorDrawable(stateListDrawable, R.styleable.background_bl_pressed_solid_color, R.styleable.background_bl_pressed_stroke_color, android.R.attr.state_pressed);
        setSelectorDrawable(stateListDrawable, R.styleable.background_bl_unPressed_solid_color, R.styleable.background_bl_unPressed_stroke_color, -16842919);
        setSelectorDrawable(stateListDrawable, R.styleable.background_bl_focused_solid_color, R.styleable.background_bl_focused_stroke_color, android.R.attr.state_focused);
        setSelectorDrawable(stateListDrawable, R.styleable.background_bl_unFocused_solid_color, R.styleable.background_bl_unFocused_stroke_color, -16842908);
        return stateListDrawable;
    }
}
