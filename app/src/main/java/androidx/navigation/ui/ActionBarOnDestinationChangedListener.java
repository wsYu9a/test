package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class ActionBarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {

    /* renamed from: f */
    private final AppCompatActivity f3059f;

    ActionBarOnDestinationChangedListener(@NonNull AppCompatActivity appCompatActivity, @NonNull AppBarConfiguration appBarConfiguration) {
        super(appCompatActivity.getDrawerToggleDelegate().getActionBarThemedContext(), appBarConfiguration);
        this.f3059f = appCompatActivity;
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    protected void b(Drawable drawable, @StringRes int i2) {
        ActionBar supportActionBar = this.f3059f.getSupportActionBar();
        if (drawable == null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        } else {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            this.f3059f.getDrawerToggleDelegate().setActionBarUpIndicator(drawable, i2);
        }
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    protected void c(CharSequence charSequence) {
        this.f3059f.getSupportActionBar().setTitle(charSequence);
    }
}
