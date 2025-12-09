package org.howard.edu.lsp.finale.question1;

import java.util.HashMap;
import java.util.Map;

public class PasswordGeneratorService {
    private static PasswordGeneratorService instance;
    private final Map<String, PasswordAlgorithm> algorithms = new HashMap<>();
    private PasswordAlgorithm currentAlgorithm;

    private PasswordGeneratorService() {
        algorithms.put("basic", new BasicPasswordAlgorithm());
        algorithms.put("enhanced", new EnhancedPasswordAlgorithm());
        algorithms.put("letters", new LettersPasswordAlgorithm());
    }

    public static synchronized PasswordGeneratorService getInstance() {
        if (instance == null) {
            instance = new PasswordGeneratorService();
        }
        return instance;
    }

    public void setAlgorithm(String name) {
        if (name == null) {
            currentAlgorithm = null;
            return;
        }
        PasswordAlgorithm algo = algorithms.get(name.toLowerCase());
        if (algo == null) {
            throw new IllegalArgumentException("Unknown algorithm: " + name);
        }
        currentAlgorithm = algo;
    }

    public String generatePassword(int length) {
        if (currentAlgorithm == null) {
            throw new IllegalStateException("Password algorithm has not been set.");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be positive.");
        }
        return currentAlgorithm.generate(length);
    }
}
