package comanche.naked;

/** Runs tasks as soon as they arrive, in the same thread. */
public class SequentialScheduler  {
  public void schedule (Runnable task) { task.run(); }
}
