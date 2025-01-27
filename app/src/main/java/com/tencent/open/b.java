package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.a.f;

/* loaded from: classes4.dex */
public abstract class b extends Dialog {

    /* renamed from: a */
    protected a f23174a;

    /* renamed from: b */
    @SuppressLint({"NewApi"})
    protected final WebChromeClient f23175b;

    public b(Context context, int i10) {
        super(context, i10);
        this.f23175b = new WebChromeClient() { // from class: com.tencent.open.b.1
            public AnonymousClass1() {
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (consoleMessage == null) {
                    return false;
                }
                f.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                b.this.a(consoleMessage.message());
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(String str, int i11, String str2) {
                f.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i11 + " of " + str2);
            }
        };
    }

    public abstract void a(String str);

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f23174a = new a();
    }

    /* renamed from: com.tencent.open.b$1 */
    public class AnonymousClass1 extends WebChromeClient {
        public AnonymousClass1() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return false;
            }
            f.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            b.this.a(consoleMessage.message());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String str, int i11, String str2) {
            f.c("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i11 + " of " + str2);
        }
    }
}
