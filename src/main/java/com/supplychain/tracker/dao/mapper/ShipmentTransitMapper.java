package com.supplychain.tracker.dao.mapper;

import com.supplychain.tracker.model.ShipmentTransitModel;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ShipmentTransitMapper implements RowMapper<ShipmentTransitModel> {

    @Override
    public ShipmentTransitModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        int transitId = rs.getInt("transit_id");
        int shipmentId = rs.getInt("shipment_id");
        String transitType = rs.getString("transit_type");
        int outboundNodeId = rs.getInt("outbound_node_id");
        int inboundNodeId = rs.getInt("inbound_node_id");
        LocalDateTime transitStartTime = rs.getTimestamp("transit_start_time").toLocalDateTime();
        LocalDateTime transitEndTime = rs.getTimestamp("transit_end_time").toLocalDateTime();

        return new ShipmentTransitModel(transitId, shipmentId, transitType, outboundNodeId, inboundNodeId, transitStartTime, transitEndTime);
    }
}
