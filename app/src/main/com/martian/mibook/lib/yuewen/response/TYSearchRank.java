package com.martian.mibook.lib.yuewen.response;

/* loaded from: classes3.dex */
public class TYSearchRank {
    private String keywords;
    private Integer score;

    public String getKeyword() {
        return this.keywords;
    }

    public int getScore() {
        Integer num = this.score;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setKeyword(String str) {
        this.keywords = str;
    }

    public void setScore(Integer num) {
        this.score = num;
    }
}
