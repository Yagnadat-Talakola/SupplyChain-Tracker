## SupplyChain Tracker

#### A REST Application Programming Interface (API) that showcases rich business data on item, node, shipment and transit data of a simulated near-real-world supply chain network.

* Tools used:
    * PostgreSQL for persisting data. 
    * Java for application development. 
    * [Spring Boot](http://spring.io/projects/spring-boot) for its integrated support (Apache Tomcat web-server for instance.)
    * Gradle for dependencies and build management.
    * [IntelliJ IDEA](https://www.jetbrains.com/idea/) for its excellent IDE for Java applications.
 
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