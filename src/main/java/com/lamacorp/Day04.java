package com.lamacorp;

import java.util.Arrays;
import java.util.List;

public class Day04 extends Day {
    @Override
    protected void part1() {
        String[] lines = input.split("\n");
        int code = Arrays.stream(lines).map(this::toTicketValue).reduce(Integer::sum).orElse(0);
        System.out.println("Part 1 : " + code);
    }

    private int toTicketValue(String s) {
        String numberWithoutTitle = s.split(":")[1];
        String winningNumbersRaw = numberWithoutTitle.split("\\|")[0];
        String currentNumbersRaw = numberWithoutTitle.split("\\|")[1];
        List<Integer> winningNumbers = Arrays.stream(winningNumbersRaw.trim().split(" "))
                .map(Integer::parseInt)
                .toList();
        List<Integer> winnedNumbers = Arrays.stream(currentNumbersRaw.trim().split(" "))
                .map(Integer::parseInt)
                .filter(winningNumbers::contains)
                .toList();
        return calculateTicketValue(winnedNumbers);
    }

    private int calculateTicketValue(List<Integer> numbers) {
        if (numbers.size() == 0) {
            return 0;
        }
        return (int) Math.pow(2, numbers.size() - 1);
    }

    @Override
    protected void part2() {

    }

    @Override
    protected String getNumber() {
        return "04";
    }

    private final String input = """
            Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
            Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
            Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
            Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
            Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
            Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
            """;
}
