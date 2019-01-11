package com.supplychain.tracker.dao.mapper;

import com.supplychain.tracker.model.ItemAttributesModel;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ItemAttributesMapper implements RowMapper<ItemAttributesModel> {

    @Override
    public ItemAttributesModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        int itemId = rs.getInt("item_id");
        String itemState = rs.getString("item_state");
        String itemName = rs.getString("item_name");
        String itemDescription = rs.getString("item_description");
        String channelAvailability = rs.getString("channel_availability");
        String itemDimensions = rs.getString("item_dimensions");
        float itemWeight = rs.getFloat("item_weight");
        int unitsPerCasePack = rs.getInt("units_per_case_pack");
        String casePackDimensions = rs.getString("case_pack_dimensions");
        String casePackUnitsOfMeasure = rs.getString("case_pack_units_of_measure");
        boolean dropShippingEnabled = rs.getBoolean("drop_shipping_enabled");
        boolean isBackorderEligible= rs.getBoolean("is_backorder_eligible");
        int maxBackorderQuantity = rs.getInt("max_back_order_quantity");
        boolean vendorChargebacksAllowed = rs.getBoolean("vendor_chargebacks_allowed");
        boolean isItemPerishable = rs.getBoolean("is_item_perishable");
        boolean isItemHazardous = rs.getBoolean("is_item_hazardous");
        boolean isItemFlammable = rs.getBoolean("is_item_flammable");
        boolean isRFIDEnabled = rs.getBoolean("is_RFID_enabled");
        int itemShelfLife = rs.getInt("item_shelf_life");

        return new ItemAttributesModel(itemId, itemState, itemName, itemDescription, channelAvailability, itemDimensions, itemWeight,
                                  unitsPerCasePack, casePackDimensions, casePackUnitsOfMeasure, dropShippingEnabled, isBackorderEligible,
                                  maxBackorderQuantity, vendorChargebacksAllowed, isItemPerishable, isItemHazardous, isItemFlammable,
                                  isRFIDEnabled, itemShelfLife);

    }
}
