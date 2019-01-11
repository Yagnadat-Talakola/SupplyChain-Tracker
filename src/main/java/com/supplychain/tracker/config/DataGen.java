package com.supplychain.tracker.config;

import com.supplychain.tracker.model.ChannelAvailability;
import com.supplychain.tracker.model.ItemState;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class DataGen {

    //INSERT INTO public.item_table
    //(item_id, item_state, item_name, item_description, channel_availability, item_dimensions, item_weight, units_per_case_pack, case_pack_dimensions, case_pack_units_of_measure, drop_shipping_enabled, is_backorder_eligible, max_back_order_quantity, vendor_chargebacks_allowed, is_item_perishable, is_item_hazardous, is_item_flammable, is_rfid_enabled, item_shelf_life)
    //VALUES(987654321, 'initialized', 'PS-4', 'playing console', 'store', '10*20*5', 12.5, 10, '50*20*50', 'inch', true, true, 6, false, false, false, false, true, 2);

    public static void main(String args[]) {

        try (PrintStream out = new PrintStream(new FileOutputStream("item_data.txt"))) {

            for(int i = 0; i < 1000; i++) {
            List<String> rows = new ArrayList<>();

            Random rand = new Random();
            int itemId = rand.nextInt(1000000000);
            rows.add(String.valueOf(itemId));

            List<ItemState> itemStates = Arrays.asList(ItemState.values());
            Collections.shuffle(itemStates);
            String itemState = itemStates.stream().findFirst().get().name();
            rows.add(itemState);

            List<String> itemName = Arrays.asList("BUTTER TOFFEE EVERYTHING GIFT BASKET",
                    "CANDY CANES FOR BREAKFAST",
                    "M&M POPCORN BUCKET",
                    "LIGHT LIFE VEGGIE PROTEIN",
                    "ORGANIC BANANAS",
                    "ORGANIC BLUEBERRIES",
                    "ORGANIC RASPBERRIES",
                    "BELL PEPPERS", "GREEN SEEDLESS GRAPES",
                    "SWEET PEPPERS",
                    "HONEY CRISP APPLES",
                    "GALA APPLES",
                    "FIJI APPLES", "PINK LADY APPLE",
                    "MIGHTY KIWIS", "OCEAN SPRAY FRESH CRANBERRIES",
                    "CHERIOS HONEY NUT BREAKFAST CEREAL", "CINNAMON TOAST CRUNCH BREAKFAST CEREAL", "QUAKER OATS",
                    "NATURE VALLEY GRANOLA BAR", "BELVITA BLUEBERRY BREAKFAST BISCUITS", "SIMPLY BALANCED ALMOND BUTTER", "MARKET PANTRY PEANUT OIL");
            Collections.shuffle(itemName);
            String itemNames = itemName.stream().findFirst().get() + " " + rand.nextInt(25) * 2 + " pack";
            rows.add(itemNames);

            rows.add("food");


            List<ChannelAvailability> channelAvail = Arrays.asList(ChannelAvailability.values());
            Collections.shuffle(channelAvail);
            String channelAvailString = channelAvail.stream().findFirst().get().name();
            rows.add(channelAvailString);

            rows.add("4 x 5 x 9");

            rows.add("13.0");
            rows.add("100");
            rows.add("15 x 18 x 30");

            rows.add("inch");
            rows.add("true");

            rows.add("true");
            rows.add("4");
            rows.add("false");
            rows.add("true");
            rows.add("false");
            rows.add("false");
            rows.add("true");
            rows.add("5");

            String row = rows.stream().reduce((t, u) -> t + "," + u).get();

            System.out.println(row);

                out.println(row);

        }

        } catch (Exception e) {

        }
    }




}
