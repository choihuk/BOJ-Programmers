class Solution {
	public long solution(long w,long h) {
        long minus = 0;
        
        
        if (w == 1 || h == 1) {
            return 0;
        }
        
        long gcd = gcd(w, h);
        minus = gcd * (w/gcd + h/gcd - 1);
        return (w*h) - minus;
	}
    
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}