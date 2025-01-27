package b.b.a.g;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* loaded from: classes.dex */
final class e implements DialogInterface.OnKeyListener {
    e() {
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        return i2 == 4;
    }
}
