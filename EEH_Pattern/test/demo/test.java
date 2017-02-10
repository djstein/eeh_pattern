package test.demo;

import java.util.EmptyStackException;
import java.util.concurrent.ExecutionException;

public class test_PATTERN {
    
    public static void main(String[] args) {
        try {
        	throw new EmptyStackException();
        	System.out.println("TEST");
        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

}