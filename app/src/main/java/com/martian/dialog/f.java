package com.martian.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.DatePicker;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import c.a.a.a.a.o;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class f extends e {

    /* renamed from: c */
    protected static final String f9690c = "zone";

    /* renamed from: d */
    protected static final String f9691d = "date";

    /* renamed from: e */
    protected static final String f9692e = "24h";

    /* renamed from: f */
    DatePicker f9693f;

    /* renamed from: g */
    Calendar f9694g;

    public static class a extends d<a> {
        Date q;
        String r;
        b s;
        private boolean t;

        protected a(Context context, FragmentManager fragmentManager) {
            super(context, fragmentManager, f.class);
            this.q = new Date();
            this.r = null;
            this.t = true;
        }

        @Override // c.a.a.a.a.n
        protected Bundle c() {
            Bundle bundle = new Bundle();
            bundle.putLong(f.f9691d, this.q.getTime());
            bundle.putBoolean(f.f9692e, this.t);
            String str = this.r;
            if (str != null) {
                bundle.putString(f.f9690c, str);
            } else {
                bundle.putString(f.f9690c, "GMT");
            }
            return bundle;
        }

        @Override // c.a.a.a.a.n
        /* renamed from: s */
        public a d() {
            return this;
        }

        public a t(boolean state) {
            this.t = state;
            return this;
        }

        public a u(Date date) {
            this.q = date;
            return this;
        }

        public a v(b listener) {
            this.s = listener;
            return this;
        }

        public a w(String zone) {
            this.r = zone;
            return this;
        }
    }

    public interface b {
        void a(DatePicker datePicker, int year, int month, int dayOfMonth);
    }

    public static a h(Context context, FragmentManager fragmentManager) {
        return new a(context, fragmentManager);
    }

    public static a i(FragmentActivity context) {
        return h(context, context.getSupportFragmentManager());
    }

    /* renamed from: k */
    public /* synthetic */ void l(DialogInterface dialog, int which) {
        b bVar = ((a) this.f9688a).s;
        if (bVar != null) {
            DatePicker datePicker = this.f9693f;
            bVar.a(datePicker, datePicker.getYear(), this.f9693f.getMonth(), this.f9693f.getDayOfMonth());
        }
    }

    static /* synthetic */ void m(DialogInterface dialog, int which) {
    }

    @Override // com.martian.dialog.e, c.a.a.a.a.o
    protected o.a a(o.a builder) {
        builder.V(R.string.confirm, new DialogInterface.OnClickListener() { // from class: com.martian.dialog.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                f.this.l(dialogInterface, i2);
            }
        });
        builder.R(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.martian.dialog.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                f.m(dialogInterface, i2);
            }
        });
        DatePicker datePicker = (DatePicker) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_part_datepicker, (ViewGroup) null);
        this.f9693f = datePicker;
        builder.d0(datePicker);
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(getArguments() == null ? "" : getArguments().getString(f9690c)));
        this.f9694g = calendar;
        calendar.setTimeInMillis(getArguments().getLong(f9691d, System.currentTimeMillis()));
        this.f9693f.updateDate(this.f9694g.get(1), this.f9694g.get(2), this.f9694g.get(5));
        return builder;
    }

    public Date j() {
        this.f9694g.set(1, this.f9693f.getYear());
        this.f9694g.set(2, this.f9693f.getMonth());
        this.f9694g.set(5, this.f9693f.getDayOfMonth());
        return this.f9694g.getTime();
    }
}
