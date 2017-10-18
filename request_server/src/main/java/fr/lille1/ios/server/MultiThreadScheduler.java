package fr.lille1.ios.server;

/** Runs tasks by creating one new thread per task */
public class MultiThreadScheduler  {
  public void schedule (Runnable task) { new Thread(task).start(); }
}
