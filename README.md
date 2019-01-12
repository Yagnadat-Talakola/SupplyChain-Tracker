## SupplyChain Tracker

#### A REST Application Programming Interface (API) that showcases rich business data on item, node, shipment and transit data of a simulated near-real-world supply chain network.

* Tools used:
    * PostgreSQL for persisting data. 
    * Java for application development. 
    * [Spring Boot](http://spring.io/projects/spring-boot) for its integrated support (Apache Tomcat web-server for instance.)
    * Gradle for dependencies and build management.
    * [IntelliJ IDEA](https://www.jetbrains.com/idea/) for its excellent IDE for Java applications.

* Database Tables:
    1. item_table:
        * item_id
        * item_state
        * item_name
        * item_description
        * channel_availability
        * item_dimensions
        * item_weight
        * units_per_case_pack
        * case_pack_dimensions
        * case_pack_units_of_measure
        * drop_shipping_enabled
        * is_backorder_eligible
        * max_backorder_quantity
        * vendor_charge_backs_allowed
        * is_item_perishable
        * is_item_hazardous
        * is_item_flammable
        * is_RFID_enabled
        * item_shelf_life
    
    2. node_table:
        * node_id
        * node_type
        * node_location
        * node_lead_time_in_hours
        * node_max_inbound_capacity
        * node_max_outbound_capacity
        * can_handle_perishable_items
        * can_handle_hazardous_items
        * can_handle_flammable_items
        
    3. item_shipment_table:
        * shipment_id
        * item_id
        * item_quantity
        
    4. shipment_transit_table:
        * transit_id
        * shipment_id
        * transit_type
        * outbound_node_id
        * inbound_node_id
        * transit_start_time
        * transit_end_time
        
* Request-Response:
    * /supply_chain_tracker/items?item_id=(int-value) 
        * get item data by its item_id.
    * /supply_chain_tracker/items/channel?channel=(string-value)
        * get items by channel_type.
    * /supply_chain_tracker/items/state?state=(string-value)
        * get items by item_state.
    * /supply_chain_tracker/items/allItems
        * get all items data.
    * /supply_chain_tracker/nodes?node_id=(int-value)
        * get node data by node_id.
    * /supply_chain_tracker/nodes/allNodes
        * get all nodes data.
    * /supply_chain_tracker/nodes/nodeType?node_type=(string-value)
        * get nodes by node_type.
    * /supply_chain_tracker/shipments?shipment_id=(int-value)
        * get shipment data given shipment_id.
    * /supply_chain_tracker/shipments/allShipments
        * get all shipments data.
    * /supply_chain_tracker/shipments/itemId?item_id=(int-value)
        * get shipment data given item_id.
    * /supply_chain_tracker/transits?transit_id=(int-value)
        * get transit data given transit_id.
    * /supply_chain_tracker/transits/allTransits
        * get all transit data.
    * /supply_chain_tracker/transits/shipmentId?shipmentId=(int-value)
        * get transit data given shipment_id.
    * /supply_chain_tracker/transits/itemId?item_id=(int-value)
        * get transit data given item_id.
    * /supply_chain_tracker/shipments/shipmentInterval?shipment_id=(int-value)
        * get shipment start time, and shipment end time.
    * /supply_chain_tracker/shipments/itemToTrack?item_id=(int-value)&time_instance=(LocalDateTime)
        * get shipment data currently transporting given item.
* Major components of the application:
    * `SupplyChainController` class annotated with `@RestController` maps `HTTP` requests with appropriate `JSON` responses (annotated with `@ResponseBody`)
    * `SupplyChainService` class annotated with `@Service` is the intermediary that interfaces with `SupplyChainController` to fetch data as requested by the user's `@RequestParams` data.
    * `SupplyChainDAO` class annotated with `@Component` contains the business logic that queries database using the `@RequestParam` data supplied by the `SupplyChainService`
    *  `application.yml` holds all the configuration that Spring reads from.
* Few highlights:
    * Modular design enabled by separation of business logic from handling request-response through an intermediary service layer.