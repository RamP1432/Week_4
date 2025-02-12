package com.tit.mapinterface;

import java.util.*;

class VotingSystem {
    private Map<String, Integer> voteCount = new HashMap<>(); // Store votes for each candidate
    private Map<String, Integer> voteOrder = new LinkedHashMap<>(); // Maintain vote order
    private TreeMap<String, Integer> sortedResults = new TreeMap<>(); // Display results in sorted order

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
        sortedResults.put(candidate, voteCount.get(candidate));
    }

    // Get vote count for a specific candidate
    public int getVotes(String candidate) {
        return voteCount.getOrDefault(candidate, 0);
    }

    // Display votes in the order they were cast
    public void displayVoteOrder() {
        System.out.println("Votes in Order of Casting:");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Display final results in sorted order
    public void displaySortedResults() {
        System.out.println("Final Sorted Results:");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }
}

public class VotingSystemManagement {
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        // Casting votes
        system.castVote("Arjun");
        system.castVote("Boby");
        system.castVote("Arya");
        system.castVote("Chanchal");
        system.castVote("Boby");
        system.castVote("Arjun");

        // Displaying votes in order of casting
        System.out.println();
        system.displayVoteOrder();

        // Displaying sorted results
        System.out.println();
        system.displaySortedResults();
    }
}

