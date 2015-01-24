package com.yadavvi.topcoder.question268;

import java.util.StringTokenizer;

import com.yadavvi.sort.MergeSort;

public class Lottery {

	public String[] sortByOdds(String[] rules) {
		Rule[] rule = new Rule[rules.length];
		StringBuilder strBuilder = new StringBuilder();

		for (int i = 0; i < rules.length; i++) {
			rule[i] = parseStringAndCreateRule(rules[i]);

			// Print the Rules
			/*strBuilder.setLength(0);
			strBuilder.append(rule[i].name + ": ");
			for (String indRule : rule[i].conditions) {
				strBuilder.append(indRule + ", ");
			}
			strBuilder.delete(strBuilder.length() - 2, strBuilder.length() - 1);
			System.out.println(strBuilder.toString());*/
		}

		MergeSort.sort(rule);
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
