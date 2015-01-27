package com.yadavvi.topcoder.question268;

import java.util.StringTokenizer;

import com.yadavvi.sort.MergeSort;

public class Lottery {

	public String[] sortByOdds(String[] rules) {
		Rule[] rule = new Rule[rules.length];

		for (int i = 0; i < rules.length; i++) {
			rule[i] = parseStringAndCreateRule(rules[i]);
		}

		MergeSort.sort(rule);
		// In fact, Arrays.sort() IS a stable sort, so we can use it too.
		// Arrays.sort(rule);

		String[] namesOfRules = new String[rule.length];
		for (int i = 0; i < rule.length; i++) {
			namesOfRules[i] = rule[i].name;
		}
		return namesOfRules;
	}

	private Rule parseStringAndCreateRule(String rule) {
		StringTokenizer strTokenizer = new StringTokenizer(rule, ":");

		String name = strTokenizer.nextToken().trim();
		String[] conditions = strTokenizer.nextToken().trim().split(" ");

		return new Rule(name, conditions);
	}

}
