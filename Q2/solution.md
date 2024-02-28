### Question
Fetch the following columns for completed return items of SM_STORE for ecom return channel.
    RETURN_ID 
    ORDER_ID
    PRODUCT_STORE_ID 
    STATUS_DATETIME
    ORDER_NAME 
    FROM_PARTY_ID 
    RETURN_DATE 
    ENTRY_DATE
    RETURN_CHANNEL_ENUM_ID

### SOLUTION:
```sql

SELECT
	rh.RETURN_ID,
	oh.ORDER_ID,
	oh.PRODUCT_STORE_ID ,
	rs.STATUS_DATETIME,
	oh.ORDER_NAME ,
	rh.FROM_PARTY_ID, 
	rh.RETURN_DATE ,
	rh.ENTRY_DATE,
	rh.RETURN_CHANNEL_ENUM_ID
FROM order_header oh 
INNER JOIN order_item oi ON oh.order_id = oi.order_id
INNER JOIN return_item ri ON ri.ORDER_ID = oi.ORDER_ID AND ri.ORDER_ITEM_SEQ_ID = oi.ORDER_ITEM_SEQ_ID AND ri.STATUS_ID = 'RETURN_COMPLETED'
INNER JOIN return_header rh ON rh.RETURN_ID = ri.RETURN_ID AND rh.RETURN_CHANNEL_ENUM_ID = 'ECOM_RTN_CHANNEL'
INNER JOIN return_status rs ON ri.RETURN_ID = rs.RETURN_ID AND ri.RETURN_ITEM_SEQ_ID = rs.RETURN_ITEM_SEQ_ID AND rs.STATUS_ID = 'RETURN_COMPLETED'
WHERE oh.PRODUCT_STORE_ID = 'SM_STORE';
```

![Alt text](image.png)

![alt text](image-1.png)