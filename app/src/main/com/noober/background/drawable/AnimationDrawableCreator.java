package com.noober.background.drawable;

import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.StyleableRes;
import com.noober.background.R;

/* loaded from: classes3.dex */
public class AnimationDrawableCreator implements ICreateDrawable {
    private TypedArray animationTa;
    private int duration = 0;
    private AnimationDrawable drawable = new AnimationDrawable();

    public AnimationDrawableCreator(TypedArray typedArray) {
        this.animationTa = typedArray;
    }

    private void addFrame(@StyleableRes int i10, @StyleableRes int i11) {
        Drawable drawable;
        if (!this.animationTa.hasValue(i10) || (drawable = this.animationTa.getDrawable(i10)) == null) {
            return;
        }
        if (this.animationTa.hasValue(i11)) {
            this.drawable.addFrame(drawable, this.animationTa.getInt(i11, 0));
        } else {
            this.drawable.addFrame(drawable, this.duration);
        }
    }

    @Override // com.noober.background.drawable.ICreateDrawable
    public Drawable create() throws Exception {
        Drawable drawable;
        for (int i10 = 0; i10 < this.animationTa.getIndexCount(); i10++) {
            int index = this.animationTa.getIndex(i10);
            if (index == R.styleable.bl_anim_bl_duration) {
                this.duration = this.animationTa.getInt(index, 0);
            } else if (index == R.styleable.bl_anim_bl_oneshot) {
                this.drawable.setOneShot(this.animationTa.getBoolean(index, false));
            }
        }
        if (this.animationTa.hasValue(R.styleable.bl_anim_bl_frame_drawable_item0) && (drawable = this.animationTa.getDrawable(R.styleable.bl_anim_bl_frame_drawable_item0)) != null) {
            if (this.animationTa.hasValue(R.styleable.bl_anim_bl_duration_item0)) {
                this.drawable.addFrame(drawable, this.animationTa.getInt(R.styleable.bl_anim_bl_duration_item0, 0));
            } else {
                this.drawable.addFrame(drawable, this.duration);
            }
        }
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item0, R.styleable.bl_anim_bl_duration_item0);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item1, R.styleable.bl_anim_bl_duration_item1);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item2, R.styleable.bl_anim_bl_duration_item2);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item3, R.styleable.bl_anim_bl_duration_item3);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item4, R.styleable.bl_anim_bl_duration_item4);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item5, R.styleable.bl_anim_bl_duration_item5);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item6, R.styleable.bl_anim_bl_duration_item6);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item7, R.styleable.bl_anim_bl_duration_item7);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item8, R.styleable.bl_anim_bl_duration_item8);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item9, R.styleable.bl_anim_bl_duration_item9);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item10, R.styleable.bl_anim_bl_duration_item10);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item11, R.styleable.bl_anim_bl_duration_item11);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item12, R.styleable.bl_anim_bl_duration_item12);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item13, R.styleable.bl_anim_bl_duration_item13);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item14, R.styleable.bl_anim_bl_duration_item14);
        return this.drawable;
    }
}
