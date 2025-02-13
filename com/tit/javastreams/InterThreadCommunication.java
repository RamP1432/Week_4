package com.tit.javastreams;

import java.io.*;

// Thread responsible for writing data into the piped stream
class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from WriterThread!";
            // Writing message bytes into the PipedOutputStream
            pos.write(message.getBytes());
            pos.close(); // Closing the stream to indicate end of data
            System.out.println("WriterThread: Data written to pipe.");
        } catch (IOException e) {
            System.out.println("WriterThread: Error writing data.");
            e.printStackTrace();
        }
    }
}

// Thread responsible for reading data from the piped stream
class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(pis));
            // Reading the message sent by WriterThread
            String receivedMessage = reader.readLine();
            System.out.println("ReaderThread: Received - " + receivedMessage);
        } catch (IOException e) {
            System.out.println("ReaderThread: Error reading data.");
            System.out.println(e.getMessage());
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        try {
            // Creating piped streams for inter-thread communication
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Creating writer and reader threads
            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            // Starting both threads
            writer.start();
            reader.start();

            // Ensuring both threads complete execution before exiting
            writer.join();
            reader.join();
        } catch (IOException | InterruptedException e) {
            System.out.println("Main: Error in thread communication.");
            System.out.println(e.getMessage());        }
    }
}