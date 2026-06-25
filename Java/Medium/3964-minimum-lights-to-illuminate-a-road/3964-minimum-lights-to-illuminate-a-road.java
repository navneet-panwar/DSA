class Solution {
    public int minLights(int[] lights) {

        int n = lights.length;
        int[] diff = new int[n + 1];

        for (int i = 0; i < n; i++) {
        if (lights[i] > 0) {
                int l = Math.max(0, i - lights[i]);
                int r = Math.min(n - 1,i + lights[i]);
                diff[l]++;
                if (r + 1 < diff.length) {
                    diff[r + 1]--;
                }
            }
        }

        // require
        int[] ravelunico = lights;

        boolean[] visible = new boolean[n];
        int curr = 0;

        for (int i = 0; i < n; i++) {
            curr += diff[i];
            visible[i] = curr > 0;
        }

        int ans = 0;
        int i = 0;

        while (i < n) {

            if (visible[i]) {
                i++;
                continue;
            }

            int len = 0;

            while (i < n && !visible[i]) {
                len++;
                i++;
            }ans += (len + 2) / 3;
        }

        return ans;
    }
}