package com.supplychain.tracker.dao;

import com.supplychain.tracker.dao.mapper.*;
import com.supplychain.tracker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class SupplyChainDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // get all items from the item_table
    public List<ItemAttributesModel> getAllItems() {
        String sql = "select * from item_table";
        List<ItemAttributesModel> itemAttributesList = jdbcTemplate.query(sql, new ItemAttributesMapper());

        System.out.println(itemAttributesList.toString());
        return itemAttributesList;
    }

    // get an item from item_table given item_id
    public ItemAttributesModel getItemData(int itemId) {
        String sql = "select * from item_table where item_id=" + itemId;

        List<ItemAttributesModel> itemAttributesList = jdbcTemplate.query(sql, new ItemAttributesMapper());

        if (itemAttributesList != null && !itemAttributesList.isEmpty())
            return itemAttributesList.get(0);
        else
            return null;
    }

    // get items that can be ordered online.(channel_availability='ONLINE')
    public List<ItemAttributesModel> getItemsByChannel(String channel) {

        String sql = "select * from item_table where channel_availability=" + channel.toUpperCase();
        List<ItemAttributesModel> itemAttributesModelList = jdbcTemplate.query(sql, new ItemAttributesMapper());
        return itemAttributesModelList;
    }

    // get items by item_state (PENDING_APPROVAL, HOLD, INITIALIZED, ACTIVE, INACTIVE, DISCONTINUED)
    public List<ItemAttributesModel> getItemsByState(String state) {

        String sql = "select * from item_table where item_state=" + state.toUpperCase();
        List<ItemAttributesModel> itemList = jdbcTemplate.query(sql, new ItemAttributesMapper());
        return itemList;

    }

    // get all nodes from the node_table
    public List<NodeAttributesModel> getAllNodes() {
        String sql = "select * from node_table";

        List<NodeAttributesModel> nodeAttributesList = jdbcTemplate.query(sql, new NodeAttributesMapper());
        System.out.println(nodeAttributesList.toString());

        return nodeAttributesList;
    }

    // get a node from the node_table given node_id
    public NodeAttributesModel getNodeData(int nodeId) {
        String sql = "select * from node_table where node_id=" + nodeId;

        List<NodeAttributesModel> nodeAttributesList = jdbcTemplate.query(sql, new NodeAttributesMapper());

        if (nodeAttributesList != null && !nodeAttributesList.isEmpty())
            return nodeAttributesList.get(0);
        else
            return null;
    }

    // get a node by node_type (food_dc, global_dc, regional_dc, forward_dc, store_1,2,3,4,5)
    public List<NodeAttributesModel> getNodeByNodeType(String nodeType) {
        String sql = "select * from node_table where node_type=" + nodeType;
        List<NodeAttributesModel> nodeList = jdbcTemplate.query(sql, new NodeAttributesMapper());
        return nodeList;
    }


    // get all shipments from the item_shipment table
    public List<ItemShipmentModel> getAllShipments() {
        String sql = "select * from item_shipment_table";
        List<ItemShipmentModel> shipmentList = jdbcTemplate.query(sql, new ItemShipmentMapper());
        return shipmentList;
    }

    // get shipment data from item_shipment_table given shipment_id
    public ItemShipmentModel getShipmentData(int shipmentId) {
        String sql = "select * from item_shipment_table where shipment_id=" + shipmentId;
        List<ItemShipmentModel> shipmentData = jdbcTemplate.query(sql, new ItemShipmentMapper());

        if (shipmentData != null && !shipmentData.isEmpty()) {
            return shipmentData.get(0);
        } else {
            return null;
        }
    }

    // get shipment data from the item_shipment_table given item_id
    public ItemShipmentModel getShipmentDataGivenItemId(int itemId) {
        String sql = "select * from item_shipment_table where item_id=" + itemId;
       List<ItemShipmentModel > shipmentData = jdbcTemplate.query(sql, new ItemShipmentMapper());

        if (shipmentData != null && !shipmentData.isEmpty()) {
            return shipmentData.get(0);
        } else {
            return null;
        }
    }

    // get all transit data from shipment_transit_table
    public List<ShipmentTransitModel> getAllTransits() {
        String sql = "select * from shipment_transit_table";
        return jdbcTemplate.query(sql, new ShipmentTransitMapper());
    }

    // get transit data from shipment_transit_table given transit_id
    public ShipmentTransitModel getTransitData(int transitId) {
        String sql = "select * from shipment_transit_table where transit_id=" + transitId;
        List<ShipmentTransitModel> transitData = jdbcTemplate.query(sql, new ShipmentTransitMapper());

        if (transitData != null && !transitData.isEmpty())
            return transitData.get(0);

        return null;

    }

    // get transit data from shipment_transit_table given shipment_id
    public List<ShipmentTransitModel> getTransitDataGivenShipmentId(int shipmentId) {
        String sql = "select * from shipment_transit_table where shipment_id=" + shipmentId;
        return jdbcTemplate.query(sql, new ShipmentTransitMapper());
    }

    // get transit data given item_id (from shipment_transit_table & item_shipment_table)
    public List<ShipmentTransitModel> getTransitDataGivenItemId(int itemId) {
        // get shipment data given itemId
        ItemShipmentModel shipmentData = getShipmentDataGivenItemId(itemId);

        // get transit data given shipmentId
        return getTransitDataGivenShipmentId(shipmentData.getShipmentId());
    }

    // get outbound_node_id, inbound_node_id, transit_start_time and transit_end_time given transit_id
    public ShipmentTransitModel getNodeDataGivenTransitId(int transitId) {
        String sql = "select * from shipment_transit_table where transitId=" + transitId;
        List<ShipmentTransitModel> transitData = jdbcTemplate.query(sql, new ShipmentTransitMapper());

        if (transitData != null && !transitData.isEmpty()) {
            return transitData.get(0);
        }
        return null;
    }

    // given a nodeId, startTime, endTime. Return list of items the node contained in that duration.
    // TODO: cannot use logical comparators to compare two LocalDateTime objects. Find another way.
    public List<Integer> getItemsInNode(int nodeId, LocalDateTime startTime, LocalDateTime endTime) {

        String sql = "(select shipment_id from shipment_transit_table where outbound_node_id=" + nodeId
                    + " and transit_start_time > " + java.sql.Timestamp.valueOf(startTime) +
                    " ) intersect (select shipment_id from " +
                    "shipment_transit_table where inbound_node_id = " + nodeId + " and transit_end_time < "
                    + java.sql.Timestamp.valueOf(endTime) + ")";

        List<ShipmentTransitModel> shipmentList = jdbcTemplate.query(sql, new ShipmentTransitMapper());
        return shipmentList
                .stream()
                .map(shipment -> shipment.getShipmentId())
                .map(shipmentId -> getShipmentData(shipmentId))
                .map(shipmentData -> shipmentData.getItemId())
                .collect(Collectors.toList());
    }

    // get shipmentStartTime, shipmentEndTime given shipmentId. Returns HashMap<String, LocalDateTime>
    public Map<String, LocalDateTime> getShipmentInterval(int shipmentId) {
        LocalDateTime shipmentStartTime;
        LocalDateTime shipmentEndTime;
        Map<String, LocalDateTime> shipmentTimeData = new HashMap<>();

        List<ShipmentTransitModel> transitList = getTransitDataGivenShipmentId(shipmentId);
        shipmentStartTime = transitList.stream()
                                        .map(transitDatPoint -> transitDatPoint.getTransitStartTime())
                                        .min((t1, t2) -> new LocalDateTimeComparator().compare(t1, t2))
                                        .get();

        shipmentEndTime = transitList.stream()
                                        .map(transitDataPoint -> transitDataPoint.getTransitEndTime())
                                        .max((t1, t2) -> new LocalDateTimeComparator().compare(t1, t2))
                                        .get();


        shipmentTimeData.put("shipmentEndTime", shipmentEndTime);
        shipmentTimeData.put("shipmentStartTime", shipmentStartTime);
        return shipmentTimeData;
    }

    // given item_id and LocalDateTime instance, return (if any) ongoing shipments in the instance.
    public ShipmentTrackerModel getShipmentStatus(int itemId, LocalDateTime instance) {
        int shipmentId = getShipmentDataGivenItemId(itemId).getShipmentId();

        String sql = "select * from shipment_transit_table where '" + java.sql.Timestamp.valueOf(instance) + "' > transit_start_time and '" + java.sql.Timestamp.valueOf(instance)
                        + "' < transit_end_time";

        List<ShipmentTransitModel> transitList = jdbcTemplate.query(sql, new ShipmentTransitMapper());

        if (transitList.isEmpty() || transitList == null) {
            String status = "no item in-transit during this time instance";
            return new ShipmentTrackerModel(shipmentId, itemId, 0, 0, 0, 0, status);
        } else {
            int transitId = transitList.get(0).getTransitId();
            int outboundNodeId = transitList.get(0).getOutboundNodeId();
            int inboundNodeId = transitList.get(0).getInboundNodeId();
            Duration timeUntilDestination = Duration.between(instance, transitList.get(0).getTransitEndTime());
            String status = "item in-transit found at the given time instance.";

            return new ShipmentTrackerModel(shipmentId, itemId, transitId, outboundNodeId, inboundNodeId, timeUntilDestination.toHours(), status);
        }
    }

}





