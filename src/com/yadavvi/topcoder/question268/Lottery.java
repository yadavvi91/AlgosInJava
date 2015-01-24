package com.yadavvi.topcoder.question268;

import java.util.StringTokenizer;

import com.yadavvi.sort.MergeSort;

public class Lottery {

	public String[] sortByOdds(String[] rules) {
		Rule[] rule = new Rule[rules.length];
		StringBuilder strBuilder = new StringBuilder();

		for (int i = 0; i < rules.length; i++) {
			rule[i] = parseStringAndCreateRule(rules[i]);
		}

		MergeSort.sort(rule);
		// MergeSort is REQUIRED because we shouldn't change the order of Rules
		// if 2 (or more) Rules have the same Odds. This is not guaranteed with
		// Array.sort().
		// Arrays.sort(rule);

		String[] namesOfRules = new String[rule.length];
		for (int i = 0; i < rule.length; i++) {
			namesOfRules[i] = rule[i].name;
			strBuilder.setLength(0);
			strBuilder.append(rule[i].name + ": ");
			strBuilder.append(rule[i].numberOfOdds + ",");
			System.out.println(strBuilder.toString());
		}
		System.out.println();
		return namesOfRules;
	}

	private Rule parseStringAndCreateRule(String rule) {
		StringTokenizer strTokenizer = new StringTokenizer(rule, ":");

		String name = strTokenizer.nextToken().trim();
		String[] conditions = strTokenizer.nextToken().trim().split(" ");

		return new Rule(name, conditions);
	}

}
