package com.martian.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.a.a.a.o;

/* loaded from: classes2.dex */
public abstract class e extends o {

    /* renamed from: a */
    d f9688a;

    /* renamed from: b */
    private DialogInterface.OnCancelListener f9689b;

    @Override // c.a.a.a.a.o
    protected o.a a(o.a initialBuilder) {
        return initialBuilder;
    }

    public void f(d builder) {
        this.f9688a = builder;
    }

    public void g(DialogInterface.OnCancelListener l) {
        this.f9689b = l;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        DialogInterface.OnCancelListener onCancelListener = this.f9689b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialog);
        }
        super.onCancel(dialog);
    }

    @Override // c.a.a.a.a.o, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        d dVar = this.f9688a;
        if (dVar == null) {
            return null;
        }
        return a(dVar.n(this, getActivity(), inflater, container)).f();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f9688a == null) {
            dismiss();
        }
    }
}
