class Solution {
    public int trap(int[] height) {
    int len = height.length;
    if(len == 0)    return 0;
    int[] maxleft = new int[len];
    int[] maxright = new int[len];
    int max = Integer.MIN_VALUE;
    for(int i=0;i<len;i++){
        if(height[i] > max){
            max = height[i];
        }
        maxleft[i] = max;
    }
    max = Integer.MIN_VALUE;
    for(int i=len-1;i>=0;i--){
        if(height[i] > max){
            max = height[i];
        }
        maxright[i] = max;
    }
    int ret = 0;
    for(int i=0;i<len;i++){
        int diff = Math.min(maxleft[i],maxright[i]) - height[i];
        ret += diff;
    }
    return ret;
}
}

class Solution {
    public int trap(int[] height) {
        
        
        
        int n = height.length;
        if(n == 0) {
            return 0;
        }
        int total = 0;
        for(int i = 0; i < n; i++) {
            
            int lMax = 0;
            for(int j = 0;  j <= i - 1; j++) {
                lMax = Math.max(lMax, height[j]);
            }
            
            int rMax = 0;
            
            for(int j = i + 1; j < n; j++) {
                rMax = Math.max(rMax, height[j]);
            }
            
            int min = Math.min(lMax, rMax);
            System.out.println(min);
            int waterStored = min - height[i];
            
            if(waterStored < 0) {
                total += 0;
            } else {
                total += waterStored;
            }
        }
        
        return total;
    }
}
