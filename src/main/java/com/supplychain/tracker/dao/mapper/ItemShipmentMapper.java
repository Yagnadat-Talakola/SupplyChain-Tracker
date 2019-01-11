package com.supplychain.tracker.dao.mapper;

import com.supplychain.tracker.model.ItemShipmentModel;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ItemShipmentMapper implements RowMapper<ItemShipmentModel> {

    @Override
    public ItemShipmentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        int shipmentId = rs.getInt("shipment_id");
        int itemId = rs.getInt("item_id");
        int itemQuantity = rs.getInt("item_quantity");

        return new ItemShipmentModel(shipmentId, itemId, itemQuantity);
    }
}
