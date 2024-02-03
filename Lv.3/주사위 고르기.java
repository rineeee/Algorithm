import java.util.*;

class Solution {
    static int[][] d;
    static int n;
    static Set<Integer> numberSet = new HashSet<>();
    static List<Integer> aList;
    static List<Integer> bList;
    static int maxWinCount = 0;
    static List<Integer> selectedDice;

    public int[] solution(int[][] dice) {
        d = dice;
        n = dice.length;
        int[] number = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            numberSet.add(i);
        }
        dfs(visited, 0, 0);
        int[] result = new int[selectedDice.size()];
        Collections.sort(selectedDice);
        for (int i = 0; i < selectedDice.size(); i++) {
            result[i] = selectedDice.get(i) + 1; 
        }
        return result;
    }

    static public void dfs(boolean[] visited, int cnt, int curr) {
        if (cnt == n / 2) {
            Set<Integer> aSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    aSet.add(i);
                }
            }
            check(aSet);
            return;
        }
        for (int i = curr; i < n; i++) {
            visited[i] = true;
            dfs(visited, cnt + 1, i + 1);
            visited[i] = false;
        }
    }

    static public void check(Set<Integer> aSet) {
        Set<Integer> bSet = new HashSet<>(numberSet);
        bSet.removeAll(aSet);
        Integer[] aArr = aSet.toArray(new Integer[0]);
        Integer[] bArr = bSet.toArray(new Integer[0]);
        aList = new ArrayList<>();
        bList = new ArrayList<>();
        makeList(aArr, true, 0, 0);
        makeList(bArr, false, 0, 0);
        int aWinCount = calculateWinCount();

        if (aWinCount > maxWinCount) {
            maxWinCount = aWinCount;
            selectedDice = new ArrayList<>(aSet);
        }
    }

    static public void makeList(Integer[] arr, boolean isA, int cnt, int sum) {
        if (cnt == arr.length) {
            if (isA) {
                aList.add(sum);
            } else {
                bList.add(sum);
            }
            return;
        }
        for (int i = 0; i < 6; i++) {
            makeList(arr, isA, cnt + 1, sum + d[arr[cnt]][i]);
        }
    }

    static public int calculateWinCount() {
        int aWin = 0;
        Collections.sort(aList);
        Collections.sort(bList);
        for (int aVal : aList) {
            int bIndex = binarySearch(bList, aVal);
            aWin += bIndex;
        }
        return aWin;
    }

    static public int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
