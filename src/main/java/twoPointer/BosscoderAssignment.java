package twoPointer;

import java.util.HashMap;

public class BosscoderAssignment {
	public static void main(String[] args) {

	}

	// 379. Ugly Number II
	private static int nthUglyNUmber(int n) {

		int[] ugly = new int[n];
		ugly[0] = 1;
		int p2 = 0, p3 = 0, p5 = 0;
		for (int i = 1; i < n; i++) {
			int nextUgly = Math.min(ugly[p2] * 2, Math.min(ugly[p3] * 3, ugly[p5] * 5));
			ugly[i] = nextUgly;

			if (ugly[p2] * 2 == nextUgly)
				p2++;

			if (ugly[p3] * 3 == nextUgly)
				p3++;

			if (ugly[p5] * 5 == nextUgly)
				p5++;

		}
		return ugly[n - 1];

	}

	// 560. Subarray Sum Equals K
	public int subarraySum(int[] nums, int k) {
		int count = 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;

	}

	// 167. Two Sum II - Input Array Is Sorted
	public int[] twoSum(int[] numbers, int target) {

		int l = 0, r = numbers.length - 1;

		while (l < r) {
			if (numbers[l] + numbers[r] == target) {
				return new int[] { l + 1, r + 1 };
			} else if (numbers[l] + numbers[r] > target) {
				r--;
			} else {
				l++;
			}
		}
		return new int[] {};

	}

	// 11. Container With Most Water
	public int maxArea(int[] height) {

		int l = 0, r = height.length - 1;
		int ans = 0;
		while (l < r) {
			ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));

			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}

		return ans;

	}

}
