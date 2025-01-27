package com.martian.mibook.mvvm.base;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lc.a;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import me.jessyan.autosize.internal.CustomAdapt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001a\u0010\u0011J\u000f\u0010\u001b\u001a\u00028\u0000H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u001d\u0010\u0011R\u0018\u0010 \u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010%R\u0014\u0010(\u001a\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001c¨\u0006)"}, d2 = {"Lcom/martian/mibook/mvvm/base/BaseActivity;", "Landroidx/viewbinding/ViewBinding;", "VB", "Lme/imid/swipebacklayout/lib/app/SwipeBackActivity;", "Lme/jessyan/autosize/internal/CustomAdapt;", "<init>", "()V", "", "isBaseOnWidth", "()Z", "", "getSizeInDp", "()F", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "requestedOrientation", "setRequestedOrientation", "(I)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "b1", "Z0", "()Landroidx/viewbinding/ViewBinding;", "c1", "c", "Landroidx/viewbinding/ViewBinding;", "_mViewBinding", "d", "Z", "d1", "e1", "(Z)V", "isPortrait", "a1", "mViewBinding", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public abstract class BaseActivity<VB extends ViewBinding> extends SwipeBackActivity implements CustomAdapt {

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public VB _mViewBinding;

    /* renamed from: d, reason: from kotlin metadata */
    public boolean isPortrait = true;

    @k
    public abstract VB Z0();

    @k
    public final VB a1() {
        VB vb2 = this._mViewBinding;
        if (vb2 != null) {
            return vb2;
        }
        throw new IllegalStateException(("Activity " + this + " viewBinding cannot be accessed").toString());
    }

    public void b1(@l Bundle savedInstanceState) {
        this._mViewBinding = Z0();
        setContentView(a1().getRoot());
    }

    public abstract void c1(@l Bundle savedInstanceState);

    /* renamed from: d1, reason: from getter */
    public final boolean getIsPortrait() {
        return this.isPortrait;
    }

    public final void e1(boolean z10) {
        this.isPortrait = z10;
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public float getSizeInDp() {
        return 360.0f;
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public boolean isBaseOnWidth() {
        return this.isPortrait;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@k Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int i10 = newConfig.orientation;
        if (i10 == 1) {
            this.isPortrait = true;
        } else {
            if (i10 != 2) {
                return;
            }
            this.isPortrait = false;
        }
    }

    @Override // me.imid.swipebacklayout.lib.app.SwipeBackActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@l Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT == 26) {
            a aVar = a.f28080a;
            if (aVar.b(this)) {
                aVar.a(this);
            }
        }
        super.onCreate(savedInstanceState);
        Configuration configuration = getResources().getConfiguration();
        if (configuration != null) {
            this.isPortrait = configuration.orientation == 1;
        }
        b1(savedInstanceState);
        c1(savedInstanceState);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int requestedOrientation) {
        if (Build.VERSION.SDK_INT == 26 && a.f28080a.b(this)) {
            return;
        }
        super.setRequestedOrientation(requestedOrientation);
    }
}
