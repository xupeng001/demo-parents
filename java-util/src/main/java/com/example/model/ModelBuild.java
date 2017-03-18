package com.example.model;

@SuppressWarnings("unused")
public class ModelBuild {

    public static void main(String[] args) {
        info info = null;
        for (int i = 0; i < 1000; i++) {
            info = new info();
        }
    }

    static class info {
        private static final int _1Mb = 1024 * 1024;

    }
}
