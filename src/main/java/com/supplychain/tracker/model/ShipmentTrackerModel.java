package com.supplychain.tracker.model;

public class ShipmentTrackerModel {
    private int shipmentId;
    private transient int itemId;
    private int transitId;
    private int outboundNodeId;
    private int inboundNodeId;
    private long timeUntilDestinationInHours;
    private String statusMessage;

    public ShipmentTrackerModel(int shipmentId, int itemId, int transitId, int outboundNodeId, int inboundNodeId, long timeUntilDestination, String statusMessage) {
        this.shipmentId = shipmentId;
        this.itemId = itemId;
        this.transitId = transitId;
        this.outboundNodeId = outboundNodeId;
        this.inboundNodeId = inboundNodeId;
        this.timeUntilDestinationInHours = timeUntilDestination;
        this.statusMessage = statusMessage;
    }

    public ShipmentTrackerModel(int shipmentId, int transitId, int outboundNodeId, int inboundNodeId, long timeUntilDestinationInHours, String statusMessage) {
        this.shipmentId = shipmentId;
        this.transitId = transitId;
        this.outboundNodeId = outboundNodeId;
        this.inboundNodeId = inboundNodeId;
        this.timeUntilDestinationInHours = timeUntilDestinationInHours;
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        return "ShipmentTrackerModel{" +
                "shipmentId=" + shipmentId +
                ", itemId=" + itemId +
                ", transitId=" + transitId +
                ", outboundNodeId=" + outboundNodeId +
                ", inboundNodeId=" + inboundNodeId +
                ", timeUntilDestination(in hours)=" + timeUntilDestinationInHours+
                '}';
    }
}
