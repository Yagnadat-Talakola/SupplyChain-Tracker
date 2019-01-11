package com.supplychain.tracker.model;

import com.google.gson.annotations.SerializedName;

public class NodeAttributesModel {

    @SerializedName("node_id")
    private int nodeId;

    @SerializedName("node_type")
    private String nodeType;

    @SerializedName("node_location")
    private String nodeLocation;

    @SerializedName("node_lead_time_in_hours")
    private float nodeLeadTimeInHours;

    @SerializedName("node_max_inbound_capacity")
    private float nodeMaxInboundCapacity;

    @SerializedName("node_max_outbound_capacity")
    private float nodeMaxOutboundCapacity;

    @SerializedName("can_handle_perishable_items")
    private boolean canHandlePerishableItems;

    @SerializedName("can_handle_hazardous_items")
    private boolean canHandleHazardounsItems;

    @SerializedName("can_handle_flammable_items")
    private boolean canHandleFlammableItems;

    public NodeAttributesModel(int nodeId, String nodeType, String nodeLocation, float nodeLeadTimeInHours, float nodeMaxInboundCapacity, float nodeMaxOutboundCapacity, boolean canHandlePerishableItems, boolean canHandleHazardounsItems, boolean canHandleFlammableItems) {
        this.nodeId = nodeId;
        this.nodeType = nodeType;
        this.nodeLocation = nodeLocation;
        this.nodeLeadTimeInHours = nodeLeadTimeInHours;
        this.nodeMaxInboundCapacity= nodeMaxInboundCapacity;
        this.nodeMaxOutboundCapacity = nodeMaxOutboundCapacity;
        this.canHandlePerishableItems = canHandlePerishableItems;
        this.canHandleHazardounsItems = canHandleHazardounsItems;
        this.canHandleFlammableItems = canHandleFlammableItems;
    }

    @Override
    public String toString() {
        return "NodeAttributesModel{" +
                "nodeId=" + nodeId +
                ", nodeType='" + nodeType + '\'' +
                ", nodeLocation='" + nodeLocation + '\'' +
                ", nodeLeadTime=" + nodeLeadTimeInHours +
                ", nodeMaxInboundCapacity=" + nodeMaxInboundCapacity+
                ", nodeMaxOutboundCapacity=" + nodeMaxOutboundCapacity +
                ", canHandlePerishableItems=" + canHandlePerishableItems +
                ", canHandleHazardounsItems=" + canHandleHazardounsItems +
                ", canHandleFlammableItems=" + canHandleFlammableItems +
                '}';
    }
}
