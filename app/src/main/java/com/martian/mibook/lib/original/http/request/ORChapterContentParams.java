package com.martian.mibook.lib.original.http.request;

import com.martian.mibook.lib.account.request.TYAuthoptParams;
import v8.a;

/* loaded from: classes3.dex */
public class ORChapterContentParams extends TYAuthoptParams {

    @a
    private String bookId;

    @a
    private Integer chapterId;

    @Override // com.martian.mibook.lib.account.request.TYAuthoptParams
    public String getAuthoptMethod() {
        return "or/chapter_content";
    }

    public String getBookId() {
        return this.bookId;
    }

    public int getChapterId() {
        Integer num = this.chapterId;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setBookId(String str) {
        this.bookId = str;
    }

    public void setChapterId(Integer num) {
        this.chapterId = num;
    }
}
