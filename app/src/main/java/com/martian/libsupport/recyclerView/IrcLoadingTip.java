package com.martian.libsupport.recyclerView;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.martian.libsupport.R;

/* loaded from: classes3.dex */
public class IrcLoadingTip extends LinearLayout {

    /* renamed from: a */
    private TextView f10648a;

    /* renamed from: b */
    private b f10649b;

    /* renamed from: c */
    private String f10650c;

    public enum LoadStatus {
        sereverError,
        error,
        empty,
        loading,
        finish,
        error_msg
    }

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f10651a;

        static {
            int[] iArr = new int[LoadStatus.values().length];
            f10651a = iArr;
            try {
                iArr[LoadStatus.empty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10651a[LoadStatus.sereverError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10651a[LoadStatus.error.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10651a[LoadStatus.error_msg.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10651a[LoadStatus.loading.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public interface b {
        void a();
    }

    public IrcLoadingTip(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.irc_loading_tip, this);
        TextView textView = (TextView) findViewById(R.id.loading_tips);
        this.f10648a = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libsupport.recyclerView.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IrcLoadingTip.this.c(view);
            }
        });
        setVisibility(8);
    }

    /* renamed from: b */
    public /* synthetic */ void c(View view) {
        b bVar = this.f10649b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void setErrorMsg(String msg) {
        this.f10650c = msg;
    }

    public void setLoadingTip(LoadStatus loadStatus) {
        int i2 = a.f10651a[loadStatus.ordinal()];
        if (i2 == 1) {
            setVisibility(0);
            this.f10648a.setText("数据为空");
            return;
        }
        if (i2 == 2) {
            setVisibility(0);
            this.f10648a.setText("服务器加载失败，点击重试");
            return;
        }
        if (i2 != 3 && i2 != 4) {
            if (i2 != 5) {
                setVisibility(8);
                return;
            } else {
                setVisibility(0);
                this.f10648a.setText("加载中...");
                return;
            }
        }
        setVisibility(0);
        if (TextUtils.isEmpty(this.f10650c)) {
            this.f10648a.setText("网络不给力，点击重试");
            return;
        }
        this.f10648a.setText(this.f10650c + "，点击重试");
    }

    public void setOnReloadListener(b onReloadListener) {
        this.f10649b = onReloadListener;
    }

    public void setTips(String tips) {
        TextView textView = this.f10648a;
        if (textView != null) {
            textView.setText(tips);
        }
    }

    public IrcLoadingTip(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context);
    }

    public IrcLoadingTip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a(context);
    }

    @TargetApi(21)
    public IrcLoadingTip(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        a(context);
    }
}
