package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* renamed from: c */
    static final int f218c = 0;

    /* renamed from: d */
    static final int f219d = 1;

    /* renamed from: e */
    final AlertController f220e;

    public static class Builder {

        /* renamed from: a */
        private final AlertController.AlertParams f221a;

        /* renamed from: b */
        private final int f222b;

        public Builder(@NonNull Context context) {
            this(context, AlertDialog.c(context, 0));
        }

        @NonNull
        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.f221a.mContext, this.f222b);
            this.f221a.apply(alertDialog.f220e);
            alertDialog.setCancelable(this.f221a.mCancelable);
            if (this.f221a.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f221a.mOnCancelListener);
            alertDialog.setOnDismissListener(this.f221a.mOnDismissListener);
            DialogInterface.OnKeyListener onKeyListener = this.f221a.mOnKeyListener;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        @NonNull
        public Context getContext() {
            return this.f221a.mContext;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f221a.mCancelable = z;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mCursor = cursor;
            alertParams.mLabelColumn = str;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCustomTitle(@Nullable View view) {
            this.f221a.mCustomTitleView = view;
            return this;
        }

        public Builder setIcon(@DrawableRes int i2) {
            this.f221a.mIconId = i2;
            return this;
        }

        public Builder setIconAttribute(@AttrRes int i2) {
            TypedValue typedValue = new TypedValue();
            this.f221a.mContext.getTheme().resolveAttribute(i2, typedValue, true);
            this.f221a.mIconId = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean z) {
            this.f221a.mForceInverseBackground = z;
            return this;
        }

        public Builder setItems(@ArrayRes int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i2);
            this.f221a.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMessage(@StringRes int i2) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mMessage = alertParams.mContext.getText(i2);
            return this;
        }

        public Builder setMultiChoiceItems(@ArrayRes int i2, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i2);
            AlertController.AlertParams alertParams2 = this.f221a;
            alertParams2.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams2.mCheckedItems = zArr;
            alertParams2.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(@StringRes int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i2);
            this.f221a.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable drawable) {
            this.f221a.mNegativeButtonIcon = drawable;
            return this;
        }

        public Builder setNeutralButton(@StringRes int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i2);
            this.f221a.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable drawable) {
            this.f221a.mNeutralButtonIcon = drawable;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f221a.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f221a.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f221a.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f221a.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setPositiveButton(@StringRes int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i2);
            this.f221a.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable drawable) {
            this.f221a.mPositiveButtonIcon = drawable;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.f221a.mRecycleOnMeasure = z;
            return this;
        }

        public Builder setSingleChoiceItems(@ArrayRes int i2, int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i2);
            AlertController.AlertParams alertParams2 = this.f221a;
            alertParams2.mOnClickListener = onClickListener;
            alertParams2.mCheckedItem = i3;
            alertParams2.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(@StringRes int i2) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mTitle = alertParams.mContext.getText(i2);
            return this;
        }

        public Builder setView(int i2) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mView = null;
            alertParams.mViewLayoutResId = i2;
            alertParams.mViewSpacingSpecified = false;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }

        public Builder(@NonNull Context context, @StyleRes int i2) {
            this.f221a = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.c(context, i2)));
            this.f222b = i2;
        }

        public Builder setIcon(@Nullable Drawable drawable) {
            this.f221a.mIcon = drawable;
            return this;
        }

        public Builder setMessage(@Nullable CharSequence charSequence) {
            this.f221a.mMessage = charSequence;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.f221a.mTitle = charSequence;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mNegativeButtonText = charSequence;
            alertParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mNeutralButtonText = charSequence;
            alertParams.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mPositiveButtonText = charSequence;
            alertParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setView(View view) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mView = view;
            alertParams.mViewLayoutResId = 0;
            alertParams.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mCheckedItems = zArr;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i2, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mCursor = cursor;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i2;
            alertParams.mLabelColumn = str;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public Builder setView(View view, int i2, int i3, int i4, int i5) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mView = view;
            alertParams.mViewLayoutResId = 0;
            alertParams.mViewSpacingSpecified = true;
            alertParams.mViewSpacingLeft = i2;
            alertParams.mViewSpacingTop = i3;
            alertParams.mViewSpacingRight = i4;
            alertParams.mViewSpacingBottom = i5;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mCursor = cursor;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mIsCheckedColumn = str;
            alertParams.mLabelColumn = str2;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i2;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f221a;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i2;
            alertParams.mIsSingleChoice = true;
            return this;
        }
    }

    protected AlertDialog(@NonNull Context context) {
        this(context, 0);
    }

    static int c(@NonNull Context context, @StyleRes int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void d(int i2) {
        this.f220e.setButtonPanelLayoutHint(i2);
    }

    public Button getButton(int i2) {
        return this.f220e.getButton(i2);
    }

    public ListView getListView() {
        return this.f220e.getListView();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f220e.installContent();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f220e.onKeyDown(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.f220e.onKeyUp(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    public void setButton(int i2, CharSequence charSequence, Message message) {
        this.f220e.setButton(i2, charSequence, null, message, null);
    }

    public void setCustomTitle(View view) {
        this.f220e.setCustomTitle(view);
    }

    public void setIcon(int i2) {
        this.f220e.setIcon(i2);
    }

    public void setIconAttribute(int i2) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i2, typedValue, true);
        this.f220e.setIcon(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.f220e.setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f220e.setTitle(charSequence);
    }

    public void setView(View view) {
        this.f220e.setView(view);
    }

    protected AlertDialog(@NonNull Context context, @StyleRes int i2) {
        super(context, c(context, i2));
        this.f220e = new AlertController(getContext(), this, getWindow());
    }

    public void setButton(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f220e.setButton(i2, charSequence, onClickListener, null, null);
    }

    public void setIcon(Drawable drawable) {
        this.f220e.setIcon(drawable);
    }

    public void setView(View view, int i2, int i3, int i4, int i5) {
        this.f220e.setView(view, i2, i3, i4, i5);
    }

    public void setButton(int i2, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.f220e.setButton(i2, charSequence, onClickListener, null, drawable);
    }

    protected AlertDialog(@NonNull Context context, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }
}
