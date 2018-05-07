package com.rakesh.algo.dp;

public class LongestCommonSubsequence {

	String getLCS(String s1, String s2) {
		int arr[][] = new int[s1.length() + 1][s2.length() + 1];
		String arrS[][] = new String[s1.length() + 1][s2.length() + 1];
		int max = 0;
		String maxS = "";

		for (int i = 0; i < s1.length() + 1; i++) {
			arr[i][0] = 0;
			arrS[i][0] = "";
		}
		for (int i = 0; i < s2.length() + 1; i++) {
			arr[0][i] = 0;
			arrS[0][i] = "";
		}
		for (int ix = 0; ix < s1.length(); ix++) {
			int i = ix + 1;
			for (int jx = 0; jx < s2.length(); jx++) {

				int j = jx + 1;
				if (s1.charAt(ix) == s2.charAt(jx)) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
					arrS[i][j] = arrS[i - 1][j - 1] + s1.charAt(ix);
				} else {
					if (arr[i][j - 1] > arr[i - 1][j]) {
						arr[i][j] = arr[i][j - 1];
						arrS[i][j] = arrS[i][j - 1];
					} else {
						arr[i][j] = arr[i - 1][j];
						arrS[i][j] = arrS[i - 1][j];
					}
				}
				if (arr[i][j] > max) {
					max = arr[i][j];
					maxS = arrS[i][j];
				}
			}
		}

		return maxS;
	}

	public static void main(String[] args) {
		String s1 = "asdf1fsdf2fe3ss4gr5cc6se7f8aa";
		String s2 = "kkhj1hjtt2iit3bb4jj5bb6yy7mm8yh";
		System.out.println(new LongestCommonSubsequence().getLCS(s1, s2));
	}
}
