package com.khlin.leetcode;

public class DecodedStringAtIndex {

	public static class Solution {
		public String decodeAtIndex(String S, int K) {

			StringBuilder tape = new StringBuilder(S.length());
			for (char c : S.toCharArray()) {
				if (c >= '2' && c <= '9') {
					int times = Integer.parseInt(String.valueOf(c)) - 1;
					String repeatStr = tape.toString();
					for (int i = 1; i <= times; i++) {
						tape.append(repeatStr);
						if (tape.length() >= K) {
							return String.valueOf(tape.charAt(K - 1));
						}
					}
				} else {
					tape.append(c);
					if (tape.length() >= K) {
						return String.valueOf(tape.charAt(K - 1));
					}
				}
			}
			return "";
		}

		public String decodeAtIndex2(String S, int K) {
			StringBuilder stringTempBuilder = new StringBuilder();
			int tapeLength = 0;

			int index = 0;
			for (; index <= S.length() - 1 && tapeLength < K; index++) {
				char c = S.charAt(index);
				if (Character.isDigit(c)) {
					tapeLength = tapeLength
							* (Integer.parseInt(String.valueOf(c)));
				} else {
					tapeLength++;
				}
			}

			while(index >= 0) {
			    char c = S.charAt(index);
			    if(Character.isLetter(c)) {
			        tapeLength --;
                } else {
			        int repeat = c - '0';
			        tapeLength = tapeLength / repeat;
			        if(K > tapeLength) {
                    }
                }
            }
			return "";
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().decodeAtIndex("y959q969u3hb22odq595",
				222280369));
	}
}
