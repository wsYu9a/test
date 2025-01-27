package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class WithdrawBookCoinsParams extends TYAuthParams {

    @a
    private Integer bookCoins;

    @a
    private Integer money;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "withdraw_book_coins.do";
    }

    public Integer getBookCoins() {
        Integer num = this.bookCoins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setBookCoins(Integer bookCoins) {
        this.bookCoins = bookCoins;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
