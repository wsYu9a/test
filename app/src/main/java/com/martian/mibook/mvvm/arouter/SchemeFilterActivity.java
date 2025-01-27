package com.martian.mibook.mvvm.arouter;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import kc.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/martian/mibook/mvvm/arouter/SchemeFilterActivity;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "b", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class SchemeFilterActivity extends Activity {

    /* renamed from: c */
    @k
    public static final String f14012c = "tfbook";

    /* renamed from: d */
    @k
    public static final String f14013d = "m.taoyuewenhua.com";

    @Override // android.app.Activity
    public void onCreate(@l Bundle savedInstanceState) {
        String path;
        int hashCode;
        super.onCreate(savedInstanceState);
        Uri data = getIntent().getData();
        if (data != null && Intrinsics.areEqual(data.getScheme(), "tfbook") && Intrinsics.areEqual(data.getHost(), f14013d) && (path = data.getPath()) != null && ((hashCode = path.hashCode()) == 1388120957 ? path.equals("/reading") : hashCode == 2122987954 && path.equals("/reader"))) {
            b.p(this, data);
        }
        finish();
    }
}
