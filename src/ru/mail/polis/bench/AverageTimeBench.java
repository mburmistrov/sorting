package ru.mail.polis.bench;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import ru.mail.polis.sort.*;

/**
 * Created by Nechaev Mikhail
 * Since 20/11/16.
 */

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class AverageTimeBench {

    int[][] data;
    int[] curr;
    int index;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new int[10][];
        for (int i = 0; i < 10; i++) {
            data[i] = Helper.genSortedDESC(1000);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    /*@Benchmark
    public void measureBubbleSort() {
        BubbleSort.sort(curr);
    }

    @Benchmark
    public void measureInsertionSort() {
        InsertionSort.sort(curr);
    }

    @Benchmark
    public void measureImprovedInsertionSort() {
        ImprovedInsertionSort.sort(curr);
    }

    @Benchmark
    public void measureShellSort() {
        ShellSort.sort(curr);
    }*/

    @Benchmark
    public void measureMergeSort() {
        MergeSort.sort(curr);
    }

    @Benchmark
    public void measureMemoryOptimisedMergeSort() {
        MemoryOptimisedMergeSort.sort(curr);
    }

    @Benchmark
    public void measureQuickSort() {
        QuickSort.sort(curr);
    }

    @Benchmark
    public void measureRandomPivot3PartQuickSort() {
        MemoryOptimisedMergeSort.sort(curr);
    }

    @Benchmark
    public void measureBinaryQuickSort() {
        BinaryQuickSort.sort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AverageTimeBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
