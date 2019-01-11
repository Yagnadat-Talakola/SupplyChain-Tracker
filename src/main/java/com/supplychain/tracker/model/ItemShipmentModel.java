package com.supplychain.tracker.model;

import com.google.gson.annotations.SerializedName;

public class ItemShipmentModel {

    @SerializedName("shipment_id")
    private int shipmentId;

    @SerializedName("item_id")
    private int itemId;

    @SerializedName("item_quantity")
    private int itemQuantity;


    public int getShipmentId() {
        return shipmentId;
    }

    public int getItemId() {
        return itemId;
    }

    public ItemShipmentModel(int shipmentId, int itemId, int itemQuantity) {
        this.shipmentId = shipmentId;
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String toString() {
        return "ItemShipmentModel{" +
                "shipmentId=" + shipmentId +
                ", itemId=" + itemId +
                ", itemQuantity=" + itemQuantity +
                '}';
    }
}
