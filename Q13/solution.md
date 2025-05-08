### QUESTION

Fetch the following details for orders completed in August of 2023.
    PRODUCT_ID
    PRODUCT_TYPE_ID
    PRODUCT_STORE_ID 
    TOTAL_QUANTITY
    INTERNAL_NAME 
    FACILITY_ID
    EXTERNAL_ID 
    FACILITY_TYPE_ID 
    ORDER_HISTORY_ID 
    ORDER_ID
    ORDER_ITEM_SEQ_ID
    SHIP_GROUP_SEQ_ID


### SOLUTION:

```sql

SELECT
	p.PRODUCT_ID,
	p.PRODUCT_TYPE_ID,
	oh.PRODUCT_STORE_ID,
	oi.QUANTITY,
	p.INTERNAL_NAME,
	oisg.FACILITY_ID,
	oh.EXTERNAL_ID,
	f.FACILITY_TYPE_ID,
	oht.ORDER_HISTORY_ID,
	oh.ORDER_ID,
	oi.ORDER_ITEM_SEQ_ID,
	oisg.SHIP_GROUP_SEQ_ID 
FROM order_header oh
JOIN order_item oi ON oh.ORDER_ID = oi.ORDER_ID
JOIN order_item_ship_group_assoc oisga ON oi.ORDER_ID = oisga.ORDER_ID AND oi.ORDER_ITEM_SEQ_ID = oisga.ORDER_ITEM_SEQ_ID 
JOIN order_item_ship_group oisg ON oisga.ORDER_ID = oisg.ORDER_ID AND oisga.SHIP_GROUP_SEQ_ID = oisg.SHIP_GROUP_SEQ_ID 
JOIN order_history oht ON oi.ORDER_ID = oht.ORDER_ID AND oi.ORDER_ITEM_SEQ_ID = oht.ORDER_ITEM_SEQ_ID 
JOIN product p  ON oi.PRODUCT_ID = p.PRODUCT_ID 
JOIN facility f ON oisg.FACILITY_ID = f.FACILITY_ID
JOIN order_status os ON oh.ORDER_ID = os.ORDER_ID AND os.STATUS_ID = "ORDER_COMPLETED"
WHERE oh.status_id = "ORDER_COMPLETED" AND 
(os.STATUS_DATETIME BETWEEN '2023-08-01' AND '2023-08-31' );

```
![Alt text](image.png)
