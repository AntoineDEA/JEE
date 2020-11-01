package model;

import java.util.ArrayList;

public class Bean {
    
    private int ssn;
    private int multi;
    private int result;
    private int bonusAmount = 50;

    public int getSecureNumber() {
        return ssn;
    }

    public void setSecureNumber(int secureNumber) {
        this.ssn = secureNumber;
    }

    public int getMulti() {
        return multi;
    }

    public void setMulti(int multi) {
        this.multi = multi;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(int bonusAmount) {
        this.bonusAmount = bonusAmount;
    }
    
}
