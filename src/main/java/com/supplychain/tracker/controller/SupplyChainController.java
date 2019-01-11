package com.supplychain.tracker.controller;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.supplychain.tracker.model.*;
import com.supplychain.tracker.service.SupplyChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/supply_chain_tracker")
public class SupplyChainController {

    @Autowired
    private Gson gson;
    @Autowired
    private SupplyChainService supplyChainService;

    // get item by item_id
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    @ResponseBody
    public String getItemByItemId(@RequestParam(value = "item_id") int id) {
        ItemAttributesModel item = supplyChainService.getItemData(id);
        return gson.toJson(item, ItemAttributesModel.class);
    }

    // get all items
    @RequestMapping(value = "/items/allItems", method = RequestMethod.GET)
    @ResponseBody
    public String getAllItems() {
        List<ItemAttributesModel> items = supplyChainService.getAllItems();
        return gson.toJson(items, new TypeToken<List<ItemAttributesModel>>() {
        }.getType());
    }

    // get node by node_id
    @RequestMapping(value = "/nodes", method = RequestMethod.GET)
    @ResponseBody
    public String getNodeByNodeId(@RequestParam(value = "node_id") int id) {
        NodeAttributesModel node = supplyChainService.getNodeData(id);
        return gson.toJson(node, NodeAttributesModel.class);
    }

    // get all nodes.
    @RequestMapping(value = "/nodes/allNodes", method = RequestMethod.GET)
    @ResponseBody
    public String getAllNodes() {
        List<NodeAttributesModel> nodes = supplyChainService.getAllNodes();
        return gson.toJson(nodes, new TypeToken<List<NodeAttributesModel>>() {
        }.getType());
    }

    // get shipment data from shipment_id.
    @RequestMapping(value = "/shipments", method = RequestMethod.GET)
    @ResponseBody
    public String getShipmenDatatByShipmentId(@RequestParam(value = "shipment_id") int shipmentId) {
        ItemShipmentModel shipmentData = supplyChainService.getShipmentData(shipmentId);
        return gson.toJson(shipmentData, ItemShipmentModel.class);
    }

    // get all shipments.
    @RequestMapping(value = "/shipments/allShipments", method = RequestMethod.GET)
    @ResponseBody
    public String getAllShipments() {
        List<ItemShipmentModel> shipmentData = supplyChainService.getAllShipments();
        return gson.toJson(shipmentData, new TypeToken<List<ItemShipmentModel>>() {
        }.getType());
    }

    // get shipment data given item_id.
    @RequestMapping(value = "/shipments/itemId", method = RequestMethod.GET)
    @ResponseBody
    public String getShipmentDataByItemId(@RequestParam(value = "item_id") int itemId) {
        ItemShipmentModel shipmentData = supplyChainService.getShipmentDataGivenItemId(itemId);
        return gson.toJson(shipmentData, ItemShipmentModel.class);
    }

    // get all transits
    @RequestMapping(value = "/transits/allTransits", method = RequestMethod.GET)
    @ResponseBody
    public String getAllTransits() {
        List<ShipmentTransitModel> transitData = supplyChainService.getAllTransits();
        return gson.toJson(transitData, new TypeToken<List<ShipmentTransitModel>>() {
        }.getType());
    }

    // get transit data by transit_id
    @RequestMapping(value = "/transits", method = RequestMethod.GET)
    @ResponseBody
    public String getTransitDataByTransitId(@RequestParam(value = "transit_id") int transitId) {
        ShipmentTransitModel transitData = supplyChainService.getTransitData(transitId);
        return gson.toJson(transitData, ShipmentTransitModel.class);
    }

    // get transit data given shipment_id
    @RequestMapping(value = "/transits/shipmentId", method = RequestMethod.GET)
    @ResponseBody
    public String getTransitDataByShipmentId(@RequestParam(value = "shipment_id") int shipmentId) {
        List<ShipmentTransitModel> transitData = supplyChainService.getTransitDataGivenShipmentId(shipmentId);
        return gson.toJson(transitData, new TypeToken<List<ShipmentTransitModel>>() {
        }.getType());
    }

    // get transit data given item_id
    @RequestMapping(value = "/transits/itemId", method = RequestMethod.GET)
    @ResponseBody
    public String getTransitDataByItemId(@RequestParam(value = "item_id") int itemId) {
        List<ShipmentTransitModel> transitData = supplyChainService.getTransitDataGivenItemId(itemId);
        return gson.toJson(transitData, new TypeToken<List<ShipmentTransitModel>>() {
        }.getType());
    }

    /**
     * given shipment_id. Return shipment_start_time and shipment_end_time.
     *
     * @param: shipment_id.
     * @return: Map<String ,   LocalDateTime> "shipment_start_time": {LocalDateTime}, "shipment_end_time": {LocalDateTime}
     */

    @RequestMapping(value = "/shipments/shipmentInterval", method = RequestMethod.GET)
    @ResponseBody
    public String getShipmentInterval(@RequestParam( value = "shipment_id") int shipmentId) {
        Map<String, LocalDateTime> shipmentIntervalData = supplyChainService.getShipmentIntervalData(shipmentId);
        return gson.toJson(shipmentIntervalData, new TypeToken<Map<String, ShipmentTransitModel>>() {
        }.getType());
    }

    /**
     * Given item_id and instance of LocalDatetime-
     * return the corresponding shipment_id if currently transporting this item. If no shipments found, return "currently no shipments carrying this item."
     *
     * @param: int item_id, LocalDateTime localDateTime
     * @return: {shipment_id: /shipment_id/, item_id: item_id, outbound_node_id: 1234, inbound_node_id: 4321, time_until_destination: 1 hour},
     */

    @CrossOrigin(origins = "http://localhost:8082")
    @RequestMapping(value = "/shipments/itemToTrack", method = RequestMethod.GET)
    @ResponseBody
    public String getCurrentShipmentData(@RequestParam(value = "item_id") int itemId, @RequestParam(value = "time_instance") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timeInstance) {
        ShipmentTrackerModel currentShipmentData = supplyChainService.getCurrentShipmentData(itemId, timeInstance);
        return gson.toJson(currentShipmentData, ShipmentTrackerModel.class);
    }

}

//localhost:8080/supply_chain_tracker/shipments/itemToTrack/910504800/timeInstance/2018-03-23 14:43:18