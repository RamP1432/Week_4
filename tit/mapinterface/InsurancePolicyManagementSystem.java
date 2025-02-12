package com.tit.mapinterface;

import java.time.LocalDate;
import java.util.*;

class InsurancePolicy {
    String policyNumber;
    String policyHolder;
    LocalDate expiryDate;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyHolder, LocalDate expiryDate, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyHolder +
                ", Expiry: " + expiryDate + ", Premium: Rs." + premiumAmount;
    }
}

class PolicyManagementSystem {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();  // Store policies by policy number
    private Map<String, InsurancePolicy> orderedPolicies = new LinkedHashMap<>();  // Maintain insertion order
    private TreeMap<LocalDate, List<InsurancePolicy>> expirySortedPolicies = new TreeMap<>(); // Sort by expiry date

    // Add a new policy
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);
        expirySortedPolicies.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    // Retrieve a policy by policy number
    public InsurancePolicy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<InsurancePolicy> getExpiringPolicies() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        for (Map.Entry<LocalDate, List<InsurancePolicy>> entry : expirySortedPolicies.subMap(today, true, limit, true).entrySet()) {
            expiringPolicies.addAll(entry.getValue());
        }
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<InsurancePolicy> getPoliciesByHolder(String policyHolder) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.policyHolder.equalsIgnoreCase(policyHolder)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<InsurancePolicy>>> iterator = expirySortedPolicies.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<InsurancePolicy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) { // Check if the expiry date is in the past
                for (InsurancePolicy policy : entry.getValue()) {
                    policyMap.remove(policy.policyNumber);
                    orderedPolicies.remove(policy.policyNumber);
                }
                iterator.remove();
            }
        }
    }

    // Display all policies in insertion order
    public void displayAllPolicies() {
        for (InsurancePolicy policy : orderedPolicies.values()) {
            System.out.println(policy);
        }
    }
}

public class InsurancePolicyManagementSystem {
    public static void main(String[] args) {
        PolicyManagementSystem system = new PolicyManagementSystem();

        // Adding some policies
        system.addPolicy(new InsurancePolicy("P1001", "Anish", LocalDate.now().plusDays(10), 500.0));
        system.addPolicy(new InsurancePolicy("P1002", "Bhavya", LocalDate.now().plusDays(35), 600.0));
        system.addPolicy(new InsurancePolicy("P1003", "Anuj", LocalDate.now().plusDays(20), 550.0));
        system.addPolicy(new InsurancePolicy("P1004", "Chanchal", LocalDate.now().minusDays(5), 700.0)); // Expired
        system.addPolicy(new InsurancePolicy("P1005", "Dravid", LocalDate.now().plusDays(5), 800.0));

        // Display all policies
        System.out.println("\nAll Policies:");
        system.displayAllPolicies();

        // Retrieve a policy
        System.out.println("\nRetrieving Policy P1003:");
        System.out.println(system.getPolicy("P1003"));

        // List policies expiring in the next 30 days
        System.out.println("\nPolicies Expiring in Next 30 Days:");
        for (InsurancePolicy policy : system.getExpiringPolicies()) {
            System.out.println(policy);
        }

        // List policies for a specific policyholder
        System.out.println("\nPolicies for Anish:");
        for (InsurancePolicy policy : system.getPoliciesByHolder("Anish")) {
            System.out.println(policy);
        }

        // Remove expired policies
        system.removeExpiredPolicies();
        System.out.println("\nAfter Removing Expired Policies:");
        system.displayAllPolicies();
    }
}

