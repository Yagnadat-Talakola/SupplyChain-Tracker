package com.supplychain.tracker.model;

import com.google.gson.annotations.SerializedName;
import java.time.LocalDateTime;

public class ShipmentTransitModel {

    @SerializedName("transit_id")
    private int transitId;

    @SerializedName("shipment_id")
    private int shipmentId;

    @SerializedName("transit_type")
    private String transitType;

    @SerializedName("outbound_node_id")
    private int outboundNodeId;

    @SerializedName("inbound_node_id")
    private int inboundNodeId;

    @SerializedName("transit_start_time")
    private LocalDateTime transitStartTime;

    @SerializedName("transit_end_time")
    private LocalDateTime transitEndTime;

    public int getShipmentId() {
        return shipmentId;
    }

    public int getTransitId() {
        return transitId;
    }

    public int getOutboundNodeId() {
        return outboundNodeId;
    }

    public int getInboundNodeId() {
        return inboundNodeId;
    }

    public LocalDateTime getTransitStartTime() {
        return transitStartTime;
    }

    public LocalDateTime getTransitEndTime() {
        return transitEndTime;
    }

    public ShipmentTransitModel(int transitId, int shipmentId, String transitType, int outboundNodeId, int inboundNodeId, LocalDateTime transitStartTime, LocalDateTime transitEndTime) {
        this.transitId = transitId;
        this.shipmentId = shipmentId;
        this.transitType = transitType;
        this.outboundNodeId = outboundNodeId;
        this.inboundNodeId = inboundNodeId;
        this.transitStartTime = transitStartTime;
        this.transitEndTime = transitEndTime;
    }

    @Override
    public String toString() {
        return "ShipmentTransitModel{" +
                "transitId=" + transitId +
                ", shipmentId=" + shipmentId +
                ", transitType='" + transitType + '\'' +
                ", outboundNodeId=" + outboundNodeId +
                ", inboundNodeId=" + inboundNodeId +
                ", transitStartTime=" + transitStartTime +
                ", transitEndTime=" + transitEndTime +
                '}';
    }
}
