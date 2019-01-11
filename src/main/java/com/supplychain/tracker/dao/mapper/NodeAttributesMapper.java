package com.supplychain.tracker.dao.mapper;

import com.supplychain.tracker.model.NodeAttributesModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NodeAttributesMapper implements RowMapper<NodeAttributesModel> {

    @Override
    public NodeAttributesModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        int nodeId = rs.getInt("node_id");
        String itemType = rs.getString("node_type");
        String nodeLocation = rs.getString("node_location");
        float nodeLeadTimeInHours = rs.getFloat("node_lead_time_in_hours");
        float maxInboundCapacity = rs.getFloat("node_max_inbound_capacity");
        float maxOutboundCapacity = rs.getFloat("node_max_outbound_capacity");
        boolean canHandlePerishableItems = rs.getBoolean("can_handle_perishable_items");
        boolean canHandleHazardousItems = rs.getBoolean("can_handle_hazardous_items");
        boolean canHandleFlammableItems = rs.getBoolean("can_handle_flammable_items");

        return new NodeAttributesModel(nodeId, itemType, nodeLocation, nodeLeadTimeInHours, maxInboundCapacity, maxOutboundCapacity,
                                  canHandlePerishableItems, canHandleHazardousItems, canHandleFlammableItems);
    }
}
