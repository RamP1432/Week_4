package com.tit.setinterface;

import java.util.*;

// Class representing an Insurance Policy
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    // Constructor to initialize policy attributes
    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getter methods
    public String getPolicyNumber() { return policyNumber; }
    public Date getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }

    // Overriding equals and hashCode to ensure unique policy numbers
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // Comparing policies based on the expiry date for TreeSet
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    // String representation of a Policy object
    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

// Class for managing insurance policies
public class InsuranceManagementSystem {
    // Different types of sets for policy storage
    private Set<Policy> hashSetPolicies = new HashSet<>(); // Fast lookups
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>(); // Maintains insertion order
    private Set<Policy> treeSetPolicies = new TreeSet<>(); // Sorted by expiry date

    // Method to add policy to all sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Retrieve all stored policies
    public Set<Policy> getAllPolicies() {
        return new HashSet<>(hashSetPolicies);
    }

    // Retrieve policies expiring within the next 30 days
    public Set<Policy> getPoliciesExpiringSoon() {
        Set<Policy> expiringSoon = new TreeSet<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date threshold = calendar.getTime();
        for (Policy policy : treeSetPolicies) {
            if (policy.getExpiryDate().before(threshold)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    // Retrieve policies based on a coverage type
    public Set<Policy> getPoliciesByCoverageType(String coverageType) {
        Set<Policy> filteredPolicies = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    // Identify duplicate policies based on policy number
    public Set<Policy> getDuplicatePolicies() {
        Set<String> policyNumbers = new HashSet<>();
        Set<Policy> duplicates = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        // Creating an instance of a policy management system
        InsuranceManagementSystem manager = new InsuranceManagementSystem();

        // Adding sample policies
        manager.addPolicy(new Policy("P123", "Raj Ranjan", new Date(System.currentTimeMillis() + 10_000_000), "Health", 500.0));
        manager.addPolicy(new Policy("P124", "Jay Singh", new Date(System.currentTimeMillis() + 2_500_000), "Auto", 700.0));
        manager.addPolicy(new Policy("P125", "Mike Singh", new Date(System.currentTimeMillis() + 5_000_000), "Home", 900.0));

        // Displaying various policy sets and results
        System.out.println("All Policies: " + manager.getAllPolicies());
        System.out.println("Policies Expiring Soon: " + manager.getPoliciesExpiringSoon());
        System.out.println("Auto Policies: " + manager.getPoliciesByCoverageType("Auto"));
        System.out.println("Duplicate Policies: " + manager.getDuplicatePolicies());
    }
}

