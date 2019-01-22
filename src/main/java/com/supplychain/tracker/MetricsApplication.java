//package com.supplychain.tracker;
//
//import com.codahale.metrics.*;
//import com.codahale.metrics.graphite.Graphite;
//import com.codahale.metrics.graphite.GraphiteReporter;
//import com.sun.swing.internal.plaf.metal.resources.metal;
//
//import java.net.InetSocketAddress;
//import java.util.concurrent.TimeUnit;
//
//public class MetricsApplication {
//
//    private static final MetricRegistry metrics = SharedMetricRegistries.getOrCreate("TEST");
//
//    public static void main(String[] args) throws Exception {
//        startReport();
//        Meter requests = metrics.meter("requests");
//        Counter c = metrics.counter("testcounter");
//
//        Gauge g = metrics.gauge("timeUntilDestination", () -> )
//
//        int i = 100000000;
//        while(i > 0) {
//            requests.mark();
//            c.inc();
//            i--;
//        }
//
//        Thread.sleep(5 * 10000);
//
//
//    }
//
//    private static void startReport() {
//        final Graphite graphite = new Graphite(new InetSocketAddress("localhost", 2003));
//        final GraphiteReporter reporter = GraphiteReporter.forRegistry(metrics)
//                .convertRatesTo(TimeUnit.SECONDS)
//                .convertDurationsTo(TimeUnit.MILLISECONDS)
//                .filter(MetricFilter.ALL)
//                .build(graphite);
//        reporter.start(1, TimeUnit.SECONDS);
//    }
//}
