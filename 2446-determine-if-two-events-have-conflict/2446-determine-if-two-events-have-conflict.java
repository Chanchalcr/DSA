class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int[] range1 = new int[2]; 
        int[] range2 = new int[2]; 
        range1[0] = toMinute(event1[0]);
        range1[1] = toMinute(event1[1]);
        range2[0] = toMinute(event2[0]);
        range2[1] = toMinute(event2[1]);
        if(range1[0] <= range2[0] && range2[0] <= range1[1]) return true;
        if(range1[0] <= range2[1] && range2[1] <= range1[1]) return true;
        if(range2[0] <= range1[0] && range1[0] <= range2[1]) return true;
        if(range2[0] <= range1[1] && range1[1] <= range2[1]) return true;
        return false;
    }
    public int toMinute(String S) {
        char[] event = S.toCharArray();
        int min = 0;
        min = ((event[0]-'0')*10 + (event[1] - '0'))*60;
        return min + (event[3] - '0')*10 + (event[4]-'0');
    }
}