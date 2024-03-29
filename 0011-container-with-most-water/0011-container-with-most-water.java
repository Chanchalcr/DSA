class Solution {
    public int maxArea(int[] height) {
        int max=Integer.MIN_VALUE;
        int area;
        int i=0,j=height.length-1;
        while(i<j){
            area=(j-i)*Math.min(height[i],height[j]);
            if(max<area) max=area;
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return max;
    }
}