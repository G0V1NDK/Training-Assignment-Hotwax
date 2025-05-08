### Question
6. In the past month, which store has the highest number of one-day shipped orders?


### Solution

```sql

SELECT
    oh.PRODUCT_STORE_ID,
    COUNT(s.PRIMARY_ORDER_ID) AS shipped_order_count
FROM
    shipment s
JOIN
    shipment_status ss ON ss.SHIPMENT_ID = s.SHIPMENT_ID
JOIN
    order_header oh ON s.PRIMARY_ORDER_ID = oh.ORDER_ID
WHERE
    s.SHIPMENT_METHOD_TYPE_ID = 'NEXT_DAY'
    AND ss.STATUS_ID = 'SHIPMENT_SHIPPED'
    AND ss.STATUS_DATE >= CURDATE() - INTERVAL 1 MONTH
GROUP BY
    oh.PRODUCT_STORE_ID;


--------OR ----------

SELECT 
    COUNT(DISTINCT oh.ORDER_ID) AS SHIPPED_ORDERS,
    oh.PRODUCT_STORE_ID
FROM
    order_header oh
        JOIN
    order_Item oi ON oi.order_id = oh.order_id
        JOIN
    order_item_ship_group oisg ON oisg.ORDER_ID = oi.ORDER_ID
        AND oisg.SHIP_GROUP_SEQ_ID = oi.SHIP_GROUP_SEQ_ID
        JOIN
    shipment s ON s.PRIMARY_ORDER_ID = oisg.order_id
        AND s.PRIMARY_SHIP_GROUP_SEQ_ID = oisg.ship_group_seq_id
        JOIN
    shipment_status ss ON ss.SHIPMENT_ID = s.shipment_id
        AND ss.STATUS_ID = 'SHIPMENT_SHIPPED'
WHERE
    ss.STATUS_DATE > DATE_SUB(CURDATE(), INTERVAL 1 MONTH)
        AND s.STATUS_ID = 'SHIPMENT_SHIPPED'
        AND (oisg.SHIPMENT_METHOD_TYPE_ID = 'SAME_DAY'
        OR oisg.SHIPMENT_METHOD_TYPE_ID = 'NEXT_DAY')
GROUP BY oh.PRODUCT_STORE_ID
ORDER BY SHIPPED_ORDERS DESC
LIMIT 1;

```

![Alt text](image-2.png)

![Alt text](image-1.png)