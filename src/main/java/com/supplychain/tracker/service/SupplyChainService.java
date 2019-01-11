package com.supplychain.tracker.service;

import com.supplychain.tracker.dao.SupplyChainDAO;
import com.supplychain.tracker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class SupplyChainService {

    @Autowired
    private SupplyChainDAO supplyChainDAO;

    public ItemAttributesModel getItemData(int itemId) {
        return supplyChainDAO.getItemData(itemId);
    }

    public List<ItemAttributesModel> getAllItems() {
        return supplyChainDAO.getAllItems();
    }

    public List<ItemAttributesModel> getItemsByChannel(String channel) { return supplyChainDAO.getItemsByChannel(channel); }

    public List<ItemAttributesModel> getItemsByState(String state) { return supplyChainDAO.getItemsByState(state); }

    public List<NodeAttributesModel> getAllNodes() {
        return supplyChainDAO.getAllNodes();
    }

    public NodeAttributesModel getNodeData(int nodeId) { return supplyChainDAO.getNodeData(nodeId); }

    public List<NodeAttributesModel> getNodeByNodeType(String nodeType) { return supplyChainDAO.getNodeByNodeType(nodeType); }

    public List<ItemShipmentModel> getAllShipments() { return supplyChainDAO.getAllShipments(); }

    public ItemShipmentModel getShipmentData(int shipmentId) { return supplyChainDAO.getShipmentData(shipmentId); }

    public ItemShipmentModel getShipmentDataGivenItemId(int itemId) { return supplyChainDAO.getShipmentDataGivenItemId(itemId); }

    public List<ShipmentTransitModel> getAllTransits() { return supplyChainDAO.getAllTransits(); }

    public ShipmentTransitModel getTransitData(int transitId) { return supplyChainDAO.getTransitData(transitId); }

    public List<ShipmentTransitModel> getTransitDataGivenShipmentId(int shipmentId) { return supplyChainDAO.getTransitDataGivenShipmentId(shipmentId); }

    public List<ShipmentTransitModel> getTransitDataGivenItemId(int itemId) { return supplyChainDAO.getTransitDataGivenItemId(itemId); }

    //public List<Integer> getItemsInNode (int nodeId, LocalDateTime startTime, LocalDateTime endTime) { return supplyChainDAO.getItemsInNode(nodeId, startTime, endTime); }

    public Map<String, LocalDateTime> getShipmentIntervalData(int shipmentId) { return supplyChainDAO.getShipmentInterval(shipmentId); }

    public ShipmentTrackerModel getCurrentShipmentData(int itemId, LocalDateTime instance) { return supplyChainDAO.getShipmentStatus(itemId, instance); }


}
