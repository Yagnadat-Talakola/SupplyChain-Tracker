package com.supplychain.tracker.model;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class TransitDataGenerator {

    private static List<Integer> nodeList = Arrays.asList(1001, 3001,4001, 9001);
    private static Map<Integer, Integer> outboundInboundPairs = new HashMap<>();

    public static void main(String[] args) throws Exception{

        try (PrintStream out = new PrintStream(new FileOutputStream("transit_data.txt"))) {

            // TODO: generate all shipping_ids into an Array List and extract one at a time.
            long shipping_id;
            File file = new File("/home/yagna/IdeaProjects/SupplyChainTracker/shipment.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {
                shipping_id = Long.parseLong(st);

                Random rand = new Random();
                int days = rand.nextInt(365);

                LocalDateTime seedDate = LocalDateTime.now().minusDays(days);
                // generate a loop of three iterations for one shipping_id.
                for (int iter = 1; iter < 4; iter++) {

                    List<String> rows = new ArrayList<>();


                    int transitId = rand.nextInt(10000000);

                    rows.add(String.valueOf(transitId));
                    rows.add(String.valueOf(shipping_id));


                    if(iter == 1) {
                        rows.add("AIR");
                        rows.add("1001,3001");
                    }

                    if(iter == 2) {
                        rows.add("RAIL");
                        rows.add("3001,4001");
                    }

                    if(iter== 3) {
                        rows.add("ROAD");
                        rows.add("4001,9001");
                    }

                    LocalDateTime startTime =  seedDate.plusDays(iter * 10);
                    LocalDateTime endTime = seedDate.plusDays(iter * 10 ).plusDays(iter + 6);

                    rows.add(java.sql.Timestamp.valueOf(startTime).toString());
                    rows.add(java.sql.Timestamp.valueOf(endTime).toString());

                    String row = rows.stream().reduce((t, u) -> t + "," + u).get();

                    System.out.println(row);

                    out.println(row);
                }

            }
        }

    }
}
