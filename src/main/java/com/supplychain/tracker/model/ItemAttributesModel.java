package com.supplychain.tracker.model;

import com.google.gson.annotations.SerializedName;

public class ItemAttributesModel {

    @SerializedName("item_id")
    private int itemId;

    @SerializedName("item_state")
    private String itemState;

    public int getItemId() {
        return itemId;
    }

    public String getItemState() {
        return itemState;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getChannelAvailability() {
        return channelAvailability;
    }

    public String getItemDimensions() {
        return itemDimensions;
    }

    public float getItemWeight() {
        return itemWeight;
    }

    public int getUnitsPerCasePack() {
        return unitsPerCasePack;
    }

    public String getCasePackDimensions() {
        return casePackDimensions;
    }

    public String getCasePackUnitsOfMeasure() {
        return casePackUnitsOfMeasure;
    }

    public boolean isDropShippingEnabled() {
        return dropShippingEnabled;
    }

    public boolean isBackOrderEligible() {
        return isBackOrderEligible;
    }

    public int getMaxBackOrderQuantity() {
        return maxBackOrderQuantity;
    }

    public boolean isVendorChargebacksAllowed() {
        return vendorChargebacksAllowed;
    }

    public boolean isItemPerishable() {
        return isItemPerishable;
    }

    public boolean isItemHazardous() {
        return isItemHazardous;
    }

    public boolean isItemFlammable() {
        return isItemFlammable;
    }

    public boolean isRFIDEnabled() {
        return isRFIDEnabled;
    }

    public int getItemShelfLife() {
        return itemShelfLife;
    }

    @SerializedName("item_name")
    private String itemName;

    @SerializedName("item_description")
    private String itemDescription;

    @SerializedName("channel_availability")
    private String channelAvailability;

    @SerializedName("item_dimensions")
    private String itemDimensions;

    @SerializedName("item_weight")
    private float itemWeight;

    @SerializedName("units_per_case_pack")
    private int unitsPerCasePack;

    @SerializedName("case_pack_dimensions")
    private String casePackDimensions;

    @SerializedName("case_pack_units_of_measure")
    private String casePackUnitsOfMeasure;

    @SerializedName("drop_shipping_enabled")
    private boolean dropShippingEnabled;

    @SerializedName("is_backorder_eligible")
    private boolean isBackOrderEligible;

    @SerializedName("max_back_order_quantity")
    private int maxBackOrderQuantity;

    @SerializedName("vendor_chargebacks_allowed")
    private boolean vendorChargebacksAllowed;

    @SerializedName("is_item_perishable")
    private boolean isItemPerishable;

    @SerializedName("is_item_hazardous")
    private boolean isItemHazardous;

    @SerializedName("is_item_flammable")
    private boolean isItemFlammable;

    @SerializedName("is_RFID_enabled")
    private boolean isRFIDEnabled;

    @SerializedName("item_shelf_life")
    private int itemShelfLife;


    public ItemAttributesModel(int itemId, String itemState, String itemName, String itemDescription, String channelAvailability, String itemDimensions, float itemWeight, int unitsPerCasePack, String casePackDimensions, String casePackUnitsOfMeasure, boolean dropShippingEnabled, boolean isBackOrderEligible, int maxBackOrderQuantity, boolean vendorChargebacksAllowed, boolean isItemPerishable, boolean isItemHazardous, boolean isItemFlammable, boolean isRFIDEnabled, int itemShelfLife) {
        this.itemId = itemId;
        this.itemState = itemState;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.channelAvailability = channelAvailability;
        this.itemDimensions = itemDimensions;
        this.itemWeight = itemWeight;
        this.unitsPerCasePack = unitsPerCasePack;
        this.casePackDimensions = casePackDimensions;
        this.casePackUnitsOfMeasure = casePackUnitsOfMeasure;
        this.dropShippingEnabled = dropShippingEnabled;
        this.isBackOrderEligible = isBackOrderEligible;
        this.maxBackOrderQuantity = maxBackOrderQuantity;
        this.vendorChargebacksAllowed = vendorChargebacksAllowed;
        this.isItemPerishable = isItemPerishable;
        this.isItemHazardous = isItemHazardous;
        this.isItemFlammable = isItemFlammable;
        this.isRFIDEnabled = isRFIDEnabled;
        this.itemShelfLife = itemShelfLife;
    }

    @Override
    public String toString() {
        return "ItemAttributesModel{" +
                "itemId=" + itemId +
                ", itemState='" + itemState + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", channelAvailability='" + channelAvailability + '\'' +
                ", itemDimensions='" + itemDimensions + '\'' +
                ", itemWeight=" + itemWeight +
                ", unitsPerCasePack=" + unitsPerCasePack +
                ", casePackDimensions='" + casePackDimensions + '\'' +
                ", casePackUnitsOfMeasure='" + casePackUnitsOfMeasure + '\'' +
                ", dropShippingEnabled=" + dropShippingEnabled +
                ", isBackOrderEligible=" + isBackOrderEligible +
                ", maxBackOrderQuantity=" + maxBackOrderQuantity +
                ", vendorChargebacksAllowed=" + vendorChargebacksAllowed +
                ", isItemPerishable=" + isItemPerishable +
                ", isItemHazardous=" + isItemHazardous +
                ", isItemFlammable=" + isItemFlammable +
                ", isRFIDEnabled=" + isRFIDEnabled +
                ", itemShelfLife=" + itemShelfLife +
                '}';
    }
}
