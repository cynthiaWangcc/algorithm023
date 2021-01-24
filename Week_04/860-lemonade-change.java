class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0) {
            return true;
        }
        
        int five = 0;
        int ten = 0;

        for(int cash : bills) {
            if(cash == 5) {
                five ++;
            } else if (cash == 10) {
                if(five == 0) {
                    return false;
                }
                five --;
                ten ++;
            } else {
                if(five > 0 && ten > 0) {
                    five --;
                    ten --;
                } else if(five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}